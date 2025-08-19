package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CuadernoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CuadernoService {
	private List<CuadernoDTO> listaCuadernos;

	@PostConstruct
	public void init() {
		listaCuadernos = new ArrayList<>();

//		listaCuadernos.add(new CuadernoDTO("Cuaderno Universitario 100 Hojas", "Norma", "Cuaderno",
//				"Espiral, hojas rayadas", "https://example.com/cuaderno_universitario.jpg", 12500, 60, "CUA001",
//				"Espiral", "Rayadas", 100, true));
//
//		listaCuadernos.add(new CuadernoDTO("Cuaderno Profesional 80 Hojas", "Scribe", "Cuaderno",
//				"Argollado resistente", "https://example.com/cuaderno_profesional.jpg", 9800, 40, "CUA002", "Argollado",
//				"Cuadriculadas", 80, true));
//
//		listaCuadernos.add(new CuadernoDTO("Cuaderno Cosido 50 Hojas", "Norma", "Cuaderno", "Formato escolar",
//				"https://example.com/cuaderno_cosido.jpg", 6500, 70, "CUA003", "Cosido", "Rayadas", 50, false));
//
//		listaCuadernos.add(new CuadernoDTO("Cuaderno Dotted A5", "Moleskine", "Cuaderno",
//				"Punteado para bullet journal", "https://example.com/cuaderno_dotted.jpg", 55000, 15, "CUA004",
//				"Espiral", "Punteadas", 192, true));
//
//		listaCuadernos.add(new CuadernoDTO("Sketchbook Artista", "Canson", "Cuaderno", "Papel liso para dibujo",
//				"https://example.com/cuaderno_sketch.jpg", 32000, 20, "CUA005", "Espiral", "Lisas", 120, true));
//
//		listaCuadernos.add(new CuadernoDTO("Cuaderno Milimetrado", "Oxford", "Cuaderno", "Ideal para diagramas",
//				"https://example.com/cuaderno_milimetrado.jpg", 14000, 25, "CUA006", "Espiral", "Milimetradas", 80,
//				false));
//
//		listaCuadernos.add(new CuadernoDTO("Cuaderno Reciclado 90 Hojas", "EcoPaper", "Cuaderno",
//				"Hecho con papel reciclado", "https://example.com/cuaderno_reciclado.jpg", 11000, 30, "CUA007",
//				"Argollado", "Recicladas", 90, true));
//
//		listaCuadernos.add(new CuadernoDTO("Bloc de Notas A6", "Post-it", "Cuaderno", "Empaque x3, tamaño bolsillo",
//				"https://example.com/bloc_notas.jpg", 7500, 100, "CUA008", "Empaque x3", "Lisas", 150, false));
//
//		listaCuadernos.add(new CuadernoDTO("Cuaderno Inteligente", "Rocketbook", "Cuaderno",
//				"Hojas borrables y reutilizables", "https://example.com/cuaderno_inteligente.jpg", 89000, 8, "CUA009",
//				"Espiral", "Borrables", 36, true));
//
//		listaCuadernos.add(new CuadernoDTO("Cuaderno Escolar 100 Hojas", "Kores", "Cuaderno", "Cosido, uso escolar",
//				"https://example.com/cuaderno_escolar.jpg", 8200, 80, "CUA010", "Cosido", "Rayadas", 100, false));
//		igualarListas();
		leerLista();

	}

	public void igualarListas() {
		ModelFacade.getCuadernoDAO().getlistaCuadernos()
				.addAll(DataMapper.listaCuadernoDTOToListaCuaderno((ArrayList<CuadernoDTO>) listaCuadernos));
		ModelFacade.getCuadernoDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getCorrectorDAO().cargarDesdeArchivo();
		listaCuadernos = DataMapper.listaCuadernoToListaCuadernoDTO(ModelFacade.getCuadernoDAO().getlistaCuadernos());
	}
	public List<CuadernoDTO> getProducts() {
		return new ArrayList<>(listaCuadernos);
	}

	public List<CuadernoDTO> getProducts(int size) {

		if (size > listaCuadernos.size()) {
			Random rand = new Random();

			List<CuadernoDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCuadernos.size());
				randomList.add(listaCuadernos.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCuadernos.subList(0, size));
		}

	}

	public List<CuadernoDTO> getClonedProducts(int size) {
		List<CuadernoDTO> results = new ArrayList<>();
		List<CuadernoDTO> originals = getProducts(size);
		for (CuadernoDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (CuadernoDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
