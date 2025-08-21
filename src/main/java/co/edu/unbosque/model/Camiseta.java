package co.edu.unbosque.model;

/**
 * Representa un tipo específico de {@link Ropa} llamado Camiseta.
 * Esta clase añade atributos relacionados con el tipo de manga, el cuello
 * y si la prenda tiene estampado.
 *
 * <p>
 * Se utiliza para modelar productos de tipo camiseta en el sistema.
 * </p>
 *
 * @author David Ramirez
 * @version 1.0
 */
public class Camiseta extends Ropa {

    /**
     * Tipo de manga de la camiseta (por ejemplo: corta, larga, sin mangas).
     */
    private String tipoManga;

    /**
     * Tipo de cuello de la camiseta (por ejemplo: redondo, en V, polo).
     */
    private String cuello;

    /**
     * Indica si la camiseta tiene estampado o no.
     */
    private boolean isEstampado;

    /**
     * Constructor por defecto.
     */
    public Camiseta() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y específicos de la camiseta.
     *
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único del producto.
     * @param tipoManga    Tipo de manga de la camiseta.
     * @param cuello       Tipo de cuello de la camiseta.
     * @param isEstampado  Indica si la camiseta tiene estampado.
     */
    public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoManga, String cuello, boolean isEstampado) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoManga = tipoManga;
        this.cuello = cuello;
        this.isEstampado = isEstampado;
    }

    /**
     * Constructor que inicializa atributos heredados y específicos de la camiseta.
     *
     * @param talla        Talla de la camiseta.
     * @param genero       Género para el que está diseñada.
     * @param material     Material principal de la camiseta.
     * @param tipoManga    Tipo de manga.
     * @param cuello       Tipo de cuello.
     * @param isEstampado  Indica si la camiseta tiene estampado.
     */
    public Camiseta(String talla, String genero, String material, String tipoManga, String cuello,
            boolean isEstampado) {
        super(talla, genero, material);
        this.tipoManga = tipoManga;
        this.cuello = cuello;
        this.isEstampado = isEstampado;
    }

    /**
     * Constructor que inicializa solo los atributos específicos de la camiseta.
     *
     * @param tipoManga    Tipo de manga.
     * @param cuello       Tipo de cuello.
     * @param isEstampado  Indica si la camiseta tiene estampado.
     */
    public Camiseta(String tipoManga, String cuello, boolean isEstampado) {
        super();
        this.tipoManga = tipoManga;
        this.cuello = cuello;
        this.isEstampado = isEstampado;
    }

    /**
     * Constructor que inicializa atributos heredados.
     *
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único del producto.
     * @param talla        Talla de la camiseta.
     * @param genero       Género para el que está diseñada.
     * @param material     Material principal de la camiseta.
     */
    public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String talla, String genero, String material) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
    }

    /**
     * Constructor que inicializa atributos básicos heredados.
     *
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único del producto.
     */
    public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa atributos básicos como talla, género y material.
     *
     * @param talla    Talla de la camiseta.
     * @param genero   Género para el que está diseñada.
     * @param material Material principal de la camiseta.
     */
    public Camiseta(String talla, String genero, String material) {
        super(talla, genero, material);
    }

    /**
     * Constructor que inicializa todos los atributos heredados y específicos de la camiseta.
     *
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único del producto.
     * @param talla        Talla de la camiseta.
     * @param genero       Género para el que está diseñada.
     * @param material     Material principal de la camiseta.
     * @param tipoManga    Tipo de manga.
     * @param cuello       Tipo de cuello.
     * @param isEstampado  Indica si la camiseta tiene estampado.
     */
    public Camiseta(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String talla, String genero, String material, String tipoManga,
            String cuello, boolean isEstampado) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
        this.tipoManga = tipoManga;
        this.cuello = cuello;
        this.isEstampado = isEstampado;
    }

    /**
     * Obtiene el tipo de manga de la camiseta.
     *
     * @return tipoManga Tipo de manga.
     */
    public String getTipoManga() {
        return tipoManga;
    }

    /**
     * Establece el tipo de manga de la camiseta.
     *
     * @param tipoManga Tipo de manga.
     */
    public void setTipoManga(String tipoManga) {
        this.tipoManga = tipoManga;
    }

    /**
     * Obtiene el tipo de cuello de la camiseta.
     *
     * @return cuello Tipo de cuello.
     */
    public String getCuello() {
        return cuello;
    }

    /**
     * Establece el tipo de cuello de la camiseta.
     *
     * @param cuello Tipo de cuello.
     */
    public void setCuello(String cuello) {
        this.cuello = cuello;
    }

    /**
     * Indica si la camiseta tiene estampado.
     *
     * @return true si tiene estampado, false en caso contrario.
     */
    public boolean isEstampado() {
        return isEstampado;
    }

    /**
     * Define si la camiseta tiene estampado.
     *
     * @param isEstampado true si tiene estampado, false en caso contrario.
     */
    public void setEstampado(boolean isEstampado) {
        this.isEstampado = isEstampado;
    }
}
