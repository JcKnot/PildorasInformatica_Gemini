/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public interface Trabajador {
    // Esto es una constante (Bonus base para todos)
    double BONUS_BASE = 1500;
    double BONUS_MAXIMO = 10000;
    
    // Nuestro "Diccionario" de tiempos (en milisegundos)
    int TIEMPO_DIRECTOR = 1000;
    int TIEMPO_JEFE = 2000;
    int TIEMPO_EMPLEADO = 3000;
    
    // Este es el método que todos están obligados a tener
    double establecerBonus(double gratificacion);
    
    String getNombre();
}
