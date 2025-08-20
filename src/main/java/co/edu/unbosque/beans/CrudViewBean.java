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
public class CrudViewBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private ArrayList<ProductoDTO> products;

    private ProductoDTO selectedProduct;

    private ArrayList<ProductoDTO> selectedProducts;

    @Inject
    //Pasar las referencnias de una clase ya creada e inyectarla dentro de esta otra clase "injection of dependencies"
    private CrudService productService;

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


	public void openNew() {
        this.selectedProduct = new ProductoDTO();
    }

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

    public void deleteProduct() {
        this.products.remove(this.selectedProduct);
        this.selectedProducts.remove(this.selectedProduct);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedProducts()) {
            int size = this.selectedProducts.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }

    public boolean hasSelectedProducts() {
        return this.selectedProducts != null && !this.selectedProducts.isEmpty();
    }

    public void deleteSelectedProducts() {
    	System.out.println("Deleting selected products: " + selectedProducts);
        this.products.removeAll(this.selectedProducts);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}

