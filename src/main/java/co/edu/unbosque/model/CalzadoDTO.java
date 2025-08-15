package co.edu.unbosque.model;

public class CalzadoDTO extends RopaDTO {
    private String tipoCalzado; //Posible enum
    private String ocasion;
    private String materialSuela;
    private double alturaSuela;

    public CalzadoDTO() {
		// TODO Auto-generated constructor stub
	}
	public CalzadoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoCalzado, String ocasion, String materialSuela,
			double alturaSuela) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoCalzado = tipoCalzado;
		this.ocasion = ocasion;
		this.materialSuela = materialSuela;
		this.alturaSuela = alturaSuela;
	}
	public CalzadoDTO(String talla, String genero, String material, String tipoCalzado, String ocasion,
			String materialSuela, double alturaSuela) {
		super(talla, genero, material);
		this.tipoCalzado = tipoCalzado;
		this.ocasion = ocasion;
		this.materialSuela = materialSuela;
		this.alturaSuela = alturaSuela;
	}
	public CalzadoDTO(String tipoCalzado, String ocasion, String materialSuela, double alturaSuela) {
		super();
		this.tipoCalzado = tipoCalzado;
		this.ocasion = ocasion;
		this.materialSuela = materialSuela;
		this.alturaSuela = alturaSuela;
	}
	public CalzadoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String talla, String genero, String material) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
		// TODO Auto-generated constructor stub
	}
	public CalzadoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}
	public CalzadoDTO(String talla, String genero, String material) {
		super(talla, genero, material);
		// TODO Auto-generated constructor stub
	}
	public CalzadoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String talla, String genero, String material, String tipoCalzado,
			String ocasion, String materialSuela, double alturaSuela) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
		this.tipoCalzado = tipoCalzado;
		this.ocasion = ocasion;
		this.materialSuela = materialSuela;
		this.alturaSuela = alturaSuela;
	}

	public String getTipoCalzado() {
		return tipoCalzado;
	}

	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}

	public String getOcasion() {
		return ocasion;
	}

	public void setOcasion(String ocasion) {
		this.ocasion = ocasion;
	}

	public String getMaterialSuela() {
		return materialSuela;
	}

	public void setMaterialSuela(String materialSuela) {
		this.materialSuela = materialSuela;
	}

	public double getAlturaSuela() {
		return alturaSuela;
	}

	public void setAlturaSuela(double alturaSuela) {
		this.alturaSuela = alturaSuela;
	}



}
