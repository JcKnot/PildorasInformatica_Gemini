
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public class Main {
    public static void main(String[] args) {
        // 1. Creamos un Array de la Interfaz (Capacidad para 3 "filas")
        Persona[] listaPersonas = new Persona[4];

        // 2. Llenamos el array con diferentes tipos (Polimorfismo puro)
        listaPersonas[0] = new Empleado("Antonio", 30, 1000);
        listaPersonas[1] = new Jefe("Jose", 39, 1700);
        listaPersonas[2] = new Empleado("Ana", 35, 900);
        listaPersonas[3] = new Director("Santiago", 45, 2900);

        System.out.println("--- Reporte de Bonus Navideño ---");

        // 3. Recorremos el array con un bucle "for-each"
        for (Persona p : listaPersonas) {
            String departamento = p.getClass().getSimpleName();
            
            if (p instanceof Empleado e){
                double bonus = e.establecerBonus(500);
                
                e.iniciarJornada();
                System.out.println("El " + departamento + " " + e.getNombre() + " tiene un bono de: " + bonus);
            }
        }
    }
}
