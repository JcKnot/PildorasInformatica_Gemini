
package practicaCursoPildorasInformatica.grafico;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author slipk
 */
public class PruebaDibujo {
    public static void main(String[] args) {
        
        MarcoConDibujos miMarco = new MarcoConDibujos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoConDibujos extends JFrame{
    
    public MarcoConDibujos(){
        setTitle("Prueba de Dibujo");
        setSize(400, 400);
        LaminaConFiguras miLamina = new LaminaConFiguras();
        add(miLamina);
    }
}

class LaminaConFiguras extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(50, 50, 300, 300);
    }
}