package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.TelevisorDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TelevisorService {
	private List<TelevisorDTO> listaTelevisores;

	@PostConstruct
	public void init() {
		listaTelevisores = new ArrayList<>();

//		listaTelevisores.add(new TelevisorDTO("Smart TV Crystal UHD", "Samsung", "Televisor",
//				"Televisor 4K con tecnología Crystal Display", "https://example.com/samsung_crystal.jpg", 1800000, 10,
//				"TV001", 55, "3840x2160", "Tizen", 3, 60, "Bixby"));
//
//		listaTelevisores.add(new TelevisorDTO("OLED C1", "LG", "Televisor", "Televisor OLED con procesador α9 Gen4 AI",
//				"https://example.com/lg_oled_c1.jpg", 3500000, 8, "TV002", 65, "3840x2160", "webOS", 4, 120, "Alexa"));
//
//		listaTelevisores.add(new TelevisorDTO("Bravia XR", "Sony", "Televisor",
//				"Televisor 4K HDR con Cognitive Processor XR", "https://example.com/sony_bravia.jpg", 4200000, 6,
//				"TV003", 75, "3840x2160", "Google TV", 4, 120, "Google Assistant"));
//
//		listaTelevisores.add(new TelevisorDTO("QLED Q80T", "Samsung", "Televisor",
//				"Televisor QLED con Full Array Local Dimming", "https://example.com/samsung_q80t.jpg", 2900000, 12,
//				"TV004", 65, "3840x2160", "Tizen", 4, 120, "Bixby"));
//
//		listaTelevisores.add(new TelevisorDTO("NanoCell NANO90", "LG", "Televisor",
//				"Televisor NanoCell con Dolby Vision y Dolby Atmos", "https://example.com/lg_nanocell.jpg", 2400000, 15,
//				"TV005", 55, "3840x2160", "webOS", 3, 120, "Google Assistant"));
//
//		listaTelevisores.add(new TelevisorDTO("The Frame", "Samsung", "Televisor",
//				"Televisor QLED diseñado como un marco de arte", "https://example.com/samsung_frame.jpg", 3800000, 5,
//				"TV006", 55, "3840x2160", "Tizen", 4, 60, "Bixby"));
//
//		listaTelevisores.add(new TelevisorDTO("OLED A1", "LG", "Televisor",
//				"Televisor OLED económico con gran calidad de imagen", "https://example.com/lg_oled_a1.jpg", 2800000, 7,
//				"TV007", 48, "3840x2160", "webOS", 3, 60, "Alexa"));
//
//		listaTelevisores.add(new TelevisorDTO("X90J", "Sony", "Televisor",
//				"Televisor Full Array LED con procesador Cognitive XR", "https://example.com/sony_x90j.jpg", 3100000, 9,
//				"TV008", 65, "3840x2160", "Google TV", 4, 120, "Google Assistant"));
//
//		listaTelevisores.add(new TelevisorDTO("QLED Q60A", "Samsung", "Televisor", "Televisor QLED con Quantum HDR",
//				"https://example.com/samsung_q60a.jpg", 2000000, 20, "TV009", 50, "3840x2160", "Tizen", 3, 60,
//				"Bixby"));
//
//		listaTelevisores.add(new TelevisorDTO("NanoCell NANO75", "LG", "Televisor",
//				"Televisor NanoCell con HDR10 Pro y sonido envolvente", "https://example.com/lg_nano75.jpg", 1700000,
//				18, "TV010", 50, "3840x2160", "webOS", 3, 60, "Alexa"));
//		igualarListas();
		leerLista();
		
	}
	
	public void igualarListas() {
		ModelFacade.getTelevisorDAO().getListaCalzado()
				.addAll(DataMapper.listaTelevisorDTOToListaTelevisor((ArrayList<TelevisorDTO>) listaTelevisores));
		ModelFacade.getTelevisorDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getTelevisorDAO().cargarDesdeArchivo();
		listaTelevisores = DataMapper.listaToListaTelevisorDTO(ModelFacade.getTelevisorDAO().getListaCalzado());
	}

	public List<TelevisorDTO> getProducts() {
		return new ArrayList<>(listaTelevisores);
	}

	public List<TelevisorDTO> getProducts(int size) {

		if (size > listaTelevisores.size()) {
			Random rand = new Random();

			List<TelevisorDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaTelevisores.size());
				randomList.add(listaTelevisores.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaTelevisores.subList(0, size));
		}

	}

	public List<TelevisorDTO> getClonedProducts(int size) {
		List<TelevisorDTO> results = new ArrayList<>();
		List<TelevisorDTO> originals = getProducts(size);
		for (TelevisorDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (TelevisorDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
