/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicaCursoPildorasInformatica.grafico;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author slipk
 */
public class PruebaAcciones {
    
    public static void main(String[] args) {
        MarcoAccion marco = new MarcoAccion();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
    
}

class MarcoAccion extends JFrame{
    
    public MarcoAccion(){
        setTitle("Prueba Acciones");
        setBounds(600, 300, 600, 300);
        PanelAccion lamina = new PanelAccion();
        add(lamina);
    }
}

class PanelAccion extends JPanel{
    
    public PanelAccion(){        
        JButton btnAmarillo = new JButton("Amarillo");
        JButton btnAzul = new JButton("Azul");
        JButton btnRojo = new JButton("Rojo");
        
        add(btnAmarillo);
        add(btnAzul);
        add(btnRojo);
        
    }
    
}

class AccionColor extends AbstractAction{
    
    public AccionColor(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}