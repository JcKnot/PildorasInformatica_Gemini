
package practicaCursoPildorasInformatica.PracticaGuiada2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author jcastillo
 */
public class MarcoDialogo extends JFrame {
    private LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje
                        , LaminaTipoOpciones, LaminaOpciones, LaminaEntrada;
    private String cadenaMensaje = "Mensaje";
    private Icon iconoMensaje = new ImageIcon("src/practicaCursoPildorasInformatica/PracticaGuiada/IconoAzul.PNG");
    private Object objetoMensaje = new Date();
    private Component componenteMensaje = new LaminaComponent();
    
    public MarcoDialogo(){
        setTitle("Prueba de Dialogos");
        setBounds(500, 300, 600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel laminaCuadricula = new JPanel();
        laminaCuadricula.setLayout(new GridLayout(2,3));
        
        String[] tipo = {"Mensaje","Confirmar","Opciones","Entrada"};
        laminaTipo = new LaminaBotones("Tipo",tipo);
        laminaCuadricula.add(laminaTipo);
        
        laminaTipoMensaje = new LaminaBotones("Tipo de Mensaje", new String[]{"ERRO_MESSAGE"
                                                                    ,"INFORMATION_MESSAGE"
                                                                    ,"WARNING_MESSAGE"
                                                                    ,"QUESTION_MESSAGE"
                                                                    ,"PLAIN_MESSAGE"});
        laminaCuadricula.add(laminaTipoMensaje);
        
        laminaMensaje = new LaminaBotones("Mensaje", new String[]{"Cadena","Icono","Componente","Otros","Object[]"});
        laminaCuadricula.add(laminaMensaje);
        
        LaminaTipoOpciones = new LaminaBotones("Confirmar", new String[]{"DEFAULT_OPTION"
                                                                        ,"YES_NO_OPTION"
                                                                        ,"YES_NO_CANCEL_OPTION"
                                                                        ,"OK_CANCEL_OPTION"});
        laminaCuadricula.add(LaminaTipoOpciones);
        
        LaminaOpciones = new LaminaBotones("Opción" , new String[]{"String[]","Icon[]","Object[]"});
        laminaCuadricula.add(LaminaOpciones);
        
        LaminaEntrada = new LaminaBotones("Entrada" , new String[]{"Campo de Texto","Combo"});
        laminaCuadricula.add(LaminaEntrada);
        
        setLayout(new BorderLayout());
        
        JPanel laminaMostrar = new JPanel();
        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.addActionListener(new AccionMostrar());
        laminaMostrar.add(btnMostrar);
        
        add(laminaCuadricula, BorderLayout.CENTER);
        add(laminaMostrar, BorderLayout.SOUTH);       
    }
    
    public Object dameMensaje(){
        
        switch (laminaMensaje.dameSeleccion()) {
            case "Cadena":
                return cadenaMensaje;
            case "Icono":
                return iconoMensaje;
            case "Componente":
                return componenteMensaje;
            case "Otros":
                return objetoMensaje;
            case "Object[]":
                return new Object[]{cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje};
            default:
                break;
        }
        
        return null;
    }
    
    public int dameTipoMensaje(){
        String s = laminaTipoMensaje.dameSeleccion();
        
        if(s.equals("ERRO_MESSAGE")){
            return 0;
        }else if(s.equals("INFORMATION_MESSAGE")){
            return 1;
        }else if(s.equals("WARNING_MESSAGE")){
            return 2;
        }else if(s.equals("QUESTION_MESSAGE")){
            return 3;
        }else if(s.equals("PLAIN_MESSAGE")){
            return -1;
        }else {
            return -2;
        }
        
    }
    
    private class AccionMostrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String mensaje = laminaMensaje.dameSeleccion();
            
            switch (laminaTipo.dameSeleccion()) {
                case "Mensaje":
                    JOptionPane.showMessageDialog(MarcoDialogo.this, dameMensaje(), "Titulo", dameTipoMensaje());
                    break;
                case "Confirmar":
                    JOptionPane.showConfirmDialog(MarcoDialogo.this, dameMensaje(), "Titulo", 0, dameTipoMensaje());
                    break;
                case "Opciones":
                    JOptionPane.showOptionDialog(MarcoDialogo.this, dameMensaje(), "Titulo", 0, dameTipoMensaje(), null, null, null);
                    break;
                case "Entrada":
                    JOptionPane.showInputDialog(MarcoDialogo.this, dameMensaje(), "Titulo", dameTipoMensaje());
                    break;
                default:
                    break;
            }
        }
        
    }
    
    class LaminaComponent extends JPanel{
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D) g;
            
            Rectangle2D rectangulo = new Rectangle2D.Double(0,0,getWidth(),getHeight());
            
            g2.setPaint(Color.YELLOW);
            g2.fill(rectangulo);
        }
    }
    
}
