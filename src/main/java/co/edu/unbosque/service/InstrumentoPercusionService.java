package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoPercusionDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de instrumentos de percusión.
 * <p>
 * Esta clase administra una lista de {@link InstrumentoPercusionDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de instrumentos de percusión.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class InstrumentoPercusionService {

    /** Lista que almacena los instrumentos de percusión disponibles */
    private List<InstrumentoPercusionDTO> listaInstrumentosPercusion;

    /**
     * Inicializa la lista de instrumentos de percusión con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaInstrumentosPercusion = new ArrayList<>();

        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Batería Acústica", "Pearl",
                "Instrumento de Percusión", "Batería de 5 piezas", "https://example.com/bateria.jpg", 4200000, 2,
                "IP001", false, "Batería", true, "Membranófono", 5));
        listaInstrumentosPercusion.add(
                new InstrumentoPercusionDTO("Cajón Flamenco", "Meinl", "Instrumento de Percusión", "Cajón artesanal",
                        "https://example.com/cajon.jpg", 550000, 6, "IP002", false, "Cajón", false, "Idiófono", 1));
        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Xilófono", "Yamaha", "Instrumento de Percusión",
                "Xilófono de concierto", "https://example.com/xilofono.jpg", 2800000, 2, "IP003", true, "Xilófono",
                true, "Idiófono", 37));
        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Timbales", "LP", "Instrumento de Percusión",
                "Juego de timbales latinos", "https://example.com/timbales.jpg", 1400000, 3, "IP004", true, "Timbales",
                true, "Membranófono", 2));
        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Congas", "Meinl", "Instrumento de Percusión",
                "Juego de congas profesionales", "https://example.com/congas.jpg", 2500000, 2, "IP005", false, "Congas",
                true, "Membranófono", 2));
        listaInstrumentosPercusion
                .add(new InstrumentoPercusionDTO("Bongo", "LP", "Instrumento de Percusión", "Par de bongós de madera",
                        "https://example.com/bongo.jpg", 780000, 5, "IP006", false, "Bongó", true, "Membranófono", 2));
        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Maracas", "Latin Percussion",
                "Instrumento de Percusión", "Par de maracas tradicionales", "https://example.com/maracas.jpg", 150000,
                10, "IP007", false, "Maracas", false, "Idiófono", 2));
        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Djembe", "Remo", "Instrumento de Percusión",
                "Tambor africano", "https://example.com/djembe.jpg", 1200000, 4, "IP008", false, "Djembe", true,
                "Membranófono", 1));
        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Triángulo", "Meinl", "Instrumento de Percusión",
                "Triángulo de acero", "https://example.com/triangulo.jpg", 60000, 20, "IP009", false, "Triángulo", true,
                "Idiófono", 1));
        listaInstrumentosPercusion.add(new InstrumentoPercusionDTO("Caja Redoblante", "Mapex",
                "Instrumento de Percusión", "Caja de concierto", "https://example.com/redoblante.jpg", 1300000, 3,
                "IP010", true, "Redoblante", true, "Membranófono", 1));
        igualarListas();
        leerLista();

    }

    /**
     * Sincroniza la lista de instrumentos de percusión con el DAO persistente.
     * <p>
     * Convierte los {@link InstrumentoPercusionDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getPercusionDAO().getListaInstrumentoPercusion()
                .addAll(DataMapper.listaInstrumentoPercusionDTOToListaInstrumentoPercusion((ArrayList<InstrumentoPercusionDTO>) listaInstrumentosPercusion));
        ModelFacade.getPercusionDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de instrumentos de percusión desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getPercusionDAO().cargarDesdeArchivo();
        listaInstrumentosPercusion = DataMapper.listaInstrumentoPercusionToListaInstrumentoPercusionDTO(ModelFacade.getPercusionDAO().getListaInstrumentoPercusion());
    }

    /**
     * Obtiene la lista completa de instrumentos de percusión.
     * 
     * @return {@link List} de {@link InstrumentoPercusionDTO} con todos los instrumentos de percusión
     */
    public List<InstrumentoPercusionDTO> getProducts() {
        return new ArrayList<>(listaInstrumentosPercusion);
    }

    /**
     * Obtiene una sublista de instrumentos de percusión o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de instrumentos a obtener
     * @return {@link List} de {@link InstrumentoPercusionDTO} con los productos seleccionados
     */
    public List<InstrumentoPercusionDTO> getProducts(int size) {

        if (size > listaInstrumentosPercusion.size()) {
            Random rand = new Random();

            List<InstrumentoPercusionDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaInstrumentosPercusion.size());
                randomList.add(listaInstrumentosPercusion.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaInstrumentosPercusion.subList(0, size));
        }

    }

    /**
     * Clona los instrumentos de percusión obtenidos y asegura códigos únicos.
     * 
     * @param size Número de instrumentos a clonar
     * @return {@link List} de {@link InstrumentoPercusionDTO} con los productos clonados y con ID único
     */
    public List<InstrumentoPercusionDTO> getClonedProducts(int size) {
        List<InstrumentoPercusionDTO> results = new ArrayList<>();
        List<InstrumentoPercusionDTO> originals = getProducts(size);
        for (InstrumentoPercusionDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (InstrumentoPercusionDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
