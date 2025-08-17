package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.ResponsiveOption;

import co.edu.unbosque.model.SombraDTO;
import co.edu.unbosque.service.SombraService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CarouselViewSombras implements Serializable {
	private List<SombraDTO> products;

    private List<ResponsiveOption> responsiveOptions;

    @Inject
    private SombraService service;

    @PostConstruct
    public void init() {
        products = service.getProducts(9);
        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }

    public List<SombraDTO> getProducts() {
        return products;
    }

    public void setService(SombraService service) {
        this.service = service;
    }

    public List<ResponsiveOption> getResponsiveOptions() {
        return responsiveOptions;
    }

    public void setResponsiveOptions(List<ResponsiveOption> responsiveOptions) {
        this.responsiveOptions = responsiveOptions;
    }

}
