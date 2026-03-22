/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public abstract class Persona {
    private String nombre;
    private int edad;
    private static int idSiguiente = 1;
    private int id;
    
    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.id = idSiguiente;
        idSiguiente++;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getEdad(){
        return this.edad;
    }
}
