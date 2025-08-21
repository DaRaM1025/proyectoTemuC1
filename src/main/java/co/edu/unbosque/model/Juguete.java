package co.edu.unbosque.model;

/**
 * Representa un juguete dentro del sistema.
 * Esta clase extiende la clase {@link Producto} y añade un atributo específico para la edad recomendada.
 * Permite almacenar información relacionada con juguetes y su rango de edad apropiado.
 * 
 * @author David
 */
public class Juguete extends Producto {
    
    /** Edad recomendada para el uso del juguete. */
    protected int edadRecomendada;

    /**
     * Constructor por defecto.
     */
    public Juguete() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa el juguete con la edad recomendada.
     * 
     * @param edadRecomendada Edad recomendada para el juguete.
     */
    public Juguete(int edadRecomendada) {
        super();
        this.edadRecomendada = edadRecomendada;
    }

    /**
     * Constructor que inicializa los atributos heredados de {@link Producto}.
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
    public Juguete(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
    public Juguete(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
