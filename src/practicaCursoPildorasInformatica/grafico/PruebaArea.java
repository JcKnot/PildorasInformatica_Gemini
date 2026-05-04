
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Jose Castillo
 *
 */
public class PruebaArea {
    
    public static void main(String[] args) {
        
        MarcoPruebaArea miMarco = new MarcoPruebaArea();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);
    }

}

class MarcoPruebaArea extends JFrame{
    private JPanel laminaBotones;
    private JButton btnInsertar;
    private JButton btnSaltoLinea;
    private JTextArea areaTexto;
    private JScrollPane laminaConBarras;
    
    public MarcoPruebaArea(){
        setTitle("Probando Area de Texto");
        setBounds(400, 400, 500, 350);
        setLayout(new BorderLayout());
        
        laminaBotones = new JPanel();
        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.append("En un lugar de la Mancha de cuyo no quiero acordarme");
            }            
        });
        laminaBotones.add(btnInsertar);
        
        btnSaltoLinea = new JButton("Salto Linea");
        btnSaltoLinea.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saltar = !areaTexto.getLineWrap();
                areaTexto.setLineWrap(saltar);
                
                if(saltar){
                    btnSaltoLinea.setText("Quitar Salto");
                }else {
                    btnSaltoLinea.setText("Salto Linea");
                }
            }            
        });
        laminaBotones.add(btnSaltoLinea);
        add(laminaBotones, BorderLayout.SOUTH);
        
        areaTexto = new JTextArea(8,20);
        laminaConBarras = new JScrollPane(areaTexto);
        add(laminaConBarras, BorderLayout.CENTER);
        
        
    }
}
