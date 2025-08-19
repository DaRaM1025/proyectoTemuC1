package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
@Named("cintaBean")
@ViewScoped
public class FormCintaAdhesiva implements Serializable{

	private String nombre;
	private String marca;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
	private String presentacion;
	private boolean reposicionable;
    private double anchoCinta;
    private String tipoCinta;
    
    private ArrayList<String>opcionesPresentacion;
    private ArrayList<String>opcionesTipo;
    @PostConstruct
    public void init() {
    	opcionesPresentacion= new ArrayList<String>();
    	opcionesTipo= new ArrayList<String>();
    	opcionesPresentacion.add("Unidad");
        opcionesPresentacion.add("Paquete/Blister");
        opcionesPresentacion.add("Caja");
        opcionesPresentacion.add("Rollo");
        opcionesPresentacion.add("Kit");
        opcionesTipo.add("Cinta Transparente");
        opcionesTipo.add("Cinta de Embalaje");
        opcionesTipo.add("Cinta Doble Faz");
        opcionesTipo.add("Cinta Térmica");
        opcionesTipo.add("Cinta de Enmascarar");
    	
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
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public boolean isReposicionable() {
		return reposicionable;
	}
	public void setReposicionable(boolean reposicionable) {
		this.reposicionable = reposicionable;
	}
	public double getAnchoCinta() {
		return anchoCinta;
	}
	public void setAnchoCinta(double anchoCinta) {
		this.anchoCinta = anchoCinta;
	}
	public String getTipoCinta() {
		return tipoCinta;
	}
	public void setTipoCinta(String tipoCinta) {
		this.tipoCinta = tipoCinta;
	}
	
	
	public ArrayList<String> getOpcionesPresentacion() {
		return opcionesPresentacion;
	}

	public void setOpcionesPresentacion(ArrayList<String> opcionesPresentacion) {
		this.opcionesPresentacion = opcionesPresentacion;
	}

	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	public void setOpcionesTipo(ArrayList<String> opcionesTipo) {
		this.opcionesTipo = opcionesTipo;
	}

	@Override
	public String toString() {
		return "FormCintaAdhesiva [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", reposicionable=" + reposicionable + ", anchoCinta=" + anchoCinta + ", tipoCinta=" + tipoCinta
				+ "]";
	}
    
    
	
}
