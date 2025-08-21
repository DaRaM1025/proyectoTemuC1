package co.edu.unbosque.model;

/**
 * Representa una cinta adhesiva, un tipo de {@link Papeleria}.
 * Incluye características específicas como si es reposicionable,
 * el ancho y el tipo de cinta.
 * 
 * <p>Ejemplos de tipos de cinta pueden ser: transparente, enmascarar, doble faz, etc.</p>
 * 
 * @author David
 * @version 1.0
 */
public class CintaAdhesiva extends Papeleria {

    /** Indica si la cinta adhesiva es reposicionable. */
    private boolean esAdhesivoReposicionable;

    /** Ancho de la cinta adhesiva en milímetros o centímetros. */
    private double ancho;

    /** Tipo de cinta adhesiva (ejemplo: transparente, enmascarar, doble faz). */
    private String tipoCinta;

    /**
     * Constructor por defecto.
     */
    public CintaAdhesiva() {
        // Constructor vacío
    }

    /**
     * Constructor con todos los atributos principales y específicos.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto (ejemplo: papelería).
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param esAdhesivoReposicionable Si la cinta es reposicionable.
     * @param ancho Ancho de la cinta.
     * @param tipoCinta Tipo de cinta.
     */
    public CintaAdhesiva(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Constructor que incluye el tipo de presentación del producto.
     * 
     * @param tipoPresentacion Tipo de presentación (ejemplo: rollo).
     * @param esAdhesivoReposicionable Si la cinta es reposicionable.
     * @param ancho Ancho de la cinta.
     * @param tipoCinta Tipo de cinta.
     */
    public CintaAdhesiva(String tipoPresentacion, boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
        super(tipoPresentacion);
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Constructor con los atributos específicos de la cinta.
     * 
     * @param esAdhesivoReposicionable Si la cinta es reposicionable.
     * @param ancho Ancho de la cinta.
     * @param tipoCinta Tipo de cinta.
     */
    public CintaAdhesiva(boolean esAdhesivoReposicionable, double ancho, String tipoCinta) {
        super();
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Constructor que incluye presentación y atributos generales del producto.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoPresentacion Tipo de presentación (ejemplo: rollo).
     */
    public CintaAdhesiva(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPresentacion) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
    }

    /**
     * Constructor para atributos generales del producto.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     */
    public CintaAdhesiva(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que solo recibe el tipo de presentación.
     * 
     * @param tipoPresentacion Tipo de presentación (ejemplo: rollo).
     */
    public CintaAdhesiva(String tipoPresentacion) {
        super(tipoPresentacion);
    }

    /**
     * Constructor completo que incluye atributos de {@link Papeleria} y específicos de cinta adhesiva.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoPresentacion Tipo de presentación.
     * @param esAdhesivoReposicionable Si la cinta es reposicionable.
     * @param ancho Ancho de la cinta.
     * @param tipoCinta Tipo de cinta.
     */
    public CintaAdhesiva(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPresentacion, boolean esAdhesivoReposicionable,
            double ancho, String tipoCinta) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
        this.ancho = ancho;
        this.tipoCinta = tipoCinta;
    }

    /**
     * Verifica si la cinta es reposicionable.
     * 
     * @return true si la cinta es reposicionable, false en caso contrario.
     */
    public boolean isEsAdhesivoReposicionable() {
        return esAdhesivoReposicionable;
    }

    /**
     * Establece si la cinta es reposicionable.
     * 
     * @param esAdhesivoReposicionable true si es reposicionable, false si no.
     */
    public void setEsAdhesivoReposicionable(boolean esAdhesivoReposicionable) {
        this.esAdhesivoReposicionable = esAdhesivoReposicionable;
    }

    /**
     * Obtiene el ancho de la cinta.
     * 
     * @return Ancho en milímetros o centímetros.
     */
    public double getAncho() {
        return ancho;
    }

    /**
     * Establece el ancho de la cinta.
     * 
     * @param ancho Ancho en milímetros o centímetros.
     */
    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    /**
     * Obtiene el tipo de cinta.
     * 
     * @return Tipo de cinta (ejemplo: transparente, enmascarar, doble faz).
     */
    public String getTipoCinta() {
        return tipoCinta;
    }

    /**
     * Establece el tipo de cinta.
     * 
     * @param tipoCinta Tipo de cinta (ejemplo: transparente, enmascarar, doble faz).
     */
    public void setTipoCinta(String tipoCinta) {
        this.tipoCinta = tipoCinta;
    }
}
