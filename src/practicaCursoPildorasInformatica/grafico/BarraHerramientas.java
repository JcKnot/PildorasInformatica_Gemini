
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author Jose Castillo
 *
 */
public class BarraHerramientas {
    
    public static void main(String[] args) {
        MarcoBarra miMarco = new MarcoBarra();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
    

}

class MarcoBarra extends JFrame{
    private JPanel lamina;
    public MarcoBarra(){
        setTitle("Marco con Barra");
        setBounds(500, 300, 600, 450);
        lamina = new JPanel();
        add(lamina);
        
        //Configuracion de acciones
        
        Action accionAzul = new AccionColor("Azul", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboard-tasks.png"), Color.BLUE);
        Action accionAmarillo = new AccionColor("Amarillo", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboard-inventory.png"), Color.YELLOW);
        Action accionRojo = new AccionColor("Rojo", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboardplan.png"), Color.RED);
        Action accionSalir =  new AbstractAction("Salir", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/icono.png")){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }            
        };
        
        JMenu menu = new JMenu("Color");
        menu.add(accionAzul);
        menu.add(accionAmarillo);
        menu.add(accionRojo);
        
        JMenuBar barraMenu = new JMenuBar();
        barraMenu.add(menu);
        
        setJMenuBar(barraMenu);
        
        // Construccion de la barra de herramientas
        
        JToolBar barra = new JToolBar();
        barra.add(accionAzul);
        barra.add(accionAmarillo);
        barra.add(accionRojo);
        barra.addSeparator();
        barra.add(accionSalir);
        add(barra, BorderLayout.NORTH);
    }
    
    private class AccionColor extends AbstractAction{
        
        public AccionColor(String nombre, Icon icono, Color c){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Color de Fondo... " + nombre);       
            putValue("Color", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("Color");
            lamina.setBackground(c);
        }
        
        
    }
}
