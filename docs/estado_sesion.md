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
* El usuario ha decidido **NO dar por cerrado el bloque de Layouts (Clases 81-85)** todavía para consolidar el conocimiento espacial en Java Swing.
* **Reto Activo:** Crear el Módulo de Recursos Humanos (`MarcoPerfilEmpleado.java`).
  * **Propósito Pedagógico:** Consolidar el dominio de los Gestores de Diseño (Clases 81-85) mediante la técnica de "anidamiento de paneles". Demostrar cómo una interfaz compleja se construye dividiéndola en sub-paneles con sus propios Layouts independientes, sin romper la arquitectura existente.
  * **Alcance del Ejercicio:** El desarrollo es exclusivamente **Front-end / Interfaz Visual**. El objetivo es maquetar la estructura espacial de una ficha de empleado. No se requiere persistencia en base de datos; los campos (`JTextField`) solo simularán contener datos. La ventana debe poder abrirse de forma independiente desde el panel central.
  * **Instrucciones Detalladas de Arquitectura:**
    1. **Contenedor Raíz:** Crear la clase `MarcoPerfilEmpleado` (`JFrame`). Instanciar dentro una `LaminaPerfil` (`JPanel`). Aplicar obligatoriamente `setLayout(new BorderLayout())` a esta lámina.
    2. **Construcción del NORTE (Cabecera):** Crear un nuevo `JPanel` secundario. Aplicarle un `FlowLayout` centrado. Añadirle un `JLabel` con formato de título (ej. "Expediente Confidencial"). Anidar este sub-panel en el `BorderLayout.NORTH` de la lámina raíz.
    3. **Construcción del CENTRO (Formulario):** Crear otro `JPanel` secundario. Aplicarle un `GridLayout` de 3 filas y 2 columnas (idealmente con separación, ej. `GridLayout(3, 2, 10, 10)`). Añadir los componentes en pares: `JLabel("Nombre")` + `JTextField(15)`, luego "Sueldo", luego "Departamento". Anidarlo en el `BorderLayout.CENTER`.
    4. **Construcción del SUR (Botonera):** Crear un tercer `JPanel` secundario con `FlowLayout`. Añadir dos `JButton` ("Guardar Cambios", "Cerrar Ficha"). Anidarlo en el `BorderLayout.SOUTH`.
    5. **Integración Final:** Modificar `MarcoCentradoComando` (el panel corporativo principal). Insertar un botón "Consultar Perfiles" y programar su evento para que instancie y muestre el nuevo `MarcoPerfilEmpleado`.
