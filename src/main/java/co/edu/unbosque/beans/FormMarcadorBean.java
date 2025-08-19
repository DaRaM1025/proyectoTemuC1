package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("marcadorBean")
@ViewScoped
public class FormMarcadorBean implements Serializable {

	private String nombre;
    private String marca;
    private String descripcion;
    private String imagen; 
    private double precio;
    private int cantidad;
    private String presentacion;
    private String tipoPunta;
    private boolean permanente;
    private String tipoMarcador;
    private ArrayList<String>opcionesPresentacion;
    private ArrayList<String>opcionesPunta;
    private ArrayList<String>opcionesTipo;
    @PostConstruct
    public void init() {
    opcionesPresentacion= new ArrayList<String>();
    opcionesPunta= new ArrayList<String>();
    opcionesTipo= new ArrayList<String>();
    opcionesPresentacion.add("Unidad");
    opcionesPresentacion.add("Paquete/Blister");
    opcionesPresentacion.add("Caja");
    opcionesPresentacion.add("Rollo");
    opcionesPresentacion.add("Kit");
    opcionesPunta.add("Redonda");
    opcionesPunta.add("Cónica");
    opcionesPunta.add("Plana");
    opcionesPunta.add("Fina");
    opcionesPunta.add("Pincel");
    opcionesTipo.add("Permanente");
    opcionesTipo.add("Textil");
    opcionesTipo.add("Resaltador");
    opcionesTipo.add("Borrable");
    opcionesTipo.add("Acuarelable");
    	
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
	public String getTipoPunta() {
		return tipoPunta;
	}
	public void setTipoPunta(String tipoPunta) {
		this.tipoPunta = tipoPunta;
	}
	public boolean isPermanente() {
		return permanente;
	}
	public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}
	public String getTipoMarcador() {
		return tipoMarcador;
	}
	public void setTipoMarcador(String tipoMarcador) {
		this.tipoMarcador = tipoMarcador;
	}
	@Override
	public String toString() {
		return "FormMarcadorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", tipoPunta=" + tipoPunta + ", permanente=" + permanente + ", tipoMarcador=" + tipoMarcador + "]";
	}

	public ArrayList<String> getOpcionesPresentacion() {
		return opcionesPresentacion;
	}

	public void setOpcionesPresentacion(ArrayList<String> opcionesPresentacion) {
		this.opcionesPresentacion = opcionesPresentacion;
	}

	public ArrayList<String> getOpcionesPunta() {
		return opcionesPunta;
	}

	public void setOpcionesPunta(ArrayList<String> opcionesPunta) {
		this.opcionesPunta = opcionesPunta;
	}

	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	public void setOpcionesTipo(ArrayList<String> opcionesTipo) {
		this.opcionesTipo = opcionesTipo;
	}
    
    
    
	
}
