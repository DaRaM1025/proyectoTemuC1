package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ProductoDAO;

public class ModelFacadeProducto {
	private ProductoDAO productoDao;;

	public ModelFacadeProducto() {
		
		 this.productoDao = new ProductoDAO();
	}

	public ProductoDAO getProductoDao() {
		return productoDao;
	}

	public void setProductoDao(ProductoDAO productoDao) {
		this.productoDao = productoDao;
	}

	


}
