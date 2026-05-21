
package pildorasinformatica_gemini;

import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoCompensacion extends JFrame {
    private LaminaCompensacion miLamina;
    
    public MarcoCompensacion(){
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        miLamina = new LaminaCompensacion();
        add(miLamina);
        setVisible(true);
    }

}
