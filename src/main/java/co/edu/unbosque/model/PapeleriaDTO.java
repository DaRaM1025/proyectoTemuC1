package co.edu.unbosque.model;

/**
 * Representa un objeto de transferencia de datos (DTO) para productos de tipo Papelería.
 * Extiende de {@link ProductoDTO} y añade el atributo {@code tipoPresentacion}.
 * 
 * <p>
 * Esta clase se utiliza para transferir datos entre capas de la aplicación sin exponer
 * la lógica de negocio de la entidad {@link Papeleria}.
 * </p>
 * 
 * @author David
 * @version 1.0
 */
public class PapeleriaDTO extends ProductoDTO {

    /**
     * Tipo de presentación del producto de papelería (por ejemplo: paquete, unidad, caja).
     */
    protected String tipoPresentacion; // Posible enum

    /**
     * Constructor por defecto. Inicializa una instancia de {@code PapeleriaDTO} sin valores específicos.
     */
    public PapeleriaDTO() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa la papelería DTO con el tipo de presentación.
     *
     * @param tipoPresentacion tipo de presentación del producto.
     */
    public PapeleriaDTO(String tipoPresentacion) {
        super();
        this.tipoPresentacion = tipoPresentacion;
    }

    /**
     * Constructor que inicializa la papelería DTO con los datos básicos del producto.
     *
     * @param nombre       nombre del producto.
     * @param marca        marca del producto.
     * @param tipoProducto tipo de producto.
     * @param descripcion  descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       precio del producto.
     * @param cantidad     cantidad disponible.
     * @param id           identificador único del producto.
     */
    public PapeleriaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa la papelería DTO con todos sus atributos, incluyendo tipo de presentación.
     *
     * @param nombre           nombre del producto.
     * @param marca            marca del producto.
     * @param tipoProducto     tipo de producto.
     * @param descripcion      descripción del producto.
     * @param urlImagen        URL de la imagen del producto.
     * @param precio           precio del producto.
     * @param cantidad         cantidad disponible.
     * @param id               identificador único del producto.
     * @param tipoPresentacion tipo de presentación del producto.
     */
    public PapeleriaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPresentacion) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoPresentacion = tipoPresentacion;
    }

    /**
     * Obtiene el tipo de presentación del producto de papelería.
     *
     * @return tipo de presentación.
     */
    public String getTipoPresentacion() {
        return tipoPresentacion;
    }

    /**
     * Establece el tipo de presentación del producto de papelería.
     *
     * @param tipoPresentacion tipo de presentación a asignar.
     */
    public void setTipoPresentacion(String tipoPresentacion) {
        this.tipoPresentacion = tipoPresentacion;
    }
}
