
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Jose Castillo
 * 
 */
public class CampoPassword {
    
    public static void main(String[] args) {
        
        MarcoPassword miMarco = new MarcoPassword();
        miMarco.setVisible(true);
    }
    
}

class MarcoPassword extends JFrame{
    
    public MarcoPassword(){
        setTitle("Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 600, 400);
        
        LaminaPassword miLamina = new LaminaPassword();
        add(miLamina);
    }
}

class LaminaPassword extends JPanel{
    private JPasswordField txtPassword;
    
    public LaminaPassword(){
        setLayout(new BorderLayout());
        
        JPanel laminaSuperior = new JPanel();
        laminaSuperior.setLayout(new GridLayout(2,2));
        
        JLabel etiqueta1 = new JLabel("Usuario");
        JLabel etiqueta2 = new JLabel("Contraseña");
        JTextField txtUsuario = new JTextField(15);
        txtPassword = new JPasswordField(15);
        
        CompruebaPassword evento = new CompruebaPassword();
        txtPassword.getDocument().addDocumentListener(evento);
        
        laminaSuperior.add(etiqueta1);
        laminaSuperior.add(txtUsuario);
        laminaSuperior.add(etiqueta2);
        laminaSuperior.add(txtPassword);
        
        add(laminaSuperior, BorderLayout.NORTH);
        
        JButton boton = new JButton("Enviar");
        add(boton, BorderLayout.SOUTH);
        
    }
    
    private class CompruebaPassword implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            char[] contrasena;
            contrasena = txtPassword.getPassword();
            
            if(contrasena.length < 8 || contrasena.length > 12){
                txtPassword.setBackground(Color.red);
            }else {
                txtPassword.setBackground(Color.white);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            char[] contrasena;
            contrasena = txtPassword.getPassword();
            
            if(contrasena.length < 8 || contrasena.length > 12){
                txtPassword.setBackground(Color.red);
            }else {
                txtPassword.setBackground(Color.white);
            }            
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        
    }
}
