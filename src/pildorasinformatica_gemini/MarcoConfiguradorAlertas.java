
package pildorasinformatica_gemini;

import javax.swing.JFrame;

/**
 *
 * @author "Jose Castillo"
 *
 */
public class MarcoConfiguradorAlertas extends JFrame {
    private LaminaConfiguradorAlertas miLamina = new LaminaConfiguradorAlertas();
    
    public static void main(String[] args) {
        MarcoConfiguradorAlertas miMarco = new MarcoConfiguradorAlertas();
        miMarco.setVisible(true);
    }
    
    public MarcoConfiguradorAlertas(){
        setTitle("Alerta");
        setBounds(500, 500, 500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(miLamina);
    }

}
