package practicaCursoPildorasInformatica.grafico;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 *
 */
public class CreandoMarcos {
    public static void main(String[] args) {
        
        miMarco marco1 = new miMarco();
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}

class miMarco extends JFrame{
    
    public miMarco(){
        setSize(500, 300);
        setLocation(500,300);
        setBounds(500,300,550,250);
        setTitle("Mi ventana");
//        setResizable(false);
//        setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}