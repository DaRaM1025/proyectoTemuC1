package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.model.UsuarioDTO;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * Clase DAO (Data Access Object) para gestionar operaciones CRUD y persistencia
 * de objetos {@link Usuario}. Implementa la interfaz {@link OperacionDAO} para
 * manejar objetos {@link UsuarioDTO} y {@link Usuario}.
 * <p>
 * Esta clase permite crear, eliminar, actualizar y buscar usuarios en memoria,
 * así como almacenar y recuperar los datos desde archivos serializados.
 * </p>
 */
@ApplicationScoped
public class UsuarioDAO implements OperacionDAO<UsuarioDTO, Usuario> {

    /** Lista de usuarios cargados en memoria */
    private ArrayList<Usuario> listaUsuarios;

    /** Nombre del archivo serializado para persistencia binaria */
    private final String SERIAL_FILE_NAME = "usuario.dat";

    /**
     * Constructor de la clase.
     * <p>
     * Inicializa la lista de usuarios y carga los datos desde el archivo serializado si existe.
     * </p>
     */
    public UsuarioDAO() {
        listaUsuarios = new ArrayList<>();
        leerArchivoSerializado();
    }

    /**
     * Obtiene la lista de usuarios en memoria.
     *
     * @return {@link ArrayList} de usuarios
     */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * Establece la lista de usuarios en memoria.
     *
     * @param listaUsuarios Nueva lista de usuarios
     */
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    /**
     * Escribe la lista de usuarios en un archivo serializado para persistencia binaria.
     */
    private void escribirArchivoSerializado() {
        FileManager.escribirArchivoSerializado(SERIAL_FILE_NAME, listaUsuarios);
    }

    /**
     * Carga la lista de usuarios desde un archivo serializado.
     * <p>
     * Si el archivo no existe o está vacío, se inicializa una nueva lista.
     * </p>
     */
    @SuppressWarnings("unchecked")
    private void leerArchivoSerializado() {
        listaUsuarios = (ArrayList<Usuario>) FileManager.leerArchivoSerializado(SERIAL_FILE_NAME);
        if (listaUsuarios == null) {
            listaUsuarios = new ArrayList<>();
        }
    }

    /**
     * Crea un nuevo usuario en la lista si no existe previamente.
     *
     * @param nuevo Objeto {@link UsuarioDTO} que se desea agregar
     * @return {@code true} si se agregó correctamente; {@code false} si ya existía
     */
    @Override
    public boolean crear(UsuarioDTO nuevo) {
        Usuario entidad = DataMapper.usuarioDTOToUsuario(nuevo);
        Usuario encontrado = find(entidad);

        if (encontrado == null) {
            listaUsuarios.add(entidad);
            System.out.println("EXITO" + listaUsuarios.size());
            escribirArchivoSerializado();
            return true;
        }
        System.out.println("USUARIO YA EXISTE");
        return false;
    }

    /**
     * Elimina un usuario existente de la lista.
     *
     * @param eliminado Objeto {@link UsuarioDTO} que se desea eliminar
     * @return {@code true} si se eliminó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean eliminar(UsuarioDTO eliminado) {
        Usuario entidad = DataMapper.usuarioDTOToUsuario(eliminado);
        Usuario encontrado = find(entidad);
        if (encontrado != null) {
            listaUsuarios.remove(encontrado);
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Busca un usuario en la lista por su nombre de usuario (username).
     *
     * @param toFind Objeto {@link Usuario} con el username a buscar
     * @return El {@link Usuario} encontrado, o {@code null} si no existe
     */
    @Override
    public Usuario find(Usuario toFind) {
        if (!listaUsuarios.isEmpty()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getUsername().equals(toFind.getUsername())) {
                    System.out.println("USUARIO IGUAL ENCONTRADO");
                    return usuario;
                }
            }
        }
        return null;
    }

    /**
     * Actualiza un usuario existente con nuevos datos.
     *
     * @param previo Objeto {@link UsuarioDTO} con los datos actuales
     * @param nuevo  Objeto {@link UsuarioDTO} con los datos nuevos a actualizar
     * @return {@code true} si la actualización se realizó correctamente; {@code false} si no se encontró
     */
    @Override
    public boolean update(UsuarioDTO previo, UsuarioDTO nuevo) {
        Usuario entidadPrevio = DataMapper.usuarioDTOToUsuario(previo);
        Usuario entidadNuevo = DataMapper.usuarioDTOToUsuario(nuevo);
        Usuario encontrado = find(entidadPrevio);
        if (encontrado != null) {
            listaUsuarios.remove(encontrado);
            listaUsuarios.add(entidadNuevo);
            escribirArchivoSerializado();
            return true;
        }
        return false;
    }

    /**
     * Devuelve una representación en texto de todos los usuarios de la lista.
     *
     * @return {@link String} con los datos de cada usuario separados por línea
     */
    @Override
    public String mostrar() {
        if (listaUsuarios.isEmpty()) {
            return "No hay usuarios en la lista";
        }
        StringBuilder rta = new StringBuilder();
        for (Usuario usuario : listaUsuarios) {
            rta.append(usuario.toString()).append("\n");
        }
        return rta.toString();
    }
}
