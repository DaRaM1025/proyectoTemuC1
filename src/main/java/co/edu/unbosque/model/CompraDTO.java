package co.edu.unbosque.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class CompraDTO {
	private UsuarioDTO usuario;
	private ArrayList<ProductoDTO> productos;
	private LocalDate fecha;
	
	
	public CompraDTO(UsuarioDTO usuario, ArrayList<ProductoDTO> productos, LocalDate fecha) {
		super();
		this.usuario = usuario;
		this.productos = productos;
		this.fecha = fecha;
	}
	
	public CompraDTO() {
		super();
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
