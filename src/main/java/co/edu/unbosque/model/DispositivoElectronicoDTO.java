package co.edu.unbosque.model;

public class DispositivoElectronicoDTO extends Producto {
	protected double pulgadas;
	protected String resolucion;
	protected String sistemaOperativo;

	public DispositivoElectronicoDTO() {
		// TODO Auto-generated constructor stub
	}

	public DispositivoElectronicoDTO(double pulgadas, String resolucion, String sistemaOperativo) {
		super();
		this.pulgadas = pulgadas;
		this.resolucion = resolucion;
		this.sistemaOperativo = sistemaOperativo;
	}

	public DispositivoElectronicoDTO(String nombre, String marca, String tipoProducto, String descripcion,
			String urlImagen, double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public DispositivoElectronicoDTO(String nombre, String marca, String tipoProducto, String descripcion,
			String urlImagen, double precio, int cantidad, String id, double pulgadas, String resolucion,
			String sistemaOperativo) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.pulgadas = pulgadas;
		this.resolucion = resolucion;
		this.sistemaOperativo = sistemaOperativo;
	}

	public double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

}
