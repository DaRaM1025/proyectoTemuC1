package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Labial;
import co.edu.unbosque.model.LabialDTO;

public class LabialDAO implements OperacionDAO<LabialDTO, Labial> {

	private ArrayList<Labial> listaLabiales;
	private final String SERIAL_FILE_NAME = "labial.dat";
	private final String LABIAL_FILE_NAME = "labial.csv";

	public LabialDAO() {
		listaLabiales = new ArrayList<Labial>();
		cargarDesdeArchivo();
	}

	@Override
	public boolean crear(LabialDTO nuevo) {
		Labial entidad = DataMapper.dtoToLabial(nuevo);
		Labial encontrado = find(entidad);

		if (encontrado == null) {
			listaLabiales.add(entidad);
			System.out.println("EXITO" + listaLabiales.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("Labial YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(LabialDTO eliminado) {
		Labial entidad = DataMapper.dtoToLabial(eliminado);
		Labial encontrado = find(entidad);
		if (encontrado != null) {
			listaLabiales.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Labial find(Labial toFind) {
		if (!listaLabiales.isEmpty()) {
			for (Labial cal : listaLabiales) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("Labial IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(LabialDTO previo, LabialDTO nuevo) {
		Labial entidadPrevio = DataMapper.dtoToLabial(previo);
		Labial entidadNuevo = DataMapper.dtoToLabial(nuevo);
		Labial encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaLabiales.remove(encontrado);
			listaLabiales.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaLabiales.isEmpty()) {
			return "No hay Labials en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Labial cal : listaLabiales) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaLabiales);
	}

	private void leerArchivoSerializado() {
		listaLabiales = (ArrayList<Labial>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaLabiales == null) {
			listaLabiales = new ArrayList<>();
		}
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaLabiales.size(); i++) {
			contenido += listaLabiales.get(i).getNombre() + ";";
			contenido += listaLabiales.get(i).getMarca() + ";";
			contenido += listaLabiales.get(i).getTipoProducto() + ";";
			contenido += listaLabiales.get(i).getDescripcion() + ";";
			contenido += listaLabiales.get(i).getUrlImagen() + ";";
			contenido += listaLabiales.get(i).getPrecio() + ";";
			contenido += listaLabiales.get(i).getCantidad() + ";";
			contenido += listaLabiales.get(i).getId() + ";";
			contenido += listaLabiales.get(i).getTipoPiel() + ";";
			contenido += listaLabiales.get(i).isEsApruebaDeAgua() + ";";
			contenido += listaLabiales.get(i).getFechaVencimiento() + ";";
			contenido += listaLabiales.get(i).getDuracion() + ";";
			contenido += listaLabiales.get(i).isEsHidratante() + "\n";
		}
		FileManager.escribirEnArchivoTexto(LABIAL_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(LABIAL_FILE_NAME);

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
			String tipoPiel = columnas[8];
			boolean pruebaAgua = Boolean.parseBoolean(columnas[9]);
			String fechaVencimiento = columnas[10];
			String duracion = columnas[11];
			boolean hidratante = Boolean.parseBoolean(columnas[12]);
			listaLabiales.add(new Labial(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
					tipoPiel, pruebaAgua, fechaVencimiento, duracion, hidratante));
		}
	}

	public ArrayList<Labial> getListaLabiales() {
		return listaLabiales;
	}

	public void setListaLabiales(ArrayList<Labial> listaLabiales) {
		this.listaLabiales = listaLabiales;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getLABIAL_FILE_NAME() {
		return LABIAL_FILE_NAME;
	}

}
