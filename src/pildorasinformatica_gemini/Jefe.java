
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public class Jefe extends Empleado{
    private final double BONUS_PRIMA = 2000;
    
    public Jefe (String nombre){
        super(nombre);
    }

    @Override
    public double establecerBonus(double gratificacion) {
        return super.establecerBonus(gratificacion) + this.BONUS_PRIMA;
    }
}
