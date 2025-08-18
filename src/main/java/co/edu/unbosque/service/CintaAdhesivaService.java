package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CintaAdhesivaDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CintaAdhesivaService {
	private List<CintaAdhesivaDTO> listaCintasAdhesivas;

	@PostConstruct
	public void init() {
		listaCintasAdhesivas = new ArrayList<>();

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta Transparente 18mm x 30m", "Scotch", "Cinta Adhesiva",
				"Transparente para oficina", "https://example.com/cinta_transparente.jpg", 3500, 120, "CIN001",
				"Rollo individual", false, 1.8, "Transparente"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta de Embalaje 48mm x 100m", "3M", "Cinta Adhesiva",
				"Para cajas y paquetería", "https://example.com/cinta_embalaje.jpg", 14500, 60, "CIN002",
				"Rollo industrial", false, 4.8, "Embalaje"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta Doble Faz 24mm", "Tesa", "Cinta Adhesiva",
				"Adhesivo por ambas caras", "https://example.com/cinta_doble_faz.jpg", 12000, 40, "CIN003", "Blister",
				false, 2.4, "Doble faz"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Washi Tape Decorativa 15mm", "MT", "Cinta Adhesiva",
				"Decorativa y reposicionable", "https://example.com/washi_tape.jpg", 8000, 80, "CIN004", "Unidad", true,
				1.5, "Washi"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta Aislante Eléctrica 19mm", "3M", "Cinta Adhesiva",
				"Para aislamiento eléctrico", "https://example.com/cinta_electrica.jpg", 4200, 100, "CIN005", "Unidad",
				false, 1.9, "Eléctrica"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta Masking 24mm x 40m", "Tesa", "Cinta Adhesiva",
				"Para pintura y cubrimiento", "https://example.com/cinta_masking.jpg", 6500, 90, "CIN006",
				"Rollo individual", true, 2.4, "Masking"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta Antideslizante 50mm", "3M", "Cinta Adhesiva",
				"Superficie antideslizante", "https://example.com/cinta_antideslizante.jpg", 29000, 20, "CIN007",
				"Blister", false, 5.0, "Antideslizante"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta Transparente con Dispensador", "Scotch", "Cinta Adhesiva",
				"Incluye dispensador de escritorio", "https://example.com/cinta_disp.jpg", 7800, 70, "CIN008",
				"Dispensador", false, 1.8, "Transparente"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta de Enmascarar Azul 24mm", "3M", "Cinta Adhesiva",
				"Para bordes limpios, pintura", "https://example.com/cinta_azul.jpg", 11500, 50, "CIN009",
				"Rollo individual", true, 2.4, "Masking"));

		listaCintasAdhesivas.add(new CintaAdhesivaDTO("Cinta Reposicionable 12mm Pack x3", "Scotch", "Cinta Adhesiva",
				"Adhesivo removible para papel", "https://example.com/cinta_repo.jpg", 9000, 65, "CIN010", "Pack x3",
				true, 1.2, "Transparente"));

	}

	public List<CintaAdhesivaDTO> getProducts() {
		return new ArrayList<>(listaCintasAdhesivas);
	}

	public List<CintaAdhesivaDTO> getProducts(int size) {

		if (size > listaCintasAdhesivas.size()) {
			Random rand = new Random();

			List<CintaAdhesivaDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCintasAdhesivas.size());
				randomList.add(listaCintasAdhesivas.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCintasAdhesivas.subList(0, size));
		}

	}

	public List<CintaAdhesivaDTO> getClonedProducts(int size) {
		List<CintaAdhesivaDTO> results = new ArrayList<>();
		List<CintaAdhesivaDTO> originals = getProducts(size);
		for (CintaAdhesivaDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (CintaAdhesivaDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
