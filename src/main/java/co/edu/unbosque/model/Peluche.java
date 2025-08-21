package co.edu.unbosque.model;

/**
 * Representa un peluche como tipo de {@link Juguete} con atributos específicos para su sonido,
 * tipo de relleno y posibilidad de lavado a máquina.
 * 
 * <p>
 * Esta clase permite definir diferentes tipos de peluches y sus características
 * especiales, como si emiten sonido o si son aptos para lavado en lavadora.
 * </p>
 * 
 * @author David
 * @version 1.0
 */
public class Peluche extends Juguete {

    /**
     * Indica si el peluche tiene sonido.
     */
    private boolean tieneSonido;

    /**
     * Tipo de relleno del peluche (por ejemplo: algodón, fibra sintética, etc.).
     */
    private String tipoRelleno; // Posible enum

    /**
     * Indica si el peluche puede ser lavado a máquina.
     */
    private boolean lavadoMaquina;

    /**
     * Constructor por defecto. Inicializa un peluche sin valores específicos.
     */
    public Peluche() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa un peluche con todos los atributos, incluyendo
     * los de la clase {@link Juguete}.
     * 
     * @param nombre         nombre del peluche.
     * @param marca          marca del peluche.
     * @param tipoProducto   tipo de producto.
     * @param descripcion    descripción del peluche.
     * @param urlImagen      URL de la imagen del peluche.
     * @param precio         precio del peluche.
     * @param cantidad       cantidad disponible.
     * @param id             identificador único del peluche.
     * @param tieneSonido    indica si el peluche tiene sonido.
     * @param tipoRelleno    tipo de relleno del peluche.
     * @param lavadoMaquina  indica si el peluche puede lavarse a máquina.
     */
    public Peluche(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                   double precio, int cantidad, String id, boolean tieneSonido, String tipoRelleno, boolean lavadoMaquina) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tieneSonido = tieneSonido;
        this.tipoRelleno = tipoRelleno;
        this.lavadoMaquina = lavadoMaquina;
    }

    /**
     * Constructor que inicializa un peluche con edad recomendada y atributos
     * específicos.
     * 
     * @param edadRecomendada edad recomendada para el peluche.
     * @param tieneSonido     indica si el peluche tiene sonido.
     * @param tipoRelleno     tipo de relleno del peluche.
     * @param lavadoMaquina   indica si el peluche puede lavarse a máquina.
     */
    public Peluche(int edadRecomendada, boolean tieneSonido, String tipoRelleno, boolean lavadoMaquina) {
        super(edadRecomendada);
        this.tieneSonido = tieneSonido;
        this.tipoRelleno = tipoRelleno;
        this.lavadoMaquina = lavadoMaquina;
    }

    /**
     * Constructor que inicializa un peluche con sus atributos específicos sin edad recomendada.
     * 
     * @param tieneSonido    indica si el peluche tiene sonido.
     * @param tipoRelleno    tipo de relleno del peluche.
     * @param lavadoMaquina  indica si el peluche puede lavarse a máquina.
     */
    public Peluche(boolean tieneSonido, String tipoRelleno, boolean lavadoMaquina) {
        super();
        this.tieneSonido = tieneSonido;
        this.tipoRelleno = tipoRelleno;
        this.lavadoMaquina = lavadoMaquina;
    }

    /**
     * Constructor que inicializa un peluche únicamente con edad recomendada.
     * 
     * @param edadRecomendada edad recomendada para el peluche.
     */
    public Peluche(int edadRecomendada) {
        super(edadRecomendada);
    }

    /**
     * Constructor que inicializa un peluche con todos los atributos incluyendo edad recomendada.
     * 
     * @param nombre          nombre del peluche.
     * @param marca           marca del peluche.
     * @param tipoProducto    tipo de producto.
     * @param descripcion     descripción del peluche.
     * @param urlImagen       URL de la imagen del peluche.
     * @param precio          precio del peluche.
     * @param cantidad        cantidad disponible.
     * @param id              identificador único del peluche.
     * @param edadRecomendada edad recomendada para el peluche.
     * @param tieneSonido     indica si el peluche tiene sonido.
     * @param tipoRelleno     tipo de relleno del peluche.
     * @param lavadoMaquina   indica si el peluche puede lavarse a máquina.
     */
    public Peluche(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                   double precio, int cantidad, String id, int edadRecomendada, boolean tieneSonido, String tipoRelleno,
                   boolean lavadoMaquina) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
        this.tieneSonido = tieneSonido;
        this.tipoRelleno = tipoRelleno;
        this.lavadoMaquina = lavadoMaquina;
    }

    /**
     * Indica si el peluche tiene sonido.
     * 
     * @return true si tiene sonido, false de lo contrario.
     */
    public boolean isTieneSonido() {
        return tieneSonido;
    }

    /**
     * Establece si el peluche tiene sonido.
     * 
     * @param tieneSonido valor a asignar.
     */
    public void setTieneSonido(boolean tieneSonido) {
        this.tieneSonido = tieneSonido;
    }

    /**
     * Obtiene el tipo de relleno del peluche.
     * 
     * @return tipo de relleno.
     */
    public String getTipoRelleno() {
        return tipoRelleno;
    }

    /**
     * Establece el tipo de relleno del peluche.
     * 
     * @param tipoRelleno tipo de relleno a asignar.
     */
    public void setTipoRelleno(String tipoRelleno) {
        this.tipoRelleno = tipoRelleno;
    }

    /**
     * Indica si el peluche puede lavarse a máquina.
     * 
     * @return true si puede lavarse a máquina, false de lo contrario.
     */
    public boolean isLavadoMaquina() {
        return lavadoMaquina;
    }

    /**
     * Establece si el peluche puede lavarse a máquina.
     * 
     * @param lavadoMaquina valor a asignar.
     */
    public void setLavadoMaquina(boolean lavadoMaquina) {
        this.lavadoMaquina = lavadoMaquina;
    }
}
