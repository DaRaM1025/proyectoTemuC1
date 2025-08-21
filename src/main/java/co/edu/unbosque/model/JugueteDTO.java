package co.edu.unbosque.model;

/**
 * Clase que representa el Data Transfer Object (DTO) para un juguete.
 * Extiende la clase {@link ProductoDTO} y añade un atributo para la edad recomendada.
 * Se utiliza para transportar datos relacionados con un juguete entre las capas de la aplicación.
 * 
 * @author David
 */
public class JugueteDTO extends ProductoDTO {
    
    /** Edad recomendada para el uso del juguete. */
    protected int edadRecomendada;

    /**
     * Constructor por defecto.
     */
    public JugueteDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa el juguete con la edad recomendada.
     * 
     * @param edadRecomendada Edad recomendada para el juguete.
     */
    public JugueteDTO(int edadRecomendada) {
        super();
        this.edadRecomendada = edadRecomendada;
    }

    /**
     * Constructor que inicializa los atributos heredados de {@link ProductoDTO}.
     * 
     * @param nombre        Nombre del producto.
     * @param marca         Marca del producto.
     * @param tipoProducto  Tipo de producto.
     * @param descripcion   Descripción del producto.
     * @param urlImagen     URL de la imagen del producto.
     * @param precio        Precio del producto.
     * @param cantidad      Cantidad disponible.
     * @param id            Identificador único del producto.
     */
    public JugueteDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos heredados y la edad recomendada.
     * 
     * @param nombre            Nombre del producto.
     * @param marca             Marca del producto.
     * @param tipoProducto      Tipo de producto.
     * @param descripcion       Descripción del producto.
     * @param urlImagen         URL de la imagen del producto.
     * @param precio            Precio del producto.
     * @param cantidad          Cantidad disponible.
     * @param id                Identificador único del producto.
     * @param edadRecomendada   Edad recomendada para el juguete.
     */
    public JugueteDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, int edadRecomendada) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.edadRecomendada = edadRecomendada;
    }

    /**
     * Obtiene la edad recomendada para el juguete.
     * 
     * @return Edad recomendada.
     */
    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    /**
     * Establece la edad recomendada para el juguete.
     * 
     * @param edadRecomendada Edad recomendada a establecer.
     */
    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

}
