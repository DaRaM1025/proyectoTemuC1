package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Sombra;
import co.edu.unbosque.model.SombraDTO;

/**
 * Clase DAO (Data Access Object) para gestionar operaciones CRUD y persistencia
 * de objetos {@link Sombra}. Implementa la interfaz {@link OperacionDAO} para
 * manejar objetos {@link SombraDTO} y {@link Sombra}.
 * <p>
 * Esta clase permite crear, eliminar, actualizar y buscar sombras en memoria,
 * así como almacenar y recuperar los datos desde archivos CSV y serializados.
 * </p>
 */
public class SombraDAO implements OperacionDAO<SombraDTO, Sombra> {

    /** Lista de sombras cargadas en memoria */
    private ArrayList<Sombra> listaSombras;

    /** Nombre del archivo serializado para persistencia binaria */
    private final String SERIAL_FILE_NAME = "Sombra.dat";

    /** Nombre del archivo CSV para persistencia en texto */
    private final String SOMBRAS_FILE_NAME = "Sombra.csv";

    /**
     * Constructor de la clase.
     * <p>
     * Inicializa la lista de sombras y carga los datos desde el archivo CSV si existe.
     * </p>
     */
    public SombraDAO() {
        listaSombras = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Crea una nueva sombra en la lista si no existe previamente.
     *
     * @param nuevo Objeto {@link SombraDTO} que se desea agregar
     * @return {@code true} si se agregó correctamente; {@code false} si ya existía
     */
    @Override
    public boolean crear(SombraDTO nuevo) {
        Sombra entidad = DataMapper.dtoToSombra(nuevo);
        Sombra encontrado = find(entidad);

        if (encontrado == null) {
            listaSombras.add(entidad);
            System.out.println("EXITO" + listaSombras.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("Sombra YA EXISTE");
        return false;
    }

    /**
     * Elimina una sombra existente de la lista.
     *
     * @param eliminado Objeto {@link SombraDTO} que se desea eliminar
     * @return {@code true} si se eliminó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean eliminar(SombraDTO eliminado) {
        Sombra entidad = DataMapper.dtoToSombra(eliminado);
        Sombra encontrado = find(entidad);
        if (encontrado != null) {
            listaSombras.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca una sombra en la lista por su ID.
     *
     * @param toFind Objeto {@link Sombra} con el ID a buscar
     * @return El {@link Sombra} encontrado, o {@code null} si no existe
     */
    @Override
    public Sombra find(Sombra toFind) {
        if (!listaSombras.isEmpty()) {
            for (Sombra cal : listaSombras) {
                if (cal.getId().equals(toFind.getId())) {
                    System.out.println("Sombra IGUAL ENCONTRADO");
                    return cal;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza una sombra existente con nuevos datos.
     *
     * @param previo Objeto {@link SombraDTO} con los datos actuales
     * @param nuevo  Objeto {@link SombraDTO} con los datos nuevos a actualizar
     * @return {@code true} si la actualización se realizó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean update(SombraDTO previo, SombraDTO nuevo) {
        Sombra entidadPrevio = DataMapper.dtoToSombra(previo);
        Sombra entidadNuevo = DataMapper.dtoToSombra(nuevo);
        Sombra encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaSombras.remove(encontrado);
            listaSombras.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve una representación en texto de todas las sombras de la lista.
     *
     * @return {@link String} con los datos de cada sombra separados por línea
     */
    @Override
    public String mostrar() {
        if (listaSombras.isEmpty()) {
            return "No hay Sombras en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Sombra cal : listaSombras) {
            rta.append(cal.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de sombras en un archivo serializado para persistencia binaria.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaSombras);
    }

    /**
     * Carga la lista de sombras desde un archivo serializado.
     * <p>
     * Si el archivo no existe o está vacío, se inicializa una nueva lista.
     * </p>
     */
    private void leerArchivoSerializado() {
        listaSombras = (ArrayList<Sombra>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaSombras == null) {
            listaSombras = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de sombras en un archivo de texto CSV.
     * <p>
     * Cada campo de la sombra se separa con ';' y cada sombra con salto de línea.
     * Campos: nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, 
     * tipoPiel, esApruebaDeAgua, fechaVencimiento, cantidadColores, acabado.
     * </p>
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Sombra element : listaSombras) {
            contenido += element.getNombre() + ";";
            contenido += element.getMarca() + ";";
            contenido += element.getTipoProducto() + ";";
            contenido += element.getDescripcion() + ";";
            contenido += element.getUrlImagen() + ";";
            contenido += element.getPrecio() + ";";
            contenido += element.getCantidad() + ";";
            contenido += element.getId() + ";";
            contenido += element.getTipoPiel() + ";";
            contenido += element.isEsApruebaDeAgua() + ";";
            contenido += element.getFechaVencimiento() + ";";
            contenido += element.getCantidadColores() + ";";
            contenido += element.getAcabado() + "\n";
        }
        FileManager.escribirEnArchivoTexto(SOMBRAS_FILE_NAME, contenido);
    }

    /**
     * Carga las sombras desde un archivo CSV a la lista en memoria.
     * <p>
     * El archivo debe tener los campos en el siguiente orden:
     * nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
     * tipoPiel, esApruebaDeAgua, fechaVencimiento, cantidadColores, acabado.
     * Si alguna fila está mal formada, se omite.
     * </p>
     */
    public void cargarDesdeArchivo() {
        String contenido = FileManager.leerArchivoTexto(SOMBRAS_FILE_NAME);

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
            int cantColores = Integer.parseInt(columnas[11]);
            String acabado = columnas[12];

            listaSombras.add(new Sombra(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
                    tipoPiel, pruebaAgua, fechaVencimiento, cantColores, acabado));
        }
    }

    /**
     * Obtiene la lista de sombras en memoria.
     *
     * @return {@link ArrayList} de sombras
     */
    public ArrayList<Sombra> getlistaSombras() {
        return listaSombras;
    }

    /**
     * Establece la lista de sombras en memoria.
     *
     * @param listaSombras Nueva lista de sombras
     */
    public void setlistaSombras(ArrayList<Sombra> listaSombras) {
        this.listaSombras = listaSombras;
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
    public String getSombra_FILE_NAME() {
        return SOMBRAS_FILE_NAME;
    }

}
