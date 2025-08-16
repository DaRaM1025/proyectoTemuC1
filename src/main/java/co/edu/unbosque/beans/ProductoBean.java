package co.edu.unbosque.beans;

import java.util.List;

import co.edu.unbosque.model.ProductoCarrito;

import java.io.Serializable;
import java.util.ArrayList;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("productoBean")
@ViewScoped
public class ProductoBean implements Serializable {

	private List<ProductoCarrito> productos;

	@PostConstruct
	public void init() {
		productos = new ArrayList<>();

		productos.add(new ProductoCarrito("Camiseta", "P001", "resources/images/camiseta.jpg", 1));
		productos.add(new ProductoCarrito("Zapatos", "P002", "resources/images/zapatos.jpg", 2));
		productos.add(new ProductoCarrito("Gorra", "P003", "resources/images/gorra.jpg", 1));
		productos.add(new ProductoCarrito("Mochila", "P004", "resources/images/mochila.jpg", 3));
	}

	public void realizarCompra() {
		// Acción simulada
		System.out.println("Compra realizada");
	}

	public List<ProductoCarrito> getProductos() {
		return productos;
	}
	
	public void verificarCantidad() {
	    productos.removeIf(p -> p.getCantidad() == 0);
	}

}
