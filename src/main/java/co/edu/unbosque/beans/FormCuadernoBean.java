package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("cuadernoBean")
@ViewScoped
public class FormCuadernoBean implements Serializable {

	private String nombre;
	private String marca;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
	private String presentacion;
	private String tipoHoja;
	private int cantidadHojas;
	private boolean pastaDura;
	private ArrayList<String> opcionesPresentacion;
	private ArrayList<String> opcionesHojas;
	 @PostConstruct
	public void init() {
		opcionesPresentacion = new ArrayList<String>();
		opcionesHojas = new ArrayList<String>();
		opcionesPresentacion.add("Unidad");
		opcionesPresentacion.add("Paquete/Blister");
		opcionesPresentacion.add("Caja");
		opcionesPresentacion.add("Rollo");
		opcionesPresentacion.add("Kit");
		opcionesHojas.add("Cuadriculadas");
		opcionesHojas.add("Rayadas");
		opcionesHojas.add("Punteadas");
		opcionesHojas.add("Blancas");
		opcionesHojas.add("Doble Reglón");
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

	public String getTipoHoja() {
		return tipoHoja;
	}

	public void setTipoHoja(String tipoHoja) {
		this.tipoHoja = tipoHoja;
	}

	public int getCantidadHojas() {
		return cantidadHojas;
	}

	public void setCantidadHojas(int cantidadHojas) {
		this.cantidadHojas = cantidadHojas;
	}

	public boolean isPastaDura() {
		return pastaDura;
	}

	public void setPastaDura(boolean pastaDura) {
		this.pastaDura = pastaDura;
	}

	
	public ArrayList<String> getOpcionesPresentacion() {
		return opcionesPresentacion;
	}

	public void setOpcionesPresentacion(ArrayList<String> opcionesPresentacion) {
		this.opcionesPresentacion = opcionesPresentacion;
	}

	public ArrayList<String> getOpcionesHojas() {
		return opcionesHojas;
	}

	public void setOpcionesHojas(ArrayList<String> opcionesHojas) {
		this.opcionesHojas = opcionesHojas;
	}

	@Override
	public String toString() {
		return "FormCuadernoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", tipoHoja=" + tipoHoja + ", cantidadHojas=" + cantidadHojas + ", pastaDura=" + pastaDura + "]";
	}

}
