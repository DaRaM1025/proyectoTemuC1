package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa un Usuario del sistema.
 * Implementa Serializable para permitir la persistencia de objetos.
 */
public class Usuario implements Serializable {

    /** Nombre completo del usuario */
    private String nombre;

    /** Número de teléfono del usuario */
    private String telefono;

    /** Correo electrónico del usuario */
    private String email;

    /** Nombre de usuario para iniciar sesión */
    private String username;

    /** Contraseña del usuario */
    private String password;

    /** Fecha de nacimiento del usuario */
    private Date fechaNacimiento;

    /**
     * Constructor por defecto de Usuario.
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos del Usuario.
     *
     * @param nombre Nombre completo del usuario
     * @param telefono Teléfono del usuario
     * @param email Correo electrónico del usuario
     * @param username Nombre de usuario
     * @param password Contraseña del usuario
     * @param fechaNacimiento Fecha de nacimiento del usuario
     */
    public Usuario(String nombre, String telefono, String email, String username, String password,
                   Date fechaNacimiento) {
        super();
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.username = username;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre completo del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el teléfono del usuario.
     *
     * @return teléfono del usuario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del usuario.
     *
     * @param telefono Teléfono del usuario
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return correo electrónico del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email Correo electrónico del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username Nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password Contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return fecha de nacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento Fecha de nacimiento del usuario
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve una representación en cadena del objeto Usuario.
     *
     * @return cadena con la información del usuario
     */
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", username=" + username
                + ", password=" + password + ", fechaNacimiento=" + fechaNacimiento + "]";
    }

}
