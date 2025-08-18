package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.ResponsiveOption;

import co.edu.unbosque.model.ComputadorDTO;
import co.edu.unbosque.service.ComputadorService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class CarouselViewComputadores implements Serializable {
	private List<ComputadorDTO> products;

	private List<ResponsiveOption> responsiveOptions;

	@Inject
	private ComputadorService service;

	@PostConstruct
	public void init() {
		products = service.getProducts(10);
		responsiveOptions = new ArrayList<>();
		responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
		responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
		responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
	}

	public List<ComputadorDTO> getProducts() {
		return products;
	}

	public void setService(ComputadorService service) {
		this.service = service;
	}

	public List<ResponsiveOption> getResponsiveOptions() {
		return responsiveOptions;
	}

	public void setResponsiveOptions(List<ResponsiveOption> responsiveOptions) {
		this.responsiveOptions = responsiveOptions;
	}

}
