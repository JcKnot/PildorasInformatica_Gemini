
package practicaCursoPildorasInformatica.grafico;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author "Jose Castillo"
 *
 */
public class Calculadora {

    public static void main(String[] args) {

        MarcoCalculadora miMarco = new MarcoCalculadora();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miMarco.setVisible(true);

    }

}

class MarcoCalculadora extends JFrame {

    public MarcoCalculadora() {
        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);
        LaminaCalculadora miLamina = new LaminaCalculadora();
        add(miLamina);
        // pack();
    }
}

class LaminaCalculadora extends JPanel {
    private JPanel botonera;
    private JButton pantalla;
    private boolean isCero;
    private double resultado;
    private String ultimaOperacion;

    public LaminaCalculadora() {
        setLayout(new BorderLayout());
        isCero = true;
        pantalla = new JButton("0");
        pantalla.setEnabled(false);
        add(pantalla, BorderLayout.NORTH);
        ultimaOperacion = "=";
        botonera = new JPanel();
        botonera.setLayout(new GridLayout(4, 4));
        ActionListener oyente = new InsertaNumero();
        ActionListener orden = new AccionOrden();
        agragarBotones("7", oyente);
        agragarBotones("8", oyente);
        agragarBotones("9", oyente);
        agragarBotones("/", orden);
        agragarBotones("4", oyente);
        agragarBotones("5", oyente);
        agragarBotones("6", oyente);
        agragarBotones("*", orden);
        agragarBotones("1", oyente);
        agragarBotones("2", oyente);
        agragarBotones("3", oyente);
        agragarBotones("-", orden);
        agragarBotones("0", oyente);
        agragarBotones(".", oyente);
        agragarBotones("=", orden);
        agragarBotones("+", orden);
        add(botonera, BorderLayout.CENTER);
    }

    private void agragarBotones(String rotulo, ActionListener oyente) {
        JButton boton = new JButton(rotulo);
        boton.addActionListener(oyente);
        botonera.add(boton);
    }

    private class InsertaNumero implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String entrada = e.getActionCommand();
            if (isCero) {
                pantalla.setText("");
                isCero = false;
            }
            pantalla.setText(pantalla.getText() + entrada);
        }

    }

    private class AccionOrden implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String operacion = e.getActionCommand();
            calcular(Double.parseDouble(pantalla.getText()), operacion);
            ultimaOperacion = operacion;
            isCero = true;

        }

        public void calcular(double x, String operacion) {

            if (ultimaOperacion.equals("+")) {
                resultado += x;
            } else if (ultimaOperacion.equals("-")) {
                resultado -= x;
            } else if (ultimaOperacion.equals("*")) {
                resultado *= x;
            } else if (ultimaOperacion.equals("/")) {
                resultado /= x;
            } else if (ultimaOperacion.equals("=")) {
                resultado = x;
            }

            pantalla.setText("" + resultado);

        }

    }
}