
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public class Main {
    public static void main(String[] args) {
        // 1. Creamos un Array de la Interfaz (Capacidad para 3 "filas")
        Trabajador[] misTrabajadores = new Trabajador[4];

        // 2. Llenamos el array con diferentes tipos (Polimorfismo puro)
        misTrabajadores[0] = new Empleado("Antonio");
        misTrabajadores[1] = new Jefe("Jose");
        misTrabajadores[2] = new Empleado("Ana");
        misTrabajadores[3] = new Director("Santiago");

        System.out.println("--- Reporte de Bonus Navideño ---");

        // 3. Recorremos el array con un bucle "for-each"
        for (Trabajador t : misTrabajadores) {
            /* Aquí ocurre la magia: Java sabe si "t" es Jefe o Empleado 
               y llama al método correcto automáticamente.
            */
            double bonus = t.establecerBonus(500);

            // Nota: Para imprimir el nombre, necesitamos un truco que te explicaré abajo
            System.out.println("Trabajador " + t.getNombre() + " con bonus de: " + bonus);
        }
    }
}
