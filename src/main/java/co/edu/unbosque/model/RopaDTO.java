package co.edu.unbosque.model;


public class RopaDTO extends Producto {
    protected String talla;
    protected String genero; //Posible enum
    protected String material;

    public RopaDTO() {
		// TODO Auto-generated constructor stub
	}


	public RopaDTO(String talla, String genero, String material) {
		super();
		this.talla = talla;
		this.genero = genero;
		this.material = material;
	}

	public RopaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}


	public RopaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, String talla, String genero, String material) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.talla = talla;
		this.genero = genero;
		this.material = material;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
