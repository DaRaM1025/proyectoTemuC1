package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Marcador;
import co.edu.unbosque.model.MarcadorDTO;

public class MarcadorDAO implements OperacionDAO<MarcadorDTO, Marcador>{
	private ArrayList<Marcador> listaMarcadores;
	private final String SERIAL_FILE_NAME = "Marcador.dat";
	private final String MARCADOR_FILE_NAME = "Marcador.csv";

	public MarcadorDAO() {
		listaMarcadores = new ArrayList<>();
		cargarDesdeArchivo();
	}

	@Override
	public boolean crear(MarcadorDTO nuevo) {
		Marcador entidad = DataMapper.dtoToMarcador(nuevo);
		Marcador encontrado = find(entidad);

		if (encontrado == null) {
			listaMarcadores.add(entidad);
			System.out.println("EXITO" + listaMarcadores.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("Marcador YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(MarcadorDTO eliminado) {
		Marcador entidad = DataMapper.dtoToMarcador(eliminado);
		Marcador encontrado = find(entidad);
		if (encontrado != null) {
			listaMarcadores.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Marcador find(Marcador toFind) {
		if (!listaMarcadores.isEmpty()) {
			for (Marcador cal : listaMarcadores) {
				if (cal.getId().equals(toFind.getId())) {
					System.out.println("Marcador IGUAL ENCONTRADO");
					return cal;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(MarcadorDTO previo, MarcadorDTO nuevo) {
		Marcador entidadPrevio = DataMapper.dtoToMarcador(previo);
		Marcador entidadNuevo = DataMapper.dtoToMarcador(nuevo);
		Marcador encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaMarcadores.remove(encontrado);
			listaMarcadores.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaMarcadores.isEmpty()) {
			return "No hay Marcadors en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Marcador cal : listaMarcadores) {
			rta.append(cal.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaMarcadores);
	}

	private void leerArchivoSerializado() {
		listaMarcadores = (ArrayList<Marcador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaMarcadores == null) {
			listaMarcadores = new ArrayList<>();
		}
	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (Marcador listaMarcadore : listaMarcadores) {
			contenido += listaMarcadore.getNombre() + ";";
			contenido += listaMarcadore.getMarca() + ";";
			contenido += listaMarcadore.getTipoProducto() + ";";
			contenido += listaMarcadore.getDescripcion() + ";";
			contenido += listaMarcadore.getUrlImagen() + ";";
			contenido += listaMarcadore.getPrecio() + ";";
			contenido += listaMarcadore.getCantidad() + ";";
			contenido += listaMarcadore.getId() + ";";
			contenido += listaMarcadore.getTipoPresentacion() + ";";
			contenido += listaMarcadore.getTipoPunta() + ";";
			contenido += listaMarcadore.isPermanente() + ";";
			contenido += listaMarcadore.getTipoMarcador() + "\n";
		}
		FileManager.escribirEnArchivoTexto(MARCADOR_FILE_NAME, contenido);
	}

	public void cargarDesdeArchivo() {
		String contenido = FileManager.leerArchivoTexto(MARCADOR_FILE_NAME);

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
			String tipoPresentacion = columnas[9];
			String tipoPunta = columnas[10];
			boolean permanente = Boolean.parseBoolean(columnas[11]);
			String tipoMarcador = columnas[10];
			listaMarcadores.add(new Marcador(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
					tipoPresentacion, tipoPunta, permanente, tipoMarcador));
		}
	}

	public ArrayList<Marcador> getlistaMarcadores() {
		return listaMarcadores;
	}

	public void setlistaMarcadores(ArrayList<Marcador> listaMarcadores) {
		this.listaMarcadores = listaMarcadores;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getMARCADOR_FILE_NAME() {
		return MARCADOR_FILE_NAME;
	}

}
