package co.edu.unbosque.beans;

import java.util.Date;

import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.service.UsuarioService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Named(value = "informacionusuariobean")
@RequestScoped
public class InformacionUsuarioBean {

	@NotBlank(message = "El nombre ES OBLIGATORIO👺")
	@Size(max = 30, message = "Máximo 30 caracteres🙄")
	private String nombre;

	@NotBlank(message = "El teléfono es OBLIGATORIO👺")
	private String telefono;

	@NotBlank(message = "El email es OBLIGATORIO👺")
	@Email(message = "El formato de correo inválido🤔")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@gmail\\.com$", message = "Solo se permiten correos de @gmail.com")
	@Size(max = 40, message = "Máximo 40 caracteres🙄")
	private String email;

	@NotBlank(message = "El nombre de usuario es OBLIGATORIO👺")
	@Size(max = 30, message = "Máximo 30 caracteres🙄")
	private String username;

	@NotBlank(message = "La contraseña es OBLIGATORIA👺")
	@Size(min = 8, max = 40, message = "La contraseña debe tener entre 8 y 40 caracteres🙄")
	private String password;

	private Date fechaNacimiento;

	@Inject
	private UsuarioService usuarioService;

	public String guardar() {
	    UsuarioDTO dto = new UsuarioDTO(nombre, telefono, email, username, password, fechaNacimiento);
	    boolean exito = usuarioService.agregarUsuarioVerificando(dto);

	    if (exito) {
	        System.out.println("Usuario guardado con éxito😁");
	        return null;
	    } else {
	    	 FacesContext.getCurrentInstance().addMessage(null,
	    	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "❌ El usuario ya existe (username repetido)", null));
	    	        return null;
	    }
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public void probar() {

		System.out.println("== Datos recibidos ==");
		System.out.println("Nombre: " + nombre);
		System.out.println("Tel: " + telefono);
		System.out.println("Email: " + email);
		System.out.println("User: " + username);
		System.out.println("Pass: " + password);
		System.out.println("Fecha: " + fechaNacimiento);

	}

}
