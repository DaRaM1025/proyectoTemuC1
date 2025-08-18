package co.edu.unbosque.model;

public class MarcadorDTO extends PapeleriaDTO {
	private String tipoPunta; //Posible enum
	private boolean isPermanente;
	private String tipoMarcador; //Posible enum

	public MarcadorDTO() {
		// TODO Auto-generated constructor stub
	}

	public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPunta, boolean isPermanente, String tipoMarcador) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	public MarcadorDTO(String tipoPresentacion, String tipoPunta, boolean isPermanente, String tipoMarcador) {
		super(tipoPresentacion);
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	public MarcadorDTO(String tipoPunta, boolean isPermanente, String tipoMarcador) {
		super();
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		// TODO Auto-generated constructor stub
	}

	public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public MarcadorDTO(String tipoPresentacion) {
		super(tipoPresentacion);
		// TODO Auto-generated constructor stub
	}

	public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion, String tipoPunta, boolean isPermanente,
			String tipoMarcador) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	public String getTipoPunta() {
		return tipoPunta;
	}

	public void setTipoPunta(String tipoPunta) {
		this.tipoPunta = tipoPunta;
	}

	public boolean isPermanente() {
		return isPermanente;
	}

	public void setPermanente(boolean isPermanente) {
		this.isPermanente = isPermanente;
	}

	public String getTipoMarcador() {
		return tipoMarcador;
	}

	public void setTipoMarcador(String tipoMarcador) {
		this.tipoMarcador = tipoMarcador;
	}
	
	public MarcadorDTO clone() {
		return new MarcadorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), getTipoPresentacion(), getTipoPunta(), isPermanente(), getTipoMarcador());
	}

}
