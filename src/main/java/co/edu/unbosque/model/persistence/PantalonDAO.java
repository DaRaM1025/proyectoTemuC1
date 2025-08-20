package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pantalon;
import co.edu.unbosque.model.PantalonDTO;
/**
 * Implementación del patrón Data Access Object (DAO) para la entidad {@link Pantalon}.
 * <p>
 * Esta clase gestiona las operaciones CRUD (crear, leer, actualizar, eliminar)
 * de objetos de tipo {@link Pantalon}, manteniendo la persistencia de los datos
 * en un archivo de texto (CSV) y en un archivo serializado (DAT).
 * </p>
 *
 * <p>Características principales:</p>
 * <ul>
 *   <li>Almacena en memoria los objetos en una lista interna.</li>
 *   <li>Sincroniza automáticamente los cambios con los archivos de persistencia.</li>
 *   <li>El criterio de unicidad de un pantalón está dado por su campo {@code id}.</li>
 * </ul>
 *
 * @author Nataly Rengifo
 * @version 1.0
 */
public class PantalonDAO implements OperacionDAO<PantalonDTO, Pantalon> {

	 /** Lista en memoria que almacena los pantalones disponibles. */
    private ArrayList<Pantalon> listaPantalon;

    /** Nombre del archivo serializado donde se almacenan los objetos. */
    private final String SERIAL_FILE_NAME = "pantaon.dat"; // Ojo: posible error de escritura ("pantalon.dat")

    /** Nombre del archivo de texto (CSV) donde se almacenan los objetos. */
    private final String TEXT_FILE_NAME = "pantalon.csv";

    /**
     * Constructor que inicializa la lista y carga los datos desde el archivo CSV.
      */

	public PantalonDAO() {
		listaPantalon= new ArrayList<>();
		cargarDesdeArchivo();
	}

	 /**
     * Obtiene la lista completa de pistolas de agua en memoria.
     *
     * @return lista de pistolas de agua.
     */
		public ArrayList<Pantalon> getListaPantalon() {
		return listaPantalon;
	}

	 /**
	     * Establece una nueva lista de pantalones.
	     *
	     * @param listaPantalon lista de pantalones a asignar.
	     */
	public void setListaPantalon(ArrayList<Pantalon> listaPantalon) {
		this.listaPantalon = listaPantalon;
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
     * Crea un nuevo pantalón en la lista, si no existe ya un objeto con el mismo ID.
     * <p>
     * Además de añadirlo en memoria, actualiza los archivos de texto y serializado.
     * </p>
     *
     * @param nuevo el objeto {@link PantalonDTO} que se desea agregar
     * @return {@code true} si la operación fue exitosa, {@code false} si ya existía
     */
	@Override
	public boolean crear(PantalonDTO nuevo) {
		Pantalon entidad = DataMapper.dtoToPantalon(nuevo);
		   Pantalon encontrado = find(entidad);

		    if (encontrado == null) {
		        listaPantalon.add(entidad);
		        System.out.println("EXITO" + listaPantalon.size());
		        escribirEnArchivo();
		        escribirArchivoSerializado();
		        return true;
		    }
		    System.out.println("PANTALON YA EXISTE");
		    return false;
	}
	/**
     * Elimina un pantalón de la lista, siempre que exista un objeto con el mismo ID.
     * <p>
     * También se actualizan los archivos de persistencia.
     * </p>
     *
     * @param eliminado el objeto {@link PantalonDTO} que se desea eliminar
     * @return {@code true} si se eliminó correctamente, {@code false} si no se encontró
     */
	@Override
	public boolean eliminar(PantalonDTO eliminado) {
		Pantalon entidad = DataMapper.dtoToPantalon(eliminado);
		Pantalon encontrado = find(entidad);
		if (encontrado != null) {
			listaPantalon.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	 /**
     * Busca un pantalón en la lista, comparando únicamente por su ID.
     *
     * @param toFind el objeto {@link Pantalon} con el ID a buscar
     * @return el objeto encontrado si existe, o {@code null} en caso contrario
     */
    @Override
	public Pantalon find(Pantalon toFind) {
		 if (!listaPantalon.isEmpty()) {
		        for (Pantalon cal : listaPantalon) {
		          if (cal.getId().equals(toFind.getId())) {
		                System.out.println("PANTALON IGUAL ENCONTRADO");
		                return cal;
		            }
		        }
		    }
		    return null;
	}

    /**
     * Actualiza un pantalón existente, reemplazándolo completamente
     * por una nueva versión.
     * <p>
     * Si no existe un objeto con el ID del previo, no se realiza ninguna modificación.
     * </p>
     *
     * @param previo el objeto {@link PantalonDTO} a reemplazar
     * @param nuevo el objeto {@link PantalonDTO} con los nuevos datos
     * @return {@code true} si la actualización fue exitosa, {@code false} si no se encontró el previo
     */
    @Override
	public boolean update(PantalonDTO previo, PantalonDTO nuevo) {
		Pantalon entidadPrevio = DataMapper.dtoToPantalon(previo);
		Pantalon entidadNuevo = DataMapper.dtoToPantalon(nuevo);
		Pantalon encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaPantalon.remove(encontrado);
			listaPantalon.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
    /**
     * Retorna un texto con la representación de todos los pantalones en la lista.
     *
     * @return un {@link String} con los objetos separados por saltos de línea,
     *         o el mensaje {@code "No hay pantalones en la lista"} si está vacía
     */
    @Override
	public String mostrar() {
		if (listaPantalon.isEmpty()) {
			return "No hay pantalones en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Pantalon cal : listaPantalon) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

    /**
     * Escribe la lista de pantalones en un archivo serializado.
     * <p>
     * Utiliza la clase {@link FileManager} para la operación de escritura.
     * </p>
     */
    	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPantalon);
	}
    	 /**
         * Lee el archivo serializado y carga los pantalones en memoria.
         * <p>
         * Si el archivo no existe o está vacío, la lista se inicializa como vacía.
         * </p>
         */
	private void leerArchivoSerializado() {
		listaPantalon = (ArrayList<Pantalon>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaPantalon == null) {
			listaPantalon = new ArrayList<>();
		}

	}
	  /**
     * Escribe el contenido de la lista en un archivo de texto (CSV).
     * <p>
     * El formato es separado por punto y coma {@code ;}, un registro por cada línea.
     * Los atributos que se almacenan son: nombre, marca, tipoProducto, descripción,
     * urlImagen, precio, cantidad, id, talla, género, material, tipoPantalon, corte y largo.
     * </p>
     */
	public void escribirEnArchivo() {
		String contenido = "";
		for (Pantalon element : listaPantalon) {
			contenido += element.getNombre() + ";";
			contenido += element.getMarca() + ";";
			contenido += element.getTipoProducto() + ";";
			contenido += element.getDescripcion() + ";";
			contenido += element.getUrlImagen() + ";";
			contenido += element.getPrecio() + ";";
			contenido += element.getCantidad() + ";";
			contenido += element.getId() + ";";
			contenido += element.getTalla() + ";";
			contenido += element.getGenero() + ";";
			contenido += element.getMaterial() + ";";
			contenido += element.getTipoPantalon() + ";";
			contenido += element.getCorte() + ";";
			contenido += element.getLargo() + "\n";

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
			String talla = columnas[8];
			String genero = columnas[9];
			String material = columnas[10];
			String tipoPantalon = columnas[11];
			String corte = columnas[12];
			String largo = columnas[13];


			listaPantalon.add(new Pantalon(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material, tipoPantalon, corte, largo));
		}
	}

}
