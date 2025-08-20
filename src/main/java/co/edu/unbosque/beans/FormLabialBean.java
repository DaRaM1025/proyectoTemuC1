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
@Named("labialBean")
@ViewScoped
public class FormLabialBean implements Serializable{

	private String nombre;
    private String marca;
    private String tipoProducto="Labial";
    private String descripcion;
    private String imagen="https://img.freepik.com/foto-gratis/vista-frontal-lapiz-labial-rojo-sobre-fondo-rosa_23-2148320952.jpg"; 
    private double precio;
    private int cantidad;
    private String id=UUID.randomUUID().toString();
    private String tipoPiel;
    private boolean pruebaAgua;
    private String fechaVencimiento;
    private String duracionLabial;
    private boolean hidratante;
    private ArrayList<String>opcionesPiel;
    private ArrayList<String>opcionesDuracion;
    @Inject
    private CrudService crudSer;
   @PostConstruct
    public void init() {
    	opcionesPiel=new ArrayList<String>();
    	opcionesPiel.add("Grasa");
    	opcionesPiel.add("Seca ");
    	opcionesPiel.add("Mixta");
    	opcionesDuracion= new ArrayList<String>();
    	opcionesDuracion.add("Corta (1 a 2 horas)");
    	opcionesDuracion.add("Media (3 a 5 horas)");
    	opcionesDuracion.add("Larga (6 a 8 horas)");
    	opcionesDuracion.add("Ultra (24 horas)");
    	opcionesDuracion.add("No transfer");
    }
    
    public void guardar() {
    	System.out.println(toString());
    	crudSer.agregarProducto(new LabialDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, tipoPiel, pruebaAgua, descripcion, duracionLabial, hidratante));
    }
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getTipoPiel() {
		return tipoPiel;
	}
	public void setTipoPiel(String tipoPiel) {
		this.tipoPiel = tipoPiel;
	}
	public boolean isPruebaAgua() {
		return pruebaAgua;
	}
	public void setPruebaAgua(boolean pruebaAgua) {
		this.pruebaAgua = pruebaAgua;
	}
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getDuracionLabial() {
		return duracionLabial;
	}
	public void setDuracionLabial(String duracionLabial) {
		this.duracionLabial = duracionLabial;
	}
	public boolean isHidratante() {
		return hidratante;
	}
	public void setHidratante(boolean hidratante) {
		this.hidratante = hidratante;
	}
		
	public ArrayList<String> getOpcionesPiel() {
		return opcionesPiel;
	}

	public void setOpcionesPiel(ArrayList<String> opcionesPiel) {
		this.opcionesPiel = opcionesPiel;
	}

	public ArrayList<String> getOpcionesDuracion() {
		return opcionesDuracion;
	}

	public void setOpcionesDuracion(ArrayList<String> opcionesDuracion) {
		this.opcionesDuracion = opcionesDuracion;
	}

	@Override
	public String toString() {
		return "FormLabialBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", tipoPiel=" + tipoPiel + ", pruebaAgua="
				+ pruebaAgua + ", fechaVencimiento=" + fechaVencimiento + ", duracionLabial=" + duracionLabial
				+ ", hidratante=" + hidratante + "]";
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
    
    
    
}
