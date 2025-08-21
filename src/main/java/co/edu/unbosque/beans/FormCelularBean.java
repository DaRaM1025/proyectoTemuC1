/**
 * Clase que representa el bean de la vista para la gestión de productos de celular
 * Permite registrar y gestionar los atributos de un producto de celular
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CelularDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de celular
 */
@Named("celularBean")
@ViewScoped
public class FormCelularBean implements Serializable {

	/**
	 * Nombre del producto de celular
	 */
	private String nombre;

	/**
	 * Marca del producto de celular
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Celular"
	 */
	private String tipoProducto="Celular";

	/**
	 * Descripción del producto de celular
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de celular
	 */
	private String imagen="https://img.freepik.com/foto-gratis/composicion-elegante-telefono-inteligente_23-2149437106.jpg";

	/**
	 * Precio del producto de celular
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de celular
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de celular
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Tamaño de la pantalla del celular en pulgadas
	 */
	private double pulgadas;

	/**
	 * Resolución de la pantalla del celular
	 */
	private String resolucion;

	/**
	 * Tipo de producto específico, fijo como "SmartPhone"
	 */
	private String tipoProductoC="SmartPhone";

	/**
	 * Sistema operativo del celular
	 */
	private String sistemaOperativo;

	/**
	 * Capacidad de almacenamiento del celular
	 */
	private String almacenamientoCel;

	/**
	 * Cantidad de memoria RAM del celular
	 */
	private String ramCel;

	/**
	 * Número de cámaras del celular
	 */
	private int camaras;

	/**
	 * Indica si el celular soporta dual SIM
	 */
	private boolean dualSim;

	/**
	 * Lista de opciones de resolución de pantalla
	 */
	private ArrayList<String> opcionesResolucion;

	/**
	 * Lista de opciones de sistema operativo
	 */
	private ArrayList<String> opcionesSistema;

	/**
	 * Lista de opciones de capacidad de almacenamiento
	 */
	private ArrayList<String> opcionesAlmacenamiento;

	/**
	 * Lista de opciones de memoria RAM
	 */
	private ArrayList<String> opcionesRam;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para resolución, sistema operativo, almacenamiento y RAM del celular
	 */
	@PostConstruct
	public void init() {
		opcionesResolucion=new ArrayList<String>();
		opcionesSistema= new ArrayList<String>();
		opcionesAlmacenamiento= new ArrayList<String>();
		opcionesRam= new ArrayList<String>();
		opcionesResolucion.add("HD (1280x720)");
		opcionesResolucion.add("Full HD (1920x1080)");
		opcionesResolucion.add("2K/QHD (2560x1440)");
		opcionesResolucion.add("4K UHD (3840x2160)");
		opcionesResolucion.add("8K UHD (7680x4320)");
		opcionesSistema.add("Android");
		opcionesSistema.add("iOS");
		opcionesSistema.add("HarmonyOS");
		opcionesSistema.add("KaiOS");
		opcionesSistema.add("Windows");
		opcionesSistema.add("macOS");
		opcionesSistema.add("Linux");
		opcionesSistema.add("ChromeOS");
		opcionesSistema.add("AndroidTV");
		opcionesSistema.add("webOS");
		opcionesSistema.add("Tyzen");
		opcionesSistema.add("FireOS");
		opcionesAlmacenamiento.add("64 GB");
		opcionesAlmacenamiento.add("128 GB");
		opcionesAlmacenamiento.add("256 GB");
		opcionesAlmacenamiento.add("512 GB");
		opcionesAlmacenamiento.add("1 TB");
		opcionesRam.add("4 GB");
		opcionesRam.add("6 GB");
		opcionesRam.add("8 GB");
		opcionesRam.add("12 GB");
		opcionesRam.add("16 GB");
	}

	/**
	 * Guarda un nuevo producto de celular utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new CelularDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, pulgadas, resolucion, sistemaOperativo, almacenamientoCel, ramCel, camaras, dualSim));
	}

	/**
	 * Obtiene el nombre del producto de celular
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de celular
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de celular
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de celular
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de celular
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de celular
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de celular
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de celular
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de celular
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de celular
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de celular
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de celular
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el tamaño de la pantalla del celular en pulgadas
	 * @return El tamaño de la pantalla en pulgadas
	 */
	public double getPulgadas() {
		return pulgadas;
	}

	/**
	 * Establece el tamaño de la pantalla del celular en pulgadas
	 * @param pulgadas El tamaño de la pantalla en pulgadas
	 */
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	/**
	 * Obtiene la resolución de la pantalla del celular
	 * @return La resolución de la pantalla
	 */
	public String getResolucion() {
		return resolucion;
	}

	/**
	 * Establece la resolución de la pantalla del celular
	 * @param resolucion La resolución de la pantalla
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	/**
	 * Obtiene el sistema operativo del celular
	 * @return El sistema operativo
	 */
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	/**
	 * Establece el sistema operativo del celular
	 * @param sistemaOperativo El sistema operativo
	 */
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	/**
	 * Obtiene la capacidad de almacenamiento del celular
	 * @return La capacidad de almacenamiento
	 */
	public String getAlmacenamientoCel() {
		return almacenamientoCel;
	}

	/**
	 * Establece la capacidad de almacenamiento del celular
	 * @param almacenamientoCel La capacidad de almacenamiento
	 */
	public void setAlmacenamientoCel(String almacenamientoCel) {
		this.almacenamientoCel = almacenamientoCel;
	}

	/**
	 * Obtiene la cantidad de memoria RAM del celular
	 * @return La cantidad de memoria RAM
	 */
	public String getRamCel() {
		return ramCel;
	}

	/**
	 * Establece la cantidad de memoria RAM del celular
	 * @param ramCel La cantidad de memoria RAM
	 */
	public void setRamCel(String ramCel) {
		this.ramCel = ramCel;
	}

	/**
	 * Obtiene el número de cámaras del celular
	 * @return El número de cámaras
	 */
	public int getCamaras() {
		return camaras;
	}

	/**
	 * Establece el número de cámaras del celular
	 * @param camaras El número de cámaras
	 */
	public void setCamaras(int camaras) {
		this.camaras = camaras;
	}

	/**
	 * Indica si el celular soporta dual SIM
	 * @return Verdadero si soporta dual SIM, falso en caso contrario
	 */
	public boolean isDualSim() {
		return dualSim;
	}

	/**
	 * Establece si el celular soporta dual SIM
	 * @param dualSim Verdadero si soporta dual SIM, falso en caso contrario
	 */
	public void setDualSim(boolean dualSim) {
		this.dualSim = dualSim;
	}

	/**
	 * Obtiene la lista de opciones de resolución de pantalla
	 * @return La lista de opciones de resolución
	 */
	public ArrayList<String> getOpcionesResolucion() {
		return opcionesResolucion;
	}

	/**
	 * Establece la lista de opciones de resolución de pantalla
	 * @param opcionesResolucion La lista de opciones de resolución
	 */
	public void setOpcionesResolucion(ArrayList<String> opcionesResolucion) {
		this.opcionesResolucion = opcionesResolucion;
	}

	/**
	 * Obtiene la lista de opciones de sistema operativo
	 * @return La lista de opciones de sistema operativo
	 */
	public ArrayList<String> getOpcionesSistema() {
		return opcionesSistema;
	}

	/**
	 * Establece la lista de opciones de sistema operativo
	 * @param opcionesSistema La lista de opciones de sistema operativo
	 */
	public void setOpcionesSistema(ArrayList<String> opcionesSistema) {
		this.opcionesSistema = opcionesSistema;
	}

	/**
	 * Obtiene la lista de opciones de capacidad de almacenamiento
	 * @return La lista de opciones de almacenamiento
	 */
	public ArrayList<String> getOpcionesAlmacenamiento() {
		return opcionesAlmacenamiento;
	}

	/**
	 * Establece la lista de opciones de capacidad de almacenamiento
	 * @param opcionesAlmacenamiento La lista de opciones de almacenamiento
	 */
	public void setOpcionesAlmacenamiento(ArrayList<String> opcionesAlmacenamiento) {
		this.opcionesAlmacenamiento = opcionesAlmacenamiento;
	}

	/**
	 * Obtiene la lista de opciones de memoria RAM
	 * @return La lista de opciones de RAM
	 */
	public ArrayList<String> getOpcionesRam() {
		return opcionesRam;
	}

	/**
	 * Establece la lista de opciones de memoria RAM
	 * @param opcionesRam La lista de opciones de RAM
	 */
	public void setOpcionesRam(ArrayList<String> opcionesRam) {
		this.opcionesRam = opcionesRam;
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
	 * Obtiene el tipo de producto específico
	 * @return El tipo de producto específico
	 */
	public String getTipoProductoC() {
		return tipoProductoC;
	}

	/**
	 * Establece el tipo de producto específico
	 * @param tipoProductoC El tipo de producto específico
	 */
	public void setTipoProductoC(String tipoProductoC) {
		this.tipoProductoC = tipoProductoC;
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
	 * Representación en cadena del objeto FormCelularBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormCelularBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", pulgadas=" + pulgadas + ", resolucion="
				+ resolucion + ", sistemaOperativo=" + sistemaOperativo + ", almacenamientoCel=" + almacenamientoCel
				+ ", ramCel=" + ramCel + ", camaras=" + camaras + ", dualSim=" + dualSim + "]";
	}
}