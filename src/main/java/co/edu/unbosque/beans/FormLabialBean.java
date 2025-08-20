package co.edu.unbosque.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
@Named("labialBean")
@ViewScoped
public class FormLabialBean implements Serializable{

	private String nombre;
    private String marca;
    private String descripcion;
    private String imagen; 
    private double precio;
    private int cantidad;
    private String tipoPiel;
    private boolean pruebaAgua;
    private LocalDate fechaVencimiento;
    private String duracionLabial;
    private boolean hidratante;
    private ArrayList<String>opcionesPiel;
    private ArrayList<String>opcionesDuracion;
   @PostConstruct
    public void init() {
    	opcionesPiel=new ArrayList<String>();
    	opcionesPiel.add("Grasa");
    	opcionesPiel.add("Seca ");
    	opcionesPiel.add("Mixta");
    	opcionesDuracion= new ArrayList<String>();
    	opcionesDuracion.add("Corta (1 a 2 horas)");
    	opcionesDuracion.add("Media (3 a 5 horas)");
    	opcionesDuracion.add("Larga (6 a 8 horas)");
    	opcionesDuracion.add("Ultra (24 horas)");
    	opcionesDuracion.add("No transfer");
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
	public String getTipoPiel() {
		return tipoPiel;
	}
	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}
	public boolean isPruebaAgua() {
		return pruebaAgua;
	}
	public void setPruebaAgua(boolean pruebaAgua) {
		this.pruebaAgua = pruebaAgua;
	}
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getDuracionLabial() {
		return duracionLabial;
	}
	public void setDuracionLabial(String duracionLabial) {
		this.duracionLabial = duracionLabial;
	}
	public boolean isHidratante() {
		return hidratante;
	}
	public void setHidratante(boolean hidratante) {
		this.hidratante = hidratante;
	}
		
	public ArrayList<String> getOpcionesPiel() {
		return opcionesPiel;
	}

	public void setOpcionesPiel(ArrayList<String> opcionesPiel) {
		this.opcionesPiel = opcionesPiel;
	}

	public ArrayList<String> getOpcionesDuracion() {
		return opcionesDuracion;
	}

	public void setOpcionesDuracion(ArrayList<String> opcionesDuracion) {
		this.opcionesDuracion = opcionesDuracion;
	}

	@Override
	public String toString() {
		return "FormLabialBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", tipoPiel=" + tipoPiel + ", pruebaAgua="
				+ pruebaAgua + ", fechaVencimiento=" + fechaVencimiento + ", duracionLabial=" + duracionLabial
				+ ", hidratante=" + hidratante + "]";
	}
    
    
    
}
