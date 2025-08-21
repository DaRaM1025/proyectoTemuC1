package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CorrectorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de correctores de maquillaje.
 * <p>
 * Esta clase administra una lista de {@link CorrectorDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de productos.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class CorrectorService {

    /** Lista que almacena los correctores disponibles */
    private List<CorrectorDTO> listaCorrectores;

    /**
     * Inicializa la lista de correctores con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaCorrectores = new ArrayList<>();
        listaCorrectores.add(new CorrectorDTO("Corrector Fit Me", "Maybelline", "Líquido",
                "Corrector líquido de cobertura media", "assets/corrector1.jpeg", 35000, 20, "C001", "Mixta",
                true, "2026-05-12", "Media", "Tubito"));

        listaCorrectores.add(new CorrectorDTO("Corrector True Match", "L'Oréal", "Líquido",
                "Corrector de larga duración con acabado natural", "assets/corrector2.jpeg", 42000, 15,
                "C002", "Grasa", false, "2027-01-20", "Alta", "Tubito"));

        listaCorrectores.add(new CorrectorDTO("Corrector Colorstay", "Revlon", "Líquido",
                "Corrector resistente al agua con cobertura completa", "assets/corrector3.jpeg", 48000, 18,
                "C003", "Seca", true, "2026-10-05", "Total", "Barra"));

        listaCorrectores.add(new CorrectorDTO("Corrector Pro Longwear", "MAC", "Líquido",
                "Corrector profesional de larga duración", "assets/corrector4.jpeg", 95000, 12, "C004",
                "Mixta", true, "2027-03-14", "Alta", "Pump"));

        listaCorrectores.add(new CorrectorDTO("Corrector HD", "NYX", "Líquido", "Corrector HD para fotografía y video",
                "assets/corrector5.jpeg", 38000, 25, "C005", "Normal", false, "2026-12-01", "Media", "Tubito"));

        listaCorrectores.add(new CorrectorDTO("Corrector Even Better", "Clinique", "Crema",
                "Corrector con propiedades hidratantes", "assets/corrector6.jpeg", 87000, 10, "C006",
                "Seca", true, "2027-07-21", "Media", "Crema"));

        listaCorrectores.add(new CorrectorDTO("Corrector Bright Future", "Sephora", "Líquido",
                "Corrector ligero para iluminar la mirada", "assets/corrector7.jpeg", 55000, 14, "C007",
                "Grasa", false, "2026-09-17", "Ligera", "Tubito"));

        listaCorrectores.add(new CorrectorDTO("Corrector Naked Skin", "Urban Decay", "Líquido",
                "Corrector de acabado natural y cobertura modulable", "assets/corrector8.jpeg", 115000, 8,
                "C008", "Mixta", true, "2027-05-05", "Media", "Tubito"));

        listaCorrectores.add(new CorrectorDTO("Corrector Camouflage", "Essence", "Crema",
                "Corrector económico de cobertura total", "assets/corrector9.jpeg", 25000, 30, "C009",
                "Normal", false, "2026-11-30", "Total", "Crema"));

        listaCorrectores.add(new CorrectorDTO("Corrector Overachiever", "Huda Beauty", "Líquido",
                "Corrector de alta cobertura y duración extrema", "assets/corrector10.jpeg", 135000, 6,
                "C010", "Seca", true, "2027-08-10", "Total", "Tubito"));

        igualarListas();
        leerLista();

    }

    /**
     * Sincroniza la lista de correctores con el DAO persistente.
     * <p>
     * Convierte los {@link CorrectorDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getCorrectorDAO().getListaCorrectores()
                .addAll(DataMapper.listaCorrectorDTOToListaCorrector((ArrayList<CorrectorDTO>) listaCorrectores));
        ModelFacade.getCorrectorDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de correctores desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getCorrectorDAO().cargarDesdeArchivo();
        listaCorrectores = DataMapper.listaCorrectorToListaCorrectorDTO(ModelFacade.getCorrectorDAO().getListaCorrectores());
    }

    /**
     * Obtiene la lista completa de correctores.
     * 
     * @return {@link List} de {@link CorrectorDTO} con todos los correctores
     */
    public List<CorrectorDTO> getProducts() {
        return new ArrayList<>(listaCorrectores);
    }

    /**
     * Obtiene una sublista de correctores o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de correctores a obtener
     * @return {@link List} de {@link CorrectorDTO} con los productos seleccionados
     */
    public List<CorrectorDTO> getProducts(int size) {

        if (size > listaCorrectores.size()) {
            Random rand = new Random();

            List<CorrectorDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaCorrectores.size());
                randomList.add(listaCorrectores.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaCorrectores.subList(0, size));
        }

    }

    /**
     * Clona los correctores obtenidos y asegura códigos únicos.
     * 
     * @param size Número de correctores a clonar
     * @return {@link List} de {@link CorrectorDTO} con los productos clonados y con ID único
     */
    public List<CorrectorDTO> getClonedProducts(int size) {
        List<CorrectorDTO> results = new ArrayList<>();
        List<CorrectorDTO> originals = getProducts(size);
        for (CorrectorDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (CorrectorDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
