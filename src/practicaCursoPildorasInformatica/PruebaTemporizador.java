
package practicaCursoPildorasInformatica;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author slipk
 */
public class PruebaTemporizador {
    public static void main(String[] args) {
        DameLaHora oyente = new DameLaHora();
        Timer miTemporizador = new Timer(5000, oyente);
        miTemporizador.start();
        JOptionPane.showMessageDialog(null, "Pilsa Aceptar para detener");
        System.exit(0);
    }
}

class DameLaHora implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        Date ahora = new Date();
        System.out.println("Te pongo la hora cada 5 seg " + ahora);
        Toolkit.getDefaultToolkit().beep();
    }
    
}