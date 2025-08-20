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
@Named("sombraBean")
@ViewScoped
public class FormSombraBean implements Serializable {
	private String nombre;
    private String marca;
    private String tipoProducto="Sombra";
    private String descripcion;
    private String imagen="https://img.freepik.com/foto-gratis/vista-paleta-sombras-ojos-polvo-cosmetico_23-2150260878.jpg"; 
    private double precio;
    private int cantidad;
    private String id=UUID.randomUUID().toString();
    private String tipoPiel;
    private boolean pruebaAgua;
    private String fechaVencimiento;
    private int cantidadColores;
    private String acabadoSombras;
    private ArrayList<String>opcionesPiel;
    private ArrayList<String>opcionesAcabado;
    @Inject
    private CrudService crudSer;
    @PostConstruct
    public void init() {
    	opcionesPiel= new ArrayList<String>();
    	opcionesAcabado= new ArrayList<String>();
    	opcionesPiel=new ArrayList<String>();
    	opcionesPiel.add("Grasa");
    	opcionesPiel.add("Seca ");
    	opcionesPiel.add("Mixta");
    	opcionesAcabado.add("Mate");
    	opcionesAcabado.add("Satinado");
    	opcionesAcabado.add("Shimmer");
    	opcionesAcabado.add("Holográfico");
    	opcionesAcabado.add("Perlado");
    	opcionesAcabado.add("Metálico");
    }
    
    
    public void guardar() {
    	System.out.println(toString());
    	crudSer.agregarProducto(new SombraDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, tipoPiel, pruebaAgua, descripcion, cantidadColores, acabadoSombras));
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
	public int getCantidadColores() {
		return cantidadColores;
	}
	public void setCantidadColores(int cantidadColores) {
		this.cantidadColores = cantidadColores;
	}
	public String getAcabadoSombras() {
		return acabadoSombras;
	}
	public void setAcabadoSombras(String acabadoSombras) {
		this.acabadoSombras = acabadoSombras;
	}
	
	
	public ArrayList<String> getOpcionesPiel() {
		return opcionesPiel;
	}


	public void setOpcionesPiel(ArrayList<String> opcionesPiel) {
		this.opcionesPiel = opcionesPiel;
	}


	public ArrayList<String> getOpcionesAcabado() {
		return opcionesAcabado;
	}


	public void setOpcionesAcabado(ArrayList<String> opcionesAcabado) {
		this.opcionesAcabado = opcionesAcabado;
	}


	@Override
	public String toString() {
		return "FormSombraBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", tipoPiel=" + tipoPiel + ", pruebaAgua="
				+ pruebaAgua + ", fechaVencimiento=" + fechaVencimiento + ", cantidadColores=" + cantidadColores
				+ ", acabadoSombras=" + acabadoSombras + "]";
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
