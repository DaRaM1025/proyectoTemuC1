package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
@Named("celularBean")
@ViewScoped
public class FormCelularBean implements Serializable{

	private String nombre;
    private String marca;
    private String descripcion;
    private String imagen; 
    private double precio;
    private int cantidad;
    private double pulgadas;
    private String resolucion;
    private String sistemaOperativo;
    private String almacenamientoCel;
    private String ramCel;
    private int camaras;
    private boolean dualSim;
    private ArrayList<String>opcionesResolucion;
    private ArrayList<String>opcionesSistema;
    private ArrayList<String>opcionesAlmacenamiento;
    private ArrayList<String>opcionesRam;
    @PostConstruct
    public void init() {
    	opcionesResolucion=new ArrayList<String>();
    	opcionesSistema= new ArrayList<String>();
    	opcionesAlmacenamiento= new ArrayList<String>();
    	opcionesRam= new ArrayList<String>();
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
    	opcionesAlmacenamiento.add("64 GB");
    	opcionesAlmacenamiento.add("128 GB");
    	opcionesAlmacenamiento.add("256 GB");
    	opcionesAlmacenamiento.add("512 GB");
    	opcionesAlmacenamiento.add("1 TB");
    	opcionesRam.add("4 GB");
    	opcionesRam.add("6 GB");
    	opcionesRam.add("8 GB");
    	opcionesRam.add("12 GB");
    	opcionesRam.add("16 GB");
    }
    
    public void guardar() {
    	System.out.println(toString());
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
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	public String getAlmacenamientoCel() {
		return almacenamientoCel;
	}
	public void setAlmacenamientoCel(String almacenamientoCel) {
		this.almacenamientoCel = almacenamientoCel;
	}
	public String getRamCel() {
		return ramCel;
	}
	public void setRamCel(String ramCel) {
		this.ramCel = ramCel;
	}
	public int getCamaras() {
		return camaras;
	}
	public void setCamaras(int camaras) {
		this.camaras = camaras;
	}
	public boolean isDualSim() {
		return dualSim;
	}
	public void setDualSim(boolean dualSim) {
		this.dualSim = dualSim;
	}
	
	public ArrayList<String> getOpcionesResolucion() {
		return opcionesResolucion;
	}

	public void setOpcionesResolucion(ArrayList<String> opcionesResolucion) {
		this.opcionesResolucion = opcionesResolucion;
	}

	public ArrayList<String> getOpcionesSistema() {
		return opcionesSistema;
	}

	public void setOpcionesSistema(ArrayList<String> opcionesSistema) {
		this.opcionesSistema = opcionesSistema;
	}

	public ArrayList<String> getOpcionesAlmacenamiento() {
		return opcionesAlmacenamiento;
	}

	public void setOpcionesAlmacenamiento(ArrayList<String> opcionesAlmacenamiento) {
		this.opcionesAlmacenamiento = opcionesAlmacenamiento;
	}

	public ArrayList<String> getOpcionesRam() {
		return opcionesRam;
	}

	public void setOpcionesRam(ArrayList<String> opcionesRam) {
		this.opcionesRam = opcionesRam;
	}

	@Override
	public String toString() {
		return "FormCelularBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", pulgadas=" + pulgadas + ", resolucion="
				+ resolucion + ", sistemaOperativo=" + sistemaOperativo + ", almacenamientoCel=" + almacenamientoCel
				+ ", ramCel=" + ramCel + ", camaras=" + camaras + ", dualSim=" + dualSim + "]";
	}
    
    
	
}
