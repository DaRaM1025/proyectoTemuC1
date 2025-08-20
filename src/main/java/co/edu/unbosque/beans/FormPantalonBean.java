package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.PantalonDTO;
import co.edu.unbosque.service.CrudService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
@Named(value="pantalonBean")
@ViewScoped
public class FormPantalonBean implements Serializable{

	private String nombre;
	private String marca;
	 private final String tipoProducto="Pantalón";
	private String descripcion;
	private String imagen="https://img.freepik.com/foto-gratis/mano-sosteniendo-pantalones-beige-marron-claro_23-2150756282.jpg";
	private double precio;
	private int cantidad;
	private String id=UUID.randomUUID().toString();
	private String talla;
    private String genero;
    private String material;
    private String tipoPantalon;
    private String cortePantalon;
    private String largoPantalon;
    
    private ArrayList<String> opcionesGenero;
    private ArrayList<String> opcionesTipo;
    private ArrayList<String> opcionesCorte;
    private ArrayList<String> opcionesLargo;
    
    @Inject
    private CrudService crudSer;
    
    @PostConstruct
    public void init() {
    	opcionesGenero = new ArrayList<>();
    	opcionesTipo = new ArrayList<>();
    	opcionesCorte = new ArrayList<>();
    	opcionesLargo = new ArrayList<>();
		opcionesGenero.add("Mujer");
		opcionesGenero.add("Hombre");
		opcionesGenero.add("Niño");
		opcionesGenero.add("Niña");
		opcionesTipo.add("Jean");
		opcionesTipo.add("Cargo");
		opcionesTipo.add("Chino");
		opcionesTipo.add("Jogger");
		opcionesTipo.add("De vestir");
		opcionesCorte.add("Boyfriend");
		opcionesCorte.add("Skinny");
		opcionesCorte.add("Slim fit");
		opcionesCorte.add("Recto");
		opcionesCorte.add("Bootcut");
		opcionesCorte.add("Wide leg");
		opcionesLargo.add("Corto");
		opcionesLargo.add("Capri");
		opcionesLargo.add("Tobillero");
		opcionesLargo.add("Normal");
		opcionesLargo.add("Extra Largo");
	}

    public void guardar() {
    	System.out.println(toString());
    	crudSer.agregarProducto(new PantalonDTO(nombre, marca, tipoProducto, descripcion, imagen, precio, cantidad, id, talla, genero, material, tipoPantalon, cortePantalon, largoPantalon));
    }
    
	@Override
	public String toString() {
		return "FormPantalonBean [nombre=" + nombre + ", marca=" + marca + ", descripcion=" + descripcion + ", imagen="
				+ imagen + ", precio=" + precio + ", cantidad=" + cantidad + ", talla=" + talla + ", genero=" + genero
				+ ", material=" + material + ", tipoPantalon=" + tipoPantalon + ", cortePantalon=" + cortePantalon
				+ ", largoPantalon=" + largoPantalon ;
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

	public String getTipoPantalon() {
		return tipoPantalon;
	}

	public void setTipoPantalon(String tipoPantalon) {
		this.tipoPantalon = tipoPantalon;
	}

	public String getCortePantalon() {
		return cortePantalon;
	}

	public void setCortePantalon(String cortePantalon) {
		this.cortePantalon = cortePantalon;
	}

	public String getLargoPantalon() {
		return largoPantalon;
	}

	public void setLargoPantalon(String largoPantalon) {
		this.largoPantalon = largoPantalon;
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

	public ArrayList<String> getOpcionesCorte() {
		return opcionesCorte;
	}

	public void setOpcionesCorte(ArrayList<String> opcionesCorte) {
		this.opcionesCorte = opcionesCorte;
	}

	public ArrayList<String> getOpcionesLargo() {
		return opcionesLargo;
	}

	public void setOpcionesLargo(ArrayList<String> opcionesLargo) {
		this.opcionesLargo = opcionesLargo;
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
    
	
}
