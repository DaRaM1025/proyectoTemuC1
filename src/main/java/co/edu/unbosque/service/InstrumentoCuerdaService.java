package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoCuerdaDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de instrumentos de cuerda.
 * <p>
 * Esta clase administra una lista de {@link InstrumentoCuerdaDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de instrumentos de cuerda.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class InstrumentoCuerdaService {

    /** Lista que almacena los instrumentos de cuerda disponibles */
    private List<InstrumentoCuerdaDTO> listaInstrumentosCuerda;

    /**
     * Inicializa la lista de instrumentos de cuerda con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaInstrumentosCuerda = new ArrayList<>();

        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Guitarra Clásica", "Yamaha", "Instrumento de Cuerda",
                "Guitarra acústica de estudio", "https://example.com/guitarra1.jpg", 950000, 10, "IC001", true,
                "Guitarra", 6, "Nylon", true));
        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Violín Estudiantil", "Stentor", "Instrumento de Cuerda",
                "Violín de iniciación con arco", "https://example.com/violin.jpg", 1200000, 8, "IC002", true, "Violín",
                4, "Acero", true));
        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Ukulele Tenor", "Kala", "Instrumento de Cuerda",
                "Ukulele tenor con sonido cálido", "https://example.com/ukulele.jpg", 450000, 15, "IC003", true,
                "Ukulele", 4, "Nylon", true));
        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Bajo Eléctrico", "Fender", "Instrumento de Cuerda",
                "Bajo eléctrico Jazz Bass", "https://example.com/bajo.jpg", 2800000, 5, "IC004", false, "Bajo", 4,
                "Acero", false));
        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Arpa Clásica", "Lyon & Healy", "Instrumento de Cuerda",
                "Arpa de concierto profesional", "https://example.com/arpa.jpg", 7500000, 2, "IC005", false, "Arpa", 47,
                "Nylon", true));
        listaInstrumentosCuerda.add(
                new InstrumentoCuerdaDTO("Banjo Tradicional", "Deering", "Instrumento de Cuerda", "Banjo de 5 cuerdas",
                        "https://example.com/banjo.jpg", 2100000, 4, "IC006", true, "Banjo", 5, "Acero", true));
        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Mandolina", "Gretsch", "Instrumento de Cuerda",
                "Mandolina acústica de 8 cuerdas", "https://example.com/mandolina.jpg", 1350000, 6, "IC007", false,
                "Mandolina", 8, "Acero", true));
        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Guitarra Eléctrica", "Ibanez", "Instrumento de Cuerda",
                "Guitarra eléctrica para rock", "https://example.com/electric.jpg", 2400000, 7, "IC008", false,
                "Guitarra", 6, "Acero", false));
        listaInstrumentosCuerda
                .add(new InstrumentoCuerdaDTO("Laúd Árabe", "Zeryab", "Instrumento de Cuerda", "Laúd tradicional árabe",
                        "https://example.com/laud.jpg", 3000000, 3, "IC009", true, "Laúd", 11, "Nylon", true));
        listaInstrumentosCuerda.add(new InstrumentoCuerdaDTO("Charango Andino", "BolivianArt", "Instrumento de Cuerda",
                "Charango artesanal", "https://example.com/charango.jpg", 1100000, 5, "IC010", true, "Charango", 10,
                "Nylon", true));
        igualarListas();
        leerLista();

    }

    /**
     * Sincroniza la lista de instrumentos de cuerda con el DAO persistente.
     * <p>
     * Convierte los {@link InstrumentoCuerdaDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getCuerdaDAO().getListaInstrumentoCuerda()
                .addAll(DataMapper.listaInstrumentoCuerdaDTOToListaInstrumentoCuerda((ArrayList<InstrumentoCuerdaDTO>) listaInstrumentosCuerda));
        ModelFacade.getCuerdaDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de instrumentos de cuerda desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getCuerdaDAO().cargarDesdeArchivo();
        listaInstrumentosCuerda = DataMapper.listaInstrumentoCuerdaToListaInstrumentoCuerdaDTO(ModelFacade.getCuerdaDAO().getListaInstrumentoCuerda());
    }

    /**
     * Obtiene la lista completa de instrumentos de cuerda.
     * 
     * @return {@link List} de {@link InstrumentoCuerdaDTO} con todos los instrumentos de cuerda
     */
    public List<InstrumentoCuerdaDTO> getProducts() {
        return new ArrayList<>(listaInstrumentosCuerda);
    }

    /**
     * Obtiene una sublista de instrumentos de cuerda o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de instrumentos a obtener
     * @return {@link List} de {@link InstrumentoCuerdaDTO} con los productos seleccionados
     */
    public List<InstrumentoCuerdaDTO> getProducts(int size) {

        if (size > listaInstrumentosCuerda.size()) {
            Random rand = new Random();

            List<InstrumentoCuerdaDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaInstrumentosCuerda.size());
                randomList.add(listaInstrumentosCuerda.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaInstrumentosCuerda.subList(0, size));
        }

    }

    /**
     * Clona los instrumentos de cuerda obtenidos y asegura códigos únicos.
     * 
     * @param size Número de instrumentos a clonar
     * @return {@link List} de {@link InstrumentoCuerdaDTO} con los productos clonados y con ID único
     */
    public List<InstrumentoCuerdaDTO> getClonedProducts(int size) {
        List<InstrumentoCuerdaDTO> results = new ArrayList<>();
        List<InstrumentoCuerdaDTO> originals = getProducts(size);
        for (InstrumentoCuerdaDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (InstrumentoCuerdaDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
