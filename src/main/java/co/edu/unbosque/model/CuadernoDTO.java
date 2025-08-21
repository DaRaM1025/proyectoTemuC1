package co.edu.unbosque.model;

/**
 * Representa un cuaderno como un tipo de papelería. Extiende de {@link PapeleriaDTO}.
 * Contiene información específica como tipo de hojas, cantidad de hojas y si es pasta dura.
 * 
 * @author David
 */
public class CuadernoDTO extends PapeleriaDTO {

    /**
     * Tipo de hojas del cuaderno (por ejemplo, rayadas, cuadriculadas, blancas).
     */
    private String tipoHojas;

    /**
     * Cantidad total de hojas del cuaderno.
     */
    private int cantidadHojas;

    /**
     * Indica si el cuaderno tiene pasta dura.
     */
    private boolean isPastaDura;

    /**
     * Constructor por defecto.
     */
    public CuadernoDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos del cuaderno, incluyendo los heredados.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoHojas Tipo de hojas del cuaderno.
     * @param cantidadHojas Cantidad de hojas.
     * @param isPastaDura {@code true} si es pasta dura, {@code false} en caso contrario.
     */
    public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                       double precio, int cantidad, String id, String tipoHojas, int cantidadHojas, boolean isPastaDura) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    /**
     * Constructor que inicializa presentación y características específicas del cuaderno.
     *
     * @param tipoPresentacion Tipo de presentación.
     * @param tipoHojas Tipo de hojas.
     * @param cantidadHojas Cantidad de hojas.
     * @param isPastaDura Indica si es pasta dura.
     */
    public CuadernoDTO(String tipoPresentacion, String tipoHojas, int cantidadHojas, boolean isPastaDura) {
        super(tipoPresentacion);
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    /**
     * Constructor que inicializa únicamente las propiedades específicas del cuaderno.
     *
     * @param tipoHojas Tipo de hojas.
     * @param cantidadHojas Cantidad de hojas.
     * @param isPastaDura Indica si es pasta dura.
     */
    public CuadernoDTO(String tipoHojas, int cantidadHojas, boolean isPastaDura) {
        super();
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    /**
     * Constructor que incluye atributos heredados y tipo de presentación.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoPresentacion Tipo de presentación.
     */
    public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                       double precio, int cantidad, String id, String tipoPresentacion) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
    }

    /**
     * Constructor que inicializa atributos heredados.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     */
    public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                       double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa únicamente el tipo de presentación.
     *
     * @param tipoPresentacion Tipo de presentación.
     */
    public CuadernoDTO(String tipoPresentacion) {
        super(tipoPresentacion);
    }

    /**
     * Constructor que inicializa todos los atributos, incluidos los heredados y específicos.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoPresentacion Tipo de presentación.
     * @param tipoHojas Tipo de hojas.
     * @param cantidadHojas Cantidad de hojas.
     * @param isPastaDura Indica si es pasta dura.
     */
    public CuadernoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                       double precio, int cantidad, String id, String tipoPresentacion, String tipoHojas, int cantidadHojas,
                       boolean isPastaDura) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    /**
     * Obtiene el tipo de hojas del cuaderno.
     *
     * @return Tipo de hojas.
     */
    public String getTipoHojas() {
        return tipoHojas;
    }

    /**
     * Establece el tipo de hojas del cuaderno.
     *
     * @param tipoHojas Tipo de hojas.
     */
    public void setTipoHojas(String tipoHojas) {
        this.tipoHojas = tipoHojas;
    }

    /**
     * Obtiene la cantidad de hojas del cuaderno.
     *
     * @return Cantidad de hojas.
     */
    public int getCantidadHojas() {
        return cantidadHojas;
    }

    /**
     * Establece la cantidad de hojas del cuaderno.
     *
     * @param cantidadHojas Cantidad de hojas.
     */
    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }

    /**
     * Indica si el cuaderno es de pasta dura.
     *
     * @return {@code true} si es pasta dura, {@code false} en caso contrario.
     */
    public boolean isPastaDura() {
        return isPastaDura;
    }

    /**
     * Establece si el cuaderno es de pasta dura.
     *
     * @param isPastaDura {@code true} si es pasta dura, {@code false} en caso contrario.
     */
    public void setPastaDura(boolean isPastaDura) {
        this.isPastaDura = isPastaDura;
    }

    /**
     * Crea una copia del cuaderno actual.
     *
     * @return Nueva instancia de {@link CuadernoDTO} con los mismos valores.
     */
    @Override
    public CuadernoDTO clone() {
        return new CuadernoDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getTipoPresentacion(), getTipoHojas(), getCantidadHojas(), isPastaDura());
    }
}
