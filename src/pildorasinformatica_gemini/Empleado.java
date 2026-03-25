package pildorasinformatica_gemini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date; // Para capturar la hora real
import javax.swing.Timer;
import pildorasinformatica_gemini.Trabajador;

public class Empleado extends Persona implements Trabajador {
    private double sueldo;
    private Timer time;
    
    public Empleado(String nombre, int edad) {
        super(nombre, edad);
    }
    
    public void setSueldo(double sueldo){
        if(sueldo < 1000){
            System.out.println("Erro el sueldo no puede ser menor a 1000");
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
    
    public void comenzarJornada(int segundos){
        // --- AQUÍ EMPIEZA LA CLASE INTERNA ---
        class RelojFichaje implements ActionListener{
            private int contador = 0;
            @Override
            public void actionPerformed(ActionEvent e) {            
                if(contador <= 5){
                    System.out.println("Empleado: " + getNombre() + " Marcaje: " + new Date());
                    contador++;
                }else time.stop();            
            }        
        }
        // --- AQUÍ TERMINA LA CLASE INTERNA ---
        
        this.time = new Timer(segundos, new RelojFichaje());
        time.start();
    }
}