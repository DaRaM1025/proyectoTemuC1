/**
 * Clase que representa el bean de la vista para la gestión de productos de pantalón
 * Permite registrar y gestionar los atributos de un producto de pantalón
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.PantalonDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de pantalón
 */
@Named(value="pantalonBean")
@ViewScoped
public class FormPantalonBean implements Serializable {

	/**
	 * Nombre del producto de pantalón
	 */
	private String nombre;

	/**
	 * Marca del producto de pantalón
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Pantalón"
	 */
	private final String tipoProducto="Pantalón";

	/**
	 * Descripción del producto de pantalón
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de pantalón
	 */
	private String imagen="https://img.freepik.com/foto-gratis/mano-sosteniendo-pantalones-beige-marron-claro_23-2150756282.jpg";

	/**
	 * Precio del producto de pantalón
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de pantalón
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de pantalón
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Talla del pantalón
	 */
	private String talla;

	/**
	 * Género del pantalón
	 */
	private String genero;

	/**
	 * Material del pantalón
	 */
	private String material;

	/**
	 * Tipo de pantalón
	 */
	private String tipoPantalon;

	/**
	 * Corte del pantalón
	 */
	private String cortePantalon;

	/**
	 * Largo del pantalón
	 */
	private String largoPantalon;

	/**
	 * Lista de opciones de género
	 */
	private ArrayList<String> opcionesGenero;

	/**
	 * Lista de opciones de tipo de pantalón
	 */
	private ArrayList<String> opcionesTipo;

	/**
	 * Lista de opciones de corte de pantalón
	 */
	private ArrayList<String> opcionesCorte;

	/**
	 * Lista de opciones de largo de pantalón
	 */
	private ArrayList<String> opcionesLargo;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para género, tipo, corte y largo de pantalón
	 */
	@PostConstruct
	public void init() {
		opcionesGenero = new ArrayList<>();
		opcionesTipo = new ArrayList<>();
		opcionesCorte = new ArrayList<>();
		opcionesLargo = new ArrayList<>();
		opcionesGenero.add("Mujer");
		opcionesGenero.add("Hombre");
		opcionesGenero.add("Niño");
		opcionesGenero.add("Niña");
		opcionesTipo.add("Jean");
		opcionesTipo.add("Cargo");
		opcionesTipo.add("Chino");
		opcionesTipo.add("Jogger");
		opcionesTipo.add("De vestir");
		opcionesCorte.add("Boyfriend");
		opcionesCorte.add("Skinny");
		opcionesCorte.add("Slim fit");
		opcionesCorte.add("Recto");
		opcionesCorte.add("Bootcut");
		opcionesCorte.add("Wide leg");
		opcionesLargo.add("Corto");
		opcionesLargo.add("Capri");
		opcionesLargo.add("Tobillero");
		opcionesLargo.add("Normal");
		opcionesLargo.add("Extra Largo");
	}

	/**
	 * Guarda un nuevo producto de pantalón utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new PantalonDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, talla, genero, material, tipoPantalon, cortePantalon, largoPantalon));
	}

	/**
	 * Obtiene el nombre del producto de pantalón
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de pantalón
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de pantalón
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de pantalón
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de pantalón
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de pantalón
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de pantalón
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de pantalón
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de pantalón
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de pantalón
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de pantalón
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de pantalón
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la talla del pantalón
	 * @return La talla del pantalón
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * Establece la talla del pantalón
	 * @param talla La talla del pantalón
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

	/**
	 * Obtiene el género del pantalón
	 * @return El género del pantalón
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el género del pantalón
	 * @param genero El género del pantalón
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene el material del pantalón
	 * @return El material del pantalón
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Establece el material del pantalón
	 * @param material El material del pantalón
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Obtiene el tipo de pantalón
	 * @return El tipo de pantalón
	 */
	public String getTipoPantalon() {
		return tipoPantalon;
	}

	/**
	 * Establece el tipo de pantalón
	 * @param tipoPantalon El tipo de pantalón
	 */
	public void setTipoPantalon(String tipoPantalon) {
		this.tipoPantalon = tipoPantalon;
	}

	/**
	 * Obtiene el corte del pantalón
	 * @return El corte del pantalón
	 */
	public String getCortePantalon() {
		return cortePantalon;
	}

	/**
	 * Establece el corte del pantalón
	 * @param cortePantalon El corte del pantalón
	 */
	public void setCortePantalon(String cortePantalon) {
		this.cortePantalon = cortePantalon;
	}

	/**
	 * Obtiene el largo del pantalón
	 * @return El largo del pantalón
	 */
	public String getLargoPantalon() {
		return largoPantalon;
	}

	/**
	 * Establece el largo del pantalón
	 * @param largoPantalon El largo del pantalón
	 */
	public void setLargoPantalon(String largoPantalon) {
		this.largoPantalon = largoPantalon;
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
	 * Obtiene la lista de opciones de tipo de pantalón
	 * @return La lista de opciones de tipo de pantalón
	 */
	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	/**
	 * Establece la lista de opciones de tipo de pantalón
	 * @param opcionesTipo La lista de opciones de tipo de pantalón
	 */
	public void setOpcionesTipo(ArrayList<String> opcionesTipo) {
		this.opcionesTipo = opcionesTipo;
	}

	/**
	 * Obtiene la lista de opciones de corte de pantalón
	 * @return La lista de opciones de corte de pantalón
	 */
	public ArrayList<String> getOpcionesCorte() {
		return opcionesCorte;
	}

	/**
	 * Establece la lista de opciones de corte de pantalón
	 * @param opcionesCorte La lista de opciones de corte de pantalón
	 */
	public void setOpcionesCorte(ArrayList<String> opcionesCorte) {
		this.opcionesCorte = opcionesCorte;
	}

	/**
	 * Obtiene la lista de opciones de largo de pantalón
	 * @return La lista de opciones de largo de pantalón
	 */
	public ArrayList<String> getOpcionesLargo() {
		return opcionesLargo;
	}

	/**
	 * Establece la lista de opciones de largo de pantalón
	 * @param opcionesLargo La lista de opciones de largo de pantalón
	 */
	public void setOpcionesLargo(ArrayList<String> opcionesLargo) {
		this.opcionesLargo = opcionesLargo;
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

	/**
	 * Representación en cadena del objeto FormPantalonBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormPantalonBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", talla=" + talla + ", genero=" + genero
				+ ", material=" + material + ", tipoPantalon=" + tipoPantalon + ", cortePantalon=" + cortePantalon
				+ ", largoPantalon=" + largoPantalon + "]";
	}
}