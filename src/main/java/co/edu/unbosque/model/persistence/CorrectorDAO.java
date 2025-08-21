package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Corrector;
import co.edu.unbosque.model.CorrectorDTO;

/**
 * Clase {@code CorrectorDAO} que implementa las operaciones CRUD para gestionar objetos de tipo
 * {@link Corrector} y su persistencia en archivos de texto y binarios.
 * 
 * <p>Implementa la interfaz {@link OperacionDAO} para realizar las operaciones:
 * crear, eliminar, actualizar, buscar y mostrar correctores.</p>
 * 
 * <p>
 * Maneja la persistencia en dos formatos:
 * <ul>
 * <li>Archivo serializado: {@code Corrector.dat}</li>
 * <li>Archivo de texto (CSV): {@code Corrector.csv}</li>
 * </ul>
 * </p>
 */
public class CorrectorDAO implements OperacionDAO<CorrectorDTO, Corrector> {

    /** Lista que almacena los objetos de tipo {@link Corrector}. */
    private ArrayList<Corrector> listaCorrectores;

    /** Nombre del archivo para la persistencia en formato binario. */
    private final String SERIAL_FILE_NAME = "Corrector.dat";

    /** Nombre del archivo para la persistencia en formato CSV. */
    private final String CORRECTOR_FILE_NAME = "Corrector.csv";

    /**
     * Constructor por defecto que inicializa la lista de correctores y carga los datos desde el archivo CSV.
     */
    public CorrectorDAO() {
        listaCorrectores = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Crea un nuevo corrector a partir de un objeto {@link CorrectorDTO}.
     * 
     * @param nuevo el DTO que representa el nuevo corrector.
     * @return {@code true} si se agregó correctamente, {@code false} si ya existía.
     */
    @Override
    public boolean crear(CorrectorDTO nuevo) {
        Corrector entidad = DataMapper.dtoToCorrector(nuevo);
        Corrector encontrado = find(entidad);

        if (encontrado == null) {
            listaCorrectores.add(entidad);
            System.out.println("EXITO" + listaCorrectores.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("Corrector YA EXISTE");
        return false;
    }

    /**
     * Elimina un corrector existente.
     * 
     * @param eliminado el DTO que representa el corrector a eliminar.
     * @return {@code true} si fue eliminado, {@code false} si no se encontró.
     */
    @Override
    public boolean eliminar(CorrectorDTO eliminado) {
        Corrector entidad = DataMapper.dtoToCorrector(eliminado);
        Corrector encontrado = find(entidad);
        if (encontrado != null) {
            listaCorrectores.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un corrector en la lista por su identificador.
     * 
     * @param toFind el corrector a buscar.
     * @return el corrector encontrado o {@code null} si no existe.
     */
    @Override
    public Corrector find(Corrector toFind) {
        if (!listaCorrectores.isEmpty()) {
            for (Corrector cal : listaCorrectores) {
                if (cal.getId().equals(toFind.getId())) {
                    System.out.println("Corrector IGUAL ENCONTRADO");
                    return cal;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza la información de un corrector existente.
     * 
     * @param previo el DTO previo.
     * @param nuevo el DTO actualizado.
     * @return {@code true} si se actualizó correctamente, {@code false} en caso contrario.
     */
    @Override
    public boolean update(CorrectorDTO previo, CorrectorDTO nuevo) {
        Corrector entidadPrevio = DataMapper.dtoToCorrector(previo);
        Corrector entidadNuevo = DataMapper.dtoToCorrector(nuevo);
        Corrector encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaCorrectores.remove(encontrado);
            listaCorrectores.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Muestra la lista de correctores en formato de texto.
     * 
     * @return una cadena con la información de todos los correctores o un mensaje si la lista está vacía.
     */
    @Override
    public String mostrar() {
        if (listaCorrectores.isEmpty()) {
            return "No hay Correctors en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Corrector cal : listaCorrectores) {
            rta.append(cal.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de correctores en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCorrectores);
    }

    /**
     * Lee el archivo serializado y carga los datos en la lista.
     * Si el archivo está vacío, se inicializa una nueva lista.
     */
    private void leerArchivoSerializado() {
        listaCorrectores = (ArrayList<Corrector>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaCorrectores == null) {
            listaCorrectores = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de correctores en un archivo de texto en formato CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Corrector listaCorrectore : listaCorrectores) {
            contenido += listaCorrectore.getNombre() + ";";
            contenido += listaCorrectore.getMarca() + ";";
            contenido += listaCorrectore.getTipoProducto() + ";";
            contenido += listaCorrectore.getDescripcion() + ";";
            contenido += listaCorrectore.getUrlImagen() + ";";
            contenido += listaCorrectore.getPrecio() + ";";
            contenido += listaCorrectore.getCantidad() + ";";
            contenido += listaCorrectore.getId() + ";";
            contenido += listaCorrectore.getTipoPiel() + ";";
            contenido += listaCorrectore.isEsApruebaDeAgua() + ";";
            contenido += listaCorrectore.getFechaVencimiento() + ";";
            contenido += listaCorrectore.getCobertura() + ";";
            contenido += listaCorrectore.getFormato() + "\n";
        }
        FileManager.escribirEnArchivoTexto(CORRECTOR_FILE_NAME, contenido);
    }

    /**
     * Carga los datos de correctores desde un archivo CSV y los agrega a la lista.
     */
    public void cargarDesdeArchivo() {
        String contenido = FileManager.leerArchivoTexto(CORRECTOR_FILE_NAME);

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
            String tipoPiel = columnas[8];
            boolean pruebaAgua = Boolean.parseBoolean(columnas[9]);
            String fechaVencimiento = columnas[10];
            String cobertura = columnas[11];
            String formato = columnas[12];

            listaCorrectores.add(new Corrector(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad,
                    id, tipoPiel, pruebaAgua, fechaVencimiento, cobertura, formato));
        }
    }

    /**
     * Obtiene la lista de correctores.
     * 
     * @return lista de objetos {@link Corrector}.
     */
    public ArrayList<Corrector> getListaCorrectores() {
        return listaCorrectores;
    }

    /**
     * Establece la lista de correctores.
     * 
     * @param listaCorrectores nueva lista de objetos {@link Corrector}.
     */
    public void setListaCorrectores(ArrayList<Corrector> listaCorrectores) {
        this.listaCorrectores = listaCorrectores;
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
    public String getCORRECTOR_FILE_NAME() {
        return CORRECTOR_FILE_NAME;
    }
}
