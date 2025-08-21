package co.edu.unbosque.model;

/**
 * Representa un juguete tipo Lego, el cual hereda de la clase {@link Juguete}.
 * Contiene información específica como el tema, número de piezas y si incluye minifiguras.
 * 
 * @author David
 */
public class Lego extends Juguete {

    /** Tema del set de Lego. */
    private String tema;

    /** Número de piezas del set. */
    private int numeroPiezas;

    /** Indica si el set incluye minifiguras. */
    private boolean tieneMinifiguras;

    /**
     * Constructor por defecto.
     */
    public Lego() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con todos los atributos del producto y los específicos de Lego.
     *
     * @param nombre           Nombre del producto.
     * @param marca            Marca del producto.
     * @param tipoProducto     Tipo de producto.
     * @param descripcion      Descripción del producto.
     * @param urlImagen        URL de la imagen del producto.
     * @param precio           Precio del producto.
     * @param cantidad         Cantidad disponible.
     * @param id               Identificador del producto.
     * @param tema             Tema del set de Lego.
     * @param numeroPiezas     Número de piezas.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public Lego(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Constructor con edad recomendada y atributos específicos de Lego.
     *
     * @param edadRecomendada  Edad recomendada para el set.
     * @param tema             Tema del set.
     * @param numeroPiezas     Número de piezas.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public Lego(int edadRecomendada, String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super(edadRecomendada);
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Constructor con solo atributos específicos de Lego.
     *
     * @param tema             Tema del set.
     * @param numeroPiezas     Número de piezas.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public Lego(String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super();
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Constructor con edad recomendada.
     *
     * @param edadRecomendada Edad recomendada para el set.
     */
    public Lego(int edadRecomendada) {
        super(edadRecomendada);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con atributos generales y edad recomendada.
     *
     * @param nombre           Nombre del producto.
     * @param marca            Marca del producto.
     * @param tipoProducto     Tipo de producto.
     * @param descripcion      Descripción del producto.
     * @param urlImagen        URL de la imagen del producto.
     * @param precio           Precio del producto.
     * @param cantidad         Cantidad disponible.
     * @param id               Identificador del producto.
     * @param edadRecomendada  Edad recomendada.
     */
    public Lego(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, int edadRecomendada) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con atributos generales del producto.
     *
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador del producto.
     */
    public Lego(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor completo con atributos generales, edad recomendada y atributos específicos de Lego.
     *
     * @param nombre           Nombre del producto.
     * @param marca            Marca del producto.
     * @param tipoProducto     Tipo de producto.
     * @param descripcion      Descripción del producto.
     * @param urlImagen        URL de la imagen del producto.
     * @param precio           Precio del producto.
     * @param cantidad         Cantidad disponible.
     * @param id               Identificador del producto.
     * @param edadRecomendada  Edad recomendada.
     * @param tema             Tema del set.
     * @param numeroPiezas     Número de piezas.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public Lego(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, int edadRecomendada, String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Obtiene el tema del set de Lego.
     *
     * @return Tema del set.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Establece el tema del set de Lego.
     *
     * @param tema Tema del set.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Obtiene el número de piezas del set.
     *
     * @return Número de piezas.
     */
    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    /**
     * Establece el número de piezas del set.
     *
     * @param numeroPiezas Número de piezas.
     */
    public void setNumeroPiezas(int numeroPiezas) {
        this.numeroPiezas = numeroPiezas;
    }

    /**
     * Verifica si el set incluye minifiguras.
     *
     * @return {@code true} si incluye minifiguras, {@code false} en caso contrario.
     */
    public boolean isTieneMinifiguras() {
        return tieneMinifiguras;
    }

    /**
     * Establece si el set incluye minifiguras.
     *
     * @param tieneMinifiguras {@code true} si incluye minifiguras, {@code false} en caso contrario.
     */
    public void setTieneMinifiguras(boolean tieneMinifiguras) {
        this.tieneMinifiguras = tieneMinifiguras;
    }

}
