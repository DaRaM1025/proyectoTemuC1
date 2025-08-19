package co.edu.unbosque.model;

public class ComputadorDTO extends DispositivoElectronicoDTO {
	private String almacenamiento;
	private String ram;
	private String procesador;
	private String tarjetaGrafica;

	public ComputadorDTO() {
		// TODO Auto-generated constructor stub
	}

	public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
			String almacenamiento, String ram, String procesador, String tarjetaGrafica) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
				sistemaOperativo);
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.procesador = procesador;
		this.tarjetaGrafica = tarjetaGrafica;
	}

	public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String almacenamiento, String ram, String procesador,
			String tarjetaGrafica) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.procesador = procesador;
		this.tarjetaGrafica = tarjetaGrafica;
	}

	public ComputadorDTO(double pulgadas, String resolucion, String sistemaOperativo, String almacenamiento, String ram,
			String procesador, String tarjetaGrafica) {
		super(pulgadas, resolucion, sistemaOperativo);
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.procesador = procesador;
		this.tarjetaGrafica = tarjetaGrafica;
	}

	public ComputadorDTO(String almacenamiento, String ram, String procesador, String tarjetaGrafica) {
		super();
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.procesador = procesador;
		this.tarjetaGrafica = tarjetaGrafica;
	}

	public ComputadorDTO(double pulgadas, String resolucion, String sistemaOperativo) {
		super(pulgadas, resolucion, sistemaOperativo);
		// TODO Auto-generated constructor stub
	}

	public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
				sistemaOperativo);
		// TODO Auto-generated constructor stub
	}

	public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
			String almacenamiento, String ram, String tipo, String procesador, String tarjetaGrafica) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
				sistemaOperativo);
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.procesador = procesador;
		this.tarjetaGrafica = tarjetaGrafica;
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public String getTarjetaGrafica() {
		return tarjetaGrafica;
	}

	public void setTarjetaGrafica(String tarjetaGrafica) {
		this.tarjetaGrafica = tarjetaGrafica;
	}

	@Override
	public ComputadorDTO clone() {
		return new ComputadorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), getPulgadas(), getResolucion(), getSistemaOperativo(), getAlmacenamiento(), getRam(), getProcesador(), getTarjetaGrafica());
	}

}
