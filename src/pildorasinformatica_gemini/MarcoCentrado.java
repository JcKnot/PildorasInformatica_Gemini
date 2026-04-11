
package pildorasinformatica_gemini;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author slipk
 */
public class MarcoCentrado extends JFrame {
    private AuditoriaVentana auditoriaVentana = new AuditoriaVentana();
    private InicioGrafico inicioGraf = new InicioGrafico();
    
    public MarcoCentrado(){
        Toolkit screen = Toolkit.getDefaultToolkit();
        Dimension sizeScreen = screen.getScreenSize();
        setSize(sizeScreen.width / 2, sizeScreen.height / 2);
        setLocation(sizeScreen.width / 4, sizeScreen.height / 4);
        setTitle(EnumVariables.TITULO_APP.getValor() + " " + EnumVariables.VERSION_COMPILACION.getValor());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Image icono = screen.createImage("src/pildorasinformatica_gemini/icono_gestion.png");
        setIconImage(icono);
        setExtendedState(JFrame.NORMAL); //MAXIMIZED_BOTH);
        setResizable(EnumVariables.VENTANA_REDIMENSIONABLE.getValorBoolean());
        LaminaPrincipal miLamina = new LaminaPrincipal();
        add(miLamina);
        addWindowStateListener(auditoriaVentana);
        addWindowListener(inicioGraf);
    }
    
    class AuditoriaVentana implements WindowStateListener{

        @Override
        public void windowStateChanged(WindowEvent e) {
            
            if(e.getNewState() == JFrame.ICONIFIED){
                System.out.println("[AUDITORÍA] El sistema ha sido minimizado. Ocultando datos...");    
            }else if(e.getNewState() == JFrame.NORMAL){
                System.out.println("[AUDITORÍA] Sistema restaurado a tamaño estándar.");
            }
        }
        
    }
    
    class InicioGrafico extends WindowAdapter {
        
        @Override
        public void windowOpened(WindowEvent e){
            System.out.println("Iniciando conexión con la base de datos gráfica...");
        }
    }
        
}

class LaminaPrincipal extends JPanel{
    private Image imageUser;
    private Image imageFondo;
    private JButton btnProduccion = new JButton("Produccion");
    private JButton btnDesarrollo = new JButton("Desarrollo");
    private ColorEntorno colorEntornoP = new ColorEntorno(Color.RED);
    private ColorEntorno colorEntornoD = new ColorEntorno(Color.LIGHT_GRAY);
    private JButton btnCambiaModulo = new JButton("Cambiar Modulo");
    private CambiaTituloModulo cambioTituloModulo = new CambiaTituloModulo();
    private String tituloModulo = EnumVariables.TITULO_MODULO_GESTION.getValor();
    private KeyEventos tecla = new KeyEventos();
    private MouseEvento raton = new MouseEvento();
    private boolean operadorEnZona = false;
    
    public LaminaPrincipal(){
        try{
            imageUser = ImageIO.read(new File(EnumVariables.IMAGEN_USUARIO.getValor()));
            imageFondo = ImageIO.read(new File(EnumVariables.FONDO_CABECERA.getValor()));
        }catch(IOException e){
            System.out.println("Imagen no encontrada");
        }
        
        btnProduccion.addActionListener(colorEntornoP);
        btnDesarrollo.addActionListener(colorEntornoD);
        btnCambiaModulo.addActionListener(cambioTituloModulo);
        addKeyListener(tecla);
        addMouseListener(raton);
        add(btnProduccion);
        add(btnDesarrollo);
        add(btnCambiaModulo);
        setFocusable(true);
    }    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, this.getWidth(), 200);
        g2.setPaint(new Color(0, 102, 204));
        g2.fill(rectangulo);
        
        g2.drawImage(imageFondo, 0, 0, this);
        int recAncho = (int)rectangulo.getWidth();
        int recAlto = (int)rectangulo.getHeight();
        int width = imageFondo.getWidth(this);
        int height = imageFondo.getHeight(this);
        
        for(int i = 0; i < recAncho; i+=width){
            for(int j = 0; j < recAlto; j+=height){
                if(i+j > 0){
                    g2.copyArea(0, 0, width, height, i, j); 
                }
            }
        }
        
        g2.drawImage(imageUser, 20, 20, 150, 150, this);        
        
        Font fuente = new Font("Arial", Font.BOLD, 26);
        g2.setFont(fuente);
        g2.setColor(Color.WHITE);
        int h = (int) rectangulo.getHeight() / 2;
        g2.drawString(tituloModulo, 200,  h );
        
        if(operadorEnZona){
            setBackground(Color.GREEN);
        }else setBackground(Color.ORANGE);        
//        (operadorEnZona) ? setBackground(Color.GREEN) : setBackground(Color.ORANGE);

    }
    
    
    class ColorEntorno implements ActionListener{
        private Color color;
        
        public ColorEntorno(Color c){
            this.color = c;
        }        

        @Override
        public void actionPerformed(ActionEvent e) {
            setBackground(color);
        }
        
    }
    
    class CambiaTituloModulo implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            tituloModulo = (tituloModulo.equals(EnumVariables.TITULO_MODULO_GESTION.getValor())) 
                            ? EnumVariables.TITULO_MODULO_AUDITORIA.getValor() : EnumVariables.TITULO_MODULO_GESTION.getValor();
            repaint();
        }
    }
    
    class KeyEventos extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A){
                System.out.println("[SISTEMA] Iniciando Modo Administrador...");
                setBackground(Color.DARK_GRAY);
                repaint();
            }
            
            if(e.getKeyCode() == KeyEvent.VK_C){
                if(operadorEnZona){
                    System.out.println("Check-in del supervisor: Operador en posicion");
                }else System.out.println("ALERTA CRITICA: Operador fuera de zona");
            }
        }
    }
    
    class MouseEvento extends MouseAdapter {
        
        @Override
        public void mouseClicked(MouseEvent e) {
            requestFocusInWindow(true);
            System.out.println("Doble clic detectado en las coordenadas: X= " + e.getX() + " Y= " + e.getY());
        }
        
        @Override
        public void mouseEntered(MouseEvent e){
            operadorEnZona = true;
            repaint();
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            operadorEnZona = false;
            repaint();
        }
    }
    
}