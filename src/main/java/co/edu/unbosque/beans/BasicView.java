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

@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<ProductoDTO> products;

    @Inject
    private CarritoService service;

    @PostConstruct
    public void init() {
        products = service.getListaCarrito();
    }

    public List<ProductoDTO> getProducts() {
        return products;
    }

    public void setService(CarritoService service) {
        this.service = service;
    }

    public void onToggle(ColumnToggleEvent e) {
        Integer index = (Integer) e.getData();
        UIColumn column = e.getColumn();
        Visibility visibility = e.getVisibility();
        String header = column.getAriaHeaderText() != null ? column.getAriaHeaderText() : column.getHeaderText();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Column " + index + " toggled: " + header + " " + visibility, null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
