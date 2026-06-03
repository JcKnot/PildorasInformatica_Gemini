
package pildorasinformatica_gemini;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoEditor extends JFrame{
    private JMenuBar barraMenu;
    private LaminaEditor lamina;
    private JMenu menuFuente, menuEstilo;
    
    public MarcoEditor(){
        setTitle("Editor de Borradores Corporativos");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lamina = new LaminaEditor();
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        
        menuFuente = new JMenu("Fuente");
        menuEstilo = new JMenu("Estilo");
        
        // Item Fuente //
        configuraItemMenu("Arial", menuFuente, "Arial",9,12);
        configuraItemMenu("Courier", menuFuente, "Courier",9,12);
        configuraItemMenu("Verdana", menuFuente, "Verdana",9,12);
        // Item Estilo //
        configuraItemMenu("Negrita", menuEstilo, "",Font.BOLD,12);
        configuraItemMenu("Cursiva", menuEstilo, "",Font.ITALIC,12);
        
        barraMenu.add(menuFuente);
        barraMenu.add(menuEstilo);
        
        add(lamina);
        
    }
    
    private void configuraItemMenu(String rotulo, JMenu menu, String tipo, int stilo, int tamano){
        JMenuItem itemMenu = new JMenuItem(rotulo);
        menu.add(itemMenu);
        
        if(menu == menuEstilo){
            if(stilo == Font.BOLD){itemMenu.addActionListener(new StyledEditorKit.BoldAction());}
            if(stilo == Font.ITALIC){itemMenu.addActionListener(new StyledEditorKit.ItalicAction());}
        }else if(menu == menuFuente){
            itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Tipo", tipo));
        }
        
        
    }

}
