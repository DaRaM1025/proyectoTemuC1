package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InstrumentoViento;
import co.edu.unbosque.model.InstrumentoVientoDTO;

public class InstrumentoVientoDAO implements OperacionDAO<InstrumentoVientoDTO, InstrumentoViento> {

	private ArrayList<InstrumentoViento> listaInstrumentoViento;
	private final String SERIAL_FILE_NAME = "instrumentoviento.dat";
	private final String CALZADO_FILE_NAME = "instrumentoviento.csv";

	public InstrumentoVientoDAO() {
		listaInstrumentoViento = new ArrayList<>();
		cargarDesdeArchivo();
	}

	public ArrayList<InstrumentoViento> getListaInstrumentoViento() {
		return listaInstrumentoViento;
	}

	public void setListaInstrumentoViento(ArrayList<InstrumentoViento> listaInstrumentoViento) {
		this.listaInstrumentoViento = listaInstrumentoViento;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCALZADO_FILE_NAME() {
		return CALZADO_FILE_NAME;
	}

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

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaInstrumentoViento);
	}

	private void leerArchivoSerializado() {
		listaInstrumentoViento = (ArrayList<InstrumentoViento>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaInstrumentoViento == null) {
			listaInstrumentoViento = new ArrayList<>();
		}

	}

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
