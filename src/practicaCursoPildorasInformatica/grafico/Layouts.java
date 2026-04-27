
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author "Jose Castillo"
 *
 */
public class Layouts {
    
    public static void main(String[] args) {
        
        MarcoLayout marco = new MarcoLayout();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

}

class MarcoLayout extends JFrame{
    
    public MarcoLayout(){
        setTitle("Prueba Layout");
        setBounds(600, 300, 600, 300);
        PanelLayout lamina = new PanelLayout();
        PanelLayout2 lamina2 = new PanelLayout2();
        
//        FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT);
//        setLayout(disposicion);

        add(lamina,BorderLayout.NORTH);
        add(lamina2,BorderLayout.SOUTH);
        
    }
}

class PanelLayout extends JPanel{
    
    public PanelLayout(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JButton("Amarillo"),BorderLayout.NORTH);
        add(new JButton("Rojo"),BorderLayout.SOUTH);
    }
}

class PanelLayout2 extends JPanel{
    
    public PanelLayout2(){
        setLayout(new BorderLayout(10, 10));
        add(new JButton("Azul"),BorderLayout.WEST);
        add(new JButton("Verde"),BorderLayout.EAST);
        add(new JButton("Naranja"),BorderLayout.CENTER);
    }
}