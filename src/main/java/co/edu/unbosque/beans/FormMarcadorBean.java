/**
 * Clase que representa el bean de la vista para la gestión de productos de marcador
 * Permite registrar y gestionar los atributos de un producto de marcador
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.MarcadorDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de marcador
 */
@Named("marcadorBean")
@ViewScoped
public class FormMarcadorBean implements Serializable {

	/**
	 * Nombre del producto de marcador
	 */
	private String nombre;

	/**
	 * Marca del producto de marcador
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Marcador"
	 */
	private String tipoProducto="Marcador";

	/**
	 * Descripción del producto de marcador
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de marcador
	 */
	private String imagen="https://img.freepik.com/foto-gratis/rotulador-negro-aislado-fondo-whtie_53876-18006.jpg";

	/**
	 * Precio del producto de marcador
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de marcador
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de marcador
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Presentación del producto de marcador
	 */
	private String presentacion;

	/**
	 * Tipo de punta del marcador
	 */
	private String tipoPunta;

	/**
	 * Indica si el marcador es permanente
	 */
	private boolean permanente;

	/**
	 * Tipo de marcador
	 */
	private String tipoMarcador;

	/**
	 * Lista de opciones de presentación del marcador
	 */
	private ArrayList<String> opcionesPresentacion;

	/**
	 * Lista de opciones de tipo de punta del marcador
	 */
	private ArrayList<String> opcionesPunta;

	/**
	 * Lista de opciones de tipo de marcador
	 */
	private ArrayList<String> opcionesTipo;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para presentación, tipo de punta y tipo de marcador
	 */
	@PostConstruct
	public void init() {
		opcionesPresentacion= new ArrayList<String>();
		opcionesPunta= new ArrayList<String>();
		opcionesTipo= new ArrayList<String>();
		opcionesPresentacion.add("Unidad");
		opcionesPresentacion.add("Paquete/Blister");
		opcionesPresentacion.add("Caja");
		opcionesPresentacion.add("Rollo");
		opcionesPresentacion.add("Kit");
		opcionesPunta.add("Redonda");
		opcionesPunta.add("Cónica");
		opcionesPunta.add("Plana");
		opcionesPunta.add("Fina");
		opcionesPunta.add("Pincel");
		opcionesTipo.add("Permanente");
		opcionesTipo.add("Textil");
		opcionesTipo.add("Resaltador");
		opcionesTipo.add("Borrable");
		opcionesTipo.add("Acuarelable");
	}

	/**
	 * Guarda un nuevo producto de marcador utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new MarcadorDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, presentacion, tipoPunta, permanente, tipoMarcador));
	}

	/**
	 * Obtiene el nombre del producto de marcador
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de marcador
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de marcador
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de marcador
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de marcador
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de marcador
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de marcador
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de marcador
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de marcador
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de marcador
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de marcador
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de marcador
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene la presentación del producto de marcador
	 * @return La presentación del producto
	 */
	public String getPresentacion() {
		return presentacion;
	}

	/**
	 * Establece la presentación del producto de marcador
	 * @param presentacion La presentación del producto
	 */
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	/**
	 * Obtiene el tipo de punta del marcador
	 * @return El tipo de punta
	 */
	public String getTipoPunta() {
		return tipoPunta;
	}

	/**
	 * Establece el tipo de punta del marcador
	 * @param tipoPunta El tipo de punta
	 */
	public void setTipoPunta(String tipoPunta) {
		this.tipoPunta = tipoPunta;
	}

	/**
	 * Indica si el marcador es permanente
	 * @return Verdadero si es permanente, falso en caso contrario
	 */
	public boolean isPermanente() {
		return permanente;
	}

	/**
	 * Establece si el marcador es permanente
	 * @param permanente Verdadero si es permanente, falso en caso contrario
	 */
	public void setPermanente(boolean permanente) {
		this.permanente = permanente;
	}

	/**
	 * Obtiene el tipo de marcador
	 * @return El tipo de marcador
	 */
	public String getTipoMarcador() {
		return tipoMarcador;
	}

	/**
	 * Establece el tipo de marcador
	 * @param tipoMarcador El tipo de marcador
	 */
	public void setTipoMarcador(String tipoMarcador) {
		this.tipoMarcador = tipoMarcador;
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
	 * Obtiene la lista de opciones de tipo de punta
	 * @return La lista de opciones de tipo de punta
	 */
	public ArrayList<String> getOpcionesPunta() {
		return opcionesPunta;
	}

	/**
	 * Establece la lista de opciones de tipo de punta
	 * @param opcionesPunta La lista de opciones de tipo de punta
	 */
	public void setOpcionesPunta(ArrayList<String> opcionesPunta) {
		this.opcionesPunta = opcionesPunta;
	}

	/**
	 * Obtiene la lista de opciones de tipo de marcador
	 * @return La lista de opciones de tipo de marcador
	 */
	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	/**
	 * Establece la lista de opciones de tipo de marcador
	 * @param opcionesTipo La lista de opciones de tipo de marcador
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
	 * Representación en cadena del objeto FormMarcadorBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormMarcadorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", presentacion=" + presentacion
				+ ", tipoPunta=" + tipoPunta + ", permanente=" + permanente + ", tipoMarcador=" + tipoMarcador + "]";
	}
}