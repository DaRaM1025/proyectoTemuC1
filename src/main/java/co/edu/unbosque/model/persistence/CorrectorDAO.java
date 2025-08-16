package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Corrector;
import co.edu.unbosque.model.CorrectorDTO;

public class CorrectorDAO implements OperacionDAO<CorrectorDTO, Corrector> {

	private ArrayList<Corrector> listaCorrectores;
	private final String SERIAL_FILE_NAME = "Corrector.dat";
	private final String CORRECTOR_FILE_NAME = "Corrector.csv";

	public CorrectorDAO() {
		listaCorrectores = new ArrayList<Corrector>();
		cargarDesdeArchivo();
	}

	@Override
	public boolean crear(CorrectorDTO nuevo) {
		Corrector entidad = DataMapper.dtoToCorrector(nuevo);
		Corrector encontrado = find(entidad);

		if (encontrado == null) {
			listaCorrectores.add(entidad);
			System.out.println("EXITO" + listaCorrectores.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("Corrector YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(CorrectorDTO eliminado) {
		Corrector entidad = DataMapper.dtoToCorrector(eliminado);
		Corrector encontrado = find(entidad);
		if (encontrado != null) {
			listaCorrectores.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Corrector find(Corrector toFind) {
		if (!listaCorrectores.isEmpty()) {
			for (Corrector cal : listaCorrectores) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("Corrector IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(CorrectorDTO previo, CorrectorDTO nuevo) {
		Corrector entidadPrevio = DataMapper.dtoToCorrector(previo);
		Corrector entidadNuevo = DataMapper.dtoToCorrector(nuevo);
		Corrector encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCorrectores.remove(encontrado);
			listaCorrectores.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaCorrectores.isEmpty()) {
			return "No hay Correctors en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Corrector cal : listaCorrectores) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCorrectores);
	}

	private void leerArchivoSerializado() {
		listaCorrectores = (ArrayList<Corrector>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCorrectores == null) {
			listaCorrectores = new ArrayList<>();
		}
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaCorrectores.size(); i++) {
			contenido += listaCorrectores.get(i).getNombre() + ";";
			contenido += listaCorrectores.get(i).getMarca() + ";";
			contenido += listaCorrectores.get(i).getTipoProducto() + ";";
			contenido += listaCorrectores.get(i).getDescripcion() + ";";
			contenido += listaCorrectores.get(i).getUrlImagen() + ";";
			contenido += listaCorrectores.get(i).getPrecio() + ";";
			contenido += listaCorrectores.get(i).getCantidad() + ";";
			contenido += listaCorrectores.get(i).getId() + ";";
			contenido += listaCorrectores.get(i).getTipoPiel() + ";";
			contenido += listaCorrectores.get(i).isEsApruebaDeAgua() + ";";
			contenido += listaCorrectores.get(i).getFechaVencimiento() + ";";
			contenido += listaCorrectores.get(i).getCobertura() + ";";
			contenido += listaCorrectores.get(i).getFormato() + ";";
		}
		FileManager.escribirEnArchivoTexto(CORRECTOR_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(CORRECTOR_FILE_NAME);

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
			String cobertura = columnas[11];
			String formato = columnas[12];

			listaCorrectores.add(new Corrector(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad,
					id, tipoPiel, pruebaAgua, fechaVencimiento, cobertura, formato));
		}
	}

	public ArrayList<Corrector> getListaCorrectores() {
		return listaCorrectores;
	}

	public void setListaCorrectores(ArrayList<Corrector> listaCorrectores) {
		this.listaCorrectores = listaCorrectores;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCORRECTOR_FILE_NAME() {
		return CORRECTOR_FILE_NAME;
	}
	

}