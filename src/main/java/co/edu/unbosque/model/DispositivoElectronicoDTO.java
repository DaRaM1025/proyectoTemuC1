package co.edu.unbosque.model;

/**
 * Representa un dispositivo electrónico como un tipo específico de {@link ProductoDTO}.
 * Contiene información adicional como pulgadas, resolución y sistema operativo.
 * 
 * <p>Esta clase se utiliza como un DTO (Data Transfer Object) para transportar datos
 * entre las capas del sistema.</p>
 * 
 * @author David Ramirez
 */
public class DispositivoElectronicoDTO extends ProductoDTO {

    /** Tamaño del dispositivo en pulgadas. */
    protected double pulgadas;

    /** Resolución de la pantalla del dispositivo. */
    protected String resolucion;

    /** Sistema operativo del dispositivo. */
    protected String sistemaOperativo;

    /**
     * Constructor por defecto.
     */
    public DispositivoElectronicoDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa las propiedades específicas del dispositivo.
     *
     * @param pulgadas Tamaño en pulgadas.
     * @param resolucion Resolución del dispositivo.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     */
    public DispositivoElectronicoDTO(double pulgadas, String resolucion, String sistemaOperativo) {
        super();
        this.pulgadas = pulgadas;
        this.resolucion = resolucion;
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Constructor que inicializa las propiedades heredadas de {@link ProductoDTO}.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     */
    public DispositivoElectronicoDTO(String nombre, String marca, String tipoProducto, String descripcion,
            String urlImagen, double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todas las propiedades, incluyendo las específicas
     * del dispositivo electrónico.
     *
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen URL de la imagen del producto.
     * @param precio Precio del producto.
     * @param cantidad Cantidad disponible.
     * @param id Identificador único del producto.
     * @param pulgadas Tamaño en pulgadas.
     * @param resolucion Resolución del dispositivo.
     * @param sistemaOperativo Sistema operativo del dispositivo.
     */
    public DispositivoElectronicoDTO(String nombre, String marca, String tipoProducto, String descripcion,
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
     * @param resolucion Resolución del dispositivo.
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
     * @param sistemaOperativo Sistema operativo del dispositivo.
     */
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
}
