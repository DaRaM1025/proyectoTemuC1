package co.edu.unbosque.model;

/**
 * Clase Data Transfer Object (DTO) que representa una Pistola de Agua.
 * Extiende de {@link JugueteDTO} e incluye atributos específicos de las pistolas de agua.
 * Se utiliza para transferir datos entre capas de la aplicación sin exponer la lógica de negocio.
 */
public class PistolaAguaDTO extends JugueteDTO {

    /** Capacidad de agua que puede contener la pistola. */
    private double capacidadAgua;

    /** Cantidad de chorros que puede disparar la pistola. */
    private int cantidadChorros;

    /** Alcance máximo que puede alcanzar el chorro de agua. */
    private double alcanceMaximo;

    /**
     * Constructor por defecto de la clase.
     */
    public PistolaAguaDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos incluyendo los de la clase padre.
     *
     * @param nombre          Nombre del producto
     * @param marca           Marca del producto
     * @param tipoProducto    Tipo de producto
     * @param descripcion     Descripción del producto
     * @param urlImagen       URL de la imagen del producto
     * @param precio          Precio del producto
     * @param cantidad        Cantidad disponible
     * @param id              Identificador único del producto
     * @param capacidadAgua   Capacidad de agua de la pistola
     * @param cantidadChorros Cantidad de chorros
     * @param alcanceMaximo   Alcance máximo del chorro
     */
    public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                           double precio, int cantidad, String id, double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.capacidadAgua = capacidadAgua;
        this.cantidadChorros = cantidadChorros;
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Constructor que inicializa los atributos específicos de la pistola de agua
     * junto con la edad recomendada.
     *
     * @param edadRecomendada Edad recomendada para usar la pistola
     * @param capacidadAgua   Capacidad de agua de la pistola
     * @param cantidadChorros Cantidad de chorros
     * @param alcanceMaximo   Alcance máximo del chorro
     */
    public PistolaAguaDTO(int edadRecomendada, double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
        super(edadRecomendada);
        this.capacidadAgua = capacidadAgua;
        this.cantidadChorros = cantidadChorros;
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Constructor que inicializa solo los atributos específicos de la pistola de agua.
     *
     * @param capacidadAgua   Capacidad de agua de la pistola
     * @param cantidadChorros Cantidad de chorros
     * @param alcanceMaximo   Alcance máximo del chorro
     */
    public PistolaAguaDTO(double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
        super();
        this.capacidadAgua = capacidadAgua;
        this.cantidadChorros = cantidadChorros;
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Constructor que inicializa únicamente la edad recomendada.
     *
     * @param edadRecomendada Edad recomendada para usar la pistola
     */
    public PistolaAguaDTO(int edadRecomendada) {
        super(edadRecomendada);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos de la clase padre junto con la edad recomendada.
     *
     * @param nombre          Nombre del producto
     * @param marca           Marca del producto
     * @param tipoProducto    Tipo de producto
     * @param descripcion     Descripción del producto
     * @param urlImagen       URL de la imagen del producto
     * @param precio          Precio del producto
     * @param cantidad        Cantidad disponible
     * @param id              Identificador único del producto
     * @param edadRecomendada Edad recomendada para usar la pistola
     */
    public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                           double precio, int cantidad, String id, int edadRecomendada) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa únicamente los atributos heredados de la clase padre.
     *
     * @param nombre       Nombre del producto
     * @param marca        Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion  Descripción del producto
     * @param urlImagen    URL de la imagen del producto
     * @param precio       Precio del producto
     * @param cantidad     Cantidad disponible
     * @param id           Identificador único del producto
     */
    public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                           double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos, incluyendo los de la clase padre
     * y la edad recomendada.
     *
     * @param nombre          Nombre del producto
     * @param marca           Marca del producto
     * @param tipoProducto    Tipo de producto
     * @param descripcion     Descripción del producto
     * @param urlImagen       URL de la imagen del producto
     * @param precio          Precio del producto
     * @param cantidad        Cantidad disponible
     * @param id              Identificador único del producto
     * @param edadRecomendada Edad recomendada para usar la pistola
     * @param capacidadAgua   Capacidad de agua de la pistola
     * @param cantidadChorros Cantidad de chorros
     * @param alcanceMaximo   Alcance máximo del chorro
     */
    public PistolaAguaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                           double precio, int cantidad, String id, int edadRecomendada, double capacidadAgua, int cantidadChorros,
                           double alcanceMaximo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
        this.capacidadAgua = capacidadAgua;
        this.cantidadChorros = cantidadChorros;
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Obtiene la capacidad de agua de la pistola.
     *
     * @return Capacidad de agua
     */
    public double getCapacidadAgua() {
        return capacidadAgua;
    }

    /**
     * Establece la capacidad de agua de la pistola.
     *
     * @param capacidadAgua Capacidad de agua
     */
    public void setCapacidadAgua(double capacidadAgua) {
        this.capacidadAgua = capacidadAgua;
    }

    /**
     * Obtiene la cantidad de chorros de la pistola.
     *
     * @return Cantidad de chorros
     */
    public int getCantidadChorros() {
        return cantidadChorros;
    }

    /**
     * Establece la cantidad de chorros de la pistola.
     *
     * @param cantidadChorros Cantidad de chorros
     */
    public void setCantidadChorros(int cantidadChorros) {
        this.cantidadChorros = cantidadChorros;
    }

    /**
     * Obtiene el alcance máximo de la pistola.
     *
     * @return Alcance máximo
     */
    public double getAlcanceMaximo() {
        return alcanceMaximo;
    }

    /**
     * Establece el alcance máximo de la pistola.
     *
     * @param alcanceMaximo Alcance máximo
     */
    public void setAlcanceMaximo(double alcanceMaximo) {
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Crea y devuelve un clon de la instancia actual.
     *
     * @return Nuevo objeto {@link PistolaAguaDTO} con los mismos valores
     */
    @Override
    public PistolaAguaDTO clone() {
        return new PistolaAguaDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getEdadRecomendada(), getCapacidadAgua(), getCantidadChorros(), getAlcanceMaximo());
    }
}
