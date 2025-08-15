package co.edu.unbosque.model;

public class PelucheDTO extends Juguete {
    private boolean tieneSonido;
    private String tipoRelleno; //Posible enum
    private boolean lavadoMaquina;
    public PelucheDTO() {
		// TODO Auto-generated constructor stub
	}

	public PelucheDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean tieneSonido, String tipoRelleno, boolean lavadoMaquina) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tieneSonido = tieneSonido;
		this.tipoRelleno = tipoRelleno;
		this.lavadoMaquina = lavadoMaquina;
	}

	public PelucheDTO(int edadRecomendada, boolean tieneSonido, String tipoRelleno, boolean lavadoMaquina) {
		super(edadRecomendada);
		this.tieneSonido = tieneSonido;
		this.tipoRelleno = tipoRelleno;
		this.lavadoMaquina = lavadoMaquina;
	}

	public PelucheDTO(boolean tieneSonido, String tipoRelleno, boolean lavadoMaquina) {
		super();
		this.tieneSonido = tieneSonido;
		this.tipoRelleno = tipoRelleno;
		this.lavadoMaquina = lavadoMaquina;
	}

	public PelucheDTO(int edadRecomendada) {
		super(edadRecomendada);
		// TODO Auto-generated constructor stub
	}

	public PelucheDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, int edadRecomendada) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
		// TODO Auto-generated constructor stub
	}

	public PelucheDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public PelucheDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, int edadRecomendada, boolean tieneSonido, String tipoRelleno,
			boolean lavadoMaquina) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
		this.tieneSonido = tieneSonido;
		this.tipoRelleno = tipoRelleno;
		this.lavadoMaquina = lavadoMaquina;
	}

	public boolean isTieneSonido() {
		return tieneSonido;
	}

	public void setTieneSonido(boolean tieneSonido) {
		this.tieneSonido = tieneSonido;
	}

	public String getTipoRelleno() {
		return tipoRelleno;
	}

	public void setTipoRelleno(String tipoRelleno) {
		this.tipoRelleno = tipoRelleno;
	}

	public boolean isLavadoMaquina() {
		return lavadoMaquina;
	}

	public void setLavadoMaquina(boolean lavadoMaquina) {
		this.lavadoMaquina = lavadoMaquina;
	}

}
