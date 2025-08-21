package co.edu.unbosque.model;

/**
 * Representa un instrumento de percusión dentro del sistema, extendiendo las
 * características generales de {@link InstrumentoMusicalDTO}. Contiene
 * información específica como el tipo de instrumento, si utiliza baquetas,
 * el tipo de percusión y la cantidad de superficies sonoras.
 * 
 * <p>Esta clase se utiliza como DTO (Data Transfer Object) para manejar
 * datos relacionados con instrumentos de percusión en operaciones de
 * transferencia y persistencia.</p>
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class InstrumentoPercusionDTO extends InstrumentoMusicalDTO {

    /**
     * Tipo de instrumento de percusión (por ejemplo: membranófono, idiófono).
     */
    private String tipoInstrumentoPercusion;

    /**
     * Indica si el instrumento requiere el uso de baquetas.
     */
    private boolean usoBaquetas;

    /**
     * Tipo de percusión (por ejemplo: afinada, no afinada).
     */
    private String tipoPercusion;

    /**
     * Número de superficies sonoras que posee el instrumento.
     */
    private int cantSuperficiesSonoras;

    /**
     * Constructor por defecto.
     */
    public InstrumentoPercusionDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y específicos.
     *
     * @param nombre                    Nombre del instrumento.
     * @param marca                     Marca del instrumento.
     * @param tipoProducto              Tipo de producto.
     * @param descripcion               Descripción del instrumento.
     * @param urlImagen                 URL de la imagen del instrumento.
     * @param precio                    Precio del instrumento.
     * @param cantidad                  Cantidad disponible.
     * @param id                        Identificador único del instrumento.
     * @param tipoInstrumentoPercusion  Tipo de instrumento de percusión.
     * @param usoBaquetas               Indica si se utilizan baquetas.
     * @param tipoPercusion             Tipo de percusión.
     * @param cantSuperficiesSonoras    Cantidad de superficies sonoras.
     */
    public InstrumentoPercusionDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoInstrumentoPercusion, boolean usoBaquetas,
            String tipoPercusion, int cantSuperficiesSonoras) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
        this.usoBaquetas = usoBaquetas;
        this.tipoPercusion = tipoPercusion;
        this.cantSuperficiesSonoras = cantSuperficiesSonoras;
    }

    /**
     * Constructor que inicializa solo los atributos específicos de percusión.
     *
     * @param tipoInstrumentoPercusion  Tipo de instrumento de percusión.
     * @param usoBaquetas               Indica si se utilizan baquetas.
     * @param tipoPercusion             Tipo de percusión.
     * @param cantSuperficiesSonoras    Cantidad de superficies sonoras.
     */
    public InstrumentoPercusionDTO(String tipoInstrumentoPercusion, boolean usoBaquetas, String tipoPercusion,
            int cantSuperficiesSonoras) {
        super();
        this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
        this.usoBaquetas = usoBaquetas;
        this.tipoPercusion = tipoPercusion;
        this.cantSuperficiesSonoras = cantSuperficiesSonoras;
    }

    /**
     * Constructor que indica si el instrumento incluye estuche.
     *
     * @param incluyeEstuche Indica si el instrumento incluye estuche.
     */
    public InstrumentoPercusionDTO(boolean incluyeEstuche) {
        super(incluyeEstuche);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa atributos heredados y especifica si incluye estuche.
     *
     * @param nombre          Nombre del instrumento.
     * @param marca           Marca del instrumento.
     * @param tipoProducto    Tipo de producto.
     * @param descripcion     Descripción del instrumento.
     * @param urlImagen       URL de la imagen del instrumento.
     * @param precio          Precio del instrumento.
     * @param cantidad        Cantidad disponible.
     * @param id              Identificador único del instrumento.
     * @param incluyeEstuche  Indica si el instrumento incluye estuche.
     */
    public InstrumentoPercusionDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, boolean incluyeEstuche) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, incluyeEstuche);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos heredados sin considerar el estuche.
     *
     * @param nombre       Nombre del instrumento.
     * @param marca        Marca del instrumento.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del instrumento.
     * @param urlImagen    URL de la imagen del instrumento.
     * @param precio       Precio del instrumento.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único del instrumento.
     */
    public InstrumentoPercusionDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos incluyendo si incluye estuche
     * y los específicos de percusión.
     *
     * @param nombre                    Nombre del instrumento.
     * @param marca                     Marca del instrumento.
     * @param tipoProducto              Tipo de producto.
     * @param descripcion               Descripción del instrumento.
     * @param urlImagen                 URL de la imagen del instrumento.
     * @param precio                    Precio del instrumento.
     * @param cantidad                  Cantidad disponible.
     * @param id                        Identificador único del instrumento.
     * @param incluyeEstuche            Indica si incluye estuche.
     * @param tipoInstrumentoPercusion  Tipo de instrumento de percusión.
     * @param usoBaquetas               Indica si se utilizan baquetas.
     * @param tipoPercusion             Tipo de percusión.
     * @param cantSuperficiesSonoras    Cantidad de superficies sonoras.
     */
    public InstrumentoPercusionDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
     * Indica si el instrumento utiliza baquetas.
     *
     * @return {@code true} si usa baquetas, {@code false} en caso contrario.
     */
    public boolean isUsoBaquetas() {
        return usoBaquetas;
    }

    /**
     * Establece si el instrumento utiliza baquetas.
     *
     * @param usoBaquetas {@code true} si usa baquetas, {@code false} en caso contrario.
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
     * Obtiene la cantidad de superficies sonoras del instrumento.
     *
     * @return Cantidad de superficies sonoras.
     */
    public int getCantSuperficiesSonoras() {
        return cantSuperficiesSonoras;
    }

    /**
     * Establece la cantidad de superficies sonoras del instrumento.
     *
     * @param cantSuperficiesSonoras Cantidad de superficies sonoras.
     */
    public void setCantSuperficiesSonoras(int cantSuperficiesSonoras) {
        this.cantSuperficiesSonoras = cantSuperficiesSonoras;
    }

    /**
     * Crea una copia exacta del objeto actual.
     *
     * @return Una nueva instancia de {@code InstrumentoPercusionDTO} con los mismos valores.
     */
    @Override
    public InstrumentoPercusionDTO clone() {
        return new InstrumentoPercusionDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), isIncluyeEstuche(), getTipoInstrumentoPercusion(), isUsoBaquetas(), getTipoPercusion(), getCantSuperficiesSonoras());
    }
}
