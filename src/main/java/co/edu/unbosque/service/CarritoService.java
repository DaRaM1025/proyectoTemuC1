package co.edu.unbosque.service;

import java.util.ArrayList;
import co.edu.unbosque.model.ProductoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CarritoService {

	private ArrayList<ProductoDTO> listaCarrito;
	
	@PostConstruct
	public void init() {
		listaCarrito = new ArrayList<>();
	}

	public void agregarProducto(ProductoDTO producto) {
		if (producto == null) {
			return;
		}

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
