package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PistolaAguaDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class PistolaAguaService {
	private List<PistolaAguaDTO> listaPistolasAgua;

	@PostConstruct
	public void init() {
		listaPistolasAgua = new ArrayList<>();

		listaPistolasAgua.add(new PistolaAguaDTO("Super Soaker Hydro", "Hasbro", "Juguete",
				"Pistola de agua con gran capacidad de disparo", "https://example.com/supersoaker_hydro.jpg", 95000, 15,
				"PA001", 6, 1.2, 3, 8.5));

		listaPistolasAgua.add(new PistolaAguaDTO("Aqua Blaster Pro", "XShot", "Juguete",
				"Pistola ligera y resistente con diseño ergonómico", "https://example.com/aqua_blaster_pro.jpg", 72000,
				25, "PA002", 5, 0.9, 2, 7.0));

		listaPistolasAgua.add(new PistolaAguaDTO("Mega Stream 3000", "Nerf", "Juguete",
				"Pistola de agua con triple chorro de largo alcance", "https://example.com/mega_stream.jpg", 120000, 10,
				"PA003", 7, 1.5, 3, 10.0));

		listaPistolasAgua.add(new PistolaAguaDTO("SplashMaster X", "Aquafun", "Juguete",
				"Pistola compacta con gran potencia de disparo", "https://example.com/splashmaster_x.jpg", 60000, 30,
				"PA004", 4, 0.7, 1, 6.0));

		listaPistolasAgua.add(new PistolaAguaDTO("Hydro Jet Max", "Hasbro", "Juguete",
				"Pistola con tanque recargable y boquilla ajustable", "https://example.com/hydro_jet_max.jpg", 110000,
				12, "PA005", 8, 1.8, 2, 9.5));

		listaPistolasAgua.add(new PistolaAguaDTO("Water Warrior Titan", "BuzzBee", "Juguete",
				"Pistola de agua con diseño robusto para largas batallas", "https://example.com/water_titan.jpg",
				135000, 8, "PA006", 10, 2.0, 3, 12.0));

		listaPistolasAgua.add(new PistolaAguaDTO("Mini Soaker Pocket", "Aquafun", "Juguete",
				"Pistola pequeña ideal para niños pequeños", "https://example.com/mini_soaker.jpg", 40000, 50, "PA007",
				3, 0.3, 1, 4.0));

		listaPistolasAgua.add(
				new PistolaAguaDTO("Double Blast 2X", "XShot", "Juguete", "Pistola doble chorro con disparo simultáneo",
						"https://example.com/double_blast.jpg", 98000, 20, "PA008", 6, 1.1, 2, 8.0));

		listaPistolasAgua.add(new PistolaAguaDTO("Storm Surge Elite", "Nerf", "Juguete",
				"Pistola con depósito grande y alcance extendido", "https://example.com/storm_surge.jpg", 145000, 9,
				"PA009", 9, 2.2, 3, 11.0));

		listaPistolasAgua.add(new PistolaAguaDTO("Hydro Blaster Mini", "Hasbro", "Juguete",
				"Pistola económica y compacta con buen disparo", "https://example.com/hydro_blaster_mini.jpg", 55000,
				40, "PA010", 5, 0.6, 1, 5.5));
		igualarListas();
		leerLista();

	}

	public void igualarListas() {
		ModelFacade.getPistolaDAO().getListaPistola().addAll(
				DataMapper.listaPistolaAguaDTOToListaPistolaAgua((ArrayList<PistolaAguaDTO>) listaPistolasAgua));
		ModelFacade.getPistolaDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getPistolaDAO().cargarDesdeArchivo();
		listaPistolasAgua = DataMapper
				.listaPistolaAguaToListaPistolaAguaDTO(ModelFacade.getPistolaDAO().getListaPistola());
	}

	public List<PistolaAguaDTO> getProducts() {
		return new ArrayList<>(listaPistolasAgua);
	}

	public List<PistolaAguaDTO> getProducts(int size) {

		if (size > listaPistolasAgua.size()) {
			Random rand = new Random();

			List<PistolaAguaDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaPistolasAgua.size());
				randomList.add(listaPistolasAgua.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaPistolasAgua.subList(0, size));
		}

	}

	public List<PistolaAguaDTO> getClonedProducts(int size) {
		List<PistolaAguaDTO> results = new ArrayList<>();
		List<PistolaAguaDTO> originals = getProducts(size);
		for (PistolaAguaDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (PistolaAguaDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
