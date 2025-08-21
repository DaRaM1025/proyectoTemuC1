/**
 * Clase que representa el bean de la vista para la gestión de productos de camiseta
 * Permite registrar y gestionar los atributos de un producto de camiseta
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CamisetaDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de camiseta
 */
@Named(value="camisetaBean")
@ViewScoped
public class FormCamisetaBean implements Serializable {

	/**
	 * Nombre del producto de camiseta
	 */
	private String nombre;

	/**
	 * Marca del producto de camiseta
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Camiseta"
	 */
	private final String tipoProducto="Camiseta";

	/**
	 * Descripción del producto de camiseta
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de camiseta
	 */
	private String imagen="https://img.freepik.com/foto-gratis/camisa-limpia-blanco-percha_23-2149347514.jpg";

	/**
	 * Precio del producto de camiseta
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de camiseta
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de camiseta
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Talla del producto de camiseta
	 */
	private String talla;

	/**
	 * Género al que está dirigido el producto de camiseta
	 */
	private String genero;

	/**
	 * Material del producto de camiseta
	 */
	private String material;

	/**
	 * Tipo de manga de la camiseta
	 */
	private String mangaCamiseta;

	/**
	 * Tipo de cuello de la camiseta
	 */
	private String cuelloCamiseta;

	/**
	 * Indica si la camiseta es estampada
	 */
	private boolean estampada;

	/**
	 * Lista de opciones de género para la camiseta
	 */
	private ArrayList<String> opcionesGenero;

	/**
	 * Lista de opciones de tipo de manga para la camiseta
	 */
	private ArrayList<String> opcionesManga;

	/**
	 * Lista de opciones de tipo de cuello para la camiseta
	 */
	private ArrayList<String> opcionesCuello;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para género, manga y cuello de la camiseta
	 */
	@PostConstruct
	public void init() {
		opcionesGenero = new ArrayList<>();
		opcionesManga = new ArrayList<>();
		opcionesCuello = new ArrayList<>();
		opcionesGenero.add("Mujer");
		opcionesGenero.add("Hombre");
		opcionesGenero.add("Niño");
		opcionesGenero.add("Niña");
		opcionesManga.add("Manga Corta");
		opcionesManga.add("Manga Larga");
		opcionesManga.add("Manga 3/4");
		opcionesManga.add("Sin Mangas");
		opcionesCuello.add("Cuello Redondo");
		opcionesCuello.add("Cuello en V");
		opcionesCuello.add("Cuello Polo");
		opcionesCuello.add("Cuello TortugaS");
	}

	/**
	 * Guarda un nuevo producto de camiseta utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new CamisetaDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, talla, genero, material, descripcion, cuelloCamiseta, estampada));
	}

	/**
	 * Representación en cadena del objeto FormCamisetaBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormCamisetaBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", talla=" + talla + ", genero=" + genero
				+ ", material=" + material + ", mangaCamiseta=" + mangaCamiseta + ", cuelloCamiseta=" + cuelloCamiseta
				+ ", estampada=" + estampada + "]";
	}

	/**
	 * Obtiene el nombre del producto de camiseta
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de camiseta
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de camiseta
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de camiseta
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de camiseta
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de camiseta
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de camiseta
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de camiseta
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de camiseta
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de camiseta
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de camiseta
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de camiseta
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la talla del producto de camiseta
	 * @return La talla del producto
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * Establece la talla del producto de camiseta
	 * @param talla La talla del producto
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

	/**
	 * Obtiene el género del producto de camiseta
	 * @return El género del producto
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el género del producto de camiseta
	 * @param genero El género del producto
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene el material del producto de camiseta
	 * @return El material del producto
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Establece el material del producto de camiseta
	 * @param material El material del producto
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Obtiene el tipo de manga de la camiseta
	 * @return El tipo de manga
	 */
	public String getMangaCamiseta() {
		return mangaCamiseta;
	}

	/**
	 * Establece el tipo de manga de la camiseta
	 * @param mangaCamiseta El tipo de manga
	 */
	public void setMangaCamiseta(String mangaCamiseta) {
		this.mangaCamiseta = mangaCamiseta;
	}

	/**
	 * Obtiene el tipo de cuello de la camiseta
	 * @return El tipo de cuello
	 */
	public String getCuelloCamiseta() {
		return cuelloCamiseta;
	}

	/**
	 * Establece el tipo de cuello de la camiseta
	 * @param cuelloCamiseta El tipo de cuello
	 */
	public void setCuelloCamiseta(String cuelloCamiseta) {
		this.cuelloCamiseta = cuelloCamiseta;
	}

	/**
	 * Indica si la camiseta es estampada
	 * @return Verdadero si la camiseta es estampada, falso en caso contrario
	 */
	public boolean isEstampada() {
		return estampada;
	}

	/**
	 * Establece si la camiseta es estampada
	 * @param estampada Verdadero si la camiseta es estampada, falso en caso contrario
	 */
	public void setEstampada(boolean estampada) {
		this.estampada = estampada;
	}

	/**
	 * Obtiene la lista de opciones de género
	 * @return La lista de opciones de género
	 */
	public ArrayList<String> getOpcionesGenero() {
		return opcionesGenero;
	}

	/**
	 * Establece la lista de opciones de género
	 * @param opcionesGenero La lista de opciones de género
	 */
	public void setOpcionesGenero(ArrayList<String> opcionesGenero) {
		this.opcionesGenero = opcionesGenero;
	}

	/**
	 * Obtiene la lista de opciones de tipo de manga
	 * @return La lista de opciones de manga
	 */
	public ArrayList<String> getOpcionesManga() {
		return opcionesManga;
	}

	/**
	 * Establece la lista de opciones de tipo de manga
	 * @param opcionesManga La lista de opciones de manga
	 */
	public void setOpcionesManga(ArrayList<String> opcionesManga) {
		this.opcionesManga = opcionesManga;
	}

	/**
	 * Obtiene la lista de opciones de tipo de cuello
	 * @return La lista de opciones de cuello
	 */
	public ArrayList<String> getOpcionesCuello() {
		return opcionesCuello;
	}

	/**
	 * Establece la lista de opciones de tipo de cuello
	 * @param opcionesCuello La lista de opciones de cuello
	 */
	public void setOpcionesCuello(ArrayList<String> opcionesCuello) {
		this.opcionesCuello = opcionesCuello;
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
	 * Obtiene el tipo de producto
	 * @return El tipo de producto
	 */
	public String getTipoProducto() {
		return tipoProducto;
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
}