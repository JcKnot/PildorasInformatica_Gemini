/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public final class Director extends Jefe {
    private final double BONUS_DIRECTOR = 5000;
    
    public Director(String nombre, int edad) {
        super(nombre, edad);
    }
    
    @Override
    public double establecerBonus(double gratificacion) {
        double bono = Trabajador.BONUS_BASE + this.BONUS_DIRECTOR + gratificacion;
        
        if(bono > Trabajador.BONUS_MAXIMO){
            System.out.println("(!) Nota: Bono de Director ajustado al tope legal.");
            bono = Trabajador.BONUS_MAXIMO;
        }
        return bono;
    }
    
}
