# Estado: ✅ CERRADO Y APROBADO — 2026-06-17

### 📊 Reto Integrador: Editor Corporativo Avanzado (Menús II)

**Contexto del Negocio:**
El departamento de RRHH está satisfecho con la primera versión del editor de borradores, pero han solicitado mejoras en la Experiencia de Usuario (UX). Quieren visualizar claramente qué estilo y tipografía están activos, estructurar mejor las opciones para que el menú no sea tan largo, y garantizar que la selección de tipografía sea excluyente.

**Tu Misión:**
Refactorizar la barra de menús de la clase `MarcoEditor` utilizando los componentes avanzados de Swing (`JCheckBoxMenuItem`, `JRadioButtonMenuItem`, Menús Anidados y Separadores).

---

### 📋 Checklist de Criterios de Aceptación

- [ ] **Efectos Acumulativos (JCheckBoxMenuItem):**
    - Convertir las opciones de "Negrita" y "Cursiva" del menú "Estilo" para que utilicen la clase `JCheckBoxMenuItem` en lugar del ítem tradicional.
- [ ] **Exclusión Mutua de Fuentes (JRadioButtonMenuItem):**
    - Convertir las opciones de tipografía ("Arial", "Courier", "Verdana") para que utilicen la clase `JRadioButtonMenuItem`.
    - Agrupar obligatoriamente estas tres opciones dentro de un objeto `ButtonGroup` para asegurar que el usuario solo pueda tener seleccionada una fuente visualmente a la vez.
    - Asegurar que la primera fuente de la lista arranque marcada por defecto (`setSelected(true)`).
- [ ] **Anidamiento de Menús (Subcarpetas):**
    - El menú "Fuente" ya no debe contener las tipografías directamente.
    - Crear un submenú (instanciando otro `JMenu`) llamado "Tipografías".
    - Añadir los `JRadioButtonMenuItem` a este submenú "Tipografías", y luego añadir este submenú al menú principal "Fuente".
- [ ] **Organización Visual (Separadores):**
    - Añadir un `addSeparator()` en algún lugar lógico del menú (por ejemplo, debajo del submenú "Tipografías" si decides agregar opciones de "Tamaño" luego, o dentro del menú Estilo).
- [ ] **Refactorización de Lógica de Construcción:**
    - Como ahora tienes diferentes tipos de ítems (`JCheckBoxMenuItem` y `JRadioButtonMenuItem`), analiza si puedes adaptar tu método actual `configuraItemMenu()` o si necesitas separarlo/sobrecargarlo. El objetivo es mantener el código limpio y sin excesiva duplicación.
- [ ] **Estándares Profesionales (Auditoría):**
    - Todos los componentes y variables de clase deben ser rigurosamente `private` (encapsulamiento).
    - Métodos e interfaces sobrescritas deben llevar la anotación `@Override`.
    - Respetar la nomenclatura estándar (`PascalCase` para clases y `camelCase` para métodos/variables).
