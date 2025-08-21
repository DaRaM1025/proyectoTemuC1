/**
 * Clase que representa el bean de la vista para la gestión de productos de computador
 * Permite registrar y gestionar los atributos de un producto de computador
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.ComputadorDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Bean de vista para la gestión de formularios de computador
 */
@Named("computadorBean")
@ViewScoped
public class FormComputadorBean implements Serializable {

	/**
	 * Nombre del producto de computador
	 */
	private String nombre;

	/**
	 * Marca del producto de computador
	 */
	private String marca;

	/**
	 * Tipo de producto, fijo como "Computador"
	 */
	private final String tipoProducto="Computador";

	/**
	 * Descripción del producto de computador
	 */
	private String descripcion;

	/**
	 * URL de la imagen del producto de computador
	 */
	private String imagen="https://img.freepik.com/foto-gratis/jugador-alto-angulo-jugando-computadora-portatil_23-2149829167.jpg";

	/**
	 * Precio del producto de computador
	 */
	private double precio;

	/**
	 * Cantidad disponible del producto de computador
	 */
	private int cantidad;

	/**
	 * Identificador único del producto de computador
	 */
	private String id=UUID.randomUUID().toString();

	/**
	 * Tamaño de la pantalla del computador en pulgadas
	 */
	private double pulgadas;

	/**
	 * Resolución de la pantalla del computador
	 */
	private String resolucion;

	/**
	 * Tipo de producto específico, fijo como "Portátil"
	 */
	private final String tipoProductoP="Portátil";

	/**
	 * Sistema operativo del computador
	 */
	private String sistemaOperativo;

	/**
	 * Capacidad de almacenamiento del computador
	 */
	private String almacenamientoPc;

	/**
	 * Cantidad de memoria RAM del computador
	 */
	private String ramPc;

	/**
	 * Procesador del computador
	 */
	private String procesadorPc;

	/**
	 * Tarjeta gráfica del computador
	 */
	private String graficaPc;

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
	 * Lista de opciones de procesador
	 */
	private ArrayList<String> opcionesProcesador;

	/**
	 * Lista de opciones de tarjeta gráfica
	 */
	private ArrayList<String> opcionesTarjeta;

	/**
	 * Servicio para operaciones CRUD inyectado
	 */
	@Inject
	private CrudService crudSer;

	/**
	 * Inicializa las listas de opciones para resolución, sistema operativo, almacenamiento, RAM, procesador y tarjeta gráfica
	 */
	@PostConstruct
	public void init() {
		opcionesResolucion=new ArrayList<String>();
		opcionesSistema= new ArrayList<String>();
		opcionesAlmacenamiento= new ArrayList<String>();
		opcionesRam= new ArrayList<String>();
		opcionesProcesador= new ArrayList<String>();
		opcionesTarjeta=new ArrayList<String>();
		opcionesResolucion.add("HD (1280x720)");
		opcionesResolucion.add("Full HD (1920x1080)");
		opcionesResolucion.add("2K/QHD (2560x1440)");
		opcionesResolucion.add("4K UHD (3840x2160)");
		opcionesResolucion.add("8K UHD (7680x4320)");
		opcionesSistema.add("Windows");
		opcionesSistema.add("macOS");
		opcionesSistema.add("Linux");
		opcionesSistema.add("ChromeOS");
		opcionesAlmacenamiento.add("128 GB");
		opcionesAlmacenamiento.add("256 GB");
		opcionesAlmacenamiento.add("512 GB");
		opcionesAlmacenamiento.add("1 TB");
		opcionesAlmacenamiento.add("2 TB");
		opcionesAlmacenamiento.add("4 TB");
		opcionesAlmacenamiento.add("8 TB");
		opcionesAlmacenamiento.add("16 TB");
		opcionesRam.add("4GB");
		opcionesRam.add("8GB");
		opcionesRam.add("16GB");
		opcionesRam.add("32GB");
		opcionesRam.add("64GB");
		opcionesProcesador.add("INTEL I3");
		opcionesProcesador.add("INTEL I5");
		opcionesProcesador.add("INTEL I7");
		opcionesProcesador.add("AMD RYZEN 5");
		opcionesProcesador.add("AMD RYZEN 7");
		opcionesTarjeta.add("INTEGRADA INTEL");
		opcionesTarjeta.add("NVIDIA GTX 1650");
		opcionesTarjeta.add("NVIDIA RTX 3050");
		opcionesTarjeta.add("NVIDIA RTX 4060");
		opcionesTarjeta.add("AMD RX 6600M");
	}

	/**
	 * Guarda un nuevo producto de computador utilizando el servicio CRUD
	 */
	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new ComputadorDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, pulgadas, resolucion, sistemaOperativo, almacenamientoPc, ramPc, tipoProductoP, procesadorPc, graficaPc));
	}

	/**
	 * Obtiene el nombre del producto de computador
	 * @return El nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto de computador
	 * @param nombre El nombre del producto
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la marca del producto de computador
	 * @return La marca del producto
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Establece la marca del producto de computador
	 * @param marca La marca del producto
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtiene la descripción del producto de computador
	 * @return La descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto de computador
	 * @param descripcion La descripción del producto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene la URL de la imagen del producto de computador
	 * @return La URL de la imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece la URL de la imagen del producto de computador
	 * @param imagen La URL de la imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el precio del producto de computador
	 * @return El precio del producto
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio del producto de computador
	 * @param precio El precio del producto
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad disponible del producto de computador
	 * @return La cantidad disponible
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Establece la cantidad disponible del producto de computador
	 * @param cantidad La cantidad disponible
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el tamaño de la pantalla del computador en pulgadas
	 * @return El tamaño de la pantalla en pulgadas
	 */
	public double getPulgadas() {
		return pulgadas;
	}

	/**
	 * Establece el tamaño de la pantalla del computador en pulgadas
	 * @param pulgadas El tamaño de la pantalla en pulgadas
	 */
	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	/**
	 * Obtiene la resolución de la pantalla del computador
	 * @return La resolución de la pantalla
	 */
	public String getResolucion() {
		return resolucion;
	}

	/**
	 * Establece la resolución de la pantalla del computador
	 * @param resolucion La resolución de la pantalla
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	/**
	 * Obtiene el sistema operativo del computador
	 * @return El sistema operativo
	 */
	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	/**
	 * Establece el sistema operativo del computador
	 * @param sistemaOperativo El sistema operativo
	 */
	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	/**
	 * Obtiene la capacidad de almacenamiento del computador
	 * @return La capacidad de almacenamiento
	 */
	public String getAlmacenamientoPc() {
		return almacenamientoPc;
	}

	/**
	 * Establece la capacidad de almacenamiento del computador
	 * @param almacenamientoPc La capacidad de almacenamiento
	 */
	public void setAlmacenamientoPc(String almacenamientoPc) {
		this.almacenamientoPc = almacenamientoPc;
	}

	/**
	 * Obtiene la cantidad de memoria RAM del computador
	 * @return La cantidad de memoria RAM
	 */
	public String getRamPc() {
		return ramPc;
	}

	/**
	 * Establece la cantidad de memoria RAM del computador
	 * @param ramPc La cantidad de memoria RAM
	 */
	public void setRamPc(String ramPc) {
		this.ramPc = ramPc;
	}

	/**
	 * Obtiene el procesador del computador
	 * @return El procesador
	 */
	public String getProcesadorPc() {
		return procesadorPc;
	}

	/**
	 * Establece el procesador del computador
	 * @param procesadorPc El procesador
	 */
	public void setProcesadorPc(String procesadorPc) {
		this.procesadorPc = procesadorPc;
	}

	/**
	 * Obtiene la tarjeta gráfica del computador
	 * @return La tarjeta gráfica
	 */
	public String getGraficaPc() {
		return graficaPc;
	}

	/**
	 * Establece la tarjeta gráfica del computador
	 * @param graficaPc La tarjeta gráfica
	 */
	public void setGraficaPc(String graficaPc) {
		this.graficaPc = graficaPc;
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
	 * Obtiene la lista de opciones de procesador
	 * @return La lista de opciones de procesador
	 */
	public ArrayList<String> getOpcionesProcesador() {
		return opcionesProcesador;
	}

	/**
	 * Establece la lista de opciones de procesador
	 * @param opcionesProcesador La lista de opciones de procesador
	 */
	public void setOpcionesProcesador(ArrayList<String> opcionesProcesador) {
		this.opcionesProcesador = opcionesProcesador;
	}

	/**
	 * Obtiene la lista de opciones de tarjeta gráfica
	 * @return La lista de opciones de tarjeta gráfica
	 */
	public ArrayList<String> getOpcionesTarjeta() {
		return opcionesTarjeta;
	}

	/**
	 * Establece la lista de opciones de tarjeta gráfica
	 * @param opcionesTarjeta La lista de opciones de tarjeta gráfica
	 */
	public void setOpcionesTarjeta(ArrayList<String> opcionesTarjeta) {
		this.opcionesTarjeta = opcionesTarjeta;
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
	 * Obtiene el tipo de producto específico
	 * @return El tipo de producto específico
	 */
	public String getTipoProductoP() {
		return tipoProductoP;
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
	 * Representación en cadena del objeto FormComputadorBean
	 * @return La representación en cadena del objeto
	 */
	@Override
	public String toString() {
		return "FormComputadorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", pulgadas=" + pulgadas + ", resolucion="
				+ resolucion + ", sistemaOperativo=" + sistemaOperativo + ", almacenamientoPc=" + almacenamientoPc
				+ ", ramPc=" + ramPc + ", procesadorPc=" + procesadorPc + ", graficaPc=" + graficaPc + "]";
	}
}