
package practicaCursoPildorasInformatica.execpciones;

/**
 *
 * @author Jose Castillo
 *
 */
public class Fallos {
    
    public static void main(String[] args) {
        
        int[] miMatriz = new int[5];
        
        miMatriz[0] = 5;
        miMatriz[1] = 38;
        miMatriz[2] = -15;
        miMatriz[3] = 92;
        miMatriz[4] = 71;
        
        for(int i = 0; i < miMatriz.length; i++){
            System.out.println("Posicion " + i + " = " + miMatriz[i]);
        }
    }

}
