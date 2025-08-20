package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.CalzadoDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@Named(value="calzadoBean")
@ViewScoped
public class FormCalzadoBean implements Serializable {
	private String nombre;
	private String marca;
	 private final String tipoProducto="Calzado";
	private String descripcion;
	private String imagen="https://img.freepik.com/foto-gratis/zapatos-cuero-marron_1203-8175.jpg";
	private double precio;
	private int cantidad;
	private String id=UUID.randomUUID().toString();
	private String talla;
    private String genero;
    private String material;
    private String tipoCalzado;
    private String ocasionCalzado;
    private String suelaCalzado;
    private double alturaSuela;
    
    private ArrayList<String> opcionesGenero;
    private ArrayList<String> opcionesTipo;
    private ArrayList<String> opcionesOcasion;
    private ArrayList<String> opcionesMaterial;
    @Inject
    private CrudService crudSer;
    @PostConstruct
    public void init() {
    	opcionesGenero = new ArrayList<>();
    	opcionesTipo = new ArrayList<>();
    	opcionesOcasion = new ArrayList<>();
    	opcionesMaterial = new ArrayList<>();
		opcionesGenero.add("Mujer");
		opcionesGenero.add("Hombre");
		opcionesGenero.add("Niño");
		opcionesGenero.add("Niña");
		opcionesTipo.add("Tennis");
		opcionesTipo.add("Sandalía");
		opcionesTipo.add("Bota");
		opcionesTipo.add("Tacón");
		opcionesTipo.add("Mocasín");
		opcionesOcasion.add("Casual");
		opcionesOcasion.add("Fiesta");
		opcionesOcasion.add("Formal");
		opcionesOcasion.add("Deportiva");
		opcionesMaterial.add("Poliuretano");
		opcionesMaterial.add("Policloruro de vinilo");
		opcionesMaterial.add("Neopreno");
		opcionesMaterial.add("Yute");
		opcionesMaterial.add("Cuero");
		opcionesMaterial.add("Corcho");
		opcionesMaterial.add("Thermo Rubber");
		opcionesMaterial.add("Espuma");
	}
    
    
    public void guardar() {
    	System.out.println(toString());
    	crudSer.agregarProducto(new CalzadoDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, talla, genero, material, tipoCalzado, ocasionCalzado, suelaCalzado, alturaSuela));
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
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTipoCalzado() {
		return tipoCalzado;
	}
	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}
	public String getOcasionCalzado() {
		return ocasionCalzado;
	}
	public void setOcasionCalzado(String ocasionCalzado) {
		this.ocasionCalzado = ocasionCalzado;
	}
	public String getSuelaCalzado() {
		return suelaCalzado;
	}
	public void setSuelaCalzado(String suelaCalzado) {
		this.suelaCalzado = suelaCalzado;
	}
	public double getAlturaSuela() {
		return alturaSuela;
	}
	public void setAlturaSuela(double alturaSuela) {
		this.alturaSuela = alturaSuela;
	}


	public ArrayList<String> getOpcionesGenero() {
		return opcionesGenero;
	}


	public void setOpcionesGenero(ArrayList<String> opcionesGenero) {
		this.opcionesGenero = opcionesGenero;
	}


	public ArrayList<String> getOpcionesTipo() {
		return opcionesTipo;
	}


	public void setOpcionesTipo(ArrayList<String> opcionesTipo) {
		this.opcionesTipo = opcionesTipo;
	}


	public ArrayList<String> getOpcionesOcasion() {
		return opcionesOcasion;
	}


	public void setOpcionesOcasion(ArrayList<String> opcionesOcasion) {
		this.opcionesOcasion = opcionesOcasion;
	}


	public ArrayList<String> getOpcionesMaterial() {
		return opcionesMaterial;
	}


	public void setOpcionesMaterial(ArrayList<String> opcionesMaterial) {
		this.opcionesMaterial = opcionesMaterial;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTipoProducto() {
		return tipoProducto;
	}


	public CrudService getCrudSer() {
		return crudSer;
	}


	public void setCrudSer(CrudService crudSer) {
		this.crudSer = crudSer;
	}


	@Override
	public String toString() {
		return "FormCalzadoBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", talla=" + talla + ", genero=" + genero
				+ ", material=" + material + ", tipoCalzado=" + tipoCalzado + ", ocasionCalzado=" + ocasionCalzado
				+ ", suelaCalzado=" + suelaCalzado + ", alturaSuela=" + alturaSuela ;
	}

    
    
}
