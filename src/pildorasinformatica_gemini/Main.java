
package pildorasinformatica_gemini;

import javax.swing.JOptionPane;

/**
 *
 * @author slipk
 */
public class Main {
    public static void main(String[] args) {
        // 1. Creamos un Array de la Interfaz (Capacidad para 3 "filas")
        Persona[] listaPersonas = new Persona[5];
        double totalNomina = 0;

        // 2. Llenamos el array con diferentes tipos (Polimorfismo puro)
        listaPersonas[0] = new Empleado("Luis", 30);
        listaPersonas[1] = new Jefe("Jose", 39);
        listaPersonas[2] = new Empleado("Ana", 35);
        listaPersonas[3] = new Director("Santiago", 45);
        listaPersonas[4] = new Empleado("Alanna", 25);

        System.out.println("--- Reporte de Bonus Navideño ---");

        // 3. Recorremos el array con un bucle "for-each"
        for (Persona p : listaPersonas) {
            if (p instanceof Empleado e){
                double bonus = e.establecerBonus(3000); 
                Persona.acumularNomina(bonus);
//                totalNomina += bonus;
                e.comenzarJornada();
                System.out.println("ID: " + e.getId() + 
                                    " | Nombre: " + e.getNombre() + 
                                    " | Edad: " + e.getEdad() + 
                                    " | Sueldo: " + e.getSueldo() +
                                    " | Bonus: " + bonus);
            }
        }
        
        System.out.println("Gasto total de la empresa en bonos: " + Persona.getTotalNominasRepartidas() );
        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener el reloj");
    }
}
