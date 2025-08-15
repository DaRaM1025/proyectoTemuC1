package co.edu.unbosque.model;

public class Camiseta extends Ropa {
	private String tipoManga; // Posible enum
	private String cuello;
	private boolean isEstampado;

	public Camiseta() {
		// TODO Auto-generated constructor stub
	}

	public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoManga, String cuello, boolean isEstampado) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoManga = tipoManga;
		this.cuello = cuello;
		this.isEstampado = isEstampado;
	}

	public Camiseta(String talla, String genero, String material, String tipoManga, String cuello,
			boolean isEstampado) {
		super(talla, genero, material);
		this.tipoManga = tipoManga;
		this.cuello = cuello;
		this.isEstampado = isEstampado;
	}

	public Camiseta(String tipoManga, String cuello, boolean isEstampado) {
		super();
		this.tipoManga = tipoManga;
		this.cuello = cuello;
		this.isEstampado = isEstampado;
	}

	public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String talla, String genero, String material) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
		// TODO Auto-generated constructor stub
	}

	public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public Camiseta(String talla, String genero, String material) {
		super(talla, genero, material);
		// TODO Auto-generated constructor stub
	}

	public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String talla, String genero, String material, String tipoManga,
			String cuello, boolean isEstampado) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
		this.tipoManga = tipoManga;
		this.cuello = cuello;
		this.isEstampado = isEstampado;
	}

	public String getTipoManga() {
		return tipoManga;
	}

	public void setTipoManga(String tipoManga) {
		this.tipoManga = tipoManga;
	}

	public String getCuello() {
		return cuello;
	}

	public void setCuello(String cuello) {
		this.cuello = cuello;
	}

	public boolean isEstampado() {
		return isEstampado;
	}

	public void setEstampado(boolean isEstampado) {
		this.isEstampado = isEstampado;
	}

}
