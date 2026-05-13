
package pildorasinformatica_gemini;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Jose Castillo
 * 
 */
public class MarcoCentradoComando extends JFrame {

    public static void main(String[] args) {
        MarcoCentradoComando marco = new MarcoCentradoComando();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    public MarcoCentradoComando() {
        setTitle("Comando");
        setBounds(600, 300, 600, 300);
        Lamina lamina = new Lamina();
        add(lamina);
    }

    class Lamina extends JPanel implements ActionListener {
        private JButton botonComunicado;
        private JButton btnMonitor;
        private JTextField cajaMensaje;
        private ArrayList<TerminalEmpleado> terminalesAbiertas = new ArrayList<>();
        private JButton btnVerPerfiles;
        private JButton btnCredenciales;
        private JButton btnBiografia;

        public Lamina() {
            AccionColor amarillo = new AccionColor("Amarillo", new ImageIcon(EnumVariables.ICONO_AMARILLO.getValor()),
                    Color.YELLOW, this);
            AccionColor azul = new AccionColor("Azul", new ImageIcon(EnumVariables.ICONO_AZUL.getValor()), Color.BLUE,
                    this);
            AccionColor rojo = new AccionColor("Rojo", new ImageIcon(EnumVariables.ICONO_ROJO.getValor()), Color.RED,
                    this);

            JButton botonAmarillo = new JButton(amarillo);
            JButton botonAzul = new JButton(azul);
            JButton botonRojo = new JButton(rojo);

            add(botonAmarillo);
            add(botonAzul);
            add(botonRojo);

            InputMap mapa = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
            KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B");
            KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R");
            mapa.put(teclaAmarillo, "fondoAmarillo");
            mapa.put(teclaAzul, "fondoAzul");
            mapa.put(teclaRojo, "fondoRojo");
            ActionMap mapaAccion = getActionMap();
            mapaAccion.put("fondoAmarillo", amarillo);
            mapaAccion.put("fondoAzul", azul);
            mapaAccion.put("fondoRojo", rojo);

            cajaMensaje = new JTextField("Esperando órdenes...",20);
            AccionComunicado textCominicado = new AccionComunicado("Emitir Comunicado", null, "Envia Comunicado",
                    Color.ORANGE, cajaMensaje, terminalesAbiertas);
            InputMap mapaCaja = cajaMensaje.getInputMap(JComponent.WHEN_FOCUSED);
            mapaCaja.put(KeyStroke.getKeyStroke("ENTER"), "enviar_comunicado");
            ActionMap mapaAccionCaja = cajaMensaje.getActionMap();
            mapaAccionCaja.put("enviar_comunicado", textCominicado);
            add(cajaMensaje);

            botonComunicado = new JButton(textCominicado);
            add(botonComunicado);

            btnMonitor = new JButton("Nuevo Monitor");
            btnMonitor.addActionListener(this);
            add(btnMonitor);
            
            btnVerPerfiles = new JButton("Ver Perfiles");
            AccionPerfiles verPerfiles = new AccionPerfiles();
            btnVerPerfiles.addActionListener(verPerfiles);
            add(btnVerPerfiles);
            
            btnCredenciales = new JButton("Terminal Credenciales");
            AccionCredenciales verCredenciales = new AccionCredenciales();
            btnCredenciales.addActionListener(verCredenciales);
            add(btnCredenciales);
            
            btnBiografia = new JButton("Configurar Biografía");
            btnBiografia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MarcoConfigPerfil marcoPerfil = new MarcoConfigPerfil();                    
                    marcoPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    marcoPerfil.setVisible(true);
                }
            }            
            );
            add(btnBiografia);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            TerminalEmpleado newTerminal = new TerminalEmpleado(botonComunicado, cajaMensaje);
            terminalesAbiertas.add(newTerminal);
            newTerminal.setVisible(true);
        }
    }

    class AccionComunicado extends AbstractAction {
        private JTextField comunicado;
        private ArrayList<TerminalEmpleado> lista;

        public AccionComunicado(String nombre, Icon icono, String descrip, Color c,
                JTextField comunicado, ArrayList<TerminalEmpleado> list) {
            this.lista = list;
            this.comunicado = comunicado;
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, descrip);
            putValue("color_fondo", c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String mensaje = comunicado.getText();
            System.out.println("Enviendo:" + mensaje);

            for (TerminalEmpleado t : lista) {
                t.recibirMensaje(mensaje);
            }
        }

    }
    
    class AccionPerfiles implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoPerfilEmpleado perfil = new MarcoPerfilEmpleado();
            perfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            perfil.setVisible(true);
        }
        
    } 
    
    class AccionCredenciales implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoCredenciales credenciales = new MarcoCredenciales();
            credenciales.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            credenciales.setVisible(true);
        }
        
    }
}
