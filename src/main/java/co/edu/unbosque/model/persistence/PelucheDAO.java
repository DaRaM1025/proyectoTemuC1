package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Peluche;
import co.edu.unbosque.model.PelucheDTO;

public class PelucheDAO implements OperacionDAO<PelucheDTO, Peluche>{

	private ArrayList<Peluche> listaPeluches;
	private final String SERIAL_FILE_NAME = "peluche.dat";
	private final String TEXT_FILE_NAME = "peluche.csv";

	public PelucheDAO() {
		listaPeluches = new ArrayList<>();
		cargarDesdeArchivo();
	}
	
	@Override
	public boolean crear(PelucheDTO nuevo) {
		Peluche entidad = DataMapper.dtoToPeluche(nuevo);
		Peluche encontrado = find(entidad);

		if (encontrado == null) {
			listaPeluches.add(entidad);
			System.out.println("EXITO" + listaPeluches.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("PELUCHE YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(PelucheDTO eliminado) {
		Peluche entidad = DataMapper.dtoToPeluche(eliminado);
		Peluche encontrado = find(entidad);
		if (encontrado != null) {
			listaPeluches.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Peluche find(Peluche toFind) {
		if (!listaPeluches.isEmpty()) {
			for (Peluche cal : listaPeluches) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("PELUCHE IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(PelucheDTO previo, PelucheDTO nuevo) {
		Peluche entidadPrevio = DataMapper.dtoToPeluche(previo);
		Peluche entidadNuevo = DataMapper.dtoToPeluche(nuevo);
		Peluche encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaPeluches.remove(encontrado);
			listaPeluches.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaPeluches.isEmpty()) {
			return "No hay peluches en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Peluche cal : listaPeluches) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPeluches);
	}

	private void leerArchivoSerializado() {
		listaPeluches = (ArrayList<Peluche>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaPeluches == null) {
			listaPeluches = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaPeluches.size(); i++) {
			contenido += listaPeluches.get(i).getNombre() + ";";
			contenido += listaPeluches.get(i).getMarca() + ";";
			contenido += listaPeluches.get(i).getTipoProducto() + ";";
			contenido += listaPeluches.get(i).getDescripcion() + ";";
			contenido += listaPeluches.get(i).getUrlImagen() + ";";
			contenido += listaPeluches.get(i).getPrecio() + ";";
			contenido += listaPeluches.get(i).getCantidad() + ";";
			contenido += listaPeluches.get(i).getId() + ";";
			contenido += listaPeluches.get(i).getEdadRecomendada() + ";";
			contenido += listaPeluches.get(i).isTieneSonido() + ";";
			contenido += listaPeluches.get(i).getTipoRelleno() + ";";
			contenido += listaPeluches.get(i).isLavadoMaquina() +"\n";

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
			boolean tieneSonido= Boolean.parseBoolean(columnas[9]);
			String tipoRelleno = columnas[13];
			boolean lavadoMaquina= Boolean.parseBoolean(columnas[12])
			;
			listaPeluches.add(new Peluche(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada, tieneSonido, tipoRelleno, lavadoMaquina));
					
		}
	}
	
	
}
