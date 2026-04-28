
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jose Castillo
 * 
 */
public class LaminaPerfil extends JPanel{
    private JLabel nombre = new JLabel("Nombre");
    private JLabel sueldo = new JLabel("Sueldo");
    private JLabel Departamento = new JLabel("Departamento");
    private JTextField txtNombre = new JTextField(15);
    private JTextField txtSueldo = new JTextField(15);
    private JTextField txtDepartamento = new JTextField(15);
    private JButton btnActualizar = new JButton("Actualizar");
    private JButton btnCerrar = new JButton("Cerrar");
    
    public LaminaPerfil(){
        setLayout(new BorderLayout());
        
        JPanel panelCabecera = new JPanel();
        panelCabecera.setLayout(new FlowLayout());
        JLabel lbExpediente = new JLabel("Expediente Confidencial");
        panelCabecera.add(lbExpediente);
        
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(3,2));
        llenaPanelCentro(panelCentro);
        
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new FlowLayout());
        panelControles.add(btnActualizar);
        panelControles.add(btnCerrar);
        
        add(panelCabecera, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelControles, BorderLayout.SOUTH);
        
    }
    
    private void llenaPanelCentro(JPanel panel){
        panel.add(nombre);
        panel.add(txtNombre);
        panel.add(sueldo);
        panel.add(txtSueldo);
        panel.add(Departamento);
        panel.add(txtDepartamento);
    }
    
}
