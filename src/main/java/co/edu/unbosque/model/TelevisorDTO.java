package co.edu.unbosque.model;

/**
 * Clase que representa un Data Transfer Object (DTO) para Televisor.
 * Contiene atributos heredados de DispositivoElectronicoDTO y atributos específicos de Televisor.
 */
public class TelevisorDTO extends DispositivoElectronicoDTO {

    /** Cantidad de puertos HDMI disponibles en el televisor. */
    private int cantPuertosHDMI;

    /** Frecuencia de actualización de la pantalla en Hz. */
    private int frecuenciaHz;

    /** Asistente virtual integrado en el televisor. */
    private String asistenteVirtual;

    /**
     * Constructor por defecto de TelevisorDTO.
     */
    public TelevisorDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos heredados de DispositivoElectronicoDTO
     * y los específicos de TelevisorDTO.
     *
     * @param pulgadas Tamaño de la pantalla en pulgadas
     * @param resolucion Resolución de la pantalla
     * @param sistemaOperativo Sistema operativo del televisor
     * @param cantPuertosHDMI Cantidad de puertos HDMI
     * @param frecuenciaHz Frecuencia de actualización en Hz
     * @param asistenteVirtual Asistente virtual integrado
     */
    public TelevisorDTO(double pulgadas, String resolucion, String sistemaOperativo, int cantPuertosHDMI, int frecuenciaHz,
                        String asistenteVirtual) {
        super(pulgadas, resolucion, sistemaOperativo);
        this.cantPuertosHDMI = cantPuertosHDMI;
        this.frecuenciaHz = frecuenciaHz;
        this.asistenteVirtual = asistenteVirtual;
    }

    /**
     * Constructor que inicializa únicamente los atributos específicos de TelevisorDTO.
     *
     * @param cantPuertosHDMI Cantidad de puertos HDMI
     * @param frecuenciaHz Frecuencia de actualización en Hz
     * @param asistenteVirtual Asistente virtual integrado
     */
    public TelevisorDTO(int cantPuertosHDMI, int frecuenciaHz, String asistenteVirtual) {
        super();
        this.cantPuertosHDMI = cantPuertosHDMI;
        this.frecuenciaHz = frecuenciaHz;
        this.asistenteVirtual = asistenteVirtual;
    }

    /**
     * Constructor que inicializa solo los atributos heredados de DispositivoElectronicoDTO.
     *
     * @param pulgadas Tamaño de la pantalla en pulgadas
     * @param resolucion Resolución de la pantalla
     * @param sistemaOperativo Sistema operativo del televisor
     */
    public TelevisorDTO(double pulgadas, String resolucion, String sistemaOperativo) {
        super(pulgadas, resolucion, sistemaOperativo);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa atributos heredados de ProductoDTO y DispositivoElectronicoDTO.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param pulgadas Tamaño de la pantalla
     * @param resolucion Resolución de la pantalla
     * @param sistemaOperativo Sistema operativo del televisor
     */
    public TelevisorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                        double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion, sistemaOperativo);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa solo los atributos heredados de ProductoDTO.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     */
    public TelevisorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                        double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y específicos de TelevisorDTO.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param pulgadas Tamaño de la pantalla
     * @param resolucion Resolución de la pantalla
     * @param sistemaOperativo Sistema operativo del televisor
     * @param cantPuertosHDMI Cantidad de puertos HDMI
     * @param frecuenciaHz Frecuencia de actualización
     * @param asistenteVirtual Asistente virtual integrado
     */
    public TelevisorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                        double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
                        int cantPuertosHDMI, int frecuenciaHz, String asistenteVirtual) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion, sistemaOperativo);
        this.cantPuertosHDMI = cantPuertosHDMI;
        this.frecuenciaHz = frecuenciaHz;
        this.asistenteVirtual = asistenteVirtual;
    }

    /**
     * Obtiene la cantidad de puertos HDMI.
     *
     * @return Cantidad de puertos HDMI
     */
    public int getCantPuertosHDMI() {
        return cantPuertosHDMI;
    }

    /**
     * Establece la cantidad de puertos HDMI.
     *
     * @param cantPuertosHDMI Cantidad de puertos HDMI
     */
    public void setCantPuertosHDMI(int cantPuertosHDMI) {
        this.cantPuertosHDMI = cantPuertosHDMI;
    }

    /**
     * Obtiene la frecuencia de actualización en Hz.
     *
     * @return Frecuencia de actualización
     */
    public int getFrecuenciaHz() {
        return frecuenciaHz;
    }

    /**
     * Establece la frecuencia de actualización en Hz.
     *
     * @param frecuenciaHz Frecuencia de actualización
     */
    public void setFrecuenciaHz(int frecuenciaHz) {
        this.frecuenciaHz = frecuenciaHz;
    }

    /**
     * Obtiene el asistente virtual del televisor.
     *
     * @return Asistente virtual
     */
    public String getAsistenteVirtual() {
        return asistenteVirtual;
    }

    /**
     * Establece el asistente virtual del televisor.
     *
     * @param asistenteVirtual Asistente virtual
     */
    public void setAsistenteVirtual(String asistenteVirtual) {
        this.asistenteVirtual = asistenteVirtual;
    }

    /**
     * Crea un clon del objeto TelevisorDTO actual.
     *
     * @return Nuevo objeto TelevisorDTO con los mismos atributos
     */
    @Override
    public TelevisorDTO clone() {
        return new TelevisorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getPulgadas(), getResolucion(), getSistemaOperativo(), getCantPuertosHDMI(), getFrecuenciaHz(), getAsistenteVirtual());
    }

}
