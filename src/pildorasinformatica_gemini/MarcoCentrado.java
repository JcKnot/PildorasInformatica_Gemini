
package pildorasinformatica_gemini;

import java.awt.Dimension;
import java.awt.Toolkit;
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
        setBounds(sizeScreen.width / 2, sizeScreen.height / 2, sizeScreen.width / 4, sizeScreen.height / 4);
        setTitle("Gestión de Personal " + EnumVariables.VERSION_COMPILACION.getValor());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
