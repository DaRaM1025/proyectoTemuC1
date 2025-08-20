package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Calzado;
import co.edu.unbosque.model.CalzadoDTO;

/**
 * Clase que implementa el patrón DAO (Data Access Object) para gestionar
 * las operaciones CRUD relacionadas con la entidad {@link Calzado}.
 *
 * Esta clase permite persistir la información en archivos de texto y archivos
 * serializados, además de proporcionar mecanismos para crear, eliminar, actualizar
 * y consultar calzados.
 *
 * Implementa la interfaz {@link OperacionDAO} utilizando {@link CalzadoDTO} como
 * objeto de transferencia de datos y {@link Calzado} como entidad.
 *
 * @author Nataly Rengifo
 * @version 1.0
 */
public class CalzadoDAO implements OperacionDAO<CalzadoDTO, Calzado> {
	  /** Lista en memoria que almacena los objetos de tipo {@link Calzado}. */
    private ArrayList<Calzado> listaCalzado;

    /** Nombre del archivo donde se almacenan los objetos de forma serializada. */
    private final String SERIAL_FILE_NAME = "calzado.dat";

    /** Nombre del archivo de texto donde se almacenan los calzados en formato CSV. */
    private final String CALZADO_FILE_NAME = "calzado.csv";

    /**
     * Constructor que inicializa la lista de calzados y carga los datos
     * desde el archivo de texto correspondiente.
     */
	public CalzadoDAO() {
		listaCalzado= new ArrayList<>();
		cargarDesdeArchivo();
	}

    /**
     * Obtiene la lista completa de calzados en memoria.
     *
     * @return lista de calzados.
     */
	public ArrayList<Calzado> getListaCalzado() {
		return listaCalzado;
	}

    /**
     * Establece una nueva lista de calzados.
     *
     * @param listaCalzado lista de calzados a asignar.
     */
	public void setListaCalzado(ArrayList<Calzado> listaCalzado) {
		this.listaCalzado = listaCalzado;
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
     * Crea un nuevo calzado en la lista y lo persiste en los archivos.
     *
     * @param nuevo objeto {@link CalzadoDTO} con la información del calzado a crear.
     * @return true si el calzado fue creado exitosamente, false si ya existía.
     */
	@Override
	public boolean crear(CalzadoDTO nuevo) {
		Calzado entidad = DataMapper.dtoToCalzado(nuevo);
	   Calzado encontrado = find(entidad);

	    if (encontrado == null) {
	        listaCalzado.add(entidad);
	        System.out.println("EXITO" + listaCalzado.size());
	        escribirEnArchivo();
	        escribirArchivoSerializado();
	        return true;
	    }
	    System.out.println("CALZADO YA EXISTE");
	    return false;
	}
	/**
     * Elimina un calzado de la lista y actualiza los archivos de persistencia.
     *
     * @param eliminado objeto {@link CalzadoDTO} con el identificador del calzado a eliminar.
     * @return true si se eliminó exitosamente, false si no se encontró.
     */
	@Override
	public boolean eliminar(CalzadoDTO eliminado) {
		Calzado entidad = DataMapper.dtoToCalzado(eliminado);
		Calzado encontrado = find(entidad);
		if (encontrado != null) {
			listaCalzado.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	/**
     * Busca un calzado en la lista a partir de su identificador.
     *
     * @param toFind objeto {@link Calzado} con el ID a buscar.
     * @return el calzado encontrado, o null si no existe.
     */
	@Override
	public Calzado find(Calzado toFind) {
		 if (!listaCalzado.isEmpty()) {
		        for (Calzado cal : listaCalzado) {
		          if (cal.getId().equals(toFind.getId())) {
		                System.out.println("CALZADO IGUAL ENCONTRADO");
		                return cal;
		            }
		        }
		    }
		    return null;
	}
	 /**
     * Actualiza un calzado en la lista y refleja el cambio en los archivos de persistencia.
     *
     * @param previo calzado existente a reemplazar.
     * @param nuevo nuevo calzado que sustituye al anterior.
     * @return true si la actualización fue exitosa, false si no se encontró el calzado previo.
     */
	@Override
	public boolean update(CalzadoDTO previo, CalzadoDTO nuevo) {
		Calzado entidadPrevio = DataMapper.dtoToCalzado(previo);
		Calzado entidadNuevo = DataMapper.dtoToCalzado(nuevo);
		Calzado encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCalzado.remove(encontrado);
			listaCalzado.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}
	 /**
     * Devuelve una representación en texto de todos los calzados registrados.
     *
     * @return cadena con la información de todos los calzados, o un mensaje si la lista está vacía.
     */
	@Override
	public String mostrar() {
		if (listaCalzado.isEmpty()) {
			return "No hay calzados en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Calzado cal : listaCalzado) {
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
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCalzado);
	}
	/**
     * Lee el archivo serializado y carga las pistolas de agua en memoria.
     * <p>
     * Si el archivo no existe o está vacío, la lista se inicializa como vacía.
     * </p>
     */
	private void leerArchivoSerializado() {
		listaCalzado = (ArrayList<Calzado>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCalzado == null) {
			listaCalzado = new ArrayList<>();
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
		for (Calzado element : listaCalzado) {
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
			contenido += element.getTipoCalzado() + ";";
			contenido += element.getOcasion() + ";";
			contenido += element.getMaterialSuela() + ";";
			contenido += element.getAlturaSuela() + "\n";
		}

		FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
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
			String talla = columnas[8];
			String genero = columnas[9];
			String material = columnas[10];
			String tipoCalzado = columnas[11];
			String ocasion = columnas[12];
			String materialSuela = columnas[13];
			double alturaSuela = Double.parseDouble(columnas[14]);

			listaCalzado.add(new Calzado(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material, tipoCalzado, ocasion, materialSuela, alturaSuela));
		}
	}

}
