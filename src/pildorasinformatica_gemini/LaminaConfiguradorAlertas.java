
package pildorasinformatica_gemini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author "Jose Castillo"
 *
 */
public class LaminaConfiguradorAlertas extends JPanel {
    private ButtonGroup grupoMensaje = new ButtonGroup();
    private ButtonGroup grupoOpcion = new ButtonGroup();
    private JLabel lbInformacion = new JLabel("El administrador a pulsado: ");
    
    public LaminaConfiguradorAlertas(){
        
        Box boxTipoMensaje = Box.createHorizontalBox();
        pintaBorderNonbre("Tipo de Mensaje", boxTipoMensaje);
        Box boxOpcion = Box.createHorizontalBox();
        pintaBorderNonbre("Opciones de Confirmación", boxOpcion);
        Box boxBotones = Box.createHorizontalBox();
        Box box = Box.createVerticalBox();
        
        llenaRadioButton(grupoMensaje,"Error",true,String.valueOf(JOptionPane.ERROR_MESSAGE));
        llenaRadioButton(grupoMensaje,"Información",false,String.valueOf(JOptionPane.INFORMATION_MESSAGE));
        llenaRadioButton(grupoMensaje,"Advertencia",false,String.valueOf(JOptionPane.WARNING_MESSAGE));
        llenaRadioButton(grupoMensaje,"Pregunta",false,String.valueOf(JOptionPane.QUESTION_MESSAGE));
        
        Enumeration<AbstractButton> listaMensaje =  grupoMensaje.getElements();
        while(listaMensaje.hasMoreElements()){
            boxTipoMensaje.add(listaMensaje.nextElement());
        }
        
        boxTipoMensaje.add(Box.createVerticalStrut(50));
        
        llenaRadioButton(grupoOpcion, "Aceptar", true,String.valueOf(JOptionPane.DEFAULT_OPTION));
        llenaRadioButton(grupoOpcion, "Sí/No", false,String.valueOf(JOptionPane.YES_NO_OPTION));
        llenaRadioButton(grupoOpcion, "Sí/No/Cancelar", false,String.valueOf(JOptionPane.YES_NO_CANCEL_OPTION));
        llenaRadioButton(grupoOpcion, "Aceptar/Cancelar", false,String.valueOf(JOptionPane.OK_CANCEL_OPTION));
        
        Enumeration<AbstractButton> listaOpciones =  grupoOpcion.getElements();
        while(listaOpciones.hasMoreElements()){
            boxOpcion.add(listaOpciones.nextElement());
        }
        
        boxOpcion.add(Box.createVerticalStrut(50));
        
        JButton btnEjecutar = new JButton("Lanzar Alerta"); 
        btnEjecutar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                lanzaMensaje();
            }
            
        });
        boxBotones.add(btnEjecutar);
                
        box.add(boxTipoMensaje);
        box.add(boxOpcion);
        box.add(Box.createGlue());
        box.add(Box.createVerticalStrut(30));
        box.add(boxBotones);
        box.add(lbInformacion);
        add(box);
        
    }
    
    private void llenaRadioButton(ButtonGroup grupo, String nombre, boolean estado, String command){
        
        JRadioButton radioButton = new JRadioButton(nombre, estado);
        radioButton.setActionCommand(command);
        grupo.add(radioButton);        
        
    }
    
    private void pintaBorderNonbre(String title, Box namedBox ) {
        Border lineBorder = BorderFactory.createLineBorder(Color.GRAY, 1, true);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                lineBorder, 
                title, 
                TitledBorder.LEFT, 
                TitledBorder.TOP, 
                new Font("Arial", Font.BOLD, 12), 
                Color.BLUE
        );

        Border marginBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        
        Border finalBorder = BorderFactory.createCompoundBorder(titledBorder, marginBorder);

        namedBox.setBorder(finalBorder);
    }
    
    private void lanzaMensaje(){
        int msj = Integer.parseInt(grupoMensaje.getSelection().getActionCommand());
        int opt = Integer.parseInt(grupoOpcion.getSelection().getActionCommand());
        String titulo = grupoMensaje.getSelection().getClass().getName();
        
        int confirmacion = JOptionPane.showConfirmDialog(this, "Alerta", titulo, opt, msj);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            lbInformacion.setText("El administrador a pulsado: YES");
        } else if (confirmacion == JOptionPane.NO_OPTION) {
            lbInformacion.setText("El administrador a pulsado: NO");
        } else if (confirmacion == JOptionPane.CANCEL_OPTION) {
            lbInformacion.setText("El administrador a pulsado: CANCEL");
        } else if (confirmacion == JOptionPane.CLOSED_OPTION) {
            lbInformacion.setText("El diálogo fue cerrado por la X");
        }
                
    }

}
