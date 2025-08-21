package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.ResponsiveOption;

import co.edu.unbosque.model.MarcadorDTO;
import co.edu.unbosque.service.MarcadorService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * Clase que gestiona la vista de carrusel para productos de marcadores
 * @author Nataly Vanessa Rengifo Bautista
 */
@Named
@ViewScoped
public class CarouselViewMarcadores implements Serializable {
    /**
     * Lista de productos de marcadores
     */
    private List<MarcadorDTO> products;

    /**
     * Opciones de diseño responsive para el carrusel
     */
    private List<ResponsiveOption> responsiveOptions;

    /**
     * Servicio para manejar operaciones de marcadores
     */
    @Inject
    private MarcadorService service;

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
     * Obtiene la lista de productos de marcadores
     * @return Lista de productos
     */
    public List<MarcadorDTO> getProducts() {
        return products;
    }

    /**
     * Establece el servicio de marcadores
     * @param service Servicio a inyectar
     */
    public void setService(MarcadorService service) {
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