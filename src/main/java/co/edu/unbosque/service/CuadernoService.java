package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.CuadernoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.persistence.DataMapper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de cuadernos.
 * <p>
 * Esta clase administra una lista de {@link CuadernoDTO}, permitiendo inicializar,
 * clonar, leer desde almacenamiento persistente y obtener sublistas o listas completas de cuadernos.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class CuadernoService {

    /** Lista que almacena los cuadernos disponibles */
    private List<CuadernoDTO> listaCuadernos;

    /**
     * Inicializa la lista de cuadernos con datos de ejemplo y sincroniza con el DAO.
     * <p>
     * Se ejecuta automáticamente después de la construcción del bean gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaCuadernos = new ArrayList<>();

        listaCuadernos.add(new CuadernoDTO("Cuaderno Universitario 100 Hojas", "Norma", "Cuaderno",
                "Espiral, hojas rayadas", "https://example.com/cuaderno_universitario.jpg", 12500, 60, "CUA001",
                "Espiral", "Rayadas", 100, true));

        listaCuadernos.add(new CuadernoDTO("Cuaderno Profesional 80 Hojas", "Scribe", "Cuaderno",
                "Argollado resistente", "https://example.com/cuaderno_profesional.jpg", 9800, 40, "CUA002", "Argollado",
                "Cuadriculadas", 80, true));

        listaCuadernos.add(new CuadernoDTO("Cuaderno Cosido 50 Hojas", "Norma", "Cuaderno", "Formato escolar",
                "https://example.com/cuaderno_cosido.jpg", 6500, 70, "CUA003", "Cosido", "Rayadas", 50, false));

        listaCuadernos.add(new CuadernoDTO("Cuaderno Dotted A5", "Moleskine", "Cuaderno",
                "Punteado para bullet journal", "https://example.com/cuaderno_dotted.jpg", 55000, 15, "CUA004",
                "Espiral", "Punteadas", 192, true));

        listaCuadernos.add(new CuadernoDTO("Sketchbook Artista", "Canson", "Cuaderno", "Papel liso para dibujo",
                "https://example.com/cuaderno_sketch.jpg", 32000, 20, "CUA005", "Espiral", "Lisas", 120, true));

        listaCuadernos.add(new CuadernoDTO("Cuaderno Milimetrado", "Oxford", "Cuaderno", "Ideal para diagramas",
                "https://example.com/cuaderno_milimetrado.jpg", 14000, 25, "CUA006", "Espiral", "Milimetradas", 80,
                false));

        listaCuadernos.add(new CuadernoDTO("Cuaderno Reciclado 90 Hojas", "EcoPaper", "Cuaderno",
                "Hecho con papel reciclado", "https://example.com/cuaderno_reciclado.jpg", 11000, 30, "CUA007",
                "Argollado", "Recicladas", 90, true));

        listaCuadernos.add(new CuadernoDTO("Bloc de Notas A6", "Post-it", "Cuaderno", "Empaque x3, tamaño bolsillo",
                "https://example.com/bloc_notas.jpg", 7500, 100, "CUA008", "Empaque x3", "Lisas", 150, false));

        listaCuadernos.add(new CuadernoDTO("Cuaderno Inteligente", "Rocketbook", "Cuaderno",
                "Hojas borrables y reutilizables", "https://example.com/cuaderno_inteligente.jpg", 89000, 8, "CUA009",
                "Espiral", "Borrables", 36, true));

        listaCuadernos.add(new CuadernoDTO("Cuaderno Escolar 100 Hojas", "Kores", "Cuaderno", "Cosido, uso escolar",
                "https://example.com/cuaderno_escolar.jpg", 8200, 80, "CUA010", "Cosido", "Rayadas", 100, false));
        igualarListas();
        leerLista();

    }

    /**
     * Sincroniza la lista de cuadernos con el DAO persistente.
     * <p>
     * Convierte los {@link CuadernoDTO} a entidades y los agrega al DAO.
     * </p>
     */
    public void igualarListas() {
        ModelFacade.getCuadernoDAO().getlistaCuadernos()
                .addAll(DataMapper.listaCuadernoDTOToListaCuaderno((ArrayList<CuadernoDTO>) listaCuadernos));
        ModelFacade.getCuadernoDAO().escribirEnArchivo();
    }

    /**
     * Lee la lista de cuadernos desde el DAO persistente y la convierte a DTO.
     */
    public void leerLista() {
        ModelFacade.getCorrectorDAO().cargarDesdeArchivo();
        listaCuadernos = DataMapper.listaCuadernoToListaCuadernoDTO(ModelFacade.getCuadernoDAO().getlistaCuadernos());
    }

    /**
     * Obtiene la lista completa de cuadernos.
     * 
     * @return {@link List} de {@link CuadernoDTO} con todos los cuadernos
     */
    public List<CuadernoDTO> getProducts() {
        return new ArrayList<>(listaCuadernos);
    }

    /**
     * Obtiene una sublista de cuadernos o una lista aleatoria si el tamaño solicitado
     * es mayor al tamaño disponible.
     * 
     * @param size Número de cuadernos a obtener
     * @return {@link List} de {@link CuadernoDTO} con los productos seleccionados
     */
    public List<CuadernoDTO> getProducts(int size) {

        if (size > listaCuadernos.size()) {
            Random rand = new Random();

            List<CuadernoDTO> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(listaCuadernos.size());
                randomList.add(listaCuadernos.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(listaCuadernos.subList(0, size));
        }

    }

    /**
     * Clona los cuadernos obtenidos y asegura códigos únicos.
     * 
     * @param size Número de cuadernos a clonar
     * @return {@link List} de {@link CuadernoDTO} con los productos clonados y con ID único
     */
    public List<CuadernoDTO> getClonedProducts(int size) {
        List<CuadernoDTO> results = new ArrayList<>();
        List<CuadernoDTO> originals = getProducts(size);
        for (CuadernoDTO original : originals) {
            results.add(original.clone());
        }

        // make sure to have unique codes
        for (CuadernoDTO product : results) {
            product.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
        }

        return results;
    }

}
