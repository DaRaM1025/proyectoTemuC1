package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.service.CarritoService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {
	
	@Inject
	private CarritoService cartService;

	

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