package pildorasinformatica_gemini;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date; // Para capturar la hora real
import javax.swing.JFrame;
import javax.swing.Timer;

public class Empleado extends Persona implements Trabajador {
    private double sueldo;
    private Timer time;
    
    public Empleado(String nombre, int edad) {
        super(nombre, edad);
    }
    
    public void setSueldo(double sueldo){
        if(sueldo < Integer.parseInt(EnumVariables.SUELDO_MINIMO.getValor())){
            System.out.println("Erro el sueldo no puede ser menor a "+EnumVariables.SUELDO_MINIMO.getValor());
            this.sueldo = sueldo;
        }else {
            this.sueldo = sueldo;
        }
    }
    
    public double getSueldo(){
        return this.sueldo;
    }

    // --- AQUÍ EMPIEZA LA CLASE INTERNA ---
    private class RelojInterno {
        public void emitirTicket() {
            // Accedemos directamente a getNombre() de la clase padre (Empleado)
            System.out.println("[TICKET] Entrada registrada para: " + getNombre());
            System.out.println("[HORA]: " + new Date());
        }
    }
    // --- AQUÍ TERMINA LA CLASE INTERNA ---

    // Método de Empleado que usa su clase interna
    public void realizarFichaje() {
        RelojInterno miReloj = new RelojInterno();
        miReloj.emitirTicket();
    }

    @Override
    public double establecerBonus(double gratificacion) {  
        
        class Auditor{
            public boolean validarBono(double monto){
                if(monto > Trabajador.BONUS_MAXIMO){
                    System.out.println("ALERTA DE FRAUDE: Intento de bono excesivo para " + getNombre());
                    return false;
                } else return true;                
            }
        }
        
        Auditor audi = new Auditor();
        double bonus = Trabajador.BONUS_BASE + gratificacion;
        if(audi.validarBono(bonus)){
            return bonus;
        }else if (this instanceof Director){
                return Trabajador.BONUS_MAXIMO;
        }else return 0;
        
    }
    
    public void comenzarJornada(int segundos, JFrame ventana){
        // --- AQUÍ EMPIEZA LA CLASE INTERNA ---
        class RelojFichaje implements ActionListener{
            private int contador = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contador <= 5){
                    String msj = "Empleado: " + getNombre() + " Marcaje: " + new Date();
                    ventana.setTitle(msj);
                    System.out.println(msj);
                    Toolkit.getDefaultToolkit().beep();
                    contador++;
                }else time.stop();            
            }        
        }
        // --- AQUÍ TERMINA LA CLASE INTERNA ---
        
        this.time = new Timer(segundos, new RelojFichaje());
        time.start();
    }
}