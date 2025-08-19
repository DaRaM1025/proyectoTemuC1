package co.edu.unbosque.service;

import java.util.List;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioService {

	@Inject
	private UsuarioDAO usuarioDAO;

	public boolean agregarUsuarioVerificando(UsuarioDTO dto) {

		if (esUsuarioDuplicado(dto)) {
			System.out.println("usuario duplicado");
			return false;
		}
		return usuarioDAO.crear(dto);
	}

	private boolean esUsuarioDuplicado(UsuarioDTO dto) {
		for (Usuario usuarioExistente : usuarioDAO.getListaUsuarios()) {
			if (usuarioExistente.getUsername().equalsIgnoreCase(dto.getUsername())
					|| usuarioExistente.getEmail().equalsIgnoreCase(dto.getEmail())
					|| usuarioExistente.getTelefono().equals(dto.getTelefono())) {
				return true;
			}
		}
		return false;
	}

	public List<Usuario> obtenerUsuarios() {
		return usuarioDAO.getListaUsuarios();

	}

	public String mostrarUsuarios() {
		return usuarioDAO.mostrar();
	}

	public Usuario validarCredenciales(String username, String password) {
	    for (Usuario u : usuarioDAO.getListaUsuarios()) {
	        if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
	            return u;
	        }
	    }
	    return null;
	}

	public Usuario buscarPorUsername(String username) {
		for (Usuario u : usuarioDAO.getListaUsuarios()) {
			if (u.getUsername().equalsIgnoreCase(username)) {
				return u;
			}
		}
		return null;
	}

}
