
package practicaCursoPildorasInformatica.grafico;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoMEmergente {

    public static void main(String[] args) {
        MarcoEmergenteM miMarco = new MarcoEmergenteM();
        miMarco.setVisible(true);
    }
}

class MarcoEmergenteM extends JFrame{
    
    public MarcoEmergenteM(){
        setBounds(100, 100, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaEmergenteM miLamina = new LaminaEmergenteM();
        add(miLamina);
    }
}

class LaminaEmergenteM extends JPanel{
    
    public LaminaEmergenteM(){
        JPopupMenu emergente = new JPopupMenu();
        JMenuItem op1 = new JMenuItem("Opcion 1");
        emergente.add(op1);
        setComponentPopupMenu(emergente);
        
    }        
}