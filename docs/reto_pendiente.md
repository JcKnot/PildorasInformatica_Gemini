# Estado: CERRADO Y APROBADO

### 🏢 Reto Integrador: Terminal de Gestión de Contratos (Clases 93-95)

**Contexto del Negocio:**
El departamento de Recursos Humanos necesita estandarizar la forma en que se ingresan los datos contractuales de los empleados, evitando errores de tipeo y selecciones imposibles (como ser "Freelance" y "Tiempo Completo" a la vez). 

**Tu Misión:**
Implementar un módulo de "Gestión de Contratos" usando menús desplegables para los cargos y botones de radio mutuamente excluyentes para las condiciones laborales.

### 📋 Checklist de Criterios de Aceptación

- [x] **Arquitectura y Limpieza:** Crear las clases `MarcoContrato` y `LaminaContrato` en el paquete `pildorasinformatica_gemini`. Seguir el patrón de diseño donde el `JFrame` hospeda al `JPanel`.
- [x] **Integración en Sistema:** Añadir un botón "Gestión de Contratos" en el `MarcoCentradoComando` para abrir este módulo (`DISPOSE_ON_CLOSE`).
- [x] **Menú Desplegable (JComboBox):** 
    - Añadir un `JComboBox` llamado "Cargo" con al menos 4 opciones (Ej: Junior, Semi-Senior, Senior, Arquitecto).
    - Configurar el combo con `setEditable(true)` por si RRHH necesita escribir un cargo especial que no está en la lista.
- [x] **Grupos de Selección Excluyente (JRadioButton):**
    - Crear un grupo para la **Jornada**: "Tiempo Completo", "Medio Tiempo".
    - Crear un segundo grupo independiente para la **Ubicación**: "Remoto", "Híbrido", "Oficina".
    - *Crucial:* Debes instanciar dos objetos `ButtonGroup` distintos para que la selección de Jornada no interfiera con la de Ubicación.
- [x] **Requisito Senior (Refactorización DRY):** En lugar de instanciar cada `JRadioButton` repitiendo 4 líneas de código, debes crear un método privado de apoyo (ej. `private void agregarBotonRadio(...)`) que reciba el texto, el estado, el `ButtonGroup` y el contenedor, centralizando la creación del componente (como viste en la Clase 94).
- [x] **Resumen Reactivo (Casting y GetSource):** 
    - Crea una etiqueta (`JLabel`) en la parte inferior llamada "Resumen del Contrato".
    - Añade eventos a tus componentes de modo que cuando se seleccione algo, la etiqueta se actualice (Ej: "Contrato: Senior - Medio Tiempo - Remoto").
    - *Recuerda:* Deberás usar un Casting `(String)` para extraer el texto del `JComboBox`.
- [x] **Estándares Profesionales:** Validar uso de `private`, anotaciones `@Override` y nomenclaturas correctas.
