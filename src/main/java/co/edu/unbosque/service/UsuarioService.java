package co.edu.unbosque.service;

import java.util.List;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

/**
 * Servicio para la gestión de usuarios en la aplicación.
 * <p>
 * Proporciona métodos para agregar usuarios verificando duplicados, 
 * validar credenciales, buscar usuarios por username y obtener la lista de usuarios.
 * </p>
 * <p>
 * Esta clase se maneja como bean CDI en contexto de aplicación mediante {@link ApplicationScoped}.
 * </p>
 */
@ApplicationScoped
public class UsuarioService {

    /** DAO de usuarios inyectado para operaciones de persistencia */
    @Inject
    private UsuarioDAO usuarioDAO;

    /**
     * Agrega un nuevo usuario verificando que no exista duplicado por username, email o teléfono.
     * 
     * @param dto Data Transfer Object del usuario a agregar
     * @return {@code true} si el usuario fue agregado correctamente; {@code false} si ya existe
     */
    public boolean agregarUsuarioVerificando(UsuarioDTO dto) {

        if (esUsuarioDuplicado(dto)) {
            System.out.println("usuario duplicado");
            return false;
        }
        return usuarioDAO.crear(dto);
    }

    /**
     * Verifica si un usuario ya existe en la base de datos por username, email o teléfono.
     * 
     * @param dto Data Transfer Object del usuario a verificar
     * @return {@code true} si el usuario ya existe; {@code false} en caso contrario
     */
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

    /**
     * Obtiene la lista completa de usuarios registrados.
     * 
     * @return {@link List} de {@link Usuario} con todos los usuarios
     */
    public List<Usuario> obtenerUsuarios() {
        return usuarioDAO.getListaUsuarios();
    }

    /**
     * Muestra información de todos los usuarios en formato de texto.
     * 
     * @return {@link String} con la representación textual de todos los usuarios
     */
    public String mostrarUsuarios() {
        return usuarioDAO.mostrar();
    }

    /**
     * Valida las credenciales de un usuario comparando username y password.
     * 
     * @param username Nombre de usuario a validar
     * @param password Contraseña a validar
     * @return {@link Usuario} si las credenciales son correctas; {@code null} en caso contrario
     */
    public Usuario validarCredenciales(String username, String password) {
        for (Usuario u : usuarioDAO.getListaUsuarios()) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Busca un usuario por su username.
     * 
     * @param username Nombre de usuario a buscar
     * @return {@link Usuario} si se encuentra; {@code null} en caso contrario
     */
    public Usuario buscarPorUsername(String username) {
        for (Usuario u : usuarioDAO.getListaUsuarios()) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

}
