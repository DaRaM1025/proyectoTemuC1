package co.edu.unbosque.model;

public class ProductoDTO {
	protected String nombre;
	protected String marca;
	protected String tipoProducto; //Posible enum
	protected String descripcion;
	protected String urlImagen;
	protected double precio;
	protected int cantidad;
	protected String id;

	public ProductoDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.tipoProducto = tipoProducto;
		this.descripcion = descripcion;
		this.urlImagen = urlImagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

