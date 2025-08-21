package co.edu.unbosque.model;

/**
 * Representa un producto de maquillaje del tipo Corrector.
 * Hereda las propiedades de {@link Maquillaje} e incluye atributos específicos como
 * cobertura y formato.
 * 
 * Esta clase permite modelar diferentes correctores con información detallada
 * sobre su presentación y características.
 * 
 * @author David Ramirez
 */
public class Corrector extends Maquillaje {

    /**
     * Tipo de cobertura del corrector (ej. ligera, media, alta).
     */
    private String cobertura;

    /**
     * Formato del corrector (ej. líquido, barra, crema).
     */
    private String formato;

    /**
     * Constructor por defecto.
     */
    public Corrector() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa los atributos heredados de {@link Maquillaje} y
     * los específicos de la clase Corrector.
     * 
     * @param tipoPiel        Tipo de piel para la que está diseñado el corrector.
     * @param esApruebaDeAgua Indica si es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento del producto.
     * @param cobertura        Tipo de cobertura (ligera, media, alta).
     * @param formato          Formato del corrector (líquido, barra, crema).
     */
    public Corrector(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento, String cobertura,
            String formato) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Constructor que inicializa atributos generales del producto y los específicos
     * del corrector.
     * 
     * @param nombre     Nombre del producto.
     * @param marca      Marca del producto.
     * @param tipoProducto Tipo del producto.
     * @param descripcion Descripción del producto.
     * @param urlImagen   URL de la imagen del producto.
     * @param precio      Precio del producto.
     * @param cantidad    Cantidad disponible.
     * @param id          Identificador único del producto.
     * @param cobertura   Tipo de cobertura.
     * @param formato     Formato del corrector.
     */
    public Corrector(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String cobertura, String formato) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Constructor que inicializa solo los atributos específicos del corrector.
     * 
     * @param cobertura Tipo de cobertura.
     * @param formato   Formato del corrector.
     */
    public Corrector(String cobertura, String formato) {
        super();
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Constructor que inicializa atributos heredados relacionados con el maquillaje.
     * 
     * @param tipoPiel        Tipo de piel.
     * @param esApruebaDeAgua Indica si es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento.
     */
    public Corrector(String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(tipoPiel, esApruebaDeAgua, fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa atributos generales del producto y datos heredados
     * del maquillaje.
     * 
     * @param nombre          Nombre del producto.
     * @param marca           Marca del producto.
     * @param tipoProducto    Tipo del producto.
     * @param descripcion     Descripción del producto.
     * @param urlImagen       URL de la imagen.
     * @param precio          Precio del producto.
     * @param cantidad        Cantidad disponible.
     * @param id              Identificador único.
     * @param tipoPiel        Tipo de piel.
     * @param esApruebaDeAgua Indica si es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento.
     */
    public Corrector(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa solo los atributos generales del producto.
     * 
     * @param nombre       Nombre del producto.
     * @param marca        Marca del producto.
     * @param tipoProducto Tipo del producto.
     * @param descripcion  Descripción del producto.
     * @param urlImagen    URL de la imagen.
     * @param precio       Precio del producto.
     * @param cantidad     Cantidad disponible.
     * @param id           Identificador único.
     */
    public Corrector(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor completo que inicializa atributos generales, heredados y específicos.
     * 
     * @param nombre          Nombre del producto.
     * @param marca           Marca del producto.
     * @param tipoProducto    Tipo del producto.
     * @param descripcion     Descripción del producto.
     * @param urlImagen       URL de la imagen.
     * @param precio          Precio del producto.
     * @param cantidad        Cantidad disponible.
     * @param id              Identificador único.
     * @param tipoPiel        Tipo de piel.
     * @param esApruebaDeAgua Indica si es a prueba de agua.
     * @param fechaVencimiento Fecha de vencimiento.
     * @param cobertura       Tipo de cobertura.
     * @param formato         Formato del corrector.
     */
    public Corrector(String nombre, String marca, String tipoProducto, String descripcion, String urlImagen,
            double precio, int cantidad, String id, String tipoPiel, boolean esApruebaDeAgua, String fechaVencimiento,
            String cobertura, String formato) {
        super(nombre, marca, tipoProducto, descripcion, urlImagen, precio, cantidad, id, tipoPiel, esApruebaDeAgua,
                fechaVencimiento);
        this.cobertura = cobertura;
        this.formato = formato;
    }

    /**
     * Obtiene el tipo de cobertura del corrector.
     * 
     * @return cobertura del corrector.
     */
    public String getCobertura() {
        return cobertura;
    }

    /**
     * Establece el tipo de cobertura del corrector.
     * 
     * @param cobertura Tipo de cobertura.
     */
    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    /**
     * Obtiene el formato del corrector.
     * 
     * @return formato del corrector.
     */
    public String getFormato() {
        return formato;
    }

    /**
     * Establece el formato del corrector.
     * 
     * @param formato Formato del corrector.
     */
    public void setFormato(String formato) {
        this.formato = formato;
    }

}
