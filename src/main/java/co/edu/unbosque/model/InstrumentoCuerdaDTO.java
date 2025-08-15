package co.edu.unbosque.model;

public class InstrumentoCuerdaDTO extends InstrumentoMusical {
	private String tipoInstrumentoCuerda; //Posible enum
	private int numeroCuerdas;
	private String tipoCuerda; //Posible enum
	private boolean tieneCajaResonancia;
public InstrumentoCuerdaDTO() {
	// TODO Auto-generated constructor stub
}
	public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
		double precio, int cantidad, String id, String tipoInstrumentoCuerda, int numeroCuerdas, String tipoCuerda,
		boolean tieneCajaResonancia) {
	super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
	this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
	this.numeroCuerdas = numeroCuerdas;
	this.tipoCuerda = tipoCuerda;
	this.tieneCajaResonancia = tieneCajaResonancia;
}
	public InstrumentoCuerdaDTO(String tipoInstrumentoCuerda, int numeroCuerdas, String tipoCuerda,
		boolean tieneCajaResonancia) {
	super();
	this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
	this.numeroCuerdas = numeroCuerdas;
	this.tipoCuerda = tipoCuerda;
	this.tieneCajaResonancia = tieneCajaResonancia;
}
	public InstrumentoCuerdaDTO(boolean incluyeEstuche) {
	super(incluyeEstuche);
	// TODO Auto-generated constructor stub
}
public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
		double precio, int cantidad, String id, boolean incluyeEstuche) {
	super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
	// TODO Auto-generated constructor stub
}
public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
		double precio, int cantidad, String id) {
	super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
	// TODO Auto-generated constructor stub
}
	public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoCuerda,
			int numeroCuerdas, String tipoCuerda, boolean tieneCajaResonancia) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
		this.numeroCuerdas = numeroCuerdas;
		this.tipoCuerda = tipoCuerda;
		this.tieneCajaResonancia = tieneCajaResonancia;
	}

	public String getTipoInstrumentoCuerda() {
		return tipoInstrumentoCuerda;
	}

	public void setTipoInstrumentoCuerda(String tipoInstrumentoCuerda) {
		this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
	}

	public int getNumeroCuerdas() {
		return numeroCuerdas;
	}

	public void setNumeroCuerdas(int numeroCuerdas) {
		this.numeroCuerdas = numeroCuerdas;
	}

	public String getTipoCuerda() {
		return tipoCuerda;
	}

	public void setTipoCuerda(String tipoCuerda) {
		this.tipoCuerda = tipoCuerda;
	}

	public boolean isTieneCajaResonancia() {
		return tieneCajaResonancia;
	}

	public void setTieneCajaResonancia(boolean tieneCajaResonancia) {
		this.tieneCajaResonancia = tieneCajaResonancia;
	}

}
