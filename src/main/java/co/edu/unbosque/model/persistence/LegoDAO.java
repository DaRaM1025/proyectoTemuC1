package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Lego;
import co.edu.unbosque.model.LegoDTO;

public class LegoDAO implements OperacionDAO<LegoDTO, Lego> {

	private ArrayList<Lego> listaLego;
	private final String SERIAL_FILE_NAME = "lego.dat";
	private final String TEXT_FILE_NAME = "lego.csv";

	public LegoDAO() {
		listaLego = new ArrayList<>();
		cargarDesdeArchivo();
	}
	
	
	@Override
	public boolean crear(LegoDTO nuevo) {
		Lego entidad = DataMapper.dtoToLego(nuevo);
		Lego encontrado = find(entidad);

		if (encontrado == null) {
			listaLego.add(entidad);
			System.out.println("EXITO" + listaLego.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("LEGO YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(LegoDTO eliminado) {
		Lego entidad = DataMapper.dtoToLego(eliminado);
		Lego encontrado = find(entidad);
		if (encontrado != null) {
			listaLego.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Lego find(Lego toFind) {
		if (!listaLego.isEmpty()) {
			for (Lego cal : listaLego) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("LEGO IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(LegoDTO previo, LegoDTO nuevo) {
		Lego entidadPrevio = DataMapper.dtoToLego(previo);
		Lego entidadNuevo = DataMapper.dtoToLego(nuevo);
		Lego encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaLego.remove(encontrado);
			listaLego.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaLego.isEmpty()) {
			return "No hay legos en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Lego cal : listaLego) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaLego);
	}

	private void leerArchivoSerializado() {
		listaLego = (ArrayList<Lego>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaLego == null) {
			listaLego = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaLego.size(); i++) {
			contenido += listaLego.get(i).getNombre() + ";";
			contenido += listaLego.get(i).getMarca() + ";";
			contenido += listaLego.get(i).getTipoProducto() + ";";
			contenido += listaLego.get(i).getDescripcion() + ";";
			contenido += listaLego.get(i).getUrlImagen() + ";";
			contenido += listaLego.get(i).getPrecio() + ";";
			contenido += listaLego.get(i).getCantidad() + ";";
			contenido += listaLego.get(i).getId() + ";";
			contenido += listaLego.get(i).getEdadRecomendada() + ";";
			contenido += listaLego.get(i).getTema() + ";";
			contenido += listaLego.get(i).getNumeroPiezas() + ";";
			contenido += listaLego.get(i).isTieneMinifiguras() +"\n";

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
			String tema = columnas[9];
			int numeroPiezas = Integer.parseInt(columnas[10]);
			boolean tieneMinifiguras= Boolean.parseBoolean(columnas[11])
			;
			listaLego.add(new Lego(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada, tema, numeroPiezas, tieneMinifiguras));
					
		}
	}
	
}
