package co.edu.unbosque.model;

/**
 * Representa un computador, que es un tipo de dispositivo electrónico con
 * características específicas como almacenamiento, memoria RAM, procesador y
 * tarjeta gráfica.
 * 
 * Esta clase hereda de {@link DispositivoElectronico} y añade atributos
 * relacionados con el hardware del computador.
 * 
 * @author David Ramirez
 */
public class Computador extends DispositivoElectronico {

    /**
     * Almacenamiento del computador (ej. 512GB SSD).
     */
    private String almacenamiento;

    /**
     * Memoria RAM del computador (ej. 16GB).
     */
    private String ram;

    /**
     * Procesador del computador (ej. Intel i7, AMD Ryzen 5).
     */
    private String procesador;

    /**
     * Tarjeta gráfica del computador (ej. NVIDIA RTX 3060).
     */
    private String tarjetaGrafica;

    /**
     * Constructor vacío.
     */
    public Computador() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos, incluyendo los de la clase
     * padre.
     * 
     * @param nombre          Nombre del producto
     * @param marca           Marca del producto
     * @param tipoProducto    Tipo de producto
     * @param descripcion     Descripción del producto
     * @param urlImagen       URL de la imagen del producto
     * @param precio          Precio del producto
     * @param cantidad        Cantidad disponible
     * @param id              Identificador del producto
     * @param pulgadas        Tamaño en pulgadas
     * @param resolucion      Resolución del dispositivo
     * @param sistemaOperativo Sistema operativo instalado
     * @param almacenamiento  Almacenamiento del computador
     * @param ram             Memoria RAM
     * @param procesador      Procesador
     * @param tarjetaGrafica  Tarjeta gráfica
     */
    public Computador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
     * Constructor que inicializa atributos básicos y los específicos del
     * computador.
     * 
     * @param nombre         Nombre del producto
     * @param marca          Marca
     * @param tipoProducto   Tipo de producto
     * @param descripcion    Descripción
     * @param urlImagen      URL de la imagen
     * @param precio         Precio
     * @param cantidad       Cantidad
     * @param id             Identificador
     * @param almacenamiento Almacenamiento
     * @param ram            Memoria RAM
     * @param procesador     Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public Computador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String almacenamiento, String ram, String procesador,
            String tarjetaGrafica) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Constructor que inicializa características del dispositivo y atributos
     * específicos del computador.
     * 
     * @param pulgadas       Tamaño en pulgadas
     * @param resolucion     Resolución
     * @param sistemaOperativo Sistema operativo
     * @param almacenamiento Almacenamiento
     * @param ram            Memoria RAM
     * @param procesador     Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public Computador(double pulgadas, String resolucion, String sistemaOperativo, String almacenamiento, String ram,
            String procesador, String tarjetaGrafica) {
        super(pulgadas, resolucion, sistemaOperativo);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Constructor que inicializa solo los atributos propios del computador.
     * 
     * @param almacenamiento Almacenamiento
     * @param ram            Memoria RAM
     * @param procesador     Procesador
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public Computador(String almacenamiento, String ram, String procesador, String tarjetaGrafica) {
        super();
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    /**
     * Constructor que inicializa las características básicas del dispositivo.
     * 
     * @param pulgadas       Tamaño en pulgadas
     * @param resolucion     Resolución
     * @param sistemaOperativo Sistema operativo
     */
    public Computador(double pulgadas, String resolucion, String sistemaOperativo) {
        super(pulgadas, resolucion, sistemaOperativo);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos del dispositivo.
     * 
     * @param nombre          Nombre
     * @param marca           Marca
     * @param tipoProducto    Tipo de producto
     * @param descripcion     Descripción
     * @param urlImagen       URL de la imagen
     * @param precio          Precio
     * @param cantidad        Cantidad
     * @param id              Identificador
     * @param pulgadas        Tamaño en pulgadas
     * @param resolucion      Resolución
     * @param sistemaOperativo Sistema operativo
     */
    public Computador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
                sistemaOperativo);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor básico que inicializa los atributos principales del producto.
     * 
     * @param nombre       Nombre
     * @param marca        Marca
     * @param tipoProducto Tipo de producto
     * @param descripcion  Descripción
     * @param urlImagen    URL de la imagen
     * @param precio       Precio
     * @param cantidad     Cantidad
     * @param id           Identificador
     */
    public Computador(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Obtiene el almacenamiento del computador.
     * 
     * @return Almacenamiento
     */
    public String getAlmacenamiento() {
        return almacenamiento;
    }

    /**
     * Establece el almacenamiento del computador.
     * 
     * @param almacenamiento Almacenamiento
     */
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    /**
     * Obtiene la memoria RAM del computador.
     * 
     * @return RAM
     */
    public String getRam() {
        return ram;
    }

    /**
     * Establece la memoria RAM del computador.
     * 
     * @param ram Memoria RAM
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Obtiene el procesador del computador.
     * 
     * @return Procesador
     */
    public String getProcesador() {
        return procesador;
    }

    /**
     * Establece el procesador del computador.
     * 
     * @param procesador Procesador
     */
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    /**
     * Obtiene la tarjeta gráfica del computador.
     * 
     * @return Tarjeta gráfica
     */
    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    /**
     * Establece la tarjeta gráfica del computador.
     * 
     * @param tarjetaGrafica Tarjeta gráfica
     */
    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }
}
