package co.edu.unbosque.model;

/**
 * Representa un instrumento musical de percusión que hereda de {@link InstrumentoMusical}.
 * Este tipo de instrumento tiene características adicionales como tipo, uso de baquetas,
 * tipo de percusión y cantidad de superficies sonoras.
 * 
 * @author David Ramirez
 */
public class InstrumentoPercusion extends InstrumentoMusical {

    /** Tipo de instrumento de percusión (ejemplo: membranófono, idiófono). */
    private String tipoInstrumentoPercusion;

    /** Indica si el instrumento utiliza baquetas. */
    private boolean usoBaquetas;

    /** Tipo de percusión (ejemplo: directa, indirecta). */
    private String tipoPercusion;

    /** Cantidad de superficies sonoras del instrumento. */
    private int cantSuperficiesSonoras;

    /**
     * Constructor por defecto.
     */
    public InstrumentoPercusion() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos heredados y los propios de la clase.
     *
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen del instrumento.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoInstrumentoPercusion Tipo de instrumento de percusión.
     * @param usoBaquetas Indica si se usan baquetas.
     * @param tipoPercusion Tipo de percusión.
     * @param cantSuperficiesSonoras Cantidad de superficies sonoras.
     */
    public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoInstrumentoPercusion, boolean usoBaquetas,
            String tipoPercusion, int cantSuperficiesSonoras) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
        this.usoBaquetas = usoBaquetas;
        this.tipoPercusion = tipoPercusion;
        this.cantSuperficiesSonoras = cantSuperficiesSonoras;
    }

    /**
     * Constructor que inicializa solo los atributos propios de la clase.
     *
     * @param tipoInstrumentoPercusion Tipo de instrumento de percusión.
     * @param usoBaquetas Indica si se usan baquetas.
     * @param tipoPercusion Tipo de percusión.
     * @param cantSuperficiesSonoras Cantidad de superficies sonoras.
     */
    public InstrumentoPercusion(String tipoInstrumentoPercusion, boolean usoBaquetas, String tipoPercusion,
            int cantSuperficiesSonoras) {
        super();
        this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
        this.usoBaquetas = usoBaquetas;
        this.tipoPercusion = tipoPercusion;
        this.cantSuperficiesSonoras = cantSuperficiesSonoras;
    }

    /**
     * Constructor que inicializa el atributo de inclusión de estuche.
     *
     * @param incluyeEstuche Indica si incluye estuche.
     */
    public InstrumentoPercusion(boolean incluyeEstuche) {
        super(incluyeEstuche);
    }

    /**
     * Constructor que inicializa atributos heredados y si incluye estuche.
     *
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen del instrumento.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param incluyeEstuche Indica si incluye estuche.
     */
    public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean incluyeEstuche) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
    }

    /**
     * Constructor que inicializa los atributos heredados sin incluir estuche.
     *
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen del instrumento.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     */
    public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param nombre Nombre del instrumento.
     * @param marca Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del instrumento.
     * @param urlImagen URL de la imagen del instrumento.
     * @param precio Precio del instrumento.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param incluyeEstuche Indica si incluye estuche.
     * @param tipoInstrumentoPercusion Tipo de instrumento de percusión.
     * @param usoBaquetas Indica si se usan baquetas.
     * @param tipoPercusion Tipo de percusión.
     * @param cantSuperficiesSonoras Cantidad de superficies sonoras.
     */
    public InstrumentoPercusion(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean incluyeEstuche, String tipoInstrumentoPercusion,
            boolean usoBaquetas, String tipoPercusion, int cantSuperficiesSonoras) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
        this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
        this.usoBaquetas = usoBaquetas;
        this.tipoPercusion = tipoPercusion;
        this.cantSuperficiesSonoras = cantSuperficiesSonoras;
    }

    /**
     * Obtiene el tipo de instrumento de percusión.
     *
     * @return Tipo de instrumento de percusión.
     */
    public String getTipoInstrumentoPercusion() {
        return tipoInstrumentoPercusion;
    }

    /**
     * Establece el tipo de instrumento de percusión.
     *
     * @param tipoInstrumentoPercusion Tipo de instrumento de percusión.
     */
    public void setTipoInstrumentoPercusion(String tipoInstrumentoPercusion) {
        this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
    }

    /**
     * Verifica si el instrumento utiliza baquetas.
     *
     * @return true si utiliza baquetas, false en caso contrario.
     */
    public boolean isUsoBaquetas() {
        return usoBaquetas;
    }

    /**
     * Establece si el instrumento utiliza baquetas.
     *
     * @param usoBaquetas true si utiliza baquetas, false en caso contrario.
     */
    public void setUsoBaquetas(boolean usoBaquetas) {
        this.usoBaquetas = usoBaquetas;
    }

    /**
     * Obtiene el tipo de percusión.
     *
     * @return Tipo de percusión.
     */
    public String getTipoPercusion() {
        return tipoPercusion;
    }

    /**
     * Establece el tipo de percusión.
     *
     * @param tipoPercusion Tipo de percusión.
     */
    public void setTipoPercusion(String tipoPercusion) {
        this.tipoPercusion = tipoPercusion;
    }

    /**
     * Obtiene la cantidad de superficies sonoras.
     *
     * @return Cantidad de superficies sonoras.
     */
    public int getCantSuperficiesSonoras() {
        return cantSuperficiesSonoras;
    }

    /**
     * Establece la cantidad de superficies sonoras.
     *
     * @param cantSuperficiesSonoras Cantidad de superficies sonoras.
     */
    public void setCantSuperficiesSonoras(int cantSuperficiesSonoras) {
        this.cantSuperficiesSonoras = cantSuperficiesSonoras;
    }
}
