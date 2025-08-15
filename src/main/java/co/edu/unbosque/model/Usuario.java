package co.edu.unbosque.model;

import java.util.Date;

public class Usuario {
	private String nombre;
	private String telefono;
	private String email;
	private String username;
	private String password;
	private Date fechaNacimiento;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
