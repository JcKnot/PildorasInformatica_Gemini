
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Jose Castillo
 *
 */
public class EjemploRadio {
    
    public static void main(String[] args) {
        MarcoRadio miMarco = new MarcoRadio();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoRadio extends JFrame{
    
    public MarcoRadio(){
        setVisible(true);
        setBounds(550, 300, 500, 350);
        LaminaRadio miLamina = new LaminaRadio();
        add(miLamina);
    }
}

class LaminaRadio extends JPanel{
    private JLabel texto;
    private JRadioButton boton1, boton2, boton3, boton4;
    private ButtonGroup miGrupo = new ButtonGroup();
    private JPanel laminaBotones = new JPanel();
    
    public LaminaRadio(){
        setLayout(new BorderLayout());
        texto = new JLabel("En un lugar de la mancha");
        texto.setFont(new Font("Serif", Font.PLAIN, 12));
        add(texto, BorderLayout.CENTER);
        
        colocarBotones("Pequeño", false, 12);
        colocarBotones("Mediano", false, 16);
        colocarBotones("Grande", false, 18);
        colocarBotones("Muy Grande", false, 20);
        
        add(laminaBotones, BorderLayout.SOUTH);
        
//        ButtonGroup miGrupo = new ButtonGroup();
//        boton1 = new JRadioButton("Pequeño", false);
//        boton2 = new JRadioButton("Mediano", false);
//        boton3 = new JRadioButton("Grande", false);
//        boton4 = new JRadioButton("Muy Grande", false);
//        
//        JPanel laminaRadio = new JPanel();
//        
//        EventoRadio miEvento = new EventoRadio();
//        boton1.addActionListener(miEvento);
//        boton2.addActionListener(miEvento);
//        boton3.addActionListener(miEvento);
//        boton4.addActionListener(miEvento);
//        
//        miGrupo.add(boton1);
//        miGrupo.add(boton2);
//        miGrupo.add(boton3);
//        miGrupo.add(boton4);
//        
//        laminaRadio.add(boton1);
//        laminaRadio.add(boton2);
//        laminaRadio.add(boton3);
//        laminaRadio.add(boton4);
//        
//        add(laminaRadio, BorderLayout.SOUTH);
    }
    
    public void colocarBotones(String nombre, boolean seleccionado, final int tamano){
        
        JRadioButton boton = new JRadioButton(nombre, seleccionado);
        miGrupo.add(boton);
        laminaBotones.add(boton);
        ActionListener miEvento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto.setFont(new Font("Serif", Font.PLAIN, tamano));
            }
        };
        boton.addActionListener(miEvento);        
    }
    
//    private class EventoRadio implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            
//            if(e.getSource() == boton1){
//                texto.setFont(new Font("Serif", Font.PLAIN, 10));
//            }else if(e.getSource() == boton2){
//                texto.setFont(new Font("Serif", Font.PLAIN, 12));
//            }else if(e.getSource() == boton3){
//                texto.setFont(new Font("Serif", Font.PLAIN, 18));
//            }else if(e.getSource() == boton4){
//                texto.setFont(new Font("Serif", Font.PLAIN, 24));
//            }
//        }
//        
//    }
}
