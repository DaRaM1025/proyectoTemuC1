package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Camiseta;
import co.edu.unbosque.model.Peluche;
import co.edu.unbosque.model.PelucheDTO;
/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@link Peluche}.
 * <p>
 * Esta clase gestiona las operaciones CRUD (crear, leer, actualizar, eliminar)
 * de objetos de tipo {@link Peluche}, manteniendo la persistencia de los datos
 * en un archivo de texto (CSV) y en un archivo serializado (DAT).
 * </p>
 *
 * <p>Características principales:</p>
 * <ul>
 *   <li>Almacena en memoria los objetos en una lista interna.</li>
 *   <li>Sincroniza automáticamente los cambios con los archivos de persistencia.</li>
 *   <li>El criterio de unicidad de un peluche está dado por su campo {@code id}.</li>
 * </ul>
 * 
 * @author Nataly Rengifo
 * @version 1.0
 */
public class PelucheDAO implements OperacionDAO<PelucheDTO, Peluche>{

	 /** Lista en memoria que almacena las camisetas disponibles. */
    private ArrayList<Peluche> listaPeluches; 
	
	/** Nombre del archivo serializado donde se almacenan los objetos. */
    	private final String SERIAL_FILE_NAME = "peluche.dat";
    	 
    	/** Nombre del archivo de texto (CSV) donde se almacenan los objetos. */
        private final String TEXT_FILE_NAME = "peluche.csv";
	
        /**
     * Constructor que inicializa la lista y carga los datos desde el archivo CSV,
      */
	public PelucheDAO() {
		listaPeluches = new ArrayList<>();
		cargarDesdeArchivo();
	}
	
	/**
     * Obtiene la lista completa de peluches en memoria.
     * 
     * @return lista de peluches.
     */
	
	public ArrayList<Peluche> getListaPeluches() {
		return listaPeluches;
	}


	/**
     * Establece una nueva lista de peluches.
     * 
     * @param listaPeluches lista de peluches a asignar.
     */
	public void setListaPeluches(ArrayList<Peluche> listaPeluches) {
		this.listaPeluches = listaPeluches;
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
     * Crea un nuevo peluche en el sistema.
     *
     * @param nuevo DTO del peluche a registrar
     * @return {@code true} si el peluche se creó con éxito, {@code false} si ya existía
     */
	@Override
	public boolean crear(PelucheDTO nuevo) {
		Peluche entidad = DataMapper.dtoToPeluche(nuevo);
		Peluche encontrado = find(entidad);

		if (encontrado == null) {
			listaPeluches.add(entidad);
			System.out.println("EXITO" + listaPeluches.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("PELUCHE YA EXISTE");
		return false;
	}
	/**
     * Elimina un peluche existente en el sistema.
     *
     * @param eliminado DTO del peluche a eliminar
     * @return {@code true} si fue eliminado, {@code false} si no se encontró
     */
	@Override
	public boolean eliminar(PelucheDTO eliminado) {
		Peluche entidad = DataMapper.dtoToPeluche(eliminado);
		Peluche encontrado = find(entidad);
		if (encontrado != null) {
			listaPeluches.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	 /**
     * Busca un peluche en la lista en memoria.
     *
     * @param toFind peluche con el ID a buscar
     * @return el peluche encontrado o {@code null} si no existe
     */
	@Override
	public Peluche find(Peluche toFind) {
		if (!listaPeluches.isEmpty()) {
			for (Peluche cal : listaPeluches) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("PELUCHE IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

    /**
     * Actualiza la información de un peluche.
     *
     * @param previo DTO con la información actual
     * @param nuevo DTO con la información nueva
     * @return {@code true} si se actualizó, {@code false} si no se encontró
     */
	@Override
	public boolean update(PelucheDTO previo, PelucheDTO nuevo) {
		Peluche entidadPrevio = DataMapper.dtoToPeluche(previo);
		Peluche entidadNuevo = DataMapper.dtoToPeluche(nuevo);
		Peluche encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaPeluches.remove(encontrado);
			listaPeluches.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	   /**
     * Muestra todos los peluches en la lista.
     *
     * @return cadena con la representación de todos los peluches,
     *         o un mensaje si no hay elementos
     */
	@Override
	public String mostrar() {
		if (listaPeluches.isEmpty()) {
			return "No hay peluches en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Peluche cal : listaPeluches) {
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
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPeluches);
	}
	/**
     * Lee el archivo serializado y carga las pistolas de agua en memoria.
     * <p>
     * Si el archivo no existe o está vacío, la lista se inicializa como vacía.
     * </p>
     */
	private void leerArchivoSerializado() {
		listaPeluches = (ArrayList<Peluche>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaPeluches == null) {
			listaPeluches = new ArrayList<>();
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
		for (int i = 0; i < listaPeluches.size(); i++) {
			contenido += listaPeluches.get(i).getNombre() + ";";
			contenido += listaPeluches.get(i).getMarca() + ";";
			contenido += listaPeluches.get(i).getTipoProducto() + ";";
			contenido += listaPeluches.get(i).getDescripcion() + ";";
			contenido += listaPeluches.get(i).getUrlImagen() + ";";
			contenido += listaPeluches.get(i).getPrecio() + ";";
			contenido += listaPeluches.get(i).getCantidad() + ";";
			contenido += listaPeluches.get(i).getId() + ";";
			contenido += listaPeluches.get(i).getEdadRecomendada() + ";";
			contenido += listaPeluches.get(i).isTieneSonido() + ";";
			contenido += listaPeluches.get(i).getTipoRelleno() + ";";
			contenido += listaPeluches.get(i).isLavadoMaquina() +"\n";

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
			int edadRecomendada = Integer.parseInt(columnas[8]);
			boolean tieneSonido= Boolean.parseBoolean(columnas[9]);
			String tipoRelleno = columnas[10];
			boolean lavadoMaquina= Boolean.parseBoolean(columnas[11])
			;
			listaPeluches.add(new Peluche(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada, tieneSonido, tipoRelleno, lavadoMaquina));
					
		}
	}
	
	
}
