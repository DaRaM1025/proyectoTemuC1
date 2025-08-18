package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CalzadoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CalzadoService {
	private List<CalzadoDTO> listaCalzados;
	private ModelFacade mf;

	@PostConstruct
	public void init() {
		listaCalzados = new ArrayList<>();
		mf = new ModelFacade();

		listaCalzados.add(new CalzadoDTO("Zapatillas Running Air", "Nike", "Deportivo",
				"Zapatillas para correr con tecnología Air", "https://example.com/nike_air.jpg", 320000, 20, "CAL001",
				"42", "Hombre", "Sintético", "Zapatillas", "Deporte", "Goma", 3.5));

		listaCalzados.add(new CalzadoDTO("Tenis Classic", "Adidas", "Casual", "Tenis blancos clásicos para uso diario",
				"https://example.com/adidas_classic.jpg", 280000, 18, "CAL002", "40", "Unisex", "Cuero", "Tenis",
				"Casual", "Caucho", 2.5));

		listaCalzados.add(new CalzadoDTO("Botas Montaña Explorer", "The North Face", "Outdoor",
				"Botas resistentes para senderismo", "https://example.com/tnf_botas.jpg", 450000, 10, "CAL003", "44",
				"Hombre", "Cuero", "Botas", "Montaña", "Vibram", 4.0));

		listaCalzados.add(new CalzadoDTO("Sandalias Verano", "Havaianas", "Casual",
				"Sandalias cómodas para clima cálido", "https://example.com/havaianas.jpg", 90000, 25, "CAL004", "38",
				"Mujer", "Caucho", "Sandalias", "Playa", "Caucho", 1.0));

		listaCalzados.add(new CalzadoDTO("Zapatos Oxford", "Clarks", "Formal",
				"Zapatos de vestir elegantes estilo Oxford", "https://example.com/oxford.jpg", 390000, 12, "CAL005",
				"41", "Hombre", "Cuero", "Zapatos", "Formal", "Cuero", 2.0));

		listaCalzados.add(new CalzadoDTO("Botines de Moda", "Zara", "Urbano", "Botines modernos para looks urbanos",
				"https://example.com/zara_botin.jpg", 310000, 14, "CAL006", "39", "Mujer", "Sintético", "Botines",
				"Casual", "Caucho", 3.0));

		listaCalzados.add(new CalzadoDTO("Tacones Elegancia", "Steve Madden", "Formal",
				"Zapatos de tacón alto elegantes para ocasiones especiales", "https://example.com/tacones.jpg", 420000,
				8, "CAL007", "37", "Mujer", "Charol", "Tacones", "Fiesta", "Cuero", 9.0));

		listaCalzados.add(new CalzadoDTO("Mocasines Comfort", "Geox", "Casual", "Mocasines transpirables y cómodos",
				"https://example.com/mocasines.jpg", 270000, 16, "CAL008", "42", "Hombre", "Cuero", "Mocasines",
				"Oficina", "Goma", 2.0));

		listaCalzados.add(new CalzadoDTO("Botas Militares", "Dr. Martens", "Urbano",
				"Botas estilo militar con suela gruesa", "https://example.com/drmartens.jpg", 520000, 7, "CAL009", "43",
				"Unisex", "Cuero", "Botas", "Casual", "Caucho", 5.0));

		listaCalzados.add(new CalzadoDTO("Zapatillas Skate", "Vans", "Urbano", "Zapatillas de lona clásicas para skate",
				"https://example.com/vans_skate.jpg", 260000, 22, "CAL010", "41", "Unisex", "Lona", "Zapatillas",
				"Casual", "Goma", 2.5));

		igualarListas();
		leerLista();
	}

	public List<CalzadoDTO> getProducts() {
		return new ArrayList<>(listaCalzados);

	}

	public List<CalzadoDTO> getProducts(int size) {

		if (size > listaCalzados.size()) {
			Random rand = new Random();

			List<CalzadoDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCalzados.size());
				randomList.add(listaCalzados.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCalzados.subList(0, size));
		}

	}

	public void igualarListas() {
		mf.getCalzadoDAO().getListaCalzado()
				.addAll(DataMapper.listaCalzadoDTOToListaCalzado((ArrayList<CalzadoDTO>) listaCalzados));
		mf.getCalzadoDAO().escribirEnArchivo();
	}

	public void leerLista() {
		mf.getCalzadoDAO().cargarDesdeArchivo();
		listaCalzados = DataMapper.listaCalzadoToListaCalzadoDTO(mf.getCalzadoDAO().getListaCalzado());
	}

	public List<CalzadoDTO> getClonedProducts(int size) {
		List<CalzadoDTO> results = new ArrayList<>();
		List<CalzadoDTO> originals = getProducts(size);
		for (CalzadoDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (CalzadoDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
