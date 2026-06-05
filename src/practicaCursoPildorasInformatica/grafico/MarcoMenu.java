
package practicaCursoPildorasInformatica.grafico;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jose Castillo
 *
 */
public class MarcoMenu {
    
    public static void main(String[] args) {
        MenuFrame miMarco = new MenuFrame();
        miMarco.setVisible(true);
    }

}

class MenuFrame extends JFrame{
    
    public MenuFrame(){
        setBounds(500, 300, 500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MenuLamina miLamina = new MenuLamina();
        add(miLamina);
    }
}

class MenuLamina extends JPanel{
    
    public MenuLamina(){
        JMenuBar miMenu = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuEdicion = new JMenu("Edicion");
        JMenu menuHerramientas = new JMenu("Herramientas");
        JMenu menuOpciones = new JMenu("Opciones");
        
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemGuardarComo = new JMenuItem("Guardar Como");
        
        JMenuItem itemCopiar = new JMenuItem("Copiar", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboard-inventory.png"));
        itemCopiar.setHorizontalTextPosition(SwingConstants.LEFT);
        JMenuItem itemCortar = new JMenuItem("Cortar", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboard-tasks.png"));
        JMenuItem itemPegar = new JMenuItem("Pegar", new ImageIcon("src/practicaCursoPildorasInformatica/grafico/clipboardplan.png"));
        
        JMenuItem itemGenerales = new JMenuItem("Generales");
        JMenuItem itemOpcion1 = new JMenuItem("Opcion 1");
        JMenuItem itemOpcion2 = new JMenuItem("Opcion 1");
        
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemGuardarComo);
        menuEdicion.add(itemCortar);
        menuEdicion.add(itemCopiar);
        menuEdicion.add(itemPegar);
        menuEdicion.addSeparator();
        menuHerramientas.add(itemGenerales);
        menuOpciones.add(itemOpcion1);
        menuOpciones.add(itemOpcion2);
        
        menuEdicion.add(menuOpciones);
        
        miMenu.add(menuArchivo);
        miMenu.add(menuEdicion);
        miMenu.add(menuHerramientas);
        
        add(miMenu);
    }
}