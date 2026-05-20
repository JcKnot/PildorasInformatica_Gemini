
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Jose Castillo
 *
 */
public class LaminaContrato extends JPanel{
    private JLabel resumenContrato;
    private JComboBox<String> jboxCargo;
    private ButtonGroup grupoJornada = new ButtonGroup();
    private ButtonGroup grupoUbicacion = new ButtonGroup();
    private static final JLabel TITULO_JORNADA = new JLabel("Jornada: ");
    private static final JLabel TITULO_UBICACION = new JLabel("Ubicación: ");
    private static final JLabel TITULO_CARGO = new JLabel("Cargo: ");
    
    public LaminaContrato(){
        setLayout(new BorderLayout());
        
        JPanel laminaResumen = new JPanel();
        resumenContrato = new JLabel("Contrato: ");
        laminaResumen.add(resumenContrato);
        add(laminaResumen, BorderLayout.SOUTH);
        
        JPanel laminaJornada = new JPanel();
        boolean esPrimeroJornada = true;
        for (String ubi : EnumVariables.JORNADAS.getValorArray()) {
            agregarBotonRadio(ubi, esPrimeroJornada, grupoJornada, laminaJornada);
            esPrimeroJornada = false; 
        }
        
        JPanel laminaUbicacion = new JPanel();
        boolean esPrimero = true;
        for (String ubi : EnumVariables.UBICACIONES.getValorArray()) {
            agregarBotonRadio(ubi, esPrimero, grupoUbicacion, laminaUbicacion);
            esPrimero = false; 
        }
        
        jboxCargo = new JComboBox<>();
        jboxCargo.setEditable(true);
        EventoJBoxCargo eventoCargo = new EventoJBoxCargo();
        jboxCargo.addActionListener(eventoCargo);
        llenarComboBox();
        
        JPanel laminaRadioButton = new JPanel();
        laminaRadioButton.setLayout(new GridLayout(3,2));
        laminaRadioButton.add(TITULO_JORNADA);
        laminaRadioButton.add(laminaJornada);
        laminaRadioButton.add(TITULO_UBICACION);
        laminaRadioButton.add(laminaUbicacion);        
        laminaRadioButton.add(TITULO_CARGO);
        laminaRadioButton.add(jboxCargo);  
        add(laminaRadioButton, BorderLayout.CENTER);
    }
    
    private void llenarComboBox(){
        jboxCargo.addItem("Junior");
        jboxCargo.addItem("Semi-Senior");
        jboxCargo.addItem("Senior");
        jboxCargo.addItem("Arquitecto");
    }
    
    private void agregarBotonRadio(String texto, boolean estado, ButtonGroup grupo, JPanel panel){
        JRadioButton botonRadio =  new JRadioButton (texto, estado);
        botonRadio.setActionCommand(texto);
        botonRadio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizaResumen();
            }            
        });
        grupo.add(botonRadio);
        panel.add(botonRadio);        
    }
    
    private void actualizaResumen(){
        String cargo = String.valueOf(jboxCargo. getSelectedItem());
        String jornada = grupoJornada.getSelection().getActionCommand();
        String ubicacion = grupoUbicacion.getSelection().getActionCommand();
        
        resumenContrato.setText("Contrato: " + cargo + " - " + jornada + " - " + ubicacion);
    }
    
    private class EventoJBoxCargo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            actualizaResumen();
        }
        
    }

}
