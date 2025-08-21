package co.edu.unbosque.model;

/**
 * Representa un Data Transfer Object (DTO) para un instrumento musical.
 * Esta clase hereda de {@link ProductoDTO} e incluye información adicional
 * sobre si el instrumento viene con estuche.
 * 
 * <p>Se utiliza para transportar datos entre capas sin exponer la lógica interna.</p>
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class InstrumentoMusicalDTO extends ProductoDTO {

    /**
     * Indica si el instrumento incluye un estuche.
     */
    protected boolean incluyeEstuche;

    /**
     * Constructor por defecto que inicializa el objeto sin valores asignados.
     */
    public InstrumentoMusicalDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un instrumento musical con los atributos heredados
     * de {@link ProductoDTO}.
     * 
     * @param nombre       Nombre del instrumento musical.
     * @param marca        Marca del instrumento musical.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del instrumento.
     * @param urlImagen    URL de la imagen representativa.
     * @param precio       Precio del instrumento.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único del instrumento.
     */
    public InstrumentoMusicalDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                                  double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa el objeto indicando si incluye estuche.
     * 
     * @param incluyeEstuche {@code true} si el instrumento incluye estuche, {@code false} en caso contrario.
     */
    public InstrumentoMusicalDTO(boolean incluyeEstuche) {
        super();
        this.incluyeEstuche = incluyeEstuche;
    }

    /**
     * Constructor que inicializa todos los atributos del instrumento musical,
     * incluyendo los heredados y si incluye estuche.
     * 
     * @param nombre         Nombre del instrumento musical.
     * @param marca          Marca del instrumento musical.
     * @param tipoProducto   Tipo de producto.
     * @param descripcion    Descripción del instrumento.
     * @param urlImagen      URL de la imagen representativa.
     * @param precio         Precio del instrumento.
     * @param cantidad       Cantidad disponible.
     * @param id             Identificador único del instrumento.
     * @param incluyeEstuche {@code true} si incluye estuche, {@code false} en caso contrario.
     */
    public InstrumentoMusicalDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                                  double precio, int cantidad, String id, boolean incluyeEstuche) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.incluyeEstuche = incluyeEstuche;
    }

    /**
     * Indica si el instrumento incluye un estuche.
     * 
     * @return {@code true} si incluye estuche, {@code false} en caso contrario.
     */
    public boolean isIncluyeEstuche() {
        return incluyeEstuche;
    }

    /**
     * Establece si el instrumento incluye un estuche.
     * 
     * @param incluyeEstuche {@code true} para indicar que incluye estuche, {@code false} en caso contrario.
     */
    public void setIncluyeEstuche(boolean incluyeEstuche) {
        this.incluyeEstuche = incluyeEstuche;
    }

}
