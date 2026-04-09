

package practicaCursoPildorasInformatica.grafico;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 * 
 */
public class EventoRaton {
    
    public static void main(String[] args) {
        MarcoRaton miMarco = new MarcoRaton();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoRaton extends JFrame {
    
    public MarcoRaton(){
        setBounds(700, 300, 600, 450);
        setVisible(true);
        EventosRaton raton = new EventosRaton();
        addMouseListener(raton);
    }
}

class EventosRaton implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Has hecho click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Precionado");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Click suelto");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}