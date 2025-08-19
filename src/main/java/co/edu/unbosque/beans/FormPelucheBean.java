package co.edu.unbosque.beans;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named(value="pelucheBean")
@ViewScoped
public class FormPelucheBean implements Serializable {

	private String nombre;
	private String marca;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
	private int edadRecomendada;
	private boolean sonidoPeluche;
	private String rellenoPeluche;
	private boolean lavable;

	private ArrayList<String> opcionesRelleno;

	public FormPelucheBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		opcionesRelleno = new ArrayList<>();
		opcionesRelleno.add("Algodón sintético");
		opcionesRelleno.add("Espuma");
		opcionesRelleno.add("Microperlas");
		opcionesRelleno.add("Algodón Natural");
		opcionesRelleno.add("Bolitas térmicas");
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

	public boolean isSonidoPeluche() {
		return sonidoPeluche;
	}

	public void setSonidoPeluche(boolean sonidoPeluche) {
		this.sonidoPeluche = sonidoPeluche;
	}

	public String getRellenoPeluche() {
		return rellenoPeluche;
	}

	public void setRellenoPeluche(String rellenoPeluche) {
		this.rellenoPeluche = rellenoPeluche;
	}

	public boolean isLavable() {
		return lavable;
	}

	public void setLavable(boolean lavable) {
		this.lavable = lavable;
	}

	public ArrayList<String> getOpcionesRelleno() {
		return opcionesRelleno;
	}

	public void setOpcionesRelleno(ArrayList<String> opcionesRelleno) {
		this.opcionesRelleno = opcionesRelleno;
	}

	public void guardar() {
		System.out.println("Peluche guardado: " +"Nombre: " + nombre +" Marca: "+ marca +" Descrip: "+ descripcion + "Imagen: " + imagen +" precio: " + precio + "Cantidad " +cantidad
				+ "Edad Recomendad:" + edadRecomendada +"donido: "+ sonidoPeluche +" relleno: "+ rellenoPeluche + "lavar"  +  lavable);
		
	}

//Metodo que limpie los campos del form sin guardar nada
	public String cancelar() {

		return null;
	}

}
