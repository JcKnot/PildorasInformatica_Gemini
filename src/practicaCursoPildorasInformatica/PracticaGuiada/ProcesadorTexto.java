
package practicaCursoPildorasInformatica.PracticaGuiada;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
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
        setSize(800, 460);
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
    private JButton btnNegrita, btnCursiva, btnUnderline, btnAzul,
            btnAmarillo, btnRojo, btnIzq, btnDer, btnCentro, btnJust;
    private JToolBar barra;
    
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
//        JCheckBoxMenuItem jMenuNegrita = new JCheckBoxMenuItem("Negrita",new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png"));
//        JCheckBoxMenuItem jMenuItalic = new JCheckBoxMenuItem("Cursiva",new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png"));
//        jMenuNegrita.addActionListener(new StyledEditorKit.BoldAction());
//        jMenuItalic.addActionListener(new StyledEditorKit.ItalicAction());
//        menuEstilo.add(jMenuNegrita);
//        menuEstilo.add(jMenuItalic);
        configuraItemMenu("Negrita", menuEstilo, "",Font.BOLD,12,"src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png");
        configuraItemMenu("Cursiva", menuEstilo, "",Font.ITALIC,12,"src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_ital_32px.png");
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
        
        veintiCuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        
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
        
        JPopupMenu emergente = new JPopupMenu();
        JMenuItem negritaE = new JMenuItem("Negrita");
        JMenuItem cursivaE = new JMenuItem("Cursiva");
        negritaE.addActionListener(new StyledEditorKit.BoldAction());
        cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
        emergente.add(negritaE);
        emergente.add(cursivaE);
        areaTexto.setComponentPopupMenu(emergente);
        
        //--------------------------------------------------------------------//
        // Barra de herramienta
        /*
        JToolBar barra = new JToolBar();
        //Estilo
        JButton btnNegrita = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png"));
        btnNegrita.addActionListener(new StyledEditorKit.BoldAction());
        JButton btnCursiva = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_ital_32px.png"));
        btnCursiva.addActionListener(new StyledEditorKit.ItalicAction());
        JButton btnUnderline = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Under.png"));
        btnUnderline.addActionListener(new StyledEditorKit.UnderlineAction());
        //Color
        JButton btnAzul = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/IconoAzul.png"));
        btnAzul.addActionListener(new StyledEditorKit.ForegroundAction("Azul", Color.BLUE));
        JButton btnAmarillo = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/IconoAmarillo.png"));
        btnAmarillo.addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));
        JButton btnRojo = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/IconoRojo.png"));
        btnRojo.addActionListener(new StyledEditorKit.ForegroundAction("Rojo", Color.RED));
        //Alineacion
        JButton btnIzq = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/alineacion-izquierda.png"));
        btnIzq.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
        JButton btnDer = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/alineacion-derecha.png"));
        btnDer.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 2));
        JButton btnCentro = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/alineacion-centro.png"));
        btnCentro.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 1));
        JButton btnJust = new JButton(new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/justificar.png"));
        btnJust.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 3));
        
        barra.add(btnNegrita);
        barra.add(btnCursiva);
        barra.add(btnUnderline);
        barra.add(btnAzul);
        barra.add(btnAmarillo);
        barra.add(btnRojo);
        barra.add(btnIzq);
        barra.add(btnDer);
        barra.add(btnCentro);
        barra.add(btnJust);
        */
        barra = new JToolBar();
        //Estilo
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Bold_32px.png").addActionListener(new StyledEditorKit.BoldAction());
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_ital_32px.png").addActionListener(new StyledEditorKit.ItalicAction());
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/Icono_Under.png").addActionListener(new StyledEditorKit.UnderlineAction());
        barra.addSeparator();
        //Color
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/IconoAzul.png").addActionListener(new StyledEditorKit.ForegroundAction("Azul", Color.BLUE));
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/IconoAmarillo.png").addActionListener(new StyledEditorKit.ForegroundAction("Amarillo", Color.YELLOW));
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/IconoRojo.png").addActionListener(new StyledEditorKit.ForegroundAction("Rojo", Color.RED));
        barra.addSeparator();
        //Alineacion
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/alineacion-izquierda.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/alineacion-derecha.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 2));
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/alineacion-centro.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 1));
        configuraBarra("src/practicaCursoPildorasInformatica/PracticaGuiada/justificar.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 3));
        barra.setOrientation(1);
        add(barra, BorderLayout.WEST);
    }
    
    public JButton configuraBarra(String ruta){
        JButton btn = new JButton(new ImageIcon(ruta));
        barra.add(btn);
        return btn;
    }
    
    private void configuraItemMenu(String rotulo, JMenu menu, String tipo, int stilo, int tamano, String ruta){
        JMenuItem itemMenu = new JMenuItem(rotulo, new ImageIcon(ruta));
        menu.add(itemMenu);
        
        if(menu == menuTamano){
            itemMenu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", tamano));
        }else if(menu == menuEstilo){
            if(stilo == Font.BOLD){
                itemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                itemMenu.addActionListener(new StyledEditorKit.BoldAction());
            }
            if(stilo == Font.ITALIC){
                itemMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                itemMenu.addActionListener(new StyledEditorKit.ItalicAction());
            }
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