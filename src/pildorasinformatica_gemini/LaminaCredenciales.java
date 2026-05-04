
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;
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
public class LaminaCredenciales extends JPanel{
    private JPanel grid;
    private JPanel pnlTitulo;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JPasswordField txtConfPassword;
    private JLabel jbMensaje = new JLabel("");
    
    public LaminaCredenciales(){
        setLayout(new BorderLayout());
        add(jbMensaje, BorderLayout.SOUTH);
        
        pnlTitulo = new JPanel();
        pnlTitulo.setLayout(new FlowLayout());
        JLabel jbTitulo = new JLabel("Terminal Credenciales");
        jbTitulo.setSize(500, 500);
        pnlTitulo.add(jbTitulo);
        add(pnlTitulo, BorderLayout.NORTH);
        
        grid = new JPanel();
        grid.setLayout(new GridLayout(3,2));
        add(grid, BorderLayout.CENTER);
        
        JLabel lbEmail = new JLabel("Emal:");
        txtEmail = new JTextField(15);
        JLabel lbPassword = new JLabel("Password:");
        txtPassword = new JPasswordField(15);
        JLabel lbPasswordConfirmar = new JLabel("Confirmar Password:");
        txtConfPassword = new JPasswordField(15);
        
        CompruebaEmail compruebaEmail = new CompruebaEmail();
        txtEmail.getDocument().addDocumentListener(compruebaEmail);
        
        CompruebaPassword compruebaPassword = new CompruebaPassword();
        txtPassword.getDocument().addDocumentListener(compruebaPassword);
        txtConfPassword.getDocument().addDocumentListener(compruebaPassword);
                
        grid.add(lbEmail);
        grid.add(txtEmail);
        grid.add(lbPassword);
        grid.add(txtPassword);
        grid.add(lbPasswordConfirmar);
        grid.add(txtConfPassword);                
    }
    
    private class CompruebaEmail implements DocumentListener{
        @Override
        public void insertUpdate(DocumentEvent e) {
            if(validaEmail(txtEmail.getText())){
                txtEmail.setBackground(Color.GREEN);
            }else {
                txtEmail.setBackground(Color.red);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            if(validaEmail(txtEmail.getText())){
                txtEmail.setBackground(Color.GREEN);
            }else {
                txtEmail.setBackground(Color.red);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        
        private boolean validaEmail(String email){
            if(email.endsWith("@corporativo.com")){
                return true;
            }else {
                return false;
            }
        }
    }
    
    private class CompruebaPassword implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            char[] pass1 = txtPassword. getPassword();
            char[] pass2 = txtConfPassword. getPassword();
                        
            if(validaPassword(pass1, pass2)){
                jbMensaje.setForeground(Color.GREEN);
                jbMensaje.setText("Credenciales Válidas");
            }else {
                jbMensaje.setForeground(Color.RED);
                jbMensaje.setText("Error de seguridad");            
            }
            
            Arrays.fill(pass1, 'a');
            Arrays.fill(pass2, 'a');            
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            char[] pass1 = txtPassword. getPassword();
            char[] pass2 = txtConfPassword. getPassword();
                        
            if(validaPassword(pass1, pass2)){
                jbMensaje.setForeground(Color.GREEN);
                jbMensaje.setText("Credenciales Válidas");
            }else {
                jbMensaje.setForeground(Color.RED);
                jbMensaje.setText("Error de seguridad");            
            }
            
            Arrays.fill(pass1, 'a');
            Arrays.fill(pass2, 'a');           
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        
        private boolean validaPassword(char[] pass1, char[] pass2){
            if(pass1.length >= 8 && Arrays.equals(pass1, pass2)){
                return true;
            }else {
                return false;
            }
        }
        
    }

}
