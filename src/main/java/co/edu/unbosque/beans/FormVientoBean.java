package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoVientoDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Administra el formulario para crear y manejar datos de productos de tipo instrumento de viento.
 * Proporciona funcionalidad para inicializar las opciones de tipo de instrumento y afinación,
 * y para guardar los datos del instrumento usando el servicio CrudService.
 * @author David Santiago Ramirez Arevalo
 */
@Named("vientoBean")
@ViewScoped
public class FormVientoBean implements Serializable {

    private String nombre;
    private String marca;
    private String tipoProducto = "Instrumento de Viento";
    private String descripcion;
    private String imagen = "https://img.freepik.com/foto-gratis/trompeta-manos_23-2147624318.jpg";
    private double precio;
    private int cantidad;
    private String id = UUID.randomUUID().toString();
    private boolean incluyeEstuche;
    private String tipoInstrumentoViento;
    private String afinacion;
    private int numValvulas;
    private boolean boquillas;

    private ArrayList<String> opcionesInstrumento;
    private ArrayList<String> opcionesAfinacion;
    @Inject
    private CrudService crudSer;

    /**
     * Inicializa las listas de opciones para tipo de instrumento y afinación.
     */
    @PostConstruct
    public void init() {
        opcionesInstrumento = new ArrayList<String>();
        opcionesAfinacion = new ArrayList<String>();
        opcionesInstrumento.add("Corno Fránces");
        opcionesInstrumento.add("Corneta");
        opcionesInstrumento.add("Clarinete");
        opcionesInstrumento.add("Fagot");
        opcionesInstrumento.add("Flauta");
        opcionesInstrumento.add("Oboe");
        opcionesInstrumento.add("Tuba");
        opcionesInstrumento.add("Trombón");
        opcionesInstrumento.add("Trompeta");
        opcionesInstrumento.add("Saxofón");
        opcionesAfinacion.add("Do (C)");
        opcionesAfinacion.add("Re (D)");
        opcionesAfinacion.add("Mi♭ (Eb)");
        opcionesAfinacion.add("Fa (F)");
        opcionesAfinacion.add("Sol (G)");
        opcionesAfinacion.add("Si♭ (Bb)");
    }

    /**
     * Guarda los datos del instrumento de viento en el servicio CrudService e imprime los detalles del objeto en la consola.
     */
    public void guardar() {
        System.out.println(toString());
        crudSer.agregarProducto(new InstrumentoVientoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, incluyeEstuche, tipoInstrumentoViento, afinacion, numValvulas, boquillas));
    }

    /**
     * Obtiene la marca del instrumento.
     * @return La marca del instrumento
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del instrumento.
     * @param marca La marca a establecer
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la descripción del instrumento.
     * @return La descripción del instrumento
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del instrumento.
     * @param descripcion La descripción a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la URL de la imagen del instrumento.
     * @return La URL de la imagen del instrumento
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la URL de la imagen del instrumento.
     * @param imagen La URL de la imagen a establecer
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el precio del instrumento.
     * @return El precio del instrumento
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del instrumento.
     * @param precio El precio a establecer
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad de instrumentos.
     * @return La cantidad de instrumentos
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de instrumentos.
     * @param cantidad La cantidad a establecer
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Verifica si el instrumento incluye estuche.
     * @return true si incluye estuche, false en caso contrario
     */
    public boolean isIncluyeEstuche() {
        return incluyeEstuche;
    }

    /**
     * Establece si el instrumento incluye estuche.
     * @param incluyeEstuche true si incluye estuche, false en caso contrario
     */
    public void setIncluyeEstuche(boolean incluyeEstuche) {
        this.incluyeEstuche = incluyeEstuche;
    }

    /**
     * Obtiene el tipo de instrumento de viento.
     * @return El tipo de instrumento de viento
     */
    public String getTipoInstrumentoViento() {
        return tipoInstrumentoViento;
    }

    /**
     * Establece el tipo de instrumento de viento.
     * @param tipoInstrumentoViento El tipo de instrumento a establecer
     */
    public void setTipoInstrumentoViento(String tipoInstrumentoViento) {
        this.tipoInstrumentoViento = tipoInstrumentoViento;
    }

    /**
     * Obtiene la afinación del instrumento.
     * @return La afinación del instrumento
     */
    public String getAfinacion() {
        return afinacion;
    }

    /**
     * Establece la afinación del instrumento.
     * @param afinacion La afinación a establecer
     */
    public void setAfinacion(String afinacion) {
        this.afinacion = afinacion;
    }

    /**
     * Obtiene el número de válvulas del instrumento.
     * @return El número de válvulas
     */
    public int getNumValvulas() {
        return numValvulas;
    }

    /**
     * Establece el número de válvulas del instrumento.
     * @param numValvulas El número de válvulas a establecer
     */
    public void setNumValvulas(int numValvulas) {
        this.numValvulas = numValvulas;
    }

    /**
     * Verifica si el instrumento incluye boquillas.
     * @return true si incluye boquillas, false en caso contrario
     */
    public boolean isBoquillas() {
        return boquillas;
    }

    /**
     * Establece si el instrumento incluye boquillas.
     * @param boquillas true si incluye boquillas, false en caso contrario
     */
    public void setBoquillas(boolean boquillas) {
        this.boquillas = boquillas;
    }

    /**
     * Obtiene el nombre del instrumento.
     * @return El nombre del instrumento
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del instrumento.
     * @param nombre El nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de opciones de tipos de instrumentos disponibles.
     * @return La lista de opciones de tipos de instrumentos
     */
    public ArrayList<String> getOpcionesInstrumento() {
        return opcionesInstrumento;
    }

    /**
     * Establece la lista de opciones de tipos de instrumentos disponibles.
     * @param opcionesInstrumento La lista de opciones de tipos de instrumentos a establecer
     */
    public void setOpcionesInstrumento(ArrayList<String> opcionesInstrumento) {
        this.opcionesInstrumento = opcionesInstrumento;
    }

    /**
     * Obtiene la lista de opciones de afinaciones disponibles.
     * @return La lista de opciones de afinaciones
     */
    public ArrayList<String> getOpcionesAfinacion() {
        return opcionesAfinacion;
    }

    /**
     * Establece la lista de opciones de afinaciones disponibles.
     * @param opcionesAfinacion La lista de opciones de afinaciones a establecer
     */
    public void setOpcionesAfinacion(ArrayList<String> opcionesAfinacion) {
        this.opcionesAfinacion = opcionesAfinacion;
    }

    /**
     * Obtiene el tipo de producto del instrumento.
     * @return El tipo de producto
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Establece el tipo de producto del instrumento.
     * @param tipoProducto El tipo de producto a establecer
     */
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    /**
     * Obtiene el identificador único del instrumento.
     * @return El identificador único
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del instrumento.
     * @param id El identificador único a establecer
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la instancia del servicio CrudService utilizada para gestionar los datos del instrumento.
     * @return La instancia del servicio CrudService
     */
    public CrudService getCrudSer() {
        return crudSer;
    }

    /**
     * Establece la instancia del servicio CrudService utilizada para gestionar los datos del instrumento.
     * @param crudSer La instancia del servicio CrudService a establecer
     */
    public void setCrudSer(CrudService crudSer) {
        this.crudSer = crudSer;
    }

    /**
     * Devuelve una representación en cadena del objeto FormVientoBean.
     * @return Una cadena con los valores de los campos del objeto
     */
    @Override
    public String toString() {
        return "FormVientoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
                + imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", incluyeEstuche=" + incluyeEstuche
                + ", tipoInstrumentoViento=" + tipoInstrumentoViento + ", afinacion=" + afinacion + ", numValvulas="
                + numValvulas + ", boquillas=" + boquillas + "]";
    }
}