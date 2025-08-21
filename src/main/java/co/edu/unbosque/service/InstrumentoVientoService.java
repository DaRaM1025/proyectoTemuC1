package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.InstrumentoVientoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de instrumentos de viento.
 * <p>
 * Esta clase administra una lista de {@link InstrumentoVientoDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de instrumentos de viento.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class InstrumentoVientoService {

    /** Lista que almacena los instrumentos de viento disponibles */
    private List<InstrumentoVientoDTO> listaInstrumentosViento;

    /**
     * Inicializa la lista de instrumentos de viento con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaInstrumentosViento = new ArrayList<>();

        listaInstrumentosViento
                .add(new InstrumentoVientoDTO("Flauta Dulce", "Yamaha", "Instrumento de Viento", "Flauta de iniciación",
                        "https://example.com/flauta.jpg", 45000, 50, "IV001", false, "Flauta", "Do", 0, false));
        listaInstrumentosViento.add(new InstrumentoVientoDTO("Trompeta", "Bach", "Instrumento de Viento",
                "Trompeta de latón profesional", "https://example.com/trompeta.jpg", 2500000, 5, "IV002", true,
                "Trompeta", "Si bemol", 3, true));
        listaInstrumentosViento.add(new InstrumentoVientoDTO("Clarinete", "Buffet Crampon", "Instrumento de Viento",
                "Clarinete en si bemol", "https://example.com/clarinete.jpg", 3200000, 3, "IV003", true, "Clarinete",
                "Si bemol", 0, true));
        listaInstrumentosViento
                .add(new InstrumentoVientoDTO("Saxofón Alto", "Yamaha", "Instrumento de Viento", "Saxofón de estudio",
                        "https://example.com/saxo.jpg", 4500000, 4, "IV004", true, "Saxofón", "Mi bemol", 0, true));
        listaInstrumentosViento.add(new InstrumentoVientoDTO("Oboe", "Howarth", "Instrumento de Viento",
                "Oboe intermedio", "https://example.com/oboe.jpg", 5800000, 2, "IV005", true, "Oboe", "Do", 0, true));
        listaInstrumentosViento
                .add(new InstrumentoVientoDTO("Trombón", "Conn", "Instrumento de Viento", "Trombón tenor de vara",
                        "https://example.com/trombon.jpg", 3000000, 3, "IV006", true, "Trombón", "Si bemol", 0, false));
        listaInstrumentosViento
                .add(new InstrumentoVientoDTO("Armónica", "Hohner", "Instrumento de Viento", "Armónica de 10 agujeros",
                        "https://example.com/armonica.jpg", 120000, 20, "IV007", false, "Armónica", "Do", 0, false));
        listaInstrumentosViento.add(new InstrumentoVientoDTO("Tuba", "Miraphone", "Instrumento de Viento",
                "Tuba de concierto", "https://example.com/tuba.jpg", 9000000, 1, "IV008", true, "Tuba", "Fa", 4, true));
        listaInstrumentosViento
                .add(new InstrumentoVientoDTO("Fagot", "Fox", "Instrumento de Viento", "Fagot profesional",
                        "https://example.com/fagot.jpg", 12000000, 1, "IV009", true, "Fagot", "Do", 0, true));
        listaInstrumentosViento
                .add(new InstrumentoVientoDTO("Corneta", "Getzen", "Instrumento de Viento", "Corneta de latón",
                        "https://example.com/corneta.jpg", 1800000, 2, "IV010", true, "Corneta", "Si bemol", 3, true));
        igualarListas();
        leerLista();

    }

    /**
     * Sincroniza la lista de instrumentos de viento con el DAO persistente.
     * <p>
     * Convierte los {@link InstrumentoVientoDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getVientoDAO().getListaInstrumentoViento()
                .addAll(DataMapper.listaInstrumentoVientoDTOToListaInstrumentoViento((ArrayList<InstrumentoVientoDTO>) listaInstrumentosViento));
        ModelFacade.getVientoDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de instrumentos de viento desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getVientoDAO().cargarDesdeArchivo();
        listaInstrumentosViento = DataMapper.listaInstrumentoVientoToListaInstrumentoVientoDTO(ModelFacade.getVientoDAO().getListaInstrumentoViento());
    }

    /**
     * Obtiene la lista completa de instrumentos de viento.
     * 
     * @return {@link List} de {@link InstrumentoVientoDTO} con todos los instrumentos de viento
     */
    public List<InstrumentoVientoDTO> getProducts() {
        return new ArrayList<>(listaInstrumentosViento);
    }

    /**
     * Obtiene una sublista de instrumentos de viento o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de instrumentos a obtener
     * @return {@link List} de {@link InstrumentoVientoDTO} con los productos seleccionados
     */
    public List<InstrumentoVientoDTO> getProducts(int size) {

        if (size > listaInstrumentosViento.size()) {
            Random rand = new Random();

            List<InstrumentoVientoDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaInstrumentosViento.size());
                randomList.add(listaInstrumentosViento.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaInstrumentosViento.subList(0, size));
        }

    }

    /**
     * Clona los instrumentos de viento obtenidos y asegura códigos únicos.
     * 
     * @param size Número de instrumentos a clonar
     * @return {@link List} de {@link InstrumentoVientoDTO} con los productos clonados y con ID único
     */
    public List<InstrumentoVientoDTO> getClonedProducts(int size) {
        List<InstrumentoVientoDTO> results = new ArrayList<>();
        List<InstrumentoVientoDTO> originals = getProducts(size);
        for (InstrumentoVientoDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (InstrumentoVientoDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
