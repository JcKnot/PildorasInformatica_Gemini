
package practicaCursoPildorasInformatica.grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 *
 */
public class PruebaCheckbox {
    
    public static void main(String[] args) {
        
        MarcoCheck miMarco = new MarcoCheck();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoCheck extends JFrame{
    
    public MarcoCheck(){
        setBounds(550, 300, 550, 350);
        setVisible(true);
        LaminaCheck miLamina = new LaminaCheck();
        add(miLamina);
        
    }
}

class LaminaCheck extends JPanel{
    
    public LaminaCheck(){
        
    }
}