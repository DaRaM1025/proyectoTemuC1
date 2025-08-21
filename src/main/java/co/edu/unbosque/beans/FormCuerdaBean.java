/**
 * Clase que representa el bean de la vista para la gestión de productos de instrumentos de cuerda
 * Permite registrar y gestionar los atributos de un producto de instrumento de cuerda
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoCuerdaDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de instrumentos de cuerda
 */
@Named("cuerdaBean")
@ViewScoped
public class FormCuerdaBean implements Serializable {

	/**
	 * Nombre del producto de instrumento de cuerda
	 */
	private String nombre;

	/**
	 * Marca del producto de instrumento de cuerda
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Instrumento Musical de Cuerda"
	 */
	private String tipoProducto="Instrumento Musical de Cuerda";

	/**
	 * Descripción del producto de instrumento de cuerda
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de instrumento de cuerda
	 */
	private String imagen="https://img.freepik.com/foto-gratis/vista-cerca-mujer-guitara_23-2148201743.jpg";

	/**
	 * Precio del producto de instrumento de cuerda
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de instrumento de cuerda
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de instrumento de cuerda
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Indica si el instrumento incluye estuche
	 */
	private boolean incluyeEstuche;

	/**
	 * Tipo de instrumento de cuerda
	 */
	private String tipoInstrumentoCuerda;

	/**
	 * Número de cuerdas del instrumento
	 */
	private int numeroCuerdas;

	/**
	 * Tipo de cuerda del instrumento
	 */
	private String tipoCuerda;

	/**
	 * Indica si el instrumento tiene caja de resonancia
	 */
	private boolean cajaResonancia;

	/**
	 * Lista de opciones de tipo de instrumento de cuerda
	 */
	private ArrayList<String> opcionesInstrumento;

	/**
	 * Lista de opciones de tipo de cuerda
	 */
	private ArrayList<String> opcionesTipo;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para tipo de instrumento y tipo de cuerda
	 */
	@PostConstruct
	public void init() {
		opcionesInstrumento= new ArrayList<String>();
		opcionesTipo= new ArrayList<String>();
		opcionesInstrumento.add("Guitarra");
		opcionesInstrumento.add("Bajo");
		opcionesInstrumento.add("Violín");
		opcionesInstrumento.add("Viola");
		opcionesInstrumento.add("Violonchelo");
		opcionesInstrumento.add("Contrabajo");
		opcionesInstrumento.add("Ukelele");
		opcionesInstrumento.add("Banjo");
		opcionesInstrumento.add("Mandolina");
		opcionesInstrumento.add("Arpa");
		opcionesTipo.add("Nylon");
		opcionesTipo.add("Acero");
		opcionesTipo.add("Tripas");
		opcionesTipo.add("Entorchadas");
		opcionesTipo.add("Carbono");
	}

	/**
	 * Guarda un nuevo producto de instrumento de cuerda utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new InstrumentoCuerdaDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, incluyeEstuche, tipoInstrumentoCuerda, numeroCuerdas, tipoCuerda, cajaResonancia));
	}

	/**
	 * Obtiene el nombre del producto de instrumento de cuerda
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de instrumento de cuerda
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de instrumento de cuerda
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de instrumento de cuerda
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de instrumento de cuerda
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de instrumento de cuerda
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de instrumento de cuerda
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de instrumento de cuerda
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de instrumento de cuerda
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de instrumento de cuerda
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de instrumento de cuerda
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de instrumento de cuerda
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
	 * Obtiene el tipo de instrumento de cuerda
	 * @return El tipo de instrumento
	 */
	public String getTipoInstrumentoCuerda() {
		return tipoInstrumentoCuerda;
	}

	/**
	 * Establece el tipo de instrumento de cuerda
	 * @param tipoInstrumentoCuerda El tipo de instrumento
	 */
	public void setTipoInstrumentoCuerda(String tipoInstrumentoCuerda) {
		this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
	}

	/**
	 * Obtiene el número de cuerdas del instrumento
	 * @return El número de cuerdas
	 */
	public int getNumeroCuerdas() {
		return numeroCuerdas;
	}

	/**
	 * Establece el número de cuerdas del instrumento
	 * @param numeroCuerdas El número de cuerdas
	 */
	public void setNumeroCuerdas(int numeroCuerdas) {
		this.numeroCuerdas = numeroCuerdas;
	}

	/**
	 * Obtiene el tipo de cuerda del instrumento
	 * @return El tipo de cuerda
	 */
	public String getTipoCuerda() {
		return tipoCuerda;
	}

	/**
	 * Establece el tipo de cuerda del instrumento
	 * @param tipoCuerda El tipo de cuerda
	 */
	public void setTipoCuerda(String tipoCuerda) {
		this.tipoCuerda = tipoCuerda;
	}

	/**
	 * Indica si el instrumento tiene caja de resonancia
	 * @return Verdadero si tiene caja de resonancia, falso en caso contrario
	 */
	public boolean isCajaResonancia() {
		return cajaResonancia;
	}

	/**
	 * Establece si el instrumento tiene caja de resonancia
	 * @param cajaResonancia Verdadero si tiene caja de resonancia, falso en caso contrario
	 */
	public void setCajaResonancia(boolean cajaResonancia) {
		this.cajaResonancia = cajaResonancia;
	}

	/**
	 * Obtiene la lista de opciones de tipo de instrumento
	 * @return La lista de opciones de tipo de instrumento
	 */
	public ArrayList<String> getOpcionesInstrumento() {
		return opcionesInstrumento;
	}

	/**
	 * Establece la lista de opciones de tipo de instrumento
	 * @param opcionesInstrumento La lista de opciones de tipo de instrumento
	 */
	public void setOpcionesInstrumento(ArrayList<String> opcionesInstrumento) {
		this.opcionesInstrumento = opcionesInstrumento;
	}

	/**
	 * Obtiene la lista de opciones de tipo de cuerda
	 * @return La lista de opciones de tipo de cuerda
	 */
	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	/**
	 * Establece la lista de opciones de tipo de cuerda
	 * @param opcionesTipo La lista de opciones de tipo de cuerda
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
	 * Representación en cadena del objeto FormCuerdaBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormCuerdaBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", incluyeEstuche=" + incluyeEstuche
				+ ", tipoInstrumentoCuerda=" + tipoInstrumentoCuerda + ", numeroCuerdas=" + numeroCuerdas
				+ ", tipoCuerda=" + tipoCuerda + ", cajaResonancia=" + cajaResonancia + "]";
	}
}