package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CuadernoDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("cuadernoBean")
@ViewScoped
public class FormCuadernoBean implements Serializable {

	private String nombre;
	private String marca;
	private String tipoProducto="Cuaderno";
	private String descripcion;
	private String imagen="https://img.freepik.com/foto-gratis/concepto-adorable-flores-libreta-hojas_23-2148007116.jpg";
	private double precio;
	private int cantidad;
	private String id=UUID.randomUUID().toString();
	private String presentacion;
	private String tipoHoja;
	private int cantidadHojas;
	private boolean pastaDura;
	private ArrayList<String> opcionesPresentacion;
	private ArrayList<String> opcionesHojas;
	 @Inject
	    private CrudService crudSer;
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
		crudSer.agregarProducto(new CuadernoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, presentacion, tipoHoja, cantidadHojas, pastaDura));
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
		return "FormCuadernoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", tipoHoja=" + tipoHoja + ", cantidadHojas=" + cantidadHojas + ", pastaDura=" + pastaDura + "]";
	}

}
