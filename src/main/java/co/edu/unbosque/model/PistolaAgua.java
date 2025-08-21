package co.edu.unbosque.model;

/**
 * Clase que representa una pistola de agua como tipo de juguete.
 * Contiene información sobre su capacidad, cantidad de chorros y alcance máximo.
 */
public class PistolaAgua extends Juguete {

    /** Capacidad de agua en litros o mililitros */
    private double capacidadAgua;

    /** Cantidad de chorros que puede expulsar */
    private int cantidadChorros;

    /** Alcance máximo del agua en metros */
    private double alcanceMaximo;

    /**
     * Constructor por defecto de PistolaAgua.
     */
    public PistolaAgua() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos incluyendo los heredados de Juguete.
     *
     * @param nombre Nombre del juguete
     * @param marca Marca del juguete
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del juguete
     * @param urlImagen URL de la imagen del juguete
     * @param precio Precio del juguete
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param capacidadAgua Capacidad de agua
     * @param cantidadChorros Número de chorros
     * @param alcanceMaximo Alcance máximo
     */
    public PistolaAgua(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                       double precio, int cantidad, String id, double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.capacidadAgua = capacidadAgua;
        this.cantidadChorros = cantidadChorros;
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Constructor con edad recomendada y atributos de pistola de agua.
     *
     * @param edadRecomendada Edad mínima recomendada
     * @param capacidadAgua Capacidad de agua
     * @param cantidadChorros Número de chorros
     * @param alcanceMaximo Alcance máximo
     */
    public PistolaAgua(int edadRecomendada, double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
        super(edadRecomendada);
        this.capacidadAgua = capacidadAgua;
        this.cantidadChorros = cantidadChorros;
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Constructor con solo atributos de la pistola de agua.
     *
     * @param capacidadAgua Capacidad de agua
     * @param cantidadChorros Número de chorros
     * @param alcanceMaximo Alcance máximo
     */
    public PistolaAgua(double capacidadAgua, int cantidadChorros, double alcanceMaximo) {
        super();
        this.capacidadAgua = capacidadAgua;
        this.cantidadChorros = cantidadChorros;
        this.alcanceMaximo = alcanceMaximo;
    }

    /**
     * Constructor con solo edad recomendada.
     *
     * @param edadRecomendada Edad mínima recomendada
     */
    public PistolaAgua(int edadRecomendada) {
        super(edadRecomendada);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con atributos básicos y edad recomendada.
     *
     * @param nombre Nombre del juguete
     * @param marca Marca del juguete
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del juguete
     * @param urlImagen URL de la imagen
     * @param precio Precio del juguete
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param edadRecomendada Edad mínima recomendada
     */
    public PistolaAgua(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                       double precio, int cantidad, String id, int edadRecomendada) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, edadRecomendada);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con atributos básicos sin edad recomendada.
     *
     * @param nombre Nombre del juguete
     * @param marca Marca del juguete
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del juguete
     * @param urlImagen URL de la imagen
     * @param precio Precio del juguete
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     */
    public PistolaAgua(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                       double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos incluyendo edad recomendada.
     *
     * @param nombre Nombre del juguete
     * @param marca Marca del juguete
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del juguete
     * @param urlImagen URL de la imagen
     * @param precio Precio del juguete
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param edadRecomendada Edad mínima recomendada
     * @param capacidadAgua Capacidad de agua
     * @param cantidadChorros Número de chorros
     * @param alcanceMaximo Alcance máximo
     */
    public PistolaAgua(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
     * @return capacidad de agua
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
     * Obtiene la cantidad de chorros que puede expulsar.
     *
     * @return cantidad de chorros
     */
    public int getCantidadChorros() {
        return cantidadChorros;
    }

    /**
     * Establece la cantidad de chorros de la pistola.
     *
     * @param cantidadChorros Número de chorros
     */
    public void setCantidadChorros(int cantidadChorros) {
        this.cantidadChorros = cantidadChorros;
    }

    /**
     * Obtiene el alcance máximo de la pistola.
     *
     * @return alcance máximo en metros
     */
    public double getAlcanceMaximo() {
        return alcanceMaximo;
    }

    /**
     * Establece el alcance máximo de la pistola.
     *
     * @param alcanceMaximo Alcance máximo en metros
     */
    public void setAlcanceMaximo(double alcanceMaximo) {
        this.alcanceMaximo = alcanceMaximo;
    }
}
