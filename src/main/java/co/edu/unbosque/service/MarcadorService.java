package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.MarcadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class MarcadorService {
	private List<MarcadorDTO> listaMarcadores;

	@PostConstruct
	public void init() {
		listaMarcadores = new ArrayList<>();

//		listaMarcadores.add(new MarcadorDTO("Marcador Permanente Azul", "Sharpie", "Marcador",
//				"Marcador de tinta permanente azul", "https://example.com/marcador_azul.jpg", 4500, 60, "MAR001",
//				"Unidad", "Fina", true, "Permanente"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Borrable Negro", "Expo", "Marcador",
//				"Marcador borrable para tablero acrílico", "https://example.com/marcador_borrable.jpg", 5200, 45,
//				"MAR002", "Unidad", "Mediana", false, "Borrable"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Resaltador Amarillo", "Stabilo", "Marcador",
//				"Resaltador amarillo fluorescente", "https://example.com/marcador_amarillo.jpg", 3800, 100, "MAR003",
//				"Unidad", "Biselada", false, "Resaltador"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Permanente Negro", "Pilot", "Marcador",
//				"Marcador negro resistente al agua", "https://example.com/marcador_negro.jpg", 4900, 70, "MAR004",
//				"Unidad", "Gruesa", true, "Permanente"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Resaltador Verde", "Faber-Castell", "Marcador",
//				"Resaltador verde para estudio", "https://example.com/marcador_verde.jpg", 3900, 80, "MAR005", "Unidad",
//				"Biselada", false, "Resaltador"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Borrable Rojo", "Expo", "Marcador",
//				"Marcador borrable color rojo para tablero", "https://example.com/marcador_rojo.jpg", 5000, 55,
//				"MAR006", "Unidad", "Mediana", false, "Borrable"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Permanente Verde", "Sharpie", "Marcador",
//				"Marcador verde de larga duración", "https://example.com/marcador_verde.jpg", 4700, 65, "MAR007",
//				"Unidad", "Fina", true, "Permanente"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Resaltador Naranja", "Stabilo", "Marcador",
//				"Resaltador naranja fluorescente", "https://example.com/marcador_naranja.jpg", 4000, 90, "MAR008",
//				"Unidad", "Biselada", false, "Resaltador"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Borrable Azul", "Bic", "Marcador",
//				"Marcador azul borrable para tablero", "https://example.com/marcador_borrable_azul.jpg", 4800, 50,
//				"MAR009", "Unidad", "Gruesa", false, "Borrable"));
//
//		listaMarcadores.add(new MarcadorDTO("Marcador Permanente Rojo", "Pilot", "Marcador",
//				"Marcador rojo resistente y permanente", "https://example.com/marcador_rojo.jpg", 4600, 75, "MAR010",
//				"Unidad", "Mediana", true, "Permanente"));
//		igualarListas();
		leerLista();
		
	}
	
	public void igualarListas() {
		ModelFacade.getMarcadorDAO().getlistaMarcadores()
				.addAll(DataMapper.listaMarcadorDTOToListaMarcador((ArrayList<MarcadorDTO>) listaMarcadores));
		ModelFacade.getMarcadorDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getMarcadorDAO().cargarDesdeArchivo();
		listaMarcadores = DataMapper.listaMarcadorToListaMarcadorDTO(ModelFacade.getMarcadorDAO().getlistaMarcadores());
	}
	public List<MarcadorDTO> getProducts() {
		return new ArrayList<>(listaMarcadores);
	}

	public List<MarcadorDTO> getProducts(int size) {

		if (size > listaMarcadores.size()) {
			Random rand = new Random();

			List<MarcadorDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaMarcadores.size());
				randomList.add(listaMarcadores.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaMarcadores.subList(0, size));
		}

	}

	public List<MarcadorDTO> getClonedProducts(int size) {
		List<MarcadorDTO> results = new ArrayList<>();
		List<MarcadorDTO> originals = getProducts(size);
		for (MarcadorDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (MarcadorDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
