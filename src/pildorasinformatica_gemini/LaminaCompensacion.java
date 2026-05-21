
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Jose Castillo
 *
 */
public class LaminaCompensacion extends JPanel {
    private JSlider jsAnosExperiencia;
    private JSpinner jsAjusteSalarial;
    private static final Font TITULO_VENTANA = new Font("Serif", Font.BOLD, 18);
    private static final Font TITULO_COMPONENTE = new Font("Serif", Font.PLAIN, 12);
    private final JLabel lbTitulo = new JLabel("Compensación y Antigüedad"); 
    private final JLabel lbAnosExp = new JLabel("Años Experiencia: ");
    private final JLabel lbAjusteSalarial = new JLabel("Ajuste Salarial: ");
    private JLabel etiqueta;
    private String txtCategoria, txtAnos, txtAjusSalario;
    
    public LaminaCompensacion(){
        setLayout(new BorderLayout());
        JPanel jpTitulo = new JPanel();
        lbTitulo.setFont(TITULO_VENTANA);
        jpTitulo.add(lbTitulo);
        add(jpTitulo, BorderLayout.NORTH);
        
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(2,2));
        
        creaSliderAnosExperiencia();
        creaSpinnerAjusteSalarial();
        lbAnosExp.setFont(TITULO_COMPONENTE);
        lbAjusteSalarial.setFont(TITULO_COMPONENTE);
        panelCentro.add(lbAnosExp);
        panelCentro.add(jsAnosExperiencia);
        panelCentro.add(lbAjusteSalarial);
        panelCentro.add(jsAjusteSalarial);
        add(panelCentro, BorderLayout.CENTER);
                
        etiqueta = new JLabel("");
        actualizaEtiqueta();
        add(etiqueta, BorderLayout.SOUTH);
    }
    
    public void creaSliderAnosExperiencia(){
        jsAnosExperiencia = new JSlider(0, 40, 5);
        jsAnosExperiencia.setMinorTickSpacing(1);
        jsAnosExperiencia.setMajorTickSpacing(10);
        jsAnosExperiencia.setPaintTicks(true);
        jsAnosExperiencia.setPaintLabels(true);
        jsAnosExperiencia.setSnapToTicks(true);
        jsAnosExperiencia.setFont(TITULO_COMPONENTE);
        jsAnosExperiencia.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizaEtiqueta();
            }
        });
    }
    
    public void creaSpinnerAjusteSalarial(){
        jsAjusteSalarial = new JSpinner(new SpinnerNumberModel(10, 0, 50, 5));
        jsAjusteSalarial.setPreferredSize(new Dimension(40, 10));
        jsAjusteSalarial.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                actualizaEtiqueta();
            }            
        });
    }
    
    public void actualizaEtiqueta(){
        txtCategoria = calculaCategoria();
        txtAnos = String.valueOf(jsAnosExperiencia.getValue());
        txtAjusSalario = String.valueOf(jsAjusteSalarial.getValue());
        etiqueta.setText("Ajuste Salarial: "+ txtAjusSalario +"% | Nivel: "+ txtCategoria +" ("+ txtAnos +" años de antigüedad)");
    }
    
    public String calculaCategoria(){
        int valor = jsAnosExperiencia.getValue();
        
        if(valor >= 0 && valor <= 2){
            return "Trainee";
        }else if(valor >= 3 && valor <= 5){
            return "Asociado";
        }else if(valor >= 6 && valor <= 15){
            return "Especialista";
        }else if(valor >= 16 && valor <= 40){
            return "Senior Legend";
        }else {
            return "";
        }
    }

}
