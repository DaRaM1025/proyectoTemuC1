package co.edu.unbosque.model.persistence;

/**
 * Interfaz genérica para operaciones CRUD (Create, Read, Update, Delete) sobre
 * objetos de tipo D y E.
 * <p>
 * Esta interfaz define los métodos que deben implementar todos los DAO
 * (Data Access Object) para manejar la persistencia de datos y operaciones
 * sobre entidades y DTOs.
 * </p>
 *
 * @param <D> Tipo de objeto DTO (Data Transfer Object) utilizado como entrada
 * @param <E> Tipo de entidad que representa los datos en memoria o persistencia
 */
public interface OperacionDAO<D, E> {

    /**
     * Crea un nuevo registro en la persistencia.
     *
     * @param nuevo Objeto de tipo D que contiene los datos a agregar
     * @return {@code true} si el registro se creó correctamente, {@code false} si ya existía
     */
    public boolean crear(D nuevo);

    /**
     * Elimina un registro existente de la persistencia.
     *
     * @param eliminado Objeto de tipo D que contiene los datos a eliminar
     * @return {@code true} si el registro se eliminó correctamente, {@code false} si no se encontró
     */
    public boolean eliminar(D eliminado);

    /**
     * Busca un registro en la persistencia.
     *
     * @param toFind Objeto de tipo E que contiene la información para buscar el registro
     * @return El objeto de tipo E encontrado, o {@code null} si no existe
     */
    public E find(E toFind);

    /**
     * Actualiza un registro existente con nuevos datos.
     *
     * @param previo Objeto de tipo D con los datos actuales del registro
     * @param nuevo  Objeto de tipo D con los datos nuevos a actualizar
     * @return {@code true} si el registro se actualizó correctamente, {@code false} si no se encontró
     */
    public boolean update(D previo, D nuevo);

    /**
     * Devuelve una representación en texto de todos los registros.
     *
     * @return {@link String} que contiene la información de todos los registros
     */
    public String mostrar();

}
