package co.edu.unbosque.model;

public class CintaAdhesivaDTO extends PapeleriaDTO {
	private boolean esAdhesivoReposicionable;
	private double ancho;
	private String tipoCinta; //Posible enum

	public CintaAdhesivaDTO() {
		// TODO Auto-generated constructor stub
	}


	public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.esAdhesivoReposicionable = esAdhesivoReposicionable;
		this.ancho = ancho;
		this.tipoCinta = tipoCinta;
	}


	public CintaAdhesivaDTO(String tipoPresentacion, boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
		super(tipoPresentacion);
		this.esAdhesivoReposicionable = esAdhesivoReposicionable;
		this.ancho = ancho;
		this.tipoCinta = tipoCinta;
	}


	public CintaAdhesivaDTO(boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
		super();
		this.esAdhesivoReposicionable = esAdhesivoReposicionable;
		this.ancho = ancho;
		this.tipoCinta = tipoCinta;
	}


	public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		// TODO Auto-generated constructor stub
	}


	public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}


	public CintaAdhesivaDTO(String tipoPresentacion) {
		super(tipoPresentacion);
		// TODO Auto-generated constructor stub
	}


	public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion, boolean esAdhesivoReposicionable,
			double ancho, String tipoCinta) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		this.esAdhesivoReposicionable = esAdhesivoReposicionable;
		this.ancho = ancho;
		this.tipoCinta = tipoCinta;
	}

	public boolean isEsAdhesivoReposicionable() {
		return esAdhesivoReposicionable;
	}

	public void setEsAdhesivoReposicionable(boolean esAdhesivoReposicionable) {
		this.esAdhesivoReposicionable = esAdhesivoReposicionable;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public String getTipoCinta() {
		return tipoCinta;
	}

	public void setTipoCinta(String tipoCinta) {
		this.tipoCinta = tipoCinta;
	}

	@Override
	public CintaAdhesivaDTO clone() {
		return new CintaAdhesivaDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), getTipoPresentacion(), isEsAdhesivoReposicionable(), getAncho(), getTipoCinta());
	}

}

