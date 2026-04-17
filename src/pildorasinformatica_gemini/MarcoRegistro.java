
package pildorasinformatica_gemini;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jose Castillo
 */
public class MarcoRegistro extends JFrame implements WindowFocusListener{
    private LaminaRegistro miLamina;
    private String txtCampoNameBack;
    private String txtCampoIDBack;
    
    public static void main(String[] args) {
        MarcoRegistro miMarco = new MarcoRegistro();
        miMarco.setVisible(true);
    }
    
    public MarcoRegistro(){
        setTitle("Registro de Operadores");
        setBounds(300, 100, 600, 300);        
        
        miLamina = new LaminaRegistro();
        add(miLamina);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowFocusListener(this);
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        setTitle("Sesion Activa");
        miLamina.setBackground(Color.WHITE);
        miLamina.campoNombre.setText(txtCampoNameBack);
        miLamina.campoID.setText(txtCampoIDBack);  
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        setTitle("Bloqueado");
        miLamina.setBackground(Color.ORANGE);
        txtCampoNameBack = miLamina.campoNombre.getText();
        miLamina.campoNombre.setText("");
        txtCampoIDBack = miLamina.campoID.getText();
        miLamina.campoID.setText("");                
    }

    class LaminaRegistro extends JPanel {
        JTextField campoNombre;
        JTextField campoID;
        Font fuente;
        
        public LaminaRegistro(){
            setLayout(null); 
            campoNombre = new JTextField();
            campoNombre.setBounds(57, 80, 80, 20);
            add(campoNombre);
            campoID = new JTextField();
            campoID.setBounds(57, 110, 80, 20);
            fuente = new Font("Arial", Font.BOLD, 10);
            add(campoID);
            oyenteLamina oyente = new oyenteLamina();
            campoNombre.addFocusListener(oyente);
            campoID.addFocusListener(oyente);
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Graphics2D txtNombre = (Graphics2D) g;            
            txtNombre.setFont(fuente);
            g.drawString("Nombre:", 10, 90);            
            
            Graphics2D txtID = (Graphics2D) g;
            txtID.setFont(fuente);
            g.drawString("ID:", 10, 120);        
            
        }
        
        class oyenteLamina implements FocusListener{

            @Override
            public void focusGained(FocusEvent e) {
                JTextField campoRef = (JTextField) e.getSource();
                
                if(campoRef.getBackground() == Color.RED){
                   campoRef.setBackground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField campoRef = (JTextField) e.getSource();
                boolean esValido = isCampo(campoRef);
                
                campoRef.setBackground(esValido ? Color.WHITE : Color.RED);                
            }
            
            public boolean isCampo (JTextField c){
                if(c == campoNombre){
                    return !c.getText().isEmpty();
                }
                
                if(c == campoID){
                    return c.getText().length() == 6;
                }
                return true;
            }
            
        }

    }

}
