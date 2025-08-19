package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CamisetaDTO;
import co.edu.unbosque.model.ComputadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class ComputadorService {
	private List<ComputadorDTO> listaComputadores;

	@PostConstruct
	public void init() {
		listaComputadores = new ArrayList<>();

//		listaComputadores.add(
//				new ComputadorDTO("MacBook Pro 16", "Apple", "Portátil", "Portátil de alto rendimiento con chip M1 Pro",
//						"https://example.com/macbookpro16.jpg", 12000000, 5, "COMP001", 16.0, "3072x1920",
//						"macOS Monterey", "1TB SSD", "16GB", "Portátil", "Apple M1 Pro", "Integrada"));
//
//		listaComputadores.add(new ComputadorDTO("XPS 13", "Dell", "Portátil",
//				"Ultrabook compacto con pantalla InfinityEdge", "https://example.com/xps13.jpg", 7500000, 8, "COMP002",
//				13.4, "1920x1200", "Windows 11", "512GB SSD", "16GB", "Portátil", "Intel i7-1260P", "Integrada"));
//
//		listaComputadores
//				.add(new ComputadorDTO("Legion 5 Pro", "Lenovo", "Gaming", "Portátil gamer con gráficos NVIDIA RTX",
//						"https://example.com/legion5pro.jpg", 9500000, 10, "COMP003", 16.0, "2560x1600", "Windows 11",
//						"1TB SSD", "32GB", "Portátil", "AMD Ryzen 7 5800H", "NVIDIA RTX 3070"));
//
//		listaComputadores.add(new ComputadorDTO("ROG Zephyrus G14", "Asus", "Gaming",
//				"Portátil gamer ultraligero con gran rendimiento", "https://example.com/rogzephyrusg14.jpg", 8700000, 6,
//				"COMP004", 14.0, "2560x1440", "Windows 11", "1TB SSD", "16GB", "Portátil", "AMD Ryzen 9 5900HS",
//				"NVIDIA RTX 3060"));
//
//		listaComputadores.add(
//				new ComputadorDTO("Predator Helios 300", "Acer", "Gaming", "Portátil gamer con refrigeración avanzada",
//						"https://example.com/helios300.jpg", 8200000, 7, "COMP005", 15.6, "1920x1080", "Windows 11",
//						"512GB SSD", "16GB", "Portátil", "Intel i7-11800H", "NVIDIA RTX 3060"));
//
//		listaComputadores.add(new ComputadorDTO("ThinkPad X1 Carbon", "Lenovo", "Ejecutivo",
//				"Portátil empresarial ligero y resistente", "https://example.com/thinkpadx1.jpg", 9800000, 4, "COMP006",
//				14.0, "1920x1200", "Windows 11 Pro", "1TB SSD", "16GB", "Portátil", "Intel i7-1260P", "Integrada"));
//
//		listaComputadores.add(new ComputadorDTO("Inspiron 15", "Dell", "Portátil", "Portátil versátil para uso diario",
//				"https://example.com/inspiron15.jpg", 3500000, 15, "COMP007", 15.6, "1920x1080", "Windows 11",
//				"512GB SSD", "8GB", "Portátil", "Intel i5-1135G7", "Integrada"));
//
//		listaComputadores.add(
//				new ComputadorDTO("Pavilion Gaming 15", "HP", "Gaming", "Portátil gamer accesible con buen rendimiento",
//						"https://example.com/paviliongaming15.jpg", 5200000, 12, "COMP008", 15.6, "1920x1080",
//						"Windows 11", "512GB SSD", "16GB", "Portátil", "AMD Ryzen 5 5600H", "NVIDIA GTX 1650"));
//
//		listaComputadores.add(
//				new ComputadorDTO("Surface Laptop 4", "Microsoft", "Portátil", "Ultrabook premium con pantalla táctil",
//						"https://example.com/surfacelaptop4.jpg", 7200000, 9, "COMP009", 13.5, "2256x1504",
//						"Windows 11", "512GB SSD", "16GB", "Portátil", "Intel i7-1185G7", "Integrada"));
//
//		listaComputadores
//				.add(new ComputadorDTO("Omen 17", "HP", "Gaming", "Portátil gamer de 17 pulgadas con gran potencia",
//						"https://example.com/omen17.jpg", 10500000, 3, "COMP010", 17.3, "2560x1440", "Windows 11",
//						"1TB SSD", "32GB", "Portátil", "Intel i9-12900H", "NVIDIA RTX 3080"));
//		igualarListas();
		leerLista();
		
	}
	
	public void igualarListas() {
		ModelFacade.getComputadorDAO().getListaComputador()
				.addAll(DataMapper.listaComputadorDTOToListaComputador((ArrayList<ComputadorDTO>) listaComputadores));
		ModelFacade.getComputadorDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getComputadorDAO().cargarDesdeArchivo();
		listaComputadores = DataMapper.listaComputadorToListaComputadorDTO(ModelFacade.getComputadorDAO().getListaComputador());
	}
	public List<ComputadorDTO> getProducts() {
		return new ArrayList<>(listaComputadores);
	}

	public List<ComputadorDTO> getProducts(int size) {

		if (size > listaComputadores.size()) {
			Random rand = new Random();

			List<ComputadorDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaComputadores.size());
				randomList.add(listaComputadores.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaComputadores.subList(0, size));
		}

	}

	public List<ComputadorDTO> getClonedProducts(int size) {
		List<ComputadorDTO> results = new ArrayList<>();
		List<ComputadorDTO> originals = getProducts(size);
		for (ComputadorDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (ComputadorDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
