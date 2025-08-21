package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.ComputadorDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("computadorBean")
@ViewScoped
public class FormComputadorBean implements Serializable {

	private String nombre;
    private String marca;
    private final String tipoProducto="Computador";
    private String descripcion;
    private String imagen="https://img.freepik.com/foto-gratis/jugador-alto-angulo-jugando-computadora-portatil_23-2149829167.jpg";
    private double precio;
    private int cantidad;
    private String id=UUID.randomUUID().toString();
    private double pulgadas;
    private String resolucion;
    private final String tipoProductoP="Portátil";
    private String sistemaOperativo;
    private String almacenamientoPc;
    private String ramPc;
    private String procesadorPc;
    private String graficaPc;
    
    private ArrayList<String>opcionesResolucion;
    private ArrayList<String>opcionesSistema;
    private ArrayList<String>opcionesAlmacenamiento;
    private ArrayList<String>opcionesRam;
    private ArrayList<String>opcionesProcesador;
    private ArrayList<String>opcionesTarjeta;
    @Inject
    private CrudService crudSer;
    
    @PostConstruct
    public void init() {
    	opcionesResolucion=new ArrayList<String>();
    	opcionesSistema= new ArrayList<String>();
    	opcionesAlmacenamiento= new ArrayList<String>();
    	opcionesRam= new ArrayList<String>();
    	opcionesProcesador= new ArrayList<String>();
    	opcionesTarjeta=new ArrayList<String>();
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
    	opcionesAlmacenamiento.add("128 GB");
    	opcionesAlmacenamiento.add("256 GB");
    	opcionesAlmacenamiento.add("512 GB");
    	opcionesAlmacenamiento.add("1 TB");
    	opcionesAlmacenamiento.add("2 TB");
    	opcionesAlmacenamiento.add("4 TB");
    	opcionesAlmacenamiento.add("8 TB");
    	opcionesAlmacenamiento.add("16 TB");
    	opcionesRam.add("4GB");
    	opcionesRam.add("8GB");
    	opcionesRam.add("16GB");
    	opcionesRam.add("32GB");
    	opcionesRam.add("64GB");
    	opcionesProcesador.add("INTEL I3");
    	opcionesProcesador.add("INTEL I5");
    	opcionesProcesador.add("INTEL I7");
    	opcionesProcesador.add("AMD RYZEN 5");
    	opcionesProcesador.add("AMD RYZEN 7");
    	opcionesTarjeta.add("INTEGRADA INTEL");
    	opcionesTarjeta.add("NVIDIA GTX 1650");
    	opcionesTarjeta.add("NVIDIA RTX 3050");
    	opcionesTarjeta.add("NVIDIA RTX 4060");
    	opcionesTarjeta.add("AMD RX 6600M");
    }
    
    public void guardar() {
    	System.out.println(toString());
    	crudSer.agregarProducto(new ComputadorDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, pulgadas, resolucion, sistemaOperativo, almacenamientoPc, ramPc, tipoProductoP, procesadorPc, graficaPc));
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
	public String getAlmacenamientoPc() {
		return almacenamientoPc;
	}
	public void setAlmacenamientoPc(String almacenamientoPc) {
		this.almacenamientoPc = almacenamientoPc;
	}
	public String getRamPc() {
		return ramPc;
	}
	public void setRamPc(String ramPc) {
		this.ramPc = ramPc;
	}
	public String getProcesadorPc() {
		return procesadorPc;
	}
	public void setProcesadorPc(String procesadorPc) {
		this.procesadorPc = procesadorPc;
	}
	public String getGraficaPc() {
		return graficaPc;
	}
	public void setGraficaPc(String graficaPc) {
		this.graficaPc = graficaPc;
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

	public ArrayList<String> getOpcionesProcesador() {
		return opcionesProcesador;
	}

	public void setOpcionesProcesador(ArrayList<String> opcionesProcesador) {
		this.opcionesProcesador = opcionesProcesador;
	}

	public ArrayList<String> getOpcionesTarjeta() {
		return opcionesTarjeta;
	}

	public void setOpcionesTarjeta(ArrayList<String> opcionesTarjeta) {
		this.opcionesTarjeta = opcionesTarjeta;
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

	public String getTipoProductoP() {
		return tipoProductoP;
	}

	@Override
	public String toString() {
		return "FomComputadorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", pulgadas=" + pulgadas + ", resolucion="
				+ resolucion + ", sistemaOperativo=" + sistemaOperativo + ", almacenamientoPc=" + almacenamientoPc
				+ ", ramPc=" + ramPc + ", procesadorPc=" + procesadorPc + ", graficaPc=" + graficaPc + "]";
	}
    
    
	
	
}
