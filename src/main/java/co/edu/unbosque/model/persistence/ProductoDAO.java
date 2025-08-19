package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Producto;
import co.edu.unbosque.model.ProductoDTO;

public class ProductoDAO implements OperacionDAO<ProductoDTO, Producto> {

	private ArrayList<Producto> listaProductos;
	private final String SERIAL_FILE_NAME = "productos.dat";

	public ProductoDAO() {
		super();
		listaProductos = new ArrayList<>();
		leerArchivoSerializado();
	}

	private void leerArchivoSerializado() {
		listaProductos = (ArrayList<Producto>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
		if (listaProductos == null) {
			listaProductos = new ArrayList<>();
		}
	}

//	@Override
	@Override
	public boolean crear(ProductoDTO nuevo) {
		//listaProductos.add(nuevo);
		return true;
	}

	@Override
	public boolean eliminar(ProductoDTO eliminado) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto find(Producto toFind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(ProductoDTO previo, ProductoDTO nuevo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String mostrar() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}


}
