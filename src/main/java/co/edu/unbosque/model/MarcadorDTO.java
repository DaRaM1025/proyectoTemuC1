package co.edu.unbosque.model;

/**
 * Representa un marcador como un tipo específico de papelería.
 * Contiene información adicional sobre el tipo de punta, si es permanente y el tipo de marcador.
 * 
 * @author David Ramirez
 */
public class MarcadorDTO extends PapeleriaDTO {
    
    /** Tipo de punta del marcador (por ejemplo: fina, gruesa). */
    private String tipoPunta; 
    
    /** Indica si el marcador es permanente. */
    private boolean isPermanente;
    
    /** Tipo de marcador (por ejemplo: pizarra, resaltador). */
    private String tipoMarcador; 

    /**
     * Constructor por defecto.
     */
    public MarcadorDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con todos los atributos heredados y específicos de MarcadorDTO.
     *
     * @param nombre Nombre del marcador.
     * @param marca Marca del marcador.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del marcador.
     * @param urlImagen URL de la imagen del marcador.
     * @param precio Precio del marcador.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoPunta Tipo de punta del marcador.
     * @param isPermanente Indica si el marcador es permanente.
     * @param tipoMarcador Tipo de marcador.
     */
    public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPunta, boolean isPermanente, String tipoMarcador) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoPunta = tipoPunta;
        this.isPermanente = isPermanente;
        this.tipoMarcador = tipoMarcador;
    }

    /**
     * Constructor que incluye tipo de presentación y atributos específicos del marcador.
     *
     * @param tipoPresentacion Tipo de presentación.
     * @param tipoPunta Tipo de punta.
     * @param isPermanente Si es permanente.
     * @param tipoMarcador Tipo de marcador.
     */
    public MarcadorDTO(String tipoPresentacion, String tipoPunta, boolean isPermanente, String tipoMarcador) {
        super(tipoPresentacion);
        this.tipoPunta = tipoPunta;
        this.isPermanente = isPermanente;
        this.tipoMarcador = tipoMarcador;
    }

    /**
     * Constructor que recibe únicamente atributos del marcador.
     *
     * @param tipoPunta Tipo de punta.
     * @param isPermanente Si es permanente.
     * @param tipoMarcador Tipo de marcador.
     */
    public MarcadorDTO(String tipoPunta, boolean isPermanente, String tipoMarcador) {
        super();
        this.tipoPunta = tipoPunta;
        this.isPermanente = isPermanente;
        this.tipoMarcador = tipoMarcador;
    }

    /**
     * Constructor que recibe datos heredados y tipo de presentación.
     *
     * @param nombre Nombre del marcador.
     * @param marca Marca del marcador.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del marcador.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del marcador.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoPresentacion Tipo de presentación.
     */
    public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPresentacion) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
    }

    /**
     * Constructor que recibe datos heredados.
     *
     * @param nombre Nombre del marcador.
     * @param marca Marca del marcador.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del marcador.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del marcador.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     */
    public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor con tipo de presentación.
     *
     * @param tipoPresentacion Tipo de presentación.
     */
    public MarcadorDTO(String tipoPresentacion) {
        super(tipoPresentacion);
    }

    /**
     * Constructor con todos los atributos heredados y específicos.
     *
     * @param nombre Nombre del marcador.
     * @param marca Marca del marcador.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del marcador.
     * @param urlImagen URL de la imagen.
     * @param precio Precio del marcador.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param tipoPresentacion Tipo de presentación.
     * @param tipoPunta Tipo de punta.
     * @param isPermanente Si es permanente.
     * @param tipoMarcador Tipo de marcador.
     */
    public MarcadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPresentacion, String tipoPunta, boolean isPermanente,
            String tipoMarcador) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
        this.tipoPunta = tipoPunta;
        this.isPermanente = isPermanente;
        this.tipoMarcador = tipoMarcador;
    }

    /**
     * Obtiene el tipo de punta del marcador.
     *
     * @return Tipo de punta.
     */
    public String getTipoPunta() {
        return tipoPunta;
    }

    /**
     * Establece el tipo de punta del marcador.
     *
     * @param tipoPunta Tipo de punta.
     */
    public void setTipoPunta(String tipoPunta) {
        this.tipoPunta = tipoPunta;
    }

    /**
     * Verifica si el marcador es permanente.
     *
     * @return true si es permanente, false en caso contrario.
     */
    public boolean isPermanente() {
        return isPermanente;
    }

    /**
     * Establece si el marcador es permanente.
     *
     * @param isPermanente true si es permanente, false en caso contrario.
     */
    public void setPermanente(boolean isPermanente) {
        this.isPermanente = isPermanente;
    }

    /**
     * Obtiene el tipo de marcador.
     *
     * @return Tipo de marcador.
     */
    public String getTipoMarcador() {
        return tipoMarcador;
    }

    /**
     * Establece el tipo de marcador.
     *
     * @param tipoMarcador Tipo de marcador.
     */
    public void setTipoMarcador(String tipoMarcador) {
        this.tipoMarcador = tipoMarcador;
    }

    /**
     * Crea y devuelve una copia del objeto MarcadorDTO.
     *
     * @return Copia del objeto actual.
     */
    @Override
    public MarcadorDTO clone() {
        return new MarcadorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getTipoPresentacion(), getTipoPunta(), isPermanente(), getTipoMarcador());
    }

}
