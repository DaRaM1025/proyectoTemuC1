package co.edu.unbosque.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

import co.edu.unbosque.model.CarritoDTO;
import co.edu.unbosque.model.ProductoDTO;

@Named("carritoBean")
@SessionScoped
public class CarritoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private CarritoDTO carrito = new CarritoDTO();

	private ProductoDTO seleccionado;

	public void add(ProductoDTO producto) {
		if (producto == null)
			return;

		if (!carrito.getProductos().contains(producto)) {
			carrito.getProductos().add(producto);
		} else {
			System.out.println("Item repetido.");
		}
	}

	public void addSeleccionado() {
		add(seleccionado);
	}

	public void remove(ProductoDTO producto) {
		carrito.getProductos().remove(producto);
	}

	public void clear() {
		carrito.getProductos().clear();
	}

	public String goToCheckout() {
		return "/checkout.xhtml?faces-redirect=true";
	}

	public List<ProductoDTO> getProductos() {
		return carrito.getProductos();
	}

	public double getTotal() {
		return carrito.getTotal();
	}

	public int getCount() {
		return carrito.getCantidad();
	}

	public ProductoDTO getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(ProductoDTO Seleccionado) {
		this.seleccionado = Seleccionado;
	}

	public CarritoDTO getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoDTO carrito) {
		this.carrito = carrito;
	}
}