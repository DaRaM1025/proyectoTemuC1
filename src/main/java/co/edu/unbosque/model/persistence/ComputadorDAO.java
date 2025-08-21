package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Computador;
import co.edu.unbosque.model.ComputadorDTO;

/**
 * Clase {@code ComputadorDAO} que implementa las operaciones CRUD para gestionar objetos de tipo
 * {@link Computador} y su persistencia en archivos de texto y binarios.
 * 
 * <p>Implementa la interfaz {@link OperacionDAO} para realizar las operaciones:
 * crear, eliminar, actualizar, buscar y mostrar computadores.</p>
 * 
 * <p>
 * Maneja la persistencia en dos formatos:
 * <ul>
 * <li>Archivo serializado: {@code computador.dat}</li>
 * <li>Archivo de texto (CSV): {@code computador.csv}</li>
 * </ul>
 * </p>
 */
public class ComputadorDAO implements OperacionDAO<ComputadorDTO, Computador> {

    /** Lista que almacena los objetos de tipo {@link Computador}. */
    private ArrayList<Computador> listaComputador;

    /** Nombre del archivo para la persistencia en formato binario. */
    private final String SERIAL_FILE_NAME = "computador.dat";

    /** Nombre del archivo para la persistencia en formato CSV. */
    private final String CALZADO_FILE_NAME = "computador.csv";

    /**
     * Constructor por defecto que inicializa la lista de computadores y carga los datos desde el archivo CSV.
     */
    public ComputadorDAO() {
        listaComputador = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Obtiene la lista de computadores.
     * 
     * @return lista de objetos {@link Computador}.
     */
    public ArrayList<Computador> getListaComputador() {
        return listaComputador;
    }

    /**
     * Establece la lista de computadores.
     * 
     * @param listaComputador nueva lista de objetos {@link Computador}.
     */
    public void setListaComputador(ArrayList<Computador> listaComputador) {
        this.listaComputador = listaComputador;
    }

    /**
     * Obtiene el nombre del archivo serializado.
     * 
     * @return nombre del archivo serializado.
     */
    public String getSERIAL_FILE_NAME() {
        return SERIAL_FILE_NAME;
    }

    /**
     * Obtiene el nombre del archivo CSV.
     * 
     * @return nombre del archivo CSV.
     */
    public String getCALZADO_FILE_NAME() {
        return CALZADO_FILE_NAME;
    }

    /**
     * Crea un nuevo computador a partir de un objeto {@link ComputadorDTO}.
     * 
     * @param nuevo el DTO que representa el nuevo computador.
     * @return {@code true} si se agregó correctamente, {@code false} si ya existía.
     */
    @Override
    public boolean crear(ComputadorDTO nuevo) {
        Computador entidad = DataMapper.dtoToComputador(nuevo);
        Computador encontrado = find(entidad);

        if (encontrado == null) {
            listaComputador.add(entidad);
            System.out.println("EXITO" + listaComputador.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("COMPUTADOR YA EXISTE");
        return false;
    }

    /**
     * Elimina un computador existente.
     * 
     * @param eliminado el DTO que representa el computador a eliminar.
     * @return {@code true} si fue eliminado, {@code false} si no se encontró.
     */
    @Override
    public boolean eliminar(ComputadorDTO eliminado) {
        Computador entidad = DataMapper.dtoToComputador(eliminado);
        Computador encontrado = find(entidad);
        if (encontrado != null) {
            listaComputador.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un computador en la lista por su identificador.
     * 
     * @param toFind el computador a buscar.
     * @return el computador encontrado o {@code null} si no existe.
     */
    @Override
    public Computador find(Computador toFind) {
        if (!listaComputador.isEmpty()) {
            for (Computador compu : listaComputador) {
                if (compu.getId().equals(toFind.getId())) {
                    System.out.println("COMPUTADOR IGUAL ENCONTRADO");
                    return compu;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza la información de un computador existente.
     * 
     * @param previo el DTO previo.
     * @param nuevo el DTO actualizado.
     * @return {@code true} si se actualizó correctamente, {@code false} en caso contrario.
     */
    @Override
    public boolean update(ComputadorDTO previo, ComputadorDTO nuevo) {
        Computador entidadPrevio = DataMapper.dtoToComputador(previo);
        Computador entidadNuevo = DataMapper.dtoToComputador(nuevo);
        Computador encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaComputador.remove(encontrado);
            listaComputador.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Muestra la lista de computadores en formato de texto.
     * 
     * @return una cadena con la información de todos los computadores o un mensaje si la lista está vacía.
     */
    @Override
    public String mostrar() {
        if (listaComputador.isEmpty()) {
            return "No hay computadores en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Computador compu : listaComputador) {
            rta.append(compu.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de computadores en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaComputador);
    }

    /**
     * Lee el archivo serializado y carga los datos en la lista.
     * Si el archivo está vacío, se inicializa una nueva lista.
     */
    private void leerArchivoSerializado() {
        listaComputador = (ArrayList<Computador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaComputador == null) {
            listaComputador = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de computadores en un archivo de texto en formato CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Computador element : listaComputador) {
            contenido += element.getNombre() + ";";
            contenido += element.getMarca() + ";";
            contenido += element.getTipoProducto() + ";";
            contenido += element.getDescripcion() + ";";
            contenido += element.getUrlImagen() + ";";
            contenido += element.getPrecio() + ";";
            contenido += element.getCantidad() + ";";
            contenido += element.getId() + ";";
            contenido += element.getPulgadas() + ";";
            contenido += element.getResolucion() + ";";
            contenido += element.getSistemaOperativo() + ";";
            contenido += element.getAlmacenamiento() + ";";
            contenido += element.getRam() + ";";
            contenido += element.getProcesador() + ";";
            contenido += element.getTarjetaGrafica() + "\n";
        }

        FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
    }

    /**
     * Carga los datos de computadores desde un archivo CSV y los agrega a la lista.
     */
    public void cargarDesdeArchivo() {
        String contenido = FileManager.leerArchivoTexto(CALZADO_FILE_NAME);

        if (contenido.isBlank() || contenido.isEmpty()) {
            return;
        }

        String[] filas = contenido.split("\n");
        for (String element : filas) {
            String[] columnas = element.split(";");
            String nombre = columnas[0];
            String marca = columnas[1];
            String tipoProducto = columnas[2];
            String descripcion = columnas[3];
            String urlImagen = columnas[4];
            double precio = Double.parseDouble(columnas[5]);
            int cantidad = Integer.parseInt(columnas[6]);
            String id = columnas[7];
            double pulgadas = Double.parseDouble(columnas[8]);
            String resolucion = columnas[9];
            String sistemaOperativo = columnas[10];
            String almacenamiento = columnas[11];
            String ram = columnas[12];
            String procesador = columnas[13];
            String tarjetaGrafica = columnas[14];
            listaComputador.add(new Computador(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad,
                    id, pulgadas, resolucion, sistemaOperativo, almacenamiento, ram, procesador, tarjetaGrafica));
        }
    }
}
