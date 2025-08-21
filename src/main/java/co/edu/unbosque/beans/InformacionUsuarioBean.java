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

/**
 * Administra el formulario para crear y manejar datos de usuarios.
 * Proporciona funcionalidad para guardar la información del usuario utilizando el servicio UsuarioService,
 * validando los datos ingresados y mostrando mensajes de error si es necesario.
 * @author David Santiago Ramirez Arevalo
 */
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

    /**
     * Guarda los datos del usuario en el servicio UsuarioService, verificando si el nombre de usuario ya existe.
     * Muestra un mensaje de error si el usuario ya está registrado.
     * @return null para permanecer en la misma página
     */
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

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre El nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono del usuario.
     * @return El número de teléfono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del usuario.
     * @param telefono El número de teléfono a establecer
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return El correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email El correo electrónico a establecer
     */
    public void setEmail(String email) {
        this.email = email;
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

    /**
     * Obtiene la fecha de nacimiento del usuario.
     * @return La fecha de nacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     * @param fechaNacimiento La fecha de nacimiento a establecer
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Imprime los datos del usuario en la consola para propósitos de prueba.
     */
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