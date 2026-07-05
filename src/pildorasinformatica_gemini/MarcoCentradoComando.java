
package pildorasinformatica_gemini;

import java.awt.BorderLayout;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author Jose Castillo
 * 
 */
public class MarcoCentradoComando extends JFrame {
    private JToolBar barraHerramienta;
    
    public static void main(String[] args) {
        MarcoCentradoComando marco = new MarcoCentradoComando();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    public MarcoCentradoComando() {
        setTitle("Comando");
        setBounds(800, 300, 600, 300);
        setLayout(new BorderLayout());
        Lamina lamina = new Lamina();
        
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuGestion = new JMenu("Gestión");
        barraMenu.add(menuGestion);
        barraHerramienta = new JToolBar();
        /* Se desahabilita la opcion de mover la barra de herramientas para mantener
        la interfas intacta */
        barraHerramienta.setFloatable(false);
        
        AccionPerfiles itemPerfiles = new AccionPerfiles("Ver Perfiles","Abrir Perfiles");
        menuGestion.add(itemPerfiles);
        JButton btnPerfiles = barraHerramienta.add(itemPerfiles);
        btnPerfiles.setText("Perfiles");
        
        JMenuItem itemCredenciales = new JMenuItem("Credenciales");
        itemCredenciales.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MarcoCredenciales credenciales = new MarcoCredenciales();
                credenciales.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                credenciales.setVisible(true);
            }
            
        });
        menuGestion.add(itemCredenciales);
        
        JMenuItem itemCompensacion = new JMenuItem("Configurar Compensación");
        itemCompensacion.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MarcoCompensacion marcoCompensacion = new MarcoCompensacion();
                marcoCompensacion.setVisible(true);
            }
            
        });
        menuGestion.add(itemCompensacion);
        
        JMenuItem itemBiografia = new JMenuItem("Biografia");
        itemBiografia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MarcoConfigPerfil marcoPerfil = new MarcoConfigPerfil();                    
                marcoPerfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                marcoPerfil.setVisible(true);
            }
            
        });
        menuGestion.add(itemBiografia);
        
        AccionContrato itemContrato = new AccionContrato("Gestión de Contratos","Abrir Contratos");
        menuGestion.add(itemContrato);
        JButton btnContrato = barraHerramienta.add(itemContrato);
        btnContrato.setText("Contratos");
        barraHerramienta.addSeparator();
        barraHerramienta.addSeparator();
        
        AccionEditor itemAbrirEditor = new AccionEditor("Editor Texto","Abrir Editor Texto");
        menuGestion.add(itemAbrirEditor);
        JButton btnAbrirEditor = barraHerramienta.add(itemAbrirEditor);
        btnAbrirEditor.setText("Editor");
        
        AccionAlertas itemAlerta = new AccionAlertas("Alerta","Envia Alerta");
        menuGestion.add(itemAlerta);
        JButton btnAlerta = barraHerramienta.add(itemAlerta);
        btnAlerta.setText("Alerta");
        
        add(lamina, BorderLayout.CENTER);
        setJMenuBar(barraMenu);
        add(barraHerramienta, BorderLayout.NORTH);
        
    }

    class Lamina extends JPanel implements ActionListener {
        private JButton botonComunicado;
        private JButton btnMonitor;
        private JTextField cajaMensaje;
        private ArrayList<TerminalEmpleado> terminalesAbiertas = new ArrayList<>();

        public Lamina() {
            setLayout(new BorderLayout());
            AccionColor amarillo = new AccionColor("Amarillo", new ImageIcon(EnumVariables.ICONO_AMARILLO.getValor()),
                    Color.YELLOW, this);
            AccionColor azul = new AccionColor("Azul", new ImageIcon(EnumVariables.ICONO_AZUL.getValor()), Color.BLUE,
                    this);
            AccionColor rojo = new AccionColor("Rojo", new ImageIcon(EnumVariables.ICONO_ROJO.getValor()), Color.RED,
                    this);

            JButton botonAmarillo = new JButton(amarillo);
            JButton botonAzul = new JButton(azul);
            JButton botonRojo = new JButton(rojo);
            
            JPanel panelBotones = new JPanel();
            panelBotones.setOpaque(false);
            panelBotones.add(botonAmarillo);
            panelBotones.add(botonAzul);
            panelBotones.add(botonRojo);            

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
            
            JPanel panelCentro = new JPanel();
            panelCentro.setOpaque(false);
            cajaMensaje = new JTextField("Esperando órdenes...",20);
            AccionComunicado textCominicado = new AccionComunicado("Emitir Comunicado", null, "Envia Comunicado",
                    Color.ORANGE, cajaMensaje, terminalesAbiertas);
            InputMap mapaCaja = cajaMensaje.getInputMap(JComponent.WHEN_FOCUSED);
            mapaCaja.put(KeyStroke.getKeyStroke("ENTER"), "enviar_comunicado");
            ActionMap mapaAccionCaja = cajaMensaje.getActionMap();
            mapaAccionCaja.put("enviar_comunicado", textCominicado);
            panelCentro.add(cajaMensaje);
            

            JPanel panelFoot = new JPanel();
            panelFoot.setOpaque(false);
            botonComunicado = new JButton(textCominicado);
            panelFoot.add(botonComunicado);

            btnMonitor = new JButton("Nuevo Monitor");
            btnMonitor.addActionListener(this);
            panelFoot.add(btnMonitor);
            
            
            add(panelBotones, BorderLayout.NORTH);
            add(panelCentro, BorderLayout.CENTER);
            add(panelFoot, BorderLayout.SOUTH);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            TerminalEmpleado newTerminal = new TerminalEmpleado(botonComunicado, cajaMensaje);
            terminalesAbiertas.add(newTerminal);
            newTerminal.setVisible(true);
        }
    }

    private class AccionComunicado extends AbstractAction {
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
    
    private class AccionPerfiles extends AbstractAction {
        
        public AccionPerfiles(String name, String tooltip){
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, tooltip);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoPerfilEmpleado perfil = new MarcoPerfilEmpleado();
            perfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            perfil.setVisible(true);
        }
        
    } 
    
    private class AccionContrato extends AbstractAction {
        
        public AccionContrato(String name, String tooltip){
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, tooltip);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoContrato marcoContrato = new MarcoContrato();
            marcoContrato.setVisible(true); 
        }
        
    }
    
    private class AccionEditor extends AbstractAction {
        
        public AccionEditor(String name, String tooltip){
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, tooltip);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoEditor miMarco =  new MarcoEditor();
            miMarco.setVisible(true);
        }
        
    }
    
    private class AccionAlertas extends AbstractAction {
        
        public AccionAlertas(String name, String tooltip){
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, tooltip);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoConfiguradorAlertas marcoAlerta = new MarcoConfiguradorAlertas();
            marcoAlerta.setVisible(true);
        }
        
    }

}
