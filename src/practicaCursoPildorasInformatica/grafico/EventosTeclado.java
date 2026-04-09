
package practicaCursoPildorasInformatica.grafico;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 * 
 */

public class EventosTeclado {
    
    public static void main(String[] args) {
        
        MarcoConTeclas mimarco = new MarcoConTeclas();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConTeclas extends JFrame {
    
    public MarcoConTeclas(){
        setBounds(700, 300, 600, 450);
        setVisible(true);   
        EventoDeTeclado tecla = new EventoDeTeclado();
        addKeyListener(tecla);
    }
}
        
class EventoDeTeclado implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        char letra = e.getKeyChar();
        System.out.println(letra);
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        int codigo = e.getKeyCode();
//        System.out.println(codigo);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}