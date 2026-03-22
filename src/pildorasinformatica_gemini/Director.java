/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public class Director extends Jefe {
    private final double BONUS_DIRECTOR = 5000;
    
    public Director(String nombre) {
        super(nombre);
    }
    
    @Override
    public double establecerBonus(double gratificacion) {
        return super.establecerBonus(gratificacion) + this.BONUS_DIRECTOR;
    }
    
}
