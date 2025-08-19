package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Computador;
import co.edu.unbosque.model.ComputadorDTO;

public class ComputadorDAO implements OperacionDAO<ComputadorDTO, Computador> {

	private ArrayList<Computador> listaComputador;
	private final String SERIAL_FILE_NAME = "computador.dat";
	private final String CALZADO_FILE_NAME = "computador.csv";

	public ComputadorDAO() {
		listaComputador = new ArrayList<>();
		cargarDesdeArchivo();
	}

	public ArrayList<Computador> getListaComputador() {
		return listaComputador;
	}

	public void setListaComputador(ArrayList<Computador> listaComputador) {
		this.listaComputador = listaComputador;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCALZADO_FILE_NAME() {
		return CALZADO_FILE_NAME;
	}

	@Override
	public boolean crear(ComputadorDTO nuevo) {
		Computador entidad = DataMapper.dtoToComputador(nuevo);
		Computador encontrado = find(entidad);

		if (encontrado == null) {
			listaComputador.add(entidad);
			System.out.println("EXITO" + listaComputador.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("COMPUTADOR YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(ComputadorDTO eliminado) {
		Computador entidad = DataMapper.dtoToComputador(eliminado);
		Computador encontrado = find(entidad);
		if (encontrado != null) {
			listaComputador.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Computador find(Computador toFind) {
		if (!listaComputador.isEmpty()) {
			for (Computador compu : listaComputador) {
				if (compu.getId().equals(toFind.getId())) {
					System.out.println("COMPUTADOR IGUAL ENCONTRADO");
					return compu;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(ComputadorDTO previo, ComputadorDTO nuevo) {
		Computador entidadPrevio = DataMapper.dtoToComputador(previo);
		Computador entidadNuevo = DataMapper.dtoToComputador(nuevo);
		Computador encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaComputador.remove(encontrado);
			listaComputador.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaComputador.isEmpty()) {
			return "No hay computadores en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Computador compu : listaComputador) {
			rta.append(compu.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaComputador);
	}

	private void leerArchivoSerializado() {
		listaComputador = (ArrayList<Computador>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaComputador == null) {
			listaComputador = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (Computador element : listaComputador) {
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
			contenido += element.getProcesador() + ";";
			contenido += element.getTarjetaGrafica() + "\n";
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
			String procesador = columnas[13];
			String tarjetaGrafica = columnas[14];
			listaComputador.add(new Computador(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad,
					id, pulgadas, resolucion, sistemaOperativo, almacenamiento, ram, procesador, tarjetaGrafica));
		}
	}

}
