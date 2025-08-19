package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoPercusionDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class InstrumentoPercusionService {
	private List<InstrumentoPercusionDTO> listaInstrumentosPercusion;

	@PostConstruct
	public void init() {
		listaInstrumentosPercusion = new ArrayList<>();

//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Batería Acústica", "Pearl",
//				"Instrumento de Percusión", "Batería de 5 piezas", "https://example.com/bateria.jpg", 4200000, 2,
//				"IP001", false, "Batería", true, "Membranófono", 5));
//		listaInstrumentosPercusion.add(
//				new InstrumentoPercusionDTO("Cajón Flamenco", "Meinl", "Instrumento de Percusión", "Cajón artesanal",
//						"https://example.com/cajon.jpg", 550000, 6, "IP002", false, "Cajón", false, "Idiófono", 1));
//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Xilófono", "Yamaha", "Instrumento de Percusión",
//				"Xilófono de concierto", "https://example.com/xilofono.jpg", 2800000, 2, "IP003", true, "Xilófono",
//				true, "Idiófono", 37));
//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Timbales", "LP", "Instrumento de Percusión",
//				"Juego de timbales latinos", "https://example.com/timbales.jpg", 1400000, 3, "IP004", true, "Timbales",
//				true, "Membranófono", 2));
//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Congas", "Meinl", "Instrumento de Percusión",
//				"Juego de congas profesionales", "https://example.com/congas.jpg", 2500000, 2, "IP005", false, "Congas",
//				true, "Membranófono", 2));
//		listaInstrumentosPercusion
//				.add(new InstrumentoPercusionDTO("Bongo", "LP", "Instrumento de Percusión", "Par de bongós de madera",
//						"https://example.com/bongo.jpg", 780000, 5, "IP006", false, "Bongó", true, "Membranófono", 2));
//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Maracas", "Latin Percussion",
//				"Instrumento de Percusión", "Par de maracas tradicionales", "https://example.com/maracas.jpg", 150000,
//				10, "IP007", false, "Maracas", false, "Idiófono", 2));
//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Djembe", "Remo", "Instrumento de Percusión",
//				"Tambor africano", "https://example.com/djembe.jpg", 1200000, 4, "IP008", false, "Djembe", true,
//				"Membranófono", 1));
//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Triángulo", "Meinl", "Instrumento de Percusión",
//				"Triángulo de acero", "https://example.com/triangulo.jpg", 60000, 20, "IP009", false, "Triángulo", true,
//				"Idiófono", 1));
//		listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Caja Redoblante", "Mapex",
//				"Instrumento de Percusión", "Caja de concierto", "https://example.com/redoblante.jpg", 1300000, 3,
//				"IP010", true, "Redoblante", true, "Membranófono", 1));
//		igualarListas();
		leerLista();

	}

	public void igualarListas() {
		ModelFacade.getPercusionDAO().getListaInstrumentoPercusion()
				.addAll(DataMapper.listaInstrumentoPercusionDTOToListaInstrumentoPercusion((ArrayList<InstrumentoPercusionDTO>) listaInstrumentosPercusion));
		ModelFacade.getPercusionDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getPercusionDAO().cargarDesdeArchivo();
		listaInstrumentosPercusion = DataMapper.listaInstrumentoPercusionToListaInstrumentoPercusionDTO(ModelFacade.getPercusionDAO().getListaInstrumentoPercusion());
	}

	public List<InstrumentoPercusionDTO> getProducts() {
		return new ArrayList<>(listaInstrumentosPercusion);
	}

	public List<InstrumentoPercusionDTO> getProducts(int size) {

		if (size > listaInstrumentosPercusion.size()) {
			Random rand = new Random();

			List<InstrumentoPercusionDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaInstrumentosPercusion.size());
				randomList.add(listaInstrumentosPercusion.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaInstrumentosPercusion.subList(0, size));
		}

	}

	public List<InstrumentoPercusionDTO> getClonedProducts(int size) {
		List<InstrumentoPercusionDTO> results = new ArrayList<>();
		List<InstrumentoPercusionDTO> originals = getProducts(size);
		for (InstrumentoPercusionDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (InstrumentoPercusionDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
