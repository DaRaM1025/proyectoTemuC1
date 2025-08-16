package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Calzado;
import co.edu.unbosque.model.CalzadoDTO;


public class CalzadoDAO implements OperacionDAO<CalzadoDTO, Calzado> {

	private ArrayList<Calzado> listaCalzado;
	private final String SERIAL_FILE_NAME = "calzado.dat";
	private final String CALZADO_FILE_NAME = "calzado.csv";

	public CalzadoDAO() {
		listaCalzado= new ArrayList<>();
		cargarDesdeArchivo();
	}
	
	public ArrayList<Calzado> getListaCalzado() {
		return listaCalzado;
	}

	public void setListaCalzado(ArrayList<Calzado> listaCalzado) {
		this.listaCalzado = listaCalzado;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCALZADO_FILE_NAME() {
		return CALZADO_FILE_NAME;
	}

	@Override
	public boolean crear(CalzadoDTO nuevo) {
		Calzado entidad = DataMapper.dtoToCalzado(nuevo);
	   Calzado encontrado = find(entidad);
	    
	    if (encontrado == null) {
	        listaCalzado.add(entidad);
	        System.out.println("EXITO" + listaCalzado.size());
	        escribirEnArchivo();
	        escribirArchivoSerializado();
	        return true;
	    }
	    System.out.println("CALZADO YA EXISTE");
	    return false;
	}

	@Override
	public boolean eliminar(CalzadoDTO eliminado) {
		Calzado entidad = DataMapper.dtoToCalzado(eliminado);
		Calzado encontrado = find(entidad);
		if (encontrado != null) {
			listaCalzado.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Calzado find(Calzado toFind) {
		 if (!listaCalzado.isEmpty()) {
		        for (Calzado cal : listaCalzado) {
		          if (cal.getNombre().equals(toFind.getNombre())) {
		                System.out.println("CALZADO IGUAL ENCONTRADO");
		                return cal;
		            }
		        }
		    }
		    return null;
	}

	@Override
	public boolean update(CalzadoDTO previo, CalzadoDTO nuevo) {
		Calzado entidadPrevio = DataMapper.dtoToCalzado(previo);
		Calzado entidadNuevo = DataMapper.dtoToCalzado(nuevo);
		Calzado encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaCalzado.remove(encontrado);
			listaCalzado.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaCalzado.isEmpty()) {
			return "No hay calzados en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Calzado cal : listaCalzado) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaCalzado);
	}

	private void leerArchivoSerializado() {
		listaCalzado = (ArrayList<Calzado>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaCalzado == null) {
			listaCalzado = new ArrayList<>();
		}
		
	}
	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaCalzado.size(); i++) {
			contenido += listaCalzado.get(i).getNombre() + ";";
			contenido += listaCalzado.get(i).getMarca() + ";";
			contenido += listaCalzado.get(i).getTipoProducto() + ";";
			contenido += listaCalzado.get(i).getDescripcion() + ";";
			contenido += listaCalzado.get(i).getUrlImagen() + ";";
			contenido += listaCalzado.get(i).getPrecio() + ";";
			contenido += listaCalzado.get(i).getCantidad() + ";";
			contenido += listaCalzado.get(i).getId() + ";";
			contenido += listaCalzado.get(i).getTalla() + ";";
			contenido += listaCalzado.get(i).getGenero() + ";";
			contenido += listaCalzado.get(i).getMaterial() + ";";
			contenido += listaCalzado.get(i).getTipoCalzado() + ";";
			contenido += listaCalzado.get(i).getOcasion() + ";";
			contenido += listaCalzado.get(i).getMaterialSuela() + ";";
			contenido += listaCalzado.get(i).getAlturaSuela() + "\n";
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
			String talla = columnas[8];
			String genero = columnas[9];
			String material = columnas[10];
			String tipoCalzado = columnas[11];
			String ocasion = columnas[12];
			String materialSuela = columnas[13];
			double alturaSuela = Double.parseDouble(columnas[14]);
			;
			listaCalzado.add(new Calzado(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material, tipoCalzado, ocasion, materialSuela, alturaSuela));
		}
	}
	
}
