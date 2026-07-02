
package practicaCursoPildorasInformatica.grafico;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jose Castillo
 *
 */
public class LibreDisposicion {
    
    public static void main(String[] args) {
        MarcoLibre miMarco = new MarcoLibre();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoLibre extends JFrame{
    
    public MarcoLibre(){
        setBounds(450, 350, 600, 400);
        LaminaLibre miLamina = new LaminaLibre();
        add(miLamina);
        setVisible(true);
    }
}

class LaminaLibre extends JPanel{
    
    public LaminaLibre(){
        //setLayout(null);
        setLayout(new EnColumnas());        
//        JButton boton1 = new JButton("Boton 1");
//        boton1.setBounds(50, 50, 120, 25);
//        add(boton1);
//        
//        JButton boton2 = new JButton("Boton 2");
//        boton2.setBounds(50, 90, 120, 25);
//        add(boton2);
        JLabel nombre = new JLabel("Nombre: ");
        JLabel apellido = new JLabel("Apellido: ");
        JLabel edad = new JLabel("Edad: ");
        JLabel tlf = new JLabel("Telefono: ");
        JTextField cNombre = new JTextField();
        JTextField cApellido = new JTextField();
        JTextField cEdad = new JTextField();        
        JTextField cTlf = new JTextField();
        /*
        nombre.setBounds(20, 20, 80, 10);
        cNombre.setBounds(100, 17, 100, 20);
        apellido.setBounds(20, 60, 80, 15);
        cApellido.setBounds(100, 55, 100, 20);
        */
        add(nombre);
        add(cNombre);
        add(apellido);
        add(cApellido);
        add(edad);
        add(cEdad);
        add(tlf);
        add(cTlf);
    }
}

class EnColumnas implements LayoutManager{
    
    private int x;
    private int y = 20;

    @Override
    public void addLayoutComponent(String name, Component comp) {
        
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void layoutContainer(Container parent) {
        int contador = 0;
        int n = parent.getComponentCount();
        int d = parent.getWidth();
        x = d / 2;
        
        for(int i = 0; i < n; i++){
            contador++;
            Component c = parent.getComponent(i);
            c.setBounds(x - 100, y, 100, 20);
            x += 100;
            if(contador % 2 == 0){
                x = d / 2;
                y += 40;
            }
        }
        
    }
    
}