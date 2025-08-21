package co.edu.unbosque.model;

/**
 * Representa un objeto de transferencia de datos (DTO) para productos de tipo Maquillaje.
 * Contiene información específica sobre maquillaje como tipo de piel, resistencia al agua
 * y fecha de vencimiento, además de las propiedades generales de un producto.
 * 
 * @author David Ramirez
 */
public class MaquillajeDTO extends ProductoDTO {
    
    /**
     * Tipo de piel recomendado para el maquillaje.
     */
    protected String tipoPiel; // Posible enum
    
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
    public MaquillajeDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos heredados de ProductoDTO.
     * 
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible
     * @param id Identificador único del producto
     */
    public MaquillajeDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos específicos del maquillaje.
     * 
     * @param tipoPiel Tipo de piel recomendado
     * @param esApruebaDeAgua Indica si es a prueba de agua
     * @param fechaVencimiento Fecha de vencimiento del maquillaje
     */
    public MaquillajeDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super();
        this.tipoPiel = tipoPiel;
        this.esApruebaDeAgua = esApruebaDeAgua;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Constructor que inicializa todos los atributos del maquillaje.
     * 
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible
     * @param id Identificador único del producto
     * @param tipoPiel Tipo de piel recomendado
     * @param esApruebaDeAgua Indica si es a prueba de agua
     * @param fechaVencimiento Fecha de vencimiento del maquillaje
     */
    public MaquillajeDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoPiel = tipoPiel;
        this.esApruebaDeAgua = esApruebaDeAgua;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtiene el tipo de piel recomendado.
     * 
     * @return Tipo de piel
     */
    public String getTipoPiel() {
        return tipoPiel;
    }

    /**
     * Establece el tipo de piel recomendado.
     * 
     * @param tipoPiel Tipo de piel
     */
    public void setTipoPiel(String tipoPiel) {
        this.tipoPiel = tipoPiel;
    }

    /**
     * Verifica si el maquillaje es a prueba de agua.
     * 
     * @return {@code true} si es a prueba de agua, {@code false} en caso contrario
     */
    public boolean isEsApruebaDeAgua() {
        return esApruebaDeAgua;
    }

    /**
     * Establece si el maquillaje es a prueba de agua.
     * 
     * @param esApruebaDeAgua {@code true} si es a prueba de agua, {@code false} en caso contrario
     */
    public void setEsApruebaDeAgua(boolean esApruebaDeAgua) {
        this.esApruebaDeAgua = esApruebaDeAgua;
    }

    /**
     * Obtiene la fecha de vencimiento del maquillaje.
     * 
     * @return Fecha de vencimiento
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento del maquillaje.
     * 
     * @param fechaVencimiento Fecha de vencimiento
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
