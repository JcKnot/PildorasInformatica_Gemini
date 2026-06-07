
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
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaEmergenteM miLamina = new LaminaEmergenteM();
        add(miLamina);
    }
}

class LaminaEmergenteM extends JPanel{
    
    public LaminaEmergenteM(){
        JPopupMenu emergente = new JPopupMenu();
        JMenuItem op1 = new JMenuItem("Opcion 1");
        JMenuItem op2 = new JMenuItem("Opcion 2");
        JMenuItem op3 = new JMenuItem("Opcion 3");
        emergente.add(op1);
        emergente.add(op2);
        emergente.add(op3);
        setComponentPopupMenu(emergente);
        
    }        
}