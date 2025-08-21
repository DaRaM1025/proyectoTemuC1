package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.ResponsiveOption;

import co.edu.unbosque.model.LegoDTO;
import co.edu.unbosque.service.LegoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Clase que gestiona la vista de carrusel para productos de legos
 * @author Nataly Vanessa Rengifo Bautista
 */
@Named
@ViewScoped
public class CarouselViewLegos implements Serializable {
    /**
     * Lista de productos de legos
     */
    private List<LegoDTO> products;

    /**
     * Opciones de diseño responsive para el carrusel
     */
    private List<ResponsiveOption> responsiveOptions;

    /**
     * Servicio para manejar operaciones de legos
     */
    @Inject
    private LegoService service;

    /**
     * Método de inicialización que carga productos y configura opciones responsive
     */
    @PostConstruct
    public void init() {
        products = service.getProducts(10);
        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }

    /**
     * Obtiene la lista de productos de legos
     * @return Lista de productos
     */
    public List<LegoDTO> getProducts() {
        return products;
    }

    /**
     * Establece el servicio de legos
     * @param service Servicio a inyectar
     */
    public void setService(LegoService service) {
        this.service = service;
    }

    /**
     * Obtiene las opciones de diseño responsive
     * @return Lista de opciones responsive
     */
    public List<ResponsiveOption> getResponsiveOptions() {
        return responsiveOptions;
    }

    /**
     * Establece las opciones de diseño responsive
     * @param responsiveOptions Lista de opciones a establecer
     */
    public void setResponsiveOptions(List<ResponsiveOption> responsiveOptions) {
        this.responsiveOptions = responsiveOptions;
    }

}