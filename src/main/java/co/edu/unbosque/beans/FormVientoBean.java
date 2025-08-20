package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoVientoDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("vientoBean")
@ViewScoped
public class FormVientoBean implements Serializable {

	private String nombre;
	private String marca;
	private String tipoProducto="Instrumento de Viento";
	private String descripcion;
	private String imagen="https://img.freepik.com/foto-gratis/trompeta-manos_23-2147624318.jpg";
	private double precio;
	private int cantidad;
	private String id=UUID.randomUUID().toString();
	private boolean incluyeEstuche;
	private String tipoInstrumentoViento;
	private String afinacion;
	private int numValvulas;
	private boolean boquillas;

	private ArrayList<String> opcionesInstrumento;
	private ArrayList<String> opcionesAfinacion;
	 @Inject
	    private CrudService crudSer;
	    
	@PostConstruct
	public void init() {
		opcionesInstrumento = new ArrayList<String>();
		opcionesAfinacion= new ArrayList<String>();
		opcionesInstrumento.add("Corno Fránces");
		opcionesInstrumento.add("Corneta");
		opcionesInstrumento.add("Clarinete");
		opcionesInstrumento.add("Fagot");
		opcionesInstrumento.add("Flauta");
		opcionesInstrumento.add("Oboe");
		opcionesInstrumento.add("Tuba");
		opcionesInstrumento.add("Trombón");
		opcionesInstrumento.add("Trompeta");
		opcionesInstrumento.add("Saxofón");
		opcionesAfinacion.add("Do (C)");
		opcionesAfinacion.add("Re (D)");
		opcionesAfinacion.add("Mi♭ (Eb)");
		opcionesAfinacion.add("Fa (F)");
		opcionesAfinacion.add("Sol (G)");
		opcionesAfinacion.add("Si♭ (Bb)");
	}

	public void guardar() {
		System.out.println(toString());
		crudSer.agregarProducto(new InstrumentoVientoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, incluyeEstuche, tipoInstrumentoViento, afinacion, numValvulas, boquillas));
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isIncluyeEstuche() {
		return incluyeEstuche;
	}

	public void setIncluyeEstuche(boolean incluyeEstuche) {
		this.incluyeEstuche = incluyeEstuche;
	}

	public String getTipoInstrumentoViento() {
		return tipoInstrumentoViento;
	}

	public void setTipoInstrumentoViento(String tipoInstrumentoViento) {
		this.tipoInstrumentoViento = tipoInstrumentoViento;
	}

	public String getAfinacion() {
		return afinacion;
	}

	public void setAfinacion(String afinacion) {
		this.afinacion = afinacion;
	}

	public int getNumValvulas() {
		return numValvulas;
	}

	public void setNumValvulas(int numValvulas) {
		this.numValvulas = numValvulas;
	}

	public boolean isBoquillas() {
		return boquillas;
	}

	public void setBoquillas(boolean boquillas) {
		this.boquillas = boquillas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getOpcionesInstrumento() {
		return opcionesInstrumento;
	}

	public void setOpcionesInstrumento(ArrayList<String> opcionesInstrumento) {
		this.opcionesInstrumento = opcionesInstrumento;
	}

	public ArrayList<String> getOpcionesAfinacion() {
		return opcionesAfinacion;
	}

	public void setOpcionesAfinacion(ArrayList<String> opcionesAfinacion) {
		this.opcionesAfinacion = opcionesAfinacion;
	}

	
	
	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CrudService getCrudSer() {
		return crudSer;
	}

	public void setCrudSer(CrudService crudSer) {
		this.crudSer = crudSer;
	}

	@Override
	public String toString() {
		return "FormVientoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", incluyeEstuche=" + incluyeEstuche
				+ ", tipoInstrumentoViento=" + tipoInstrumentoViento + ", afinacion=" + afinacion + ", numValvulas="
				+ numValvulas + ", boquillas=" + boquillas + "]";
	}

}
