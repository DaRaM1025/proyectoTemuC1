package co.edu.unbosque.service;

import java.util.ArrayList;
import co.edu.unbosque.model.ProductoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 * Servicio para la gestión de un carrito de compras.
 * <p>
 * Esta clase permite agregar, remover, limpiar y consultar productos en un carrito de compras
 * almacenado en memoria como una lista de {@link ProductoDTO}.
 * </p>
 * <p>
 * Se encuentra en un contexto de aplicación y se gestiona como bean CDI mediante
 * las anotaciones {@link Named} y {@link ApplicationScoped}.
 * </p>
 */
@Named
@ApplicationScoped
public class CarritoService {

    /** Lista que almacena los productos agregados al carrito */
    private ArrayList<ProductoDTO> listaCarrito;
    
    /**
     * Inicializa la lista del carrito después de la construcción del bean.
     * <p>
     * Se ejecuta automáticamente gracias a la anotación {@link PostConstruct}.
     * </p>
     */
    @PostConstruct
    public void init() {
        listaCarrito = new ArrayList<>();
    }

    /**
     * Agrega un producto al carrito si no es nulo y no está repetido.
     * 
     * @param producto El {@link ProductoDTO} que se desea agregar al carrito
     */
    public void agregarProducto(ProductoDTO producto) {
        if (producto == null) {
            return;
        }

        if (!listaCarrito.contains(producto)) {
            listaCarrito.add(producto);
        } else {
            System.out.println("Item repetido.");
        }
    }

    /**
     * Remueve un producto del carrito.
     * 
     * @param producto El {@link ProductoDTO} que se desea eliminar del carrito
     */
    public void removerProducto(ProductoDTO producto) {
        listaCarrito.remove(producto);
    }

    /**
     * Limpia todos los productos del carrito, dejándolo vacío.
     */
    public void limpiarCarrito() {
        listaCarrito.clear();
    }
    
    /**
     * Obtiene la lista completa de productos en el carrito.
     * 
     * @return {@link ArrayList} de {@link ProductoDTO} que contiene los productos del carrito
     */
    public ArrayList<ProductoDTO> getListaCarrito() {
        return listaCarrito;
    }

    /**
     * Establece una nueva lista de productos para el carrito.
     * 
     * @param listaCarrito {@link ArrayList} de {@link ProductoDTO} que reemplazará la lista actual
     */
    public void setListaCarrito(ArrayList<ProductoDTO> listaCarrito) {
        this.listaCarrito = listaCarrito;
    }

}
