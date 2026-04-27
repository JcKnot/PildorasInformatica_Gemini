# Contexto de Sesión - Antigravity (Asistente Integrado)

Este archivo sirve para transferir "la memoria" o contexto de nuestro trabajo a otra computadora. 

**Instrucción para la IA en la nueva PC:** 
Si estás leyendo esto recién iniciada la conversación, por favor asimila este contexto y pregúntale al usuario por dónde quiere continuar.

---

## Estado Actual del Proyecto
* **Proyecto:** `PildorasInformatica_Gemini` (Java en entorno NetBeans / Windows).
* **Diario de Aprendizaje:** El repositorio cuenta con el archivo `docs/aprendizaje.md` que detalla minuciosamente el avance del usuario.
* **Clase 77-80:** ✅ Finalizada por completo. Reto Broadcast superado usando un bucle `for-each` e inyección de colecciones. Limpieza de código: uso del operador diamante `<>` y eliminación de variables no leídas.
* **Clases 81-85 (Gestores de Diseño - Layouts):** 🚧 En Progreso (Práctica Extendida). 
  * Se auditó y corrigió el proyecto de la Calculadora (bug lógico de evaluación de operaciones).
  * Se superó un CodeChallenge externo sobre Scope de variables locales (`private` vs `final`) y cálculos con decimales.
  * Se construyó exitosamente un teclado numérico (`PanelSeguridad`) combinando `BorderLayout` y `GridLayout`.
  * **Hito Arquitectónico Alcanzado:** Identificación y corrección de un Anti-Patrón (Instanciar un `JFrame` dentro de otro `JFrame`). Se refactorizó la arquitectura para extraer la `LaminaSeguridad` (JPanel) e inyectarla en la clase `TerminalEmpleado`.
* **Entorno MCP:** El servidor NotebookLM MCP fue estabilizado. Se reemplazó la librería `undetected_chromedriver` por Selenium estándar con perfil persistente, se añadieron tuberías de depuración remota para soportar modo "headless", y se silenció el banner interno de FastMCP.

## ⚡ Reglas Estrictas de Interacción (Modo Tutor Activo)
**¡IMPORTANTE PARA LA IA QUE LEA ESTO!** 
El usuario está aquí para **APRENDER A PROGRAMAR**, no para que le escriban el código. Tu comportamiento debe ser el siguiente:
1. **Cero código resuelto por defecto:** NO debes escribir ni modificar el proyecto para resolverle los ejercicios a menos que el usuario lo solicite explícitamente.
2. **Método Socrático:** Si se encuentra un bug o bloqueo, da pistas, señala la línea sospechosa o explica la teoría que falla, pero fomenta que el usuario teclee la solución.
3. **Sincronización:** Cada hito de aprendizaje debe registrarse en `aprendizaje.md` y este archivo de sesión.

## Siguiente Acción Pendiente (Next Action)
* El usuario ha decidido **NO dar por cerrado el bloque de Layouts (Clases 81-85)** todavía.
* El objetivo a corto plazo es generar o continuar con **nuevos retos y prácticas** que apliquen combinaciones y anidamientos de `Layouts` dentro del proyecto corporativo `pildorasinformatica_gemini` para consolidar el conocimiento espacial en Java Swing antes de avanzar.
