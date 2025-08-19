package co.edu.unbosque.service;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoDTO;

public class CarritoService {
	
	private ArrayList<ProductoDTO> listaCarrito;
	
	public CarritoService() {
		listaCarrito = new ArrayList<ProductoDTO>();
	}
	
	public void agregarProducto(ProductoDTO producto) {
		if (producto == null)
			return;

		if (!listaCarrito.contains(producto)) {
			listaCarrito.add(producto);
		} else {
			System.out.println("Item repetido.");
		}
	}

	public void removerProducto(ProductoDTO producto) {
		listaCarrito.remove(producto);
	}

	public void limpiarCarrito() {
		listaCarrito.clear();
	}

	public ArrayList<ProductoDTO> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(ArrayList<ProductoDTO> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}
	
	
	
}
