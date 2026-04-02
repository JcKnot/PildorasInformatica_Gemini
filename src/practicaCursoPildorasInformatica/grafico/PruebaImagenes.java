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
        LaminaImagen miLamina = new LaminaImagen();
        setBounds(750,400,300,200);
        add(miLamina);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class LaminaImagen extends JPanel{
    private Image imagen;
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        File miImagen = new File("src/practicaCursoPildorasInformatica/grafico/icono.png");
        try{
        imagen = ImageIO.read(miImagen);}
        catch(IOException e){
            System.out.println("Error: Imagen no encontrada");
        }
        g.drawImage(imagen, 0, 0, null);
        
        for(int i = 0; i<300; i++){
            for(int j = 0; j <200; j++){
                g.copyArea(0, 0, imagen.getWidth(this), imagen.getHeight(this),imagen.getWidth(this)* i, imagen.getHeight(this)* j);
            }
        }
        
    }
}