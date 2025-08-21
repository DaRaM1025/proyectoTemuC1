package co.edu.unbosque.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.inject.Named;

/**
 * Administra la interacción con un componente de selección booleana en un formulario.
 * Proporciona funcionalidad para manejar eventos AJAX y mostrar mensajes según el estado
 * del componente de entrada booleana (seleccionado o no seleccionado).
 * @author David Santiago Ramirez Arevalo
 */
@Named(value = "selectBooleanView")
@RequestScoped
public class SelectBooleanView {

    private boolean value1;

    /**
     * Obtiene el valor del componente booleano.
     * @return true si el componente está seleccionado, false en caso contrario
     */
    public boolean isValue1() {
        return value1;
    }

    /**
     * Establece el valor del componente booleano.
     * @param value1 El valor booleano a establecer
     */
    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    /**
     * Maneja un evento AJAX para el componente de entrada booleana y muestra un mensaje
     * indicando si el componente está seleccionado o no.
     * @param event El evento AJAX desencadenado por el componente
     */
    public void addMessage(AjaxBehaviorEvent event) {
        UIComponent component = event.getComponent();
        if (component instanceof UIInput) {
            UIInput inputComponent = (UIInput) component;
            Boolean value = (Boolean) inputComponent.getValue();
            String summary = value ? "Checked" : "Unchecked";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
        }
    }
}