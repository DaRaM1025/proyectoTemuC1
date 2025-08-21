package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PantalonDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de productos tipo Pantalón.
 * <p>
 * Esta clase administra una lista de {@link PantalonDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de pantalones.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class PantalonService {

    /** Lista que almacena los productos tipo Pantalón disponibles */
    private List<PantalonDTO> listaPantalones;

    /**
     * Inicializa la lista de pantalones con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaPantalones = new ArrayList<>();

        listaPantalones.add(new PantalonDTO("Jeans Clásicos Azul", "Levi's", "Casual",
                "Jeans de mezclilla azul clásicos", "https://example.com/jeans_azul.jpg", 180000, 20, "PAN001", "32",
                "Hombre", "Denim", "Jeans", "Recto", "Largo"));

        listaPantalones.add(new PantalonDTO("Pantalón Chino Beige", "Zara", "Casual",
                "Pantalón chino beige elegante y cómodo", "https://example.com/chino_beige.jpg", 150000, 15, "PAN002",
                "30", "Hombre", "Algodón", "Chino", "Slim", "Largo"));

        listaPantalones.add(new PantalonDTO("Leggins Deportivos", "Nike", "Deportivo",
                "Leggins elásticos para entrenar", "https://example.com/leggins.jpg", 120000, 18, "PAN003", "M",
                "Mujer", "Poliéster", "Leggins", "Ajustado", "Largo"));

        listaPantalones.add(new PantalonDTO("Pantalón Jogger Negro", "Adidas", "Deportivo",
                "Jogger negro con puños en tobillo", "https://example.com/jogger.jpg", 110000, 22, "PAN004", "L",
                "Unisex", "Algodón", "Jogger", "Regular", "Largo"));

        listaPantalones.add(new PantalonDTO("Shorts Verano", "H&M", "Casual", "Shorts de algodón frescos para verano",
                "https://example.com/shorts.jpg", 90000, 25, "PAN005", "M", "Unisex", "Algodón", "Shorts", "Recto",
                "Corto"));

        listaPantalones.add(new PantalonDTO("Pantalón de Vestir Negro", "Hugo Boss", "Formal",
                "Pantalón elegante de vestir negro", "https://example.com/vestir_negro.jpg", 350000, 10, "PAN006", "34",
                "Hombre", "Lana", "De vestir", "Slim", "Largo"));

        listaPantalones.add(new PantalonDTO("Pantalón Palazzo", "Mango", "Moda", "Pantalón palazzo fluido para mujer",
                "https://example.com/palazzo.jpg", 200000, 12, "PAN007", "S", "Mujer", "Viscosa", "Palazzo", "Amplio",
                "Largo"));

        listaPantalones.add(new PantalonDTO("Pantalón Cargo Verde", "Pull&Bear", "Urbano",
                "Pantalón cargo con múltiples bolsillos", "https://example.com/cargo.jpg", 170000, 14, "PAN008", "32",
                "Hombre", "Algodón", "Cargo", "Recto", "Largo"));

        listaPantalones.add(new PantalonDTO("Pantalón Capri", "Stradivarius", "Moda",
                "Pantalón capri fresco para verano", "https://example.com/capri.jpg", 140000, 16, "PAN009", "M",
                "Mujer", "Algodón", "Capri", "Slim", "3/4"));

        listaPantalones.add(new PantalonDTO("Jogger Estampado", "Forever21", "Urbano", "Jogger estampado juvenil",
                "https://example.com/jogger_estampado.jpg", 130000, 19, "PAN010", "L", "Unisex", "Poliéster", "Jogger",
                "Regular", "Largo"));

        igualarListas();
        leerLista();
    }

    /**
     * Sincroniza la lista de pantalones con el DAO persistente.
     * <p>
     * Convierte los {@link PantalonDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getPantalonDAO().getListaPantalon()
                .addAll(DataMapper.listaPantalonDTOToListaPantalon((ArrayList<PantalonDTO>) listaPantalones));
        ModelFacade.getPantalonDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de pantalones desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getPantalonDAO().cargarDesdeArchivo();
        listaPantalones = DataMapper.listaPantalonToListaPantalonDTO(ModelFacade.getPantalonDAO().getListaPantalon());
    }

    /**
     * Obtiene la lista completa de pantalones.
     * 
     * @return {@link List} de {@link PantalonDTO} con todos los productos
     */
    public List<PantalonDTO> getProducts() {
        return new ArrayList<>(listaPantalones);
    }

    /**
     * Obtiene una sublista de pantalones o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de productos a obtener
     * @return {@link List} de {@link PantalonDTO} con los productos seleccionados
     */
    public List<PantalonDTO> getProducts(int size) {

        if (size > listaPantalones.size()) {
            Random rand = new Random();

            List<PantalonDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaPantalones.size());
                randomList.add(listaPantalones.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaPantalones.subList(0, size));
        }

    }

    /**
     * Clona los productos obtenidos y asegura códigos únicos.
     * 
     * @param size Número de productos a clonar
     * @return {@link List} de {@link PantalonDTO} con los productos clonados y con ID único
     */
    public List<PantalonDTO> getClonedProducts(int size) {
        List<PantalonDTO> results = new ArrayList<>();
        List<PantalonDTO> originals = getProducts(size);
        for (PantalonDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (PantalonDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
