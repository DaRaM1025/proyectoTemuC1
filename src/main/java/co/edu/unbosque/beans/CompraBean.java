package co.edu.unbosque.beans;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.annotation.ManagedBean;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Properties;

@Named("compraBean")
@ManagedBean
@ViewScoped
public class CompraBean implements Serializable {

	private String nombre;
	private String email;
	private String direccion;
	private String celular;
	private String fechaNacimiento;

	public void comprar() {

		try {
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

			document.close();

			// Configuracion del correo
			String remitente = "shoppingtemunotifications@gmail.com";
			String clave = "ukwo ntjl vose wqeg";
			String destinatario = email;

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(remitente, clave);
				}
			});

			// Se crea el mensaje
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remitente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("Confirmación de compra");

			// Texto del correo
			MimeBodyPart texto = new MimeBodyPart();
			texto.setText("Hola " + nombre + ",\n\nAdjunto encontrarás el comprobante de tu compra.");

			// Adjuntar PDF
			MimeBodyPart adjunto = new MimeBodyPart();
			adjunto.setFileName("factura.pdf");
			adjunto.setContent(baos.toByteArray(), "application/pdf");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(texto);
			multipart.addBodyPart(adjunto);

			message.setContent(multipart);

			// Envio
			Transport.send(message);

			System.out.println("Correo enviado correctamente a " + destinatario);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
}