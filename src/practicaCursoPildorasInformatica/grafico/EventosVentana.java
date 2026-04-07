package practicaCursoPildorasInformatica.grafico;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 *
 */
public class EventosVentana {
    
    public static void main(String[] args) {
        
        MarcoVentana miMarco = new MarcoVentana();
        miMarco.setTitle("Ventana1");
        miMarco.setBounds(300, 300, 500, 350);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MarcoVentana miMarco2 = new MarcoVentana();
        miMarco2.setTitle("Ventana2");
        miMarco.setBounds(900, 300, 500, 350);
        miMarco2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }

}

class MarcoVentana extends JFrame {
    
    public MarcoVentana() {
//        setTitle("Respondiendo");
//        setBounds(300, 300, 500, 350);
        setVisible(true);
        
        Mventana oyenteVentana = new Mventana();
        addWindowListener(oyenteVentana);
    }
}

class Mventana extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Cerrando Ventana");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Ventana Minimizada");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ventana Activa");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Ventana desactivada");
    }
    
}

class LaminaVentana extends JPanel {
    
    public LaminaVentana (){
        
    }
}
