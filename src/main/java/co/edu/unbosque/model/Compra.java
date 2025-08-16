package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {

	private Usuario usuario;
	private ArrayList<Producto> productos;
	private LocalDate fecha;

	public Compra(Usuario usuario, ArrayList<Producto> productos, LocalDate fecha) {
		super();
		this.usuario = usuario;
		this.productos = productos;
		this.fecha = fecha;
	}

	public Compra() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
