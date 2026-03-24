package practicaCursoPildorasInformatica;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Jose Castillo
 *
 */
public class PruebaTemporizador2 {
    
    public static void main(String[] args) {
        
        Reloj miReloj = new Reloj(3000, true);
        miReloj.enMarcha();
        JOptionPane.showMessageDialog(null, "Pulsa OK para terminar");
        System.exit(0);
        
    }
}


class Reloj{
    
    private int intervalo;
    private boolean sonido;
    
    public Reloj(int intervalo, boolean sonido){
        this.intervalo = intervalo;
        this.sonido = sonido;
    }
    
    public void enMarcha(){
        ActionListener oyente = new DameLaHora2();
        Timer miTemporizador = new Timer(intervalo, oyente);
        miTemporizador.start();
    }
    
    class DameLaHora2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Date ahora = new Date();
            System.out.println("Te pongo la hora cada 3 sg " + ahora);
            
            if(sonido){
                Toolkit.getDefaultToolkit().beep();
            }
        }
        
    }
}