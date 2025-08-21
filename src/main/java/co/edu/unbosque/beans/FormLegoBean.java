/**
 * Clase que representa el bean de la vista para la gestión de productos de Lego
 * Permite registrar y gestionar los atributos de un producto de Lego
 * @author Nataly Vanessa Rengifo Bautista
 */
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

/**
 * Bean de vista para la gestión de formularios de Lego
 */
@Named(value="legoBean")
@ViewScoped
public class FormLegoBean implements Serializable {

	/**
	 * Nombre del producto de Lego
	 */
	private String nombre;

	/**
	 * Marca del producto de Lego
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Lego"
	 */
	private String tipoProducto="Lego";

	/**
	 * Descripción del producto de Lego
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de Lego
	 */
	private String imagen="https://img.freepik.com/foto-gratis/conjunto-eccano-plastico_1398-2177.jpg";

	/**
	 * Precio del producto de Lego
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de Lego
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de Lego
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Edad recomendada para el producto de Lego
	 */
	private int edadRecomendada;

	/**
	 * Tema del set de Lego
	 */
	private String temaLego;

	/**
	 * Número de piezas del set de Lego
	 */
	private int piezasLego;

	/**
	 * Indica si el set de Lego incluye minifiguras
	 */
	private boolean minifiguras;

	/**
	 * Lista de opciones de temas de Lego
	 */
	private ArrayList<String> opcionesTema;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa la lista de opciones para temas de Lego
	 */
	@PostConstruct
	public void init() {
		opcionesTema = new ArrayList<>();
		opcionesTema.add("Ciudad");
		opcionesTema.add("Amigos");
		opcionesTema.add("Star Wars");
		opcionesTema.add("Ninjago");
		opcionesTema.add("Harry Potter");
		opcionesTema.add("Técnicos (mecánica)");
		opcionesTema.add("Construcciones libres");
		opcionesTema.add("Super héroes");
		opcionesTema.add("Arquitectura");
		opcionesTema.add("Jurassic World");
	}

	/**
	 * Guarda un nuevo producto de Lego utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new LegoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, edadRecomendada, temaLego, piezasLego, minifiguras));
	}

	/**
	 * Obtiene el nombre del producto de Lego
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de Lego
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de Lego
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de Lego
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de Lego
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de Lego
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de Lego
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de Lego
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de Lego
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de Lego
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de Lego
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de Lego
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la edad recomendada para el producto de Lego
	 * @return La edad recomendada
	 */
	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	/**
	 * Establece la edad recomendada para el producto de Lego
	 * @param edadRecomendada La edad recomendada
	 */
	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	/**
	 * Obtiene el tema del set de Lego
	 * @return El tema del set
	 */
	public String getTemaLego() {
		return temaLego;
	}

	/**
	 * Establece el tema del set de Lego
	 * @param temaLego El tema del set
	 */
	public void setTemaLego(String temaLego) {
		this.temaLego = temaLego;
	}

	/**
	 * Obtiene el número de piezas del set de Lego
	 * @return El número de piezas
	 */
	public int getPiezasLego() {
		return piezasLego;
	}

	/**
	 * Establece el número de piezas del set de Lego
	 * @param piezasLego El número de piezas
	 */
	public void setPiezasLego(int piezasLego) {
		this.piezasLego = piezasLego;
	}

	/**
	 * Indica si el set de Lego incluye minifiguras
	 * @return Verdadero si incluye minifiguras, falso en caso contrario
	 */
	public boolean isMinifiguras() {
		return minifiguras;
	}

	/**
	 * Establece si el set de Lego incluye minifiguras
	 * @param minifiguras Verdadero si incluye minifiguras, falso en caso contrario
	 */
	public void setMinifiguras(boolean minifiguras) {
		this.minifiguras = minifiguras;
	}

	/**
	 * Obtiene la lista de opciones de temas de Lego
	 * @return La lista de opciones de temas
	 */
	public ArrayList<String> getOpcionesTema() {
		return opcionesTema;
	}

	/**
	 * Establece la lista de opciones de temas de Lego
	 * @param opcionesTema La lista de opciones de temas
	 */
	public void setOpcionesTema(ArrayList<String> opcionesTema) {
		this.opcionesTema = opcionesTema;
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
	 * Representación en cadena del objeto FormLegoBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormLegoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", edadRecomendada=" + edadRecomendada
				+ ", temaLego=" + temaLego + ", piezasLego=" + piezasLego + ", minifiguras=" + minifiguras + "]";
	}
}