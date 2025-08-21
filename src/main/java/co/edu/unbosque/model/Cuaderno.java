package co.edu.unbosque.model;

/**
 * Representa un cuaderno dentro de la categoría de papelería.
 * Contiene información sobre el tipo de hojas, la cantidad y si es pasta dura.
 * 
 * @author David Ramirez
 */
public class Cuaderno extends Papeleria {
    
    private String tipoHojas; // Posible uso de enum
    private int cantidadHojas;
    private boolean isPastaDura;

    /**
     * Constructor vacío.
     */
    public Cuaderno() {
        // Constructor por defecto
    }

    /**
     * Constructor con todos los atributos específicos del cuaderno.
     *
     * @param nombre Nombre del producto
     * @param marca Marca del producto
     * @param tipoProducto Tipo del producto
     * @param descripcion Descripción del producto
     * @param urlImagen URL de la imagen
     * @param precio Precio del producto
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param tipoHojas Tipo de hojas (cuadriculadas, rayadas, etc.)
     * @param cantidadHojas Número de hojas
     * @param isPastaDura Indica si el cuaderno es de pasta dura
     */
    public Cuaderno(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                    double precio, int cantidad, String id, String tipoHojas, int cantidadHojas, boolean isPastaDura) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    /**
     * Constructor con tipo de presentación heredado y detalles del cuaderno.
     *
     * @param tipoPresentacion Tipo de presentación
     * @param tipoHojas Tipo de hojas
     * @param cantidadHojas Número de hojas
     * @param isPastaDura Si el cuaderno es pasta dura
     */
    public Cuaderno(String tipoPresentacion, String tipoHojas, int cantidadHojas, boolean isPastaDura) {
        super(tipoPresentacion);
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    /**
     * Constructor reducido solo con propiedades del cuaderno.
     *
     * @param tipoHojas Tipo de hojas
     * @param cantidadHojas Número de hojas
     * @param isPastaDura Si el cuaderno es pasta dura
     */
    public Cuaderno(String tipoHojas, int cantidadHojas, boolean isPastaDura) {
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    /**
     * Constructor completo con presentación.
     */
    public Cuaderno(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                    double precio, int cantidad, String id, String tipoPresentacion, String tipoHojas,
                    int cantidadHojas, boolean isPastaDura) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPresentacion);
        this.tipoHojas = tipoHojas;
        this.cantidadHojas = cantidadHojas;
        this.isPastaDura = isPastaDura;
    }

    // Getters y Setters
    public String getTipoHojas() {
        return tipoHojas;
    }

    public void setTipoHojas(String tipoHojas) {
        this.tipoHojas = tipoHojas;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
    }

    public boolean isPastaDura() {
        return isPastaDura;
    }

    public void setPastaDura(boolean isPastaDura) {
        this.isPastaDura = isPastaDura;
    }
}
