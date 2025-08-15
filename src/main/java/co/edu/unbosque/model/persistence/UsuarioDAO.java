package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;

public class UsuarioDAO implements OperacionDAO<UsuarioDTO, Usuario> {

	private ArrayList<Usuario> listaUsuarios;
	private final String SERIAL_FILE_NAME = "usuario.dat";

	public UsuarioDAO() {
		super();
		listaUsuarios = new ArrayList<>();
		leerArchivoSerializado();
		
	}

	public ArrayList<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	private void escribirArchivoSerializado() {
		FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaUsuarios);
	}

	private void leerArchivoSerializado() {
		listaUsuarios = (ArrayList<Usuario>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaUsuarios == null) {
			listaUsuarios = new ArrayList<>();
		}
	}

	@Override

	
	public boolean crear(UsuarioDTO nuevo) {
	    Usuario entidad = DataMapper.usuarioDTOToUsuario(nuevo);
	    Usuario encontrado = find(entidad);
	    
	    if (encontrado == null) {
	        listaUsuarios.add(entidad);
	        System.out.println("EXITO" + listaUsuarios.size());
	        escribirArchivoSerializado();
	        return true;
	    }
	    System.out.println("USUARIO YA EXISTE");
	    return false;
	}


	@Override
	public boolean eliminar(UsuarioDTO eliminado) {
		Usuario entidad = DataMapper.usuarioDTOToUsuario(eliminado);
		Usuario encontrado = find(entidad);
		if (encontrado != null) {
			listaUsuarios.remove(encontrado);
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override


	public Usuario find(Usuario toFind) {
	    if (!listaUsuarios.isEmpty()) {
	        for (Usuario usuario : listaUsuarios) {
	          if (usuario.getUsername().equals(toFind.getUsername())) {
	                System.out.println("USAURIO IGUAL ENCONTRADO");
	                return usuario;
	            }
	        }
	    }
	    return null;
	}



	@Override
	public boolean update(UsuarioDTO previo, UsuarioDTO nuevo) {
		Usuario entidadPrevio = DataMapper.usuarioDTOToUsuario(previo);
		Usuario entidadNuevo = DataMapper.usuarioDTOToUsuario(nuevo);
		Usuario encontrado = find(entidadPrevio);
		if (encontrado != null) {
			listaUsuarios.remove(encontrado);
			listaUsuarios.add(entidadNuevo);
			escribirArchivoSerializado();
			return true;
		}
		return false;
	}

	@Override
	public String mostrar() {
		if (listaUsuarios.isEmpty()) {
			return "No hay usuarios en la lista";
		}
		StringBuilder rta = new StringBuilder();
		for (Usuario usuario : listaUsuarios) {
			rta.append(usuario.toString()).append("\n");
		}
		return rta.toString();
	}
}
