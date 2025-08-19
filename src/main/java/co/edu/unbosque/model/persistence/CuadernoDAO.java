package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Cuaderno;
import co.edu.unbosque.model.CuadernoDTO;

public class CuadernoDAO implements OperacionDAO<CuadernoDTO, Cuaderno> {

	private ArrayList<Cuaderno> listaCuadernos;
	private final String SERIAL_FILE_NAME = "Cuaderno.dat";
	private final String CUADERNO_FILE_NAME = "Cuaderno.csv";

	public CuadernoDAO() {
		listaCuadernos = new ArrayList<Cuaderno>();
		cargarDesdeArchivo();
	}

	@Override
	public boolean crear(CuadernoDTO nuevo) {
		Cuaderno entidad = DataMapper.dtoToCuaderno(nuevo);
		Cuaderno encontrado = find(entidad);

		if (encontrado == null) {
			listaCuadernos.add(entidad);
			System.out.println("EXITO" + listaCuadernos.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("Cuaderno YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(CuadernoDTO eliminado) {
		Cuaderno entidad = DataMapper.dtoToCuaderno(eliminado);
		Cuaderno encontrado = find(entidad);
		if (encontrado != null) {
			listaCuadernos.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Cuaderno find(Cuaderno toFind) {
		if (!listaCuadernos.isEmpty()) {
			for (Cuaderno cal : listaCuadernos) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("Cuaderno IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(CuadernoDTO previo, CuadernoDTO nuevo) {
		Cuaderno entidadPrevio = DataMapper.dtoToCuaderno(previo);
		Cuaderno entidadNuevo = DataMapper.dtoToCuaderno(nuevo);
		Cuaderno encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCuadernos.remove(encontrado);
			listaCuadernos.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaCuadernos.isEmpty()) {
			return "No hay Cuadernos en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Cuaderno cal : listaCuadernos) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCuadernos);
	}

	private void leerArchivoSerializado() {
		listaCuadernos = (ArrayList<Cuaderno>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCuadernos == null) {
			listaCuadernos = new ArrayList<>();
		}
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaCuadernos.size(); i++) {
			contenido += listaCuadernos.get(i).getNombre() + ";";
			contenido += listaCuadernos.get(i).getMarca() + ";";
			contenido += listaCuadernos.get(i).getTipoProducto() + ";";
			contenido += listaCuadernos.get(i).getDescripcion() + ";";
			contenido += listaCuadernos.get(i).getUrlImagen() + ";";
			contenido += listaCuadernos.get(i).getPrecio() + ";";
			contenido += listaCuadernos.get(i).getCantidad() + ";";
			contenido += listaCuadernos.get(i).getId() + ";";
			contenido += listaCuadernos.get(i).getTipoPresentacion() + ";";
			contenido += listaCuadernos.get(i).getTipoHojas() + ";";
			contenido += listaCuadernos.get(i).getCantidadHojas() + ";";
			contenido += listaCuadernos.get(i).isPastaDura() + "\n";
		}
		FileManager.escribirEnArchivoTexto(CUADERNO_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(CUADERNO_FILE_NAME);

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
			String tipoPresentacion = columnas[8];
			String tipoHojas = columnas[9];
			int cantidadHojas = Integer.parseInt(columnas[10]);
			boolean pastaDura = Boolean.parseBoolean(columnas[11]);
			listaCuadernos.add(new Cuaderno(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
					tipoPresentacion, tipoHojas, cantidadHojas, pastaDura));
		}
	}

	public ArrayList<Cuaderno> getlistaCuadernos() {
		return listaCuadernos;
	}

	public void setlistaCuadernos(ArrayList<Cuaderno> listaCuadernos) {
		this.listaCuadernos = listaCuadernos;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCuaderno_FILE_NAME() {
		return CUADERNO_FILE_NAME;
	}
}
