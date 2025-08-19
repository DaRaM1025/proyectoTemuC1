package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("percusionBean")
@ViewScoped
public class FormPercusionBean implements Serializable{

	 private String nombre;
	    private String marca;
	    private String descripcion;
	    private String imagen; 
	    private double precio;
	    private int cantidad;
	    private boolean incluyeEstuche;
	    private String tipoInstrumentoPercusion;
	    private boolean usoBaquetas;
	    private String tipoPercusion;
	    private int cantSuperficiesSonoras;
	    
	    private ArrayList<String> opcionesInstrumento;
	    private ArrayList<String> opcionesTipo;
	    @PostConstruct
	     public void init() {
	    	opcionesInstrumento= new ArrayList<String>();
	    	opcionesTipo= new ArrayList<String>();
	    	opcionesInstrumento.add("Batería");
	    	opcionesInstrumento.add("Tambor");
	    	opcionesInstrumento.add("Bongó");
	    	opcionesInstrumento.add("Conga");
	    	opcionesInstrumento.add("Cajón");
	    	opcionesInstrumento.add("Timbal");
	    	opcionesInstrumento.add("Xilófono");
	    	opcionesInstrumento.add("Marimba");
	    	opcionesInstrumento.add("Platillos");
	    	opcionesInstrumento.add("Triángulo");
	    	opcionesTipo.add("Membranófonos");
	    	opcionesTipo.add("Idiófonos");
	    	opcionesTipo.add("Electrónicos");
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
		public String getTipoInstrumentoPercusion() {
			return tipoInstrumentoPercusion;
		}
		public void setTipoInstrumentoPercusion(String tipoInstrumentoPercusion) {
			this.tipoInstrumentoPercusion = tipoInstrumentoPercusion;
		}
		public boolean isUsoBaquetas() {
			return usoBaquetas;
		}
		public void setUsoBaquetas(boolean usoBaquetas) {
			this.usoBaquetas = usoBaquetas;
		}
		public String getTipoPercusion() {
			return tipoPercusion;
		}
		public void setTipoPercusion(String tipoPercusion) {
			this.tipoPercusion = tipoPercusion;
		}
		public int getCantSuperficiesSonoras() {
			return cantSuperficiesSonoras;
		}
		public void setCantSuperficiesSonoras(int cantSuperficiesSonoras) {
			this.cantSuperficiesSonoras = cantSuperficiesSonoras;
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
			return "FormPercusionBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion
					+ ", imagen=" + imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", incluyeEstuche="
					+ incluyeEstuche + ", tipoInstrumentoPercusion=" + tipoInstrumentoPercusion + ", usoBaquetas="
					+ usoBaquetas + ", tipoPercusion=" + tipoPercusion + ", cantSuperficiesSonoras="
					+ cantSuperficiesSonoras + "]";
		}
	    
	    
	    
	
}
