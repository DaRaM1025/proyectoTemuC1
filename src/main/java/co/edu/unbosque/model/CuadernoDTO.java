package co.edu.unbosque.model;

public class CuadernoDTO extends PapeleriaDTO {
	private String tipoHojas; //Posible enum
	private int cantidadHojas;
	private boolean isPastaDura;

	public CuadernoDTO() {
		// TODO Auto-generated constructor stub
	}


	public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoHojas, int cantidadHojas, boolean isPastaDura) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoHojas = tipoHojas;
		this.cantidadHojas = cantidadHojas;
		this.isPastaDura = isPastaDura;
	}


	public CuadernoDTO(String tipoPresentacion, String tipoHojas, int cantidadHojas, boolean isPastaDura) {
		super(tipoPresentacion);
		this.tipoHojas = tipoHojas;
		this.cantidadHojas = cantidadHojas;
		this.isPastaDura = isPastaDura;
	}


	public CuadernoDTO(String tipoHojas, int cantidadHojas, boolean isPastaDura) {
		super();
		this.tipoHojas = tipoHojas;
		this.cantidadHojas = cantidadHojas;
		this.isPastaDura = isPastaDura;
	}


	public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		// TODO Auto-generated constructor stub
	}


	public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}


	public CuadernoDTO(String tipoPresentacion) {
		super(tipoPresentacion);
		// TODO Auto-generated constructor stub
	}


	public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion, String tipoHojas, int cantidadHojas,
			boolean isPastaDura) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		this.tipoHojas = tipoHojas;
		this.cantidadHojas = cantidadHojas;
		this.isPastaDura = isPastaDura;
	}

	public String getTipoHojas() {
		return tipoHojas;
	}

	public void setTipoHojas(String tipoHojas) {
		this.tipoHojas = tipoHojas;
	}

	public int getCantidadHojas() {
		return cantidadHojas;
	}

	public void setCantidadHojas(int cantidadHojas) {
		this.cantidadHojas = cantidadHojas;
	}

	public boolean isPastaDura() {
		return isPastaDura;
	}

	public void setPastaDura(boolean isPastaDura) {
		this.isPastaDura = isPastaDura;
	}
	
	public CuadernoDTO clone() {
		return new CuadernoDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), getTipoPresentacion(), getTipoHojas(), getCantidadHojas(), isPastaDura());
	}

}

