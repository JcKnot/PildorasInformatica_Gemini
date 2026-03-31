package practicaCursoPildorasInformatica.grafico;

import java.awt.GraphicsEnvironment;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Castillo
 *
 */
public class Pruebass {
    
    public static void main(String[] args) {
        String fuente = JOptionPane.showInputDialog("Ingrese la fuente");
        boolean existe = false;
        String[] nombresDeFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        
        for(String nombreFuente : nombresDeFuentes){
            if(nombreFuente.equals(fuente)){
                existe = true;
            }
        }
        
        if(existe){
            System.out.println("Fuente instalada");
        }else {
            System.out.println("No esta instalada la fuente");
        }
    }

}
