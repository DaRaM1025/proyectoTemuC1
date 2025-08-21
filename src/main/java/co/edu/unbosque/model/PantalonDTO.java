package co.edu.unbosque.model;

/**
 * Representa un objeto de transferencia de datos (DTO) para un pantalón,
 * extendiendo {@link RopaDTO}. Contiene información específica de los pantalones
 * como el tipo, el corte y el largo.
 * 
 * <p>Se utiliza para transportar datos relacionados con pantalones entre las
 * capas del sistema sin exponer la lógica interna.</p>
 * 
 * @author David
 */
public class PantalonDTO extends RopaDTO {

    /**
     * Tipo de pantalón (por ejemplo, jeans, formal, deportivo).
     */
    private String tipoPantalon;

    /**
     * Corte del pantalón (por ejemplo, recto, slim, skinny).
     */
    private String corte;

    /**
     * Largo del pantalón (por ejemplo, corto, largo, capri).
     */
    private String largo;

    /**
     * Constructor por defecto.
     */
    public PantalonDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un pantalón con datos completos excepto
     * los atributos específicos (tipo, corte, largo).
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del pantalón.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion Descripción del pantalón.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del pantalón.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param talla Talla del pantalón.
     * @param genero Género al que va dirigido (hombre, mujer, unisex).
     * @param material Material del pantalón.
     */
    public PantalonDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String talla, String genero, String material) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
    }

    /**
     * Constructor que inicializa un pantalón con atributos específicos
     * relacionados al tipo, corte y largo.
     * 
     * @param talla Talla del pantalón.
     * @param genero Género al que va dirigido.
     * @param material Material del pantalón.
     * @param tipoPantalon Tipo de pantalón.
     * @param corte Corte del pantalón.
     * @param largo Largo del pantalón.
     */
    public PantalonDTO(String talla, String genero, String material, String tipoPantalon, String corte, String largo) {
        super(talla, genero, material);
        this.tipoPantalon = tipoPantalon;
        this.corte = corte;
        this.largo = largo;
    }

    /**
     * Constructor que inicializa un pantalón sin los atributos de talla y material.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del pantalón.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion Descripción del pantalón.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del pantalón.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     */
    public PantalonDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa un pantalón solo con atributos básicos.
     * 
     * @param talla Talla del pantalón.
     * @param genero Género al que va dirigido.
     * @param material Material del pantalón.
     */
    public PantalonDTO(String talla, String genero, String material) {
        super(talla, genero, material);
    }

    /**
     * Constructor que inicializa todos los atributos del pantalón.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del pantalón.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion Descripción del pantalón.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del pantalón.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param talla Talla del pantalón.
     * @param genero Género al que va dirigido.
     * @param material Material del pantalón.
     * @param tipoPantalon Tipo de pantalón.
     * @param corte Corte del pantalón.
     * @param largo Largo del pantalón.
     */
    public PantalonDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String talla, String genero, String material, String tipoPantalon,
            String corte, String largo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
        this.tipoPantalon = tipoPantalon;
        this.corte = corte;
        this.largo = largo;
    }

    /**
     * Obtiene el tipo de pantalón.
     * 
     * @return tipo de pantalón.
     */
    public String getTipoPantalon() {
        return tipoPantalon;
    }

    /**
     * Establece el tipo de pantalón.
     * 
     * @param tipoPantalon tipo de pantalón.
     */
    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

    /**
     * Obtiene el corte del pantalón.
     * 
     * @return corte del pantalón.
     */
    public String getCorte() {
        return corte;
    }

    /**
     * Establece el corte del pantalón.
     * 
     * @param corte corte del pantalón.
     */
    public void setCorte(String corte) {
        this.corte = corte;
    }

    /**
     * Obtiene el largo del pantalón.
     * 
     * @return largo del pantalón.
     */
    public String getLargo() {
        return largo;
    }

    /**
     * Establece el largo del pantalón.
     * 
     * @param largo largo del pantalón.
     */
    public void setLargo(String largo) {
        this.largo = largo;
    }

    /**
     * Crea una copia exacta del objeto actual de {@code PantalonDTO}.
     * 
     * @return una nueva instancia de {@code PantalonDTO} con los mismos valores.
     */
    @Override
    public PantalonDTO clone() {
        return new PantalonDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(),
                getPrecio(), getCantidad(), getId(), getTalla(), getGenero(), getMaterial(), getTipoPantalon(),
                getCorte(), getLargo());
    }

}
