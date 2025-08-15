package co.edu.unbosque.model;

public class LabialDTO extends Maquillaje {
    private String duracion;
    private boolean esHidratante;

    public LabialDTO() {
		// TODO Auto-generated constructor stub
	}

	public LabialDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String duracion,
			boolean esHidratante) {
		super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
		this.duracion = duracion;
		this.esHidratante = esHidratante;
	}

	public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, String duracion, boolean esHidratante) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.duracion = duracion;
		this.esHidratante = esHidratante;
	}

	public LabialDTO(String duracion, boolean esHidratante) {
		super();
		this.duracion = duracion;
		this.esHidratante = esHidratante;
	}

	public LabialDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
		// TODO Auto-generated constructor stub
	}

	public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
				fechaVencimiento);
		// TODO Auto-generated constructor stub
	}

	public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String duracion,
			boolean esHidratante) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
				fechaVencimiento);
		this.duracion = duracion;
		this.esHidratante = esHidratante;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public boolean isEsHidratante() {
		return esHidratante;
	}

	public void setEsHidratante(boolean esHidratante) {
		this.esHidratante = esHidratante;
	}

}
