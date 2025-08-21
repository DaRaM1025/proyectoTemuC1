package co.edu.unbosque.model;

/**
 * Clase que representa un producto de tipo Ropa.
 * Hereda de la clase Producto e incluye atributos específicos como talla, género y material.
 */
public class Ropa extends Producto {

    /** Talla de la prenda. */
    protected String talla;

    /** Género al que está dirigida la prenda. Posible enum. */
    protected String genero;

    /** Material de la prenda. */
    protected String material;

    /**
     * Constructor por defecto de la clase Ropa.
     */
    public Ropa() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos específicos de la clase Ropa.
     *
     * @param talla  Talla de la prenda
     * @param genero Género al que está dirigida la prenda
     * @param material Material de la prenda
     */
    public Ropa(String talla, String genero, String material) {
        super();
        this.talla = talla;
        this.genero = genero;
        this.material = material;
    }

    /**
     * Constructor que inicializa los atributos heredados de Producto.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible del producto
     * @param id Identificador único del producto
     */
    public Ropa(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
                int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos, tanto heredados como específicos de Ropa.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible del producto
     * @param id Identificador único del producto
     * @param talla Talla de la prenda
     * @param genero Género al que está dirigida la prenda
     * @param material Material de la prenda
     */
    public Ropa(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
                int cantidad, String id, String talla, String genero, String material) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.talla = talla;
        this.genero = genero;
        this.material = material;
    }

    /**
     * Obtiene la talla de la prenda.
     *
     * @return Talla de la prenda
     */
    public String getTalla() {
        return talla;
    }

    /**
     * Establece la talla de la prenda.
     *
     * @param talla Talla de la prenda
     */
    public void setTalla(String talla) {
        this.talla = talla;
    }

    /**
     * Obtiene el género al que está dirigida la prenda.
     *
     * @return Género de la prenda
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la prenda.
     *
     * @param genero Género de la prenda
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el material de la prenda.
     *
     * @return Material de la prenda
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Establece el material de la prenda.
     *
     * @param material Material de la prenda
     */
    public void setMaterial(String material) {
        this.material = material;
    }

}
