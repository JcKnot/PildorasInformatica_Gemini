
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import javax.swing.SwingConstants;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoSliders {
    
    public static void main(String[] args) {
        FrameSliders miMarco = new FrameSliders();
        miMarco.setVisible(true);
    }

}

class FrameSliders extends JFrame{
    
    public FrameSliders(){
        setBounds(500, 300, 500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        LaminaSliders miLamina = new LaminaSliders();
        add(miLamina);        
    }
}

class LaminaSliders extends JPanel{
    private JLabel rotulo;
    private JSlider control;
    
    public LaminaSliders(){
        setLayout(new BorderLayout());
        rotulo = new JLabel("En un lugar de la mancha");
        add(rotulo, BorderLayout.CENTER);
        
        control = new JSlider(8, 48, 12);
        control.setMajorTickSpacing(8);
        control.setMinorTickSpacing(1);
        control.setPaintTicks(true);
        control.setPaintLabels(true);
        control.setFont(new Font("Serif", Font.PLAIN, 10));
        control.addChangeListener(new EventoSlider());
        JPanel laminaSlider = new JPanel();
        laminaSlider.add(control);
        add(laminaSlider, BorderLayout.NORTH);
        
//        JSlider control = new JSlider(0, 100, 25);
////        control.setOrientation(SwingConstants.VERTICAL); //Cambia orientacion
//        control.setMajorTickSpacing(25); //Marcas grandes
//        control.setMinorTickSpacing(5); //Marcas pequeñas
//        control.setPaintTicks(true); //Muestra las marcas
//        control.setFont(new Font("Serif", Font.ITALIC, 12)); //Establece fuente
//        control.setPaintLabels(false); //Muestra los digitos de las marcas
//        control.setSnapToTicks(true); //Muevo slider a la marca mas cercana
//        add(control);
    }
    
    private class EventoSlider implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {            
            rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));
        }
        
    }
}