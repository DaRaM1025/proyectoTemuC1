package co.edu.unbosque.model;

public class PistolaAguaDTO extends Juguete {
	private double capacidadAgua;
	private int cantidadChorros;
	private double alcanceMaximo;

	public PistolaAguaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.capacidadAgua = capacidadAgua;
		this.cantidadChorros = cantidadChorros;
		this.alcanceMaximo = alcanceMaximo;
	}

	public PistolaAguaDTO(int edadRecomendada, double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
		super(edadRecomendada);
		this.capacidadAgua = capacidadAgua;
		this.cantidadChorros = cantidadChorros;
		this.alcanceMaximo = alcanceMaximo;
	}

	public PistolaAguaDTO(double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
		super();
		this.capacidadAgua = capacidadAgua;
		this.cantidadChorros = cantidadChorros;
		this.alcanceMaximo = alcanceMaximo;
	}

	public PistolaAguaDTO(int edadRecomendada) {
		super(edadRecomendada);
		// TODO Auto-generated constructor stub
	}

	public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, int edadRecomendada) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
		// TODO Auto-generated constructor stub
	}

	public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, int edadRecomendada, double capacidadAgua, int cantidadChorros,
			double alcanceMaximo) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
		this.capacidadAgua = capacidadAgua;
		this.cantidadChorros = cantidadChorros;
		this.alcanceMaximo = alcanceMaximo;
	}

	public double getCapacidadAgua() {
		return capacidadAgua;
	}

	public void setCapacidadAgua(double capacidadAgua) {
		this.capacidadAgua = capacidadAgua;
	}

	public int getCantidadChorros() {
		return cantidadChorros;
	}

	public void setCantidadChorros(int cantidadChorros) {
		this.cantidadChorros = cantidadChorros;
	}

	public double getAlcanceMaximo() {
		return alcanceMaximo;
	}

	public void setAlcanceMaximo(double alcanceMaximo) {
		this.alcanceMaximo = alcanceMaximo;
	}

}
