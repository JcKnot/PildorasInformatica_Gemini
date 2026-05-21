
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
//import javax.swing.SwingConstants;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoSpinner {
    
    public static void main(String[] args) {
        FrameSpinner miMarco = new FrameSpinner();
        miMarco.setVisible(true);
    }

}

class FrameSpinner extends JFrame{
    
    public FrameSpinner(){
        setBounds(500, 300, 500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        LaminaSpinner miLamina = new LaminaSpinner();
        add(miLamina);        
    }
}

class LaminaSpinner extends JPanel{
    
    public LaminaSpinner(){
//        String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
//        String lista[] = {"Enero","Febrero","Marzo","Abril","Mayo"};
//        JSpinner control = new JSpinner(new SpinnerListModel(lista));
        JSpinner control = new JSpinner(new MiModeloJspinner());
        control.setPreferredSize(new Dimension(100, 20));
        add(control);
    }
    
    private class MiModeloJspinner extends SpinnerNumberModel{
        
        public MiModeloJspinner(){
            super(5,0,10,1);            
        }
        
        @Override
        public Object getNextValue(){
            return super.getPreviousValue();
        }
        
        @Override
        public Object getPreviousValue(){
            return super.getNextValue();
        }
    }

}