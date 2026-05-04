
package practicaCursoPildorasInformatica.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jose Castillo
 *
 */
public class EjemploArea {
    
    public static void main(String[] args) {
        MarcoArea miMarco =  new MarcoArea();
        miMarco.setVisible(true);
    }
    
}

class MarcoArea extends JFrame{
    
    public MarcoArea(){
        setBounds(400, 400, 500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        LaminaArea miLamina = new LaminaArea();
        add(miLamina);
    }
}

class LaminaArea extends JPanel{
    JTextArea miArea;
    
    public LaminaArea(){
        miArea = new JTextArea(8,20);
        JScrollPane laminaBarra = new JScrollPane(miArea);
        miArea.setLineWrap(true);
        add(laminaBarra);        
        
        JButton miBoton = new JButton("Dale");
        miBoton.addActionListener(new GestionaArea());
        add(miBoton);
    }
    
    private class GestionaArea implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(miArea.getText());
        }
        
    }
}