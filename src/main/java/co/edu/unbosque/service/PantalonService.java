package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PantalonDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class PantalonService {

	private List<PantalonDTO> listaPantalones;

	@PostConstruct
	public void init() {
		listaPantalones = new ArrayList<>();

		listaPantalones.add(new PantalonDTO("Jeans Clásicos Azul", "Levi's", "Casual",
				"Jeans de mezclilla azul clásicos", "https://example.com/jeans_azul.jpg", 180000, 20, "PAN001", "32",
				"Hombre", "Denim", "Jeans", "Recto", "Largo"));

		listaPantalones.add(new PantalonDTO("Pantalón Chino Beige", "Zara", "Casual",
				"Pantalón chino beige elegante y cómodo", "https://example.com/chino_beige.jpg", 150000, 15, "PAN002",
				"30", "Hombre", "Algodón", "Chino", "Slim", "Largo"));

		listaPantalones.add(new PantalonDTO("Leggins Deportivos", "Nike", "Deportivo",
				"Leggins elásticos para entrenar", "https://example.com/leggins.jpg", 120000, 18, "PAN003", "M",
				"Mujer", "Poliéster", "Leggins", "Ajustado", "Largo"));

		listaPantalones.add(new PantalonDTO("Pantalón Jogger Negro", "Adidas", "Deportivo",
				"Jogger negro con puños en tobillo", "https://example.com/jogger.jpg", 110000, 22, "PAN004", "L",
				"Unisex", "Algodón", "Jogger", "Regular", "Largo"));

		listaPantalones.add(new PantalonDTO("Shorts Verano", "H&M", "Casual", "Shorts de algodón frescos para verano",
				"https://example.com/shorts.jpg", 90000, 25, "PAN005", "M", "Unisex", "Algodón", "Shorts", "Recto",
				"Corto"));

		listaPantalones.add(new PantalonDTO("Pantalón de Vestir Negro", "Hugo Boss", "Formal",
				"Pantalón elegante de vestir negro", "https://example.com/vestir_negro.jpg", 350000, 10, "PAN006", "34",
				"Hombre", "Lana", "De vestir", "Slim", "Largo"));

		listaPantalones.add(new PantalonDTO("Pantalón Palazzo", "Mango", "Moda", "Pantalón palazzo fluido para mujer",
				"https://example.com/palazzo.jpg", 200000, 12, "PAN007", "S", "Mujer", "Viscosa", "Palazzo", "Amplio",
				"Largo"));

		listaPantalones.add(new PantalonDTO("Pantalón Cargo Verde", "Pull&Bear", "Urbano",
				"Pantalón cargo con múltiples bolsillos", "https://example.com/cargo.jpg", 170000, 14, "PAN008", "32",
				"Hombre", "Algodón", "Cargo", "Recto", "Largo"));

		listaPantalones.add(new PantalonDTO("Pantalón Capri", "Stradivarius", "Moda",
				"Pantalón capri fresco para verano", "https://example.com/capri.jpg", 140000, 16, "PAN009", "M",
				"Mujer", "Algodón", "Capri", "Slim", "3/4"));

		listaPantalones.add(new PantalonDTO("Jogger Estampado", "Forever21", "Urbano", "Jogger estampado juvenil",
				"https://example.com/jogger_estampado.jpg", 130000, 19, "PAN010", "L", "Unisex", "Poliéster", "Jogger",
				"Regular", "Largo"));
		igualarListas();
		leerLista();

	}

	public void igualarListas() {
		ModelFacade.getPantalonDAO().getListaPantalon()
				.addAll(DataMapper.listaPantalonDTOToListaPantalon((ArrayList<PantalonDTO>) listaPantalones));
		ModelFacade.getPantalonDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getPantalonDAO().cargarDesdeArchivo();
		listaPantalones = DataMapper.listaPantalonToListaPantalonDTO(ModelFacade.getPantalonDAO().getListaPantalon());
	}
	public List<PantalonDTO> getProducts() {
		return new ArrayList<>(listaPantalones);
	}

	public List<PantalonDTO> getProducts(int size) {

		if (size > listaPantalones.size()) {
			Random rand = new Random();

			List<PantalonDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaPantalones.size());
				randomList.add(listaPantalones.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaPantalones.subList(0, size));
		}

	}

	public List<PantalonDTO> getClonedProducts(int size) {
		List<PantalonDTO> results = new ArrayList<>();
		List<PantalonDTO> originals = getProducts(size);
		for (PantalonDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (PantalonDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}