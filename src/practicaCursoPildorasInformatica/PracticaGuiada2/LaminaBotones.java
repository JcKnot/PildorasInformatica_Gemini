
package practicaCursoPildorasInformatica.PracticaGuiada2;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author jcastillo
 */
public class LaminaBotones extends JPanel {
    private ButtonGroup grupo;
    
    public LaminaBotones(String titulo, String[] opciones){
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        grupo = new ButtonGroup();
        
        for(int i = 0; i < opciones.length; i++){
            JRadioButton bot = new JRadioButton(opciones[i]);
            bot.setActionCommand(opciones[i]);
            bot.setSelected(i == 0);
            add(bot);
            grupo.add(bot);            
        }
    }
    
    public String dameSeleccion(){
        return grupo.getSelection().getActionCommand();
    }
    
}
