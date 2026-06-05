
package practicaCursoPildorasInformatica.PracticaGuiada;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Jose Castillo
 *
 */
public class ProcesadorTexto {
    
    public static void main(String[] args) {
        MenuProcesadorTexto miMarco =  new MenuProcesadorTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MenuProcesadorTexto extends JFrame{
    
    public MenuProcesadorTexto(){
        setSize(500, 350);
        setLocationRelativeTo(null);
        LaminaProcesador miLamina = new LaminaProcesador();
        add(miLamina);
        setVisible(true);
    }
}

class LaminaProcesador extends JPanel{
    private JTextPane areaTexto;
    private JMenu menuFuente, menuEstilo, menuTamano;
    private Font fuente;
    
    public LaminaProcesador(){
        setLayout(new BorderLayout());
        
        /* Menu */
        JPanel laminaMenu = new JPanel();
        JMenuBar miBarra = new JMenuBar();
        
        menuFuente = new JMenu("Fuente");
        menuEstilo = new JMenu("Estilo");
        menuTamano = new JMenu("Tamaño");
        
        // Item Fuente //
        configuraItemMenu("Arial", menuFuente, "Arial",9,12,"");
        configuraItemMenu("Courier", menuFuente, "Courier",9,12,"");
        configuraItemMenu("Verdana", menuFuente, "Verdana",9,12,"");
        // Item Estilo //
        JCheckBoxMenuItem jMenuNegrita = new JCheckBoxMenuItem("Negrita",new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png"));
        JCheckBoxMenuItem jMenuItalic = new JCheckBoxMenuItem("Cursiva",new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png"));
        jMenuNegrita.addActionListener(new StyledEditorKit.BoldAction());
        jMenuItalic.addActionListener(new StyledEditorKit.ItalicAction());
        menuEstilo.add(jMenuNegrita);
        menuEstilo.add(jMenuItalic);
//        configuraItemMenu("Negrita", menuEstilo, "",Font.BOLD,12,"src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png");
//        configuraItemMenu("Cursiva", menuEstilo, "",Font.ITALIC,12,"src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_ital_32px.png");
        // Item Tamaño //
        ButtonGroup grupoMenu = new ButtonGroup();
        
        JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem dieci = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem veintiCuatro = new JRadioButtonMenuItem("24");
        
        doce.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 12));
        dieci.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 16));
        veinte.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 20));
        veintiCuatro.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 24));
        
        grupoMenu.add(doce);
        grupoMenu.add(dieci);
        grupoMenu.add(veinte);
        grupoMenu.add(veintiCuatro);
        
        menuTamano.add(doce);
        menuTamano.add(dieci);
        menuTamano.add(veinte);
        menuTamano.add(veintiCuatro);
        
//        configuraItemMenu("12", menuTamano, "",9,12,"");
//        configuraItemMenu("16", menuTamano, "",9,16,"");
//        configuraItemMenu("20", menuTamano, "",9,20,"");
//        configuraItemMenu("24", menuTamano, "",9,24,"");
        
        miBarra.add(menuFuente);
        miBarra.add(menuEstilo);
        miBarra.add(menuTamano);
        
        laminaMenu.add(miBarra);
        add(laminaMenu, BorderLayout.NORTH);
        
        // Area de Texto //
        areaTexto = new JTextPane();
        add(areaTexto, BorderLayout.CENTER);
    }
    
    private void configuraItemMenu(String rotulo, JMenu menu, String tipo, int stilo, int tamano, String ruta){
        JMenuItem itemMenu = new JMenuItem(rotulo, new ImageIcon(ruta));
        menu.add(itemMenu);
        
        if(menu == menuTamano){
            itemMenu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", tamano));
        }else if(menu == menuEstilo){
            if(stilo == Font.BOLD){itemMenu.addActionListener(new StyledEditorKit.BoldAction());}
            if(stilo == Font.ITALIC){itemMenu.addActionListener(new StyledEditorKit.ItalicAction());}
        }else if(menu == menuFuente){
            itemMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Tipo", tipo));
        }
        
        
    }
    
//    private void configuraItemMenu(String rotulo, JMenu menu, String tipo, int stilo, int tamano){
//        JMenuItem itemMenu = new JMenuItem(rotulo);
//        menu.add(itemMenu);
//                
//        itemMenu.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fuente = areaTexto.getFont();
//                if(menu == menuFuente){
//                    areaTexto.setFont(new Font(tipo, fuente.getStyle(), fuente.getSize()));
//                }else if(menu == menuEstilo){
//                    
//                    areaTexto.setFont(new Font(fuente.getName(), stilo, fuente.getSize()));            
//                }else if(menu == menuTamano){
//                    areaTexto.setFont(new Font(fuente.getName(), fuente.getStyle(), tamano));
//                }                 
//            }
//        });
//    }
    
    
    
}