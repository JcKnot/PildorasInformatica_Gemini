
package pildorasinformatica_gemini;

import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoCredenciales extends JFrame{
    
    public static void main(String[] args) {
        MarcoCredenciales miMarco = new MarcoCredenciales();
        miMarco.setVisible(true);
        
    }
    
    public MarcoCredenciales(){
        setTitle("Terminal Credenciales");
        setBounds(400, 400, 600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        LaminaCredenciales miLamina = new LaminaCredenciales();
        add(miLamina);
        pack();
    }

}
