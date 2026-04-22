/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildorasinformatica_gemini;

/**
 *
 * @author Jose Castillo
 * 
 */
public final class Director extends Jefe {
    private final double BONUS_DIRECTOR = 5000;

    public Director(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public double establecerBonus(double gratificacion) {
        return super.establecerBonus(gratificacion + this.BONUS_DIRECTOR);
    }

}
