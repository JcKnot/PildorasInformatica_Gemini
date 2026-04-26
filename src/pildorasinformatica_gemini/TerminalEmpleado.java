
package pildorasinformatica_gemini;

import java.awt.Color;
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
public class TerminalEmpleado extends JFrame {
    private static int nroVentana;
    private JPanel miLamina;
    private JLabel msj;

    public TerminalEmpleado(JButton boton, JTextField cajaTexto) {
        nroVentana++;
        msj = new JLabel(cajaTexto.getText());
        setTitle("Terminal " + nroVentana);
        setBounds((200 * nroVentana), (100 * nroVentana), 300, 200);
        miLamina = new Lamina();
        add(miLamina);
    }

    public void recibirMensaje(String textoAlerta) {
        msj.setText(textoAlerta);
        msj.setBounds(100, 50, 100, 50);
        miLamina.add(msj);
        miLamina.setBackground(Color.ORANGE);
        miLamina.revalidate();
        miLamina.repaint();
    }

    class Lamina extends JPanel {

        public Lamina() {

        }
    }

}
