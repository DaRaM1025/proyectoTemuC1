package co.edu.unbosque.model;

/**
 * Representa un objeto de tipo {@code CintaAdhesivaDTO} que hereda de {@link PapeleriaDTO}.
 * Contiene atributos y métodos relacionados con las características específicas de una cinta adhesiva.
 * 
 * <p>
 * Incluye propiedades como si es reposicionable, el ancho y el tipo de cinta.
 * Además, implementa varios constructores para inicializar diferentes combinaciones
 * de atributos.
 * </p>
 * 
 * @author David Ramirez
 */
public class CintaAdhesivaDTO extends PapeleriaDTO {

    /** Indica si la cinta adhesiva es reposicionable. */
    private boolean esAdhesivoReposicionable;

    /** Ancho de la cinta adhesiva en milímetros o centímetros, según la unidad utilizada. */
    private double ancho;

    /** Tipo de cinta adhesiva (por ejemplo, transparente, doble faz, etc.). */
    private String tipoCinta; // Posible enum

    /**
     * Constructor por defecto.
     */
    public CintaAdhesivaDTO() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa todos los atributos de {@code CintaAdhesivaDTO}.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param esAdhesivoReposicionable Indica si la cinta es reposicionable.
     * @param ancho Ancho de la cinta adhesiva.
     * @param tipoCinta Tipo de cinta adhesiva.
     */
    public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Constructor que inicializa algunos atributos heredados y propios de {@code CintaAdhesivaDTO}.
     * 
     * @param tipoPresentacion Tipo de presentación del producto.
     * @param esAdhesivoReposicionable Indica si la cinta es reposicionable.
     * @param ancho Ancho de la cinta adhesiva.
     * @param tipoCinta Tipo de cinta adhesiva.
     */
    public CintaAdhesivaDTO(String tipoPresentacion, boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
        super(tipoPresentacion);
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Constructor que inicializa únicamente los atributos propios de {@code CintaAdhesivaDTO}.
     * 
     * @param esAdhesivoReposicionable Indica si la cinta es reposicionable.
     * @param ancho Ancho de la cinta adhesiva.
     * @param tipoCinta Tipo de cinta adhesiva.
     */
    public CintaAdhesivaDTO(boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
        super();
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Constructor que inicializa atributos heredados de {@link PapeleriaDTO}.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param tipoPresentacion Tipo de presentación del producto.
     */
    public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPresentacion) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
    }

    /**
     * Constructor que inicializa atributos heredados de {@link PapeleriaDTO}.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     */
    public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa el tipo de presentación.
     * 
     * @param tipoPresentacion Tipo de presentación del producto.
     */
    public CintaAdhesivaDTO(String tipoPresentacion) {
        super(tipoPresentacion);
    }

    /**
     * Constructor que inicializa todos los atributos heredados y propios de {@code CintaAdhesivaDTO}.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param tipoPresentacion Tipo de presentación del producto.
     * @param esAdhesivoReposicionable Indica si la cinta es reposicionable.
     * @param ancho Ancho de la cinta adhesiva.
     * @param tipoCinta Tipo de cinta adhesiva.
     */
    public CintaAdhesivaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPresentacion, boolean esAdhesivoReposicionable,
            double ancho, String tipoCinta) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Verifica si la cinta adhesiva es reposicionable.
     * 
     * @return {@code true} si la cinta es reposicionable, de lo contrario {@code false}.
     */
    public boolean isEsAdhesivoReposicionable() {
        return esAdhesivoReposicionable;
    }

    /**
     * Establece si la cinta adhesiva es reposicionable.
     * 
     * @param esAdhesivoReposicionable {@code true} si la cinta es reposicionable, de lo contrario {@code false}.
     */
    public void setEsAdhesivoReposicionable(boolean esAdhesivoReposicionable) {
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
    }

    /**
     * Obtiene el ancho de la cinta adhesiva.
     * 
     * @return Ancho de la cinta adhesiva.
     */
    public double getAncho() {
        return ancho;
    }

    /**
     * Establece el ancho de la cinta adhesiva.
     * 
     * @param ancho Ancho de la cinta adhesiva.
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    /**
     * Obtiene el tipo de cinta adhesiva.
     * 
     * @return Tipo de cinta adhesiva.
     */
    public String getTipoCinta() {
        return tipoCinta;
    }

    /**
     * Establece el tipo de cinta adhesiva.
     * 
     * @param tipoCinta Tipo de cinta adhesiva.
     */
    public void setTipoCinta(String tipoCinta) {
        this.tipoCinta = tipoCinta;
    }

    /**
     * Crea una copia exacta del objeto actual.
     * 
     * @return Una nueva instancia de {@code CintaAdhesivaDTO} con los mismos valores.
     */
    @Override
    public CintaAdhesivaDTO clone() {
        return new CintaAdhesivaDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(),
                getPrecio(), getCantidad(), getId(), getTipoPresentacion(), isEsAdhesivoReposicionable(), getAncho(),
                getTipoCinta());
    }
}
