package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Camiseta;
import co.edu.unbosque.model.CamisetaDTO;

public class CamisetaDAO implements OperacionDAO<CamisetaDTO, Camiseta> {

	private ArrayList<Camiseta> listaCamiseta;
	private final String SERIAL_FILE_NAME = "camiseta.dat";
	private final String TEXT_FILE_NAME = "camiseta.csv";

	public CamisetaDAO() {
		listaCamiseta = new ArrayList<>();
		cargarDesdeArchivo();
	}

	@Override
	public boolean crear(CamisetaDTO nuevo) {
		Camiseta entidad = DataMapper.dtoToCamiseta(nuevo);
		Camiseta encontrado = find(entidad);

		if (encontrado == null) {
			listaCamiseta.add(entidad);
			System.out.println("EXITO" + listaCamiseta.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("CAMISETA YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(CamisetaDTO eliminado) {
		Camiseta entidad = DataMapper.dtoToCamiseta(eliminado);
		Camiseta encontrado = find(entidad);
		if (encontrado != null) {
			listaCamiseta.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Camiseta find(Camiseta toFind) {
		if (!listaCamiseta.isEmpty()) {
			for (Camiseta cal : listaCamiseta) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("CAMISETA IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(CamisetaDTO previo, CamisetaDTO nuevo) {
		Camiseta entidadPrevio = DataMapper.dtoToCamiseta(previo);
		Camiseta entidadNuevo = DataMapper.dtoToCamiseta(nuevo);
		Camiseta encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCamiseta.remove(encontrado);
			listaCamiseta.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaCamiseta.isEmpty()) {
			return "No hay camisetas en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Camiseta cal : listaCamiseta) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCamiseta);
	}

	private void leerArchivoSerializado() {
		listaCamiseta = (ArrayList<Camiseta>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCamiseta == null) {
			listaCamiseta = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaCamiseta.size(); i++) {
			contenido += listaCamiseta.get(i).getNombre() + ";";
			contenido += listaCamiseta.get(i).getMarca() + ";";
			contenido += listaCamiseta.get(i).getTipoProducto() + ";";
			contenido += listaCamiseta.get(i).getDescripcion() + ";";
			contenido += listaCamiseta.get(i).getUrlImagen() + ";";
			contenido += listaCamiseta.get(i).getPrecio() + ";";
			contenido += listaCamiseta.get(i).getCantidad() + ";";
			contenido += listaCamiseta.get(i).getId() + ";";
			contenido += listaCamiseta.get(i).getTalla() + ";";
			contenido += listaCamiseta.get(i).getGenero() + ";";
			contenido += listaCamiseta.get(i).getMaterial() + ";";
			contenido += listaCamiseta.get(i).getTipoManga() + ";";
			contenido += listaCamiseta.get(i).getCuello() + ";";
			contenido += listaCamiseta.get(i).isEstampado() + "\n";

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
			String talla = columnas[8];
			String genero = columnas[9];
			String material = columnas[10];
			String tipoManga = columnas[11];
			String cuello = columnas[12];
			boolean isEstampado = Boolean.parseBoolean(columnas[13]);

			;
			listaCamiseta.add(new Camiseta(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material, tipoManga, cuello, isEstampado));
					
		}
	}

}
