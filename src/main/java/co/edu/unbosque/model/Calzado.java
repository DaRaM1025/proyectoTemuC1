package co.edu.unbosque.model;

/**
 * Representa un tipo específico de {@link Ropa} llamado Calzado. 
 * Esta clase añade atributos particulares relacionados con el tipo de calzado, 
 * ocasión, material de la suela y altura de la suela.
 * 
 * <p>
 * Se utiliza para gestionar productos de tipo calzado dentro del sistema.
 * </p>
 * 
 * @author DavidRamirez
 * @version 1.0
 */
public class Calzado extends Ropa {

    /**
     * Tipo de calzado (por ejemplo: deportivo, casual, formal).
     */
    private String tipoCalzado;

    /**
     * Ocasión para la cual está diseñado el calzado (por ejemplo: fiesta, deporte, diario).
     */
    private String ocasion;

    /**
     * Material de la suela del calzado (por ejemplo: goma, cuero).
     */
    private String materialSuela;

    /**
     * Altura de la suela en centímetros.
     */
    private double alturaSuela;

    /**
     * Constructor por defecto.
     */
    public Calzado() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos de la clase padre y los específicos del calzado.
     * 
     * @param nombre        Nombre del producto.
     * @param marca         Marca del producto.
     * @param tipoProducto  Tipo general del producto.
     * @param descripcion   Descripción del producto.
     * @param urlImagen     URL de la imagen del producto.
     * @param precio        Precio del producto.
     * @param cantidad      Cantidad disponible.
     * @param id            Identificador único del producto.
     * @param tipoCalzado   Tipo de calzado.
     * @param ocasion       Ocasión de uso.
     * @param materialSuela Material de la suela.
     * @param alturaSuela   Altura de la suela.
     */
    public Calzado(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoCalzado, String ocasion, String materialSuela,
            double alturaSuela) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoCalzado = tipoCalzado;
        this.ocasion = ocasion;
        this.materialSuela = materialSuela;
        this.alturaSuela = alturaSuela;
    }

    /**
     * Constructor que inicializa atributos de {@link Ropa} y los específicos del calzado.
     * 
     * @param talla         Talla del calzado.
     * @param genero        Género para el que está diseñado.
     * @param material      Material principal del calzado.
     * @param tipoCalzado   Tipo de calzado.
     * @param ocasion       Ocasión de uso.
     * @param materialSuela Material de la suela.
     * @param alturaSuela   Altura de la suela.
     */
    public Calzado(String talla, String genero, String material, String tipoCalzado, String ocasion,
            String materialSuela, double alturaSuela) {
        super(talla, genero, material);
        this.tipoCalzado = tipoCalzado;
        this.ocasion = ocasion;
        this.materialSuela = materialSuela;
        this.alturaSuela = alturaSuela;
    }

    /**
     * Constructor que inicializa solo los atributos específicos del calzado.
     * 
     * @param tipoCalzado   Tipo de calzado.
     * @param ocasion       Ocasión de uso.
     * @param materialSuela Material de la suela.
     * @param alturaSuela   Altura de la suela.
     */
    public Calzado(String tipoCalzado, String ocasion, String materialSuela, double alturaSuela) {
        super();
        this.tipoCalzado = tipoCalzado;
        this.ocasion = ocasion;
        this.materialSuela = materialSuela;
        this.alturaSuela = alturaSuela;
    }

    /**
     * Constructor que inicializa atributos de {@link Ropa}.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo general del producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único del producto.
     * @param talla        Talla del calzado.
     * @param genero       Género para el que está diseñado.
     * @param material     Material principal del calzado.
     */
    public Calzado(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
    public Calzado(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa solo talla, género y material.
     * 
     * @param talla    Talla del calzado.
     * @param genero   Género para el que está diseñado.
     * @param material Material principal del calzado.
     */
    public Calzado(String talla, String genero, String material) {
        super(talla, genero, material);
    }

    /**
     * Constructor que inicializa todos los atributos heredados y específicos del calzado.
     * 
     * @param nombre        Nombre del producto.
     * @param marca         Marca del producto.
     * @param tipoProducto  Tipo general del producto.
     * @param descripcion   Descripción del producto.
     * @param urlImagen     URL de la imagen del producto.
     * @param precio        Precio del producto.
     * @param cantidad      Cantidad disponible.
     * @param id            Identificador único del producto.
     * @param talla         Talla del calzado.
     * @param genero        Género para el que está diseñado.
     * @param material      Material principal del calzado.
     * @param tipoCalzado   Tipo de calzado.
     * @param ocasion       Ocasión de uso.
     * @param materialSuela Material de la suela.
     * @param alturaSuela   Altura de la suela.
     */
    public Calzado(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String talla, String genero, String material, String tipoCalzado,
            String ocasion, String materialSuela, double alturaSuela) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, talla, genero, material);
        this.tipoCalzado = tipoCalzado;
        this.ocasion = ocasion;
        this.materialSuela = materialSuela;
        this.alturaSuela = alturaSuela;
    }

    /**
     * Obtiene el tipo de calzado.
     * 
     * @return tipoCalzado Tipo de calzado.
     */
    public String getTipoCalzado() {
        return tipoCalzado;
    }

    /**
     * Establece el tipo de calzado.
     * 
     * @param tipoCalzado Tipo de calzado.
     */
    public void setTipoCalzado(String tipoCalzado) {
        this.tipoCalzado = tipoCalzado;
    }

    /**
     * Obtiene la ocasión para la cual está diseñado el calzado.
     * 
     * @return ocasion Ocasión del calzado.
     */
    public String getOcasion() {
        return ocasion;
    }

    /**
     * Establece la ocasión del calzado.
     * 
     * @param ocasion Ocasión del calzado.
     */
    public void setOcasion(String ocasion) {
        this.ocasion = ocasion;
    }

    /**
     * Obtiene el material de la suela.
     * 
     * @return materialSuela Material de la suela.
     */
    public String getMaterialSuela() {
        return materialSuela;
    }

    /**
     * Establece el material de la suela.
     * 
     * @param materialSuela Material de la suela.
     */
    public void setMaterialSuela(String materialSuela) {
        this.materialSuela = materialSuela;
    }

    /**
     * Obtiene la altura de la suela.
     * 
     * @return alturaSuela Altura de la suela en centímetros.
     */
    public double getAlturaSuela() {
        return alturaSuela;
    }

    /**
     * Establece la altura de la suela.
     * 
     * @param alturaSuela Altura de la suela en centímetros.
     */
    public void setAlturaSuela(double alturaSuela) {
        this.alturaSuela = alturaSuela;
    }
}
