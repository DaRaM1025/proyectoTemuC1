package co.edu.unbosque.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Map; // Importa Map para leer parámetros de la petición

@Named("temaBean")
@SessionScoped
public class TemaBean implements Serializable {

	private boolean modoOscuro;

	@PostConstruct
	public void init() {
		modoOscuro = false;
	}

	public void alternarTema() {
		modoOscuro = !modoOscuro;
		System.out.println("Modo oscuro cambiado a: " + modoOscuro + " (desde p:toggleSwitch)");

		// Envía una llamada a la función JavaScript 'aplicarTema'.
		FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts()
				.add("aplicarTema(" + modoOscuro + ");");
	}

	public void sincronizarModoOscuroDesdeCliente() {
		// Accede a los parámetros enviados por el p:remoteCommand
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String clientStateStr = params.get("clientDarkModeState"); // 'clientDarkModeState' es el nombre del parámetro
																	// que enviaremos desde JS

		if (clientStateStr != null) {
			this.modoOscuro = Boolean.parseBoolean(clientStateStr);
			System.out.println("Modo oscuro sincronizado desde cliente (localStorage): " + this.modoOscuro);
		}
	}

	public boolean isModoOscuro() {
		return modoOscuro;
	}

	public void setModoOscuro(boolean modoOscuro) {
		this.modoOscuro = modoOscuro;
	}
}
