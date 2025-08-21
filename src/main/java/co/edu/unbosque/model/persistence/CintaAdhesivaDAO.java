package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CintaAdhesiva;
import co.edu.unbosque.model.CintaAdhesivaDTO;

/**
 * Clase {@code CintaAdhesivaDAO} que implementa las operaciones CRUD para gestionar objetos de tipo
 * {@link CintaAdhesiva} y su persistencia en archivos de texto y binarios.
 * 
 * <p>Implementa la interfaz {@link OperacionDAO} para realizar las operaciones:
 * crear, eliminar, actualizar, buscar y mostrar cintas adhesivas.</p>
 * 
 * <p>
 * Maneja la persistencia en dos formatos:
 * <ul>
 * <li>Archivo serializado: {@code CintaAdhesiva.dat}</li>
 * <li>Archivo de texto (CSV): {@code CintaAdhesiva.csv}</li>
 * </ul>
 * </p>
 */
public class CintaAdhesivaDAO implements OperacionDAO<CintaAdhesivaDTO, CintaAdhesiva> {

    /** Lista que almacena los objetos de tipo {@link CintaAdhesiva}. */
    private ArrayList<CintaAdhesiva> listaCintaAdhesivas;

    /** Nombre del archivo para la persistencia en formato binario. */
    private final String SERIAL_FILE_NAME = "CintaAdhesiva.dat";

    /** Nombre del archivo para la persistencia en formato CSV. */
    private final String CINTA_FILE_NAME = "CintaAdhesiva.csv";

    /**
     * Constructor por defecto que inicializa la lista de cintas adhesivas y carga los datos desde el archivo CSV.
     */
    public CintaAdhesivaDAO() {
        listaCintaAdhesivas = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Crea una nueva cinta adhesiva a partir de un objeto {@link CintaAdhesivaDTO}.
     * 
     * @param nuevo el DTO que representa la nueva cinta adhesiva.
     * @return {@code true} si se agregó correctamente, {@code false} si ya existía.
     */
    @Override
    public boolean crear(CintaAdhesivaDTO nuevo) {
        CintaAdhesiva entidad = DataMapper.dtoToCintaAdhesiva(nuevo);
        CintaAdhesiva encontrado = find(entidad);

        if (encontrado == null) {
            listaCintaAdhesivas.add(entidad);
            System.out.println("EXITO" + listaCintaAdhesivas.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("CintaAdhesiva YA EXISTE");
        return false;
    }

    /**
     * Elimina una cinta adhesiva existente.
     * 
     * @param eliminado el DTO que representa la cinta adhesiva a eliminar.
     * @return {@code true} si fue eliminado, {@code false} si no se encontró.
     */
    @Override
    public boolean eliminar(CintaAdhesivaDTO eliminado) {
        CintaAdhesiva entidad = DataMapper.dtoToCintaAdhesiva(eliminado);
        CintaAdhesiva encontrado = find(entidad);
        if (encontrado != null) {
            listaCintaAdhesivas.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca una cinta adhesiva en la lista por su identificador.
     * 
     * @param toFind la cinta adhesiva a buscar.
     * @return la cinta adhesiva encontrada o {@code null} si no existe.
     */
    @Override
    public CintaAdhesiva find(CintaAdhesiva toFind) {
        if (!listaCintaAdhesivas.isEmpty()) {
            for (CintaAdhesiva cal : listaCintaAdhesivas) {
                if (cal.getId().equals(toFind.getId())) {
                    System.out.println("CintaAdhesiva IGUAL ENCONTRADO");
                    return cal;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza la información de una cinta adhesiva existente.
     * 
     * @param previo el DTO previo.
     * @param nuevo el DTO actualizado.
     * @return {@code true} si se actualizó correctamente, {@code false} en caso contrario.
     */
    @Override
    public boolean update(CintaAdhesivaDTO previo, CintaAdhesivaDTO nuevo) {
        CintaAdhesiva entidadPrevio = DataMapper.dtoToCintaAdhesiva(previo);
        CintaAdhesiva entidadNuevo = DataMapper.dtoToCintaAdhesiva(nuevo);
        CintaAdhesiva encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaCintaAdhesivas.remove(encontrado);
            listaCintaAdhesivas.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Muestra la lista de cintas adhesivas en formato de texto.
     * 
     * @return una cadena con la información de todas las cintas adhesivas o un mensaje si la lista está vacía.
     */
    @Override
    public String mostrar() {
        if (listaCintaAdhesivas.isEmpty()) {
            return "No hay CintaAdhesivas en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (CintaAdhesiva cal : listaCintaAdhesivas) {
            rta.append(cal.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de cintas adhesivas en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCintaAdhesivas);
    }

    /**
     * Lee el archivo serializado y carga los datos en la lista.
     * Si el archivo está vacío, se inicializa una nueva lista.
     */
    private void leerArchivoSerializado() {
        listaCintaAdhesivas = (ArrayList<CintaAdhesiva>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaCintaAdhesivas == null) {
            listaCintaAdhesivas = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de cintas adhesivas en un archivo de texto en formato CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (CintaAdhesiva element : listaCintaAdhesivas) {
            contenido += element.getNombre() + ";";
            contenido += element.getMarca() + ";";
            contenido += element.getTipoProducto() + ";";
            contenido += element.getDescripcion() + ";";
            contenido += element.getUrlImagen() + ";";
            contenido += element.getPrecio() + ";";
            contenido += element.getCantidad() + ";";
            contenido += element.getId() + ";";
            contenido += element.getTipoPresentacion() + ";";
            contenido += element.isEsAdhesivoReposicionable() + ";";
            contenido += element.getAncho() + ";";
            contenido += element.getTipoCinta() + "\n";
        }
        FileManager.escribirEnArchivoTexto(CINTA_FILE_NAME, contenido);
    }

    /**
     * Carga los datos de cintas adhesivas desde un archivo CSV y los agrega a la lista.
     */
    public void cargarDesdeArchivo() {
        String contenido = FileManager.leerArchivoTexto(CINTA_FILE_NAME);

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
            boolean adhesivo = Boolean.parseBoolean(columnas[9]);
            double ancho = Double.parseDouble(columnas[10]);
            String tipoCinta = columnas[11];
            listaCintaAdhesivas.add(new CintaAdhesiva(nombre, marca, tipoProducto, descripcion, urlImagen, precio,
                    cantidad, id, tipoPresentacion, adhesivo, ancho, tipoCinta));
        }
    }

    /**
     * Obtiene la lista de cintas adhesivas.
     * 
     * @return lista de objetos {@link CintaAdhesiva}.
     */
    public ArrayList<CintaAdhesiva> getlistaCintaAdhesivas() {
        return listaCintaAdhesivas;
    }

    /**
     * Establece la lista de cintas adhesivas.
     * 
     * @param listaCintaAdhesivas nueva lista de objetos {@link CintaAdhesiva}.
     */
    public void setlistaCintaAdhesivas(ArrayList<CintaAdhesiva> listaCintaAdhesivas) {
        this.listaCintaAdhesivas = listaCintaAdhesivas;
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
    public String getCintaAdhesiva_FILE_NAME() {
        return CINTA_FILE_NAME;
    }

}
