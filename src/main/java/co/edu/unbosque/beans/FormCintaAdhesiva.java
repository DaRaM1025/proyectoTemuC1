package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CintaAdhesivaDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@Named("cintaBean")
@ViewScoped
public class FormCintaAdhesiva implements Serializable{

	private String nombre;
	private String marca;
	private String tipoProducto="Cinta Adhesiva";
	private String descripcion;
	private String imagen="https://img.freepik.com/foto-gratis/arreglo-escritorio-alto-angulo-cinta-colores_23-2149009460.jpg";
	private double precio;
	private int cantidad;
	private String id=UUID.randomUUID().toString();
	private String presentacion;
	private boolean reposicionable;
    private double anchoCinta;
    private String tipoCinta;
    
    private ArrayList<String>opcionesPresentacion;
    private ArrayList<String>opcionesTipo;
    @Inject
    private CrudService crudSer;
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
    	crudSer.agregarProducto(new CintaAdhesivaDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, presentacion, reposicionable, anchoCinta, tipoCinta));
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
		return "FormCintaAdhesiva [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", reposicionable=" + reposicionable + ", anchoCinta=" + anchoCinta + ", tipoCinta=" + tipoCinta
				+ "]";
	}
    
    
	
}
