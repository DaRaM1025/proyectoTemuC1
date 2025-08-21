/**
 * Clase que representa el bean de la sesión del carrito de compras
 * Permite gestionar las operaciones del carrito como agregar, remover y limpiar productos
 * @author Nataly Vanessa Rengifo Bautista
 */
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

	/**
	 * Servicio inyectado para manejar la lógica del carrito
	 * 
	 */
	@Inject
	private CarritoService cartService;

	/**
	 * Agrega un producto al carrito
	 * 
	 * @param producto El producto a agregar
	 * 
	 */
	public void agregarProducto(ProductoDTO producto) {
		cartService.agregarProducto(producto);
	}

	/**
	 * Remueve un producto del carrito
	 * 
	 * @param producto El producto a remover
	 * 
	 */
	public void removerProducto(ProductoDTO producto) {
		cartService.removerProducto(producto);
	}

	/**
	 * Limpia todos los productos del carrito
	 * 
	 */
	public void limpiarCarrito() {
		cartService.limpiarCarrito();
	}

	/**
	 * Obtiene la lista de productos en el carrito
	 * 
	 * @return Lista de productos en el carrito
	 * 
	 */
	public ArrayList<ProductoDTO> getProductosCarrito() {
		return cartService.getListaCarrito();
	}
}