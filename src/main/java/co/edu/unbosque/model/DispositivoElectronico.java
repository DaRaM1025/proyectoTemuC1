package co.edu.unbosque.model;

/**
 * Representa un dispositivo electrónico que extiende de {@link Producto}.  
 * Incluye atributos específicos como tamaño en pulgadas, resolución y sistema operativo.  
 * 
 * Esta clase permite gestionar productos electrónicos dentro del inventario, ofreciendo  
 * información adicional que no aplica a otros tipos de productos.  
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class DispositivoElectronico extends Producto {

    /**
     * Tamaño de la pantalla del dispositivo en pulgadas.
     */
    protected double pulgadas;

    /**
     * Resolución de la pantalla del dispositivo.
     */
    protected String resolucion;

    /**
     * Sistema operativo del dispositivo electrónico.
     */
    protected String sistemaOperativo;

    /**
     * Constructor por defecto.
     */
    public DispositivoElectronico() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos específicos del dispositivo electrónico.
     *
     * @param pulgadas Tamaño en pulgadas.
     * @param resolucion Resolución del dispositivo.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     */
    public DispositivoElectronico(double pulgadas, String resolucion, String sistemaOperativo) {
        super();
        this.pulgadas = pulgadas;
        this.resolucion = resolucion;
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Constructor que inicializa los atributos heredados de {@link Producto}.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible en inventario.
     * @param id Identificador único del producto.
     */
    public DispositivoElectronico(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
                                   double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos, incluyendo los específicos del dispositivo electrónico.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único.
     * @param pulgadas Tamaño de la pantalla en pulgadas.
     * @param resolucion Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     */
    public DispositivoElectronico(String nombre, String marca, String tipoProducto, String descripcion,
                                   String urlImagen, double precio, int cantidad, String id, double pulgadas, String resolucion,
                                   String sistemaOperativo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.pulgadas = pulgadas;
        this.resolucion = resolucion;
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Obtiene el tamaño en pulgadas del dispositivo.
     *
     * @return Tamaño en pulgadas.
     */
    public double getPulgadas() {
        return pulgadas;
    }

    /**
     * Establece el tamaño en pulgadas del dispositivo.
     *
     * @param pulgadas Tamaño en pulgadas.
     */
    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    /**
     * Obtiene la resolución del dispositivo.
     *
     * @return Resolución del dispositivo.
     */
    public String getResolucion() {
        return resolucion;
    }

    /**
     * Establece la resolución del dispositivo.
     *
     * @param resolucion Resolución a establecer.
     */
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    /**
     * Obtiene el sistema operativo del dispositivo.
     *
     * @return Sistema operativo del dispositivo.
     */
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    /**
     * Establece el sistema operativo del dispositivo.
     *
     * @param sistemaOperativo Sistema operativo a establecer.
     */
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
}
