package co.edu.unbosque.service;

import java.util.List;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class UsuarioService {
	private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

	public UsuarioService() {

	}

	public boolean agregarUsuarioVerificando(UsuarioDTO dto) {
		if (esUsuarioDuplicado(dto)) {
			System.out.println("usauario duplicado");
			return false;
		}
		boolean creado = usuarioDAO.crear(dto);

		return creado;
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

}
