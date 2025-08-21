/**
 * Clase que representa el bean de la vista para la gestión de productos de sombra de ojos
 * Permite registrar y gestionar los atributos de un producto de sombra de ojos
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.SombraDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de sombra de ojos
 */
@Named("sombraBean")
@ViewScoped
public class FormSombraBean implements Serializable {

	/**
	 * Nombre del producto de sombra de ojos
	 */
	private String nombre;

	/**
	 * Marca del producto de sombra de ojos
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Sombra"
	 */
	private String tipoProducto="Sombra";

	/**
	 * Descripción del producto de sombra de ojos
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de sombra de ojos
	 */
	private String imagen="https://img.freepik.com/foto-gratis/vista-paleta-sombras-ojos-polvo-cosmetico_23-2150260878.jpg";

	/**
	 * Precio del producto de sombra de ojos
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de sombra de ojos
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de sombra de ojos
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Tipo de piel para el cual está diseñada la sombra
	 */
	private String tipoPiel;

	/**
	 * Indica si la sombra es resistente al agua
	 */
	private boolean pruebaAgua;

	/**
	 * Fecha de vencimiento de la sombra
	 */
	private String fechaVencimiento;

	/**
	 * Cantidad de colores en la paleta de sombras
	 */
	private int cantidadColores;

	/**
	 * Tipo de acabado de la sombra
	 */
	private String acabadoSombras;

	/**
	 * Lista de opciones de tipo de piel
	 */
	private ArrayList<String> opcionesPiel;

	/**
	 * Lista de opciones de acabado de la sombra
	 */
	private ArrayList<String> opcionesAcabado;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para tipo de piel y acabado de la sombra
	 */
	@PostConstruct
	public void init() {
		opcionesPiel = new ArrayList<String>();
		opcionesAcabado = new ArrayList<String>();
		opcionesPiel.add("Grasa");
		opcionesPiel.add("Seca");
		opcionesPiel.add("Mixta");
		opcionesAcabado.add("Mate");
		opcionesAcabado.add("Satinado");
		opcionesAcabado.add("Shimmer");
		opcionesAcabado.add("Holográfico");
		opcionesAcabado.add("Perlado");
		opcionesAcabado.add("Metálico");
	}

	/**
	 * Guarda un nuevo producto de sombra de ojos utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new SombraDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, tipoPiel, pruebaAgua, fechaVencimiento, cantidadColores, acabadoSombras));
	}

	/**
	 * Obtiene el nombre del producto de sombra de ojos
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de sombra de ojos
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de sombra de ojos
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de sombra de ojos
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de sombra de ojos
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de sombra de ojos
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de sombra de ojos
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de sombra de ojos
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de sombra de ojos
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de sombra de ojos
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de sombra de ojos
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de sombra de ojos
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el tipo de piel para la sombra
	 * @return El tipo de piel
	 */
	public String getTipoPiel() {
		return tipoPiel;
	}

	/**
	 * Establece el tipo de piel para la sombra
	 * @param tipoPiel El tipo de piel
	 */
	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Indica si la sombra es resistente al agua
	 * @return Verdadero si es resistente al agua, falso en caso contrario
	 */
	public boolean isPruebaAgua() {
		return pruebaAgua;
	}

	/**
	 * Establece si la sombra es resistente al agua
	 * @param pruebaAgua Verdadero si es resistente al agua, falso en caso contrario
	 */
	public void setPruebaAgua(boolean pruebaAgua) {
		this.pruebaAgua = pruebaAgua;
	}

	/**
	 * Obtiene la fecha de vencimiento de la sombra
	 * @return La fecha de vencimiento
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * Establece la fecha de vencimiento de la sombra
	 * @param fechaVencimiento La fecha de vencimiento
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * Obtiene la cantidad de colores en la paleta de sombras
	 * @return La cantidad de colores
	 */
	public int getCantidadColores() {
		return cantidadColores;
	}

	/**
	 * Establece la cantidad de colores en la paleta de sombras
	 * @param cantidadColores La cantidad de colores
	 */
	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}

	/**
	 * Obtiene el tipo de acabado de la sombra
	 * @return El tipo de acabado
	 */
	public String getAcabadoSombras() {
		return acabadoSombras;
	}

	/**
	 * Establece el tipo de acabado de la sombra
	 * @param acabadoSombras El tipo de acabado
	 */
	public void setAcabadoSombras(String acabadoSombras) {
		this.acabadoSombras = acabadoSombras;
	}

	/**
	 * Obtiene la lista de opciones de tipo de piel
	 * @return La lista de opciones de tipo de piel
	 */
	public ArrayList<String> getOpcionesPiel() {
		return opcionesPiel;
	}

	/**
	 * Establece la lista de opciones de tipo de piel
	 * @param opcionesPiel La lista de opciones de tipo de piel
	 */
	public void setOpcionesPiel(ArrayList<String> opcionesPiel) {
		this.opcionesPiel = opcionesPiel;
	}

	/**
	 * Obtiene la lista de opciones de acabado de la sombra
	 * @return La lista de opciones de acabado
	 */
	public ArrayList<String> getOpcionesAcabado() {
		return opcionesAcabado;
	}

	/**
	 * Establece la lista de opciones de acabado de la sombra
	 * @param opcionesAcabado La lista de opciones de acabado
	 */
	public void setOpcionesAcabado(ArrayList<String> opcionesAcabado) {
		this.opcionesAcabado = opcionesAcabado;
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
	 * Representación en cadena del objeto FormSombraBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormSombraBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", tipoPiel=" + tipoPiel + ", pruebaAgua="
				+ pruebaAgua + ", fechaVencimiento=" + fechaVencimiento + ", cantidadColores=" + cantidadColores
				+ ", acabadoSombras=" + acabadoSombras + "]";
	}
}