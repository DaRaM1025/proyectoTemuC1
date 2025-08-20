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

@Named("televisorBean")
@ViewScoped
public class FormTelevisorBean implements Serializable{

	private String nombre;
    private String marca;
    private final String tipoProducto="Televisor";
    private String descripcion;
    private String imagen="https://img.freepik.com/foto-gratis/diseno-interior-habitacion_23-2148899490.jpg"; 
    private double precio;
    private int cantidad;
    private String id=UUID.randomUUID().toString();
    private double pulgadas;
    private String resolucion;
    private final String tipoProductoT="SmartTv";
    private String sistemaOperativo;
    private int puertosHdmi;
    private int frecuenciaHz;
    private String asistenteVirtual;

    private ArrayList<String>opcionesResolucion;
    private ArrayList<String>opcionesSistema;
    private ArrayList<String>opcionesAsistente;
    @Inject
    private CrudService crudSer;
    @PostConstruct
    
    public void init() {
    	opcionesResolucion=new ArrayList<String>();
    	opcionesSistema= new ArrayList<String>();
    	opcionesAsistente= new ArrayList<String>();
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
    
    public void guardar() {
    	System.out.println(toString());
    	crudSer.agregarProducto(new TelevisorDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, pulgadas, resolucion, sistemaOperativo, puertosHdmi, frecuenciaHz, asistenteVirtual));
    }
    
	@Override
	public String toString() {
		return "FormTelevisorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", pulgadas=" + pulgadas + ", resolucion="
				+ resolucion + ",sistemaOperativo: "+sistemaOperativo+", puertosHdmi=" + puertosHdmi + ", frecuenciaHz=" + frecuenciaHz + ", asistenteVirtual="
				+ asistenteVirtual + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public int getPuertosHdmi() {
		return puertosHdmi;
	}
	public void setPuertosHdmi(int puertosHdmi) {
		this.puertosHdmi = puertosHdmi;
	}
	public int getFrecuenciaHz() {
		return frecuenciaHz;
	}
	public void setFrecuenciaHz(int frecuenciaHz) {
		this.frecuenciaHz = frecuenciaHz;
	}
	public String getAsistenteVirtual() {
		return asistenteVirtual;
	}
	public void setAsistenteVirtual(String asistenteVirtual) {
		this.asistenteVirtual = asistenteVirtual;
	}

	public ArrayList<String> getOpcionesResolucion() {
		return opcionesResolucion;
	}

	public void setOpcionesResolucion(ArrayList<String> opcionesResolucion) {
		this.opcionesResolucion = opcionesResolucion;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	public ArrayList<String> getOpcionesSistema() {
		return opcionesSistema;
	}

	public void setOpcionesSistema(ArrayList<String> opcionesSistema) {
		this.opcionesSistema = opcionesSistema;
	}

	public ArrayList<String> getOpcionesAsistente() {
		return opcionesAsistente;
	}

	public void setOpcionesAsistente(ArrayList<String> opcionesAsistente) {
		this.opcionesAsistente = opcionesAsistente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CrudService getCrudSer() {
		return crudSer;
	}

	public void setCrudSer(CrudService crudSer) {
		this.crudSer = crudSer;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public String getTipoProductoT() {
		return tipoProductoT;
	}
    
	
   
	
}
