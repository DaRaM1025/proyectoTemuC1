package co.edu.unbosque.service;

import java.util.ArrayList;

import co.edu.unbosque.model.ProductoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CrudService {

private ArrayList<ProductoDTO> listaCrud;
	
	@PostConstruct
	public void init() {
		listaCrud = new ArrayList<>();
	}

	public void agregarProducto(ProductoDTO producto) {
		if (producto == null) {
			return;
		}

		if (!listaCrud.contains(producto)) {
			listaCrud.add(producto);
		} else {
			System.out.println("Item repetido.");
		}
	}

	public void removerProducto(ProductoDTO producto) {
		listaCrud.remove(producto);
	}

	public void limpiarCarrito() {
		listaCrud.clear();
	}

	public ArrayList<ProductoDTO> getListaCrud() {
		return listaCrud;
	}

	public void setListaCrud(ArrayList<ProductoDTO> listaCrud) {
		this.listaCrud = listaCrud;
	}
	
	
	
}
