
package pildorasinformatica_gemini;

import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoConfigPerfil extends JFrame {
    
    public MarcoConfigPerfil(){
        setLocationRelativeTo(null);
        setSize(500, 350);
        LaminaConfigPerfil laminaPerfil = new LaminaConfigPerfil();
        add(laminaPerfil);
    }

}
