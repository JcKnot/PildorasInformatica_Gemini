
package pildorasinformatica_gemini;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
//import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
    private Image imageUser;
    private Image imageFondo;
    
    public LaminaPrincipal(){
        try{
            imageUser = ImageIO.read(new File(EnumVariables.IMAGEN_USUARIO.getValor()));
            imageFondo = ImageIO.read(new File(EnumVariables.FONDO_CABECERA.getValor()));
        }catch(IOException e){
            System.out.println("Imagen no encontrada");
        }
    }    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, this.getWidth(), 200);
        g2.setPaint(new Color(0, 102, 204));
        g2.fill(rectangulo);

//        Ellipse2D elipse = new Ellipse2D.Double(20, 20, 160, 160);
////        elipse.setFrame(rectangulo);
//        g2.setPaint(Color.WHITE);
//        g2.fill(elipse);
        
        g2.drawImage(imageFondo, 0, 0, this);
        int recAncho = (int)rectangulo.getWidth();
        int recAlto = (int)rectangulo.getHeight();
        int width = imageFondo.getWidth(this);
        int height = imageFondo.getHeight(this);
        
        for(int i = 0; i < recAncho; i++){
            for(int j = 0; j < recAlto; j+=height){
                g2.copyArea(0, 0, width, height, width*i, j);  
            }
        }
        
        g2.drawImage(imageUser, 20, 20, 150, 150, this);        
        
        Font fuente = new Font("Arial", Font.BOLD, 26);
        g2.setFont(fuente);
        g2.setColor(Color.WHITE);
        int h = (int) rectangulo.getHeight() / 2;
        g2.drawString(EnumVariables.TITULO_APP.getValor(), 200,  h );

    }
}