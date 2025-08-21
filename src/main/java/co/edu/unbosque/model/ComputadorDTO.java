package co.edu.unbosque.model;

/**
 * Representa un objeto Computador dentro del sistema.
 * Esta clase extiende {@link DispositivoElectronicoDTO} y añade atributos específicos 
 * para describir las características de un computador como almacenamiento, memoria RAM, 
 * procesador y tarjeta gráfica.
 * 
 * Se incluyen múltiples constructores para inicializar la instancia con diferentes niveles 
 * de detalle, así como métodos de acceso (getters y setters) para cada propiedad.
 * 
 * También se proporciona un método {@code clone()} para duplicar el objeto actual.
 * 
 * @author David Ramirez
 * @version 1.0
 */
public class ComputadorDTO extends DispositivoElectronicoDTO {
    
    /** Capacidad de almacenamiento del computador (por ejemplo, "512GB SSD"). */
    private String almacenamiento;
    
    /** Cantidad de memoria RAM del computador (por ejemplo, "16GB"). */
    private String ram;
    
    /** Modelo del procesador del computador (por ejemplo, "Intel Core i7"). */
    private String procesador;
    
    /** Modelo de la tarjeta gráfica del computador (por ejemplo, "NVIDIA GTX 1660"). */
    private String tarjetaGrafica;

    /**
     * Constructor por defecto.
     */
    public ComputadorDTO() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor con todos los atributos incluyendo los del dispositivo electrónico.
     * 
     * @param nombre Nombre del producto
     * @param marca Marca del computador
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del computador
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del computador
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param pulgadas Tamaño en pulgadas
     * @param resolucion Resolución de pantalla
     * @param sistemaOperativo Sistema operativo instalado
     * @param almacenamiento Capacidad de almacenamiento
     * @param ram Cantidad de memoria RAM
     * @param procesador Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
            String almacenamiento, String ram, String procesador, String tarjetaGrafica) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
                sistemaOperativo);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Constructor que incluye atributos principales y específicos del computador.
     * 
     * @param nombre Nombre del producto
     * @param marca Marca del computador
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del computador
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del computador
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param almacenamiento Capacidad de almacenamiento
     * @param ram Cantidad de memoria RAM
     * @param procesador Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String almacenamiento, String ram, String procesador,
            String tarjetaGrafica) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Constructor con detalles técnicos y características del computador.
     * 
     * @param pulgadas Tamaño en pulgadas
     * @param resolucion Resolución de pantalla
     * @param sistemaOperativo Sistema operativo instalado
     * @param almacenamiento Capacidad de almacenamiento
     * @param ram Cantidad de memoria RAM
     * @param procesador Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public ComputadorDTO(double pulgadas, String resolucion, String sistemaOperativo, String almacenamiento, String ram,
            String procesador, String tarjetaGrafica) {
        super(pulgadas, resolucion, sistemaOperativo);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Constructor que solo incluye los atributos propios del computador.
     * 
     * @param almacenamiento Capacidad de almacenamiento
     * @param ram Cantidad de memoria RAM
     * @param procesador Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public ComputadorDTO(String almacenamiento, String ram, String procesador, String tarjetaGrafica) {
        super();
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Constructor con detalles de pantalla y sistema operativo.
     * 
     * @param pulgadas Tamaño en pulgadas
     * @param resolucion Resolución de pantalla
     * @param sistemaOperativo Sistema operativo instalado
     */
    public ComputadorDTO(double pulgadas, String resolucion, String sistemaOperativo) {
        super(pulgadas, resolucion, sistemaOperativo);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa atributos del dispositivo sin los específicos del computador.
     * 
     * @param nombre Nombre del producto
     * @param marca Marca del computador
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del computador
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del computador
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param pulgadas Tamaño en pulgadas
     * @param resolucion Resolución de pantalla
     * @param sistemaOperativo Sistema operativo instalado
     */
    public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
                sistemaOperativo);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa el dispositivo sin detalles técnicos.
     * 
     * @param nombre Nombre del producto
     * @param marca Marca del computador
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del computador
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del computador
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     */
    public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que incluye todos los atributos, incluyendo algunos redundantes.
     * 
     * @param nombre Nombre del producto
     * @param marca Marca del computador
     * @param tipoProducto Tipo de producto
     * @param descripcion Descripción del computador
     * @param urlImagen URL de la imagen del producto
     * @param precio Precio del computador
     * @param cantidad Cantidad disponible
     * @param id Identificador único
     * @param pulgadas Tamaño en pulgadas
     * @param resolucion Resolución de pantalla
     * @param sistemaOperativo Sistema operativo instalado
     * @param almacenamiento Capacidad de almacenamiento
     * @param ram Cantidad de memoria RAM
     * @param tipo Tipo (no se utiliza actualmente)
     * @param procesador Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public ComputadorDTO(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo,
            String almacenamiento, String ram, String tipo, String procesador, String tarjetaGrafica) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
                sistemaOperativo);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Obtiene la capacidad de almacenamiento.
     * 
     * @return almacenamiento del computador
     */
    public String getAlmacenamiento() {
        return almacenamiento;
    }

    /**
     * Establece la capacidad de almacenamiento.
     * 
     * @param almacenamiento Nuevo valor de almacenamiento
     */
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    /**
     * Obtiene la cantidad de memoria RAM.
     * 
     * @return RAM del computador
     */
    public String getRam() {
        return ram;
    }

    /**
     * Establece la cantidad de memoria RAM.
     * 
     * @param ram Nuevo valor de RAM
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Obtiene el procesador.
     * 
     * @return procesador del computador
     */
    public String getProcesador() {
        return procesador;
    }

    /**
     * Establece el procesador.
     * 
     * @param procesador Nuevo valor del procesador
     */
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    /**
     * Obtiene la tarjeta gráfica.
     * 
     * @return tarjeta gráfica del computador
     */
    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    /**
     * Establece la tarjeta gráfica.
     * 
     * @param tarjetaGrafica Nuevo valor de la tarjeta gráfica
     */
    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Crea y devuelve una copia exacta del objeto ComputadorDTO.
     * 
     * @return una nueva instancia clonada de ComputadorDTO
     */
    @Override
    public ComputadorDTO clone() {
        return new ComputadorDTO(getNombre(), getMarca(), getTipoProducto(), getDescripcion(), getUrlImagen(), getPrecio(),
                getCantidad(), getId(), getPulgadas(), getResolucion(), getSistemaOperativo(), getAlmacenamiento(), getRam(), getProcesador(), getTarjetaGrafica());
    }

}
