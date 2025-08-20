package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Sombra;
import co.edu.unbosque.model.SombraDTO;

public class SombraDAO implements OperacionDAO<SombraDTO, Sombra> {

	private ArrayList<Sombra> listaSombras;
	private final String SERIAL_FILE_NAME = "Sombra.dat";
	private final String SOMBRAS_FILE_NAME = "Sombra.csv";

	public SombraDAO() {
		listaSombras = new ArrayList<>();
		cargarDesdeArchivo();
	}

	@Override
	public boolean crear(SombraDTO nuevo) {
		Sombra entidad = DataMapper.dtoToSombra(nuevo);
		Sombra encontrado = find(entidad);

		if (encontrado == null) {
			listaSombras.add(entidad);
			System.out.println("EXITO" + listaSombras.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("Sombra YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(SombraDTO eliminado) {
		Sombra entidad = DataMapper.dtoToSombra(eliminado);
		Sombra encontrado = find(entidad);
		if (encontrado != null) {
			listaSombras.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Sombra find(Sombra toFind) {
		if (!listaSombras.isEmpty()) {
			for (Sombra cal : listaSombras) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("Sombra IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(SombraDTO previo, SombraDTO nuevo) {
		Sombra entidadPrevio = DataMapper.dtoToSombra(previo);
		Sombra entidadNuevo = DataMapper.dtoToSombra(nuevo);
		Sombra encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaSombras.remove(encontrado);
			listaSombras.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaSombras.isEmpty()) {
			return "No hay Sombras en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Sombra cal : listaSombras) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaSombras);
	}

	private void leerArchivoSerializado() {
		listaSombras = (ArrayList<Sombra>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaSombras == null) {
			listaSombras = new ArrayList<>();
		}
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (Sombra element : listaSombras) {
			contenido += element.getNombre() + ";";
			contenido += element.getMarca() + ";";
			contenido += element.getTipoProducto() + ";";
			contenido += element.getDescripcion() + ";";
			contenido += element.getUrlImagen() + ";";
			contenido += element.getPrecio() + ";";
			contenido += element.getCantidad() + ";";
			contenido += element.getId() + ";";
			contenido += element.getTipoPiel() + ";";
			contenido += element.isEsApruebaDeAgua() + ";";
			contenido += element.getFechaVencimiento() + ";";
			contenido += element.getCantidadColores() + ";";
			contenido += element.getAcabado() + "\n";
		}
		FileManager.escribirEnArchivoTexto(SOMBRAS_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(SOMBRAS_FILE_NAME);

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
			String tipoPiel = columnas[8];
			boolean pruebaAgua = Boolean.parseBoolean(columnas[9]);
			String fechaVencimiento = columnas[10];
			int cantColores = Integer.parseInt(columnas[11]);
			String acabado = columnas[12];

			listaSombras.add(new Sombra(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
					tipoPiel, pruebaAgua, fechaVencimiento, cantColores, acabado));
		}
	}

	public ArrayList<Sombra> getlistaSombras() {
		return listaSombras;
	}

	public void setlistaSombras(ArrayList<Sombra> listaSombras) {
		this.listaSombras = listaSombras;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getSombra_FILE_NAME() {
		return SOMBRAS_FILE_NAME;
	}

}