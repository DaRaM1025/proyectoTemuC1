package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.CintaAdhesiva;
import co.edu.unbosque.model.CintaAdhesivaDTO;

public class CintaAdhesivaDAO implements OperacionDAO<CintaAdhesivaDTO, CintaAdhesiva> {
	private ArrayList<CintaAdhesiva> listaCintaAdhesivas;
	private final String SERIAL_FILE_NAME = "CintaAdhesiva.dat";
	private final String CINTA_FILE_NAME = "CintaAdhesiva.csv";

	public CintaAdhesivaDAO() {
		listaCintaAdhesivas = new ArrayList<CintaAdhesiva>();
		cargarDesdeArchivo();
	}

	@Override
	public boolean crear(CintaAdhesivaDTO nuevo) {
		CintaAdhesiva entidad = DataMapper.dtoToCintaAdhesiva(nuevo);
		CintaAdhesiva encontrado = find(entidad);

		if (encontrado == null) {
			listaCintaAdhesivas.add(entidad);
			System.out.println("EXITO" + listaCintaAdhesivas.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("CintaAdhesiva YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(CintaAdhesivaDTO eliminado) {
		CintaAdhesiva entidad = DataMapper.dtoToCintaAdhesiva(eliminado);
		CintaAdhesiva encontrado = find(entidad);
		if (encontrado != null) {
			listaCintaAdhesivas.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public CintaAdhesiva find(CintaAdhesiva toFind) {
		if (!listaCintaAdhesivas.isEmpty()) {
			for (CintaAdhesiva cal : listaCintaAdhesivas) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("CintaAdhesiva IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(CintaAdhesivaDTO previo, CintaAdhesivaDTO nuevo) {
		CintaAdhesiva entidadPrevio = DataMapper.dtoToCintaAdhesiva(previo);
		CintaAdhesiva entidadNuevo = DataMapper.dtoToCintaAdhesiva(nuevo);
		CintaAdhesiva encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCintaAdhesivas.remove(encontrado);
			listaCintaAdhesivas.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaCintaAdhesivas.isEmpty()) {
			return "No hay CintaAdhesivas en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (CintaAdhesiva cal : listaCintaAdhesivas) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCintaAdhesivas);
	}

	private void leerArchivoSerializado() {
		listaCintaAdhesivas = (ArrayList<CintaAdhesiva>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCintaAdhesivas == null) {
			listaCintaAdhesivas = new ArrayList<>();
		}
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaCintaAdhesivas.size(); i++) {
			contenido += listaCintaAdhesivas.get(i).getNombre() + ";";
			contenido += listaCintaAdhesivas.get(i).getMarca() + ";";
			contenido += listaCintaAdhesivas.get(i).getTipoProducto() + ";";
			contenido += listaCintaAdhesivas.get(i).getDescripcion() + ";";
			contenido += listaCintaAdhesivas.get(i).getUrlImagen() + ";";
			contenido += listaCintaAdhesivas.get(i).getPrecio() + ";";
			contenido += listaCintaAdhesivas.get(i).getCantidad() + ";";
			contenido += listaCintaAdhesivas.get(i).getId() + ";";
			contenido += listaCintaAdhesivas.get(i).getTipoPresentacion() + ";";
			contenido += listaCintaAdhesivas.get(i).isEsAdhesivoReposicionable() + ";";
			contenido += listaCintaAdhesivas.get(i).getAncho() + ";";
			contenido += listaCintaAdhesivas.get(i).getTipoCinta() + "\n";
		}
		FileManager.escribirEnArchivoTexto(CINTA_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(CINTA_FILE_NAME);

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
			boolean adhesivo = Boolean.parseBoolean(columnas[9]);
			double ancho = Double.parseDouble(columnas[10]);
			String tipoCinta = columnas[11];
			listaCintaAdhesivas.add(new CintaAdhesiva(nombre, marca, tipoProducto, descripcion, urlImagen, precio,
					cantidad, id, tipoPresentacion, adhesivo, ancho, tipoCinta));
		}
	}

	public ArrayList<CintaAdhesiva> getlistaCintaAdhesivas() {
		return listaCintaAdhesivas;
	}

	public void setlistaCintaAdhesivas(ArrayList<CintaAdhesiva> listaCintaAdhesivas) {
		this.listaCintaAdhesivas = listaCintaAdhesivas;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCintaAdhesiva_FILE_NAME() {
		return CINTA_FILE_NAME;
	}
}
