
package pildorasinformatica_gemini;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 */
public class AccionColor extends AbstractAction {
    
    private JPanel panel;
    
    public AccionColor (String nombre, Icon icono, Color c, JPanel lamina){
        this.panel = lamina;
        putValue(Action.NAME, nombre);
        putValue(Action.SMALL_ICON, icono);
        putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
        putValue("color_fondo", c);
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setBackground((Color) getValue("color_fondo"));
        panel.repaint();
    }
    
}
