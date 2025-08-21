package co.edu.unbosque.model;

/**
 * Clase que representa un pantalón como un tipo específico de {@link Ropa}.
 * Contiene atributos adicionales como el tipo de pantalón, el corte y el largo.
 * 
 * <p>Se utiliza para gestionar productos de tipo pantalón en el sistema,
 * extendiendo las propiedades básicas de la clase {@code Ropa}.</p>
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class Pantalon extends Ropa {
    
    /**
     * Tipo de pantalón (por ejemplo: jeans, formal, casual).
     */
    private String tipoPantalon;
    
    /**
     * Corte del pantalón (por ejemplo: slim, recto, regular).
     */
    private String corte;
    
    /**
     * Largo del pantalón (por ejemplo: corto, largo, capri).
     */
    private String largo;

    /**
     * Constructor por defecto.
     */
    public Pantalon() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un pantalón con información completa heredada y básica.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param talla Talla del pantalón.
     * @param genero Género al que pertenece el pantalón.
     * @param material Material del pantalón.
     */
    public Pantalon(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String talla, String genero, String material) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un pantalón con atributos relacionados a ropa y características específicas.
     *
     * @param talla Talla del pantalón.
     * @param genero Género al que pertenece el pantalón.
     * @param material Material del pantalón.
     * @param tipoPantalon Tipo de pantalón.
     * @param corte Corte del pantalón.
     * @param largo Largo del pantalón.
     */
    public Pantalon(String talla, String genero, String material, String tipoPantalon, String corte, String largo) {
        super(talla, genero, material);
        this.tipoPantalon = tipoPantalon;
        this.corte = corte;
        this.largo = largo;
    }

    /**
     * Constructor que inicializa un pantalón con información básica heredada.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     */
    public Pantalon(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un pantalón con talla, género y material.
     *
     * @param talla Talla del pantalón.
     * @param genero Género al que pertenece el pantalón.
     * @param material Material del pantalón.
     */
    public Pantalon(String talla, String genero, String material) {
        super(talla, genero, material);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos del pantalón.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param talla Talla del pantalón.
     * @param genero Género al que pertenece el pantalón.
     * @param material Material del pantalón.
     * @param tipoPantalon Tipo de pantalón.
     * @param corte Corte del pantalón.
     * @param largo Largo del pantalón.
     */
    public Pantalon(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
     * @return el tipo de pantalón.
     */
    public String getTipoPantalon() {
        return tipoPantalon;
    }

    /**
     * Establece el tipo de pantalón.
     *
     * @param tipoPantalon el tipo de pantalón a asignar.
     */
    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

    /**
     * Obtiene el corte del pantalón.
     *
     * @return el corte del pantalón.
     */
    public String getCorte() {
        return corte;
    }

    /**
     * Establece el corte del pantalón.
     *
     * @param corte el corte del pantalón a asignar.
     */
    public void setCorte(String corte) {
        this.corte = corte;
    }

    /**
     * Obtiene el largo del pantalón.
     *
     * @return el largo del pantalón.
     */
    public String getLargo() {
        return largo;
    }

    /**
     * Establece el largo del pantalón.
     *
     * @param largo el largo del pantalón a asignar.
     */
    public void setLargo(String largo) {
        this.largo = largo;
    }
}
