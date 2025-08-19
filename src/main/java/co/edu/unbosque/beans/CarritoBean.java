package co.edu.unbosque.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.service.CarritoService;

@Named("carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {
	private CarritoService cartService;
	
	//Dejar esto así o usar una etiqueta @PostConstruct?
	public CarritoBean() {
		cartService = new CarritoService();
	}
	
	public void agregarProducto(ProductoDTO producto) {
		cartService.agregarProducto(producto);
	}
	
	public void removerProducto(ProductoDTO producto) {
		cartService.removerProducto(producto);
	}
	
	public void limpiarCarrito() {
		cartService.limpiarCarrito();
	}
	
	public ArrayList<ProductoDTO> getProductosCarrito(){
		return cartService.getListaCarrito();
	}
}