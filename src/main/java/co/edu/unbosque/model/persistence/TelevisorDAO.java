package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Televisor;
import co.edu.unbosque.model.TelevisorDTO;

public class TelevisorDAO implements OperacionDAO<TelevisorDTO, Televisor> {

	private ArrayList<Televisor> listaTelevisor;
	private final String SERIAL_FILE_NAME = "televisor.dat";
	private final String CALZADO_FILE_NAME = "televisor.csv";

	public TelevisorDAO() {
		listaTelevisor = new ArrayList<>();
		cargarDesdeArchivo();
	}

	public ArrayList<Televisor> getListaCalzado() {
		return listaTelevisor;
	}

	public void setListaTelevisor(ArrayList<Televisor> listaTelevisor) {
		this.listaTelevisor = listaTelevisor;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public String getCALZADO_FILE_NAME() {
		return CALZADO_FILE_NAME;
	}

	@Override
	public boolean crear(TelevisorDTO nuevo) {
		Televisor entidad = DataMapper.dtoToTelevisor(nuevo);
		Televisor encontrado = find(entidad);

		if (encontrado == null) {
			listaTelevisor.add(entidad);
			System.out.println("EXITO" + listaTelevisor.size());
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		System.out.println("TELEVISOR YA EXISTE");
		return false;
	}

	@Override
	public boolean eliminar(TelevisorDTO eliminado) {
		Televisor entidad = DataMapper.dtoToTelevisor(eliminado);
		Televisor encontrado = find(entidad);
		if (encontrado != null) {
			listaTelevisor.remove(encontrado);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public Televisor find(Televisor toFind) {
		if (!listaTelevisor.isEmpty()) {
			for (Televisor tele : listaTelevisor) {
				if (tele.getId().equals(toFind.getId())) {
					System.out.println("TELEVISOR IGUAL ENCONTRADO");
					return tele;
				}
			}
		}
		return null;
	}

	@Override
	public boolean update(TelevisorDTO previo, TelevisorDTO nuevo) {
		Televisor entidadPrevio = DataMapper.dtoToTelevisor(previo);
		Televisor entidadNuevo = DataMapper.dtoToTelevisor(nuevo);
		Televisor encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaTelevisor.remove(encontrado);
			listaTelevisor.add(entidadNuevo);
			escribirEnArchivo();
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaTelevisor.isEmpty()) {
			return "No hay televisores en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Televisor tele : listaTelevisor) {
			rta.append(tele.toString()).append("\n");
		}
		return rta.toString();
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaTelevisor);
	}

	private void leerArchivoSerializado() {
		listaTelevisor = (ArrayList<Televisor>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaTelevisor == null) {
			listaTelevisor = new ArrayList<>();
		}

	}

	public void escribirEnArchivo() {
		String contenido = "";
		for (int i = 0; i < listaTelevisor.size(); i++) {
			contenido += listaTelevisor.get(i).getNombre() + ";";
			contenido += listaTelevisor.get(i).getMarca() + ";";
			contenido += listaTelevisor.get(i).getTipoProducto() + ";";
			contenido += listaTelevisor.get(i).getDescripcion() + ";";
			contenido += listaTelevisor.get(i).getUrlImagen() + ";";
			contenido += listaTelevisor.get(i).getPrecio() + ";";
			contenido += listaTelevisor.get(i).getCantidad() + ";";
			contenido += listaTelevisor.get(i).getId() + ";";
			contenido += listaTelevisor.get(i).getPulgadas() + ";";
			contenido += listaTelevisor.get(i).getResolucion() + ";";
			contenido += listaTelevisor.get(i).getSistemaOperativo() + ";";
			contenido += listaTelevisor.get(i).getCantPuertosHDMI() + ";";
			contenido += listaTelevisor.get(i).getFrecuenciaHz() + ";";
			contenido += listaTelevisor.get(i).getAsistenteVirtual() + "\n";
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
			double pulgadas = Double.parseDouble(columnas[8]);
			String resolucion = columnas[9];
			String sistemaOperativo = columnas[10];
			int cantPuertosHDMI = Integer.parseInt(columnas[11]);
			int frecuenciaHz = Integer.parseInt(columnas[12]);
			String asistenteVirtual = columnas[13];
			listaTelevisor.add(new Televisor(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id,
					pulgadas, resolucion, sistemaOperativo, cantPuertosHDMI, frecuenciaHz, asistenteVirtual));
		}
	}

}
