/**
 * Clase que representa el bean de la vista para la gestión de productos de instrumentos de percusión
 * Permite registrar y gestionar los atributos de un producto de instrumento de percusión
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoPercusionDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de instrumentos de percusión
 */
@Named("percusionBean")
@ViewScoped
public class FormPercusionBean implements Serializable {

	/**
	 * Nombre del producto de instrumento de percusión
	 */
	private String nombre;

	/**
	 * Marca del producto de instrumento de percusión
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Instrumento de Percusión"
	 */
	private String tipoProducto="Instrumento de Percusión";

	/**
	 * Descripción del producto de instrumento de percusión
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de instrumento de percusión
	 */
	private String imagen="https://img.freepik.com/foto-gratis/mujer-joven-instrumentos-percusion_23-2148289064.jpg";

	/**
	 * Precio del producto de instrumento de percusión
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de instrumento de percusión
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de instrumento de percusión
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Indica si el instrumento incluye estuche
	 */
	private boolean incluyeEstuche;

	/**
	 * Tipo de instrumento de percusión
	 */
	private String tipoInstrumentoPercusion;

	/**
	 * Indica si el instrumento requiere el uso de baquetas
	 */
	private boolean usoBaquetas;

	/**
	 * Tipo de percusión
	 */
	private String tipoPercusion;

	/**
	 * Cantidad de superficies sonoras del instrumento
	 */
	private int cantSuperficiesSonoras;

	/**
	 * Lista de opciones de tipo de instrumento de percusión
	 */
	private ArrayList<String> opcionesInstrumento;

	/**
	 * Lista de opciones de tipo de percusión
	 */
	private ArrayList<String> opcionesTipo;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para tipo de instrumento y tipo de percusión
	 */
	@PostConstruct
	public void init() {
		opcionesInstrumento= new ArrayList<String>();
		opcionesTipo= new ArrayList<String>();
		opcionesInstrumento.add("Batería");
		opcionesInstrumento.add("Tambor");
		opcionesInstrumento.add("Bongó");
		opcionesInstrumento.add("Conga");
		opcionesInstrumento.add("Cajón");
		opcionesInstrumento.add("Timbal");
		opcionesInstrumento.add("Xilófono");
		opcionesInstrumento.add("Marimba");
		opcionesInstrumento.add("Platillos");
		opcionesInstrumento.add("Triángulo");
		opcionesTipo.add("Membranófonos");
		opcionesTipo.add("Idiófonos");
		opcionesTipo.add("Electrónicos");
	}

	/**
	 * Guarda un nuevo producto de instrumento de percusión utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new InstrumentoPercusionDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, incluyeEstuche, tipoInstrumentoPercusion, usoBaquetas, tipoPercusion, cantSuperficiesSonoras));
	}

	/**
	 * Obtiene el nombre del producto de instrumento de percusión
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de instrumento de percusión
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de instrumento de percusión
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de instrumento de percusión
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de instrumento de percusión
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de instrumento de percusión
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de instrumento de percusión
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de instrumento de percusión
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de instrumento de percusión
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de instrumento de percusión
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de instrumento de percusión
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de instrumento de percusión
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Indica si el instrumento incluye estuche
	 * @return Verdadero si incluye estuche, falso en caso contrario
	 */
	public boolean isIncluyeEstuche() {
		return incluyeEstuche;
	}

	/**
	 * Establece si el instrumento incluye estuche
	 * @param incluyeEstuche Verdadero si incluye estuche, falso en caso contrario
	 */
	public void setIncluyeEstuche(boolean incluyeEstuche) {
		this.incluyeEstuche = incluyeEstuche;
	}

	/**
	 * Obtiene el tipo de instrumento de percusión
	 * @return El tipo de instrumento
	 */
	public String getTipoInstrumentoPercusion() {
		return tipoInstrumentoPercusion;
	}

	/**
	 * Establece el tipo de instrumento de percusión
	 * @param tipoInstrumentoPercusion El tipo de instrumento
	 */
	public void setTipoInstrumentoPercusion(String tipoInstrumentoPercusion) {
		this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
	}

	/**
	 * Indica si el instrumento requiere el uso de baquetas
	 * @return Verdadero si usa baquetas, falso en caso contrario
	 */
	public boolean isUsoBaquetas() {
		return usoBaquetas;
	}

	/**
	 * Establece si el instrumento requiere el uso de baquetas
	 * @param usoBaquetas Verdadero si usa baquetas, falso en caso contrario
	 */
	public void setUsoBaquetas(boolean usoBaquetas) {
		this.usoBaquetas = usoBaquetas;
	}

	/**
	 * Obtiene el tipo de percusión
	 * @return El tipo de percusión
	 */
	public String getTipoPercusion() {
		return tipoPercusion;
	}

	/**
	 * Establece el tipo de percusión
	 * @param tipoPercusion El tipo de percusión
	 */
	public void setTipoPercusion(String tipoPercusion) {
		this.tipoPercusion = tipoPercusion;
	}

	/**
	 * Obtiene la cantidad de superficies sonoras del instrumento
	 * @return La cantidad de superficies sonoras
	 */
	public int getCantSuperficiesSonoras() {
		return cantSuperficiesSonoras;
	}

	/**
	 * Establece la cantidad de superficies sonoras del instrumento
	 * @param cantSuperficiesSonoras La cantidad de superficies sonoras
	 */
	public void setCantSuperficiesSonoras(int cantSuperficiesSonoras) {
		this.cantSuperficiesSonoras = cantSuperficiesSonoras;
	}

	/**
	 * Obtiene la lista de opciones de tipo de instrumento de percusión
	 * @return La lista de opciones de instrumento
	 */
	public ArrayList<String> getOpcionesInstrumento() {
		return opcionesInstrumento;
	}

	/**
	 * Establece la lista de opciones de tipo de instrumento de percusión
	 * @param opcionesInstrumento La lista de opciones de instrumento
	 */
	public void setOpcionesInstrumento(ArrayList<String> opcionesInstrumento) {
		this.opcionesInstrumento = opcionesInstrumento;
	}

	/**
	 * Obtiene la lista de opciones de tipo de percusión
	 * @return La lista de opciones de tipo de percusión
	 */
	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	/**
	 * Establece la lista de opciones de tipo de percusión
	 * @param opcionesTipo La lista de opciones de tipo de percusión
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
	 * Representación en cadena del objeto FormPercusionBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormPercusionBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion
				+ ", imagen=" + imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", incluyeEstuche="
				+ incluyeEstuche + ", tipoInstrumentoPercusion=" + tipoInstrumentoPercusion + ", usoBaquetas="
				+ usoBaquetas + ", tipoPercusion=" + tipoPercusion + ", cantSuperficiesSonoras="
				+ cantSuperficiesSonoras + "]";
	}
}