# Estado: ✅ CERRADO Y APROBADO — 2026-06-19

### 📊 Reto Integrador: Centro de Comando con Barra de Herramientas Dinámica (JToolBar)

**Contexto del Negocio:**
El centro de comando central (`MarcoCentradoComando`) actúa como la central de control del software. Actualmente, todas las ventanas secundarias (Ver Perfiles, Registro de Credenciales, Gestión de Contratos, Abrir Editor, etc.) se abren exclusivamente desde el menú superior "Gestión". Para mejorar la accesibilidad (UX) y agilizar la navegación de los operadores senior, se nos ha solicitado agregar una barra de herramientas (`JToolBar`) en la parte superior que exponga accesos directos rápidos a estas mismas funciones compartiendo la misma lógica.

**Tu Misión:**
Refactorizar la estructura de `MarcoCentradoComando` implementando un `JToolBar` en la parte superior. Para evitar duplicidad de código y lograr un desacoplamiento limpio, debes encapsular la lógica de apertura de estas ventanas en objetos que hereden de `AbstractAction`. Luego, utilizarás estas mismas acciones tanto para poblar el menú "Gestión" como para poblar la barra de herramientas.

---

### 📋 Checklist de Criterios de Aceptación

- [x] **Desacoplamiento mediante Clases de Acción (Action):**
    - Crear clases internas privadas en `MarcoCentradoComando` que extiendan de `AbstractAction` para encapsular la apertura de las siguientes ventanas secundarias:
        - **AccionPerfiles**: Abre `MarcoPerfilEmpleado`.
        - **AccionContratos**: Abre `MarcoContrato`.
        - **AccionEditor**: Abre `MarcoEditor`.
- [x] **Integración en Barra de Menú (JMenuBar):**
    - Modificar el menú "Gestión" para que sus ítems se construyan a partir de estas nuevas clases de acción (ej. `new JMenuItem(accionPerfiles)` o agregando la acción directamente).
- [x] **Estructura y Posicionamiento de la Barra (JToolBar):**
    - Instanciar un `JToolBar` como variable de clase privada.
    - Asegurar que la ventana principal (`MarcoCentradoComando`) use `BorderLayout` como su gestor de diseño principal.
    - Posicionar la barra de herramientas en la región norte (`BorderLayout.NORTH`) y la lámina existente en el centro (`BorderLayout.CENTER`).
- [x] **Configuración e Iconografía en la Barra:**
    - Agregar las acciones creadas al `JToolBar` utilizando el método `.add(Action)`.
    - Capturar la referencia de los `JButton` resultantes para configurarlos visualmente:
        - Asignar tooltips descriptivos usando `.setToolTipText(...)`.
        - Si decides ocultar el texto en el botón de la barra para ahorrar espacio, asegúrate de que el botón siga siendo funcional y reconocible (puedes usar un texto corto descriptivo o desactivar el texto).
    - Insertar un separador `.addSeparator()` dentro de la barra de herramientas para agrupar lógicamente las acciones operativas (Perfiles y Contratos) separadas del Editor de textos.
- [x] **Gestión de Comportamiento:**
    - Configurar la propiedad `setFloatable(true)` o `false` para definir si el usuario puede desacoplar y arrastrar la barra de herramientas, justificando la decisión en un comentario de código.
- [x] **Estándares Profesionales (Auditoría):**
    - Todos los componentes y variables de clase deben ser rigurosamente `private` (encapsulamiento).
    - Métodos e interfaces sobrescritas deben llevar la anotación `@Override`.
    - Respetar la nomenclatura estándar (`PascalCase` para clases y `camelCase` para métodos/variables).
