package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InstrumentoCuerda;
import co.edu.unbosque.model.InstrumentoCuerdaDTO;

/**
 * Clase DAO para gestionar la persistencia de objetos {@link InstrumentoCuerda}.
 * Permite operaciones CRUD y persistencia tanto en archivos CSV como serializados.
 */
public class InstrumentoCuerdaDAO implements OperacionDAO<InstrumentoCuerdaDTO, InstrumentoCuerda> {

    /** Lista de instrumentos de cuerda en memoria */
    private ArrayList<InstrumentoCuerda> listaInstrumentoCuerda;

    /** Nombre del archivo serializado */
    private final String SERIAL_FILE_NAME = "instrumentocuerda.dat";

    /** Nombre del archivo CSV */
    private final String CALZADO_FILE_NAME = "instrumentocuerda.csv";

    /**
     * Constructor que inicializa la lista de instrumentos de cuerda y carga los datos desde archivo.
     */
    public InstrumentoCuerdaDAO() {
        listaInstrumentoCuerda = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Obtiene la lista de instrumentos de cuerda.
     * @return lista de instrumentos de cuerda
     */
    public ArrayList<InstrumentoCuerda> getListaInstrumentoCuerda() {
        return listaInstrumentoCuerda;
    }

    /**
     * Asigna la lista de instrumentos de cuerda.
     * @param listaInstrumentoCuerda lista a asignar
     */
    public void setListaInstrumentoCuerda(ArrayList<InstrumentoCuerda> listaInstrumentoCuerda) {
        this.listaInstrumentoCuerda = listaInstrumentoCuerda;
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
    public String getCALZADO_FILE_NAME() {
        return CALZADO_FILE_NAME;
    }

    /**
     * Crea un nuevo instrumento de cuerda.
     * @param nuevo DTO del instrumento a crear
     * @return true si se creó correctamente, false si ya existía
     */
    @Override
    public boolean crear(InstrumentoCuerdaDTO nuevo) {
        InstrumentoCuerda entidad = DataMapper.dtoToInstrumentoCuerda(nuevo);
        InstrumentoCuerda encontrado = find(entidad);

        if (encontrado == null) {
            listaInstrumentoCuerda.add(entidad);
            System.out.println("EXITO" + listaInstrumentoCuerda.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("INSTRUMENTO CUERDA YA EXISTE");
        return false;
    }

    /**
     * Elimina un instrumento de cuerda existente.
     * @param eliminado DTO del instrumento a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    @Override
    public boolean eliminar(InstrumentoCuerdaDTO eliminado) {
        InstrumentoCuerda entidad = DataMapper.dtoToInstrumentoCuerda(eliminado);
        InstrumentoCuerda encontrado = find(entidad);
        if (encontrado != null) {
            listaInstrumentoCuerda.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un instrumento de cuerda por su ID.
     * @param toFind instrumento a buscar
     * @return el instrumento encontrado o null si no existe
     */
    @Override
    public InstrumentoCuerda find(InstrumentoCuerda toFind) {
        if (!listaInstrumentoCuerda.isEmpty()) {
            for (InstrumentoCuerda instruCuerda : listaInstrumentoCuerda) {
                if (instruCuerda.getId().equals(toFind.getId())) {
                    System.out.println("COMPUTADOR IGUAL ENCONTRADO");
                    return instruCuerda;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza un instrumento de cuerda existente.
     * @param previo DTO del instrumento a reemplazar
     * @param nuevo DTO con los nuevos datos
     * @return true si se actualizó correctamente, false si no se encontró
     */
    @Override
    public boolean update(InstrumentoCuerdaDTO previo, InstrumentoCuerdaDTO nuevo) {
        InstrumentoCuerda entidadPrevio = DataMapper.dtoToInstrumentoCuerda(previo);
        InstrumentoCuerda entidadNuevo = DataMapper.dtoToInstrumentoCuerda(nuevo);
        InstrumentoCuerda encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaInstrumentoCuerda.remove(encontrado);
            listaInstrumentoCuerda.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve un listado en formato String de todos los instrumentos de cuerda.
     * @return String con la información de los instrumentos
     */
    @Override
    public String mostrar() {
        if (listaInstrumentoCuerda.isEmpty()) {
            return "No hay instrumentos de cuerda en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (InstrumentoCuerda instruCuerda : listaInstrumentoCuerda) {
            rta.append(instruCuerda.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de instrumentos de cuerda en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaInstrumentoCuerda);
    }

    /**
     * Lee la lista de instrumentos de cuerda desde un archivo serializado.
     */
    private void leerArchivoSerializado() {
        listaInstrumentoCuerda = (ArrayList<InstrumentoCuerda>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaInstrumentoCuerda == null) {
            listaInstrumentoCuerda = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de instrumentos de cuerda en un archivo CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (InstrumentoCuerda element : listaInstrumentoCuerda) {
            contenido += element.getNombre() + ";";
            contenido += element.getMarca() + ";";
            contenido += element.getTipoProducto() + ";";
            contenido += element.getDescripcion() + ";";
            contenido += element.getUrlImagen() + ";";
            contenido += element.getPrecio() + ";";
            contenido += element.getCantidad() + ";";
            contenido += element.getId() + ";";
            contenido += element.isIncluyeEstuche() + ";";
            contenido += element.getTipoInstrumentoCuerda() + ";";
            contenido += element.getNumeroCuerdas() + ";";
            contenido += element.getTipoCuerda() + ";";
            contenido += element.isTieneCajaResonancia() + "\n";
        }

        FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
    }

    /**
     * Carga la lista de instrumentos de cuerda desde un archivo CSV.
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
            boolean incluyeEstuche = Boolean.valueOf(columnas[8]);
            String tipoInstrumentoCuerda = columnas[9];
            int numeroCuerdas = Integer.parseInt(columnas[10]);
            String tipoCuerda = columnas[11];
            boolean tieneCajaResonancia = Boolean.valueOf(columnas[12]);
            listaInstrumentoCuerda
                    .add(new InstrumentoCuerda(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad,
                            id, incluyeEstuche, tipoInstrumentoCuerda, numeroCuerdas, tipoCuerda, tieneCajaResonancia));
        }
    }

}
