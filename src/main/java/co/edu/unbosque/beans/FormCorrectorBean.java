/**
 * Clase que representa el bean de la vista para la gestión de productos de corrector
 * Permite registrar y gestionar los atributos de un producto de corrector
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CorrectorDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de corrector
 */
@Named("correctorBean")
@ViewScoped
public class FormCorrectorBean implements Serializable {

	/**
	 * Nombre del producto de corrector
	 */
	private String nombre;

	/**
	 * Marca del producto de corrector
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Corrector"
	 */
	private String tipoProducto="Corrector";

	/**
	 * Descripción del producto de corrector
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de corrector
	 */
	private String imagen="https://img.freepik.com/foto-gratis/vista-superior-sobre-empaque-base_52683-94666.jpg";

	/**
	 * Precio del producto de corrector
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de corrector
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de corrector
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Tipo de piel para el cual está diseñado el corrector
	 */
	private String tipoPiel;

	/**
	 * Indica si el corrector es resistente al agua
	 */
	private boolean pruebaAgua;

	/**
	 * Fecha de vencimiento del corrector
	 */
	private String fechaVencimiento;

	/**
	 * Nivel de cobertura del corrector
	 */
	private String coberturaCorrector;

	/**
	 * Formato del corrector
	 */
	private String formatoCorrector;

	/**
	 * Lista de opciones de tipo de piel
	 */
	private ArrayList<String> opcionesPiel;

	/**
	 * Lista de opciones de cobertura
	 */
	private ArrayList<String> opcionesCobertura;

	/**
	 * Lista de opciones de formato
	 */
	private ArrayList<String> opcionesFormato;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para tipo de piel, cobertura y formato del corrector
	 */
	@PostConstruct
	public void init() {
		opcionesPiel=new ArrayList<String>();
		opcionesFormato=new ArrayList<String>();
		opcionesCobertura=new ArrayList<String>();
		opcionesPiel.add("Grasa");
		opcionesPiel.add("Seca");
		opcionesPiel.add("Mixta");
		opcionesFormato.add("Mousse");
		opcionesFormato.add("Líquido");
		opcionesFormato.add("Cushion");
		opcionesFormato.add("Barra");
		opcionesFormato.add("Crema");
		opcionesCobertura.add("Ligera");
		opcionesCobertura.add("Media");
		opcionesCobertura.add("Alta");
		opcionesCobertura.add("Total");
	}

	/**
	 * Guarda un nuevo producto de corrector utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new CorrectorDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, tipoPiel, pruebaAgua, descripcion, coberturaCorrector, formatoCorrector));
	}

	/**
	 * Obtiene el nombre del producto de corrector
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de corrector
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de corrector
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de corrector
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de corrector
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de corrector
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de corrector
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de corrector
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de corrector
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de corrector
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de corrector
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de corrector
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el tipo de piel para el corrector
	 * @return El tipo de piel
	 */
	public String getTipoPiel() {
		return tipoPiel;
	}

	/**
	 * Establece el tipo de piel para el corrector
	 * @param tipoPiel El tipo de piel
	 */
	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	/**
	 * Indica si el corrector es resistente al agua
	 * @return Verdadero si es resistente al agua, falso en caso contrario
	 */
	public boolean isPruebaAgua() {
		return pruebaAgua;
	}

	/**
	 * Establece si el corrector es resistente al agua
	 * @param pruebaAgua Verdadero si es resistente al agua, falso en caso contrario
	 */
	public void setPruebaAgua(boolean pruebaAgua) {
		this.pruebaAgua = pruebaAgua;
	}

	/**
	 * Obtiene la fecha de vencimiento del corrector
	 * @return La fecha de vencimiento
	 */
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * Establece la fecha de vencimiento del corrector
	 * @param fechaVencimiento La fecha de vencimiento
	 */
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * Obtiene el nivel de cobertura del corrector
	 * @return El nivel de cobertura
	 */
	public String getCoberturaCorrector() {
		return coberturaCorrector;
	}

	/**
	 * Establece el nivel de cobertura del corrector
	 * @param coberturaCorrector El nivel de cobertura
	 */
	public void setCoberturaCorrector(String coberturaCorrector) {
		this.coberturaCorrector = coberturaCorrector;
	}

	/**
	 * Obtiene el formato del corrector
	 * @return El formato del corrector
	 */
	public String getFormatoCorrector() {
		return formatoCorrector;
	}

	/**
	 * Establece el formato del corrector
	 * @param formatoCorrector El formato del corrector
	 */
	public void setFormatoCorrector(String formatoCorrector) {
		this.formatoCorrector = formatoCorrector;
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
	 * Obtiene la lista de opciones de cobertura
	 * @return La lista de opciones de cobertura
	 */
	public ArrayList<String> getOpcionesCobertura() {
		return opcionesCobertura;
	}

	/**
	 * Establece la lista de opciones de cobertura
	 * @param opcionesCobertura La lista de opciones de cobertura
	 */
	public void setOpcionesCobertura(ArrayList<String> opcionesCobertura) {
		this.opcionesCobertura = opcionesCobertura;
	}

	/**
	 * Obtiene la lista de opciones de formato
	 * @return La lista de opciones de formato
	 */
	public ArrayList<String> getOpcionesFormato() {
		return opcionesFormato;
	}

	/**
	 * Establece la lista de opciones de formato
	 * @param opcionesFormato La lista de opciones de formato
	 */
	public void setOpcionesFormato(ArrayList<String> opcionesFormato) {
		this.opcionesFormato = opcionesFormato;
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
	 * Representación en cadena del objeto FormCorrectorBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormCorrectorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", tipoPiel=" + tipoPiel + ", pruebaAgua="
				+ pruebaAgua + ", fechaVencimiento=" + fechaVencimiento + ", coberturaCorrector=" + coberturaCorrector
				+ ", formatoCorrector=" + formatoCorrector + "]";
	}
}