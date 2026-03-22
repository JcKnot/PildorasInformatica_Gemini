/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public class Empleado extends Persona implements Trabajador{
    private double sueldoBase;
    
    public Empleado(String nombre, int edad, double sueldo){
        super(nombre,edad);
        this.sueldoBase = sueldo;
    }

    @Override
    public double establecerBonus(double gratificacion) {
        return Trabajador.BONUS_BASE + gratificacion;
    }
    
    private class RelojInterno{
        public void registrarEntrada(){
            System.out.println(">>> [LOG]: El empleado " + getNombre() + " ha fichado su entrada.");
        }
    }
    
    public void iniciarJornada(){
        RelojInterno miReloj = new RelojInterno();
        miReloj.registrarEntrada();
    }
}
