package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Televisor;
import co.edu.unbosque.model.TelevisorDTO;

/**
 * Clase DAO (Data Access Object) para gestionar operaciones CRUD y persistencia
 * de objetos {@link Televisor}. Implementa la interfaz {@link OperacionDAO} para
 * manejar objetos {@link TelevisorDTO} y {@link Televisor}.
 * <p>
 * Esta clase permite crear, eliminar, actualizar y buscar televisores en memoria,
 * así como almacenar y recuperar los datos desde archivos CSV y serializados.
 * </p>
 */
public class TelevisorDAO implements OperacionDAO<TelevisorDTO, Televisor> {

    /** Lista de televisores cargados en memoria */
    private ArrayList<Televisor> listaTelevisor;

    /** Nombre del archivo serializado para persistencia binaria */
    private final String SERIAL_FILE_NAME = "televisor.dat";

    /** Nombre del archivo CSV para persistencia en texto */
    private final String CALZADO_FILE_NAME = "televisor.csv";

    /**
     * Constructor de la clase.
     * <p>
     * Inicializa la lista de televisores y carga los datos desde el archivo CSV si existe.
     * </p>
     */
    public TelevisorDAO() {
        listaTelevisor = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Obtiene la lista de televisores en memoria.
     *
     * @return {@link ArrayList} de televisores
     */
    public ArrayList<Televisor> getListaCalzado() {
        return listaTelevisor;
    }

    /**
     * Establece la lista de televisores en memoria.
     *
     * @param listaTelevisor Nueva lista de televisores
     */
    public void setListaTelevisor(ArrayList<Televisor> listaTelevisor) {
        this.listaTelevisor = listaTelevisor;
    }

    /**
     * Obtiene el nombre del archivo serializado para persistencia binaria.
     *
     * @return {@link String} nombre del archivo serializado
     */
    public String getSERIAL_FILE_NAME() {
        return SERIAL_FILE_NAME;
    }

    /**
     * Obtiene el nombre del archivo CSV para persistencia en texto.
     *
     * @return {@link String} nombre del archivo CSV
     */
    public String getCALZADO_FILE_NAME() {
        return CALZADO_FILE_NAME;
    }

    /**
     * Crea un nuevo televisor en la lista si no existe previamente.
     *
     * @param nuevo Objeto {@link TelevisorDTO} que se desea agregar
     * @return {@code true} si se agregó correctamente; {@code false} si ya existía
     */
    @Override
    public boolean crear(TelevisorDTO nuevo) {
        Televisor entidad = DataMapper.dtoToTelevisor(nuevo);
        Televisor encontrado = find(entidad);

        if (encontrado == null) {
            listaTelevisor.add(entidad);
            System.out.println("EXITO" + listaTelevisor.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("TELEVISOR YA EXISTE");
        return false;
    }

    /**
     * Elimina un televisor existente de la lista.
     *
     * @param eliminado Objeto {@link TelevisorDTO} que se desea eliminar
     * @return {@code true} si se eliminó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean eliminar(TelevisorDTO eliminado) {
        Televisor entidad = DataMapper.dtoToTelevisor(eliminado);
        Televisor encontrado = find(entidad);
        if (encontrado != null) {
            listaTelevisor.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un televisor en la lista por su ID.
     *
     * @param toFind Objeto {@link Televisor} con el ID a buscar
     * @return El {@link Televisor} encontrado, o {@code null} si no existe
     */
    @Override
    public Televisor find(Televisor toFind) {
        if (!listaTelevisor.isEmpty()) {
            for (Televisor tele : listaTelevisor) {
                if (tele.getId().equals(toFind.getId())) {
                    System.out.println("TELEVISOR IGUAL ENCONTRADO");
                    return tele;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza un televisor existente con nuevos datos.
     *
     * @param previo Objeto {@link TelevisorDTO} con los datos actuales
     * @param nuevo  Objeto {@link TelevisorDTO} con los datos nuevos a actualizar
     * @return {@code true} si la actualización se realizó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean update(TelevisorDTO previo, TelevisorDTO nuevo) {
        Televisor entidadPrevio = DataMapper.dtoToTelevisor(previo);
        Televisor entidadNuevo = DataMapper.dtoToTelevisor(nuevo);
        Televisor encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaTelevisor.remove(encontrado);
            listaTelevisor.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve una representación en texto de todos los televisores de la lista.
     *
     * @return {@link String} con los datos de cada televisor separados por línea
     */
    @Override
    public String mostrar() {
        if (listaTelevisor.isEmpty()) {
            return "No hay televisores en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Televisor tele : listaTelevisor) {
            rta.append(tele.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de televisores en un archivo serializado para persistencia binaria.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTelevisor);
    }

    /**
     * Carga la lista de televisores desde un archivo serializado.
     * <p>
     * Si el archivo no existe o está vacío, se inicializa una nueva lista.
     * </p>
     */
    private void leerArchivoSerializado() {
        listaTelevisor = (ArrayList<Televisor>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaTelevisor == null) {
            listaTelevisor = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de televisores en un archivo de texto CSV.
     * <p>
     * Cada campo del televisor se separa con ';' y cada televisor con salto de línea.
     * Campos: nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, 
     * pulgadas, resolucion, sistemaOperativo, cantPuertosHDMI, frecuenciaHz, asistenteVirtual.
     * </p>
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Televisor element : listaTelevisor) {
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
            contenido += element.getCantPuertosHDMI() + ";";
            contenido += element.getFrecuenciaHz() + ";";
            contenido += element.getAsistenteVirtual() + "\n";
        }

        FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
    }

    /**
     * Carga los televisores desde un archivo CSV a la lista en memoria.
     * <p>
     * El archivo debe tener los campos en el siguiente orden:
     * nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, 
     * pulgadas, resolucion, sistemaOperativo, cantPuertosHDMI, frecuenciaHz, asistenteVirtual.
     * Si alguna fila está mal formada, se omite.
     * </p>
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
            int cantPuertosHDMI = Integer.parseInt(columnas[11]);
            int frecuenciaHz = Integer.parseInt(columnas[12]);
            String asistenteVirtual = columnas[13];
            listaTelevisor.add(new Televisor(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
                    pulgadas, resolucion, sistemaOperativo, cantPuertosHDMI, frecuenciaHz, asistenteVirtual));
        }
    }

}
