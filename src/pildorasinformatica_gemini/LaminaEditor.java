
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Jose Castillo
 *
 */
public class LaminaEditor extends JPanel{
    private JTextPane jTextPane;
    
    public LaminaEditor(){
        setLayout(new BorderLayout());
        jTextPane = new JTextPane();
        JScrollPane scrolPane = new JScrollPane(jTextPane);
        add(scrolPane, BorderLayout.CENTER);
        
        
    }

}
