package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
@Named("cuerdaBean")
@ViewScoped
public class FormCuerdaBean implements Serializable{
	private String nombre;
	private String marca;
    private String descripcion;
    private String imagen; 
    private double precio;
    private int cantidad;
    private boolean incluyeEstuche;
    private String tipoInstrumentoCuerda;
    private int numeroCuerdas;
    private String tipoCuerda;
    private boolean cajaResonancia;
    
    private ArrayList<String> opcionesInstrumento;
    private ArrayList<String> opcionesTipo;
    @PostConstruct
    public void init() {
    	 opcionesInstrumento= new ArrayList<String>();
    	 opcionesTipo= new ArrayList<String>();
    	 opcionesInstrumento.add("Guitarra");
    	 opcionesInstrumento.add("Bajo");
    	 opcionesInstrumento.add("Violìn");
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
    
    public void guardar() {
    	System.out.println(toString());
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
	public boolean isIncluyeEstuche() {
		return incluyeEstuche;
	}
	public void setIncluyeEstuche(boolean incluyeEstuche) {
		this.incluyeEstuche = incluyeEstuche;
	}
	public String getTipoInstrumentoCuerda() {
		return tipoInstrumentoCuerda;
	}
	public void setTipoInstrumentoCuerda(String tipoInstrumentoCuerda) {
		this.tipoInstrumentoCuerda = tipoInstrumentoCuerda;
	}
	public int getNumeroCuerdas() {
		return numeroCuerdas;
	}
	public void setNumeroCuerdas(int numeroCuerdas) {
		this.numeroCuerdas = numeroCuerdas;
	}
	public String getTipoCuerda() {
		return tipoCuerda;
	}
	public void setTipoCuerda(String tipoCuerda) {
		this.tipoCuerda = tipoCuerda;
	}
	public boolean isCajaResonancia() {
		return cajaResonancia;
	}
	public void setCajaResonancia(boolean cajaResonancia) {
		this.cajaResonancia = cajaResonancia;
	}
	
	
	public ArrayList<String> getOpcionesInstrumento() {
		return opcionesInstrumento;
	}

	public void setOpcionesInstrumento(ArrayList<String> opcionesInstrumento) {
		this.opcionesInstrumento = opcionesInstrumento;
	}

	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}

	public void setOpcionesTipo(ArrayList<String> opcionesTipo) {
		this.opcionesTipo = opcionesTipo;
	}

	@Override
	public String toString() {
		return "FormCuerdaBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", incluyeEstuche=" + incluyeEstuche
				+ ", tipoInstrumentoCuerda=" + tipoInstrumentoCuerda + ", numeroCuerdas=" + numeroCuerdas
				+ ", tipoCuerda=" + tipoCuerda + ", cajaResonancia=" + cajaResonancia + "]";
	}
    
   

}
