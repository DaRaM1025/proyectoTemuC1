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
@Named("correctorBean")
@ViewScoped
public class FormCorrectorBean implements Serializable{

	private String nombre;
    private String marca;
    private String tipoProducto="Corrector";
    private String descripcion;
    private String imagen="https://img.freepik.com/foto-gratis/vista-superior-sobre-empaque-base_52683-94666.jpg"; 
    private double precio;
    private int cantidad;
    private String id=UUID.randomUUID().toString();
    private String tipoPiel;
    private boolean pruebaAgua;
    private LocalDate fechaVencimiento;
    private String coberturaCorrector;
    private String formatoCorrector;
    private ArrayList<String>opcionesPiel;
    private ArrayList<String>opcionesCobertura;
    private ArrayList<String>opcionesFormato;
    @Inject
    private CrudService crudSer;
   @PostConstruct
    public void init() {
    	opcionesPiel=new ArrayList<String>();
    	opcionesFormato=new ArrayList<String>();
    	opcionesCobertura=new ArrayList<String>();
    	opcionesPiel.add("Grasa");
    	opcionesPiel.add("Seca ");
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
    
    public void guardar() {
    	System.out.println(toString());
    	crudSer.agregarProducto(new CorrectorDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, tipoPiel, pruebaAgua, descripcion, coberturaCorrector, formatoCorrector));
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
	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public String getCoberturaCorrector() {
		return coberturaCorrector;
	}
	public void setCoberturaCorrector(String coberturaCorrector) {
		this.coberturaCorrector = coberturaCorrector;
	}
	public String getFormatoCorrector() {
		return formatoCorrector;
	}
	public void setFormatoCorrector(String formatoCorrector) {
		this.formatoCorrector = formatoCorrector;
	}
	@Override
	public String toString() {
		return "FormCorrectorBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", tipoPiel=" + tipoPiel + ", pruebaAgua="
				+ pruebaAgua + ", fechaVencimiento=" + fechaVencimiento + ", coberturaCorrector=" + coberturaCorrector
				+ ", formatoCorrector=" + formatoCorrector + "]";
	}

	public ArrayList<String> getOpcionesPiel() {
		return opcionesPiel;
	}

	public void setOpcionesPiel(ArrayList<String> opcionesPiel) {
		this.opcionesPiel = opcionesPiel;
	}

	public ArrayList<String> getOpcionesCobertura() {
		return opcionesCobertura;
	}

	public void setOpcionesCobertura(ArrayList<String> opcionesCobertura) {
		this.opcionesCobertura = opcionesCobertura;
	}

	public ArrayList<String> getOpcionesFormato() {
		return opcionesFormato;
	}

	public void setOpcionesFormato(ArrayList<String> opcionesFormato) {
		this.opcionesFormato = opcionesFormato;
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
