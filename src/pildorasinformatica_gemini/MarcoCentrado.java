
package pildorasinformatica_gemini;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.JFrame;

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
    }
    
}
