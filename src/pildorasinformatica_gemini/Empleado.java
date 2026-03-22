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
    
    public Empleado(String nombre){
        super(nombre);
    }
    
    // Estamos obligados a implementar este metodo

    @Override
    public double establecerBonus(double gratificacion) {
        return Trabajador.BONUS_BASE + gratificacion;
    }
}
