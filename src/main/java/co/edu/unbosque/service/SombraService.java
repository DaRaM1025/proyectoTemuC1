package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.SombraDTO;
import jakarta.annotation.PostConstruct;

public class SombraService {
private List<SombraDTO> listaSombras;
	
	@PostConstruct
	public void init() {
		listaSombras = new ArrayList<SombraDTO>();
		listaSombras.add(new SombraDTO("Labial Rojo", "L'Oréal", "Labial", "Labial color rojo intenso para que luzcas increible en todo momento ", "assets/prueba.jpeg", 25000, 50, "L001", "Mixta", true, "2026-05-01"));
        listaSombras.add(new SombraDTO("Labial Nude", "Maybelline", "Labial", "Tono nude", "img/nude.jpg", 23000, 30, "L002", "Seca", false, "2025-12-31"));
        listaSombras.add(new SombraDTO("Labial Rosa", "Revlon", "Labial", "Rosa suave", "img/rosa.jpg", 27000, 20, "L003", "Grasa", true, "2026-02-15"));
        listaSombras.add(new SombraDTO("Labial Vino", "MAC", "Labial", "Color vino", "img/vino.jpg", 45000, 15, "L004", "Mixta", true, "2027-01-20"));
        listaSombras.add(new SombraDTO("Labial Coral", "NYX", "Labial", "Coral brillante", "img/coral.jpg", 21000, 40, "L005", "Normal", false, "2025-11-10"));
        listaSombras.add(new SombraDTO("Labial Marrón", "Avon", "Labial", "Marrón oscuro", "img/marron.jpg", 18000, 25, "L006", "Mixta", false, "2026-03-30"));
        listaSombras.add(new SombraDTO("Labial Fucsia", "Clinique", "Labial", "Fucsia vibrante", "img/fucsia.jpg", 39000, 18, "L007", "Seca", true, "2026-07-07"));
        listaSombras.add(new SombraDTO("Labial Durazno", "Sephora", "Labial", "Durazno pastel", "img/durazno.jpg", 35000, 12, "L008", "Grasa", false, "2025-09-25"));
        listaSombras.add(new SombraDTO("Labial Morado", "Estée Lauder", "Labial", "Morado elegante", "img/morado.jpg", 52000, 10, "L009", "Normal", true, "2027-04-12"));
        listaSombras.add(new SombraDTO("Labial Transparente", "E.L.F.", "Labial", "Gloss transparente", "img/gloss.jpg", 15000, 35, "L010", "Mixta", false, "2026-08-18"));
	}
	
	 public List<SombraDTO> getProducts() {
	        return new ArrayList<>(listaSombras);
	    }

	    public List<SombraDTO> getProducts(int size) {

	        if (size > listaSombras.size()) {
	            Random rand = new Random();

	            List<SombraDTO> randomList = new ArrayList<>();
	            for (int i = 0; i < size; i++) {
	                int randomIndex = rand.nextInt(listaSombras.size());
	                randomList.add(listaSombras.get(randomIndex));
	            }

	            return randomList;
	        }

	        else {
	            return new ArrayList<>(listaSombras.subList(0, size));
	        }

	    }

	    public List<SombraDTO> getClonedProducts(int size) {
	        List<SombraDTO> results = new ArrayList<>();
	        List<SombraDTO> originals = getProducts(size);
	        for (SombraDTO original : originals) {
	            results.add(original.clone());
	        }

	        // make sure to have unique codes
	        for (SombraDTO product : results) {
	            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
	        }

	        return results;
	    }

}
