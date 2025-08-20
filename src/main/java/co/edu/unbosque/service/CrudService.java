package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.UUID;

import co.edu.unbosque.model.ProductoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
/**
 * Servicio para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * sobre una lista de productos (ProductoDTO).
 * <p>
 * Esta clase es un bean gestionado con ámbito de aplicación para mantener
 * el estado de la lista de productos durante toda la vida de la aplicación.
 * </p>
 * 
 * @author Nataly Rengifo
 */
public class CrudService {
	/**
     * Lista que contiene los productos disponibles para CRUD.
     */
private ArrayList<ProductoDTO> listaCrud;
/**
 * Método de inicialización que se ejecuta después de la construcción del bean.
 */
	@PostConstruct
	public void init() {
		listaCrud = new ArrayList<>();
		listaCrud.add(new ProductoDTO("Lipgloss", "Fenty", "Labial", "Lo mejor para tus labios", "https://img.freepik.com/foto-gratis/lapiz-labial-vista-superior-pincel_23-2149096695.jpg", 20000.0, 1, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Paleta Nude Essentials", "Maybelline", "Sombra", "Paleta de sombras con 12 tonos neutros de larga duración.", "https://img.freepik.com/foto-gratis/vista-paleta-sombras-ojos-tonos-polvo-cosmetico_23-2150260864.jpg", 59960.0, 50, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Fit Me Concealer", "Maybelline", "Corrector", "Corrector líquido para cubrir imperfecciones y ojeras.", "https://img.freepik.com/foto-gratis/primer-plano-pincel-maquillaje-polvo-compacto-sobre-fondo-rosa_23-2147899480.jpg?ga=GA1.1.1086993703.1755720175&semt=ais_hybrid&w=740&q=80", 35960.0, 60, UUID.randomUUID().toString()));
		
		listaCrud.add(new ProductoDTO("TeddyBear", "ToySmart", "Peluche", "Lo mejor para acomapañarte a diario", "https://img.freepik.com/foto-gratis/vista-frontal-lindo-bebe-pastel-oso-peluche_23-2148415544.jpg", 40000.0, 52, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Nerf water displayer", "Nerf", "Pistola de Agua", "Diviertete mojando","https://img.freepik.com/foto-gratis/chica-sonriente-tiro-medio-pistola-agua_23-2149046660.jpg", 15000.0, 45, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("LEGO Classic Caja Creativa", "LEGO", "Lego", "Set de bloques de construcción con más de 500 piezas multicolor.","https://img.freepik.com/foto-gratis/vista-avion-3d_23-2151022173.jpg", 119960.0, 60, UUID.randomUUID().toString()));
		
		listaCrud.add(new ProductoDTO("Adidas Samba", "Adidas", "Calzado", "Comodidad para tus pies", "https://img.freepik.com/foto-gratis/moda-azul-fondo-blanco-viejo_1203-6516.jpg", 125000.40, 3, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Camiseta Básica Hombre", "Adidas", "Camiseta", "Camiseta de algodón 100%, cuello redondo, ideal para uso diario o deporte.", "https://img.freepik.com/foto-gratis/disparo-horizontal-guapo-chico-europeo-barbudo-cuerpo-atletico-forma-que-correr-ejercicio-posando-aislado-pared-blanco-copyspace-su-informacion-promocional_343059-2560.jpg", 72000.0, 35, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Pantalón Slim Fit Hombre", "Levi's", "Pantalon", "Pantalón de mezclilla azul con corte moderno y ajuste cómodo.", "https://img.freepik.com/foto-gratis/pantalones-vaqueros_1203-8093.jpg", 225000.0, 40, UUID.randomUUID().toString()));
		
		listaCrud.add(new ProductoDTO("Flauta Dulce Escolar", "Yamaha", "Instrumento de Viento", "Flauta de plástico para principiantes, tono claro y afinación precisa", "https://img.freepik.com/foto-gratis/vista-arriba-flauta-bloque-doble-fondo-naranja-verde_23-2147927385.jpg", 50000.0, 25, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Guitarra Clásica 39\"", "Fender", "Instrumento de Cuerda", "Guitarra acústica para principiantes, cuerdas de nailon, acabado natural.", "https://img.freepik.com/foto-gratis/chica-joven-camisa-roja-sosteniendo-guitarra-acustica_114579-86637.jpg", 475000.0, 13, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Cajón Flamenco", "Meinl", "Instrumento de Percusión", "Cajón de percusión con sonido profesional y estructura de madera sólida", "https://img.freepik.com/foto-gratis/tambores-bongo-primer-plano_23-2147781841.jpg", 356000.0, 13, UUID.randomUUID().toString()));
		
		listaCrud.add(new ProductoDTO("Cuaderno Universitario Rayado", "Norma", "Cuaderno", "Cuaderno con 100 hojas rayadas, tamaño carta, espiral metálico.", "https://img.freepik.com/foto-gratis/cuaderno-rayado-blanco-sobre-mesa-blanca_53876-165405.jpg", 14000.0, 100, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Cinta Adhesiva Transparente 3M", "Scotch", "Cinta Adhesiva", "Rollo de cinta adhesiva resistente, ideal para oficina o escuela.", "https://img.freepik.com/foto-gratis/manos-cultivo-caja-sellado_23-2147758728.jpg", 4800.0, 200, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Marcador Permanente Negro", "Sharpie", "Marcador", "Marcador de tinta permanente, punta fina, resistente al agua y a la decoloración.", "https://img.freepik.com/foto-gratis/hombre-trabaja-oficina_1157-40488.jpg", 7000.0, 150, UUID.randomUUID().toString()));

		listaCrud.add(new ProductoDTO("Galaxy A15", "Samsung", "Celular", "Smartphone con pantalla AMOLED de 6.5\", 128GB de almacenamiento y 4GB RAM", "https://img.freepik.com/foto-gratis/nuevo-telefono-celular-sobre-fondo-colores_58702-4943.jpg", 799960.0, 23, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Laptop IdeaPad 3", "Lenovo", "Computador", "Portátil con procesador Intel i5, 8GB RAM, SSD de 256GB, pantalla 15.6\".", "https://img.freepik.com/foto-gratis/portatil-pantalla-blanco-aislado-pared-blanca_231208-8594.jpg", 1996000.0, 10, UUID.randomUUID().toString()));
		listaCrud.add(new ProductoDTO("Smart TV 50\" 4K UHD", "LG", "Televisor", "Televisor inteligente con resolución 4K, sistema webOS y control por voz.", "https://img.freepik.com/foto-gratis/gente-sale-collage-television_23-2150163651.jpg", 1519960.0, 8, UUID.randomUUID().toString()));
		
	}
	/**
     * Agrega un producto a la lista si no existe previamente.
     * 
     * @param producto El objeto ProductoDTO a agregar.
     */
	public void agregarProducto(ProductoDTO producto) {
		if (producto == null) {
			return;
		}

		if (!listaCrud.contains(producto)) {
			listaCrud.add(producto);
		} else {
			System.out.println("Item repetido.");
		}
	}
	 /**
     * Remueve un producto específico de la lista.
     * 
     * @param producto El objeto ProductoDTO a remover.
     */
	public void removerProducto(ProductoDTO producto) {
		listaCrud.remove(producto);
	}
	/**
     * Limpia todos los productos de la lista.
     */
	public void limpiarLista() {
		listaCrud.clear();
	}
	/**
     * Obtiene la lista de productos.
     * 
     * @return Una lista con los objetos ProductoDTO actuales.
     */
	public ArrayList<ProductoDTO> getListaCrud() {
		return listaCrud;
	}
	/**
     * Establece una nueva lista de productos.
     * 
     * @param listaCrud La nueva lista de ProductoDTO.
     */
	public void setListaCrud(ArrayList<ProductoDTO> listaCrud) {
		this.listaCrud = listaCrud;
	}
	
	
	
}
