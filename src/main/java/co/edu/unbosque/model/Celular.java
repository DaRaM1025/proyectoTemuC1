package co.edu.unbosque.model;

/**
 * Representa un dispositivo móvil de tipo celular, que hereda las
 * características básicas de {@link DispositivoElectronico} y añade
 * atributos específicos como almacenamiento, memoria RAM, cantidad de
 * cámaras y funcionalidad Dual SIM.
 * 
 * @author David Ramirez
 */
public class Celular extends DispositivoElectronico {

    /**
     * Capacidad de almacenamiento del celular (por ejemplo, 64GB, 128GB).
     */
    private String almacenamiento;

    /**
     * Cantidad de memoria RAM del celular (por ejemplo, 4GB, 8GB).
     */
    private String ram;

    /**
     * Número de cámaras que posee el celular.
     */
    private int cantidadCamaras;

    /**
     * Indica si el celular cuenta con la funcionalidad Dual SIM.
     */
    private boolean dualSim;

    /**
     * Constructor por defecto.
     */
    public Celular() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa todos los atributos heredados y específicos.
     * 
     * @param nombre           Nombre del producto.
     * @param marca            Marca del producto.
     * @param tipoProducto     Tipo de producto.
     * @param descripcion      Descripción del producto.
     * @param urlImagen        URL de la imagen representativa del producto.
     * @param precio           Precio del producto.
     * @param cantidad         Cantidad disponible en inventario.
     * @param id               Identificador único del producto.
     * @param almacenamiento   Capacidad de almacenamiento del celular.
     * @param ram              Memoria RAM del celular.
     * @param cantidadCamaras  Número de cámaras del celular.
     * @param dualSim          Indica si soporta Dual SIM.
     */
    public Celular(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String almacenamiento, String ram, int cantidadCamaras,
            boolean dualSim) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.cantidadCamaras = cantidadCamaras;
        this.dualSim = dualSim;
    }

    /**
     * Constructor que inicializa atributos relacionados con características físicas y técnicas.
     * 
     * @param pulgadas         Tamaño en pulgadas de la pantalla.
     * @param resolucion       Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del celular.
     * @param almacenamiento   Capacidad de almacenamiento.
     * @param ram              Memoria RAM.
     * @param cantidadCamaras  Número de cámaras.
     * @param dualSim          Indica si soporta Dual SIM.
     */
    public Celular(double pulgadas, String resolucion, String sistemaOperativo, String almacenamiento, String ram,
            int cantidadCamaras, boolean dualSim) {
        super(pulgadas, resolucion, sistemaOperativo);
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.cantidadCamaras = cantidadCamaras;
        this.dualSim = dualSim;
    }

    /**
     * Constructor que inicializa únicamente los atributos propios del celular.
     * 
     * @param almacenamiento   Capacidad de almacenamiento.
     * @param ram              Memoria RAM.
     * @param cantidadCamaras  Número de cámaras.
     * @param dualSim          Indica si soporta Dual SIM.
     */
    public Celular(String almacenamiento, String ram, int cantidadCamaras, boolean dualSim) {
        super();
        this.almacenamiento = almacenamiento;
        this.ram = ram;
        this.cantidadCamaras = cantidadCamaras;
        this.dualSim = dualSim;
    }

    /**
     * Constructor que inicializa atributos de pantalla y sistema operativo.
     * 
     * @param pulgadas         Tamaño de la pantalla en pulgadas.
     * @param resolucion       Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del celular.
     */
    public Celular(double pulgadas, String resolucion, String sistemaOperativo) {
        super(pulgadas, resolucion, sistemaOperativo);
    }

    /**
     * Constructor que inicializa atributos heredados y características físicas básicas.
     * 
     * @param nombre           Nombre del producto.
     * @param marca            Marca del producto.
     * @param tipoProducto     Tipo de producto.
     * @param descripcion      Descripción del producto.
     * @param urlImagen        URL de la imagen del producto.
     * @param precio           Precio del producto.
     * @param cantidad         Cantidad disponible.
     * @param id               Identificador único.
     * @param pulgadas         Tamaño en pulgadas.
     * @param resolucion       Resolución de la pantalla.
     * @param sistemaOperativo Sistema operativo del celular.
     */
    public Celular(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, double pulgadas, String resolucion, String sistemaOperativo) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, pulgadas, resolucion,
                sistemaOperativo);
    }

    /**
     * Constructor que inicializa los atributos básicos del producto.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo de producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único.
     */
    public Celular(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
    }

    /**
     * Constructor que inicializa todos los atributos, tanto heredados como específicos.
     * 
     * @param nombre           Nombre del producto.
     * @param marca            Marca del producto.
     * @param tipoProducto     Tipo de producto.
     * @param descripcion      Descripción del producto.
     * @param urlImagen        URL de la imagen del producto.
     * @param precio           Precio del producto.
     * @param cantidad         Cantidad disponible.
     * @param id               Identificador único.
     * @param pulgadas         Tamaño en pulgadas.
     * @param resolucion       Resolución de pantalla.
     * @param sistemaOperativo Sistema operativo del celular.
     * @param almacenamiento   Capacidad de almacenamiento.
     * @param ram              Memoria RAM.
     * @param cantidadCamaras  Número de cámaras.
     * @param dualSim          Indica si soporta Dual SIM.
     */
    public Celular(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
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
     * Obtiene la capacidad de almacenamiento del celular.
     * 
     * @return Almacenamiento del celular.
     */
    public String getAlmacenamiento() {
        return almacenamiento;
    }

    /**
     * Establece la capacidad de almacenamiento del celular.
     * 
     * @param almacenamiento Nueva capacidad de almacenamiento.
     */
    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    /**
     * Obtiene la memoria RAM del celular.
     * 
     * @return Memoria RAM.
     */
    public String getRam() {
        return ram;
    }

    /**
     * Establece la memoria RAM del celular.
     * 
     * @param ram Nueva memoria RAM.
     */
    public void setRam(String ram) {
        this.ram = ram;
    }

    /**
     * Obtiene la cantidad de cámaras del celular.
     * 
     * @return Número de cámaras.
     */
    public int getCantidadCamaras() {
        return cantidadCamaras;
    }

    /**
     * Establece la cantidad de cámaras del celular.
     * 
     * @param cantidadCamaras Nueva cantidad de cámaras.
     */
    public void setCantidadCamaras(int cantidadCamaras) {
        this.cantidadCamaras = cantidadCamaras;
    }

    /**
     * Indica si el celular soporta Dual SIM.
     * 
     * @return {@code true} si soporta Dual SIM, {@code false} en caso contrario.
     */
    public boolean isDualSim() {
        return dualSim;
    }

    /**
     * Establece si el celular soporta Dual SIM.
     * 
     * @param dualSim Valor booleano que indica la funcionalidad Dual SIM.
     */
    public void setDualSim(boolean dualSim) {
        this.dualSim = dualSim;
    }
}
