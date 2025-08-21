package co.edu.unbosque.model;

/**
 * Representa un producto cosmético del tipo labial. Hereda de {@link Maquillaje} 
 * e incorpora atributos adicionales como duración y si es hidratante.
 * 
 * Esta clase se utiliza para modelar las características específicas de un labial 
 * dentro del sistema de productos.
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class Labial extends Maquillaje {

    /**
     * Indica la duración estimada del labial.
     */
    private String duracion;

    /**
     * Indica si el labial es hidratante.
     */
    private boolean esHidratante;

    /**
     * Constructor por defecto.
     */
    public Labial() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos relacionados con la piel y 
     * características adicionales del labial.
     *
     * @param tipoPiel el tipo de piel recomendado
     * @param esApruebaDeAgua true si es a prueba de agua, false en caso contrario
     * @param fechaVencimiento la fecha de vencimiento del producto
     * @param duracion la duración del labial
     * @param esHidratante true si es hidratante, false en caso contrario
     */
    public Labial(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String duracion,
            boolean esHidratante) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Constructor que inicializa todos los atributos relacionados con el producto 
     * y las características específicas del labial.
     *
     * @param nombre el nombre del producto
     * @param marca la marca del producto
     * @param tipoProducto el tipo de producto
     * @param descripcion la descripción del producto
     * @param urlImagen la URL de la imagen del producto
     * @param precio el precio del producto
     * @param cantidad la cantidad disponible
     * @param id el identificador único
     * @param duracion la duración del labial
     * @param esHidratante true si es hidratante, false en caso contrario
     */
    public Labial(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, String duracion, boolean esHidratante) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Constructor que inicializa la duración y si es hidratante.
     *
     * @param duracion la duración del labial
     * @param esHidratante true si es hidratante, false en caso contrario
     */
    public Labial(String duracion, boolean esHidratante) {
        super();
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Constructor que inicializa atributos relacionados con el maquillaje.
     *
     * @param tipoPiel el tipo de piel recomendado
     * @param esApruebaDeAgua true si es a prueba de agua, false en caso contrario
     * @param fechaVencimiento la fecha de vencimiento del producto
     */
    public Labial(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos básicos del producto y características del maquillaje.
     *
     * @param nombre el nombre del producto
     * @param marca la marca del producto
     * @param tipoProducto el tipo de producto
     * @param descripcion la descripción del producto
     * @param urlImagen la URL de la imagen del producto
     * @param precio el precio del producto
     * @param cantidad la cantidad disponible
     * @param id el identificador único
     * @param tipoPiel el tipo de piel recomendado
     * @param esApruebaDeAgua true si es a prueba de agua, false en caso contrario
     * @param fechaVencimiento la fecha de vencimiento del producto
     */
    public Labial(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos básicos del producto.
     *
     * @param nombre el nombre del producto
     * @param marca la marca del producto
     * @param tipoProducto el tipo de producto
     * @param descripcion la descripción del producto
     * @param urlImagen la URL de la imagen del producto
     * @param precio el precio del producto
     * @param cantidad la cantidad disponible
     * @param id el identificador único
     */
    public Labial(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos del producto, maquillaje y características específicas del labial.
     *
     * @param nombre el nombre del producto
     * @param marca la marca del producto
     * @param tipoProducto el tipo de producto
     * @param descripcion la descripción del producto
     * @param urlImagen la URL de la imagen del producto
     * @param precio el precio del producto
     * @param cantidad la cantidad disponible
     * @param id el identificador único
     * @param tipoPiel el tipo de piel recomendado
     * @param esApruebaDeAgua true si es a prueba de agua, false en caso contrario
     * @param fechaVencimiento la fecha de vencimiento del producto
     * @param duracion la duración del labial
     * @param esHidratante true si es hidratante, false en caso contrario
     */
    public Labial(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String duracion,
            boolean esHidratante) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Obtiene la duración del labial.
     *
     * @return la duración del labial
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración del labial.
     *
     * @param duracion la duración del labial
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Verifica si el labial es hidratante.
     *
     * @return true si es hidratante, false en caso contrario
     */
    public boolean isEsHidratante() {
        return esHidratante;
    }

    /**
     * Establece si el labial es hidratante.
     *
     * @param esHidratante true si es hidratante, false en caso contrario
     */
    public void setEsHidratante(boolean esHidratante) {
        this.esHidratante = esHidratante;
    }

}
