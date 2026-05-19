
package practicaCursoPildorasInformatica.grafico;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Jose Castillo
 *
 */
public class SintaxisRadio {
    
    public static void main(String[] args) {
        
        MarcoRadioSintaxis miMarco = new MarcoRadioSintaxis();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}

class MarcoRadioSintaxis extends JFrame{
    
    public MarcoRadioSintaxis(){
        setVisible(true);
        setBounds(550, 300, 500, 300);
        LaminaRadioSintaxis miLamina = new LaminaRadioSintaxis();
        add(miLamina);
    }
}

class LaminaRadioSintaxis extends JPanel{
    
    public LaminaRadioSintaxis(){
        ButtonGroup miGrupo1 = new ButtonGroup();
        ButtonGroup miGrupo2 = new ButtonGroup();
        JRadioButton miRadio1 = new JRadioButton("Azul", false);
        JRadioButton miRadio2 = new JRadioButton("Rojo", true);
        JRadioButton miRadio3 = new JRadioButton("Verde", false);
        JRadioButton miRadio4 = new JRadioButton("Rojo", true);
        JRadioButton miRadio5 = new JRadioButton("Verde", false);
        
        miGrupo1.add(miRadio1);
        miGrupo1.add(miRadio2);
        miGrupo1.add(miRadio3);
        miGrupo2.add(miRadio4);
        miGrupo2.add(miRadio5);
        
        add(miRadio1);
        add(miRadio2);
        add(miRadio3);
        add(miRadio4);
        add(miRadio5);
        
        
    }
}