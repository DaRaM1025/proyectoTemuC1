package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Lego;
import co.edu.unbosque.model.LegoDTO;
/**
 * Clase {@code LegoDAO} que implementa las operaciones CRUD para la gestión de objetos {@link Lego}.
 * <p>
 * Esta clase utiliza archivos de texto (CSV) y archivos serializados para
 * la persistencia de datos. El mapeo entre {@link LegoDTO} y {@link Lego} se realiza
 * mediante la clase {@link DataMapper}.
 * </p>
 *
 * <p>Características principales:</p>
 * <ul>
 *   <li>Permite crear, actualizar, eliminar y buscar objetos Lego.</li>
 *   <li>Almacena los datos en memoria y los sincroniza con archivos de texto y binarios.</li>
 *   <li>Utiliza un archivo CSV para almacenamiento legible y un archivo serializado para respaldo.</li>
 * </ul>
 *
 * @author Nataly Rengifo
 * @version 1.0
 */
public class LegoDAO implements OperacionDAO<LegoDTO, Lego> {
	  /** Lista en memoria que contiene los objetos Lego gestionados. */
    private ArrayList<Lego> listaLego;

    /** Nombre del archivo serializado utilizado para persistencia. */
    private final String SERIAL_FILE_NAME = "lego.dat";

    /** Nombre del archivo de texto (CSV) utilizado para persistencia. */
    private final String TEXT_FILE_NAME = "lego.csv";

    /**
     * Constructor que inicializa la lista y carga los datos desde el archivo de texto.
     */
	public LegoDAO() {
		listaLego = new ArrayList<>();
		cargarDesdeArchivo();
	}
	 /**
     * Obtiene la lista de objetos Lego en memoria.
     *
     * @return lista de legos almacenados en memoria.
     */
    public ArrayList<Lego> getListaLego() {
        return listaLego;
    }

    /**
     * Asigna una nueva lista de objetos Lego en memoria.
     *
     * @param listaLego lista de legos a establecer.
     */
    public void setListaLego(ArrayList<Lego> listaLego) {
        this.listaLego = listaLego;
    }

    /**
     * Obtiene el nombre del archivo serializado.
     *
     * @return nombre del archivo {@code .dat}.
     */
    public String getSERIAL_FILE_NAME() {
        return SERIAL_FILE_NAME;
    }

    /**
     * Obtiene el nombre del archivo de texto.
     *
     * @return nombre del archivo {@code .csv}.
     */
    public String getTEXT_FILE_NAME() {
        return TEXT_FILE_NAME;
    }

    /**
     * Crea un nuevo objeto Lego en memoria y lo guarda en los archivos de persistencia.
     *
     * @param nuevo DTO con la información del nuevo Lego.
     * @return {@code true} si la creación fue exitosa, {@code false} si ya existía.
     */
	@Override
	public boolean crear(LegoDTO nuevo) {
		Lego entidad = DataMapper.dtoToLego(nuevo);
		Lego encontrado = find(entidad);

		if (encontrado == null) {
			listaLego.add(entidad);
			System.out.println("EXITO" + listaLego.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("LEGO YA EXISTE");
		return false;
	}
	 /**
     * Elimina un objeto Lego de la lista y actualiza los archivos de persistencia.
     *
     * @param eliminado DTO del Lego a eliminar.
     * @return {@code true} si fue eliminado, {@code false} si no se encontró.
     */
	@Override
	public boolean eliminar(LegoDTO eliminado) {
		Lego entidad = DataMapper.dtoToLego(eliminado);
		Lego encontrado = find(entidad);
		if (encontrado != null) {
			listaLego.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}


    /**
     * Busca un Lego en la lista por su ID.
     *
     * @param toFind Lego con el ID a buscar.
     * @return el Lego encontrado o {@code null} si no existe.
     */
    @Override
	public Lego find(Lego toFind) {
		if (!listaLego.isEmpty()) {
			for (Lego cal : listaLego) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("LEGO IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}
    /**
     * Actualiza un Lego existente en la lista y en los archivos de persistencia.
     *
     * @param previo DTO con los datos actuales.
     * @param nuevo DTO con los nuevos datos.
     * @return {@code true} si se actualizó correctamente, {@code false} si no se encontró.
     */
    @Override
	public boolean update(LegoDTO previo, LegoDTO nuevo) {
		Lego entidadPrevio = DataMapper.dtoToLego(previo);
		Lego entidadNuevo = DataMapper.dtoToLego(nuevo);
		Lego encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaLego.remove(encontrado);
			listaLego.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}


    /**
     * Muestra la lista completa de legos en formato de texto.
     *
     * @return cadena con todos los legos o un mensaje si la lista está vacía.
     */
    @Override
	public String mostrar() {
		if (listaLego.isEmpty()) {
			return "No hay legos en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Lego cal : listaLego) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	/**
     * Escribe la lista de pistolas de agua en un archivo serializado.
     * <p>
     * Utiliza la clase {@link FileManager} para la operación de escritura.
     * </p>
     */
	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaLego);
	}
	/**
     * Lee el archivo serializado y carga las pistolas de agua en memoria.
     * <p>
     * Si el archivo no existe o está vacío, la lista se inicializa como vacía.
     * </p>
     */
	private void leerArchivoSerializado() {
		listaLego = (ArrayList<Lego>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaLego == null) {
			listaLego = new ArrayList<>();
		}

	}
	/**
     * Escribe el contenido de la lista en un archivo de texto (CSV).
     * <p>
     * El formato es separado por punto y coma {@code ;}, un registro por cada línea.
     * </p>
     */
	public void escribirEnArchivo() {
		String contenido = "";
		for (Lego element : listaLego) {
			contenido += element.getNombre() + ";";
			contenido += element.getMarca() + ";";
			contenido += element.getTipoProducto() + ";";
			contenido += element.getDescripcion() + ";";
			contenido += element.getUrlImagen() + ";";
			contenido += element.getPrecio() + ";";
			contenido += element.getCantidad() + ";";
			contenido += element.getId() + ";";
			contenido += element.getEdadRecomendada() + ";";
			contenido += element.getTema() + ";";
			contenido += element.getNumeroPiezas() + ";";
			contenido += element.isTieneMinifiguras() +"\n";

		}

		FileManager.escribirEnArchivoTexto(TEXT_FILE_NAME, contenido);
	}
	/**
     * Carga los objetos desde un archivo de texto (CSV) y los añade a la lista en memoria.
     * <p>
     * Se espera que el archivo tenga el mismo formato que produce {@link #escribirEnArchivo()}.
     * </p>
     * <p>
     * En caso de que el archivo esté vacío, no se carga ningún dato.
     * </p>
     */
	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(TEXT_FILE_NAME);

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
			int edadRecomendada = Integer.parseInt(columnas[8]);
			String tema = columnas[9];
			int numeroPiezas = Integer.parseInt(columnas[10]);
			boolean tieneMinifiguras= Boolean.parseBoolean(columnas[11])
			;
			listaLego.add(new Lego(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada, tema, numeroPiezas, tieneMinifiguras));

		}
	}

}
