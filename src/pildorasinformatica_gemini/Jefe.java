
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public class Jefe extends Empleado {
    private final double BONUS_PRIMA = 2000;
    private String departamento;
    private double sueldoBase;
    
    public Jefe (String nombre, int edad, double sueldo){
        super(nombre, edad, sueldo);
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    
    public String getDepartamento(){
        return this.departamento;
    }

    @Override
    public double establecerBonus(double gratificacion) {
        return super.establecerBonus(gratificacion) + this.BONUS_PRIMA;
    }
}
