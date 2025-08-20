package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.Product;
import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.service.CrudService;
import co.edu.unbosque.service.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
/**
 * Managed Bean para manejar la vista CRUD de productos en la aplicación JSF.
 * <p>
 * Esta clase se encarga de la interacción con la interfaz de usuario,
 * gestionando la lista de productos, selección y las operaciones
 * de creación, actualización y eliminación de productos.
 * </p>
 * 
 * Tiene un ámbito de vista para mantener el estado mientras la vista esté activa.
 * 
 * @author Nataly Rengifo
 */
public class CrudViewBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private ArrayList<ProductoDTO> products;
    /**
     * Lista de productos para mostrar en la vista.
     */
    private ProductoDTO selectedProduct;
    /**
     * Producto actualmente seleccionado para  eliminación.
     */

    private ArrayList<ProductoDTO> selectedProducts;
    /**
     * Servicio inyectado para realizar operaciones CRUD sobre los productos.
     */
    @Inject
    //Pasar las referencnias de una clase ya creada e inyectarla dentro de esta otra clase "injection of dependencies"
    private CrudService productService;
    /**
     * Inicializa el bean cargando la lista de productos del servicio
     * y preparando la lista de productos seleccionados.
     */
    @PostConstruct
    public void init() {
        this.products = productService.getListaCrud();
        this.selectedProducts = new ArrayList<>();
    }


    public ArrayList<ProductoDTO> getProducts() {
		return products;
	}


	public void setProducts(ArrayList<ProductoDTO> products) {
		this.products = products;
	}


	public ProductoDTO getSelectedProduct() {
		return selectedProduct;
	}


	public void setSelectedProduct(ProductoDTO selectedProduct) {
		this.selectedProduct = selectedProduct;
	}


	public ArrayList<ProductoDTO> getSelectedProducts() {
		return selectedProducts;
	}


	public void setSelectedProducts(ArrayList<ProductoDTO> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}


	public CrudService getProductService() {
		return productService;
	}


	public void setProductService(CrudService productService) {
		this.productService = productService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     * Prepara un nuevo producto para agregar.
     */
	public void openNew() {
        this.selectedProduct = new ProductoDTO();
    }
	/**
     * Guarda un producto nuevo o actualiza uno existente.
     * <p>
     * Si el producto no tiene ID, se asigna uno nuevo y se agrega a la lista.
     * Si ya tiene ID, se asume que se actualizó y solo se informa al usuario.
     * </p>
     */
    public void saveProduct() {
        if (this.selectedProduct.getId() == null) {
            this.selectedProduct.setId(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
            this.products.add(this.selectedProduct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
/**
     * Elimina el producto actualmente seleccionado de la lista.
     */

    public void deleteProduct() {
        this.products.remove(this.selectedProduct);
        this.selectedProducts.remove(this.selectedProduct);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
    /**
     * Obtiene el texto que debe mostrar el botón de eliminar,
     * indicando la cantidad de productos seleccionados.
     * 
     * @return Mensaje para el botón eliminar.
     */
    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedProducts.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }
/**
     * Indica si hay productos seleccionados.
     * 
     * @return true si hay productos seleccionados, false de lo contrario.
     */
    public boolean hasSelectedProducts() {
        return this.selectedProducts != null && !this.selectedProducts.isEmpty();
    }
    /**
     * Elimina todos los productos seleccionados de la lista.
     */
    public void deleteSelectedProducts() {
    	System.out.println("Deleting selected products: " + selectedProducts);
        this.products.removeAll(this.selectedProducts);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}

