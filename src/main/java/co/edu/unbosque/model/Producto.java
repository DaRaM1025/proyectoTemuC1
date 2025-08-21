package co.edu.unbosque.model;

/**
 * Clase abstracta que representa un producto genérico en el sistema.
 * Contiene atributos comunes a todos los productos, como nombre, marca, tipo de producto,
 * descripción, URL de imagen, precio, cantidad e identificador único.
 * Esta clase sirve como base para las clases específicas de productos que hereden de ella.
 */
public abstract class Producto {

    /** Nombre del producto. */
    protected String nombre;

    /** Marca del producto. */
    protected String marca;

    /** Tipo de producto. Se puede considerar un posible enum. */
    protected String tipoProducto;

    /** Descripción del producto. */
    protected String descripcion;

    /** URL de la imagen que representa el producto. */
    protected String urlImagen;

    /** Precio del producto. */
    protected double precio;

    /** Cantidad disponible del producto. */
    protected int cantidad;

    /** Identificador único del producto. */
    protected String id;

    /**
     * Constructor por defecto de la clase Producto.
     */
    public Producto() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos del producto.
     *
     * @param nombre       Nombre del producto
     * @param marca        Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion  Descripción del producto
     * @param urlImagen    URL de la imagen del producto
     * @param precio       Precio del producto
     * @param cantidad     Cantidad disponible del producto
     * @param id           Identificador único del producto
     */
    public Producto(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                    double precio, int cantidad, String id) {
        super();
        this.nombre = nombre;
        this.marca = marca;
        this.tipoProducto = tipoProducto;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca del producto.
     *
     * @return Marca del producto
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del producto.
     *
     * @param marca Marca del producto
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el tipo de producto.
     *
     * @return Tipo de producto
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Establece el tipo de producto.
     *
     * @param tipoProducto Tipo de producto
     */
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return Descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion Descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la URL de la imagen del producto.
     *
     * @return URL de la imagen
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * Establece la URL de la imagen del producto.
     *
     * @param urlImagen URL de la imagen
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     *
     * @return Cantidad disponible
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto.
     *
     * @param cantidad Cantidad disponible
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return Identificador del producto
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param id Identificador del producto
     */
    public void setId(String id) {
        this.id = id;
    }
}
