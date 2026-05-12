# Estado: PENDIENTE DE IMPLEMENTACIÓN Y EVALUACIÓN

### 📜 Reto Integrador: Terminal de Biografía y Formato Avanzado (Clases 90-92)

**Contexto del Negocio:**
Para mejorar la presencia digital de los empleados en la intranet corporativa, se requiere un módulo que permita redactar una biografía profesional y personalizar su formato visual de manera interactiva.

**Tu Misión:**
Implementar un editor de biografía reactivo que utilice áreas de texto con desplazamiento y controles de estilo dinámico mediante casillas de verificación.

### 📋 Checklist de Criterios de Aceptación

- [ ] **Arquitectura y Limpieza:** Crear las clases `MarcoConfigPerfil` y `LaminaConfigPerfil` en el paquete `pildorasinformatica_gemini`. Seguir el patrón de diseño donde el `JFrame` solo hospeda al `JPanel` principal.
- [ ] **Integración en Sistema:** Añadir un botón funcional en el `MarcoCentradoComando` para abrir este nuevo módulo sin cerrar la aplicación principal (`DISPOSE_ON_CLOSE`).
- [ ] **Componente de Texto Pro:** Implementar un `JTextArea` (8 filas x 20 columnas) para la biografía.
- [ ] **Desplazamiento Dinámico:** El `JTextArea` **debe** estar encapsulado dentro de un `JScrollPane`. No se aceptarán áreas de texto que se desborden sin barras de scroll.
- [ ] **Panel de Preferencias:** Crear un panel de control con tres `JCheckBox`: "Ajuste de Línea", "Negrita" y "Cursiva".
- [ ] **Funcionalidad de Ajuste:** Al accionar "Ajuste de Línea", el texto debe saltar automáticamente al borde del área (`setLineWrap`).
- [ ] **Lógica de Estilo Senior:** 
    - Al marcar/desmarcar los checkboxes de Negrita y Cursiva, la fuente del `JTextArea` debe cambiar en tiempo real.
    - **REQUISITO TÉCNICO:** El cálculo del valor del estilo (Plain, Bold, Italic o Bold+Italic) debe realizarse obligatoriamente mediante el **operador ternario** dentro del evento.
- [ ] **Estándares Profesionales:** Validar el uso de modificadores `private`, anotaciones `@Override` y convenciones de nombres (*camelCase* para variables/métodos y *PascalCase* para clases).
