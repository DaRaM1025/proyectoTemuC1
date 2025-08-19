package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InstrumentoPercusion;
import co.edu.unbosque.model.InstrumentoPercusionDTO;

public class InstrumentoPercusionDAO implements OperacionDAO<InstrumentoPercusionDTO, InstrumentoPercusion> {

	private ArrayList<InstrumentoPercusion> listaInstrumentoPercusion;
	private final String SERIAL_FILE_NAME = "instrumentopercusion.dat";
	private final String CALZADO_FILE_NAME = "instrumentopercusion.csv";

	public InstrumentoPercusionDAO() {
		listaInstrumentoPercusion = new ArrayList<>();
		cargarDesdeArchivo();
	}

	public ArrayList<InstrumentoPercusion> getListaInstrumentoPercusion() {
		return listaInstrumentoPercusion;
	}

	public void setListaInstrumentoPercusion(ArrayList<InstrumentoPercusion> listaInstrumentoPercusion) {
		this.listaInstrumentoPercusion = listaInstrumentoPercusion;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCALZADO_FILE_NAME() {
		return CALZADO_FILE_NAME;
	}

	@Override
	public boolean crear(InstrumentoPercusionDTO nuevo) {
		InstrumentoPercusion entidad = DataMapper.dtoToInstrumentoPercusion(nuevo);
		InstrumentoPercusion encontrado = find(entidad);

		if (encontrado == null) {
			listaInstrumentoPercusion.add(entidad);
			System.out.println("EXITO" + listaInstrumentoPercusion.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("INSTRUMENTO PERCUSION YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(InstrumentoPercusionDTO eliminado) {
		InstrumentoPercusion entidad = DataMapper.dtoToInstrumentoPercusion(eliminado);
		InstrumentoPercusion encontrado = find(entidad);
		if (encontrado != null) {
			listaInstrumentoPercusion.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public InstrumentoPercusion find(InstrumentoPercusion toFind) {
		if (!listaInstrumentoPercusion.isEmpty()) {
			for (InstrumentoPercusion instruPercusion : listaInstrumentoPercusion) {
				if (instruPercusion.getId().equals(toFind.getId())) {
					System.out.println("INSTRUMENTO PERCUSION IGUAL ENCONTRADO");
					return instruPercusion;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(InstrumentoPercusionDTO previo, InstrumentoPercusionDTO nuevo) {
		InstrumentoPercusion entidadPrevio = DataMapper.dtoToInstrumentoPercusion(previo);
		InstrumentoPercusion entidadNuevo = DataMapper.dtoToInstrumentoPercusion(nuevo);
		InstrumentoPercusion encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaInstrumentoPercusion.remove(encontrado);
			listaInstrumentoPercusion.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaInstrumentoPercusion.isEmpty()) {
			return "No hay instrumentos de percusion en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (InstrumentoPercusion instruPercusion : listaInstrumentoPercusion) {
			rta.append(instruPercusion.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaInstrumentoPercusion);
	}

	private void leerArchivoSerializado() {
		listaInstrumentoPercusion = (ArrayList<InstrumentoPercusion>) FileManager
				.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaInstrumentoPercusion == null) {
			listaInstrumentoPercusion = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (InstrumentoPercusion element : listaInstrumentoPercusion) {
			contenido += element.getNombre() + ";";
			contenido += element.getMarca() + ";";
			contenido += element.getTipoProducto() + ";";
			contenido += element.getDescripcion() + ";";
			contenido += element.getUrlImagen() + ";";
			contenido += element.getPrecio() + ";";
			contenido += element.getCantidad() + ";";
			contenido += element.getId() + ";";
			contenido += element.isIncluyeEstuche() + ";";
			contenido += element.getTipoInstrumentoPercusion() + ";";
			contenido += element.isUsoBaquetas() + ";";
			contenido += element.getTipoPercusion() + ";";
			contenido += element.getCantSuperficiesSonoras() + "\n";
		}

		FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
	}

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
			String tipoInstrumentoPercusion = columnas[9];
			boolean usoBaquetas = Boolean.valueOf(columnas[10]);
			String tipoPercusion = columnas[11];
			int cantSuperficiesSonoras = Integer.parseInt(columnas[12]);
			listaInstrumentoPercusion.add(new InstrumentoPercusion(nombre, marca, tipoProducto, descripcion, urlImagen,
					precio, cantidad, id, incluyeEstuche, tipoInstrumentoPercusion, usoBaquetas, tipoPercusion,
					cantSuperficiesSonoras));
		}
	}

}
