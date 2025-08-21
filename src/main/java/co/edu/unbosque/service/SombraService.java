package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.SombraDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de productos tipo Sombra de maquillaje.
 * <p>
 * Esta clase administra una lista de {@link SombraDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de sombras.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class SombraService {

    /** Lista que almacena los productos tipo Sombra disponibles */
    private List<SombraDTO> listaSombras;

    /**
     * Inicializa la lista de sombras con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaSombras = new ArrayList<>();
        listaSombras.add(
                new SombraDTO("Sombra Nude", "Maybelline", "Polvo compacto", "Paleta de tonos nude para uso diario",
                        "assets/sombra1.jpeg", 45000, 20, "S001", "Mixta", true, "2026-05-12", 12, "Mate"));
        listaSombras.add(new SombraDTO("Sombra Brillante", "L'Oréal", "Polvo suelto", "Sombras con acabado brillante",
                "assets/sombra2.jpeg", 52000, 15, "S002", "Grasa", false, "2027-01-20", 8, "Satinado"));
        listaSombras.add(new SombraDTO("Sombra Natural", "Revlon", "Paleta", "Colores neutros para looks naturales",
                "assets/sombra3.jpeg", 60000, 25, "S003", "Seca", true, "2026-10-05", 10, "Mate"));
        listaSombras.add(new SombraDTO("Sombra Intensa", "MAC", "Polvo compacto", "Sombras de alta pigmentación",
                "assets/sombra4.jpeg", 90000, 12, "S004", "Mixta", true, "2027-03-14", 16, "Metálico"));
        listaSombras.add(new SombraDTO("Sombra Fiesta", "NYX", "Paleta", "Paleta colorida para fiestas",
                "assets/sombra5.jpeg", 75000, 18, "S005", "Normal", false, "2026-12-01", 20, "Brillante"));
        listaSombras.add(new SombraDTO("Sombra Elegante", "Clinique", "Polvo suelto", "Sombras discretas y elegantes",
                "assets/sombra6.jpeg", 82000, 10, "S006", "Seca", true, "2027-07-21", 6, "Mate"));
        listaSombras.add(new SombraDTO("Sombra Tropical", "Sephora", "Paleta", "Colores vivos inspirados en el trópico",
                "assets/sombra7.jpeg", 98000, 14, "S007", "Grasa", false, "2026-09-17", 18, "Metálico"));
        listaSombras.add(new SombraDTO("Sombra Profesional", "Urban Decay", "Paleta", "Sombras profesionales de alta duración",
                        "assets/sombra8.jpeg", 120000, 8, "S008", "Mixta", true, "2027-05-05", 24, "Brillante"));
        listaSombras.add(new SombraDTO("Sombra Minimalista", "Essence", "Polvo compacto", "Sombras básicas y económicas",
                        "assets/sombra9.jpeg", 30000, 30, "S009", "Normal", false, "2026-11-30", 4, "Mate"));
        listaSombras.add(new SombraDTO("Sombra Glam", "Huda Beauty", "Paleta", "Sombras glamorosas con acabado satinado",
                        "assets/sombra10.jpeg", 135000, 6, "S010", "Seca", true, "2027-08-10", 28, "Satinado"));
        igualarListas();
        leerLista();
    }

    /**
     * Sincroniza la lista de sombras con el DAO persistente.
     * <p>
     * Convierte los {@link SombraDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getSombraDAO().getlistaSombras()
                .addAll(DataMapper.listaSombraDTOToListaTelevisor((ArrayList<SombraDTO>) listaSombras));
        ModelFacade.getSombraDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de sombras desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getSombraDAO().cargarDesdeArchivo();
        listaSombras = DataMapper.listaSombraToListaSombraDTO(ModelFacade.getSombraDAO().getlistaSombras());
    }

    /**
     * Obtiene la lista completa de sombras.
     * 
     * @return {@link List} de {@link SombraDTO} con todos los productos
     */
    public List<SombraDTO> getProducts() {
        return new ArrayList<>(listaSombras);
    }

    /**
     * Obtiene una sublista de sombras o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de productos a obtener
     * @return {@link List} de {@link SombraDTO} con los productos seleccionados
     */
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

    /**
     * Clona los productos obtenidos y asegura códigos únicos.
     * 
     * @param size Número de productos a clonar
     * @return {@link List} de {@link SombraDTO} con los productos clonados y con ID único
     */
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
