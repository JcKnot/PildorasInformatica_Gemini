package practicaCursoPildorasInformatica.grafico;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Jose Castillo
 *
 */
public class CreandoMarcoCentrado {
    public static void main(String[] args) {
        MarcoCentrado marco = new MarcoCentrado();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
}

class MarcoCentrado extends JFrame{
    
    public MarcoCentrado(){
        Toolkit tool = Toolkit.getDefaultToolkit();
        Dimension screen = tool.getScreenSize();
        int alturaScreen = screen.height;
        int anchoScreen = screen.width;
        setSize(anchoScreen / 2, alturaScreen / 2);
        setLocation(anchoScreen / 4, alturaScreen / 4);
        setTitle("MarcoCentrado");
        Image icono = tool.getImage("src/practicaCursoPildorasInformatica/grafico/icono.png");
        setIconImage(icono);

    }
}