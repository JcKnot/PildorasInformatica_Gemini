
package pildorasinformatica_gemini;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoEditor extends JFrame{
    private JMenuBar barraMenu;
    private LaminaEditor lamina;
    private JMenu menuFuente, menuEstilo, tipografias;
    private ButtonGroup grupoMenu = new ButtonGroup();
    
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
        tipografias = new JMenu("Tipografías");
        
        // Item Fuente //
        configuraItemMenu("Arial", tipografias, "Arial",9,12, true);
        configuraItemMenu("Courier", tipografias, "Courier",9,12, false);
        configuraItemMenu("Verdana", tipografias, "Verdana",9,12, false);
//        grupoMenu.setSelected(grupoMenu.getElements().nextElement().getModel(), true);
        menuFuente.add(tipografias);
        menuFuente.addSeparator();
        // Item Estilo //
        configuraItemMenu("Negrita", menuEstilo, "",Font.BOLD,12, false);
        configuraItemMenu("Cursiva", menuEstilo, "",Font.ITALIC,12, false);
        
        barraMenu.add(menuFuente);
        barraMenu.add(menuEstilo);
        
        
        add(lamina);
        
    }
    
    private void configuraItemMenu(String rotulo, JMenu menu, String tipo, int stilo, int tamano, boolean isSelected){
        JRadioButtonMenuItem itemMenu;
        JCheckBoxMenuItem checkBoxMenu;        
        
        if(menu == menuEstilo){
            checkBoxMenu = new JCheckBoxMenuItem(rotulo);
            if(stilo == Font.BOLD){checkBoxMenu.addActionListener(new StyledEditorKit.BoldAction());}
            if(stilo == Font.ITALIC){checkBoxMenu.addActionListener(new StyledEditorKit.ItalicAction());}
            menu.add(checkBoxMenu);
        }else if(menu == tipografias){
            itemMenu = new JRadioButtonMenuItem(rotulo);
            grupoMenu.add(itemMenu);
            itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Tipo", tipo));
            itemMenu.setSelected(isSelected);
            menu.add(itemMenu);
        }
        
        
    }

}
