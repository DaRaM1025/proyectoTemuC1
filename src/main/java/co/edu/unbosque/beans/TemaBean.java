package co.edu.unbosque.beans;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * <p><b>TemaBean</b> — Bean de sesión encargado de administrar el modo claro/oscuro
 * de la interfaz y de sincronizar su estado entre el servidor (JSF) y el cliente (navegador).</p>
 *
 * <p>Características principales:</p>
 * <ul>
 *   <li>Mantiene en {@code modoOscuro} el estado del tema para la sesión del usuario.</li>
 *   <li>Inicializa el modo en <em>claro</em> ({@code false}) mediante {@link #init()}.</li>
 *   <li>Permite alternar el tema y ordena al cliente aplicarlo ejecutando la función JS
 *       global {@code aplicarTema(boolean)} vía {@link FacesContext#getPartialViewContext()}.</li>
 *   <li>Puede sincronizar el estado con el que guarda el cliente (por ejemplo en
 *       {@code localStorage}) leyendo el parámetro de petición
 *       {@code clientDarkModeState} en {@link #sincronizarModoOscuroDesdeCliente()}.</li>
 * </ul>
 *
 * <p><b>Ámbito:</b> {@link SessionScoped} — el estado persiste a lo largo de la sesión del usuario.</p>
 *
 * @author David Santiago ramirez Arevalo
 */
@Named("temaBean")
@SessionScoped
public class TemaBean implements Serializable {

    /**
     * Bandera que indica si el modo oscuro está activado ({@code true}) o no ({@code false}).
     */
    private boolean modoOscuro;

    /**
     * Inicializa el bean con el modo oscuro desactivado.
     * Se ejecuta una vez cuando el bean se construye al inicio de la sesión.
     */
    @PostConstruct
    public void init() {
        modoOscuro = false;
    }

    /**
     * Alterna el tema en el cliente según el valor actual de {@link #modoOscuro}.
     * <p>
     * No realiza navegación ni refresco de componentes; en su lugar, inyecta
     * una instrucción JavaScript en la respuesta parcial para ejecutar
     * {@code aplicarTema(modoOscuro)} en el navegador, donde la función
     * debe encargarse de añadir o quitar la clase CSS adecuada (por ejemplo,
     * {@code .dark-mode}) y persistir la preferencia si se desea.
     * </p>
     */
    public void alternarTema() {
        System.out.println("Modo oscuro cambiado a: " + modoOscuro);
        FacesContext.getCurrentInstance()
                .getPartialViewContext()
                .getEvalScripts()
                .add("aplicarTema(" + modoOscuro + ");");
    }

    /**
     * Sincroniza el valor del modo oscuro con el estado reportado por el cliente.
     * <p>
     * Lee el parámetro de la petición {@code clientDarkModeState} (por ejemplo,
     * enviado desde JavaScript con el valor guardado en {@code localStorage})
     * y actualiza {@link #modoOscuro}. Si el parámetro no está presente, no hace nada.
     * </p>
     */
    public void sincronizarModoOscuroDesdeCliente() {
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
        String clientStateStr = params.get("clientDarkModeState");
        if (clientStateStr != null) {
            this.modoOscuro = Boolean.parseBoolean(clientStateStr);
            System.out.println("Sincronizado desde cliente: " + this.modoOscuro);
        }
    }

    /**
     * Indica si el modo oscuro está activo.
     * @return {@code true} si el modo oscuro está activado; {@code false} en caso contrario
     */
    public boolean isModoOscuro() { return modoOscuro; }

    /**
     * Establece el estado del modo oscuro.
     * @param modoOscuro {@code true} para activar el modo oscuro; {@code false} para desactivarlo
     */
    public void setModoOscuro(boolean modoOscuro) { this.modoOscuro = modoOscuro; }
}
