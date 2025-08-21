package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.LegoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de productos LEGO.
 * <p>
 * Esta clase administra una lista de {@link LegoDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de LEGO.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class LegoService {

    /** Lista que almacena los productos LEGO disponibles */
    private List<LegoDTO> listaLegos;

    /**
     * Inicializa la lista de LEGO con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaLegos= new ArrayList<>();

        listaLegos.add(new LegoDTO("Lego Star Wars X-Wing", "LEGO", "Juguete",
                "Nave X-Wing de Star Wars con piezas detalladas", "https://example.com/lego_xwing.jpg",
                450000, 10, "LEGO001", 9, "Star Wars", 747, true));

        listaLegos.add(new LegoDTO("Lego Harry Potter Castillo Hogwarts", "LEGO", "Juguete",
                "Castillo de Hogwarts con múltiples detalles mágicos", "https://example.com/lego_hogwarts.jpg",
                1200000, 5, "LEGO002", 12, "Harry Potter", 6020, true));

        listaLegos.add(new LegoDTO("Lego Technic Bugatti Chiron", "LEGO", "Juguete",
                "Modelo detallado del Bugatti Chiron de la línea Technic", "https://example.com/lego_bugatti.jpg",
                1800000, 3, "LEGO003", 16, "Technic", 3599, false));

        listaLegos.add(new LegoDTO("Lego City Estación de Bomberos", "LEGO", "Juguete",
                "Estación de bomberos con camión y helicóptero", "https://example.com/lego_bomberos.jpg",
                380000, 12, "LEGO004", 6, "City", 509, true));

        listaLegos.add(new LegoDTO("Lego Friends Cafetería Heartlake", "LEGO", "Juguete",
                "Cafetería con personajes de la serie Friends de LEGO", "https://example.com/lego_cafe.jpg",
                280000, 15, "LEGO005", 7, "Friends", 315, true));

        listaLegos.add(new LegoDTO("Lego Creator Casa Modular", "LEGO", "Juguete",
                "Casa modular 3 en 1 para armar diferentes estructuras", "https://example.com/lego_casa.jpg",
                520000, 8, "LEGO006", 8, "Creator", 1477, false));

        listaLegos.add(new LegoDTO("Lego Marvel Iron Man Hall of Armor", "LEGO", "Juguete",
                "Sala de armaduras de Iron Man con minifiguras", "https://example.com/lego_ironman.jpg",
                390000, 9, "LEGO007", 9, "Marvel", 524, true));

        listaLegos.add(new LegoDTO("Lego Ninjago Templo del Dragón", "LEGO", "Juguete",
                "Templo de los dragones de la serie Ninjago", "https://example.com/lego_ninjago.jpg",
                670000, 6, "LEGO008", 10, "Ninjago", 1171, true));

        listaLegos.add(new LegoDTO("Lego Architecture Estatua de la Libertad", "LEGO", "Juguete",
                "Modelo detallado de la Estatua de la Libertad", "https://example.com/lego_liberty.jpg",
                950000, 4, "LEGO009", 16, "Architecture", 1685, false));

        listaLegos.add(new LegoDTO("Lego Disney Castillo de Frozen", "LEGO", "Juguete",
                "Castillo de Elsa y Anna inspirado en Frozen", "https://example.com/lego_frozen.jpg",
                500000, 7, "LEGO010", 6, "Disney", 701, true));

        igualarListas();
        leerLista();
    }

    /**
     * Sincroniza la lista de LEGO con el DAO persistente.
     * <p>
     * Convierte los {@link LegoDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getLegoDAO().getListaLego()
                .addAll(DataMapper.listaLegoDTOToListaLego((ArrayList<LegoDTO>) listaLegos));
        ModelFacade.getLegoDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de LEGO desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getLegoDAO().cargarDesdeArchivo();
        listaLegos = DataMapper.listaLegoToListaLegoDTO(ModelFacade.getLegoDAO().getListaLego());
    }

    /**
     * Obtiene la lista completa de LEGO.
     * 
     * @return {@link List} de {@link LegoDTO} con todos los productos LEGO
     */
    public List<LegoDTO> getProducts() {
        return new ArrayList<>(listaLegos);
    }

    /**
     * Obtiene una sublista de LEGO o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de productos LEGO a obtener
     * @return {@link List} de {@link LegoDTO} con los productos seleccionados
     */
    public List<LegoDTO> getProducts(int size) {

        if (size > listaLegos.size()) {
            Random rand = new Random();

            List<LegoDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaLegos.size());
                randomList.add(listaLegos.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaLegos.subList(0, size));
        }

    }

    /**
     * Clona los productos LEGO obtenidos y asegura códigos únicos.
     * 
     * @param size Número de productos LEGO a clonar
     * @return {@link List} de {@link LegoDTO} con los productos clonados y con ID único
     */
    public List<LegoDTO> getClonedProducts(int size) {
        List<LegoDTO> results = new ArrayList<>();
        List<LegoDTO> originals = getProducts(size);
        for (LegoDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (LegoDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
