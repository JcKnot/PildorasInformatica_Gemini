
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
    
    public LaminaCredenciales(){
        setLayout(new BorderLayout());
        
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
            if(validaEmail(txtEmail.getText().endsWith("@corporativo.com"))){
                txtEmail.setBackground(Color.GREEN);
            }else {
                txtEmail.setBackground(Color.red);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
                       
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
