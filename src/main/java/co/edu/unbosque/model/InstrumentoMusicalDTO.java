package co.edu.unbosque.model;


public class InstrumentoMusicalDTO extends Producto {
	protected boolean incluyeEstuche;

	public InstrumentoMusicalDTO() {
		// TODO Auto-generated constructor stub
	}

	public InstrumentoMusicalDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public InstrumentoMusicalDTO(boolean incluyeEstuche) {
		super();
		this.incluyeEstuche = incluyeEstuche;
	}

	public InstrumentoMusicalDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
