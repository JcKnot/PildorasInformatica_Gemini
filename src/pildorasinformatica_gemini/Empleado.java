package pildorasinformatica_gemini;

import java.util.Date; // Para capturar la hora real

public class Empleado extends Persona implements Trabajador {
    private double sueldo;
    
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
        Auditor audi = new Auditor();
        double bonus = Trabajador.BONUS_BASE + gratificacion;
        if(audi.validarBono(bonus)){
            return bonus;
        }else if (this instanceof Director){
                return Trabajador.BONUS_MAXIMO;
        }else return 0;
    }
    
    private class Auditor{
        public boolean validarBono(double monto){
            if(monto > Trabajador.BONUS_MAXIMO){
                System.out.println("ALERTA DE FRAUDE: Intento de bono excesivo para " + getNombre());
                return false;
            } else return true;                
        }
    }
}