package co.edu.unbosque.model;

/**
 * Representa un Corrector en formato DTO (Data Transfer Object) que extiende de {@link MaquillajeDTO}.
 * Este objeto se utiliza para transferir datos entre diferentes capas de la aplicación
 * sin exponer la lógica interna de la entidad.
 * <p>
 * Incluye información sobre la cobertura y el formato del corrector, además de las propiedades heredadas
 * de {@link MaquillajeDTO}.
 * </p>
 * 
 * @author David Ramirez
 */
public class CorrectorDTO extends MaquillajeDTO {

    /**
     * Tipo de cobertura del corrector (por ejemplo: alta, media, baja).
     */
    private String cobertura;

    /**
     * Formato del corrector (por ejemplo: líquido, barra, crema).
     */
    private String formato;

    /**
     * Constructor por defecto.
     */
    public CorrectorDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con atributos específicos de maquillaje y corrector.
     *
     * @param tipoPiel Tipo de piel recomendado para el corrector.
     * @param esApruebaDeAgua Indica si el corrector es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento del producto.
     * @param cobertura Tipo de cobertura del corrector.
     * @param formato Formato del corrector.
     */
    public CorrectorDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String cobertura,
            String formato) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Constructor con todos los atributos básicos del producto y atributos del corrector.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible del producto.
     * @param id Identificador único del producto.
     * @param cobertura Tipo de cobertura del corrector.
     * @param formato Formato del corrector.
     */
    public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String cobertura, String formato) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Constructor que recibe únicamente la cobertura y el formato.
     *
     * @param cobertura Tipo de cobertura del corrector.
     * @param formato Formato del corrector.
     */
    public CorrectorDTO(String cobertura, String formato) {
        super();
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Constructor con atributos básicos heredados de maquillaje.
     *
     * @param tipoPiel Tipo de piel recomendado para el corrector.
     * @param esApruebaDeAgua Indica si el corrector es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento del producto.
     */
    public CorrectorDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
    }

    /**
     * Constructor que incluye atributos del maquillaje y propiedades adicionales.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible del producto.
     * @param id Identificador único del producto.
     * @param tipoPiel Tipo de piel recomendado.
     * @param esApruebaDeAgua Indica si el corrector es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento del producto.
     */
    public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
    }

    /**
     * Constructor con los atributos principales sin detalles adicionales.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible del producto.
     * @param id Identificador único del producto.
     */
    public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor con todos los atributos del corrector, incluyendo los heredados.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible del producto.
     * @param id Identificador único del producto.
     * @param tipoPiel Tipo de piel recomendado.
     * @param esApruebaDeAgua Indica si el corrector es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento del producto.
     * @param cobertura Tipo de cobertura del corrector.
     * @param formato Formato del corrector.
     */
    public CorrectorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento,
            String cobertura, String formato) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Obtiene el tipo de cobertura del corrector.
     *
     * @return Cobertura del corrector.
     */
    public String getCobertura() {
        return cobertura;
    }

    /**
     * Establece el tipo de cobertura del corrector.
     *
     * @param cobertura Nueva cobertura del corrector.
     */
    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    /**
     * Obtiene el formato del corrector.
     *
     * @return Formato del corrector.
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Establece el formato del corrector.
     *
     * @param formato Nuevo formato del corrector.
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /**
     * Crea una copia del objeto {@link CorrectorDTO}.
     *
     * @return Nueva instancia de {@link CorrectorDTO} con los mismos atributos.
     */
    @Override
    public CorrectorDTO clone() {
        return new CorrectorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getTipoPiel(), isEsApruebaDeAgua(), getFechaVencimiento(), getCobertura(), getFormato());
    }

}
