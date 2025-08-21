package co.edu.unbosque.model;

/**
 * Representa un objeto LEGO como un tipo de {@link JugueteDTO}.
 * Incluye información específica como el tema, número de piezas
 * y si incluye minifiguras.
 * 
 * @author David Ramirez
 */
public class LegoDTO extends JugueteDTO {

    /**
     * Tema del set de LEGO.
     */
    private String tema;

    /**
     * Número de piezas del set de LEGO.
     */
    private int numeroPiezas;

    /**
     * Indica si el set incluye minifiguras.
     */
    private boolean tieneMinifiguras;

    /**
     * Constructor por defecto.
     */
    public LegoDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y propios.
     * 
     * @param nombre          Nombre del producto.
     * @param marca           Marca del producto.
     * @param tipoProducto    Tipo de producto.
     * @param descripcion     Descripción del producto.
     * @param urlImagen       URL de la imagen del producto.
     * @param precio          Precio del producto.
     * @param cantidad        Cantidad disponible.
     * @param id              Identificador único.
     * @param tema            Tema del set LEGO.
     * @param numeroPiezas    Número de piezas del set.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Constructor que inicializa atributos heredados y propios.
     * 
     * @param edadRecomendada Edad recomendada.
     * @param tema            Tema del set LEGO.
     * @param numeroPiezas    Número de piezas del set.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public LegoDTO(int edadRecomendada, String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super(edadRecomendada);
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Constructor que inicializa los atributos propios.
     * 
     * @param tema            Tema del set LEGO.
     * @param numeroPiezas    Número de piezas del set.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public LegoDTO(String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super();
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Constructor que inicializa la edad recomendada.
     * 
     * @param edadRecomendada Edad recomendada.
     */
    public LegoDTO(int edadRecomendada) {
        super(edadRecomendada);
    }

    /**
     * Constructor que inicializa atributos heredados.
     * 
     * @param nombre          Nombre del producto.
     * @param marca           Marca del producto.
     * @param tipoProducto    Tipo de producto.
     * @param descripcion     Descripción del producto.
     * @param urlImagen       URL de la imagen del producto.
     * @param precio          Precio del producto.
     * @param cantidad        Cantidad disponible.
     * @param id              Identificador único.
     * @param edadRecomendada Edad recomendada.
     */
    public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, int edadRecomendada) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
    }

    /**
     * Constructor que inicializa atributos heredados.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen del producto.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único.
     */
    public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa todos los atributos, incluyendo los heredados y propios.
     * 
     * @param nombre          Nombre del producto.
     * @param marca           Marca del producto.
     * @param tipoProducto    Tipo de producto.
     * @param descripcion     Descripción del producto.
     * @param urlImagen       URL de la imagen del producto.
     * @param precio          Precio del producto.
     * @param cantidad        Cantidad disponible.
     * @param id              Identificador único.
     * @param edadRecomendada Edad recomendada.
     * @param tema            Tema del set LEGO.
     * @param numeroPiezas    Número de piezas del set.
     * @param tieneMinifiguras Indica si incluye minifiguras.
     */
    public LegoDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen, double precio,
            int cantidad, String id, int edadRecomendada, String tema, int numeroPiezas, boolean tieneMinifiguras) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
        this.tema = tema;
        this.numeroPiezas = numeroPiezas;
        this.tieneMinifiguras = tieneMinifiguras;
    }

    /**
     * Obtiene el tema del set LEGO.
     * 
     * @return Tema del set.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Establece el tema del set LEGO.
     * 
     * @param tema Tema del set.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Obtiene el número de piezas del set LEGO.
     * 
     * @return Número de piezas.
     */
    public int getNumeroPiezas() {
        return numeroPiezas;
    }

    /**
     * Establece el número de piezas del set LEGO.
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

    /**
     * Crea una copia del objeto actual.
     * 
     * @return Una nueva instancia de {@link LegoDTO} con los mismos valores.
     */
    @Override
    public LegoDTO clone() {
        return new LegoDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getEdadRecomendada(), getTema(), getNumeroPiezas(), isTieneMinifiguras());
    }

}
