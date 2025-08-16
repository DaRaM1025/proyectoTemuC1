package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.PistolaAgua;
import co.edu.unbosque.model.PistolaAguaDTO;

public class PistolaAguaDAO implements OperacionDAO<PistolaAguaDTO, PistolaAgua>{

	private ArrayList<PistolaAgua> listaPistola;
	private final String SERIAL_FILE_NAME = "pistola.dat";
	private final String TEXT_FILE_NAME = "pistola.csv";

	public PistolaAguaDAO() {
		listaPistola = new ArrayList<>();
		cargarDesdeArchivo();
	}
	
	@Override
	public boolean crear(PistolaAguaDTO nuevo) {
		PistolaAgua entidad = DataMapper.dtoToPistolaAgua(nuevo);
		PistolaAgua encontrado = find(entidad);

		if (encontrado == null) {
			listaPistola.add(entidad);
			System.out.println("EXITO" + listaPistola.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("PISTOLA DE AGUA YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(PistolaAguaDTO eliminado) {
		PistolaAgua entidad = DataMapper.dtoToPistolaAgua(eliminado);
		PistolaAgua encontrado = find(entidad);
		if (encontrado != null) {
			listaPistola.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public PistolaAgua find(PistolaAgua toFind) {
		if (!listaPistola.isEmpty()) {
			for (PistolaAgua cal : listaPistola) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("PISTOLA AGUA IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(PistolaAguaDTO previo, PistolaAguaDTO nuevo) {
		PistolaAgua entidadPrevio = DataMapper.dtoToPistolaAgua(previo);
		PistolaAgua entidadNuevo = DataMapper.dtoToPistolaAgua(nuevo);
		PistolaAgua encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaPistola.remove(encontrado);
			listaPistola.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaPistola.isEmpty()) {
			return "No hay pistolas de agua en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (PistolaAgua cal : listaPistola) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}


	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPistola);
	}

	private void leerArchivoSerializado() {
		listaPistola = (ArrayList<PistolaAgua>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaPistola == null) {
			listaPistola = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaPistola.size(); i++) {
			contenido += listaPistola.get(i).getNombre() + ";";
			contenido += listaPistola.get(i).getMarca() + ";";
			contenido += listaPistola.get(i).getTipoProducto() + ";";
			contenido += listaPistola.get(i).getDescripcion() + ";";
			contenido += listaPistola.get(i).getUrlImagen() + ";";
			contenido += listaPistola.get(i).getPrecio() + ";";
			contenido += listaPistola.get(i).getCantidad() + ";";
			contenido += listaPistola.get(i).getId() + ";";
			contenido += listaPistola.get(i).getEdadRecomendada() + ";";
			contenido += listaPistola.get(i).getCapacidadAgua() + ";";
			contenido += listaPistola.get(i).getCantidadChorros() + ";";
			contenido += listaPistola.get(i).getAlcanceMaximo()+"\n";

		}

		FileManager.escribirEnArchivoTexto(TEXT_FILE_NAME, contenido);
	}

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
			int capacidadAgua = Integer.parseInt(columnas[10]);
			int cantidadChorros = Integer.parseInt(columnas[10]);
			double alcanceMaximo= Double.parseDouble(columnas[11])
			;
			listaPistola.add(new PistolaAgua(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada, capacidadAgua, cantidadChorros, alcanceMaximo) );
					
		}
	}
	
	
}
