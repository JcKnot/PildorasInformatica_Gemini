
package pildorasinformatica_gemini;

/**
 *
 * @author slipk
 */
public enum EnumVariables {
    // 1. Los "registros" de tu enum. Al terminar la lista, usa punto y coma (;)
    VERSION_COMPILACION("v1.0"),
    TITULO_APP("Sistema de Gestión de Recursos Humanos");

    // 2. El atributo (como la columna de una tabla). Lo ponemos 'final' porque es una constante.
    private final String valor;

    // 3. El constructor (Privado por defecto). Es lo que recibe el "v1.0".
    private EnumVariables(String valor) {
        this.valor = valor;
    }

    // 4. El método Getter (Para extraer el dato)
    public String getValor() {
        return valor;
    }
}
