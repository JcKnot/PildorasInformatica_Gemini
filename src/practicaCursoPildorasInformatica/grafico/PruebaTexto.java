
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jose Castillo
 * 
 */
public class PruebaTexto {
    
    public static void main(String[] args) {
        MarcoTexto miMarco = new MarcoTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoTexto extends JFrame{
    
    public MarcoTexto(){
        setTitle("Marco Texto");
        setBounds(450, 150, 600, 400);
        LaminaTexto miLamina = new LaminaTexto();
        add(miLamina);
        setVisible(true);
    }
    
}

class LaminaTexto extends JPanel{
    private JTextField campo1;
    private JLabel resultado;
    
    public LaminaTexto(){
//        JTextField campo1 = new JTextField("Texto por defecto",20);
        setLayout(new BorderLayout());
        
        JPanel panelResultado = new JPanel();
        panelResultado.setLayout(new FlowLayout());
        
        JLabel texto1 = new JLabel("Email:");
        panelResultado.add(texto1);
        
        campo1 = new JTextField(20);
        panelResultado.add(campo1);
        
        JButton miBoton = new JButton("Comprobar");        
        DameTexto miEvento = new DameTexto();
        miBoton.addActionListener(miEvento);
        panelResultado.add(miBoton);
        
        resultado = new JLabel("", JLabel.CENTER);
        add(resultado, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.NORTH);
    }
    
    private class DameTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int correcto = 0;
            String email = campo1.getText().trim();
            
            for(int i = 0; i < email.length(); i++ ){
                if(email.charAt(i) == '@'){
                    correcto++;
                }
            }
            
            if(correcto != 1){
                resultado.setText("Incorrecto");
                System.out.println("Incorrecto");
            }else {
                resultado.setText("Correcto");
                System.out.println("Correcto");
            }
            
        }
        
    }
}