package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.LabialDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de labiales.
 * <p>
 * Esta clase administra una lista de {@link LabialDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de labiales.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class LabialService {

    /** Lista que almacena los labiales disponibles */
    private List<LabialDTO> listaLabial;

    /**
     * Inicializa la lista de labiales con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaLabial = new ArrayList<>();
        listaLabial.add(new LabialDTO("Labial Rojo", "L'Oréal", "Labial", "Labial color rojo intenso para que luzcas increible en todo momento ", "assets/labial1.jpeg", 25000, 50, "L001", "Mixta", true, "2026-05-01"));
        listaLabial.add(new LabialDTO("Labial Nude", "Maybelline", "Labial", "Tono nude", "assets/labial2.jpg", 23000, 30, "L002", "Seca", false, "2025-12-31"));
        listaLabial.add(new LabialDTO("Labial Rosa", "Revlon", "Labial", "Rosa suave", "assets/labial3.png", 27000, 20, "L003", "Grasa", true, "2026-02-15"));
        listaLabial.add(new LabialDTO("Labial Vino", "MAC", "Labial", "Color vino", "assets/labial4.jpeg", 45000, 15, "L004", "Mixta", true, "2027-01-20"));
        listaLabial.add(new LabialDTO("Labial Coral", "NYX", "Labial", "Coral brillante", "assets/labial5.jpeg", 21000, 40, "L005", "Normal", false, "2025-11-10"));
        listaLabial.add(new LabialDTO("Labial Marrón", "Avon", "Labial", "Marrón oscuro", "assets/labial6.jpeg", 18000, 25, "L006", "Mixta", false, "2026-03-30"));
        listaLabial.add(new LabialDTO("Labial Fucsia", "Clinique", "Labial", "Fucsia vibrante", "assets/labial7.png", 39000, 18, "L007", "Seca", true, "2026-07-07"));
        listaLabial.add(new LabialDTO("Labial Durazno", "Sephora", "Labial", "Durazno pastel", "assets/labial8.jpeg", 35000, 12, "L008", "Grasa", false, "2025-09-25"));
        listaLabial.add(new LabialDTO("Labial Morado", "Estée Lauder", "Labial", "Morado elegante", "assets/labial9.jpeg", 52000, 10, "L009", "Normal", true, "2027-04-12"));
        listaLabial.add(new LabialDTO("Labial Transparente", "E.L.F.", "Labial", "Gloss transparente", "assets/labial10.jpeg", 15000, 35, "L010", "Mixta", false, "2026-08-18"));
        igualarListas();
        leerLista();
    }

    /**
     * Sincroniza la lista de labiales con el DAO persistente.
     * <p>
     * Convierte los {@link LabialDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getLabialDAO().getListaLabiales()
                .addAll(DataMapper.listaLabialDTOToListaLabial((ArrayList<LabialDTO>) listaLabial));
        ModelFacade.getLabialDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de labiales desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getLabialDAO().cargarDesdeArchivo();
        listaLabial = DataMapper.listaLabialToListaLabialDTO(ModelFacade.getLabialDAO().getListaLabiales());
    }

    /**
     * Obtiene la lista completa de labiales.
     * 
     * @return {@link List} de {@link LabialDTO} con todos los labiales
     */
    public List<LabialDTO> getProducts() {
        return new ArrayList<>(listaLabial);
    }

    /**
     * Obtiene una sublista de labiales o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de labiales a obtener
     * @return {@link List} de {@link LabialDTO} con los productos seleccionados
     */
    public List<LabialDTO> getProducts(int size) {

        if (size > listaLabial.size()) {
            Random rand = new Random();

            List<LabialDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaLabial.size());
                randomList.add(listaLabial.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaLabial.subList(0, size));
        }

    }

    /**
     * Clona los labiales obtenidos y asegura códigos únicos.
     * 
     * @param size Número de labiales a clonar
     * @return {@link List} de {@link LabialDTO} con los productos clonados y con ID único
     */
    public List<LabialDTO> getClonedProducts(int size) {
        List<LabialDTO> results = new ArrayList<>();
        List<LabialDTO> originals = getProducts(size);
        for (LabialDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (LabialDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
