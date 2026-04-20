

package practicaCursoPildorasInformatica.grafico;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 */
public class PruebaAcciones {
    
    public static void main(String[] args) {
        MarcoAccion marco = new MarcoAccion();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
    
}

class MarcoAccion extends JFrame{
    
    public MarcoAccion(){
        setTitle("Prueba Acciones");
        setBounds(600, 300, 700, 350);
        PanelAccion lamina = new PanelAccion();
        add(lamina);
    }
}

class PanelAccion extends JPanel{
    
    public PanelAccion(){       
        AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboard-inventory.png")
                                                    ,Color.YELLOW);
        AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboard-tasks.png")
                                                    ,Color.BLUE);
        AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboardplan.png")
                                                    ,Color.RED);
//        JButton btnAmarillo = new JButton(accionAmarillo);
//        JButton btnAzul = new JButton(accionAzul);
//        JButton btnVerde = new JButton(accionVerde);         
        add(new JButton(accionAmarillo));
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));

//        JButton btnAmarillo = new JButton("Amarillo");
//        JButton btnAzul = new JButton("Azul");
//        JButton btnRojo = new JButton("Rojo");        
//        add(btnAmarillo);
//        add(btnAzul);
//        add(btnRojo);
        
    }
    
    private class AccionColor extends AbstractAction{

        public AccionColor(String nombre, Icon icono, Color colorBoton){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color " + nombre);
            putValue("colorBoton", colorBoton);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("colorBoton");
            setBackground(c);
            System.out.println("Nombre: " + getValue(Action.NAME));
        }

    }
}
