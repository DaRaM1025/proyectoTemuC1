package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.UUID;

import co.edu.unbosque.model.PistolaAguaDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@Named(value="pistolaBean")
@ViewScoped
public class FormPistolaBean implements Serializable {

	 private String nombre;
	    private String marca;
	    private String tipoProducto="Pistola de Agua";
	    private String descripcion;
	    private String imagen="https://img.freepik.com/foto-gratis/hermosa-presentacion-arte-unas_23-2149295395.jpg"; 
	    private double precio;
	    private int cantidad;
	    private String id=UUID.randomUUID().toString();
	    private int edadRecomendada;
	    private int capacidadAgua;
	    private int cantidadChorros;
	    private double alcanceChorro;
	    
	    @Inject
	    private CrudService crudSer;
	    
	    public void guardar() {
	    	System.out.println(toString());
	    	crudSer.agregarProducto(new PistolaAguaDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, edadRecomendada, capacidadAgua, cantidadChorros, alcanceChorro));
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

		public String getTipoProducto() {
			return tipoProducto;
		}

		public void setTipoProducto(String tipoProducto) {
			this.tipoProducto = tipoProducto;
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

		@Override
		public String toString() {
			return "FormPistolaBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion
					+ ", imagen=" + imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", edadRecomendada="
					+ edadRecomendada + ", capacidadAgua=" + capacidadAgua + ", cantidadChorros=" + cantidadChorros
					+ ", alcanceChorro=" + alcanceChorro + "]";
		}
	    
		
}
