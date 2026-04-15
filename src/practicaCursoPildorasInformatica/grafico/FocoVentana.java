
package practicaCursoPildorasInformatica.grafico;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;

/**
 *
 * @author slipk
 */
public class FocoVentana extends JFrame implements WindowFocusListener{
    
    FocoVentana marco1;
    FocoVentana marco2;
    
    public static void main(String[] args) {
        
        FocoVentana miv = new FocoVentana();
        miv.iniciar();
        
    }
    
    public void iniciar(){        
        marco1 = new FocoVentana();
        marco2 = new FocoVentana();
        
        marco1.setBounds(200, 100, 600, 350);
        marco2.setBounds(900, 100, 600, 350);
        
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);
        
        marco1.setVisible(true);
        marco2.setVisible(true);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        if(e.getSource() == marco1){
            marco1.setTitle("Tiene Foco");
        }else {
            marco2.setTitle("Tiene Foco");
        }
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if(e.getSource() == marco1){
            marco1.setTitle("");
        }else {
            marco2.setTitle("");
        }
    }
    
}
