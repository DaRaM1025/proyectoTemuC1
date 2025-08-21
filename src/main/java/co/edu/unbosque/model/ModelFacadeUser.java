package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.UsuarioDAO;

/**
 * Clase que actúa como fachada para gestionar la lógica relacionada con usuarios.
 * Proporciona acceso centralizado al objeto {@link UsuarioDAO}.
 * 
 * <p>Se utiliza para abstraer la creación y manejo del {@code UsuarioDAO}
 * en la capa de modelo, facilitando el acceso desde otras capas del sistema.</p>
 * 
 * @author TuNombre
 * @version 1.0
 */
public class ModelFacadeUser {

    /**
     * Objeto de acceso a datos para la entidad Usuario.
     */
    private UsuarioDAO usuariodao;

    /**
     * Constructor que inicializa el objeto {@link UsuarioDAO}.
     */
    public ModelFacadeUser() {
        this.usuariodao = new UsuarioDAO();
    }

    /**
     * Obtiene la instancia del objeto {@link UsuarioDAO}.
     * 
     * @return el objeto {@code usuariodao} de tipo {@link UsuarioDAO}.
     */
    public UsuarioDAO getUsuariodao() {
        return usuariodao;
    }

    /**
     * Establece una nueva instancia del objeto {@link UsuarioDAO}.
     * 
     * @param usuariodao el nuevo objeto {@link UsuarioDAO} a asignar.
     */
    public void setUsuariodao(UsuarioDAO usuariodao) {
        this.usuariodao = usuariodao;
    }

    /**
     * Retorna una representación en cadena del objeto.
     * 
     * @return una cadena con el contenido del objeto {@code ModelFacadeUser}.
     */
    @Override
    public String toString() {
        return "ModelFacadeUser [ usuariodao=" + usuariodao + "]";
    }
}
