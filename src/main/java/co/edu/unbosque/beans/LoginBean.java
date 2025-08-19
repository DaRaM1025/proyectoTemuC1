package co.edu.unbosque.beans;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.service.UsuarioService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("loginBean")
@RequestScoped
public class LoginBean {

	private String username;
	private String password;

	@Inject
	private UsuarioService usuarioService;

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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
