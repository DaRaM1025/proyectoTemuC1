package co.edu.unbosque.model;

public class JugueteDTO extends Producto {
	protected int edadRecomendada;

	public JugueteDTO() {
		// TODO Auto-generated constructor stub
	}

	public JugueteDTO(int edadRecomendada) {
		super();
		this.edadRecomendada = edadRecomendada;
	}

	public JugueteDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public JugueteDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
