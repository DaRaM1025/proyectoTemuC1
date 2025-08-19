package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CelularDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class CelularService {
	private List<CelularDTO> listaCelulares;

	@PostConstruct
	public void init() {
		listaCelulares = new ArrayList<>();

//		listaCelulares.add(new CelularDTO("Galaxy S23 Ultra", "Samsung", "Smartphone",
//				"Celular de alta gama con cámara de 200 MP y pantalla AMOLED",
//				"https://example.com/galaxy_s23_ultra.jpg", 5200000, 15, "CEL001", 6.8, "3088x1440", "Android 13",
//				"512GB", "12GB", 4, true));
//
//		listaCelulares.add(new CelularDTO("iPhone 14 Pro Max", "Apple", "Smartphone",
//				"Última generación con chip A16 Bionic y pantalla Super Retina XDR",
//				"https://example.com/iphone_14_pro_max.jpg", 6300000, 10, "CEL002", 6.7, "2796x1290", "iOS 16", "1TB",
//				"6GB", 3, true));
//
//		listaCelulares.add(new CelularDTO("Xiaomi 13T Pro", "Xiaomi", "Smartphone",
//				"Smartphone con cámara Leica y carga ultra rápida de 120W", "https://example.com/xiaomi_13t_pro.jpg",
//				2800000, 20, "CEL003", 6.67, "2712x1220", "Android 13", "256GB", "12GB", 3, true));
//
//		listaCelulares.add(new CelularDTO("Motorola Edge 40", "Motorola", "Smartphone",
//				"Celular con diseño elegante, pantalla OLED y carga rápida", "https://example.com/motorola_edge_40.jpg",
//				2100000, 25, "CEL004", 6.55, "2400x1080", "Android 13", "256GB", "8GB", 2, true));
//
//		listaCelulares.add(new CelularDTO("OnePlus 11 5G", "OnePlus", "Smartphone",
//				"Teléfono con Snapdragon 8 Gen 2 y pantalla AMOLED 120Hz", "https://example.com/oneplus_11.jpg",
//				3500000, 18, "CEL005", 6.7, "3216x1440", "Android 13", "256GB", "16GB", 3, true));
//
//		listaCelulares.add(new CelularDTO("Huawei P50 Pro", "Huawei", "Smartphone",
//				"Smartphone con cámara Leica y diseño premium", "https://example.com/huawei_p50_pro.jpg", 4000000, 12,
//				"CEL006", 6.6, "2700x1228", "HarmonyOS 3", "256GB", "8GB", 4, false));
//
//		listaCelulares.add(new CelularDTO("Google Pixel 7 Pro", "Google", "Smartphone",
//				"Celular con cámara avanzada y Android puro", "https://example.com/pixel_7_pro.jpg", 4500000, 8,
//				"CEL007", 6.7, "3120x1440", "Android 13", "128GB", "12GB", 3, true));
//
//		listaCelulares.add(new CelularDTO("Sony Xperia 1 IV", "Sony", "Smartphone",
//				"Celular con pantalla 4K OLED y cámaras de alta calidad", "https://example.com/sony_xperia_1_iv.jpg",
//				4700000, 6, "CEL008", 6.5, "3840x1644", "Android 13", "512GB", "12GB", 4, false));
//
//		listaCelulares.add(new CelularDTO("Realme GT Neo 5", "Realme", "Smartphone",
//				"Smartphone con carga rápida de 240W y gran rendimiento", "https://example.com/realme_gt_neo5.jpg",
//				2300000, 22, "CEL009", 6.74, "2772x1240", "Android 13", "256GB", "16GB", 3, true));
//
//		listaCelulares.add(new CelularDTO("Oppo Find X6 Pro", "Oppo", "Smartphone",
//				"Celular con cámara Hasselblad y Snapdragon 8 Gen 2", "https://example.com/oppo_find_x6_pro.jpg",
//				4800000, 9, "CEL010", 6.82, "3168x1440", "Android 13", "512GB", "16GB", 3, true));
//		igualarListas();
		leerLista();

	}

	public void igualarListas() {
		ModelFacade.getCelularDAO().getListaCelular()
				.addAll(DataMapper.listaCelularDTOToListaCelular((ArrayList<CelularDTO>) listaCelulares));
		ModelFacade.getCelularDAO().escribirEnArchivo();
	}

	public void leerLista() {
		ModelFacade.getCelularDAO().cargarDesdeArchivo();
		listaCelulares = DataMapper.listaCelularToListaCelularDTO(ModelFacade.getCelularDAO().getListaCelular());
	}
	public List<CelularDTO> getProducts() {
		return new ArrayList<>(listaCelulares);
	}

	public List<CelularDTO> getProducts(int size) {

		if (size > listaCelulares.size()) {
			Random rand = new Random();

			List<CelularDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(listaCelulares.size());
				randomList.add(listaCelulares.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(listaCelulares.subList(0, size));
		}

	}

	public List<CelularDTO> getClonedProducts(int size) {
		List<CelularDTO> results = new ArrayList<>();
		List<CelularDTO> originals = getProducts(size);
		for (CelularDTO original : originals) {
			results.add(original.clone());
		}

		// make sure to have unique codes
		for (CelularDTO product : results) {
			product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
		}

		return results;
	}

}
