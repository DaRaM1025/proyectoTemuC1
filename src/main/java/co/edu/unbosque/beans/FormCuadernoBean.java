/**
 * Clase que representa el bean de la vista para la gestión de productos de cuaderno
 * Permite registrar y gestionar los atributos de un producto de cuaderno
 * @author Nataly Vanessa Rengifo Bautista
 */
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

/**
 * Bean de vista para la gestión de formularios de cuaderno
 */
@Named("cuadernoBean")
@ViewScoped
public class FormCuadernoBean implements Serializable {

	/**
	 * Nombre del producto de cuaderno
	 */
	private String nombre;

	/**
	 * Marca del producto de cuaderno
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Cuaderno"
	 */
	private String tipoProducto="Cuaderno";

	/**
	 * Descripción del producto de cuaderno
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de cuaderno
	 */
	private String imagen="https://img.freepik.com/foto-gratis/concepto-adorable-flores-libreta-hojas_23-2148007116.jpg";

	/**
	 * Precio del producto de cuaderno
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de cuaderno
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de cuaderno
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Presentación del producto de cuaderno
	 */
	private String presentacion;

	/**
	 * Tipo de hoja del cuaderno
	 */
	private String tipoHoja;

	/**
	 * Cantidad de hojas del cuaderno
	 */
	private int cantidadHojas;

	/**
	 * Indica si el cuaderno tiene pasta dura
	 */
	private boolean pastaDura;

	/**
	 * Lista de opciones de presentación para el cuaderno
	 */
	private ArrayList<String> opcionesPresentacion;

	/**
	 * Lista de opciones de tipo de hoja para el cuaderno
	 */
	private ArrayList<String> opcionesHojas;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para presentación y tipo de hoja del cuaderno
	 */
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

	/**
	 * Guarda un nuevo producto de cuaderno utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new CuadernoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, presentacion, tipoHoja, cantidadHojas, pastaDura));
	}

	/**
	 * Obtiene el nombre del producto de cuaderno
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de cuaderno
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de cuaderno
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de cuaderno
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de cuaderno
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de cuaderno
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de cuaderno
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de cuaderno
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de cuaderno
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de cuaderno
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de cuaderno
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de cuaderno
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la presentación del producto de cuaderno
	 * @return La presentación del producto
	 */
	public String getPresentacion() {
		return presentacion;
	}

	/**
	 * Establece la presentación del producto de cuaderno
	 * @param presentacion La presentación del producto
	 */
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	/**
	 * Obtiene el tipo de hoja del cuaderno
	 * @return El tipo de hoja
	 */
	public String getTipoHoja() {
		return tipoHoja;
	}

	/**
	 * Establece el tipo de hoja del cuaderno
	 * @param tipoHoja El tipo de hoja
	 */
	public void setTipoHoja(String tipoHoja) {
		this.tipoHoja = tipoHoja;
	}

	/**
	 * Obtiene la cantidad de hojas del cuaderno
	 * @return La cantidad de hojas
	 */
	public int getCantidadHojas() {
		return cantidadHojas;
	}

	/**
	 * Establece la cantidad de hojas del cuaderno
	 * @param cantidadHojas La cantidad de hojas
	 */
	public void setCantidadHojas(int cantidadHojas) {
		this.cantidadHojas = cantidadHojas;
	}

	/**
	 * Indica si el cuaderno tiene pasta dura
	 * @return Verdadero si tiene pasta dura, falso en caso contrario
	 */
	public boolean isPastaDura() {
		return pastaDura;
	}

	/**
	 * Establece si el cuaderno tiene pasta dura
	 * @param pastaDura Verdadero si tiene pasta dura, falso en caso contrario
	 */
	public void setPastaDura(boolean pastaDura) {
		this.pastaDura = pastaDura;
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
	 * Obtiene la lista de opciones de tipo de hoja
	 * @return La lista de opciones de tipo de hoja
	 */
	public ArrayList<String> getOpcionesHojas() {
		return opcionesHojas;
	}

	/**
	 * Establece la lista de opciones de tipo de hoja
	 * @param opcionesHojas La lista de opciones de tipo de hoja
	 */
	public void setOpcionesHojas(ArrayList<String> opcionesHojas) {
		this.opcionesHojas = opcionesHojas;
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
	 * Representación en cadena del objeto FormCuadernoBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormCuadernoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", tipoHoja=" + tipoHoja + ", cantidadHojas=" + cantidadHojas + ", pastaDura=" + pastaDura + "]";
	}
}