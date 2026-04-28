
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 * 
 */
public class MarcoPerfilEmpleado extends JFrame{
    
    public MarcoPerfilEmpleado(){
        setTitle("Perfil Empleado");
        setBounds(300, 300, 600, 300);
        LaminaPerfil miLamina = new LaminaPerfil();
        add(miLamina);
    }
}

