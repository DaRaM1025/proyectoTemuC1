package co.edu.unbosque.model;

/**
 * Representa una camiseta que hereda de {@link RopaDTO}. Contiene atributos
 * específicos como el tipo de manga, el tipo de cuello y si la camiseta tiene
 * estampado.
 * 
 * Ofrece múltiples constructores para inicializar los diferentes atributos
 * dependiendo del contexto y métodos de acceso para manipular su estado.
 * 
 * También implementa el método {@link #clone()} para crear una copia del
 * objeto.
 * 
 * @author David Ramirez
 */
public class CamisetaDTO extends RopaDTO {

    /** Tipo de manga de la camiseta (ej. corta, larga). */
    private String tipoManga; // Posible enum
    /** Tipo de cuello de la camiseta (ej. redondo, en V). */
    private String cuello;
    /** Indica si la camiseta es estampada. */
    private boolean isEstampado;

    /**
     * Constructor por defecto.
     */
    public CamisetaDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa una camiseta con todos los atributos heredados
     * y específicos.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único.
     * @param tipoManga    Tipo de manga de la camiseta.
     * @param cuello       Tipo de cuello de la camiseta.
     * @param isEstampado  Indica si la camiseta es estampada.
     */
    public CamisetaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoManga, String cuello, boolean isEstampado) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoManga = tipoManga;
        this.cuello = cuello;
        this.isEstampado = isEstampado;
    }

    /**
     * Constructor que inicializa solo las características físicas y específicas.
     * 
     * @param talla        Talla de la camiseta.
     * @param genero       Género para el que está diseñada.
     * @param material     Material de fabricación.
     * @param tipoManga    Tipo de manga de la camiseta.
     * @param cuello       Tipo de cuello de la camiseta.
     * @param isEstampado  Indica si la camiseta es estampada.
     */
    public CamisetaDTO(String talla, String genero, String material, String tipoManga, String cuello,
            boolean isEstampado) {
        super(talla, genero, material);
        this.tipoManga = tipoManga;
        this.cuello = cuello;
        this.isEstampado = isEstampado;
    }

    /**
     * Constructor que inicializa únicamente los atributos propios de la camiseta.
     * 
     * @param tipoManga   Tipo de manga.
     * @param cuello      Tipo de cuello.
     * @param isEstampado Indica si la camiseta tiene estampado.
     */
    public CamisetaDTO(String tipoManga, String cuello, boolean isEstampado) {
        super();
        this.tipoManga = tipoManga;
        this.cuello = cuello;
        this.isEstampado = isEstampado;
    }

    /**
     * Constructor que inicializa atributos heredados y características generales.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único.
     * @param talla        Talla.
     * @param genero       Género.
     * @param material     Material.
     */
    public CamisetaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String talla, String genero, String material) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
        // TODO Auto-generated constructor stub
    }


    /**
     * Constructor que inicializa atributos de talla, género y material.
     * 
     * @param talla    Talla de la camiseta.
     * @param genero   Género.
     * @param material Material de fabricación.
     */
    public CamisetaDTO(String talla, String genero, String material) {
        super(talla, genero, material);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor completo que inicializa todos los atributos, tanto heredados
     * como propios.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción.
     * @param urlImagen    URL de la imagen.
     * @param precio       Precio.
     * @param cantidad     Cantidad.
     * @param id           Identificador único.
     * @param talla        Talla.
     * @param genero       Género.
     * @param material     Material.
     * @param tipoManga    Tipo de manga.
     * @param cuello       Tipo de cuello.
     * @param isEstampado  Indica si es estampada.
     */
    public CamisetaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
     * @return Tipo de manga.
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
     * @return Tipo de cuello.
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
     * Indica si la camiseta es estampada.
     * 
     * @return {@code true} si es estampada, {@code false} en caso contrario.
     */
    public boolean isEstampado() {
        return isEstampado;
    }

    /**
     * Establece si la camiseta es estampada.
     * 
     * @param isEstampado {@code true} si es estampada, {@code false} en caso
     *                    contrario.
     */
    public void setEstampado(boolean isEstampado) {
        this.isEstampado = isEstampado;
    }

    /**
     * Crea una copia exacta de la camiseta actual.
     * 
     * @return Una nueva instancia de {@link CamisetaDTO} con los mismos atributos.
     */
    @Override
    public CamisetaDTO clone() {
        return new CamisetaDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(),
                getPrecio(), getCantidad(), getId(), getTalla(), getGenero(), getMaterial(), getTipoManga(),
                getCuello(), isEstampado());
    }

}
