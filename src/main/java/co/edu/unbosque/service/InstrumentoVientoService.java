package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoVientoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class InstrumentoVientoService {
	private List<InstrumentoVientoDTO> listaInstrumentosViento;

	@PostConstruct
	public void init() {
		listaInstrumentosViento = new ArrayList<>();
//
//		listaInstrumentosViento
//				.add(new InstrumentoVientoDTO("Flauta Dulce", "Yamaha", "Instrumento de Viento", "Flauta de iniciación",
//						"https://example.com/flauta.jpg", 45000, 50, "IV001", false, "Flauta", "Do", 0, false));
//		listaInstrumentosViento.add(new InstrumentoVientoDTO("Trompeta", "Bach", "Instrumento de Viento",
//				"Trompeta de latón profesional", "https://example.com/trompeta.jpg", 2500000, 5, "IV002", true,
//				"Trompeta", "Si bemol", 3, true));
//		listaInstrumentosViento.add(new InstrumentoVientoDTO("Clarinete", "Buffet Crampon", "Instrumento de Viento",
//				"Clarinete en si bemol", "https://example.com/clarinete.jpg", 3200000, 3, "IV003", true, "Clarinete",
//				"Si bemol", 0, true));
//		listaInstrumentosViento
//				.add(new InstrumentoVientoDTO("Saxofón Alto", "Yamaha", "Instrumento de Viento", "Saxofón de estudio",
//						"https://example.com/saxo.jpg", 4500000, 4, "IV004", true, "Saxofón", "Mi bemol", 0, true));
//		listaInstrumentosViento.add(new InstrumentoVientoDTO("Oboe", "Howarth", "Instrumento de Viento",
//				"Oboe intermedio", "https://example.com/oboe.jpg", 5800000, 2, "IV005", true, "Oboe", "Do", 0, true));
//		listaInstrumentosViento
//				.add(new InstrumentoVientoDTO("Trombón", "Conn", "Instrumento de Viento", "Trombón tenor de vara",
//						"https://example.com/trombon.jpg", 3000000, 3, "IV006", true, "Trombón", "Si bemol", 0, false));
//		listaInstrumentosViento
//				.add(new InstrumentoVientoDTO("Armónica", "Hohner", "Instrumento de Viento", "Armónica de 10 agujeros",
//						"https://example.com/armonica.jpg", 120000, 20, "IV007", false, "Armónica", "Do", 0, false));
//		listaInstrumentosViento.add(new InstrumentoVientoDTO("Tuba", "Miraphone", "Instrumento de Viento",
//				"Tuba de concierto", "https://example.com/tuba.jpg", 9000000, 1, "IV008", true, "Tuba", "Fa", 4, true));
//		listaInstrumentosViento
//				.add(new InstrumentoVientoDTO("Fagot", "Fox", "Instrumento de Viento", "Fagot profesional",
//						"https://example.com/fagot.jpg", 12000000, 1, "IV009", true, "Fagot", "Do", 0, true));
//		listaInstrumentosViento
//				.add(new InstrumentoVientoDTO("Corneta", "Getzen", "Instrumento de Viento", "Corneta de latón",
//						"https://example.com/corneta.jpg", 1800000, 2, "IV010", true, "Corneta", "Si bemol", 3, true));
//		igualarListas();
		leerLista();
		
	}
	
	public void igualarListas() {
		ModelFacade.getVientoDAO().getListaInstrumentoViento()
				.addAll(DataMapper.listaInstrumentoVientoDTOToListaInstrumentoViento((ArrayList<InstrumentoVientoDTO>) listaInstrumentosViento));
		ModelFacade.getVientoDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getVientoDAO().cargarDesdeArchivo();
		listaInstrumentosViento = DataMapper.listaInstrumentoVientoToListaInstrumentoVientoDTO(ModelFacade.getVientoDAO().getListaInstrumentoViento());
	}
	public List<InstrumentoVientoDTO> getProducts() {
		return new ArrayList<>(listaInstrumentosViento);
	}

	public List<InstrumentoVientoDTO> getProducts(int size) {

		if (size > listaInstrumentosViento.size()) {
			Random rand = new Random();

			List<InstrumentoVientoDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaInstrumentosViento.size());
				randomList.add(listaInstrumentosViento.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaInstrumentosViento.subList(0, size));
		}

	}

	public List<InstrumentoVientoDTO> getClonedProducts(int size) {
		List<InstrumentoVientoDTO> results = new ArrayList<>();
		List<InstrumentoVientoDTO> originals = getProducts(size);
		for (InstrumentoVientoDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (InstrumentoVientoDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
