package co.edu.unbosque.beans;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.service.UsuarioService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Administra el proceso de inicio de sesión de usuarios.
 * Valida las credenciales del usuario utilizando el servicio UsuarioService y gestiona
 * la sesión del usuario, mostrando mensajes de éxito o error según corresponda.
 * @author David Santiago Ramirez Arevalo
 */
@Named("loginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    @Inject
    private UsuarioService usuarioService;

    /**
     * Valida las credenciales del usuario y gestiona el inicio de sesión.
     * Si las credenciales son correctas, almacena el nombre de usuario y el objeto usuario
     * en la sesión y redirige a la página principal. Si son incorrectas, muestra un mensaje de error.
     * @return La URL de redirección a la página principal si el inicio de sesión es exitoso, o null si falla
     */
    public String login() {
        Usuario usuarioEncontrado = usuarioService.validarCredenciales(username, password);
        if (usuarioEncontrado != null) {
            FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("usuarioLogueado", username);
            FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().put("usuarioActual", usuarioEncontrado);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "¡Bienvenido, " + usuarioEncontrado.getNombre() + "💗!", null));
            return "index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Usuario o contraseña incorrectos👺", null));
            return null;
        }
    }

    /**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     * @param username El nombre de usuario a establecer
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password La contraseña a establecer
     */
    public void setPassword(String password) {
        this.password = password;
    }
}