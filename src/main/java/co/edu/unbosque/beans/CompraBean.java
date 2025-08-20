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

	private String nombre;
	private String email;
	private String direccion;
	private String celular;
	private String fechaNacimiento;
	private double total;

	@Inject
	private CarritoBean cb;
	@Inject
	private UsuarioService usuarioService;

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

	// ==== Getters y Setters ====

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	   public double getTotal() {
		   
	        double suma = 0.0;
	        if (cb != null && cb.getProductosCarrito() != null) {
	            for (ProductoDTO producto : cb.getProductosCarrito()) {
	                suma += producto.getPrecio();
	            }
	        }
	        return suma;
	    }

}