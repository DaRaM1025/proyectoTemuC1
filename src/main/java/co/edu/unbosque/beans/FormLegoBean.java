package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.LegoDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@Named(value="legoBean")
@ViewScoped
public class FormLegoBean implements Serializable{

	 private String nombre;
	    private String marca;
	    private String tipoProducto="Lego";
	    private String descripcion;
	    private String imagen="https://img.freepik.com/foto-gratis/conjunto-eccano-plastico_1398-2177.jpg"; 
	    private double precio;
	    private int cantidad;
	    private String id=UUID.randomUUID().toString();
	    private int edadRecomendada;
	    private String temaLego;
	    private int piezasLego;
	    private boolean minifiguras;
		private ArrayList<String> opcionesTema;
		@Inject
	    private CrudService crudSer;
		@PostConstruct
		public void init() {
			opcionesTema = new ArrayList<>();
			opcionesTema.add("Ciudad");
			opcionesTema.add("Amigos");
			opcionesTema.add("Star Wars");
			opcionesTema.add("Ninjago");
			opcionesTema.add("Harry Potter");
			opcionesTema.add("Técnicos(mecánica)");
			opcionesTema.add("Construcciones libres");
			opcionesTema.add("Super héroes");
			opcionesTema.add("Arquitectura");
			opcionesTema.add("Jurassic World");
		}
	    public void guardar() {
	    	System.out.println(toString());
	    	crudSer.agregarProducto(new LegoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, edadRecomendada, temaLego, piezasLego, minifiguras));
	    }
	    
		public ArrayList<String> getOpcionesTema() {
			return opcionesTema;
		}

		public void setOpcionesTema(ArrayList<String> opcionesTema) {
			this.opcionesTema = opcionesTema;
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
		public String getTemaLego() {
			return temaLego;
		}
		public void setTemaLego(String temaLego) {
			this.temaLego = temaLego;
		}
		public int getPiezasLego() {
			return piezasLego;
		}
		public void setPiezasLego(int piezasLego) {
			this.piezasLego = piezasLego;
		}
		public boolean isMinifiguras() {
			return minifiguras;
		}
		public void setMinifiguras(boolean minifiguras) {
			this.minifiguras = minifiguras;
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
			return "FormLegoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
					+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", edadRecomendada=" + edadRecomendada
					+ ", temaLego=" + temaLego + ", piezasLego=" + piezasLego + ", minifiguras=" + minifiguras + "]";
		}
	    
}
