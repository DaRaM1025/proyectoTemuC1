package co.edu.unbosque.model;

/**
 * Clase que representa un instrumento musical de viento en forma de DTO (Data Transfer Object).
 * Extiende {@link InstrumentoMusicalDTO} e incluye atributos específicos para este tipo de instrumentos.
 * <p>
 * Contiene información como el tipo de instrumento de viento, afinación, número de válvulas y si requiere boquilla.
 * </p>
 * 
 * @author TuNombre
 */
public class InstrumentoVientoDTO extends InstrumentoMusicalDTO {
	
	/** Tipo de instrumento de viento (ejemplo: trompeta, clarinete, etc.) */
	private String tipoInstrumentoViento;
	
	/** Afinación del instrumento (ejemplo: Do, Sib, etc.) */
	private String afinacion;
	
	/** Número de válvulas que posee el instrumento */
	private int numeroValvulas;
	
	/** Indica si el instrumento requiere boquilla */
	private boolean requiereBoquilla;

	/**
	 * Constructor por defecto.
	 */
	public InstrumentoVientoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con parámetros para inicializar atributos heredados y los específicos.
	 *
	 * @param nombre Nombre del instrumento
	 * @param marca Marca del instrumento
	 * @param tipoProducto Tipo de producto
	 * @param descripcion Descripción del instrumento
	 * @param urlImagen URL de la imagen del instrumento
	 * @param precio Precio del instrumento
	 * @param cantidad Cantidad disponible
	 * @param id Identificador único
	 * @param tipoInstrumentoViento Tipo de instrumento de viento
	 * @param afinacion Afinación del instrumento
	 * @param numeroValvulas Número de válvulas
	 * @param requiereBoquilla Indica si requiere boquilla
	 */
	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoInstrumentoViento, String afinacion, int numeroValvulas,
			boolean requiereBoquilla) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}

	/**
	 * Constructor con parámetros específicos para el instrumento de viento.
	 *
	 * @param tipoInstrumentoViento Tipo de instrumento de viento
	 * @param afinacion Afinación del instrumento
	 * @param numeroValvulas Número de válvulas
	 * @param requiereBoquilla Indica si requiere boquilla
	 */
	public InstrumentoVientoDTO(String tipoInstrumentoViento, String afinacion, int numeroValvulas,
			boolean requiereBoquilla) {
		super();
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}

	/**
	 * Constructor que inicializa el atributo incluyeEstuche.
	 *
	 * @param incluyeEstuche Indica si el instrumento incluye estuche
	 */
	public InstrumentoVientoDTO(boolean incluyeEstuche) {
		super(incluyeEstuche);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con parámetros básicos y si incluye estuche.
	 *
	 * @param nombre Nombre del instrumento
	 * @param marca Marca del instrumento
	 * @param tipoProducto Tipo de producto
	 * @param descripcion Descripción del instrumento
	 * @param urlImagen URL de la imagen del instrumento
	 * @param precio Precio del instrumento
	 * @param cantidad Cantidad disponible
	 * @param id Identificador único
	 * @param incluyeEstuche Indica si incluye estuche
	 */
	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor con parámetros básicos.
	 *
	 * @param nombre Nombre del instrumento
	 * @param marca Marca del instrumento
	 * @param tipoProducto Tipo de producto
	 * @param descripcion Descripción del instrumento
	 * @param urlImagen URL de la imagen del instrumento
	 * @param precio Precio del instrumento
	 * @param cantidad Cantidad disponible
	 * @param id Identificador único
	 */
	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor completo que incluye todos los atributos, heredados y específicos.
	 *
	 * @param nombre Nombre del instrumento
	 * @param marca Marca del instrumento
	 * @param tipoProducto Tipo de producto
	 * @param descripcion Descripción del instrumento
	 * @param urlImagen URL de la imagen del instrumento
	 * @param precio Precio del instrumento
	 * @param cantidad Cantidad disponible
	 * @param id Identificador único
	 * @param incluyeEstuche Indica si incluye estuche
	 * @param tipoInstrumentoViento Tipo de instrumento de viento
	 * @param afinacion Afinación del instrumento
	 * @param numeroValvulas Número de válvulas
	 * @param requiereBoquilla Indica si requiere boquilla
	 */
	public InstrumentoVientoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoViento,
			String afinacion, int numeroValvulas, boolean requiereBoquilla) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
		this.tipoInstrumentoViento = tipoInstrumentoViento;
		this.afinacion = afinacion;
		this.numeroValvulas = numeroValvulas;
		this.requiereBoquilla = requiereBoquilla;
	}

	/**
	 * Obtiene el tipo de instrumento de viento.
	 *
	 * @return tipoInstrumentoViento
	 */
	public String getTipoInstrumentoViento() {
		return tipoInstrumentoViento;
	}

	/**
	 * Establece el tipo de instrumento de viento.
	 *
	 * @param tipoInstrumentoViento Tipo de instrumento
	 */
	public void setTipoInstrumentoViento(String tipoInstrumentoViento) {
		this.tipoInstrumentoViento = tipoInstrumentoViento;
	}

	/**
	 * Obtiene la afinación del instrumento.
	 *
	 * @return afinacion
	 */
	public String getAfinacion() {
		return afinacion;
	}

	/**
	 * Establece la afinación del instrumento.
	 *
	 * @param afinacion Afinación a establecer
	 */
	public void setAfinacion(String afinacion) {
		this.afinacion = afinacion;
	}

	/**
	 * Obtiene el número de válvulas del instrumento.
	 *
	 * @return numeroValvulas
	 */
	public int getNumeroValvulas() {
		return numeroValvulas;
	}

	/**
	 * Establece el número de válvulas del instrumento.
	 *
	 * @param numeroValvulas Número de válvulas
	 */
	public void setNumeroValvulas(int numeroValvulas) {
		this.numeroValvulas = numeroValvulas;
	}

	/**
	 * Verifica si el instrumento requiere boquilla.
	 *
	 * @return true si requiere boquilla, false en caso contrario
	 */
	public boolean isRequiereBoquilla() {
		return requiereBoquilla;
	}

	/**
	 * Establece si el instrumento requiere boquilla.
	 *
	 * @param requiereBoquilla true si requiere boquilla
	 */
	public void setRequiereBoquilla(boolean requiereBoquilla) {
		this.requiereBoquilla = requiereBoquilla;
	}

	/**
	 * Crea una copia del objeto actual.
	 *
	 * @return un nuevo objeto {@link InstrumentoVientoDTO} con los mismos atributos
	 */
	@Override
	public InstrumentoVientoDTO clone() {
		return new InstrumentoVientoDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
				getCantidad(), getId(), isIncluyeEstuche(), getTipoInstrumentoViento(), getAfinacion(), getNumeroValvulas(), isRequiereBoquilla());
	}

}
