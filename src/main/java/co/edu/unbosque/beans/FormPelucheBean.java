/**
 * Clase que representa el bean de la vista para la gestión de productos de peluche
 * Permite registrar y gestionar los atributos de un producto de peluche
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.PelucheDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de peluche
 */
@Named(value="pelucheBean")
@ViewScoped
public class FormPelucheBean implements Serializable {

	/**
	 * Nombre del producto de peluche
	 */
	private String nombre;

	/**
	 * Marca del producto de peluche
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Peluche"
	 */
	private String tipoProducto="Peluche";

	/**
	 * Descripción del producto de peluche
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de peluche
	 */
	private String imagen="https://img.freepik.com/foto-gratis/juguetes-osos-lindos-esponjosos_23-2149642403.jpg";

	/**
	 * Precio del producto de peluche
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de peluche
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de peluche
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Edad recomendada para el producto de peluche
	 */
	private int edadRecomendada;

	/**
	 * Indica si el peluche tiene sonido
	 */
	private boolean sonidoPeluche;

	/**
	 * Tipo de relleno del peluche
	 */
	private String rellenoPeluche;

	/**
	 * Indica si el peluche es lavable
	 */
	private boolean lavable;

	/**
	 * Lista de opciones de tipo de relleno
	 */
	private ArrayList<String> opcionesRelleno;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Constructor por defecto
	 */
	public FormPelucheBean() {
	}

	/**
	 * Inicializa la lista de opciones para el tipo de relleno del peluche
	 */
	@PostConstruct
	public void init() {
		opcionesRelleno = new ArrayList<>();
		opcionesRelleno.add("Algodón sintético");
		opcionesRelleno.add("Espuma");
		opcionesRelleno.add("Microperlas");
		opcionesRelleno.add("Algodón Natural");
		opcionesRelleno.add("Bolitas térmicas");
	}

	/**
	 * Guarda un nuevo producto de peluche utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new PelucheDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, edadRecomendada, sonidoPeluche, rellenoPeluche, lavable));
	}

	/**
	 * Limpia los campos del formulario sin guardar los datos
	 * @return null para permanecer en la misma vista
	 */
	public String cancelar() {
		nombre = null;
		marca = null;
		descripcion = null;
		imagen = "https://img.freepik.com/foto-gratis/juguetes-osos-lindos-esponjosos_23-2149642403.jpg";
		precio = 0.0;
		cantidad = 0;
		id = UUID.randomUUID().toString();
		edadRecomendada = 0;
		sonidoPeluche = false;
		rellenoPeluche = null;
		lavable = false;
		return null;
	}

	/**
	 * Obtiene el nombre del producto de peluche
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de peluche
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de peluche
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de peluche
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de peluche
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de peluche
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de peluche
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de peluche
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de peluche
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de peluche
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de peluche
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de peluche
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la edad recomendada para el producto de peluche
	 * @return La edad recomendada
	 */
	public int getEdadRecomendada() {
		return edadRecomendada;
	}

	/**
	 * Establece la edad recomendada para el producto de peluche
	 * @param edadRecomendada La edad recomendada
	 */
	public void setEdadRecomendada(int edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}

	/**
	 * Indica si el peluche tiene sonido
	 * @return Verdadero si tiene sonido, falso en caso contrario
	 */
	public boolean isSonidoPeluche() {
		return sonidoPeluche;
	}

	/**
	 * Establece si el peluche tiene sonido
	 * @param sonidoPeluche Verdadero si tiene sonido, falso en caso contrario
	 */
	public void setSonidoPeluche(boolean sonidoPeluche) {
		this.sonidoPeluche = sonidoPeluche;
	}

	/**
	 * Obtiene el tipo de relleno del peluche
	 * @return El tipo de relleno
	 */
	public String getRellenoPeluche() {
		return rellenoPeluche;
	}

	/**
	 * Establece el tipo de relleno del peluche
	 * @param rellenoPeluche El tipo de relleno
	 */
	public void setRellenoPeluche(String rellenoPeluche) {
		this.rellenoPeluche = rellenoPeluche;
	}

	/**
	 * Indica si el peluche es lavable
	 * @return Verdadero si es lavable, falso en caso contrario
	 */
	public boolean isLavable() {
		return lavable;
	}

	/**
	 * Establece si el peluche es lavable
	 * @param lavable Verdadero si es lavable, falso en caso contrario
	 */
	public void setLavable(boolean lavable) {
		this.lavable = lavable;
	}

	/**
	 * Obtiene la lista de opciones de tipo de relleno
	 * @return La lista de opciones de relleno
	 */
	public ArrayList<String> getOpcionesRelleno() {
		return opcionesRelleno;
	}

	/**
	 * Establece la lista de opciones de tipo de relleno
	 * @param opcionesRelleno La lista de opciones de relleno
	 */
	public void setOpcionesRelleno(ArrayList<String> opcionesRelleno) {
		this.opcionesRelleno = opcionesRelleno;
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
	 * Representación en cadena del objeto FormPelucheBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormPelucheBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", edadRecomendada=" + edadRecomendada
				+ ", sonidoPeluche=" + sonidoPeluche + ", rellenoPeluche=" + rellenoPeluche + ", lavable=" + lavable + "]";
	}
}