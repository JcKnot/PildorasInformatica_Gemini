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
        return Trabajador.BONUS_BASE + gratificacion;
    }
}