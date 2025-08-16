package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InstrumentoCuerda;
import co.edu.unbosque.model.InstrumentoCuerdaDTO;

public class InstrumentoCuerdaDAO implements OperacionDAO<InstrumentoCuerdaDTO, InstrumentoCuerda> {

	private ArrayList<InstrumentoCuerda> listaInstrumentoCuerda;
	private final String SERIAL_FILE_NAME = "instrumentocuerda.dat";
	private final String CALZADO_FILE_NAME = "instrumentocuerda.csv";

	public InstrumentoCuerdaDAO() {
		listaInstrumentoCuerda = new ArrayList<>();
		cargarDesdeArchivo();
	}

	public ArrayList<InstrumentoCuerda> getListaInstrumentoCuerda() {
		return listaInstrumentoCuerda;
	}

	public void setListaInstrumentoCuerda(ArrayList<InstrumentoCuerda> listaInstrumentoCuerda) {
		this.listaInstrumentoCuerda = listaInstrumentoCuerda;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCALZADO_FILE_NAME() {
		return CALZADO_FILE_NAME;
	}

	@Override
	public boolean crear(InstrumentoCuerdaDTO nuevo) {
		InstrumentoCuerda entidad = DataMapper.dtoToInstrumentoCuerda(nuevo);
		InstrumentoCuerda encontrado = find(entidad);

		if (encontrado == null) {
			listaInstrumentoCuerda.add(entidad);
			System.out.println("EXITO" + listaInstrumentoCuerda.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("INSTRUMENTO CUERDA YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(InstrumentoCuerdaDTO eliminado) {
		InstrumentoCuerda entidad = DataMapper.dtoToInstrumentoCuerda(eliminado);
		InstrumentoCuerda encontrado = find(entidad);
		if (encontrado != null) {
			listaInstrumentoCuerda.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public InstrumentoCuerda find(InstrumentoCuerda toFind) {
		if (!listaInstrumentoCuerda.isEmpty()) {
			for (InstrumentoCuerda instruCuerda : listaInstrumentoCuerda) {
				if (instruCuerda.getId().equals(toFind.getId())) {
					System.out.println("COMPUTADOR IGUAL ENCONTRADO");
					return instruCuerda;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(InstrumentoCuerdaDTO previo, InstrumentoCuerdaDTO nuevo) {
		InstrumentoCuerda entidadPrevio = DataMapper.dtoToInstrumentoCuerda(previo);
		InstrumentoCuerda entidadNuevo = DataMapper.dtoToInstrumentoCuerda(nuevo);
		InstrumentoCuerda encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaInstrumentoCuerda.remove(encontrado);
			listaInstrumentoCuerda.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaInstrumentoCuerda.isEmpty()) {
			return "No hay instrumentos de cuerda en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (InstrumentoCuerda instruCuerda : listaInstrumentoCuerda) {
			rta.append(instruCuerda.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaInstrumentoCuerda);
	}

	private void leerArchivoSerializado() {
		listaInstrumentoCuerda = (ArrayList<InstrumentoCuerda>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaInstrumentoCuerda == null) {
			listaInstrumentoCuerda = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaInstrumentoCuerda.size(); i++) {
			contenido += listaInstrumentoCuerda.get(i).getNombre() + ";";
			contenido += listaInstrumentoCuerda.get(i).getMarca() + ";";
			contenido += listaInstrumentoCuerda.get(i).getTipoProducto() + ";";
			contenido += listaInstrumentoCuerda.get(i).getDescripcion() + ";";
			contenido += listaInstrumentoCuerda.get(i).getUrlImagen() + ";";
			contenido += listaInstrumentoCuerda.get(i).getPrecio() + ";";
			contenido += listaInstrumentoCuerda.get(i).getCantidad() + ";";
			contenido += listaInstrumentoCuerda.get(i).getId() + ";";
			contenido += listaInstrumentoCuerda.get(i).isIncluyeEstuche() + ";";
			contenido += listaInstrumentoCuerda.get(i).getTipoInstrumentoCuerda() + ";";
			contenido += listaInstrumentoCuerda.get(i).getNumeroCuerdas() + ";";
			contenido += listaInstrumentoCuerda.get(i).getTipoCuerda() + ";";
			contenido += listaInstrumentoCuerda.get(i).isTieneCajaResonancia() + "\\n";
		}

		FileManager.escribirEnArchivoTexto(CALZADO_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(CALZADO_FILE_NAME);

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
			boolean incluyeEstuche = Boolean.valueOf(columnas[8]);
			String tipoInstrumentoCuerda = columnas[9];
			int numeroCuerdas = Integer.parseInt(columnas[10]);
			String tipoCuerda = columnas[11];
			boolean tieneCajaResonancia = Boolean.valueOf(columnas[12]);
			listaInstrumentoCuerda
					.add(new InstrumentoCuerda(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad,
							id, incluyeEstuche, tipoInstrumentoCuerda, numeroCuerdas, tipoCuerda, tieneCajaResonancia));
		}
	}

}
