package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Celular;
import co.edu.unbosque.model.CelularDTO;

public class CelularDAO implements OperacionDAO<CelularDTO, Celular> {

	private ArrayList<Celular> listaCelular;
	private final String SERIAL_FILE_NAME = "celular.dat";
	private final String CALZADO_FILE_NAME = "celular.csv";

	public CelularDAO() {
		listaCelular = new ArrayList<>();
		cargarDesdeArchivo();
	}

	public ArrayList<Celular> getListaCelular() {
		return listaCelular;
	}

	public void setListaCelular(ArrayList<Celular> listaCelular) {
		this.listaCelular = listaCelular;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCALZADO_FILE_NAME() {
		return CALZADO_FILE_NAME;
	}

	@Override
	public boolean crear(CelularDTO nuevo) {
		Celular entidad = DataMapper.dtoToCelular(nuevo);
		Celular encontrado = find(entidad);

		if (encontrado == null) {
			listaCelular.add(entidad);
			System.out.println("EXITO" + listaCelular.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("CELULAR YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(CelularDTO eliminado) {
		Celular entidad = DataMapper.dtoToCelular(eliminado);
		Celular encontrado = find(entidad);
		if (encontrado != null) {
			listaCelular.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Celular find(Celular toFind) {
		if (!listaCelular.isEmpty()) {
			for (Celular cel : listaCelular) {
				if (cel.getId().equals(toFind.getId())) {
					System.out.println("CELULAR IGUAL ENCONTRADO");
					return cel;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(CelularDTO previo, CelularDTO nuevo) {
		Celular entidadPrevio = DataMapper.dtoToCelular(previo);
		Celular entidadNuevo = DataMapper.dtoToCelular(nuevo);
		Celular encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCelular.remove(encontrado);
			listaCelular.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaCelular.isEmpty()) {
			return "No hay celulares en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Celular cel : listaCelular) {
			rta.append(cel.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCelular);
	}

	private void leerArchivoSerializado() {
		listaCelular = (ArrayList<Celular>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCelular == null) {
			listaCelular = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (Celular element : listaCelular) {
			contenido += element.getNombre() + ";";
			contenido += element.getMarca() + ";";
			contenido += element.getTipoProducto() + ";";
			contenido += element.getDescripcion() + ";";
			contenido += element.getUrlImagen() + ";";
			contenido += element.getPrecio() + ";";
			contenido += element.getCantidad() + ";";
			contenido += element.getId() + ";";
			contenido += element.getPulgadas() + ";";
			contenido += element.getResolucion() + ";";
			contenido += element.getSistemaOperativo() + ";";
			contenido += element.getAlmacenamiento() + ";";
			contenido += element.getRam() + ";";
			contenido += element.getCantidadCamaras() + ";";
			contenido += element.isDualSim() + "\n";
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
			double pulgadas = Double.parseDouble(columnas[8]);
			String resolucion = columnas[9];
			String sistemaOperativo = columnas[10];
			String almacenamiento = columnas[11];
			String ram = columnas[12];
			int cantidadCamaras = Integer.parseInt(columnas[13]);
			boolean dualSim = Boolean.valueOf(columnas[14]);
			listaCelular.add(new Celular(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
					pulgadas, resolucion, sistemaOperativo, almacenamiento, ram, cantidadCamaras, dualSim));
		}
	}

}
