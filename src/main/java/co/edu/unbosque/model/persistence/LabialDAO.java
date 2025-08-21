package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Labial;
import co.edu.unbosque.model.LabialDTO;

/**
 * Clase DAO para gestionar la persistencia de objetos {@link Labial}.
 * Permite realizar operaciones CRUD y manejar persistencia en archivos CSV y serializados.
 */
public class LabialDAO implements OperacionDAO<LabialDTO, Labial> {

    /** Lista de labiales en memoria */
    private ArrayList<Labial> listaLabiales;

    /** Nombre del archivo serializado */
    private final String SERIAL_FILE_NAME = "labial.dat";

    /** Nombre del archivo CSV */
    private final String LABIAL_FILE_NAME = "labial.csv";

    /**
     * Constructor que inicializa la lista de labiales y carga los datos desde archivo.
     */
    public LabialDAO() {
        listaLabiales = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Crea un nuevo labial.
     * @param nuevo DTO del labial a crear
     * @return true si se creó correctamente, false si ya existía
     */
    @Override
    public boolean crear(LabialDTO nuevo) {
        Labial entidad = DataMapper.dtoToLabial(nuevo);
        Labial encontrado = find(entidad);

        if (encontrado == null) {
            listaLabiales.add(entidad);
            System.out.println("EXITO" + listaLabiales.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("Labial YA EXISTE");
        return false;
    }

    /**
     * Elimina un labial existente.
     * @param eliminado DTO del labial a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    @Override
    public boolean eliminar(LabialDTO eliminado) {
        Labial entidad = DataMapper.dtoToLabial(eliminado);
        Labial encontrado = find(entidad);
        if (encontrado != null) {
            listaLabiales.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un labial por su ID.
     * @param toFind labial a buscar
     * @return labial encontrado o null si no existe
     */
    @Override
    public Labial find(Labial toFind) {
        if (!listaLabiales.isEmpty()) {
            for (Labial cal : listaLabiales) {
                if (cal.getId().equals(toFind.getId())) {
                    System.out.println("Labial IGUAL ENCONTRADO");
                    return cal;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza un labial existente.
     * @param previo DTO del labial a reemplazar
     * @param nuevo DTO con los nuevos datos
     * @return true si se actualizó correctamente, false si no se encontró
     */
    @Override
    public boolean update(LabialDTO previo, LabialDTO nuevo) {
        Labial entidadPrevio = DataMapper.dtoToLabial(previo);
        Labial entidadNuevo = DataMapper.dtoToLabial(nuevo);
        Labial encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaLabiales.remove(encontrado);
            listaLabiales.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve un listado en formato String de todos los labiales.
     * @return String con la información de los labiales
     */
    @Override
    public String mostrar() {
        if (listaLabiales.isEmpty()) {
            return "No hay Labials en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Labial cal : listaLabiales) {
            rta.append(cal.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de labiales en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaLabiales);
    }

    /**
     * Lee la lista de labiales desde un archivo serializado.
     */
    private void leerArchivoSerializado() {
        listaLabiales = (ArrayList<Labial>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaLabiales == null) {
            listaLabiales = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de labiales en un archivo CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Labial listaLabiale : listaLabiales) {
            contenido += listaLabiale.getNombre() + ";";
            contenido += listaLabiale.getMarca() + ";";
            contenido += listaLabiale.getTipoProducto() + ";";
            contenido += listaLabiale.getDescripcion() + ";";
            contenido += listaLabiale.getUrlImagen() + ";";
            contenido += listaLabiale.getPrecio() + ";";
            contenido += listaLabiale.getCantidad() + ";";
            contenido += listaLabiale.getId() + ";";
            contenido += listaLabiale.getTipoPiel() + ";";
            contenido += listaLabiale.isEsApruebaDeAgua() + ";";
            contenido += listaLabiale.getFechaVencimiento() + ";";
            contenido += listaLabiale.getDuracion() + ";";
            contenido += listaLabiale.isEsHidratante() + "\n";
        }
        FileManager.escribirEnArchivoTexto(LABIAL_FILE_NAME, contenido);
    }

    /**
     * Carga la lista de labiales desde un archivo CSV.
     */
    public void cargarDesdeArchivo() {
        String contenido = FileManager.leerArchivoTexto(LABIAL_FILE_NAME);

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
            String duracion = columnas[11];
            boolean hidratante = Boolean.parseBoolean(columnas[12]);
            listaLabiales.add(new Labial(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
                    tipoPiel, pruebaAgua, fechaVencimiento, duracion, hidratante));
        }
    }

    /**
     * Obtiene la lista de labiales.
     * @return lista de labiales
     */
    public ArrayList<Labial> getListaLabiales() {
        return listaLabiales;
    }

    /**
     * Asigna la lista de labiales.
     * @param listaLabiales lista a asignar
     */
    public void setListaLabiales(ArrayList<Labial> listaLabiales) {
        this.listaLabiales = listaLabiales;
    }

    /**
     * Obtiene el nombre del archivo serializado.
     * @return nombre del archivo serializado
     */
    public String getSERIAL_FILE_NAME() {
        return SERIAL_FILE_NAME;
    }

    /**
     * Obtiene el nombre del archivo CSV.
     * @return nombre del archivo CSV
     */
    public String getLABIAL_FILE_NAME() {
        return LABIAL_FILE_NAME;
    }

}
