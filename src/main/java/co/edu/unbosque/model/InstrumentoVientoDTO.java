package co.edu.unbosque.model;

public class InstrumentoVientoDTO extends InstrumentoMusicalDTO {
	private String tipoInstrumentoViento; //Posible enum
	private String afinacion;
	private int numeroValvulas;
	private boolean requiereBoquilla;

	public InstrumentoVientoDTO() {
		// TODO Auto-generated constructor stub
	}


	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoInstrumentoViento, String afinacion, int numeroValvulas,
			boolean requiereBoquilla) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}


	public InstrumentoVientoDTO(String tipoInstrumentoViento, String afinacion, int numeroValvulas,
			boolean requiereBoquilla) {
		super();
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}


	public InstrumentoVientoDTO(boolean incluyeEstuche) {
		super(incluyeEstuche);
		// TODO Auto-generated constructor stub
	}


	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		// TODO Auto-generated constructor stub
	}


	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}


	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoViento,
			String afinacion, int numeroValvulas, boolean requiereBoquilla) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}

	public String getTipoInstrumentoViento() {
		return tipoInstrumentoViento;
	}

	public void setTipoInstrumentoViento(String tipoInstrumentoViento) {
		this.tipoInstrumentoViento = tipoInstrumentoViento;
	}

	public String getAfinacion() {
		return afinacion;
	}

	public void setAfinacion(String afinacion) {
		this.afinacion = afinacion;
	}

	public int getNumeroValvulas() {
		return numeroValvulas;
	}

	public void setNumeroValvulas(int numeroValvulas) {
		this.numeroValvulas = numeroValvulas;
	}

	public boolean isRequiereBoquilla() {
		return requiereBoquilla;
	}

	public void setRequiereBoquilla(boolean requiereBoquilla) {
		this.requiereBoquilla = requiereBoquilla;
	}

	@Override
	public InstrumentoVientoDTO clone() {
		return new InstrumentoVientoDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), isIncluyeEstuche(), getTipoInstrumentoViento(), getAfinacion(), getNumeroValvulas(), isRequiereBoquilla());
	}

}
