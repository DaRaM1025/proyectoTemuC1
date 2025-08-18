package co.edu.unbosque.model;

import java.util.ArrayList;

public class Carrito {
	private ArrayList<Producto> listaProductos;

	public Carrito(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	

}
