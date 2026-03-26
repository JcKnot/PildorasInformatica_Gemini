package practicaCursoPildorasInformatica.grafico;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 *
 */
public class EscribiendoEnmarco {
    
    public static void main(String[] args) {
        MarcoConTexto miMarco = new MarcoConTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


class MarcoConTexto extends JFrame{
    
    public MarcoConTexto(){
        setVisible(true);
        setSize(600, 450);
        setLocation(400,200);
        setTitle("primer texto");
        Lamina lamina = new Lamina();
        add(lamina);
    }
}

class Lamina extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Estamos aprendiendo swing", 100, 100);
    }
}