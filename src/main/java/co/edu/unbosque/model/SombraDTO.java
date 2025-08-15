package co.edu.unbosque.model;

public class SombraDTO extends MaquillajeDTO {
    private int cantidadColores;
    private String acabado;

    public SombraDTO() {
		// TODO Auto-generated constructor stub
	}

	public SombraDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, int cantidadColores,
			String acabado) {
		super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
		this.cantidadColores = cantidadColores;
		this.acabado = acabado;
	}

	public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, int cantidadColores, String acabado) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.cantidadColores = cantidadColores;
		this.acabado = acabado;
	}

	public SombraDTO(int cantidadColores, String acabado) {
		super();
		this.cantidadColores = cantidadColores;
		this.acabado = acabado;
	}

	public SombraDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
		// TODO Auto-generated constructor stub
	}

	public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
				fechaVencimiento);
		// TODO Auto-generated constructor stub
	}

	public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento,
			int cantidadColores, String acabado) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
				fechaVencimiento);
		this.cantidadColores = cantidadColores;
		this.acabado = acabado;
	}

	public int getCantidadColores() {
		return cantidadColores;
	}

	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}

	public String getAcabado() {
		return acabado;
	}

	public void setAcabado(String acabado) {
		this.acabado = acabado;
	}

}
