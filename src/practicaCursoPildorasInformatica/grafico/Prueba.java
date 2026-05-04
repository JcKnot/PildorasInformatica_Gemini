
package practicaCursoPildorasInformatica.grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author Jose Castillo
 * 
 */
public class Prueba {
   
    public static void main(String[] args) {
        
        MarcoPrueba miMarco = new MarcoPrueba();        
        miMarco.setVisible(true);                
    }
}

class MarcoPrueba extends JFrame{
    
    public MarcoPrueba(){
        setTitle("Marco Documento");
        setBounds(450, 250, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaPrueba miLamina = new LaminaPrueba();
        add(miLamina);
    }
}

class LaminaPrueba extends JPanel{
    
    public LaminaPrueba(){
        JTextField miCampo = new JTextField(20);        
        EscuchaTexto escucha = new EscuchaTexto();
        Document miDocument = miCampo.getDocument();
        miDocument.addDocumentListener(escucha);        
        
        add(miCampo);
    }
    
    private class EscuchaTexto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("Has insertado Texto");
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("Eliminaste Texto");
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        
    }
}
