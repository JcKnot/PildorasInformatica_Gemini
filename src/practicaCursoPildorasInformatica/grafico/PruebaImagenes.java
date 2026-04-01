package practicaCursoPildorasInformatica.grafico;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
    private Image imagen;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        File miImagen = new File("src/practicaCursoPildorasInformatica/grafico/image.jpg");
        try{
        imagen = ImageIO.read(miImagen);}
        catch(IOException e){
            System.out.println("Error: Imagen no encontrada");
        }
        g.drawImage(imagen, 5, 5, null);
    }
}