package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.PistolaAgua;
import co.edu.unbosque.model.PistolaAguaDTO;
/**
 * Implementación de un Data Access Object (DAO) para la entidad {@link PistolaAgua}.
 * <p>
 * Esta clase permite realizar operaciones CRUD (crear, leer, actualizar, eliminar)
 * sobre objetos de tipo {@link PistolaAgua}, gestionando la persistencia de los datos
 * tanto en un archivo de texto (CSV) como en un archivo serializado (DAT).
 * </p>
 *
 * <p>Características principales:</p>
 * <ul>
 *   <li>Almacena en memoria los objetos en una lista interna.</li>
 *   <li>Sincroniza automáticamente los cambios con los archivos de persistencia.</li>
 *   <li>El criterio de unicidad de una pistola de agua está dado por su campo {@code id}.</li>
 * </ul>
 *
 * @author Nataly Rengifo
 * @version 1.0
 */
public class PistolaAguaDAO implements OperacionDAO<PistolaAguaDTO, PistolaAgua>{

    /** Lista en memoria que almacena las pistolas de agua disponibles. */
    private ArrayList<PistolaAgua> listaPistola;

    /** Nombre del archivo serializado donde se almacenan los objetos. */
    private final String SERIAL_FILE_NAME = "pistola.dat";

    /** Nombre del archivo de texto (CSV) donde se almacenan los objetos. */
    private final String TEXT_FILE_NAME = "pistola.csv";

    /**
     * Constructor que inicializa la lista y carga los datos desde el archivo CSV.
     */
	public PistolaAguaDAO() {
		listaPistola = new ArrayList<>();
		cargarDesdeArchivo();
	}


    /**
     * Obtiene la lista completa de pistolas de agua en memoria.
     *
     * @return lista de pistolas de agua.
     */
	public ArrayList<PistolaAgua> getListaPistola() {
		return listaPistola;
	}

	/**
     * Establece una nueva lista de pistolas.
     *
     * @param listaPistola lista de pistolas a asignar.
     */
	public void setListaPistola(ArrayList<PistolaAgua> listaPistola) {
		this.listaPistola = listaPistola;
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
	public String getTEXT_FILE_NAME() {
		return TEXT_FILE_NAME;
	}


	/**
     * Crea una nueva pistola de agua en la lista, si no existe ya un objeto con el mismo ID.
     * <p>
     * Además de añadirla en memoria, actualiza los archivos de texto y serializado.
     * </p>
     *
     * @param nuevo el objeto {@link PistolaAguaDTO} que se desea agregar
     * @return {@code true} si la operación fue exitosa, {@code false} si ya existía
     */
	@Override
	public boolean crear(PistolaAguaDTO nuevo) {
		PistolaAgua entidad = DataMapper.dtoToPistolaAgua(nuevo);
		PistolaAgua encontrado = find(entidad);

		if (encontrado == null) {
			listaPistola.add(entidad);
			System.out.println("EXITO" + listaPistola.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("PISTOLA DE AGUA YA EXISTE");
		return false;
	}
	 /**
     * Elimina una pistola de agua de la lista, siempre que exista un objeto con el mismo ID.
     * <p>
     * También se actualizan los archivos de persistencia.
     * </p>
     *
     * @param eliminado el objeto {@link PistolaAguaDTO} que se desea eliminar
     * @return {@code true} si se eliminó correctamente, {@code false} si no se encontró
     */
	@Override
	public boolean eliminar(PistolaAguaDTO eliminado) {
		PistolaAgua entidad = DataMapper.dtoToPistolaAgua(eliminado);
		PistolaAgua encontrado = find(entidad);
		if (encontrado != null) {
			listaPistola.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	/**
     * Busca una pistola de agua en la lista, comparando únicamente por su ID.
     *
     * @param toFind el objeto {@link PistolaAgua} con el ID a buscar
     * @return el objeto encontrado si existe, o {@code null} en caso contrario
     */
	@Override
	public PistolaAgua find(PistolaAgua toFind) {
		if (!listaPistola.isEmpty()) {
			for (PistolaAgua cal : listaPistola) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("PISTOLA AGUA IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}
	 /**
     * Actualiza una pistola de agua existente, reemplazándola completamente
     * por una nueva versión.
     * <p>
     * Si no existe un objeto con el ID del previo, no se realiza ninguna modificación.
     * </p>
     *
     * @param previo el objeto {@link PistolaAguaDTO} a reemplazar
     * @param nuevo el objeto {@link PistolaAguaDTO} con los nuevos datos
     * @return {@code true} si la actualización fue exitosa, {@code false} si no se encontró el previo
     */
	@Override
	public boolean update(PistolaAguaDTO previo, PistolaAguaDTO nuevo) {
		PistolaAgua entidadPrevio = DataMapper.dtoToPistolaAgua(previo);
		PistolaAgua entidadNuevo = DataMapper.dtoToPistolaAgua(nuevo);
		PistolaAgua encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaPistola.remove(encontrado);
			listaPistola.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	 /**
     * Retorna un texto con la representación de todas las pistolas de agua en la lista.
     *
     * @return un {@link String} con los objetos separados por saltos de línea,
     *         o el mensaje {@code "No hay pistolas de agua en la lista"} si está vacía
     */
	@Override
	public String mostrar() {
		if (listaPistola.isEmpty()) {
			return "No hay pistolas de agua en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (PistolaAgua cal : listaPistola) {
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
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPistola);
	}
	/**
     * Lee el archivo serializado y carga las pistolas de agua en memoria.
     * <p>
     * Si el archivo no existe o está vacío, la lista se inicializa como vacía.
     * </p>
     */
	private void leerArchivoSerializado() {
		listaPistola = (ArrayList<PistolaAgua>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaPistola == null) {
			listaPistola = new ArrayList<>();
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
		for (PistolaAgua element : listaPistola) {
			contenido += element.getNombre() + ";";
			contenido += element.getMarca() + ";";
			contenido += element.getTipoProducto() + ";";
			contenido += element.getDescripcion() + ";";
			contenido += element.getUrlImagen() + ";";
			contenido += element.getPrecio() + ";";
			contenido += element.getCantidad() + ";";
			contenido += element.getId() + ";";
			contenido += element.getEdadRecomendada() + ";";
			contenido += element.getCapacidadAgua() + ";";
			contenido += element.getCantidadChorros() + ";";
			contenido += element.getAlcanceMaximo()+"\n";

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
			double capacidadAgua = Double.parseDouble(columnas[9]);
			int cantidadChorros = Integer.parseInt(columnas[10]);
			double alcanceMaximo= Double.parseDouble(columnas[11])
			;
			listaPistola.add(new PistolaAgua(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada, capacidadAgua, cantidadChorros, alcanceMaximo) );

		}
	}


}
