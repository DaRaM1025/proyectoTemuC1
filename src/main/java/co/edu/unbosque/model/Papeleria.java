package co.edu.unbosque.model;

/**
 * Representa un producto del tipo Papelería, que extiende de {@link Producto}.
 * Esta clase añade el atributo específico {@code tipoPresentacion} para
 * definir la presentación del artículo (por ejemplo: paquete, unidad, caja).
 * 
 * <p>
 * Se utiliza para modelar productos del área de papelería en el sistema.
 * </p>
 * 
 * @author David
 * @version 1.0
 */
public class Papeleria extends Producto {

    /**
     * Tipo de presentación del artículo de papelería (ejemplo: caja, unidad, paquete).
     */
    protected String tipoPresentacion; // Posible enum

    /**
     * Constructor por defecto. Inicializa una instancia de {@code Papeleria} sin valores específicos.
     */
    public Papeleria() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa la papelería solo con el tipo de presentación.
     *
     * @param tipoPresentacion tipo de presentación (ejemplo: paquete, unidad, caja).
     */
    public Papeleria(String tipoPresentacion) {
        super();
        this.tipoPresentacion = tipoPresentacion;
    }

    /**
     * Constructor que inicializa una papelería con los datos básicos del producto.
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
    public Papeleria(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa una papelería con todos sus atributos, incluyendo
     * el tipo de presentación.
     *
     * @param nombre           nombre del producto.
     * @param marca            marca del producto.
     * @param tipoProducto     tipo de producto.
     * @param descripcion      descripción del producto.
     * @param urlImagen        URL de la imagen del producto.
     * @param precio           precio del producto.
     * @param cantidad         cantidad disponible.
     * @param id               identificador único del producto.
     * @param tipoPresentacion tipo de presentación (ejemplo: paquete, unidad, caja).
     */
    public Papeleria(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
     * @param tipoPresentacion tipo de presentación (ejemplo: paquete, unidad, caja).
     */
    public void setTipoPresentacion(String tipoPresentacion) {
        this.tipoPresentacion = tipoPresentacion;
    }
}
