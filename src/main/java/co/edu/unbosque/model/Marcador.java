package co.edu.unbosque.model;

/**
 * Representa un marcador, que es un tipo de {@link Papeleria}. Contiene
 * información específica como tipo de punta, si es permanente y el tipo de
 * marcador.
 * 
 * @author David Ramirez
 */
public class Marcador extends Papeleria {

	/**
	 * Tipo de punta del marcador (por ejemplo, fina, gruesa).
	 */
	private String tipoPunta; // Posible enum

	/**
	 * Indica si el marcador es permanente.
	 */
	private boolean isPermanente;

	/**
	 * Tipo de marcador (por ejemplo, resaltador, marcador de pizarra).
	 */
	private String tipoMarcador; // Posible enum

	/**
	 * Constructor por defecto.
	 */
	public Marcador() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa todos los atributos heredados y específicos del
	 * marcador.
	 * 
	 * @param nombre        nombre del marcador
	 * @param marca         marca del marcador
	 * @param tipoProducto  tipo de producto
	 * @param descripcion   descripción del marcador
	 * @param urlImagen     URL de la imagen del marcador
	 * @param precio        precio del marcador
	 * @param cantidad      cantidad disponible
	 * @param id            identificador único
	 * @param tipoPunta     tipo de punta del marcador
	 * @param isPermanente  indica si el marcador es permanente
	 * @param tipoMarcador  tipo de marcador
	 */
	public Marcador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPunta, boolean isPermanente, String tipoMarcador) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	/**
	 * Constructor que inicializa el tipo de presentación y los atributos
	 * específicos del marcador.
	 * 
	 * @param tipoPresentacion tipo de presentación del marcador
	 * @param tipoPunta        tipo de punta del marcador
	 * @param isPermanente     indica si el marcador es permanente
	 * @param tipoMarcador     tipo de marcador
	 */
	public Marcador(String tipoPresentacion, String tipoPunta, boolean isPermanente, String tipoMarcador) {
		super(tipoPresentacion);
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	/**
	 * Constructor que inicializa los atributos específicos del marcador.
	 * 
	 * @param tipoPunta    tipo de punta del marcador
	 * @param isPermanente indica si el marcador es permanente
	 * @param tipoMarcador tipo de marcador
	 */
	public Marcador(String tipoPunta, boolean isPermanente, String tipoMarcador) {
		super();
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	/**
	 * Constructor que inicializa los atributos heredados y el tipo de presentación.
	 * 
	 * @param nombre          nombre del marcador
	 * @param marca           marca del marcador
	 * @param tipoProducto    tipo de producto
	 * @param descripcion     descripción del marcador
	 * @param urlImagen       URL de la imagen del marcador
	 * @param precio          precio del marcador
	 * @param cantidad        cantidad disponible
	 * @param id              identificador único
	 * @param tipoPresentacion tipo de presentación del marcador
	 */
	public Marcador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa los atributos heredados.
	 * 
	 * @param nombre       nombre del marcador
	 * @param marca        marca del marcador
	 * @param tipoProducto tipo de producto
	 * @param descripcion  descripción del marcador
	 * @param urlImagen    URL de la imagen del marcador
	 * @param precio       precio del marcador
	 * @param cantidad     cantidad disponible
	 * @param id           identificador único
	 */
	public Marcador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa el tipo de presentación.
	 * 
	 * @param tipoPresentacion tipo de presentación del marcador
	 */
	public Marcador(String tipoPresentacion) {
		super(tipoPresentacion);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor que inicializa todos los atributos heredados y específicos del
	 * marcador, incluyendo tipo de presentación.
	 * 
	 * @param nombre           nombre del marcador
	 * @param marca            marca del marcador
	 * @param tipoProducto     tipo de producto
	 * @param descripcion      descripción del marcador
	 * @param urlImagen        URL de la imagen del marcador
	 * @param precio           precio del marcador
	 * @param cantidad         cantidad disponible
	 * @param id               identificador único
	 * @param tipoPresentacion tipo de presentación del marcador
	 * @param tipoPunta        tipo de punta del marcador
	 * @param isPermanente     indica si el marcador es permanente
	 * @param tipoMarcador     tipo de marcador
	 */
	public Marcador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
			double precio, int cantidad, String id, String tipoPresentacion, String tipoPunta, boolean isPermanente,
			String tipoMarcador) {
		super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
		this.tipoPunta = tipoPunta;
		this.isPermanente = isPermanente;
		this.tipoMarcador = tipoMarcador;
	}

	/**
	 * Obtiene el tipo de punta del marcador.
	 * 
	 * @return tipo de punta del marcador
	 */
	public String getTipoPunta() {
		return tipoPunta;
	}

	/**
	 * Establece el tipo de punta del marcador.
	 * 
	 * @param tipoPunta tipo de punta del marcador
	 */
	public void setTipoPunta(String tipoPunta) {
		this.tipoPunta = tipoPunta;
	}

	/**
	 * Indica si el marcador es permanente.
	 * 
	 * @return true si el marcador es permanente, false en caso contrario
	 */
	public boolean isPermanente() {
		return isPermanente;
	}

	/**
	 * Establece si el marcador es permanente.
	 * 
	 * @param isPermanente true si el marcador es permanente, false en caso
	 *                     contrario
	 */
	public void setPermanente(boolean isPermanente) {
		this.isPermanente = isPermanente;
	}

	/**
	 * Obtiene el tipo de marcador.
	 * 
	 * @return tipo de marcador
	 */
	public String getTipoMarcador() {
		return tipoMarcador;
	}

	/**
	 * Establece el tipo de marcador.
	 * 
	 * @param tipoMarcador tipo de marcador
	 */
	public void setTipoMarcador(String tipoMarcador) {
		this.tipoMarcador = tipoMarcador;
	}

}
