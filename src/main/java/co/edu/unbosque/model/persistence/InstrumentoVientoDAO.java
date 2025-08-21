package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InstrumentoViento;
import co.edu.unbosque.model.InstrumentoVientoDTO;

/**
 * Clase DAO para gestionar la persistencia de objetos {@link InstrumentoViento}.
 * Permite operaciones CRUD y persistencia tanto en archivos CSV como serializados.
 */
public class InstrumentoVientoDAO implements OperacionDAO<InstrumentoVientoDTO, InstrumentoViento> {

    /** Lista de instrumentos de viento en memoria */
    private ArrayList<InstrumentoViento> listaInstrumentoViento;

    /** Nombre del archivo serializado */
    private final String SERIAL_FILE_NAME = "instrumentoviento.dat";

    /** Nombre del archivo CSV */
    private final String CALZADO_FILE_NAME = "instrumentoviento.csv";

    /**
     * Constructor que inicializa la lista de instrumentos y carga los datos desde archivo.
     */
    public InstrumentoVientoDAO() {
        listaInstrumentoViento = new ArrayList<>();
        cargarDesdeArchivo();
    }

    /**
     * Obtiene la lista de instrumentos de viento.
     * @return lista de instrumentos de viento
     */
    public ArrayList<InstrumentoViento> getListaInstrumentoViento() {
        return listaInstrumentoViento;
    }

    /**
     * Asigna una lista de instrumentos de viento.
     * @param listaInstrumentoViento lista a asignar
     */
    public void setListaInstrumentoViento(ArrayList<InstrumentoViento> listaInstrumentoViento) {
        this.listaInstrumentoViento = listaInstrumentoViento;
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
     * Crea un nuevo instrumento de viento.
     * @param nuevo DTO del instrumento a crear
     * @return true si se creó correctamente, false si ya existía
     */
    @Override
    public boolean crear(InstrumentoVientoDTO nuevo) {
        InstrumentoViento entidad = DataMapper.dtoToInstrumentoViento(nuevo);
        InstrumentoViento encontrado = find(entidad);

        if (encontrado == null) {
            listaInstrumentoViento.add(entidad);
            System.out.println("EXITO" + listaInstrumentoViento.size());
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("INSTRUMENTO VIENTO YA EXISTE");
        return false;
    }

    /**
     * Elimina un instrumento de viento existente.
     * @param eliminado DTO del instrumento a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    @Override
    public boolean eliminar(InstrumentoVientoDTO eliminado) {
        InstrumentoViento entidad = DataMapper.dtoToInstrumentoViento(eliminado);
        InstrumentoViento encontrado = find(entidad);
        if (encontrado != null) {
            listaInstrumentoViento.remove(encontrado);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un instrumento de viento por su ID.
     * @param toFind instrumento a buscar
     * @return el instrumento encontrado o null si no existe
     */
    @Override
    public InstrumentoViento find(InstrumentoViento toFind) {
        if (!listaInstrumentoViento.isEmpty()) {
            for (InstrumentoViento instruViento : listaInstrumentoViento) {
                if (instruViento.getId().equals(toFind.getId())) {
                    System.out.println("INSTRUMENTO VIENTO IGUAL ENCONTRADO");
                    return instruViento;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza un instrumento de viento existente.
     * @param previo DTO del instrumento a reemplazar
     * @param nuevo DTO con los nuevos datos
     * @return true si se actualizó correctamente, false si no se encontró
     */
    @Override
    public boolean update(InstrumentoVientoDTO previo, InstrumentoVientoDTO nuevo) {
        InstrumentoViento entidadPrevio = DataMapper.dtoToInstrumentoViento(previo);
        InstrumentoViento entidadNuevo = DataMapper.dtoToInstrumentoViento(nuevo);
        InstrumentoViento encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaInstrumentoViento.remove(encontrado);
            listaInstrumentoViento.add(entidadNuevo);
            escribirEnArchivo();
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve un listado en formato String de todos los instrumentos.
     * @return String con la información de los instrumentos
     */
    @Override
    public String mostrar() {
        if (listaInstrumentoViento.isEmpty()) {
            return "No hay instrumentos de viento en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (InstrumentoViento instruViento : listaInstrumentoViento) {
            rta.append(instruViento.toString()).append("\n");
        }
        return rta.toString();
    }

    /**
     * Escribe la lista de instrumentos en un archivo serializado.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaInstrumentoViento);
    }

    /**
     * Lee la lista de instrumentos desde un archivo serializado.
     */
    private void leerArchivoSerializado() {
        listaInstrumentoViento = (ArrayList<InstrumentoViento>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaInstrumentoViento == null) {
            listaInstrumentoViento = new ArrayList<>();
        }
    }

    /**
     * Escribe la lista de instrumentos en un archivo CSV.
     */
    public void escribirEnArchivo() {
        String contenido = "";
        for (InstrumentoViento element : listaInstrumentoViento) {
            contenido += element.getNombre() + ";";
            contenido += element.getMarca() + ";";
            contenido += element.getTipoProducto() + ";";
            contenido += element.getDescripcion() + ";";
            contenido += element.getUrlImagen() + ";";
            contenido += element.getPrecio() + ";";
            contenido += element.getCantidad() + ";";
            contenido += element.getId() + ";";
            contenido += element.isIncluyeEstuche() + ";";
            contenido += element.getTipoInstrumentoViento() + ";";
            contenido += element.getAfinacion() + ";";
            contenido += element.getNumeroValvulas() + ";";
            contenido += element.isRequiereBoquilla() + "\n";
        }

        FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
    }

    /**
     * Carga la lista de instrumentos desde un archivo CSV.
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
            String tipoInstrumentoViento = columnas[9];
            String afinacion = columnas[10];
            int numeroValvulas = Integer.parseInt(columnas[11]);
            boolean requiereBoquilla = Boolean.valueOf(columnas[12]);
            listaInstrumentoViento
                    .add(new InstrumentoViento(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad,
                            id, incluyeEstuche, tipoInstrumentoViento, afinacion, numeroValvulas, requiereBoquilla));
        }
    }

}
