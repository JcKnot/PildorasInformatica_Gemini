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

### 🧮 Módulo 3: Manejo de Arrays y Estructuras Indexadas (Clases 23 - 26)
- **Instanciación y Heap:** Los arrays no son simples listas; son objetos de longitud inmutable que residen en el **Heap**. Declarar la variable (Stack) no reserva el espacio físico de los elementos; es necesario usar `new` para la reserva inicial y, en caso de arrays de objetos, instanciar cada posición individualmente para evitar una `NullPointerException`.
- **Bucle for-each (Optimización):** Estándar de arquitectura para lectura. Mitiga errores "Off-by-one" al abstraer la gestión de índices y evitar desbordamientos accidentales.
- **Arrays Bidimensionales (Matrix Logic):** Evolución de lógica lineal a matricial (tablas relacionales). Permite gestionar dimensiones complejas mediante punteros y offsets.

### 🏗️ Módulo 4: Fundamentos de POO y Gestión de Memoria (Clases 27 - 39)
- **Ciclo de Vida en el Heap:** Los objetos nacen en el Heap; las referencias (punteros) en el Stack. El *Paso por Valor* significa que copiamos la referencia, permitiendo modificar el objeto original pero no reasignarlo externamente.
- **Relaciones de Arquitectura:** Uso riguroso de **IS-A** (Inheritance) y **HAS-A** (Composition). 
- **Protocolo de Construcción (Hallazgo de Auditoría):** Se ha identificado la necesidad de migrar de la dependencia de *Setters* hacia **Constructores con Parámetros** para garantizar la integridad del objeto desde su nacimiento.
- **Variables Locales vs Instancia:** Las variables de instancia reciben valores por defecto (0, null, false); las locales **obligan** a una inicialización manual antes de su uso.


### 🛠️ Módulo 5: Arquitectura, Gráficos y Optimización Swing (Clases 53 - 64)
- **Clases Internas de Miembro:** Permiten que una clase secundaria acceda a los campos privados de la clase externa sin necesidad de métodos públicos.
- **Clases Internas Locales:** Se declaran dentro de un método. Son ideales para tareas que solo tienen sentido durante la ejecución de ese método (ej. una auditoría rápida).
- **Enums con Tipado Fuerte:** Uso de constructores en Enums para almacenar diferentes tipos de datos (como el título de la app en `String` y si es redimensionable en `boolean`) en un solo lugar centralizado (`EnumVariables.java`).
- **Toolkit:** Clase del sistema que sirve de puente con el SO para obtener dimensiones de pantalla o iconos del sistema.
- **Casting a Graphics2D:** Para acceder a la API moderna de dibujo, debemos transformar el objeto `Graphics` básico: `Graphics2D g2 = (Graphics2D) g;`.
- **Figuras `geom`:** Uso de `Rectangle2D.Double` y `Ellipse2D.Double` para trabajar con coordenadas decimales (`double`), lo que evita errores de redondeo al escalar.
- **Carga de Imágenes (`ImageIO`):** Uso de la clase `ImageIO` para leer archivos. Requiere obligatoriamente un bloque `try-catch` para manejar la excepción `IOException`.

### ⚡ Módulo 6: Programación Dirigida por Eventos I (Clases 65 - 70)
- **Modelo de Delegación:** El flujo interactivo requiere tres piezas: Fuente (`JButton`), Evento (`ActionEvent`) y Oyente (`ActionListener`).
- **Interfaces Listener:** Un oyente DEBE implementar el método obligatorio `actionPerformed(ActionEvent e)` marcado con `@Override`.
- **Arquitectura de Oyentes (Best Practice):** Usar **Clases Internas Privadas** para que el oyente pueda manipular la interfaz (ej. `setBackground`) sin romper el encapsulamiento.
- **El Ciclo Gráfico y los Eventos (`repaint()`):** Cuando un evento modifica una variable (estado) que es utilizada para dibujar figuras o textos en el `paintComponent`, se debe invocar explícitamente al método `repaint()`.

### ⌨️ Módulo 7: Eventos de Periféricos II (Clases 71 - 73)
- **Teclado (`KeyListener` y `KeyAdapter`):**
    - Genera un flujo de tres fases: `keyPressed` (tecla baja), `keyReleased` (tecla sube) y `keyTyped` (generación de carácter imprimible).
    - **Primary Key:** Identificamos teclas con `e.getKeyCode()` y constantes (`KeyEvent.VK_A`).
- **Ratón (`MouseListener` y `MouseAdapter`):**
    - Triggers espaciales: `mousePressed`, `mouseReleased`, `mouseClicked`, `mouseEntered` y `mouseExited`.
    - **Extracción de Métricas:** Coordenadas con `e.getX()` / `e.getY()` y agresividad con `e.getClickCount()`.
- **Sincronización Híbrida (Reto Boss):** Coordinación de múltiples periféricos a través de una variable de estado booleana que condiciona el redibujado de la interfaz.

### 🎯 Módulo 8: Foco, Múltiples Fuentes y Seguridad (Clases 74 - 76)
- **Foco de Componente (`FocusListener`):** Gestión de la atención del teclado entre `JTextField`. El método `focusLost` es el lugar crítico para realizar validaciones en tiempo real (ej. comprobar si un campo está vacío o cumple un formato).
- **Identificación de Origen (`getSource()`):** Técnica para centralizar la lógica. Un solo objeto oyente puede vigilar múltiples componentes; usamos `e.getSource() == variable` para determinar qué campo disparó el evento.
- **Foco de Ventana (`WindowFocusListener`):** Supervisión a nivel de aplicación. Detecta cuándo el usuario "entra" o "sale" de la ventana (`windowGainedFocus` / `windowLostFocus`), permitiendo implementar protocolos de seguridad o pausa automática.

### 🛰️ Módulo 9: Arquitectura de Eventos y Patrones de Difusión (Clases 77 - 80)
- **Interfaz `Action` y `AbstractAction`:** Evolución profesional de los oyentes. Permite encapsular la lógica (cambio de color, borrado) junto con sus atributos (nombre, icono, tooltip) en un solo objeto.
- **Múltiples Fuentes (Binding):** Técnica para que un botón y un atajo de teclado (`KeyStroke`) disparen la misma acción sin duplicar código.
- **Estructura de Mapas Swing:** 
    - `InputMap`: Relaciona la entrada física (tecla) con un ID simbólico.
    - `ActionMap`: Relaciona ese ID simbólico con el objeto `Action` real.
- **Difusión (Single Source -> Multiple Listeners):** Arquitectura donde un solo componente (ej: Botón "Cerrar Todo" o "Alerta General") notifica a una colección de objetos independientes para que reaccionen simultáneamente.


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

### 🧮 Módulo 3: Arrays y Estructuras Estáticas (Certificado 100%) (Clases 23-26)
* **Control de Límites:** Dominio de la propiedad `.length`. Comprendo que cualquier acceso fuera del rango [0, length-1] dispara una `IndexOutOfBoundsException` (una violación crítica de arquitectura).
* **Stack vs. Heap (Referencias):** Entiendo que la variable del array es un **Reference Type** (dirección de memoria en el Stack) y el contenido real vive en el Heap.
* **Prevención de NullPointerException:** He validado que instanciar el contenedor (el "estacionamiento") no instanciar de forma automática los objetos que contiene. Se requiere un bucle de instanciación específico.
*(Calificación: 100% - APROBADO Y SELLADO)*

### 🏗️ Módulo 4: Fundamentos de POO (Clases 27-39)
* **Status Auditoría:** ✅ Validado el dominio del control de memoria (Stack/Heap) y evaluación del Paso por Valor en Objetos.
* **Vacío Técnico Detectado:** Riesgo en la inicialización de estado por exceso de uso de "Setters". Se debe priorizar el **Encadenamiento de Constructores** y el uso de constructores con parámetros obligatorios.

### 🧬 Módulo 5: POO Avanzada e Interfaces (Pendiente de Examen Práctico) (Clases 40-54)
* **Status Auditoría:** Conceptos teóricos validados; examen de código pendiente.
* **Polimorfismo:** Entiendo que el objeto (su tipo en el Heap) determina *qué* código se ejecuta realmente en tiempo de ejecución, mientras que la variable (su tipo en el Stack) dicta *qué* métodos son visibles o permitidos por el compilador.
* **Interfaces y Diamante de la Muerte:** Comprendo que las interfaces evitan colisiones de métodos entre herencias y permiten que las clases adopten "múltiples roles".
* **Vacío Técnico Detectado:** Riesgo documentado en la falta de uso de `super()` como la primera instrucción en el constructor, lo que podría hacer que clases "hijas" intenten nacer antes de que los campos de sus clases "padre" se inicialicen en la memoria.

### 🖼️ Módulo 6: Swing, Gráficos y Optimización (Clases 53-64)
* **Encapsulamiento de Lógica:** Implementación de **Clases Internas Locales** dentro de métodos para blindar procesos que no deben ser accesibles desde fuera del alcance del método (ej. Auditoría en `Empleado.java`) [4, 16].
* **Evolución Gráfica (Graphics2D):** Dominio del **Casting de Objetos** de `Graphics` a `Graphics2D` para acceder a la API de geometría avanzada (`java.awt.geom`) y precisión con tipos `double` [17, 18].
* **Integridad y Excepciones:** Aplicación obligatoria de bloques **try-catch** al usar `ImageIO.read()`. Comprendo que sin este manejo, una `IOException` (archivo faltante) detendría la ejecución del hilo de renderizado [19, 20].
* **Metáfora de Optimización (Visión DBA):** * **Constructor:** Cargar recursos aquí actúa como una "caché" o `SELECT` único [19].
    * **PaintComponent:** Cargar recursos aquí es como un `SELECT` dentro de un cursor infinito, lo que satura la CPU innecesariamente [17, 21].
* **Mosaicos Eficientes:** Uso de `copyArea()` con incrementos de bucle iguales al ancho de la imagen (`i += width`) para evitar redundancia de procesamiento píxel a píxel [19, 22].

### ⚡ Módulo 7: Eventos y Arquitectura Reactiva (Clases 65-70)
* **Delegación:** ✅ Completado. Comprensión del trípode Fuente-Evento-Oyente.
* **Auditoría de Estados:** Uso de `WindowStateListener` y constantes de `Frame` (ej. `ICONIFIED`) para registrar comportamientos del sistema.
* **Acceso VIP:** Las clases internas permiten al oyente alterar el back-end gráfico sin exponer variables públicas.

### 🎯 Módulos 8 y 9: Periféricos y Foco (Clases 71-76)
* **Limpieza Estructural:** Entiendo por qué extender de Clases Adaptadoras (`KeyAdapter`, `MouseAdapter`) es superior a implementar interfaces completas cuando solo necesito auditar un evento.
* **Sincronización Híbrida:** Capacidad validada para construir sistemas reactivos complejos leyendo múltiples estados de periféricos (Ratón + Teclado) simultáneamente.
* **Gestión de Foco:** Dominio de la delegación de eventos y uso de métodos de enrutamiento (`getSource()`). Comprendo la importancia de no instanciar componentes ni oyentes en el `paintComponent` para preservar la integridad de la memoria.
* **Protocolos de Seguridad:** Uso de `WindowFocusListener` para proteger la privacidad de los datos al detectar la pérdida de foco global de la aplicación.
* **Múltiples Fuentes y Acciones:** Capacidad para centralizar lógica interactiva mediante `AbstractAction`, abstrayendo la fuente (Botón vs Teclado) del proceso.
* **Patrón de Difusión:** Implementación de sistemas de notificación masiva donde un emisor (`JButton`) controla múltiples receptores (`JFrame.dispose()`).


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
- [x] **Reto Boss Módulo 8:** Sistema Anti-AFK con lógica coordinada de periféricos, variables de estado y geo-fencing.
- [x] **Clase 74-76:** Terminal de Registro Corporativo (`MarcoRegistro.java`) con validación de focos en tiempo real, `getSource()` y protocolos de seguridad de ventana.
- [x] **Refactorización POO Senior:** Implementación de encadenamiento de constructores (`this()`) y uso correcto de `super()` en jerarquías `Empleado/Jefe`.
- [x] **Reto Broadcast Corporativo (Clases 77-80):** Sistema de alertas globales implementando el Patrón Observador con `Action` e `InputMap`, resolviendo el problema de "Cerebro Dividido" o secuestro de eventos.

---

## Progreso
- [x] **Módulo 1:** Fundamentos, Sintaxis y Memoria (Clases 4-13)
- [x] **Módulo 2:** Control de Flujo e I/O (Examen 95% completado)
- [x] **Módulo 3:** Manejo de Estructuras Indexadas (Clases 23-26) - **APROBADO**
- [x] **Módulo 4:** Fundamentos de POO (Clases 27-39) - **CERTIFICADO**
- [ ] **Módulo 5:** POO Avanzada e Interfaces (Clases 40-52) - **PENDIENTE EXAMEN**
- [x] **Módulo 6:** Cimientos Swing, Gráficos y Recursos (Clases 53-64)
- [x] **Módulo 7:** Eventos I - Botones y Ventanas (Clases 65-70)
- [x] **Módulo 8:** Eventos II - Teclado y Ratón (Clases 71-73 y Retos completados)
- [x] **Módulo 9:** Eventos III - Foco y Múltiples Fuentes (Clases 74-76) - **APROBADO**
- [x] **Módulo 10:** Arquitectura de Difusión y Acciones (Clases 77-80) - **APROBADO**
