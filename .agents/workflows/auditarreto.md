---
description: Validar que la implementación del usuario cumple con los estándares de arquitectura y los criterios de aceptación del reto actual.
---

# Workflow: Auditoría Técnica de Retos
**Objetivo:** Validar que la implementación del usuario cumple con los estándares de arquitectura y los criterios de aceptación del reto actual.
## Pasos a seguir:
1. **Lectura de Criterios:** Leer `docs/reto_pendiente.md` para identificar los "Checklist de Criterios de Aceptación" y el contexto del negocio.
2. **Localización de Código:** Buscar en el paquete `pildorasinformatica_gemini` los archivos mencionados en el reto.
3. **Escaneo de Calidad (Checklist Senior):**
    - [ ] **Encapsulamiento:** Validar que todos los componentes (JButton, JTextField, etc.) y variables de clase sean `private`.
    - [ ] **Anotaciones:** Verificar el uso correcto de `@Override` en métodos heredados o de interfaces.
    - [ ] **Nomenclatura:** Clases en `PascalCase`, métodos y variables en `camelCase`.
    - [ ] **Arquitectura:** Comprobar que no haya "Matrioskas de Marcos" (solo debe haber un JFrame principal y el resto deben ser JPanels inyectados).
4. **Validación de Lógica Específica:**
    - Revisar que se haya usado la técnica solicitada (ej. Operador Ternario, DocumentListener, Arrays.fill para RAM, etc.).
5. **Feedback Técnico:**
    - **Aciertos:** Destacar partes del código que demuestren buenas prácticas.
    - **Refactorización Senior (OBLIGATORIO):** Proponer siempre 2 o 3 mejoras de "limpieza", optimización o patrones de diseño, incluso si el código funciona perfectamente.
    - **Puntos de Mejora (Errores):** Si algo falta o está mal, NO dar la solución. Hacer una pregunta socrática o dar una pista técnica para que el usuario lo corrija.
6. **Actualización de Documentación:**
    - Si todo es correcto, marcar con `[x]` los criterios en `docs/reto_pendiente.md` y cambiar el estado a "CERRADO Y APROBADO".