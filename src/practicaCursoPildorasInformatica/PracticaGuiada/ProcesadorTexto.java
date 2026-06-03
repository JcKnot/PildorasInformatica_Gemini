
package practicaCursoPildorasInformatica.PracticaGuiada;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
        configuraItemMenu("Arial", menuFuente, "Arial",9,12);
        configuraItemMenu("Courier", menuFuente, "Courier",9,12);
        configuraItemMenu("Verdana", menuFuente, "Verdana",9,12);
        // Item Estilo //
        configuraItemMenu("Negrita", menuEstilo, "",Font.BOLD,12);
        configuraItemMenu("Cursiva", menuEstilo, "",Font.ITALIC,12);
        // Item Tamaño //
        configuraItemMenu("12", menuTamano, "",9,12);
        configuraItemMenu("16", menuTamano, "",9,16);
        configuraItemMenu("20", menuTamano, "",9,20);
        configuraItemMenu("24", menuTamano, "",9,24);
        
        miBarra.add(menuFuente);
        miBarra.add(menuEstilo);
        miBarra.add(menuTamano);
        
        laminaMenu.add(miBarra);
        add(laminaMenu, BorderLayout.NORTH);
        
        // Area de Texto //
        areaTexto = new JTextPane();
        add(areaTexto, BorderLayout.CENTER);
    }
    
    private void configuraItemMenu(String rotulo, JMenu menu, String tipo, int stilo, int tamano){
        JMenuItem itemMenu = new JMenuItem(rotulo);
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