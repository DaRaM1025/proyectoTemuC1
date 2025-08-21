package co.edu.unbosque.model;

/**
 * Clase que representa un DTO (Data Transfer Object) para el producto de maquillaje Sombra.
 * Hereda de MaquillajeDTO e incluye atributos específicos como cantidad de colores y acabado.
 */
public class SombraDTO extends MaquillajeDTO {

    /** Cantidad de colores disponibles en la sombra. */
    private int cantidadColores;

    /** Tipo de acabado de la sombra (mate, brillante, etc.). */
    private String acabado;

    /**
     * Constructor por defecto de la clase SombraDTO.
     */
    public SombraDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos específicos de SombraDTO junto con los de MaquillajeDTO.
     *
     * @param tipoPiel Tipo de piel para el que es adecuado el maquillaje
     * @param esApruebaDeAgua Indica si es a prueba de agua
     * @param fechaVencimiento Fecha de vencimiento del producto
     * @param cantidadColores Cantidad de colores disponibles
     * @param acabado Tipo de acabado
     */
    public SombraDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, int cantidadColores,
                     String acabado) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        this.cantidadColores = cantidadColores;
        this.acabado = acabado;
    }

    /**
     * Constructor que inicializa todos los atributos heredados de ProductoDTO y los específicos de SombraDTO.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible
     * @param id Identificador único del producto
     * @param cantidadColores Cantidad de colores
     * @param acabado Tipo de acabado
     */
    public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                     double precio, int cantidad, String id, int cantidadColores, String acabado) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.cantidadColores = cantidadColores;
        this.acabado = acabado;
    }

    /**
     * Constructor que inicializa solo los atributos específicos de SombraDTO.
     *
     * @param cantidadColores Cantidad de colores
     * @param acabado Tipo de acabado
     */
    public SombraDTO(int cantidadColores, String acabado) {
        super();
        this.cantidadColores = cantidadColores;
        this.acabado = acabado;
    }

    /**
     * Constructor que inicializa los atributos heredados de MaquillajeDTO.
     *
     * @param tipoPiel Tipo de piel
     * @param esApruebaDeAgua Indica si es a prueba de agua
     * @param fechaVencimiento Fecha de vencimiento
     */
    public SombraDTO(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados de ProductoDTO y MaquillajeDTO.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción
     * @param urlImagen URL de la imagen
     * @param precio Precio
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param tipoPiel Tipo de piel
     * @param esApruebaDeAgua Indica si es a prueba de agua
     * @param fechaVencimiento Fecha de vencimiento
     */
    public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                     double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
              fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa solo los atributos heredados de ProductoDTO.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción
     * @param urlImagen URL de la imagen
     * @param precio Precio
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     */
    public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                     double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y específicos de SombraDTO.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción
     * @param urlImagen URL de la imagen
     * @param precio Precio
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param tipoPiel Tipo de piel
     * @param esApruebaDeAgua Indica si es a prueba de agua
     * @param fechaVencimiento Fecha de vencimiento
     * @param cantidadColores Cantidad de colores
     * @param acabado Tipo de acabado
     */
    public SombraDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                     double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento,
                     int cantidadColores, String acabado) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
              fechaVencimiento);
        this.cantidadColores = cantidadColores;
        this.acabado = acabado;
    }

    /**
     * Obtiene la cantidad de colores de la sombra.
     *
     * @return Cantidad de colores
     */
    public int getCantidadColores() {
        return cantidadColores;
    }

    /**
     * Establece la cantidad de colores de la sombra.
     *
     * @param cantidadColores Cantidad de colores
     */
    public void setCantidadColores(int cantidadColores) {
        this.cantidadColores = cantidadColores;
    }

    /**
     * Obtiene el acabado de la sombra.
     *
     * @return Acabado de la sombra
     */
    public String getAcabado() {
        return acabado;
    }

    /**
     * Establece el acabado de la sombra.
     *
     * @param acabado Acabado de la sombra
     */
    public void setAcabado(String acabado) {
        this.acabado = acabado;
    }

    /**
     * Crea y retorna un clon de este objeto SombraDTO.
     *
     * @return Clon del objeto SombraDTO
     */
    @Override
    public SombraDTO clone() {
        return new SombraDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                             getCantidad(), getId(), getTipoPiel(), isEsApruebaDeAgua(), getFechaVencimiento(),
                             getCantidadColores(), getAcabado());
    }

}
