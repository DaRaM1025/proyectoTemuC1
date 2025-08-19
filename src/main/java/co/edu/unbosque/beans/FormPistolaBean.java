package co.edu.unbosque.beans;

import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
@Named(value="pistolaBean")
@ViewScoped
public class FormPistolaBean implements Serializable {

	 private String nombre;
	    private String marca;
	    private String descripcion;
	    private String imagen; 
	    private double precio;
	    private int cantidad;
	    private int edadRecomendada;
	    private int capacidadAgua;
	    private int cantidadChorros;
	    private double alcanceChorro;
	    
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
		public int getEdadRecomendada() {
			return edadRecomendada;
		}
		public void setEdadRecomendada(int edadRecomendada) {
			this.edadRecomendada = edadRecomendada;
		}
		public int getCapacidadAgua() {
			return capacidadAgua;
		}
		public void setCapacidadAgua(int capacidadAgua) {
			this.capacidadAgua = capacidadAgua;
		}
		public int getCantidadChorros() {
			return cantidadChorros;
		}
		public void setCantidadChorros(int cantidadChorros) {
			this.cantidadChorros = cantidadChorros;
		}
		public double getAlcanceChorro() {
			return alcanceChorro;
		}
		public void setAlcanceChorro(double alcanceChorro) {
			this.alcanceChorro = alcanceChorro;
		}

		@Override
		public String toString() {
			return "FormPistolaBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion
					+ ", imagen=" + imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", edadRecomendada="
					+ edadRecomendada + ", capacidadAgua=" + capacidadAgua + ", cantidadChorros=" + cantidadChorros
					+ ", alcanceChorro=" + alcanceChorro + "]";
		}
	    
		
}
