package co.edu.unbosque.model;


public class InstrumentoMusical extends Producto {
	protected boolean incluyeEstuche;

	public InstrumentoMusical() {
		// TODO Auto-generated constructor stub
	}

	public InstrumentoMusical(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public InstrumentoMusical(boolean incluyeEstuche) {
		super();
		this.incluyeEstuche = incluyeEstuche;
	}

	public InstrumentoMusical(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.incluyeEstuche = incluyeEstuche;
	}

	public boolean isIncluyeEstuche() {
		return incluyeEstuche;
	}

	public void setIncluyeEstuche(boolean incluyeEstuche) {
		this.incluyeEstuche = incluyeEstuche;
	}

}
