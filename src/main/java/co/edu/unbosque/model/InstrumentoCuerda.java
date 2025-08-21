package co.edu.unbosque.model;

/**
 * Representa un instrumento musical de cuerda, que extiende la clase {@link InstrumentoMusical}.
 * Contiene información específica como tipo de instrumento, número de cuerdas, tipo de cuerda
 * y si posee caja de resonancia.
 * 
 * Ejemplos de instrumentos de cuerda incluyen guitarras, violines y arpas.
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class InstrumentoCuerda extends InstrumentoMusical {
    
    /**
     * Tipo del instrumento de cuerda (ejemplo: guitarra, violín, bajo).
     */
    private String tipoInstrumentoCuerda; // Posible enum
    
    /**
     * Número de cuerdas que posee el instrumento.
     */
    private int numeroCuerdas;
    
    /**
     * Tipo de cuerda utilizada en el instrumento (ejemplo: nylon, metal).
     */
    private String tipoCuerda; // Posible enum
    
    /**
     * Indica si el instrumento tiene caja de resonancia.
     */
    private boolean tieneCajaResonancia;

    /**
     * Constructor por defecto.
     */
    public InstrumentoCuerda() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y propios.
     * 
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen del instrumento.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoInstrumentoCuerda Tipo del instrumento de cuerda.
     * @param numeroCuerdas Número de cuerdas.
     * @param tipoCuerda Tipo de cuerda.
     * @param tieneCajaResonancia Indica si tiene caja de resonancia.
     */
    public InstrumentoCuerda(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoInstrumentoCuerda, int numeroCuerdas, String tipoCuerda,
            boolean tieneCajaResonancia) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
        this.numeroCuerdas = numeroCuerdas;
        this.tipoCuerda = tipoCuerda;
        this.tieneCajaResonancia = tieneCajaResonancia;
    }

    /**
     * Constructor que inicializa únicamente los atributos propios.
     * 
     * @param tipoInstrumentoCuerda Tipo del instrumento de cuerda.
     * @param numeroCuerdas Número de cuerdas.
     * @param tipoCuerda Tipo de cuerda.
     * @param tieneCajaResonancia Indica si tiene caja de resonancia.
     */
    public InstrumentoCuerda(String tipoInstrumentoCuerda, int numeroCuerdas, String tipoCuerda,
            boolean tieneCajaResonancia) {
        super();
        this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
        this.numeroCuerdas = numeroCuerdas;
        this.tipoCuerda = tipoCuerda;
        this.tieneCajaResonancia = tieneCajaResonancia;
    }

    /**
     * Constructor que inicializa el atributo incluyeEstuche en la clase padre.
     * 
     * @param incluyeEstuche Indica si incluye estuche.
     */
    public InstrumentoCuerda(boolean incluyeEstuche) {
        super(incluyeEstuche);
    }

    /**
     * Constructor que inicializa atributos heredados y el campo incluyeEstuche.
     * 
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param incluyeEstuche Indica si incluye estuche.
     */
    public InstrumentoCuerda(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean incluyeEstuche) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
    }

    /**
     * Constructor que inicializa atributos heredados sin campos adicionales.
     * 
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     */
    public InstrumentoCuerda(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa todos los atributos incluyendo estuche y campos propios.
     * 
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param incluyeEstuche Indica si incluye estuche.
     * @param tipoInstrumentoCuerda Tipo del instrumento de cuerda.
     * @param numeroCuerdas Número de cuerdas.
     * @param tipoCuerda Tipo de cuerda.
     * @param tieneCajaResonancia Indica si tiene caja de resonancia.
     */
    public InstrumentoCuerda(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoCuerda,
            int numeroCuerdas, String tipoCuerda, boolean tieneCajaResonancia) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
        this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
        this.numeroCuerdas = numeroCuerdas;
        this.tipoCuerda = tipoCuerda;
        this.tieneCajaResonancia = tieneCajaResonancia;
    }

    /**
     * Obtiene el tipo de instrumento de cuerda.
     * 
     * @return Tipo del instrumento de cuerda.
     */
    public String getTipoInstrumentoCuerda() {
        return tipoInstrumentoCuerda;
    }

    /**
     * Establece el tipo de instrumento de cuerda.
     * 
     * @param tipoInstrumentoCuerda Tipo del instrumento de cuerda.
     */
    public void setTipoInstrumentoCuerda(String tipoInstrumentoCuerda) {
        this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
    }

    /**
     * Obtiene el número de cuerdas.
     * 
     * @return Número de cuerdas.
     */
    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }

    /**
     * Establece el número de cuerdas.
     * 
     * @param numeroCuerdas Número de cuerdas.
     */
    public void setNumeroCuerdas(int numeroCuerdas) {
        this.numeroCuerdas = numeroCuerdas;
    }

    /**
     * Obtiene el tipo de cuerda.
     * 
     * @return Tipo de cuerda.
     */
    public String getTipoCuerda() {
        return tipoCuerda;
    }

    /**
     * Establece el tipo de cuerda.
     * 
     * @param tipoCuerda Tipo de cuerda.
     */
    public void setTipoCuerda(String tipoCuerda) {
        this.tipoCuerda = tipoCuerda;
    }

    /**
     * Verifica si tiene caja de resonancia.
     * 
     * @return {@code true} si tiene caja de resonancia, {@code false} en caso contrario.
     */
    public boolean isTieneCajaResonancia() {
        return tieneCajaResonancia;
    }

    /**
     * Establece si el instrumento tiene caja de resonancia.
     * 
     * @param tieneCajaResonancia Valor booleano que indica si tiene caja de resonancia.
     */
    public void setTieneCajaResonancia(boolean tieneCajaResonancia) {
        this.tieneCajaResonancia = tieneCajaResonancia;
    }
}
