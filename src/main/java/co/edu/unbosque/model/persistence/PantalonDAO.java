package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Pantalon;
import co.edu.unbosque.model.PantalonDTO;

public class PantalonDAO implements OperacionDAO<PantalonDTO, Pantalon> {

	private ArrayList<Pantalon> listaPantalon;
	private final String SERIAL_FILE_NAME = "pantaon.dat";
	private final String TEXT_FILE_NAME = "pantalon.csv";
	
	public PantalonDAO() {
		listaPantalon= new ArrayList<>();
		cargarDesdeArchivo();
	}
	@Override
	public boolean crear(PantalonDTO nuevo) {
		Pantalon entidad = DataMapper.dtoToPantalon(nuevo);
		   Pantalon encontrado = find(entidad);
		    
		    if (encontrado == null) {
		        listaPantalon.add(entidad);
		        System.out.println("EXITO" + listaPantalon.size());
		        escribirEnArchivo();
		        escribirArchivoSerializado();
		        return true;
		    }
		    System.out.println("PANTALON YA EXISTE");
		    return false;
	}

	@Override
	public boolean eliminar(PantalonDTO eliminado) {
		Pantalon entidad = DataMapper.dtoToPantalon(eliminado);
		Pantalon encontrado = find(entidad);
		if (encontrado != null) {
			listaPantalon.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Pantalon find(Pantalon toFind) {
		 if (!listaPantalon.isEmpty()) {
		        for (Pantalon cal : listaPantalon) {
		          if (cal.getId().equals(toFind.getId())) {
		                System.out.println("PANTALON IGUAL ENCONTRADO");
		                return cal;
		            }
		        }
		    }
		    return null;
	}

	@Override
	public boolean update(PantalonDTO previo, PantalonDTO nuevo) {
		Pantalon entidadPrevio = DataMapper.dtoToPantalon(previo);
		Pantalon entidadNuevo = DataMapper.dtoToPantalon(nuevo);
		Pantalon encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaPantalon.remove(encontrado);
			listaPantalon.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaPantalon.isEmpty()) {
			return "No hay pantalones en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Pantalon cal : listaPantalon) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaPantalon);
	}

	private void leerArchivoSerializado() {
		listaPantalon = (ArrayList<Pantalon>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaPantalon == null) {
			listaPantalon = new ArrayList<>();
		}
		
	}
	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaPantalon.size(); i++) {
			contenido += listaPantalon.get(i).getNombre() + ";";
			contenido += listaPantalon.get(i).getMarca() + ";";
			contenido += listaPantalon.get(i).getTipoProducto() + ";";
			contenido += listaPantalon.get(i).getDescripcion() + ";";
			contenido += listaPantalon.get(i).getUrlImagen() + ";";
			contenido += listaPantalon.get(i).getPrecio() + ";";
			contenido += listaPantalon.get(i).getCantidad() + ";";
			contenido += listaPantalon.get(i).getId() + ";";
			contenido += listaPantalon.get(i).getTalla() + ";";
			contenido += listaPantalon.get(i).getGenero() + ";";
			contenido += listaPantalon.get(i).getMaterial() + ";";
			contenido += listaPantalon.get(i).getTipoPantalon() + ";";
			contenido += listaPantalon.get(i).getCorte() + ";";
			contenido += listaPantalon.get(i).getLargo() + "\n";
			
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
			String tipoPantalon = columnas[11];
			String corte = columnas[12];
			String largo = columnas[13];
			
			;
			listaPantalon.add(new Pantalon(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material, tipoPantalon, corte, largo));
		}
	}
	
}
