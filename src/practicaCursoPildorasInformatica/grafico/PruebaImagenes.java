package practicaCursoPildorasInformatica.grafico;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 *
 */
public class PruebaImagenes {
    public static void main(String[] args) {
        MarcoImagen miMarco = new MarcoImagen();
        miMarco.setVisible(true);
    }
}

class MarcoImagen extends JFrame{
    
    public MarcoImagen(){
        setTitle("Marco con Imagen");
        setBounds(750,300,300,200);
        LaminaImagen miLamina = new LaminaImagen();
        add(miLamina);
    }
}

class LaminaImagen extends JPanel{
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
    }
}