
package pildorasinformatica_gemini;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author slipk
 */
public class MarcoCentrado extends JFrame {
    
    public MarcoCentrado(){
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension sizeScreen = screen.getScreenSize();
        setSize(sizeScreen.width / 2, sizeScreen.height / 2);
        setLocation(sizeScreen.width / 4, sizeScreen.height / 4);
        setTitle(EnumVariables.TITULO_APP.getValor() + " " + EnumVariables.VERSION_COMPILACION.getValor());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = screen.createImage("src/pildorasinformatica_gemini/icono_gestion.png");
        setIconImage(icono);
        setExtendedState(JFrame.NORMAL); //MAXIMIZED_BOTH);
        setResizable(EnumVariables.VENTANA_REDIMENSIONABLE.getValorBoolean());
        LaminaPrincipal miLamina = new LaminaPrincipal();
        add(miLamina);
    }
    
}

class LaminaPrincipal extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, this.getWidth(), 200);
        g2.setPaint(new Color(0, 102, 204));
        g2.fill(rectangulo);
        
        Ellipse2D elipse = new Ellipse2D.Double(20, 20, 160, 160);
//        elipse.setFrame(rectangulo);
        g2.setPaint(Color.yellow);
        g2.fill(elipse);
        
//        g2.drawRect(50, 50, 300, 200);
        g2.drawString(EnumVariables.TITULO_APP.getValor(), 200, 100);
//        g2.setFont(Font.createFont(Font.BOLD, File.createTempFile(TOOL_TIP_TEXT_KEY, TOOL_TIP_TEXT_KEY)));

    }
}