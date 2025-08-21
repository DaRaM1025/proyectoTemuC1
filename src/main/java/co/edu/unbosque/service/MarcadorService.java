package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.MarcadorDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de productos tipo Marcador.
 * <p>
 * Esta clase administra una lista de {@link MarcadorDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de marcadores.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class MarcadorService {

    /** Lista que almacena los productos tipo Marcador disponibles */
    private List<MarcadorDTO> listaMarcadores;

    /**
     * Inicializa la lista de marcadores con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaMarcadores = new ArrayList<>();

        listaMarcadores.add(new MarcadorDTO("Marcador Permanente Azul", "Sharpie", "Marcador",
                "Marcador de tinta permanente azul", "https://example.com/marcador_azul.jpg", 4500, 60, "MAR001",
                "Unidad", "Fina", true, "Permanente"));

        listaMarcadores.add(new MarcadorDTO("Marcador Borrable Negro", "Expo", "Marcador",
                "Marcador borrable para tablero acrílico", "https://example.com/marcador_borrable.jpg", 5200, 45,
                "MAR002", "Unidad", "Mediana", false, "Borrable"));

        listaMarcadores.add(new MarcadorDTO("Marcador Resaltador Amarillo", "Stabilo", "Marcador",
                "Resaltador amarillo fluorescente", "https://example.com/marcador_amarillo.jpg", 3800, 100, "MAR003",
                "Unidad", "Biselada", false, "Resaltador"));

        listaMarcadores.add(new MarcadorDTO("Marcador Permanente Negro", "Pilot", "Marcador",
                "Marcador negro resistente al agua", "https://example.com/marcador_negro.jpg", 4900, 70, "MAR004",
                "Unidad", "Gruesa", true, "Permanente"));

        listaMarcadores.add(new MarcadorDTO("Marcador Resaltador Verde", "Faber-Castell", "Marcador",
                "Resaltador verde para estudio", "https://example.com/marcador_verde.jpg", 3900, 80, "MAR005", "Unidad",
                "Biselada", false, "Resaltador"));

        listaMarcadores.add(new MarcadorDTO("Marcador Borrable Rojo", "Expo", "Marcador",
                "Marcador borrable color rojo para tablero", "https://example.com/marcador_rojo.jpg", 5000, 55,
                "MAR006", "Unidad", "Mediana", false, "Borrable"));

        listaMarcadores.add(new MarcadorDTO("Marcador Permanente Verde", "Sharpie", "Marcador",
                "Marcador verde de larga duración", "https://example.com/marcador_verde.jpg", 4700, 65, "MAR007",
                "Unidad", "Fina", true, "Permanente"));

        listaMarcadores.add(new MarcadorDTO("Marcador Resaltador Naranja", "Stabilo", "Marcador",
                "Resaltador naranja fluorescente", "https://example.com/marcador_naranja.jpg", 4000, 90, "MAR008",
                "Unidad", "Biselada", false, "Resaltador"));

        listaMarcadores.add(new MarcadorDTO("Marcador Borrable Azul", "Bic", "Marcador",
                "Marcador azul borrable para tablero", "https://example.com/marcador_borrable_azul.jpg", 4800, 50,
                "MAR009", "Unidad", "Gruesa", false, "Borrable"));

        listaMarcadores.add(new MarcadorDTO("Marcador Permanente Rojo", "Pilot", "Marcador",
                "Marcador rojo resistente y permanente", "https://example.com/marcador_rojo.jpg", 4600, 75, "MAR010",
                "Unidad", "Mediana", true, "Permanente"));

        igualarListas();
        leerLista();
    }

    /**
     * Sincroniza la lista de marcadores con el DAO persistente.
     * <p>
     * Convierte los {@link MarcadorDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getMarcadorDAO().getlistaMarcadores()
                .addAll(DataMapper.listaMarcadorDTOToListaMarcador((ArrayList<MarcadorDTO>) listaMarcadores));
        ModelFacade.getMarcadorDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de marcadores desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getMarcadorDAO().cargarDesdeArchivo();
        listaMarcadores = DataMapper.listaMarcadorToListaMarcadorDTO(ModelFacade.getMarcadorDAO().getlistaMarcadores());
    }

    /**
     * Obtiene la lista completa de marcadores.
     * 
     * @return {@link List} de {@link MarcadorDTO} con todos los productos
     */
    public List<MarcadorDTO> getProducts() {
        return new ArrayList<>(listaMarcadores);
    }

    /**
     * Obtiene una sublista de marcadores o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de productos a obtener
     * @return {@link List} de {@link MarcadorDTO} con los productos seleccionados
     */
    public List<MarcadorDTO> getProducts(int size) {

        if (size > listaMarcadores.size()) {
            Random rand = new Random();

            List<MarcadorDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaMarcadores.size());
                randomList.add(listaMarcadores.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaMarcadores.subList(0, size));
        }

    }

    /**
     * Clona los productos obtenidos y asegura códigos únicos.
     * 
     * @param size Número de productos a clonar
     * @return {@link List} de {@link MarcadorDTO} con los productos clonados y con ID único
     */
    public List<MarcadorDTO> getClonedProducts(int size) {
        List<MarcadorDTO> results = new ArrayList<>();
        List<MarcadorDTO> originals = getProducts(size);
        for (MarcadorDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (MarcadorDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
