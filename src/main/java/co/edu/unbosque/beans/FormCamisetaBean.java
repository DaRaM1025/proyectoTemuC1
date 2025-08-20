package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named(value="camisetaBean")
@ViewScoped
public class FormCamisetaBean implements Serializable {

	private String nombre;
	private String marca;
	private String descripcion;
	private String imagen;
	private double precio;
	private int cantidad;
	private String talla;
    private String genero;
    private String material;
    private String mangaCamiseta;
    private String cuelloCamiseta;
    private boolean estampada;
    
    private ArrayList<String> opcionesGenero;
    private ArrayList<String> opcionesManga;
    private ArrayList<String> opcionesCuello;
    @PostConstruct
    public void init() {
    	opcionesGenero = new ArrayList<>();
    	opcionesManga = new ArrayList<>();
    	opcionesCuello = new ArrayList<>();
		opcionesGenero.add("Mujer");
		opcionesGenero.add("Hombre");
		opcionesGenero.add("Niño");
		opcionesGenero.add("Niña");
		opcionesManga.add("Manga Corta");
		opcionesManga.add("Manga Larga");
		opcionesManga.add("Manga 3/4");
		opcionesManga.add("Sin Mangas");
		opcionesCuello.add("Cuello Redondo");
		opcionesCuello.add("Cuello en V");
		opcionesCuello.add("Cuello Polo");
		opcionesCuello.add("Cuello TortugaS");
	}
    
    public void guardar() {
    	System.out.println(toString());
    }
    
	@Override
	public String toString() {
		return "FormCamisetaBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", talla=" + talla + ", genero=" + genero
				+ ", material=" + material + ", mangaCamiseta=" + mangaCamiseta + ", cuelloCamiseta=" + cuelloCamiseta
				+ ", estampada=" + estampada + "]";
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
	public String getMangaCamiseta() {
		return mangaCamiseta;
	}
	public void setMangaCamiseta(String mangaCamiseta) {
		this.mangaCamiseta = mangaCamiseta;
	}
	public String getCuelloCamiseta() {
		return cuelloCamiseta;
	}
	public void setCuelloCamiseta(String cuelloCamiseta) {
		this.cuelloCamiseta = cuelloCamiseta;
	}
	public boolean isEstampada() {
		return estampada;
	}
	public void setEstampada(boolean estampada) {
		this.estampada = estampada;
	}

	public ArrayList<String> getOpcionesGenero() {
		return opcionesGenero;
	}

	public void setOpcionesGenero(ArrayList<String> opcionesGenero) {
		this.opcionesGenero = opcionesGenero;
	}

	public ArrayList<String> getOpcionesManga() {
		return opcionesManga;
	}

	public void setOpcionesManga(ArrayList<String> opcionesManga) {
		this.opcionesManga = opcionesManga;
	}

	public ArrayList<String> getOpcionesCuello() {
		return opcionesCuello;
	}

	public void setOpcionesCuello(ArrayList<String> opcionesCuello) {
		this.opcionesCuello = opcionesCuello;
	}
    
    
    
}
