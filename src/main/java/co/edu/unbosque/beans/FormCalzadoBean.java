/**
 * Clase que representa el bean de la vista para la gestión de productos de calzado
 * Permite registrar y gestionar los atributos de un producto de calzado
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CalzadoDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de calzado
 */
@Named(value="calzadoBean")
@ViewScoped
public class FormCalzadoBean implements Serializable {

	/**
	 * Nombre del producto de calzado
	 */
	private String nombre;

	/**
	 * Marca del producto de calzado
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Calzado"
	 */
	private final String tipoProducto="Calzado";

	/**
	 * Descripción del producto de calzado
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de calzado
	 */
	private String imagen="https://img.freepik.com/foto-gratis/zapatos-cuero-marron_1203-8175.jpg";

	/**
	 * Precio del producto de calzado
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de calzado
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de calzado
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Talla del producto de calzado
	 */
	private String talla;

	/**
	 * Género al que está dirigido el producto de calzado
	 */
	private String genero;

	/**
	 * Material del producto de calzado
	 */
	private String material;

	/**
	 * Tipo de calzado (e.g., Tennis, Sandalía)
	 */
	private String tipoCalzado;

	/**
	 * Ocasión para la que está diseñado el calzado
	 */
	private String ocasionCalzado;

	/**
	 * Tipo de suela del calzado
	 */
	private String suelaCalzado;

	/**
	 * Altura de la suela del calzado
	 */
	private double alturaSuela;

	/**
	 * Lista de opciones de género para el calzado
	 */
	private ArrayList<String> opcionesGenero;

	/**
	 * Lista de opciones de tipo de calzado
	 */
	private ArrayList<String> opcionesTipo;

	/**
	 * Lista de opciones de ocasión para el calzado
	 */
	private ArrayList<String> opcionesOcasion;

	/**
	 * Lista de opciones de material para el calzado
	 */
	private ArrayList<String> opcionesMaterial;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para género, tipo, ocasión y material del calzado
	 */
	@PostConstruct
	public void init() {
		opcionesGenero = new ArrayList<>();
		opcionesTipo = new ArrayList<>();
		opcionesOcasion = new ArrayList<>();
		opcionesMaterial = new ArrayList<>();
		opcionesGenero.add("Mujer");
		opcionesGenero.add("Hombre");
		opcionesGenero.add("Niño");
		opcionesGenero.add("Niña");
		opcionesTipo.add("Tennis");
		opcionesTipo.add("Sandalía");
		opcionesTipo.add("Bota");
		opcionesTipo.add("Tacón");
		opcionesTipo.add("Mocasín");
		opcionesOcasion.add("Casual");
		opcionesOcasion.add("Fiesta");
		opcionesOcasion.add("Formal");
		opcionesOcasion.add("Deportiva");
		opcionesMaterial.add("Poliuretano");
		opcionesMaterial.add("Policloruro de vinilo");
		opcionesMaterial.add("Neopreno");
		opcionesMaterial.add("Yute");
		opcionesMaterial.add("Cuero");
		opcionesMaterial.add("Corcho");
		opcionesMaterial.add("Thermo Rubber");
		opcionesMaterial.add("Espuma");
	}

	/**
	 * Guarda un nuevo producto de calzado utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new CalzadoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, talla, genero, material, tipoCalzado, ocasionCalzado, suelaCalzado, alturaSuela));
	}

	/**
	 * Obtiene el nombre del producto de calzado
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de calzado
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de calzado
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de calzado
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de calzado
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de calzado
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de calzado
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de calzado
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de calzado
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de calzado
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de calzado
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de calzado
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la talla del producto de calzado
	 * @return La talla del producto
	 */
	public String getTalla() {
		return talla;
	}

	/**
	 * Establece la talla del producto de calzado
	 * @param talla La talla del producto
	 */
	public void setTalla(String talla) {
		this.talla = talla;
	}

	/**
	 * Obtiene el género del producto de calzado
	 * @return El género del producto
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece el género del producto de calzado
	 * @param genero El género del producto
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene el material del producto de calzado
	 * @return El material del producto
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Establece el material del producto de calzado
	 * @param material El material del producto
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Obtiene el tipo de calzado
	 * @return El tipo de calzado
	 */
	public String getTipoCalzado() {
		return tipoCalzado;
	}

	/**
	 * Establece el tipo de calzado
	 * @param tipoCalzado El tipo de calzado
	 */
	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}

	/**
	 * Obtiene la ocasión del calzado
	 * @return La ocasión del calzado
	 */
	public String getOcasionCalzado() {
		return ocasionCalzado;
	}

	/**
	 * Establece la ocasión del calzado
	 * @param ocasionCalzado La ocasión del calzado
	 */
	public void setOcasionCalzado(String ocasionCalzado) {
		this.ocasionCalzado = ocasionCalzado;
	}

	/**
	 * Obtiene el tipo de suela del calzado
	 * @return El tipo de suela
	 */
	public String getSuelaCalzado() {
		return suelaCalzado;
	}

	/**
	 * Establece el tipo de suela del calzado
	 * @param suelaCalzado El tipo de suela
	 */
	public void setSuelaCalzado(String suelaCalzado) {
		this.suelaCalzado = suelaCalzado;
	}

	/**
	 * Obtiene la altura de la suela del calzado
	 * @return La altura de la suela
	 */
	public double getAlturaSuela() {
		return alturaSuela;
	}

	/**
	 * Establece la altura de la suela del calzado
	 * @param alturaSuela La altura de la suela
	 */
	public void setAlturaSuela(double alturaSuela) {
		this.alturaSuela = alturaSuela;
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
	 * Obtiene la lista de opciones de tipo de calzado
	 * @return La lista de opciones de tipo
	 */
	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	/**
	 * Establece la lista de opciones de tipo de calzado
	 * @param opcionesTipo La lista de opciones de tipo
	 */
	public void setOpcionesTipo(ArrayList<String> opcionesTipo) {
		this.opcionesTipo = opcionesTipo;
	}

	/**
	 * Obtiene la lista de opciones de ocasión
	 * @return La lista de opciones de ocasión
	 */
	public ArrayList<String> getOpcionesOcasion() {
		return opcionesOcasion;
	}

	/**
	 * Establece la lista de opciones de ocasión
	 * @param opcionesOcasion La lista de opciones de ocasión
	 */
	public void setOpcionesOcasion(ArrayList<String> opcionesOcasion) {
		this.opcionesOcasion = opcionesOcasion;
	}

	/**
	 * Obtiene la lista de opciones de material
	 * @return La lista de opciones de material
	 */
	public ArrayList<String> getOpcionesMaterial() {
		return opcionesMaterial;
	}

	/**
	 * Establece la lista de opciones de material
	 * @param opcionesMaterial La lista de opciones de material
	 */
	public void setOpcionesMaterial(ArrayList<String> opcionesMaterial) {
		this.opcionesMaterial = opcionesMaterial;
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
	 * Representación en cadena del objeto FormCalzadoBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormCalzadoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", talla=" + talla + ", genero=" + genero
				+ ", material=" + material + ", tipoCalzado=" + tipoCalzado + ", ocasionCalzado=" + ocasionCalzado
				+ ", suelaCalzado=" + suelaCalzado + ", alturaSuela=" + alturaSuela ;
	}
}