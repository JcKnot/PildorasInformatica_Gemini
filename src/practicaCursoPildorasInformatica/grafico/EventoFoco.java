
package practicaCursoPildorasInformatica.grafico;

import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author slipk
 */
public class EventoFoco {
    
    public static void main(String[] args) {
        
        MarcoFoco miMarco = new MarcoFoco();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class MarcoFoco extends JFrame {
    
    public MarcoFoco(){
        setBounds(300, 300, 600, 450);
        add(new LaminaFoco());
        setVisible(true);        
    }
}

class LaminaFoco extends JPanel {
    
    private JTextField jTxCuadro1;
    private JTextField jTxCuadro2;
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setLayout(null);
        
        jTxCuadro1 = new JTextField();
        jTxCuadro2 = new JTextField();
        
        jTxCuadro1.setBounds(120, 10, 150, 20);
        jTxCuadro2.setBounds(120, 50, 150, 20);
        
        add(jTxCuadro1);
        add(jTxCuadro2);
        
        LanzaFoco foco = new LanzaFoco();
        jTxCuadro1.addFocusListener(foco);

    }
    
    private class LanzaFoco implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
//            System.out.println("");
        }

        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("He perdido el foco");
        }

    }
    
}

