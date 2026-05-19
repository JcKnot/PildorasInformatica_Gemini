
package pildorasinformatica_gemini;

import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoContrato extends JFrame{
    private LaminaContrato laminaContrato;
    
    public MarcoContrato(){
        setSize(500, 350);
        setLocationRelativeTo(null);
        laminaContrato = new LaminaContrato();
        add(laminaContrato);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
