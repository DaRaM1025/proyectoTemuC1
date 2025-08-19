package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CamisetaDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CamisetaService {
	
	private List<CamisetaDTO> listaCamisetas;

	@PostConstruct
	public void init() {
		listaCamisetas = new ArrayList<>();
		
//		listaCamisetas.add(new CamisetaDTO("Camiseta Básica Blanca", "H&M", "Casual",
//				"Camiseta de algodón blanca clásica", "https://example.com/camiseta_blanca.jpg", 25000, 30, "CAM001",
//				"M", "Unisex", "Algodón", "Manga corta", "Redondo", false));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Negra Slim", "Zara", "Casual",
//				"Camiseta negra entallada de alta calidad", "https://example.com/camiseta_negra.jpg", 45000, 20,
//				"CAM002", "L", "Hombre", "Algodón", "Manga corta", "V", false));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Deportiva Dry-Fit", "Nike", "Deportiva",
//				"Camiseta deportiva con tecnología de secado rápido", "https://example.com/camiseta_nike.jpg", 80000,
//				15, "CAM003", "M", "Hombre", "Poliéster", "Manga corta", "Redondo", true));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Oversize", "Adidas", "Urbana", "Camiseta ancha estilo urbano",
//				"https://example.com/camiseta_adidas.jpg", 70000, 12, "CAM004", "XL", "Unisex", "Algodón",
//				"Manga corta", "Redondo", false));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Crop Top", "Bershka", "Moda",
//				"Camiseta corta para looks juveniles", "https://example.com/camiseta_crop.jpg", 60000, 18, "CAM005",
//				"S", "Mujer", "Algodón", "Manga corta", "Redondo", true));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Polo Clásica", "Lacoste", "Casual",
//				"Camiseta polo con cuello y botones", "https://example.com/camiseta_polo.jpg", 120000, 10, "CAM006",
//				"L", "Hombre", "Algodón Piqué", "Manga corta", "Tipo polo", false));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Manga Larga", "Pull&Bear", "Casual",
//				"Camiseta manga larga de algodón", "https://example.com/camiseta_larga.jpg", 55000, 14, "CAM007", "M",
//				"Unisex", "Algodón", "Manga larga", "Redondo", false));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Estampada Rock", "Forever21", "Urbana",
//				"Camiseta con estampado de banda de rock", "https://example.com/camiseta_rock.jpg", 48000, 25, "CAM008",
//				"L", "Unisex", "Algodón", "Manga corta", "Redondo", true));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Running Mujer", "Under Armour", "Deportiva",
//				"Camiseta ligera para correr", "https://example.com/camiseta_running.jpg", 85000, 9, "CAM009", "S",
//				"Mujer", "Poliéster", "Manga corta", "Redondo", false));
//
//		listaCamisetas.add(new CamisetaDTO("Camiseta Termica", "The North Face", "Outdoor",
//				"Camiseta térmica para climas fríos", "https://example.com/camiseta_termica.jpg", 130000, 6, "CAM010",
//				"M", "Unisex", "Poliéster térmico", "Manga larga", "Redondo", false));
//		
//		igualarListas();
		leerLista();
		
	}
	
	public void igualarListas() {
		ModelFacade.getCamisetaDAO().getListaCamiseta()
				.addAll(DataMapper.listaCamisetaDTOToListaCamiseta((ArrayList<CamisetaDTO>) listaCamisetas));
		ModelFacade.getCamisetaDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getCamisetaDAO().cargarDesdeArchivo();
		listaCamisetas = DataMapper.listaCamisetaToListaCamisetaDTO(ModelFacade.getCamisetaDAO().getListaCamiseta());
	}
	public List<CamisetaDTO> getProducts() {
		return new ArrayList<>(listaCamisetas);
	}

	public List<CamisetaDTO> getProducts(int size) {

		if (size > listaCamisetas.size()) {
			Random rand = new Random();

			List<CamisetaDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCamisetas.size());
				randomList.add(listaCamisetas.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCamisetas.subList(0, size));
		}

	}

	public List<CamisetaDTO> getClonedProducts(int size) {
		List<CamisetaDTO> results = new ArrayList<>();
		List<CamisetaDTO> originals = getProducts(size);
		for (CamisetaDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (CamisetaDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
