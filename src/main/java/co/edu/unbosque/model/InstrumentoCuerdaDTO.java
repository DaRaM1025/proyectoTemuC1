package co.edu.unbosque.model;

/**
 * Representa un instrumento musical de cuerda. Extiende la clase {@link InstrumentoMusicalDTO}
 * y añade características específicas como el tipo de instrumento de cuerda, el número de cuerdas,
 * el tipo de cuerda y si posee caja de resonancia.
 * 
 * <p>Esta clase permite modelar instrumentos como guitarras, violines, bajos, entre otros.</p>
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class InstrumentoCuerdaDTO extends InstrumentoMusicalDTO {
    
    /** Tipo de instrumento de cuerda (ejemplo: guitarra, violín). */
    private String tipoInstrumentoCuerda;
    
    /** Número de cuerdas que posee el instrumento. */
    private int numeroCuerdas;
    
    /** Tipo de cuerdas utilizadas (ejemplo: nylon, acero). */
    private String tipoCuerda;
    
    /** Indica si el instrumento tiene caja de resonancia. */
    private boolean tieneCajaResonancia;

    /**
     * Constructor por defecto.
     */
    public InstrumentoCuerdaDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y propios de la clase.
     * 
     * @param nombre nombre del instrumento
     * @param marca marca del instrumento
     * @param tipoProducto tipo de producto
     * @param descripcion descripción del instrumento
     * @param urlImagen URL de la imagen del producto
     * @param precio precio del instrumento
     * @param cantidad cantidad disponible
     * @param id identificador único del instrumento
     * @param tipoInstrumentoCuerda tipo de instrumento de cuerda
     * @param numeroCuerdas número de cuerdas
     * @param tipoCuerda tipo de cuerda
     * @param tieneCajaResonancia indica si tiene caja de resonancia
     */
    public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoInstrumentoCuerda, int numeroCuerdas, String tipoCuerda,
            boolean tieneCajaResonancia) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
        this.numeroCuerdas = numeroCuerdas;
        this.tipoCuerda = tipoCuerda;
        this.tieneCajaResonancia = tieneCajaResonancia;
    }

    /**
     * Constructor que inicializa únicamente los atributos propios de la clase.
     * 
     * @param tipoInstrumentoCuerda tipo de instrumento de cuerda
     * @param numeroCuerdas número de cuerdas
     * @param tipoCuerda tipo de cuerda
     * @param tieneCajaResonancia indica si tiene caja de resonancia
     */
    public InstrumentoCuerdaDTO(String tipoInstrumentoCuerda, int numeroCuerdas, String tipoCuerda,
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
     * @param incluyeEstuche indica si incluye estuche
     */
    public InstrumentoCuerdaDTO(boolean incluyeEstuche) {
        super(incluyeEstuche);
    }

    /**
     * Constructor que inicializa los atributos heredados y el incluyeEstuche.
     * 
     * @param nombre nombre del instrumento
     * @param marca marca del instrumento
     * @param tipoProducto tipo de producto
     * @param descripcion descripción del instrumento
     * @param urlImagen URL de la imagen del producto
     * @param precio precio del instrumento
     * @param cantidad cantidad disponible
     * @param id identificador único del instrumento
     * @param incluyeEstuche indica si incluye estuche
     */
    public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean incluyeEstuche) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
    }

    /**
     * Constructor que inicializa los atributos heredados sin información adicional.
     * 
     * @param nombre nombre del instrumento
     * @param marca marca del instrumento
     * @param tipoProducto tipo de producto
     * @param descripcion descripción del instrumento
     * @param urlImagen URL de la imagen del producto
     * @param precio precio del instrumento
     * @param cantidad cantidad disponible
     * @param id identificador único del instrumento
     */
    public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa todos los atributos heredados y propios.
     * 
     * @param nombre nombre del instrumento
     * @param marca marca del instrumento
     * @param tipoProducto tipo de producto
     * @param descripcion descripción del instrumento
     * @param urlImagen URL de la imagen del producto
     * @param precio precio del instrumento
     * @param cantidad cantidad disponible
     * @param id identificador único del instrumento
     * @param incluyeEstuche indica si incluye estuche
     * @param tipoInstrumentoCuerda tipo de instrumento de cuerda
     * @param numeroCuerdas número de cuerdas
     * @param tipoCuerda tipo de cuerda
     * @param tieneCajaResonancia indica si tiene caja de resonancia
     */
    public InstrumentoCuerdaDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoCuerda,
            int numeroCuerdas, String tipoCuerda, boolean tieneCajaResonancia) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
        this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
        this.numeroCuerdas = numeroCuerdas;
        this.tipoCuerda = tipoCuerda;
        this.tieneCajaResonancia = tieneCajaResonancia;
    }

    /** @return el tipo de instrumento de cuerda */
    public String getTipoInstrumentoCuerda() {
        return tipoInstrumentoCuerda;
    }

    /** @param tipoInstrumentoCuerda establece el tipo de instrumento de cuerda */
    public void setTipoInstrumentoCuerda(String tipoInstrumentoCuerda) {
        this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
    }

    /** @return el número de cuerdas */
    public int getNumeroCuerdas() {
        return numeroCuerdas;
    }

    /** @param numeroCuerdas establece el número de cuerdas */
    public void setNumeroCuerdas(int numeroCuerdas) {
        this.numeroCuerdas = numeroCuerdas;
    }

    /** @return el tipo de cuerda */
    public String getTipoCuerda() {
        return tipoCuerda;
    }

    /** @param tipoCuerda establece el tipo de cuerda */
    public void setTipoCuerda(String tipoCuerda) {
        this.tipoCuerda = tipoCuerda;
    }

    /** @return true si tiene caja de resonancia, false en caso contrario */
    public boolean isTieneCajaResonancia() {
        return tieneCajaResonancia;
    }

    /** @param tieneCajaResonancia establece si el instrumento tiene caja de resonancia */
    public void setTieneCajaResonancia(boolean tieneCajaResonancia) {
        this.tieneCajaResonancia = tieneCajaResonancia;
    }

    /**
     * Crea y devuelve una copia del objeto actual.
     * 
     * @return un nuevo objeto {@code InstrumentoCuerdaDTO} con los mismos valores
     */
    @Override
    public InstrumentoCuerdaDTO clone() {
        return new InstrumentoCuerdaDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(),
                getPrecio(), getCantidad(), getId(), isIncluyeEstuche(), getTipoInstrumentoCuerda(),
                getNumeroCuerdas(), getTipoCuerda(), isTieneCajaResonancia());
    }

}
