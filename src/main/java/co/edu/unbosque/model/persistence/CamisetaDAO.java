package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Camiseta;
import co.edu.unbosque.model.CamisetaDTO;
/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@link Camiseta}.
 * <p>
 * Esta clase gestiona las operaciones CRUD (crear, leer, actualizar, eliminar)
 * de objetos de tipo {@link Camiseta}, manteniendo la persistencia de los datos
 * en un archivo de texto (CSV) y en un archivo serializado (DAT).
 * </p>
 *
 * <p>Características principales:</p>
 * <ul>
 *   <li>Almacena en memoria los objetos en una lista interna.</li>
 *   <li>Sincroniza automáticamente los cambios con los archivos de persistencia.</li>
 *   <li>El criterio de unicidad de una camiseta está dado por su campo {@code id}.</li>
 * </ul>
 * 
 * @author Nataly Rengifo
 * @version 1.0
 */
public class CamisetaDAO implements OperacionDAO<CamisetaDTO, Camiseta> {
	 /** Lista en memoria que almacena las camisetas disponibles. */
    private ArrayList<Camiseta> listaCamiseta;

    /** Nombre del archivo serializado donde se almacenan los objetos. */
    private final String SERIAL_FILE_NAME = "camiseta.dat";

    /** Nombre del archivo de texto (CSV) donde se almacenan los objetos. */
    private final String TEXT_FILE_NAME = "camiseta.csv";

    /**
     * Constructor que inicializa la lista y carga los datos desde el archivo CSV,
      */
	public CamisetaDAO() {
		listaCamiseta = new ArrayList<>();
		cargarDesdeArchivo();
	}
	
	/**
     * Obtiene la lista completa de camisetas en memoria.
     * 
     * @return lista de camisetas.
     */
	public ArrayList<Camiseta> getListaCamiseta() {
		return listaCamiseta;
	}

	/**
     * Establece una nueva lista de camisetas.
     * 
     * @param listaCamiseta lista de camisetas a asignar.
     */
	public void setListaCamiseta(ArrayList<Camiseta> listaCamiseta) {
		this.listaCamiseta = listaCamiseta;
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
     * Crea una nueva camiseta en la lista, si no existe ya un objeto con el mismo ID.
     * <p>
     * Además de añadirla en memoria, actualiza los archivos de texto y serializado.
     * </p>
     *
     * @param nuevo el objeto {@link CamisetaDTO} que se desea agregar
     * @return {@code true} si la operación fue exitosa, {@code false} si ya existía
     */
	@Override
	public boolean crear(CamisetaDTO nuevo) {
		Camiseta entidad = DataMapper.dtoToCamiseta(nuevo);
		Camiseta encontrado = find(entidad);

		if (encontrado == null) {
			listaCamiseta.add(entidad);
			System.out.println("EXITO" + listaCamiseta.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("CAMISETA YA EXISTE");
		return false;
	}
	/**
     * Elimina una camiseta de la lista, siempre que exista un objeto con el mismo ID.
     * <p>
     * También se actualizan los archivos de persistencia.
     * </p>
     *
     * @param eliminado el objeto {@link CamisetaDTO} que se desea eliminar
     * @return {@code true} si se eliminó correctamente, {@code false} si no se encontró
     */
	@Override
	public boolean eliminar(CamisetaDTO eliminado) {
		Camiseta entidad = DataMapper.dtoToCamiseta(eliminado);
		Camiseta encontrado = find(entidad);
		if (encontrado != null) {
			listaCamiseta.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	 /**
     * Busca una camiseta en la lista, comparando únicamente por su ID.
     *
     * @param toFind el objeto {@link Camiseta} con el ID a buscar
     * @return el objeto encontrado si existe, o {@code null} en caso contrario
     */
	@Override
	public Camiseta find(Camiseta toFind) {
		if (!listaCamiseta.isEmpty()) {
			for (Camiseta cal : listaCamiseta) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("CAMISETA IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}
	 /**
     * Actualiza una camiseta existente, reemplazándola completamente
     * por una nueva versión.
     * <p>
     * Si no existe un objeto con el ID del previo, no se realiza ninguna modificación.
     * </p>
     *
     * @param previo el objeto {@link CamisetaDTO} a reemplazar
     * @param nuevo el objeto {@link CamisetaDTO} con los nuevos datos
     * @return {@code true} si la actualización fue exitosa, {@code false} si no se encontró el previo
     */
	@Override
	public boolean update(CamisetaDTO previo, CamisetaDTO nuevo) {
		Camiseta entidadPrevio = DataMapper.dtoToCamiseta(previo);
		Camiseta entidadNuevo = DataMapper.dtoToCamiseta(nuevo);
		Camiseta encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCamiseta.remove(encontrado);
			listaCamiseta.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	/**
     * Retorna un texto con la representación de todas las camisetas en la lista.
     *
     * @return un {@link String} con los objetos separados por saltos de línea,
     *         o el mensaje {@code "No hay camisetas en la lista"} si está vacía
     */
	@Override
	public String mostrar() {
		if (listaCamiseta.isEmpty()) {
			return "No hay camisetas en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Camiseta cal : listaCamiseta) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}
	/**
     * Escribe la lista de camisetas en un archivo serializado.
     * <p>
     * Utiliza la clase {@link FileManager} para la operación de escritura.
     * </p>
     */
	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCamiseta);
	}
	   /**
     * Lee el archivo serializado y carga las camisetas en memoria.
     * <p>
     * Si el archivo no existe o está vacío, la lista se inicializa como vacía.
     * </p>
     */
	private void leerArchivoSerializado() {
		listaCamiseta = (ArrayList<Camiseta>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCamiseta == null) {
			listaCamiseta = new ArrayList<>();
		}

	}
	 /**
     * Escribe el contenido de la lista en un archivo de texto (CSV).
     * <p>
     * El formato es separado por punto y coma {@code ;}, un registro por cada línea.
     * Los atributos que se almacenan son: nombre, marca, tipoProducto, descripción,
     * urlImagen, precio, cantidad, id, talla, género, material, tipoManga, cuello y estampado.
     * </p>
     */
	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaCamiseta.size(); i++) {
			contenido += listaCamiseta.get(i).getNombre() + ";";
			contenido += listaCamiseta.get(i).getMarca() + ";";
			contenido += listaCamiseta.get(i).getTipoProducto() + ";";
			contenido += listaCamiseta.get(i).getDescripcion() + ";";
			contenido += listaCamiseta.get(i).getUrlImagen() + ";";
			contenido += listaCamiseta.get(i).getPrecio() + ";";
			contenido += listaCamiseta.get(i).getCantidad() + ";";
			contenido += listaCamiseta.get(i).getId() + ";";
			contenido += listaCamiseta.get(i).getTalla() + ";";
			contenido += listaCamiseta.get(i).getGenero() + ";";
			contenido += listaCamiseta.get(i).getMaterial() + ";";
			contenido += listaCamiseta.get(i).getTipoManga() + ";";
			contenido += listaCamiseta.get(i).getCuello() + ";";
			contenido += listaCamiseta.get(i).isEstampado() + "\n";

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
     *
     */
	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(TEXT_FILE_NAME);

		if (contenido.isBlank() || contenido.isEmpty()) {
			return;
		}

		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			String nombre = columnas[0];
			String marca = columnas[1];
			String tipoProducto = columnas[2];
			String descripcion = columnas[3];
			String urlImagen = columnas[4];
			double precio = Double.parseDouble(columnas[5]);
			int cantidad = Integer.parseInt(columnas[6]);
			String id = columnas[7];
			String talla = columnas[8];
			String genero = columnas[9];
			String material = columnas[10];
			String tipoManga = columnas[11];
			String cuello = columnas[12];
			boolean isEstampado = Boolean.parseBoolean(columnas[13]);

			;
			listaCamiseta.add(new Camiseta(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material, tipoManga, cuello, isEstampado));
					
		}
	}

}
