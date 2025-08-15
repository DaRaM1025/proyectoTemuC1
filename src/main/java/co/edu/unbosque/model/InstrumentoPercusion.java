package co.edu.unbosque.model;

public class InstrumentoPercusion extends InstrumentoMusical {
	private String tipoInstrumentoPercusion; // Posible enum
	private boolean usoBaquetas;
	private String tipoPercusion; // Posible enum
	private int cantSuperficiesSonoras;

	public InstrumentoPercusion() {
		// TODO Auto-generated constructor stub
	}

	public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoInstrumentoPercusion, boolean usoBaquetas,
			String tipoPercusion, int cantSuperficiesSonoras) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
		this.usoBaquetas = usoBaquetas;
		this.tipoPercusion = tipoPercusion;
		this.cantSuperficiesSonoras = cantSuperficiesSonoras;
	}

	public InstrumentoPercusion(String tipoInstrumentoPercusion, boolean usoBaquetas, String tipoPercusion,
			int cantSuperficiesSonoras) {
		super();
		this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
		this.usoBaquetas = usoBaquetas;
		this.tipoPercusion = tipoPercusion;
		this.cantSuperficiesSonoras = cantSuperficiesSonoras;
	}

	public InstrumentoPercusion(boolean incluyeEstuche) {
		super(incluyeEstuche);
		// TODO Auto-generated constructor stub
	}

	public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		// TODO Auto-generated constructor stub
	}

	public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoPercusion,
			boolean usoBaquetas, String tipoPercusion, int cantSuperficiesSonoras) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
		this.usoBaquetas = usoBaquetas;
		this.tipoPercusion = tipoPercusion;
		this.cantSuperficiesSonoras = cantSuperficiesSonoras;
	}

	public String getTipoInstrumentoPercusion() {
		return tipoInstrumentoPercusion;
	}

	public void setTipoInstrumentoPercusion(String tipoInstrumentoPercusion) {
		this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
	}

	public boolean isUsoBaquetas() {
		return usoBaquetas;
	}

	public void setUsoBaquetas(boolean usoBaquetas) {
		this.usoBaquetas = usoBaquetas;
	}

	public String getTipoPercusion() {
		return tipoPercusion;
	}

	public void setTipoPercusion(String tipoPercusion) {
		this.tipoPercusion = tipoPercusion;
	}

	public int getCantSuperficiesSonoras() {
		return cantSuperficiesSonoras;
	}

	public void setCantSuperficiesSonoras(int cantSuperficiesSonoras) {
		this.cantSuperficiesSonoras = cantSuperficiesSonoras;
	}

}
