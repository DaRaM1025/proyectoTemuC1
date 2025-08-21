package co.edu.unbosque.model;

/**
 * Representa un instrumento musical de viento que hereda de {@link InstrumentoMusical}.
 * Contiene atributos específicos para instrumentos de viento, como el tipo, afinación,
 * número de válvulas y si requiere boquilla.
 * 
 * @author David Ramirez
 */
public class InstrumentoViento extends InstrumentoMusical {
	
	/**
	 * Tipo específico del instrumento de viento (por ejemplo: trompeta, clarinete, flauta).
	 */
	private String tipoInstrumentoViento; // Posible enum
	
	/**
	 * Afinación del instrumento (por ejemplo: Do, Si bemol).
	 */
	private String afinacion;
	
	/**
	 * Número de válvulas que posee el instrumento (si aplica).
	 */
	private int numeroValvulas;
	
	/**
	 * Indica si el instrumento requiere boquilla.
	 */
	private boolean requiereBoquilla;

	/**
	 * Constructor por defecto.
	 */
	public InstrumentoViento() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa todos los atributos heredados y propios del instrumento de viento.
	 *
	 * @param nombre Nombre del instrumento.
	 * @param marca Marca del instrumento.
	 * @param tipoProducto Tipo del producto.
	 * @param descripcion Descripción del instrumento.
	 * @param urlImagen URL de la imagen del instrumento.
	 * @param precio Precio del instrumento.
	 * @param cantidad Cantidad disponible.
	 * @param id Identificador único del instrumento.
	 * @param tipoInstrumentoViento Tipo específico del instrumento de viento.
	 * @param afinacion Afinación del instrumento.
	 * @param numeroValvulas Número de válvulas del instrumento.
	 * @param requiereBoquilla Indica si requiere boquilla.
	 */
	public InstrumentoViento(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoInstrumentoViento, String afinacion, int numeroValvulas,
			boolean requiereBoquilla) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}

	/**
	 * Constructor que inicializa los atributos propios del instrumento de viento.
	 *
	 * @param tipoInstrumentoViento Tipo del instrumento de viento.
	 * @param afinacion Afinación del instrumento.
	 * @param numeroValvulas Número de válvulas.
	 * @param requiereBoquilla Indica si requiere boquilla.
	 */
	public InstrumentoViento(String tipoInstrumentoViento, String afinacion, int numeroValvulas,
			boolean requiereBoquilla) {
		super();
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}

	/**
	 * Constructor que inicializa el atributo {@code incluyeEstuche}.
	 *
	 * @param incluyeEstuche Indica si el instrumento incluye estuche.
	 */
	public InstrumentoViento(boolean incluyeEstuche) {
		super(incluyeEstuche);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos heredados y el atributo {@code incluyeEstuche}.
	 *
	 * @param nombre Nombre del instrumento.
	 * @param marca Marca del instrumento.
	 * @param tipoProducto Tipo del producto.
	 * @param descripcion Descripción del instrumento.
	 * @param urlImagen URL de la imagen del instrumento.
	 * @param precio Precio del instrumento.
	 * @param cantidad Cantidad disponible.
	 * @param id Identificador único.
	 * @param incluyeEstuche Indica si incluye estuche.
	 */
	public InstrumentoViento(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos heredados sin información adicional.
	 *
	 * @param nombre Nombre del instrumento.
	 * @param marca Marca del instrumento.
	 * @param tipoProducto Tipo del producto.
	 * @param descripcion Descripción del instrumento.
	 * @param urlImagen URL de la imagen del instrumento.
	 * @param precio Precio del instrumento.
	 * @param cantidad Cantidad disponible.
	 * @param id Identificador único.
	 */
	public InstrumentoViento(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa todos los atributos heredados y propios, incluyendo estuche.
	 *
	 * @param nombre Nombre del instrumento.
	 * @param marca Marca del instrumento.
	 * @param tipoProducto Tipo del producto.
	 * @param descripcion Descripción del instrumento.
	 * @param urlImagen URL de la imagen del instrumento.
	 * @param precio Precio del instrumento.
	 * @param cantidad Cantidad disponible.
	 * @param id Identificador único.
	 * @param incluyeEstuche Indica si incluye estuche.
	 * @param tipoInstrumentoViento Tipo específico del instrumento de viento.
	 * @param afinacion Afinación del instrumento.
	 * @param numeroValvulas Número de válvulas.
	 * @param requiereBoquilla Indica si requiere boquilla.
	 */
	public InstrumentoViento(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoViento,
			String afinacion, int numeroValvulas, boolean requiereBoquilla) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}

	/**
	 * Obtiene el tipo específico del instrumento de viento.
	 *
	 * @return tipo del instrumento de viento.
	 */
	public String getTipoInstrumentoViento() {
		return tipoInstrumentoViento;
	}

	/**
	 * Establece el tipo del instrumento de viento.
	 *
	 * @param tipoInstrumentoViento tipo del instrumento.
	 */
	public void setTipoInstrumentoViento(String tipoInstrumentoViento) {
		this.tipoInstrumentoViento = tipoInstrumentoViento;
	}

	/**
	 * Obtiene la afinación del instrumento.
	 *
	 * @return afinación del instrumento.
	 */
	public String getAfinacion() {
		return afinacion;
	}

	/**
	 * Establece la afinación del instrumento.
	 *
	 * @param afinacion afinación a asignar.
	 */
	public void setAfinacion(String afinacion) {
		this.afinacion = afinacion;
	}

	/**
	 * Obtiene el número de válvulas del instrumento.
	 *
	 * @return número de válvulas.
	 */
	public int getNumeroValvulas() {
		return numeroValvulas;
	}

	/**
	 * Establece el número de válvulas del instrumento.
	 *
	 * @param numeroValvulas número de válvulas.
	 */
	public void setNumeroValvulas(int numeroValvulas) {
		this.numeroValvulas = numeroValvulas;
	}

	/**
	 * Verifica si el instrumento requiere boquilla.
	 *
	 * @return {@code true} si requiere boquilla, {@code false} en caso contrario.
	 */
	public boolean isRequiereBoquilla() {
		return requiereBoquilla;
	}

	/**
	 * Establece si el instrumento requiere boquilla.
	 *
	 * @param requiereBoquilla valor booleano que indica si requiere boquilla.
	 */
	public void setRequiereBoquilla(boolean requiereBoquilla) {
		this.requiereBoquilla = requiereBoquilla;
	}

}
