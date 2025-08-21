package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Marcador;
import co.edu.unbosque.model.MarcadorDTO;

/**
 * Clase DAO (Data Access Object) que gestiona la persistencia y operaciones CRUD
 * de objetos {@link Marcador}. Implementa la interfaz {@link OperacionDAO} para
 * operar con {@link MarcadorDTO} y {@link Marcador}.
 * <p>
 * Esta clase permite crear, eliminar, actualizar y buscar marcadores en memoria,
 * así como almacenar y recuperar los datos desde archivos CSV y serializados.
 * </p>
 */
public class MarcadorDAO implements OperacionDAO<MarcadorDTO, Marcador> {

    /** Lista de marcadores cargados en memoria */
    private ArrayList<Marcador> listaMarcadores;

    /** Nombre del archivo serializado para persistencia binaria */
    private final String SERIAL_FILE_NAME = "Marcador.dat";

    /** Nombre del archivo CSV para persistencia en texto */
    private final String MARCADOR_FILE_NAME = "Marcador.csv";

    /**
     * Constructor de la clase.
     * <p>
     * Inicializa la lista de marcadores y carga los datos desde el archivo CSV,
     * si existe.
     * </p>
     */
    public MarcadorDAO() {
        listaMarcadores = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Crea un nuevo marcador en la lista si no existe previamente.
     *
     * @param nuevo Objeto {@link MarcadorDTO} que se desea agregar
     * @return {@code true} si se agregó correctamente; {@code false} si ya existe
     */
    @Override
    public boolean crear(MarcadorDTO nuevo) {
        Marcador entidad = DataMapper.dtoToMarcador(nuevo);
        Marcador encontrado = find(entidad);

        if (encontrado == null) {
            listaMarcadores.add(entidad);
            System.out.println("EXITO" + listaMarcadores.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("Marcador YA EXISTE");
        return false;
    }

    /**
     * Elimina un marcador de la lista si existe.
     *
     * @param eliminado Objeto {@link MarcadorDTO} que se desea eliminar
     * @return {@code true} si se eliminó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean eliminar(MarcadorDTO eliminado) {
        Marcador entidad = DataMapper.dtoToMarcador(eliminado);
        Marcador encontrado = find(entidad);
        if (encontrado != null) {
            listaMarcadores.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un marcador en la lista por su ID.
     *
     * @param toFind Objeto {@link Marcador} con el ID a buscar
     * @return El {@link Marcador} encontrado o {@code null} si no existe
     */
    @Override
    public Marcador find(Marcador toFind) {
        if (!listaMarcadores.isEmpty()) {
            for (Marcador cal : listaMarcadores) {
                if (cal.getId().equals(toFind.getId())) {
                    System.out.println("Marcador IGUAL ENCONTRADO");
                    return cal;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza un marcador existente con nuevos datos.
     *
     * @param previo Objeto {@link MarcadorDTO} con los datos actuales
     * @param nuevo  Objeto {@link MarcadorDTO} con los datos nuevos
     * @return {@code true} si se actualizó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean update(MarcadorDTO previo, MarcadorDTO nuevo) {
        Marcador entidadPrevio = DataMapper.dtoToMarcador(previo);
        Marcador entidadNuevo = DataMapper.dtoToMarcador(nuevo);
        Marcador encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaMarcadores.remove(encontrado);
            listaMarcadores.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve una representación en texto de todos los marcadores de la lista.
     *
     * @return {@link String} con los datos de cada marcador separados por línea
     */
    @Override
    public String mostrar() {
        if (listaMarcadores.isEmpty()) {
            return "No hay Marcadors en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Marcador cal : listaMarcadores) {
            rta.append(cal.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de marcadores en un archivo serializado para persistencia binaria.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaMarcadores);
    }

    /**
     * Carga la lista de marcadores desde un archivo serializado.
     * <p>
     * Si el archivo no existe o está vacío, se inicializa una nueva lista.
     * </p>
     */
    private void leerArchivoSerializado() {
        listaMarcadores = (ArrayList<Marcador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaMarcadores == null) {
            listaMarcadores = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de marcadores en un archivo de texto CSV.
     * <p>
     * Cada campo del marcador se separa con ';' y cada marcador con salto de línea.
     * </p>
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Marcador listaMarcadore : listaMarcadores) {
            contenido += listaMarcadore.getNombre() + ";";
            contenido += listaMarcadore.getMarca() + ";";
            contenido += listaMarcadore.getTipoProducto() + ";";
            contenido += listaMarcadore.getDescripcion() + ";";
            contenido += listaMarcadore.getUrlImagen() + ";";
            contenido += listaMarcadore.getPrecio() + ";";
            contenido += listaMarcadore.getCantidad() + ";";
            contenido += listaMarcadore.getId() + ";";
            contenido += listaMarcadore.getTipoPresentacion() + ";";
            contenido += listaMarcadore.getTipoPunta() + ";";
            contenido += listaMarcadore.isPermanente() + ";";
            contenido += listaMarcadore.getTipoMarcador() + "\n";
        }
        FileManager.escribirEnArchivoTexto(MARCADOR_FILE_NAME, contenido);
    }

    /**
     * Carga los marcadores desde un archivo CSV a la lista en memoria.
     * <p>
     * El archivo debe tener los campos en el siguiente orden: nombre, marca,
     * tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion,
     * tipoPunta, permanente, tipoMarcador. Si alguna fila está mal formada,
     * se omite.
     * </p>
     */
    public void cargarDesdeArchivo() {
        String contenido = FileManager.leerArchivoTexto(MARCADOR_FILE_NAME);

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
            String tipoPresentacion = columnas[9];
            String tipoPunta = columnas[10];
            boolean permanente = Boolean.parseBoolean(columnas[11]);
            String tipoMarcador = columnas[10];
            listaMarcadores.add(new Marcador(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
                    tipoPresentacion, tipoPunta, permanente, tipoMarcador));
        }
    }

    /**
     * Obtiene la lista de marcadores en memoria.
     *
     * @return {@link ArrayList} de marcadores
     */
    public ArrayList<Marcador> getlistaMarcadores() {
        return listaMarcadores;
    }

    /**
     * Establece la lista de marcadores en memoria.
     *
     * @param listaMarcadores Nueva lista de marcadores
     */
    public void setlistaMarcadores(ArrayList<Marcador> listaMarcadores) {
        this.listaMarcadores = listaMarcadores;
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
    public String getMARCADOR_FILE_NAME() {
        return MARCADOR_FILE_NAME;
    }

}
