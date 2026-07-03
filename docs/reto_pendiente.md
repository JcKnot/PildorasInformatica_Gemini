# Estado: PENDIENTE DE IMPLEMENTACIÓN Y EVALUACIÓN

### 📊 Reto Integrador: Configurador de Alertas de Red (JOptionPane y Box Layout)

**Contexto del Negocio:**
El equipo de operaciones del centro de comando central (`MarcoCentradoComando`) necesita una consola para emitir alertas personalizadas y de prueba a las diferentes terminales de empleados. Se nos ha solicitado desarrollar una interfaz gráfica avanzada llamada `MarcoConfiguradorAlertas` donde el operador pueda estructurar la tipología del mensaje y los botones de respuesta antes de disparar la alerta al sistema.

**Tu Misión:**
Implementar el módulo de configurador de alertas en una nueva ventana secundaria (`MarcoConfiguradorAlertas`) que se abra desde el centro de comando. Utilizarás la clase `Box` para maquetar la UI de forma organizada y simétrica, y la clase `JOptionPane` para capturar e interpretar las respuestas de las ventanas emergentes en tiempo de ejecución.

---

### 📋 Checklist de Criterios de Aceptación

- [ ] **Acceso desde el Centro de Comando:**
    - Agregar una nueva acción `AccionAlertas` (heredando de `AbstractAction`) en `MarcoCentradoComando`.
    - Inyectar esta acción como un ítem en el menú superior "Gestión" y como un nuevo botón en la barra de herramientas `JToolBar`.
    - Esta acción debe instanciar y abrir de manera no bloqueante la ventana `MarcoConfiguradorAlertas`.
- [ ] **Diseño del Panel con Box Layout:**
    - El panel principal de la nueva ventana (`LaminaConfiguradorAlertas`) debe estructurarse utilizando el gestor de diseño por cajas de la clase `Box` (combinando cajas verticales y horizontales).
    - Agrupar los controles visuales en secciones lógicas utilizando bordes o títulos descriptivos (ej: "Tipo de Mensaje", "Opciones de Confirmación").
    - Insertar obligatoriamente espacios rígidos con `Box.createVerticalStrut(...)` o `Box.createHorizontalStrut(...)` para mantener márgenes consistentes entre grupos.
    - Colocar un muelle elástico con `Box.createGlue()` en la parte inferior para empujar el botón de ejecución hacia abajo de forma dinámica cuando la ventana cambie de tamaño.
- [ ] **Consola de Configuración de Alertas:**
    - **Selector de Tipo de Mensaje:** Un grupo de `JRadioButton` excluyentes para elegir el tipo de diálogo (Error, Información, Advertencia, Pregunta) mapeado con las constantes de `JOptionPane` (ej: `ERROR_MESSAGE`, `INFORMATION_MESSAGE`, etc.).
    - **Selector de Tipo de Opción:** Un grupo de `JRadioButton` excluyentes para elegir los botones de confirmación (Aceptar, Sí/No, Sí/No/Cancelar, Aceptar/Cancelar) mapeado con las constantes de `JOptionPane` (ej: `YES_NO_OPTION`, etc.).
- [ ] **Disparo e Interpretación de Diálogos (JOptionPane):**
    - Añadir un botón final que diga "Lanzar Alerta".
    - Al pulsar el botón, se debe invocar a `JOptionPane.showConfirmDialog(...)` o `JOptionPane.showOptionDialog(...)` configurado dinámicamente con las opciones seleccionadas por el administrador en la lámina.
    - El programa debe capturar el entero de retorno del diálogo y evaluar cada caso (incluyendo la constante de ventana cerrada `JOptionPane.CLOSED_OPTION`).
    - Mostrar el resultado de la confirmación elegida (ej: "El administrador ha pulsado: SÍ", o "El diálogo fue cerrado por la X") mediante una etiqueta `JLabel` informativa en el panel de forma persistente.
- [ ] **Estándares Profesionales (Auditoría):**
    - Todos los componentes y variables de clase deben ser estrictamente `private` (encapsulamiento).
    - Métodos e interfaces sobrescritas deben llevar la anotación `@Override`.
    - Respetar la nomenclatura estándar (`PascalCase` para clases y `camelCase` para métodos/variables).
