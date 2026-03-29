
package practicaCursoPildorasInformatica.grafico;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
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
        miMarco.setLocationRelativeTo(null);
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
//        g.drawRect(50, 50, 300, 300);
        
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
        g2.draw(rectangulo);
        Ellipse2D elipse = new Ellipse2D.Double();
        elipse.setFrame(rectangulo);
        g2.draw(elipse);
        g2.draw(new Line2D.Double(100,100,300,250));
        Double centroX = rectangulo.getCenterX();
        Double centroY = rectangulo.getCenterY();
        Double radio = 150.00;
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(centroX, centroY, centroX+radio, centroY+radio);
        g2.draw(circulo);
    }
}