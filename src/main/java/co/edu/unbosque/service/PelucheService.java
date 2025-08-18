package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.PelucheDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class PelucheService {
	private List<PelucheDTO> listaPeluches;

	@PostConstruct
	public void init() {
		listaPeluches = new ArrayList<>();

		listaPeluches.add(new PelucheDTO("Osito Teddy", "Hasbro", "Peluche",
		        "Clásico oso de felpa marrón", "https://example.com/osito_teddy.jpg",
		        45000, 15, "PEL001", 3, false, "Algodón", true));

		listaPeluches.add(new PelucheDTO("Perrito Dormilón", "Fisher Price", "Peluche",
		        "Perrito suave con orejas largas", "https://example.com/perrito.jpg",
		        52000, 10, "PEL002", 2, true, "Poliéster", true));

		listaPeluches.add(new PelucheDTO("Gato Gris", "Ty", "Peluche",
		        "Gato de felpa con ojos grandes", "https://example.com/gato.jpg",
		        38000, 25, "PEL003", 4, false, "Algodón", false));

		listaPeluches.add(new PelucheDTO("Conejo Blanco", "Disney", "Peluche",
		        "Conejo inspirado en personajes clásicos", "https://example.com/conejo.jpg",
		        60000, 8, "PEL004", 5, false, "Algodón", true));

		listaPeluches.add(new PelucheDTO("Dinosaurio Verde", "Mattel", "Peluche",
		        "Dino suave y divertido", "https://example.com/dino.jpg",
		        70000, 12, "PEL005", 6, true, "Espuma", false));

		listaPeluches.add(new PelucheDTO("Unicornio Rosa", "Ty", "Peluche",
		        "Unicornio con cuerno brillante", "https://example.com/unicornio.jpg",
		        85000, 9, "PEL006", 5, false, "Poliéster", true));

		listaPeluches.add(new PelucheDTO("Panda Gigante", "Hasbro", "Peluche",
		        "Panda suave tamaño XL", "https://example.com/panda.jpg",
		        120000, 5, "PEL007", 7, false, "Algodón", false));

		listaPeluches.add(new PelucheDTO("Dragón Azul", "Disney", "Peluche",
		        "Dragón de alas suaves", "https://example.com/dragon.jpg",
		        95000, 6, "PEL008", 8, true, "Espuma", true));

		listaPeluches.add(new PelucheDTO("Elefante Gris", "Mattel", "Peluche",
		        "Elefante orejudo con colmillos", "https://example.com/elefante.jpg",
		        65000, 14, "PEL009", 3, false, "Algodón", true));

		listaPeluches.add(new PelucheDTO("Zorro Naranja", "Fisher Price", "Peluche",
		        "Zorro de pelaje esponjoso", "https://example.com/zorro.jpg",
		        50000, 20, "PEL010", 4, false, "Poliéster", true));

	}

	public List<PelucheDTO> getProducts() {
		return new ArrayList<>(listaPeluches);
	}

	public List<PelucheDTO> getProducts(int size) {

		if (size > listaPeluches.size()) {
			Random rand = new Random();

			List<PelucheDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaPeluches.size());
				randomList.add(listaPeluches.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaPeluches.subList(0, size));
		}

	}

	public List<PelucheDTO> getClonedProducts(int size) {
		List<PelucheDTO> results = new ArrayList<>();
		List<PelucheDTO> originals = getProducts(size);
		for (PelucheDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (PelucheDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}
}
