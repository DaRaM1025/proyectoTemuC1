package co.edu.unbosque.model;

public class Papeleria extends Producto {
	protected String tipoPresentacion; // Posible enum

	public Papeleria() {
		// TODO Auto-generated constructor stub
	}

	public Papeleria(String tipoPresentacion) {
		super();
		this.tipoPresentacion = tipoPresentacion;
	}

	public Papeleria(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public Papeleria(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoPresentacion = tipoPresentacion;
	}

	public String getTipoPresentacion() {
		return tipoPresentacion;
	}

	public void setTipoPresentacion(String tipoPresentacion) {
		this.tipoPresentacion = tipoPresentacion;
	}

}
