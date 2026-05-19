
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 *
 */
public class PruebaCombo {

    public static void main(String[] args) {
        MarcoCombo miMarco = new MarcoCombo();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoCombo extends JFrame{
    
    public MarcoCombo(){
        setBounds(500, 300, 600, 450);        
        LaminaCombo miLamina = new LaminaCombo();
        add(miLamina);
        setVisible(true);
    }
}

class LaminaCombo extends JPanel{
    private JLabel texto;
    private JComboBox miCombo;
    
    public LaminaCombo(){
        setLayout(new BorderLayout());
        texto = new JLabel("En un lugar de la mancha");
        texto.setFont(new Font("Serif", Font.PLAIN, 12));
        add(texto, BorderLayout.CENTER);
        
        JPanel laminaNorte = new JPanel();
        
        miCombo = new JComboBox();
        miCombo.addItem("Serif");
        miCombo.addItem("SansSerif");
        miCombo.addItem("Monospaced");
        miCombo.addItem("Dialog");
        
        EventoCombo miEvento = new EventoCombo();
        miCombo.addActionListener(miEvento);
        
        laminaNorte.add(miCombo);
        add(laminaNorte, BorderLayout.NORTH);
    }
    
    private class EventoCombo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            texto.setFont(new Font((String) miCombo.getSelectedItem(), Font.PLAIN, 18));
        }
        
    }
}
