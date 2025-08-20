package co.edu.unbosque.model;

public class TelevisorDTO extends DispositivoElectronicoDTO {
	private int cantPuertosHDMI;
	private int frecuenciaHz;
	private String asistenteVirtual;

	public TelevisorDTO() {
		// TODO Auto-generated constructor stub
	}
	public TelevisorDTO(double pulgadas, String resolucion, String sistemaOperativo, int cantPuertosHDMI, int frecuenciaHz,
			String asistenteVirtual) {
		super(pulgadas, resolucion, sistemaOperativo);
		this.cantPuertosHDMI = cantPuertosHDMI;
		this.frecuenciaHz = frecuenciaHz;
		this.asistenteVirtual = asistenteVirtual;
	}
	public TelevisorDTO(int cantPuertosHDMI, int frecuenciaHz, String asistenteVirtual) {
		super();
		this.cantPuertosHDMI = cantPuertosHDMI;
		this.frecuenciaHz = frecuenciaHz;
		this.asistenteVirtual = asistenteVirtual;
	}
	public TelevisorDTO(double pulgadas, String resolucion, String sistemaOperativo) {
		super(pulgadas, resolucion, sistemaOperativo);
		// TODO Auto-generated constructor stub
	}
	public TelevisorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
				sistemaOperativo);
		// TODO Auto-generated constructor stub
	}
	public TelevisorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}
	public TelevisorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
			int cantPuertosHDMI, int frecuenciaHz, String asistenteVirtual) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
				sistemaOperativo);
		this.cantPuertosHDMI = cantPuertosHDMI;
		this.frecuenciaHz = frecuenciaHz;
		this.asistenteVirtual = asistenteVirtual;
	}

	public int getCantPuertosHDMI() {
		return cantPuertosHDMI;
	}

	public void setCantPuertosHDMI(int cantPuertosHDMI) {
		this.cantPuertosHDMI = cantPuertosHDMI;
	}

	public int getFrecuenciaHz() {
		return frecuenciaHz;
	}

	public void setFrecuenciaHz(int frecuenciaHz) {
		this.frecuenciaHz = frecuenciaHz;
	}

	public String getAsistenteVirtual() {
		return asistenteVirtual;
	}

	public void setAsistenteVirtual(String asistenteVirtual) {
		this.asistenteVirtual = asistenteVirtual;
	}

	@Override
	public TelevisorDTO clone() {
		return new TelevisorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), getPulgadas(), getResolucion(), getSistemaOperativo(), getCantPuertosHDMI(), getFrecuenciaHz(), getAsistenteVirtual());
	}

}
