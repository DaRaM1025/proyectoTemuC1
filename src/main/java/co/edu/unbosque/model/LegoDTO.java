package co.edu.unbosque.model;

public class LegoDTO extends Juguete {
	private String tema;
	private int numeroPiezas;
	private boolean tieneMinifiguras;

	public LegoDTO() {
		// TODO Auto-generated constructor stub
	}

	public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, String tema, int numeroPiezas, boolean tieneMinifiguras) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tema = tema;
		this.numeroPiezas = numeroPiezas;
		this.tieneMinifiguras = tieneMinifiguras;
	}

	public LegoDTO(int edadRecomendada, String tema, int numeroPiezas, boolean tieneMinifiguras) {
		super(edadRecomendada);
		this.tema = tema;
		this.numeroPiezas = numeroPiezas;
		this.tieneMinifiguras = tieneMinifiguras;
	}

	public LegoDTO(String tema, int numeroPiezas, boolean tieneMinifiguras) {
		super();
		this.tema = tema;
		this.numeroPiezas = numeroPiezas;
		this.tieneMinifiguras = tieneMinifiguras;
	}

	public LegoDTO(int edadRecomendada) {
		super(edadRecomendada);
		// TODO Auto-generated constructor stub
	}

	public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, int edadRecomendada) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
		// TODO Auto-generated constructor stub
	}

	public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
			int cantidad, String id, int edadRecomendada, String tema, int numeroPiezas, boolean tieneMinifiguras) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
		this.tema = tema;
		this.numeroPiezas = numeroPiezas;
		this.tieneMinifiguras = tieneMinifiguras;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getNumeroPiezas() {
		return numeroPiezas;
	}

	public void setNumeroPiezas(int numeroPiezas) {
		this.numeroPiezas = numeroPiezas;
	}

	public boolean isTieneMinifiguras() {
		return tieneMinifiguras;
	}

	public void setTieneMinifiguras(boolean tieneMinifiguras) {
		this.tieneMinifiguras = tieneMinifiguras;
	}

}
