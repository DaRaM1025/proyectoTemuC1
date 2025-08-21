/**
 * Clase que representa el bean de la vista para la gestión de productos de labial
 * Permite registrar y gestionar los atributos de un producto de labial
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.LabialDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de labial
 */
@Named("labialBean")
@ViewScoped
public class FormLabialBean implements Serializable {

	/**
	 * Nombre del producto de labial
	 */
	private String nombre;

	/**
	 * Marca del producto de labial
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Labial"
	 */
	private String tipoProducto="Labial";

	/**
	 * Descripción del producto de labial
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de labial
	 */
	private String imagen="https://img.freepik.com/foto-gratis/vista-frontal-lapiz-labial-rojo-sobre-fondo-rosa_23-2148320952.jpg";

	/**
	 * Precio del producto de labial
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de labial
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de labial
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Tipo de piel para el cual está diseñado el labial
	 */
	private String tipoPiel;

	/**
	 * Indica si el labial es resistente al agua
	 */
	private boolean pruebaAgua;

	/**
	 * Fecha de vencimiento del labial
	 */
	private String fechaVencimiento;

	/**
	 * Duración del labial
	 */
	private String duracionLabial;

	/**
	 * Indica si el labial es hidratante
	 */
	private boolean hidratante;

	/**
	 * Lista de opciones de tipo de piel
	 */
	private ArrayList<String> opcionesPiel;

	/**
	 * Lista de opciones de duración del labial
	 */
	private ArrayList<String> opcionesDuracion;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para tipo de piel y duración del labial
	 */
	@PostConstruct
	public void init() {
		opcionesPiel=new ArrayList<String>();
		opcionesDuracion= new ArrayList<String>();
		opcionesPiel.add("Grasa");
		opcionesPiel.add("Seca");
		opcionesPiel.add("Mixta");
		opcionesDuracion.add("Corta (1 a 2 horas)");
		opcionesDuracion.add("Media (3 a 5 horas)");
		opcionesDuracion.add("Larga (6 a 8 horas)");
		opcionesDuracion.add("Ultra (24 horas)");
		opcionesDuracion.add("No transfer");
	}

	/**
	 * Guarda un nuevo producto de labial utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new LabialDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, tipoPiel, pruebaAgua, fechaVencimiento, duracionLabial, hidratante));
	}

	/**
	 * Obtiene el nombre del producto de labial
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de labial
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de labial
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de labial
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de labial
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de labial
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de labial
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de labial
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de labial
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de labial
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de labial
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de labial
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el tipo de piel para el labial
	 * @return El tipo de piel
	 */
	public String getTipoPiel() {
		return tipoPiel;
	}

	/**
	 * Establece el tipo de piel para el labial
	 * @param tipoPiel El tipo de piel
	 */
	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Indica si el labial es resistente al agua
	 * @return Verdadero si es resistente al agua, falso en caso contrario
	 */
	public boolean isPruebaAgua() {
		return pruebaAgua;
	}

	/**
	 * Establece si el labial es resistente al agua
	 * @param pruebaAgua Verdadero si es resistente al agua, falso en caso contrario
	 */
	public void setPruebaAgua(boolean pruebaAgua) {
		this.pruebaAgua = pruebaAgua;
	}

	/**
	 * Obtiene la fecha de vencimiento del labial
	 * @return La fecha de vencimiento
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * Establece la fecha de vencimiento del labial
	 * @param fechaVencimiento La fecha de vencimiento
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * Obtiene la duración del labial
	 * @return La duración del labial
	 */
	public String getDuracionLabial() {
		return duracionLabial;
	}

	/**
	 * Establece la duración del labial
	 * @param duracionLabial La duración del labial
	 */
	public void setDuracionLabial(String duracionLabial) {
		this.duracionLabial = duracionLabial;
	}

	/**
	 * Indica si el labial es hidratante
	 * @return Verdadero si es hidratante, falso en caso contrario
	 */
	public boolean isHidratante() {
		return hidratante;
	}

	/**
	 * Establece si el labial es hidratante
	 * @param hidratante Verdadero si es hidratante, falso en caso contrario
	 */
	public void setHidratante(boolean hidratante) {
		this.hidratante = hidratante;
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
	 * Obtiene la lista de opciones de duración del labial
	 * @return La lista de opciones de duración
	 */
	public ArrayList<String> getOpcionesDuracion() {
		return opcionesDuracion;
	}

	/**
	 * Establece la lista de opciones de duración del labial
	 * @param opcionesDuracion La lista de opciones de duración
	 */
	public void setOpcionesDuracion(ArrayList<String> opcionesDuracion) {
		this.opcionesDuracion = opcionesDuracion;
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
	 * Representación en cadena del objeto FormLabialBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormLabialBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", tipoPiel=" + tipoPiel + ", pruebaAgua="
				+ pruebaAgua + ", fechaVencimiento=" + fechaVencimiento + ", duracionLabial=" + duracionLabial
				+ ", hidratante=" + hidratante + "]";
	}
}