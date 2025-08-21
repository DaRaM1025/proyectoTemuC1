package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Cuaderno;
import co.edu.unbosque.model.CuadernoDTO;

/**
 * Clase DAO para gestionar la persistencia de objetos {@link Cuaderno}.
 * Permite operaciones CRUD y persistencia tanto en archivos CSV como serializados.
 */
public class CuadernoDAO implements OperacionDAO<CuadernoDTO, Cuaderno> {

    /** Lista de cuadernos en memoria */
    private ArrayList<Cuaderno> listaCuadernos;

    /** Nombre del archivo serializado */
    private final String SERIAL_FILE_NAME = "Cuaderno.dat";

    /** Nombre del archivo CSV */
    private final String CUADERNO_FILE_NAME = "Cuaderno.csv";

    /**
     * Constructor que inicializa la lista de cuadernos y carga los datos desde archivo.
     */
    public CuadernoDAO() {
        listaCuadernos = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Crea un nuevo cuaderno.
     * @param nuevo DTO del cuaderno a crear
     * @return true si se creó correctamente, false si ya existía
     */
    @Override
    public boolean crear(CuadernoDTO nuevo) {
        Cuaderno entidad = DataMapper.dtoToCuaderno(nuevo);
        Cuaderno encontrado = find(entidad);

        if (encontrado == null) {
            listaCuadernos.add(entidad);
            System.out.println("EXITO" + listaCuadernos.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("Cuaderno YA EXISTE");
        return false;
    }

    /**
     * Elimina un cuaderno existente.
     * @param eliminado DTO del cuaderno a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    @Override
    public boolean eliminar(CuadernoDTO eliminado) {
        Cuaderno entidad = DataMapper.dtoToCuaderno(eliminado);
        Cuaderno encontrado = find(entidad);
        if (encontrado != null) {
            listaCuadernos.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un cuaderno por su ID.
     * @param toFind cuaderno a buscar
     * @return el cuaderno encontrado o null si no existe
     */
    @Override
    public Cuaderno find(Cuaderno toFind) {
        if (!listaCuadernos.isEmpty()) {
            for (Cuaderno cal : listaCuadernos) {
                if (cal.getId().equals(toFind.getId())) {
                    System.out.println("Cuaderno IGUAL ENCONTRADO");
                    return cal;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza un cuaderno existente.
     * @param previo DTO del cuaderno a reemplazar
     * @param nuevo DTO con los nuevos datos
     * @return true si se actualizó correctamente, false si no se encontró
     */
    @Override
    public boolean update(CuadernoDTO previo, CuadernoDTO nuevo) {
        Cuaderno entidadPrevio = DataMapper.dtoToCuaderno(previo);
        Cuaderno entidadNuevo = DataMapper.dtoToCuaderno(nuevo);
        Cuaderno encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaCuadernos.remove(encontrado);
            listaCuadernos.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve un listado en formato String de todos los cuadernos.
     * @return String con la información de los cuadernos
     */
    @Override
    public String mostrar() {
        if (listaCuadernos.isEmpty()) {
            return "No hay Cuadernos en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Cuaderno cal : listaCuadernos) {
            rta.append(cal.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de cuadernos en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCuadernos);
    }

    /**
     * Lee la lista de cuadernos desde un archivo serializado.
     */
    private void leerArchivoSerializado() {
        listaCuadernos = (ArrayList<Cuaderno>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaCuadernos == null) {
            listaCuadernos = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de cuadernos en un archivo CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Cuaderno element : listaCuadernos) {
            contenido += element.getNombre() + ";";
            contenido += element.getMarca() + ";";
            contenido += element.getTipoProducto() + ";";
            contenido += element.getDescripcion() + ";";
            contenido += element.getUrlImagen() + ";";
            contenido += element.getPrecio() + ";";
            contenido += element.getCantidad() + ";";
            contenido += element.getId() + ";";
            contenido += element.getTipoPresentacion() + ";";
            contenido += element.getTipoHojas() + ";";
            contenido += element.getCantidadHojas() + ";";
            contenido += element.isPastaDura() + "\n";
        }
        FileManager.escribirEnArchivoTexto(CUADERNO_FILE_NAME, contenido);
    }

    /**
     * Carga la lista de cuadernos desde un archivo CSV.
     */
    public void cargarDesdeArchivo() {
        String contenido = FileManager.leerArchivoTexto(CUADERNO_FILE_NAME);

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
            String tipoPresentacion = columnas[8];
            String tipoHojas = columnas[9];
            int cantidadHojas = Integer.parseInt(columnas[10]);
            boolean pastaDura = Boolean.parseBoolean(columnas[11]);
            listaCuadernos.add(new Cuaderno(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
                    tipoPresentacion, tipoHojas, cantidadHojas, pastaDura));
        }
    }

    /**
     * Obtiene la lista de cuadernos.
     * @return lista de cuadernos
     */
    public ArrayList<Cuaderno> getlistaCuadernos() {
        return listaCuadernos;
    }

    /**
     * Asigna la lista de cuadernos.
     * @param listaCuadernos lista a asignar
     */
    public void setlistaCuadernos(ArrayList<Cuaderno> listaCuadernos) {
        this.listaCuadernos = listaCuadernos;
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
    public String getCuaderno_FILE_NAME() {
        return CUADERNO_FILE_NAME;
    }
}
