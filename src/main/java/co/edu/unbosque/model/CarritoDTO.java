package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CarritoDTO implements Serializable {
	private ArrayList<ProductoDTO> productos = new ArrayList<>();

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setItems(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}

	public double getTotal() {
		return productos.stream().mapToDouble(ProductoDTO::getPrecio).sum();
	}

	public int getCantidad() {
		return productos.size();
	}
}
