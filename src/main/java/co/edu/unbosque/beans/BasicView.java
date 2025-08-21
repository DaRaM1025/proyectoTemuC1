package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.List;

import org.primefaces.component.api.UIColumn;
import org.primefaces.event.ColumnToggleEvent;
import org.primefaces.model.Visibility;

import co.edu.unbosque.model.ProductoDTO;
import co.edu.unbosque.service.CarritoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Clase que gestiona la vista de productos en el carrito
 * @author Nataly Vanessa Rengifo Bautista
 */
@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    /**
     * Lista de productos en el carrito
     */
    private List<ProductoDTO> products;

    /**
     * Servicio para manejar operaciones del carrito
     */
    @Inject
    private CarritoService service;

    /**
     * Método de inicialización que carga la lista de productos del carrito
     */
    @PostConstruct
    public void init() {
        products = service.getListaCarrito();
    }

    /**
     * Obtiene la lista de productos del carrito
     * @return Lista de productos
     */
    public List<ProductoDTO> getProducts() {
        return products;
    }

    /**
     * Establece el servicio del carrito
     * @param service Servicio a inyectar
     */
    public void setService(CarritoService service) {
        this.service = service;
    }

    /**
     * Maneja el evento de alternar visibilidad de columnas en la interfaz
     * @param e Evento de alternancia de columna
     */
    public void onToggle(ColumnToggleEvent e) {
        Integer index = (Integer) e.getData();
        UIColumn column = e.getColumn();
        Visibility visibility = e.getVisibility();
        String header = column.getAriaHeaderText() != null ? column.getAriaHeaderText() : column.getHeaderText();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Column " + index + " toggled: " + header + " " + visibility, null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}