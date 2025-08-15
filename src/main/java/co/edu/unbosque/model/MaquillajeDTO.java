package co.edu.unbosque.model;

public class MaquillajeDTO extends Producto {
    protected String tipoPiel; //Posible enum
    protected boolean esApruebaDeAgua;
    protected String fechaVencimiento;

    public MaquillajeDTO() {
		// TODO Auto-generated constructor stub
	}

    public MaquillajeDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}



    public MaquillajeDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super();
		this.tipoPiel = tipoPiel;
		this.esApruebaDeAgua = esApruebaDeAgua;
		this.fechaVencimiento = fechaVencimiento;
	}

	public MaquillajeDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoPiel = tipoPiel;
		this.esApruebaDeAgua = esApruebaDeAgua;
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTipoPiel() {
		return tipoPiel;
	}

	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	public boolean isEsApruebaDeAgua() {
		return esApruebaDeAgua;
	}

	public void setEsApruebaDeAgua(boolean esApruebaDeAgua) {
		this.esApruebaDeAgua = esApruebaDeAgua;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

}
