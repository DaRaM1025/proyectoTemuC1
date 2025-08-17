package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CorrectorDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CorrectorService {
	private List<CorrectorDTO> listaCorrectores;

	@PostConstruct
	public void init() {
		listaCorrectores = new ArrayList<CorrectorDTO>();
		listaCorrectores.add(new CorrectorDTO("Corrector Fit Me", "Maybelline", "Líquido",
				"Corrector líquido de cobertura media", "https://example.com/fitme.jpg", 35000, 20, "C001", "Mixta",
				true, "2026-05-12", "Media", "Tubito"));

		listaCorrectores.add(new CorrectorDTO("Corrector True Match", "L'Oréal", "Líquido",
				"Corrector de larga duración con acabado natural", "https://example.com/truematch.jpg", 42000, 15,
				"C002", "Grasa", false, "2027-01-20", "Alta", "Tubito"));

		listaCorrectores.add(new CorrectorDTO("Corrector Colorstay", "Revlon", "Líquido",
				"Corrector resistente al agua con cobertura completa", "https://example.com/colorstay.jpg", 48000, 18,
				"C003", "Seca", true, "2026-10-05", "Total", "Barra"));

		listaCorrectores.add(new CorrectorDTO("Corrector Pro Longwear", "MAC", "Líquido",
				"Corrector profesional de larga duración", "https://example.com/prolongwear.jpg", 95000, 12, "C004",
				"Mixta", true, "2027-03-14", "Alta", "Pump"));

		listaCorrectores.add(new CorrectorDTO("Corrector HD", "NYX", "Líquido", "Corrector HD para fotografía y video",
				"https://example.com/hd.jpg", 38000, 25, "C005", "Normal", false, "2026-12-01", "Media", "Tubito"));

		listaCorrectores.add(new CorrectorDTO("Corrector Even Better", "Clinique", "Crema",
				"Corrector con propiedades hidratantes", "https://example.com/evenbetter.jpg", 87000, 10, "C006",
				"Seca", true, "2027-07-21", "Media", "Crema"));

		listaCorrectores.add(new CorrectorDTO("Corrector Bright Future", "Sephora", "Líquido",
				"Corrector ligero para iluminar la mirada", "https://example.com/brightfuture.jpg", 55000, 14, "C007",
				"Grasa", false, "2026-09-17", "Ligera", "Tubito"));

		listaCorrectores.add(new CorrectorDTO("Corrector Naked Skin", "Urban Decay", "Líquido",
				"Corrector de acabado natural y cobertura modulable", "https://example.com/nakedskin.jpg", 115000, 8,
				"C008", "Mixta", true, "2027-05-05", "Media", "Tubito"));

		listaCorrectores.add(new CorrectorDTO("Corrector Camouflage", "Essence", "Crema",
				"Corrector económico de cobertura total", "https://example.com/camouflage.jpg", 25000, 30, "C009",
				"Normal", false, "2026-11-30", "Total", "Crema"));

		listaCorrectores.add(new CorrectorDTO("Corrector Overachiever", "Huda Beauty", "Líquido",
				"Corrector de alta cobertura y duración extrema", "https://example.com/overachiever.jpg", 135000, 6,
				"C010", "Seca", true, "2027-08-10", "Total", "Tubito"));
	}

	public List<CorrectorDTO> getProducts() {
		return new ArrayList<>(listaCorrectores);
	}

	public List<CorrectorDTO> getProducts(int size) {

		if (size > listaCorrectores.size()) {
			Random rand = new Random();

			List<CorrectorDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCorrectores.size());
				randomList.add(listaCorrectores.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCorrectores.subList(0, size));
		}

	}

	public List<CorrectorDTO> getClonedProducts(int size) {
		List<CorrectorDTO> results = new ArrayList<>();
		List<CorrectorDTO> originals = getProducts(size);
		for (CorrectorDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (CorrectorDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
