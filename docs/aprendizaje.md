# Diario de Aprendizaje: Java

Este archivo centraliza los conceptos clave, apuntes y ejercicios de mi curso de Java, provenientes de las clases de Píldoras Informáticas y el soporte de mi IA colaboradora.

## Notas y Conceptos Clave

### 🧱 Módulo 1: Fundamentos, Sintaxis y Memoria (Clases 4 - 13)
- **Inmutabilidad de `String`:** Las cadenas no se pueden modificar en memoria (no aceptan `UPDATE`). Al concatenar en un bucle, se crean múltiples objetos nuevos en el **Heap** (`INSERT`), dejando los anteriores sin referencia para que el *Garbage Collector* los elimine.
- **Inferencia de Tipos (`var`):** El compilador deduce el tipo de dato basándose en la inicialización. **Regla de Arquitectura:** No se recomienda su uso con el operador diamante (`<>`) en colecciones, ya que infiere el tipo genérico `Object` y rompe la seguridad de tipos.
- **Casting de Datos:** - *Implícito (Widening):* Automático y seguro (ej. pasar de `int` a `double`).
    - *Explícito (Narrowing):* Requiere forzarlo manualmente con `(tipo)` (ej. de `double` a `int`). Conlleva un alto riesgo de pérdida de precisión (truncamiento de decimales).
- **Modificadores Clave (`final` y `static`):**
    - `final`: Funciona como un constraint `READ ONLY`; garantiza que el valor de la variable no sea reasignado.
    - `static`: Indica que un método (como los de la clase `Math`) pertenece a la **Clase** (la tabla general) y no a la **Instancia** (una fila específica), permitiendo su ejecución sin necesidad de instanciar un objeto con `new`.

### 🚦 Módulo 2: Control de Flujo e Interactividad (Clases 14 - 22)
- **Estrategias de Entrada (I/O):** - `Scanner`: Lectura secuencial conectada al flujo `System.in` (ideal para *backend* o ingesta por consola).
    - `JOptionPane`: Interacción mediante interfaces gráficas y ventanas emergentes como `showInputDialog` (ideal para *frontend* rápido).
- **Parsing vs. Casting:** Diferencia arquitectónica vital. No se puede "castear" (copiar bits de un tipo a otro) de un objeto `String` a un primitivo numérico. Se requiere un proceso de "Parsing" (traducción de datos) usando métodos estáticos como `Integer.parseInt()`.
- **Operador Ternario (`? :`):** Herramienta de *Clean Code* con sintaxis compacta (`condición ? valor_true : valor_false`) para simplificar y reemplazar estructuras `if-else` en asignaciones simples.
- **Control con `switch` y *Fall-through*:** Uso crítico de la instrucción `break`. Omitirla provoca un efecto "fall-through" (ejecución en cascada), donde el flujo atraviesa los siguientes casos sin evaluar sus condiciones, generando bugs lógicos.
- **Arquitectura de Iteradores (Bucles):**
    - `while`: Evaluación en la cabecera (pre-condición). El bloque de código podría no ejecutarse jamás.
    - `do-while`: Evaluación en la base (post-condición). Garantiza por diseño al menos una ejecución obligatoria.
    - `for`: Estructura determinista. Uso obligatorio cuando el límite numérico, los pasos o el rango de iteraciones se conocen de antemano.

### 🛠️ Módulo 3: Arquitectura, Gráficos y Optimización Swing (Clases 53 - 64)
- **Clases Internas de Miembro:** Permiten que una clase secundaria acceda a los campos privados de la clase externa sin necesidad de métodos públicos.
- **Clases Internas Locales:** Se declaran dentro de un método. Son ideales para tareas que solo tienen sentido durante la ejecución de ese método (ej. una auditoría rápida).
- **Enums con Tipado Fuerte:** Uso de constructores en Enums para almacenar diferentes tipos de datos (como el título de la app en `String` y si es redimensionable en `boolean`) en un solo lugar centralizado (`EnumVariables.java`).
- **Toolkit:** Clase del sistema que sirve de puente con el SO para obtener dimensiones de pantalla o iconos del sistema.
- **Casting a Graphics2D:** Para acceder a la API moderna de dibujo, debemos transformar el objeto `Graphics` básico: `Graphics2D g2 = (Graphics2D) g;`.
- **Figuras `geom`:** Uso de `Rectangle2D.Double` y `Ellipse2D.Double` para trabajar con coordenadas decimales (`double`), lo que evita errores de redondeo al escalar.
- **Carga de Imágenes (`ImageIO`):** Uso de la clase `ImageIO` para leer archivos. Requiere obligatoriamente un bloque `try-catch` para manejar la excepción `IOException`.

### ⚡ Módulo 4: Programación Dirigida por Eventos I (Clases 65 - 70)
- **Modelo de Delegación:** El flujo interactivo requiere tres piezas: Fuente (`JButton`), Evento (`ActionEvent`) y Oyente (`ActionListener`).
- **Interfaces Listener:** Un oyente DEBE implementar el método obligatorio `actionPerformed(ActionEvent e)` marcado con `@Override`.
- **Arquitectura de Oyentes (Best Practice):** Usar **Clases Internas Privadas** para que el oyente pueda manipular la interfaz (ej. `setBackground`) sin romper el encapsulamiento.
- **El Ciclo Gráfico y los Eventos (`repaint()`):** Cuando un evento modifica una variable (estado) que es utilizada para dibujar figuras o textos en el `paintComponent`, se debe invocar explícitamente al método `repaint()`.

### ⌨️ Módulo 5: Eventos de Periféricos II (Clases 71 - 73)
- **Teclado (`KeyListener` y `KeyAdapter`):**
    - Genera un flujo de tres fases: `keyPressed` (tecla baja), `keyReleased` (tecla sube) y `keyTyped` (generación de carácter imprimible).
    - **Primary Key:** Identificamos teclas con `e.getKeyCode()` y constantes (`KeyEvent.VK_A`).
- **Ratón (`MouseListener` y `MouseAdapter`):**
    - Triggers espaciales: `mousePressed`, `mouseReleased`, `mouseClicked`, `mouseEntered` y `mouseExited`.
    - **Extracción de Métricas:** Coordenadas con `e.getX()` / `e.getY()` y agresividad con `e.getClickCount()`.
- **Sincronización Híbrida (Reto Boss):** Coordinación de múltiples periféricos a través de una variable de estado booleana que condiciona el redibujado de la interfaz.

---

## 🛠️ Notas Técnicas Avanzadas (Best Practices)

* **Polimorfismo en Colecciones:** Al recuperar un objeto de un `ArrayList` genérico, el compilador lo trata como tipo `Object` [23, 24]. Es necesario realizar un **Casting** seguro (a menudo usando `instanceof`) para recuperar las capacidades específicas de la subclase [25, 26].
* **Jerarquía del Lienzo:** La llamada a `super.paintComponent(g)` es innegociable; su función es limpiar el lienzo de "restos" visuales antes de que el nuevo frame se dibuje [18, 27].
* **Integridad y Excepciones:** Aplicación obligatoria de bloques **try-catch** al usar `ImageIO.read()`. Comprendo que sin este manejo, una `IOException` (archivo faltante) detendría la ejecución del hilo de renderizado [19, 20].
* **Metáfora de Optimización (Visión DBA):** * **Constructor:** Cargar recursos aquí actúa como una "caché" o `SELECT` único [19].
    * **PaintComponent:** Cargar recursos aquí es como un `SELECT` dentro de un cursor infinito, lo que satura la CPU innecesariamente [17, 21].
* **Mosaicos Eficientes:** Uso de `copyArea()` con incrementos de bucle iguales al ancho de la imagen (`i += width`) para evitar redundancia de procesamiento píxel a píxel [19, 22].
* **Foco del Teclado:** Un componente solo escuchará los eventos de teclado si tiene el "foco" activo del sistema.

---

## 🧠 Registro de Auto-Exámenes (Knowledge Checks)

Esta sección documenta la validación de conceptos teóricos y técnicos más allá de la implementación del código.

### 🏁 Módulo 0: Fundamentos y Gestión de Memoria
* **Gestión de Memoria (Stack vs. Heap):** Comprendo que las variables locales y referencias viven en el **Stack**, mientras que todos los objetos nacen en el **Heap** [1, 2]. Las variables de instancia (atributos) residen dentro del objeto en el Heap, no en el Stack [3, 4].
* **El Contrato de Paso por Valor:** Java **siempre pasa por valor** (copia de bits) [5, 6]. 
    * En primitivos, se copia el valor real.
    * En objetos, se copia la **referencia** (el "control remoto"), lo que permite alterar el objeto original pero no reasignar la variable externa a un nuevo objeto [7, 8].
* **Arquitectura POO (IS-A vs. HAS-A):** Uso la prueba **IS-A** para la herencia (`extends`) y la prueba **HAS-A** para la composición (variables de instancia) [5, 9]. Ejemplo: Un `Jefe` IS-A `Empleado`; un `JFrame` HAS-A `JPanel` [10, 11].
* **Interfaces y el "Diamante de la Muerte":** Entiendo que Java prohíbe la herencia múltiple de clases para evitar la ambigüedad de métodos (Diamante de la Muerte) [12, 13]. Las **Interfaces** resuelven esto permitiendo que una clase juegue múltiples "roles" sin conflictos de implementación [14, 15].

### 🧱 Módulo 1: Sintaxis, Memoria y API (Clases 4-13)
* **Inmutabilidad de String:** Los `String` son inmutables. En un bucle de 10 concatenaciones, no se hace un `UPDATE` en memoria, sino que se generan 11 objetos distintos (10 `INSERT` nuevos). La variable original simplemente actualiza su puntero al último objeto creado.
* **Inferencia de Tipos (`var`):** Java sigue siendo de tipado fuerte. Al usar `var`, el compilador determina el tipo basándose en el valor asignado en la inicialización (ej. `var cadena = "esto"` se compila estrictamente como `String`).
* **Constantes (`final`):** Funciona como un constraint `READ ONLY`. Garantiza que una variable no pueda ser reasignada. Si se intenta alterar, el compilador bloquea la ejecución.
* **Casting y Precisión:** * *Implícito (Widening):* De un tipo menor a uno mayor (ej. `int` a `double`), es seguro.
    * *Explícito (Narrowing):* De un tipo mayor a uno menor (ej. `double` a `int`), obliga a usar el operador `(int)` y conlleva el riesgo de pérdida de datos (truncamiento de decimales).
* **Comparación de Objetos (`==` vs `.equals`):** El operador `==` evalúa el `ROWID` (la dirección en memoria / referencia). Para los `String`, es un error lógico usarlo si queremos validar el contenido. Siempre se debe usar `.equals()` para comparar el valor real de los datos.
* **Métodos Estáticos (Clase `Math`):** El modificador `static` permite que un método pertenezca a la "Tabla" (Clase) y no a la "Fila" (Instancia). Por lo tanto, se pueden invocar directamente (ej. `Math.PI`) sin necesidad de usar `new` para crear un objeto.
*(Calificación Auto-Examen: 100% - 6/6)*

### 🔀 Módulo 2: Control de Flujo e I/O (Examen: 95%) (Clases 14-22)
* **Interfaces de Entrada (`Scanner` vs `JOptionPane`):** Diferencia arquitectónica asimilada. `Scanner` lee secuencias planas de la consola (ideal para procesos batch/backend), mientras que `JOptionPane` dispara cuadros de diálogo gráficos para interacción visual (*frontend* rápido).
* **Parsing vs. Casting (Lección Clave):** Comprendo la imposibilidad de "castear" un objeto `String` a un primitivo numérico. Para extraer un entero de un texto, es obligatorio usar un proceso de traducción (Parsing) invocando el método estático `Integer.parseInt(variableString)`.
* **Operador Ternario (`? :`):** Asimilado como la herramienta de *Clean Code* óptima para asignaciones y retornos binarios en una sola línea (`condición ? valor_true : valor_false`), evitando la verbosidad de un `if-else`.
* **Switch y el efecto *Fall-through*:** Entiendo el riesgo de omitir el `break`. Si no se detiene el flujo, el motor de Java "caerá" (*fall-through*) y ejecutará todo el código de los `case` posteriores sin evaluar sus condiciones, causando bugs lógicos.
* **Estrategia de Bucles:**
    * **Ejecución garantizada:** El bucle `do-while` ejecuta su bloque al menos una vez antes de evaluar la condición en la base. El `while` tradicional podría no ejecutarse nunca.
    * **Iteraciones deterministas:** El bucle `for` es la elección lógica cuando el rango y el número exacto de ejecuciones a realizar son conocidos desde el principio.

### 🖼️ Módulo 3: Swing, Gráficos y Optimización (Clases 53-64)
* **Encapsulamiento de Lógica:** Implementación de **Clases Internas Locales** dentro de métodos para blindar procesos que no deben ser accesibles desde fuera del alcance del método (ej. Auditoría en `Empleado.java`) [4, 16].
* **Evolución Gráfica (Graphics2D):** Dominio del **Casting de Objetos** de `Graphics` a `Graphics2D` para acceder a la API de geometría avanzada (`java.awt.geom`) y precisión con tipos `double` [17, 18].
* **Integridad y Excepciones:** Aplicación obligatoria de bloques **try-catch** al usar `ImageIO.read()`. Comprendo que sin este manejo, una `IOException` (archivo faltante) detendría la ejecución del hilo de renderizado [19, 20].
* **Metáfora de Optimización (Visión DBA):** * **Constructor:** Cargar recursos aquí actúa como una "caché" o `SELECT` único [19].
    * **PaintComponent:** Cargar recursos aquí es como un `SELECT` dentro de un cursor infinito, lo que satura la CPU innecesariamente [17, 21].
* **Mosaicos Eficientes:** Uso de `copyArea()` con incrementos de bucle iguales al ancho de la imagen (`i += width`) para evitar redundancia de procesamiento píxel a píxel [19, 22].

### ⚡ Módulo 4: Eventos y Arquitectura Reactiva (Clases 65-70)
* **Delegación:** ✅ Completado. Comprensión del trípode Fuente-Evento-Oyente.
* **Auditoría de Estados:** Uso de `WindowStateListener` y constantes de `Frame` (ej. `ICONIFIED`) para registrar comportamientos del sistema.
* **Acceso VIP:** Las clases internas permiten al oyente alterar el back-end gráfico sin exponer variables públicas.

### 🎯 Módulo 5: Periféricos y Retos Boss (Clases 71-73)
* **Limpieza Estructural:** Entiendo por qué extender de Clases Adaptadoras (`KeyAdapter`, `MouseAdapter`) es superior a implementar interfaces completas cuando solo necesito auditar un evento.
* **Sincronización Híbrida:** Capacidad validada para construir sistemas reactivos complejos leyendo múltiples estados de periféricos (Ratón + Teclado) simultáneamente.

---

## Errores Comunes y Soluciones 💡

| Error / Problema | Causa Raíz | Solución Técnica |
| :--- | :--- | :--- |
| El color azul se ve negro. | Valores RGB muy oscuros. | Aumentar el canal azul para mayor visibilidad. |
| Ventana lenta o "congelada". | Bucle de mosaico `i++` o lecturas a disco en el Paint. | Cargar recursos en el constructor y usar incremento `i += width`. |
| El botón no reacciona. | La fuente es "sorda". | Olvido de conectar el botón mediante `addActionListener()`. |
| La variable cambia pero el dibujo no. | El método de dibujo no se volvió a ejecutar automáticamente. | Llamar a `repaint()` justo después de cambiar la variable. |

---

## Ejercicios
- [x] **Clase 54-55:** Lógica de Auditoría con clases internas.
- [x] **Clase 58-59:** Marco Centrado dinámico (`Toolkit`).
- [x] **Clase 60-61:** Header Corporativo (`Graphics2D`).
- [x] **Clase 62-64:** Avatar y Textura con rendimiento optimizado.
- [x] **Clase 65-67:** Selector interactivo de Entornos y Título Dinámico (`repaint()`).
- [x] **Clase 68-70:** Auditoría de seguridad con `WindowStateListener` y optimización de código con `WindowAdapter`.
- [x] **Clase 71-73:** Modo Administrador (Teclado) y Rastreador de Coordenadas (Ratón) mediante Adaptadores.
- [x] **Reto Boss Módulo 5:** Sistema Anti-AFK con lógica coordinada de periféricos, variables de estado y geo-fencing.

---

## Progreso
- [x] **Módulo 1:** Fundamentos, Sintaxis y Memoria (Clases 4-13)
- [x] **Módulo 2:** Control de Flujo e I/O (Examen 95% completado)
- [x] **Módulo 3:** Cimientos Swing, Gráficos y Recursos (Clases 53-64)
- [x] **Módulo 4:** Eventos I - Botones y Ventanas (Clases 65-70)
- [x] **Módulo 5:** Eventos II - Teclado y Ratón (Clases 71-73 y Retos completados)
- [ ] **Módulo 6:** Eventos de Foco y Múltiples Fuentes (Siguiente: Clase 74+)