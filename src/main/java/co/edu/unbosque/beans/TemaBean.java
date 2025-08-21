package co.edu.unbosque.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * Administra la configuración del tema (modo claro u oscuro) de la aplicación.
 * Permite alternar entre modos y sincronizar el estado del tema con el cliente.
 * @author David Santiago Ramirez Arevalo
 */
@Named("temaBean")
@SessionScoped
public class TemaBean implements Serializable {

    private boolean modoOscuro;

    /**
     * Inicializa el estado del tema con el modo oscuro desactivado.
     */
    @PostConstruct
    public void init() {
        modoOscuro = false;
    }

    /**
     * Alterna entre el modo claro y oscuro, actualizando el estado y enviando una llamada JavaScript para aplicar el tema.
     */
    public void alternarTema() {
        modoOscuro = !modoOscuro;
        System.out.println("Modo oscuro cambiado a: " + modoOscuro + " (desde p:toggleSwitch)");
        FacesContext.getCurrentInstance().getPartialViewContext().getEvalScripts()
                .add("aplicarTema(" + modoOscuro + ");");
    }

    /**
     * Sincroniza el estado del modo oscuro con el valor recibido desde el cliente (localStorage).
     */
    public void sincronizarModoOscuroDesdeCliente() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String clientStateStr = params.get("clientDarkModeState");
        if (clientStateStr != null) {
            this.modoOscuro = Boolean.parseBoolean(clientStateStr);
            System.out.println("Modo oscuro sincronizado desde cliente (localStorage): " + this.modoOscuro);
        }
    }

    /**
     * Obtiene el estado actual del modo oscuro.
     * @return true si el modo oscuro está activado, false en caso claro
     */
    public boolean isModoOscuro() {
        return modoOscuro;
    }

    /**
     * Establece el estado del modo oscuro.
     * @param modoOscuro El estado del modo oscuro a establecer
     */
    public void setModoOscuro(boolean modoOscuro) {
        this.modoOscuro = modoOscuro;
    }
}