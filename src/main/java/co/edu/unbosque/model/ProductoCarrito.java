package co.edu.unbosque.model;

public class ProductoCarrito {
	private String nombre;
	private String id;
	private String imagen;
	private int cantidad;

	public ProductoCarrito(String nombre, String id, String imagen, int cantidad) {
		this.nombre = nombre;
		this.id = id;
		this.imagen = imagen;
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}