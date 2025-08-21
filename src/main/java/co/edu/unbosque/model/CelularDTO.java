package co.edu.unbosque.model;

/**
 * Representa un objeto Celular que hereda de {@link DispositivoElectronicoDTO}.
 * Esta clase contiene información específica sobre dispositivos móviles como
 * almacenamiento, memoria RAM, cantidad de cámaras y soporte para Dual SIM.
 * 
 * Permite la creación de objetos mediante diferentes constructores para adaptarse
 * a diversos escenarios de inicialización. Además, implementa un método {@code clone()}
 * para crear copias de la instancia actual.
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class CelularDTO extends DispositivoElectronicoDTO {

    /** Capacidad de almacenamiento del dispositivo (ej: 128GB, 256GB). */
    private String almacenamiento;

    /** Cantidad de memoria RAM del dispositivo (ej: 4GB, 8GB). */
    private String ram;

    /** Número de cámaras que posee el dispositivo. */
    private int cantidadCamaras;

    /** Indica si el dispositivo soporta Dual SIM. */
    private boolean dualSim;

    /**
     * Constructor por defecto.
     */
    public CelularDTO() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa un celular con información general y específica.
     * 
     * @param nombre Nombre del dispositivo.
     * @param marca Marca del dispositivo.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del dispositivo.
     * @param urlImagen URL de la imagen del dispositivo.
     * @param precio Precio del dispositivo.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param almacenamiento Capacidad de almacenamiento.
     * @param ram Cantidad de memoria RAM.
     * @param cantidadCamaras Número de cámaras.
     * @param dualSim Indica si soporta Dual SIM.
     */
    public CelularDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String almacenamiento, String ram, int cantidadCamaras,
            boolean dualSim) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.cantidadCamaras = cantidadCamaras;
        this.dualSim = dualSim;
    }

    /**
     * Constructor que inicializa un celular con detalles técnicos y características específicas.
     * 
     * @param pulgadas Tamaño de la pantalla en pulgadas.
     * @param resolucion Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     * @param almacenamiento Capacidad de almacenamiento.
     * @param ram Cantidad de memoria RAM.
     * @param cantidadCamaras Número de cámaras.
     * @param dualSim Indica si soporta Dual SIM.
     */
    public CelularDTO(double pulgadas, String resolucion, String sistemaOperativo, String almacenamiento, String ram,
            int cantidadCamaras, boolean dualSim) {
        super(pulgadas, resolucion, sistemaOperativo);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.cantidadCamaras = cantidadCamaras;
        this.dualSim = dualSim;
    }

    /**
     * Constructor que inicializa solo con las características específicas del celular.
     * 
     * @param almacenamiento Capacidad de almacenamiento.
     * @param ram Cantidad de memoria RAM.
     * @param cantidadCamaras Número de cámaras.
     * @param dualSim Indica si soporta Dual SIM.
     */
    public CelularDTO(String almacenamiento, String ram, int cantidadCamaras, boolean dualSim) {
        super();
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.cantidadCamaras = cantidadCamaras;
        this.dualSim = dualSim;
    }

    /**
     * Constructor que inicializa solo con datos técnicos del dispositivo.
     * 
     * @param pulgadas Tamaño de la pantalla en pulgadas.
     * @param resolucion Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     */
    public CelularDTO(double pulgadas, String resolucion, String sistemaOperativo) {
        super(pulgadas, resolucion, sistemaOperativo);
    }

    /**
     * Constructor que inicializa con datos generales y técnicos del dispositivo.
     * 
     * @param nombre Nombre del dispositivo.
     * @param marca Marca del dispositivo.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del dispositivo.
     * @param urlImagen URL de la imagen del dispositivo.
     * @param precio Precio del dispositivo.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param pulgadas Tamaño de la pantalla en pulgadas.
     * @param resolucion Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     */
    public CelularDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
                sistemaOperativo);
    }

    /**
     * Constructor que inicializa con información completa del dispositivo.
     * 
     * @param nombre Nombre del dispositivo.
     * @param marca Marca del dispositivo.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del dispositivo.
     * @param urlImagen URL de la imagen del dispositivo.
     * @param precio Precio del dispositivo.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param pulgadas Tamaño de la pantalla en pulgadas.
     * @param resolucion Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     * @param almacenamiento Capacidad de almacenamiento.
     * @param ram Cantidad de memoria RAM.
     * @param cantidadCamaras Número de cámaras.
     * @param dualSim Indica si soporta Dual SIM.
     */
    public CelularDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
            String almacenamiento, String ram, int cantidadCamaras, boolean dualSim) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
                sistemaOperativo);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.cantidadCamaras = cantidadCamaras;
        this.dualSim = dualSim;
    }

    /**
     * Obtiene la capacidad de almacenamiento del dispositivo.
     * 
     * @return Capacidad de almacenamiento.
     */
    public String getAlmacenamiento() {
        return almacenamiento;
    }

    /**
     * Establece la capacidad de almacenamiento del dispositivo.
     * 
     * @param almacenamiento Capacidad de almacenamiento.
     */
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    /**
     * Obtiene la cantidad de memoria RAM.
     * 
     * @return Memoria RAM.
     */
    public String getRam() {
        return ram;
    }

    /**
     * Establece la cantidad de memoria RAM.
     * 
     * @param ram Memoria RAM.
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Obtiene la cantidad de cámaras del dispositivo.
     * 
     * @return Número de cámaras.
     */
    public int getCantidadCamaras() {
        return cantidadCamaras;
    }

    /**
     * Establece la cantidad de cámaras del dispositivo.
     * 
     * @param cantidadCamaras Número de cámaras.
     */
    public void setCantidadCamaras(int cantidadCamaras) {
        this.cantidadCamaras = cantidadCamaras;
    }

    /**
     * Indica si el dispositivo soporta Dual SIM.
     * 
     * @return {@code true} si soporta Dual SIM, {@code false} en caso contrario.
     */
    public boolean isDualSim() {
        return dualSim;
    }

    /**
     * Establece si el dispositivo soporta Dual SIM.
     * 
     * @param dualSim {@code true} si soporta Dual SIM, {@code false} en caso contrario.
     */
    public void setDualSim(boolean dualSim) {
        this.dualSim = dualSim;
    }

    /**
     * Crea una copia exacta del objeto actual.
     * 
     * @return Nueva instancia de {@code CelularDTO} con los mismos valores.
     */
    @Override
    public CelularDTO clone() {
        return new CelularDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getPulgadas(), getResolucion(), getSistemaOperativo(), getAlmacenamiento(),
                getRam(), getCantidadCamaras(), isDualSim());
    }

}
