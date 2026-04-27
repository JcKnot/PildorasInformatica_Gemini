
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author "Jose Castillo"
 *
 */
public class PanelSeguridad extends JFrame{
    
//    public static void main(String[] args) {
//        PanelSeguridad miPanel = new PanelSeguridad();
//        miPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        miPanel.setVisible(true);
//    }
        
    public PanelSeguridad(){
        setTitle("Panel Seguridad");
        setBounds(600, 600, 250, 300);
        
        LaminaSeguridad miLamina = new LaminaSeguridad();
        add(miLamina);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

class LaminaSeguridad extends JPanel{
    private JPanel teclado;
    
    public LaminaSeguridad(){
        setLayout(new BorderLayout());
        JLabel pantalla = new JLabel("Ingrese Clave");
        add(pantalla, BorderLayout.NORTH);
        
        teclado = new JPanel();
        teclado.setLayout(new GridLayout(4,3));
        crearTeclado();
        add(teclado, BorderLayout.CENTER);
    }
    
    private void crearTeclado(){
        
        for(int i = 1; i <= 12; i++ ){
            if(i == 10){
                JButton boton = new JButton("*");
                teclado.add(boton);
            }else if(i == 11){
                JButton boton = new JButton("0");
                teclado.add(boton);
            }else if(i == 12){
                JButton boton = new JButton("#");
                teclado.add(boton);
            }else {
                JButton boton = new JButton(""+i);
                teclado.add(boton);
            }
        }
    }
}
