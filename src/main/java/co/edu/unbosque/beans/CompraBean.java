/**
 * Clase que representa el bean de la vista de compra
 * Gestiona la información del usuario y el proceso de compra, incluyendo la generación de facturas en PDF y el envío de correos electrónicos
 * @author Nataly Vanessa Rengifo Bautista
 */
package co.edu.unbosque.beans;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import co.edu.unbosque.model.Usuario;
import co.edu.unbosque.service.UsuarioService;
import co.edu.unbosque.model.ProductoDTO;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Named("compraBean")
@ManagedBean
@ViewScoped
public class CompraBean implements Serializable {

	/**
	 * Nombre del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private String nombre;

	/**
	 * Correo electrónico del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private String email;

	/**
	 * Dirección del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private String direccion;

	/**
	 * Número de celular del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private String celular;

	/**
	 * Fecha de nacimiento del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private String fechaNacimiento;

	/**
	 * Total de la compra
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private double total;

	/**
	 * Latitud de la ubicación del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private Double latitud;

	/**
	 * Longitud de la ubicación del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	private Double longitud;

	/**
	 * Bean del carrito de compras inyectado
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	@Inject
	private CarritoBean cb;

	/**
	 * Servicio para gestionar usuarios
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	@Inject
	private UsuarioService usuarioService;

	/**
	 * Inicializa el bean cargando la información del usuario desde la sesión
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	@PostConstruct
	public void init() {
		try {
			Object obj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioActual");

			if (obj instanceof Usuario u) {
				this.nombre = u.getNombre();
				this.email = u.getEmail();
				this.celular = u.getTelefono();
				if (u.getFechaNacimiento() != null) {
					this.fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").format(u.getFechaNacimiento());
				}

				System.out.println("[CompraBean] Usuario cargado de sesión: " + u.getUsername());
				return;
			}

			Object usernameObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("usuarioLogueado");

			if (usernameObj instanceof String username && usuarioService != null) {
				for (Usuario u : usuarioService.obtenerUsuarios()) {
					if (u.getUsername().equalsIgnoreCase(username)) {
						this.nombre = u.getNombre();
						this.email = u.getEmail();
						this.celular = u.getTelefono();
						if (u.getFechaNacimiento() != null) {
							this.fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").format(u.getFechaNacimiento());
						}
						System.out.println("[CompraBean] Usuario encontrado por username: " + username);
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recibe y procesa la información de geolocalización enviada desde el cliente
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void recibirGeocoding() {
	    try {
	        var params = FacesContext.getCurrentInstance()
	                .getExternalContext()
	                .getRequestParameterMap();

	        String lat = params.get("lat");
	        String lng = params.get("lng");
	        String formatted = params.get("formatted");

	        if (lat != null && lng != null) {
	            this.latitud = Double.valueOf(lat);
	            this.longitud = Double.valueOf(lng);
	        }
	        if (formatted != null && !formatted.isBlank()) {
	            this.direccion = formatted; // guarda dirección normalizada
	        }

	        System.out.println("[CompraBean] Geo OK -> " + latitud + ", " + longitud + " | " + this.direccion);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Procesa la compra, genera una factura en PDF y envía un correo al usuario con el comprobante
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void comprar() {
		try {
			ArrayList<ProductoDTO> listaProductos = cb.getProductosCarrito();
			// Se crea el PDF del correo
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, baos);
			document.open();

			document.add(new Paragraph("Factura de Compra"));
			document.add(new Paragraph("Nombre: " + nombre));
			document.add(new Paragraph("Email: " + email));
			document.add(new Paragraph("Celular: " + celular));
			document.add(new Paragraph("Dirección: " + direccion));
			document.add(new Paragraph("Fecha Nacimiento: " + fechaNacimiento));
			document.add(new Paragraph("\n--- Productos comprados ---"));

			for (ProductoDTO p : listaProductos) {
				document.add(new Paragraph("Producto: " + p.getNombre() + " | Precio: $" + p.getPrecio()
						+ " | Cantidad: " + p.getCantidad()));
			}
			document.add(new Paragraph("Total de Compra" + total));
			document.close();

			// Configuración del correo
			String remitente = "shoppingtemunotifications@gmail.com";
			String clave = "ukwo ntjl vose wqeg";
			String destinatario = email;

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(remitente, clave);
				}
			});

			// Crear mensaje
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remitente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("Confirmación de compra");

			// Texto del correo
			MimeBodyPart texto = new MimeBodyPart();
			texto.setText("Hola " + nombre + ",\nAdjunto encontrarás el comprobante de tu compra.");

			// Adjuntar PDF
			MimeBodyPart adjunto = new MimeBodyPart();
			adjunto.setFileName("factura.pdf");
			adjunto.setContent(baos.toByteArray(), "application/pdf");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(texto);
			multipart.addBodyPart(adjunto);

			message.setContent(multipart);

			// Envío
			Transport.send(message);

			System.out.println("Correo enviado correctamente a " + destinatario);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene el nombre del usuario
	 * @return El nombre del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario
	 * @param nombre El nombre del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el correo electrónico del usuario
	 * @return El correo electrónico del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el correo electrónico del usuario
	 * @param email El correo electrónico del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene la dirección del usuario
	 * @return La dirección del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección del usuario
	 * @param direccion La dirección del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el número de celular del usuario
	 * @return El número de celular del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Establece el número de celular del usuario
	 * @param celular El número de celular del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Obtiene la fecha de nacimiento del usuario
	 * @return La fecha de nacimiento del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece la fecha de nacimiento del usuario
	 * @param fechaNacimiento La fecha de nacimiento del usuario
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Calcula el total de la compra sumando los precios de los productos en el carrito
	 * @return El total de la compra
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public double getTotal() {
		double suma = 0.0;
		if (cb != null && cb.getProductosCarrito() != null) {
			for (ProductoDTO producto : cb.getProductosCarrito()) {
				suma += producto.getPrecio();
			}
		}
		return suma;
	}

	/**
	 * Obtiene la latitud de la ubicación del usuario
	 * @return La latitud de la ubicación
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public Double getLatitud() {
		return latitud;
	}

	/**
	 * Establece la latitud de la ubicación del usuario
	 * @param latitud La latitud de la ubicación
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * Obtiene la longitud de la ubicación del usuario
	 * @return La longitud de la ubicación
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public Double getLongitud() {
		return longitud;
	}

	/**
	 * Establece la longitud de la ubicación del usuario
	 * @param longitud La longitud de la ubicación
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * Obtiene el bean del carrito de compras
	 * @return El bean del carrito de compras
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public CarritoBean getCb() {
		return cb;
	}

	/**
	 * Establece el bean del carrito de compras
	 * @param cb El bean del carrito de compras
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setCb(CarritoBean cb) {
		this.cb = cb;
	}

	/**
	 * Obtiene el servicio de usuarios
	 * @return El servicio de usuarios
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	/**
	 * Establece el servicio de usuarios
	 * @param usuarioService El servicio de usuarios
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * Establece el total de la compra
	 * @param total El total de la compra
	 * @author Nataly Vanessa Rengifo Bautista
	 */
	public void setTotal(double total) {
		this.total = total;
	}
}