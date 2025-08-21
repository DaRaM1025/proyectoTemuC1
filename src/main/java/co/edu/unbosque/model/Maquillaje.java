package co.edu.unbosque.model;

/**
 * Representa un producto de maquillaje que extiende la clase {@link Producto}.
 * Contiene atributos específicos como el tipo de piel, si es a prueba de agua
 * y la fecha de vencimiento.
 * 
 * @author David Ramirez
 */
public class Maquillaje extends Producto {

    /**
     * Tipo de piel recomendado para este maquillaje (por ejemplo, seca, mixta, grasa).
     */
    protected String tipoPiel;

    /**
     * Indica si el maquillaje es a prueba de agua.
     */
    protected boolean esApruebaDeAgua;

    /**
     * Fecha de vencimiento del maquillaje.
     */
    protected String fechaVencimiento;

    /**
     * Constructor por defecto.
     */
    public Maquillaje() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos heredados de {@link Producto}.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible del producto.
     * @param id           Identificador único del producto.
     */
    public Maquillaje(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos específicos de Maquillaje.
     * 
     * @param tipoPiel          Tipo de piel recomendado.
     * @param esApruebaDeAgua   Indica si es a prueba de agua.
     * @param fechaVencimiento  Fecha de vencimiento del producto.
     */
    public Maquillaje(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super();
        this.tipoPiel = tipoPiel;
        this.esApruebaDeAgua = esApruebaDeAgua;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Constructor que inicializa todos los atributos del producto, incluyendo los
     * específicos de Maquillaje.
     * 
     * @param nombre            Nombre del producto.
     * @param marca             Marca del producto.
     * @param tipoProducto      Tipo de producto.
     * @param descripcion       Descripción del producto.
     * @param urlImagen         URL de la imagen del producto.
     * @param precio            Precio del producto.
     * @param cantidad          Cantidad disponible.
     * @param id                Identificador único.
     * @param tipoPiel          Tipo de piel recomendado.
     * @param esApruebaDeAgua   Indica si es a prueba de agua.
     * @param fechaVencimiento  Fecha de vencimiento.
     */
    public Maquillaje(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoPiel = tipoPiel;
        this.esApruebaDeAgua = esApruebaDeAgua;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtiene el tipo de piel recomendado.
     * 
     * @return Tipo de piel.
     */
    public String getTipoPiel() {
        return tipoPiel;
    }

    /**
     * Establece el tipo de piel recomendado.
     * 
     * @param tipoPiel Tipo de piel.
     */
    public void setTipoPiel(String tipoPiel) {
        this.tipoPiel = tipoPiel;
    }

    /**
     * Verifica si el maquillaje es a prueba de agua.
     * 
     * @return true si es a prueba de agua, false en caso contrario.
     */
    public boolean isEsApruebaDeAgua() {
        return esApruebaDeAgua;
    }

    /**
     * Establece si el maquillaje es a prueba de agua.
     * 
     * @param esApruebaDeAgua true si es a prueba de agua, false en caso contrario.
     */
    public void setEsApruebaDeAgua(boolean esApruebaDeAgua) {
        this.esApruebaDeAgua = esApruebaDeAgua;
    }

    /**
     * Obtiene la fecha de vencimiento del maquillaje.
     * 
     * @return Fecha de vencimiento.
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento del maquillaje.
     * 
     * @param fechaVencimiento Fecha de vencimiento.
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

}
