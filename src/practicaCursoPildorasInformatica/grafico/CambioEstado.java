package practicaCursoPildorasInformatica.grafico;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 *
 */
public class CambioEstado {
    
    public static void main(String[] args) {
        
        MarcoEstado miMarco = new MarcoEstado();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoEstado extends JFrame{
    
    public MarcoEstado(){
        setTitle("Estado Ventana");
        setBounds(350, 50, 500, 700);
        CambioEstadoVentana estado = new CambioEstadoVentana();
        addWindowStateListener(estado);
    }
}

class CambioEstadoVentana implements WindowStateListener{

    @Override
    public void windowStateChanged(WindowEvent e) {
        System.out.println("La ventana ha cambiado de estado");
        
        if(e.getNewState() == JFrame.MAXIMIZED_BOTH){
            System.out.println("Ventana Maximizada");
        }else if (e.getNewState() ==  JFrame.NORMAL){
            System.out.println("Ventana Normal");
        }
//        System.out.println(e.getNewState());
    }
    
}