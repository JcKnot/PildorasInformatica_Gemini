
package practicaCursoPildorasInformatica.PracticaGuiada2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jcastillo
 */
public class MarcoDialogo extends JFrame {
    private LaminaBotones laminaTipo, laminaTipoMensaje, laminaMensaje
                        , LaminaTipoOpciones, LaminaOpciones, LaminaEntrada;
    
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
                                                                    ,"INFORMATION_)MESSAGE"
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
        laminaMostrar.add(btnMostrar);
        
        add(laminaCuadricula, BorderLayout.CENTER);
        add(laminaMostrar, BorderLayout.SOUTH);       
    }
    
}
