package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Celular;
import co.edu.unbosque.model.CelularDTO;

/**
 * Clase {@code CelularDAO} que implementa las operaciones CRUD para gestionar objetos de tipo
 * {@link Celular} y su persistencia en archivos de texto y binarios.
 * 
 * <p>Implementa la interfaz {@link OperacionDAO} para realizar las operaciones:
 * crear, eliminar, actualizar, buscar y mostrar celulares.
 * </p>
 * 
 * <p>
 * Además, maneja la persistencia en dos formatos:
 * <ul>
 * <li>Archivo serializado: {@code celular.dat}</li>
 * <li>Archivo de texto (CSV): {@code celular.csv}</li>
 * </ul>
 * </p>
 * 
 * @author 
 */
public class CelularDAO implements OperacionDAO<CelularDTO, Celular> {

    /** Lista que almacena los objetos de tipo {@link Celular}. */
    private ArrayList<Celular> listaCelular;

    /** Nombre del archivo para la persistencia en formato binario. */
    private final String SERIAL_FILE_NAME = "celular.dat";

    /** Nombre del archivo para la persistencia en formato CSV. */
    private final String CALZADO_FILE_NAME = "celular.csv";

    /**
     * Constructor por defecto que inicializa la lista de celulares y carga los datos desde el archivo CSV.
     */
    public CelularDAO() {
        listaCelular = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Obtiene la lista de celulares.
     * 
     * @return una lista de objetos {@link Celular}.
     */
    public ArrayList<Celular> getListaCelular() {
        return listaCelular;
    }

    /**
     * Establece la lista de celulares.
     * 
     * @param listaCelular la nueva lista de objetos {@link Celular}.
     */
    public void setListaCelular(ArrayList<Celular> listaCelular) {
        this.listaCelular = listaCelular;
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
     * Crea un nuevo celular a partir de un objeto {@link CelularDTO}.
     * 
     * <p>Convierte el DTO a entidad, verifica si ya existe, y en caso contrario lo agrega a la lista
     * y actualiza los archivos de persistencia.</p>
     * 
     * @param nuevo el objeto DTO que representa el nuevo celular.
     * @return {@code true} si se agregó correctamente, {@code false} si ya existía.
     */
    @Override
    public boolean crear(CelularDTO nuevo) {
        Celular entidad = DataMapper.dtoToCelular(nuevo);
        Celular encontrado = find(entidad);

        if (encontrado == null) {
            listaCelular.add(entidad);
            System.out.println("EXITO" + listaCelular.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("CELULAR YA EXISTE");
        return false;
    }

    /**
     * Elimina un celular existente.
     * 
     * @param eliminado el DTO que representa el celular a eliminar.
     * @return {@code true} si fue eliminado, {@code false} si no se encontró.
     */
    @Override
    public boolean eliminar(CelularDTO eliminado) {
        Celular entidad = DataMapper.dtoToCelular(eliminado);
        Celular encontrado = find(entidad);
        if (encontrado != null) {
            listaCelular.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un celular en la lista por su identificador.
     * 
     * @param toFind el celular a buscar.
     * @return el celular encontrado o {@code null} si no existe.
     */
    @Override
    public Celular find(Celular toFind) {
        if (!listaCelular.isEmpty()) {
            for (Celular cel : listaCelular) {
                if (cel.getId().equals(toFind.getId())) {
                    System.out.println("CELULAR IGUAL ENCONTRADO");
                    return cel;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza la información de un celular existente.
     * 
     * @param previo el celular previo (antes del cambio).
     * @param nuevo el celular actualizado.
     * @return {@code true} si se actualizó correctamente, {@code false} en caso contrario.
     */
    @Override
    public boolean update(CelularDTO previo, CelularDTO nuevo) {
        Celular entidadPrevio = DataMapper.dtoToCelular(previo);
        Celular entidadNuevo = DataMapper.dtoToCelular(nuevo);
        Celular encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaCelular.remove(encontrado);
            listaCelular.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Muestra la lista de celulares en formato de texto.
     * 
     * @return una cadena con la información de todos los celulares o un mensaje si la lista está vacía.
     */
    @Override
    public String mostrar() {
        if (listaCelular.isEmpty()) {
            return "No hay celulares en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Celular cel : listaCelular) {
            rta.append(cel.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de celulares en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCelular);
    }

    /**
     * Lee el archivo serializado y carga los datos en la lista de celulares.
     * Si el archivo está vacío, se inicializa una nueva lista.
     */
    private void leerArchivoSerializado() {
        listaCelular = (ArrayList<Celular>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaCelular == null) {
            listaCelular = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de celulares en un archivo de texto en formato CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (Celular element : listaCelular) {
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
            contenido += element.getCantidadCamaras() + ";";
            contenido += element.isDualSim() + "\n";
        }

        FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
    }

    /**
     * Carga los datos de celulares desde un archivo CSV y los agrega a la lista.
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
            int cantidadCamaras = Integer.parseInt(columnas[13]);
            boolean dualSim = Boolean.valueOf(columnas[14]);
            listaCelular.add(new Celular(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
                    pulgadas, resolucion, sistemaOperativo, almacenamiento, ram, cantidadCamaras, dualSim));
        }
    }

}
