package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.TelevisorDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Administra el formulario para crear y manejar datos de productos de tipo televisor.
 * Proporciona funcionalidad para inicializar las opciones de resolución, sistema operativo
 * y asistente virtual, y para guardar los datos del televisor usando el servicio CrudService.
 * @author David Santiago Ramirez Arevalo
 */
@Named("televisorBean")
@ViewScoped
public class FormTelevisorBean implements Serializable {

    private String nombre;
    private String marca;
    private final String tipoProducto = "Televisor";
    private String descripcion;
    private String imagen = "https://img.freepik.com/foto-gratis/diseno-interior-habitacion_23-2148899490.jpg";
    private double precio;
    private int cantidad;
    private String id = UUID.randomUUID().toString();
    private double pulgadas;
    private String resolucion;
    private final String tipoProductoT = "SmartTv";
    private String sistemaOperativo;
    private int puertosHdmi;
    private int frecuenciaHz;
    private String asistenteVirtual;

    private ArrayList<String> opcionesResolucion;
    private ArrayList<String> opcionesSistema;
    private ArrayList<String> opcionesAsistente;
    @Inject
    private CrudService crudSer;

    /**
     * Inicializa las listas de opciones para resolución, sistema operativo y asistente virtual.
     */
    @PostConstruct
    public void init() {
        opcionesResolucion = new ArrayList<String>();
        opcionesSistema = new ArrayList<String>();
        opcionesAsistente = new ArrayList<String>();
        opcionesResolucion.add("HD (1280x720)");
        opcionesResolucion.add("Full HD (1920x1080)");
        opcionesResolucion.add("2K/QHD (2560x1440)");
        opcionesResolucion.add("4K UHD (3840x2160)");
        opcionesResolucion.add("8K UHD (7680x4320)");
        opcionesSistema.add("Android");
        opcionesSistema.add("iOS");
        opcionesSistema.add("HarmonyOS");
        opcionesSistema.add("KaiOS");
        opcionesSistema.add("Windows");
        opcionesSistema.add("macOS");
        opcionesSistema.add("Linux");
        opcionesSistema.add("ChromeOS");
        opcionesSistema.add("AndroidTV");
        opcionesSistema.add("webOS");
        opcionesSistema.add("Tyzen");
        opcionesSistema.add("FireOS");
        opcionesAsistente.add("Google Assistant");
        opcionesAsistente.add("Apple Sir");
        opcionesAsistente.add("Amazon Alexa");
        opcionesAsistente.add("Bixby");
        opcionesAsistente.add("Cortana");
        opcionesAsistente.add("LG Thinq");
        opcionesAsistente.add("Xiaomi XiaoAI");
        opcionesAsistente.add("Ninguno");
    }

    /**
     * Guarda los datos del televisor en el servicio CrudService e imprime los detalles del objeto en la consola.
     */
    public void guardar() {
        System.out.println(toString());
        crudSer.agregarProducto(new TelevisorDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, pulgadas, resolucion, sistemaOperativo, puertosHdmi, frecuenciaHz, asistenteVirtual));
    }

    /**
     * Devuelve una representación en cadena del objeto FormTelevisorBean.
     * @return Una cadena con los valores de los campos del objeto
     */
    @Override
    public String toString() {
        return "FormTelevisorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
                + imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", pulgadas=" + pulgadas + ", resolucion="
                + resolucion + ",sistemaOperativo: " + sistemaOperativo + ", puertosHdmi=" + puertosHdmi + ", frecuenciaHz=" + frecuenciaHz + ", asistenteVirtual="
                + asistenteVirtual + "]";
    }

    /**
     * Obtiene el nombre del televisor.
     * @return El nombre del televisor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del televisor.
     * @param nombre El nombre a establecer
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca del televisor.
     * @return La marca del televisor
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del televisor.
     * @param marca La marca a establecer
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la descripción del televisor.
     * @return La descripción del televisor
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del televisor.
     * @param descripcion La descripción a establecer
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la URL de la imagen del televisor.
     * @return La URL de la imagen del televisor
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece la URL de la imagen del televisor.
     * @param imagen La URL de la imagen a establecer
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el precio del televisor.
     * @return El precio del televisor
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del televisor.
     * @param precio El precio a establecer
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad de televisores.
     * @return La cantidad de televisores
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de televisores.
     * @param cantidad La cantidad a establecer
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el tamaño del televisor en pulgadas.
     * @return El tamaño del televisor en pulgadas
     */
    public double getPulgadas() {
        return pulgadas;
    }

    /**
     * Establece el tamaño del televisor en pulgadas.
     * @param pulgadas El tamaño a establecer en pulgadas
     */
    public void setPulgadas(double pulgadas) {
        this.pulgadas = pulgadas;
    }

    /**
     * Obtiene la resolución del televisor.
     * @return La resolución del televisor
     */
    public String getResolucion() {
        return resolucion;
    }

    /**
     * Establece la resolución del televisor.
     * @param resolucion La resolución a establecer
     */
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    /**
     * Obtiene el número de puertos HDMI del televisor.
     * @return El número de puertos HDMI
     */
    public int getPuertosHdmi() {
        return puertosHdmi;
    }

    /**
     * Establece el número de puertos HDMI del televisor.
     * @param puertosHdmi El número de puertos HDMI a establecer
     */
    public void setPuertosHdmi(int puertosHdmi) {
        this.puertosHdmi = puertosHdmi;
    }

    /**
     * Obtiene la frecuencia de actualización del televisor en Hertz.
     * @return La frecuencia de actualización en Hertz
     */
    public int getFrecuenciaHz() {
        return frecuenciaHz;
    }

    /**
     * Establece la frecuencia de actualización del televisor en Hertz.
     * @param frecuenciaHz La frecuencia de actualización a establecer
     */
    public void setFrecuenciaHz(int frecuenciaHz) {
        this.frecuenciaHz = frecuenciaHz;
    }

    /**
     * Obtiene el asistente virtual del televisor.
     * @return El asistente virtual del televisor
     */
    public String getAsistenteVirtual() {
        return asistenteVirtual;
    }

    /**
     * Establece el asistente virtual del televisor.
     * @param asistenteVirtual El asistente virtual a establecer
     */
    public void setAsistenteVirtual(String asistenteVirtual) {
        this.asistenteVirtual = asistenteVirtual;
    }

    /**
     * Obtiene la lista de opciones de resolución disponibles.
     * @return La lista de opciones de resolución
     */
    public ArrayList<String> getOpcionesResolucion() {
        return opcionesResolucion;
    }

    /**
     * Establece la lista de opciones de resolución disponibles.
     * @param opcionesResolucion La lista de opciones de resolución a establecer
     */
    public void setOpcionesResolucion(ArrayList<String> opcionesResolucion) {
        this.opcionesResolucion = opcionesResolucion;
    }

    /**
     * Obtiene el sistema operativo del televisor.
     * @return El sistema operativo del televisor
     */
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    /**
     * Establece el sistema operativo del televisor.
     * @param sistemaOperativo El sistema operativo a establecer
     */
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    /**
     * Obtiene la lista de opciones de sistemas operativos disponibles.
     * @return La lista de opciones de sistemas operativos
     */
    public ArrayList<String> getOpcionesSistema() {
        return opcionesSistema;
    }

    /**
     * Establece la lista de opciones de sistemas operativos disponibles.
     * @param opcionesSistema La lista de opciones de sistemas operativos a establecer
     */
    public void setOpcionesSistema(ArrayList<String> opcionesSistema) {
        this.opcionesSistema = opcionesSistema;
    }

    /**
     * Obtiene la lista de opciones de asistentes virtuales disponibles.
     * @return La lista de opciones de asistentes virtuales
     */
    public ArrayList<String> getOpcionesAsistente() {
        return opcionesAsistente;
    }

    /**
     * Establece la lista de opciones de asistentes virtuales disponibles.
     * @param opcionesAsistente La lista de opciones de asistentes virtuales a establecer
     */
    public void setOpcionesAsistente(ArrayList<String> opcionesAsistente) {
        this.opcionesAsistente = opcionesAsistente;
    }

    /**
     * Obtiene el identificador único del televisor.
     * @return El identificador único
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del televisor.
     * @param id El identificador único a establecer
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la instancia del servicio CrudService utilizada para gestionar los datos del televisor.
     * @return La instancia del servicio CrudService
     */
    public CrudService getCrudSer() {
        return crudSer;
    }

    /**
     * Establece la instancia del servicio CrudService utilizada para gestionar los datos del televisor.
     * @param crudSer La instancia del servicio CrudService a establecer
     */
    public void setCrudSer(CrudService crudSer) {
        this.crudSer = crudSer;
    }

    /**
     * Obtiene el tipo de producto del televisor.
     * @return El tipo de producto
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Obtiene el tipo de producto específico para Smart TVs.
     * @return El tipo de producto específico
     */
    public String getTipoProductoT() {
        return tipoProductoT;
    }
}