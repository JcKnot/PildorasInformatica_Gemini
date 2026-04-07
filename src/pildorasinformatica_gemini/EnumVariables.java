
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public enum EnumVariables {
    // 1. Los "registros" de tu enum. Al terminar la lista, usa punto y coma (;)
    VERSION_COMPILACION("v1.0"),
    TITULO_APP("Sistema de Gestión de Recursos Humanos"),
    TITULO_MODULO_GESTION("Gestión de Personal"),
    TITULO_MODULO_AUDITORIA("Auditoría"),
    SUELDO_MINIMO("1000"),
    IMAGEN_USUARIO("src/pildorasinformatica_gemini/userimage.png"),
    FONDO_CABECERA("src/pildorasinformatica_gemini/malla2.png"),
    VENTANA_REDIMENSIONABLE(true);

    // 2. El atributo (como la columna de una tabla). Lo ponemos 'final' porque es una constante.
    private final String valor;
    private final boolean valorBoolean;

    // 3. El constructor (Privado por defecto). Es lo que recibe el "v1.0".
    private EnumVariables(String valor) {
        this.valor = valor;
        this.valorBoolean = false;
    }
    
    private EnumVariables(boolean valorBoolean) {
        this.valorBoolean = valorBoolean;
        this.valor = null;
    }

    // 4. El método Getter (Para extraer el dato)
    public String getValor() {
        return valor;
    }
    
    public boolean getValorBoolean() {
        return this.valorBoolean;
    }
}
