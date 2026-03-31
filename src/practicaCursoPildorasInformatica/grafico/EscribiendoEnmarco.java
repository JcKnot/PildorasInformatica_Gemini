package practicaCursoPildorasInformatica.grafico;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
        Graphics2D g2 = (Graphics2D) g;
        Font fuente = new Font("Arial", Font.BOLD, 26);
        g2.setFont(fuente);
        g.drawString("Estamos aprendiendo swing", 100, 100);
        
    }
}