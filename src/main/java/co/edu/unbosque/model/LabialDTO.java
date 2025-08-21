package co.edu.unbosque.model;

/**
 * Representa un objeto de transferencia de datos (DTO) para un labial, que extiende la clase {@link MaquillajeDTO}.
 * Incluye atributos adicionales como la duración y si es hidratante.
 * 
 * @author David Ramirez
 */
public class LabialDTO extends MaquillajeDTO {

    /**
     * Duración del labial.
     */
    private String duracion;

    /**
     * Indica si el labial es hidratante.
     */
    private boolean esHidratante;

    /**
     * Constructor por defecto.
     */
    public LabialDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un labial con tipo de piel, resistencia al agua, fecha de vencimiento, duración e hidratación.
     * 
     * @param tipoPiel        Tipo de piel recomendado.
     * @param esApruebaDeAgua Indica si es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento.
     * @param duracion        Duración del labial.
     * @param esHidratante    Indica si el labial es hidratante.
     */
    public LabialDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String duracion,
            boolean esHidratante) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Constructor que inicializa un labial con atributos básicos y propiedades específicas.
     * 
     * @param nombre        Nombre del producto.
     * @param marca         Marca del producto.
     * @param tipoProducto  Tipo de producto.
     * @param descripcion   Descripción del producto.
     * @param urlImagen     URL de la imagen del producto.
     * @param precio        Precio del producto.
     * @param cantidad      Cantidad disponible.
     * @param id            Identificador único.
     * @param duracion      Duración del labial.
     * @param esHidratante  Indica si el labial es hidratante.
     */
    public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String duracion, boolean esHidratante) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Constructor que inicializa la duración e hidratación del labial.
     * 
     * @param duracion      Duración del labial.
     * @param esHidratante  Indica si el labial es hidratante.
     */
    public LabialDTO(String duracion, boolean esHidratante) {
        super();
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Constructor que inicializa un labial con tipo de piel, resistencia al agua y fecha de vencimiento.
     * 
     * @param tipoPiel         Tipo de piel recomendado.
     * @param esApruebaDeAgua  Indica si es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento.
     */
    public LabialDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un labial con atributos básicos y propiedades cosméticas.
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
    public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un labial con atributos básicos.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único.
     */
    public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un labial con todos los atributos disponibles.
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
     * @param duracion          Duración del labial.
     * @param esHidratante      Indica si el labial es hidratante.
     */
    public LabialDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento,
            String duracion, boolean esHidratante) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
        this.duracion = duracion;
        this.esHidratante = esHidratante;
    }

    /**
     * Obtiene la duración del labial.
     * 
     * @return la duración del labial.
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Establece la duración del labial.
     * 
     * @param duracion la duración a establecer.
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Indica si el labial es hidratante.
     * 
     * @return {@code true} si el labial es hidratante, de lo contrario {@code false}.
     */
    public boolean isEsHidratante() {
        return esHidratante;
    }

    /**
     * Establece si el labial es hidratante.
     * 
     * @param esHidratante {@code true} si es hidratante, {@code false} en caso contrario.
     */
    public void setEsHidratante(boolean esHidratante) {
        this.esHidratante = esHidratante;
    }

    /**
     * Crea y devuelve una copia del objeto {@code LabialDTO}.
     * 
     * @return una nueva instancia de {@code LabialDTO} con los mismos valores.
     */
    @Override
    public LabialDTO clone() {
        return new LabialDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getTipoPiel(), isEsApruebaDeAgua(), getFechaVencimiento(), getDuracion(),
                isEsHidratante());
    }
}
