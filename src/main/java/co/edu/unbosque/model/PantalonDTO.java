package co.edu.unbosque.model;

public class PantalonDTO extends RopaDTO {
    private String tipoPantalon; //Posible enum
    private String corte;
    private String largo;
    public PantalonDTO() {
		// TODO Auto-generated constructor stub
	}
	public PantalonDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String talla, String genero, String material) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
		// TODO Auto-generated constructor stub
	}
	public PantalonDTO(String talla, String genero, String material, String tipoPantalon, String corte, String largo) {
		super(talla, genero, material);
		this.tipoPantalon = tipoPantalon;
		this.corte = corte;
		this.largo = largo;
	}
	public PantalonDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}
	public PantalonDTO(String talla, String genero, String material) {
		super(talla, genero, material);
		// TODO Auto-generated constructor stub
	}
	public PantalonDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String talla, String genero, String material, String tipoPantalon,
			String corte, String largo) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
		this.tipoPantalon = tipoPantalon;
		this.corte = corte;
		this.largo = largo;
	}

	public String getTipoPantalon() {
		return tipoPantalon;
	}

	public void setTipoPantalon(String tipoPantalon) {
		this.tipoPantalon = tipoPantalon;
	}

	public String getCorte() {
		return corte;
	}

	public void setCorte(String corte) {
		this.corte = corte;
	}

	public String getLargo() {
		return largo;
	}

	public void setLargo(String largo) {
		this.largo = largo;
	}

}
