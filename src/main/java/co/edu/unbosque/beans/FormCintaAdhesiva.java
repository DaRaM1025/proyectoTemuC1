/**
 * Clase que representa el bean de la vista para la gestión de productos de cinta adhesiva
 * Permite registrar y gestionar los atributos de un producto de cinta adhesiva
 * @author Nataly Vanessa Rengifo Bautista
 */
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

/**
 * Bean de vista para la gestión de formularios de cinta adhesiva
 */
@Named("cintaBean")
@ViewScoped
public class FormCintaAdhesiva implements Serializable {

	/**
	 * Nombre del producto de cinta adhesiva
	 */
	private String nombre;

	/**
	 * Marca del producto de cinta adhesiva
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Cinta Adhesiva"
	 */
	private String tipoProducto="Cinta Adhesiva";

	/**
	 * Descripción del producto de cinta adhesiva
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de cinta adhesiva
	 */
	private String imagen="https://img.freepik.com/foto-gratis/arreglo-escritorio-alto-angulo-cinta-colores_23-2149009460.jpg";

	/**
	 * Precio del producto de cinta adhesiva
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de cinta adhesiva
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de cinta adhesiva
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Presentación del producto de cinta adhesiva
	 */
	private String presentacion;

	/**
	 * Indica si la cinta adhesiva es reposicionable
	 */
	private boolean reposicionable;

	/**
	 * Ancho de la cinta adhesiva
	 */
	private double anchoCinta;

	/**
	 * Tipo de cinta adhesiva
	 */
	private String tipoCinta;

	/**
	 * Lista de opciones de presentación para la cinta adhesiva
	 */
	private ArrayList<String> opcionesPresentacion;

	/**
	 * Lista de opciones de tipo de cinta adhesiva
	 */
	private ArrayList<String> opcionesTipo;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para presentación y tipo de cinta adhesiva
	 */
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

	/**
	 * Guarda un nuevo producto de cinta adhesiva utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new CintaAdhesivaDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, presentacion, reposicionable, anchoCinta, tipoCinta));
	}

	/**
	 * Obtiene el nombre del producto de cinta adhesiva
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de cinta adhesiva
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de cinta adhesiva
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de cinta adhesiva
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de cinta adhesiva
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de cinta adhesiva
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de cinta adhesiva
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de cinta adhesiva
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de cinta adhesiva
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de cinta adhesiva
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de cinta adhesiva
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de cinta adhesiva
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la presentación del producto de cinta adhesiva
	 * @return La presentación del producto
	 */
	public String getPresentacion() {
		return presentacion;
	}

	/**
	 * Establece la presentación del producto de cinta adhesiva
	 * @param presentacion La presentación del producto
	 */
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	/**
	 * Indica si la cinta adhesiva es reposicionable
	 * @return Verdadero si la cinta es reposicionable, falso en caso contrario
	 */
	public boolean isReposicionable() {
		return reposicionable;
	}

	/**
	 * Establece si la cinta adhesiva es reposicionable
	 * @param reposicionable Verdadero si la cinta es reposicionable, falso en caso contrario
	 */
	public void setReposicionable(boolean reposicionable) {
		this.reposicionable = reposicionable;
	}

	/**
	 * Obtiene el ancho de la cinta adhesiva
	 * @return El ancho de la cinta
	 */
	public double getAnchoCinta() {
		return anchoCinta;
	}

	/**
	 * Establece el ancho de la cinta adhesiva
	 * @param anchoCinta El ancho de la cinta
	 */
	public void setAnchoCinta(double anchoCinta) {
		this.anchoCinta = anchoCinta;
	}

	/**
	 * Obtiene el tipo de cinta adhesiva
	 * @return El tipo de cinta
	 */
	public String getTipoCinta() {
		return tipoCinta;
	}

	/**
	 * Establece el tipo de cinta adhesiva
	 * @param tipoCinta El tipo de cinta
	 */
	public void setTipoCinta(String tipoCinta) {
		this.tipoCinta = tipoCinta;
	}

	/**
	 * Obtiene la lista de opciones de presentación
	 * @return La lista de opciones de presentación
	 */
	public ArrayList<String> getOpcionesPresentacion() {
		return opcionesPresentacion;
	}

	/**
	 * Establece la lista de opciones de presentación
	 * @param opcionesPresentacion La lista de opciones de presentación
	 */
	public void setOpcionesPresentacion(ArrayList<String> opcionesPresentacion) {
		this.opcionesPresentacion = opcionesPresentacion;
	}

	/**
	 * Obtiene la lista de opciones de tipo de cinta
	 * @return La lista de opciones de tipo
	 */
	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	/**
	 * Establece la lista de opciones de tipo de cinta
	 * @param opcionesTipo La lista de opciones de tipo
	 */
	public void setOpcionesTipo(ArrayList<String> opcionesTipo) {
		this.opcionesTipo = opcionesTipo;
	}

	/**
	 * Obtiene el tipo de producto
	 * @return El tipo de producto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * Establece el tipo de producto
	 * @param tipoProducto El tipo de producto
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	/**
	 * Obtiene el identificador único del producto
	 * @return El identificador único
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador único del producto
	 * @param id El identificador único
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el servicio CRUD
	 * @return El servicio CRUD
	 */
	public CrudService getCrudSer() {
		return crudSer;
	}

	/**
	 * Establece el servicio CRUD
	 * @param crudSer El servicio CRUD
	 */
	public void setCrudSer(CrudService crudSer) {
		this.crudSer = crudSer;
	}

	/**
	 * Representación en cadena del objeto FormCintaAdhesiva
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormCintaAdhesiva [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", reposicionable=" + reposicionable + ", anchoCinta=" + anchoCinta + ", tipoCinta=" + tipoCinta
				+ "]";
	}
}