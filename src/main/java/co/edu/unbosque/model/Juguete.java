package co.edu.unbosque.model;

public class Juguete extends Producto {
	protected int edadRecomendada;

	public Juguete() {
		// TODO Auto-generated constructor stub
	}

	public Juguete(int edadRecomendada) {
		super();
		this.edadRecomendada = edadRecomendada;
	}

	public Juguete(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public Juguete(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, int edadRecomendada) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.edadRecomendada = edadRecomendada;
	}

	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

}
