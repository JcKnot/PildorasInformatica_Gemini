
package practicaCursoPildorasInformatica.grafico;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jose Castillo
 */
public class VariosOyentes {
    
    public static void main(String[] args) {
        
        MarcoPrincipal miMarco = new MarcoPrincipal();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }
    
}

class MarcoPrincipal extends JFrame{
    
    public MarcoPrincipal(){
        setTitle("Varios Oyentes");
        setBounds(600, 300, 600, 300);
        
        LaminaPrincipal lamina = new LaminaPrincipal();
        add(lamina);
        
    }
}

class LaminaPrincipal extends JPanel{
    JButton botonCerrar;
    
    public LaminaPrincipal(){        
        JButton botonNuevo = new JButton("Nuevo");
        botonCerrar = new JButton("Cerrar Todo");
        
        add(botonNuevo);
        add(botonCerrar);
        
        botonNuevoOyente oyente = new botonNuevoOyente();
        botonNuevo.addActionListener(oyente);
    }
    
    class botonNuevoOyente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoEmergente marco = new MarcoEmergente(botonCerrar);
            marco.setVisible(true);
        }
        
    }
}

class MarcoEmergente extends JFrame{
    private static int contador = 0;
    
    public MarcoEmergente(JButton botonCerrar){
        contador++;
        setTitle("Ventana " + contador);
        setBounds((40 * contador), (20 * contador), 300, 150);
        
        marcoOyente oyente = new marcoOyente();
        botonCerrar.addActionListener(oyente);
    }
    
    class marcoOyente implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
        
    }
}