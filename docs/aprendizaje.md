# Diario de Aprendizaje: Java

Este archivo centraliza los conceptos clave, apuntes y ejercicios de mi curso de Java, provenientes de las clases de Píldoras Informáticas y el soporte de mi IA colaboradora.

## Notas y Conceptos Clave

### 🧱 Módulo 1: Fundamentos, Sintaxis y Memoria (Clases 4 - 13)

- **Inmutabilidad de `String`:** Las cadenas no se pueden modificar en memoria (no aceptan `UPDATE`). Al concatenar en un bucle, se crean múltiples objetos nuevos en el **Heap** (`INSERT`), dejando los anteriores sin referencia para que el *Garbage Collector* los elimine.
- **Inferencia de Tipos (`var`):** El compilador deduce el tipo de dato basándose en la inicialización. **Regla de Arquitectura:** No se recomienda su uso con el operador diamante (`<>`) en colecciones, ya que infiere el tipo genérico `Object` y rompe la seguridad de tipos.
- **Casting de Datos:**
  - *Implícito (Widening):* Automático y seguro (ej. pasar de `int` a `double`).
  - *Explícito (Narrowing):* Requiere forzarlo manualmente con `(tipo)` (ej. de `double` a `int`). Conlleva un alto riesgo de pérdida de precisión (truncamiento de decimales).
- **Modificadores Clave (`final` y `static`):**
  - `final`: Funciona como un constraint `READ ONLY`; garantiza que el valor de la variable no sea reasignado.
  - `static`: Indica que un método (como los de la clase `Math`) pertenece a la **Clase** (la tabla general) y no a la **Instancia** (una fila específica), permitiendo su ejecución sin necesidad de instanciar un objeto con `new`.

### 🚦 Módulo 2: Control de Flujo e Interactividad (Clases 14 - 22)

- **Estrategias de Entrada (I/O):**
  - `Scanner`: Lectura secuencial conectada al flujo `System.in` (ideal para *backend* o ingesta por consola).
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

### 🧬 Módulo 5: POO Avanzada e Interfaces (Clases 40 - 52)

- **Polimorfismo:** El tipo del objeto en el **Heap** determina *qué* código se ejecuta en tiempo de ejecución; el tipo de la variable en el **Stack** dicta *qué* métodos son visibles para el compilador.
- **Herencia y `super()`:** La primera instrucción de un constructor hijo debe ser `super()` o `this()`. Sin esto, el compilador intenta instanciar el padre con argumentos por defecto, lo que puede causar errores de compilación.
- **Interfaces y el "Diamante de la Muerte":** Java prohíbe la herencia múltiple de clases para evitar ambigüedad de métodos. Las **Interfaces** resuelven esto permitiendo que una clase adopte múltiples roles sin conflictos de implementación.
- **`instanceof` y Casting Seguro:** Antes de hacer casting a un tipo específico, se debe validar con `instanceof` para evitar `ClassCastException` en tiempo de ejecución.

### 🛠️ Módulo 6: Cimientos Swing, Gráficos y Recursos (Clases 53 - 64)

- **Clases Internas de Miembro:** Permiten que una clase secundaria acceda a los campos privados de la clase externa sin necesidad de métodos públicos.
- **Clases Internas Locales:** Se declaran dentro de un método. Son ideales para tareas que solo tienen sentido durante la ejecución de ese método (ej. una auditoría rápida).
- **Enums con Tipado Fuerte:** Uso de constructores en Enums para almacenar diferentes tipos de datos (como el título de la app en `String` y si es redimensionable en `boolean`) en un solo lugar centralizado (`EnumVariables.java`).
- **Toolkit:** Clase del sistema que sirve de puente con el SO para obtener dimensiones de pantalla o iconos del sistema.
- **Casting a Graphics2D:** Para acceder a la API moderna de dibujo, debemos transformar el objeto `Graphics` básico: `Graphics2D g2 = (Graphics2D) g;`.
- **Figuras `geom`:** Uso de `Rectangle2D.Double` y `Ellipse2D.Double` para trabajar con coordenadas decimales (`double`), lo que evita errores de redondeo al escalar.
- **Carga de Imágenes (`ImageIO`):** Uso de la clase `ImageIO` para leer archivos. Requiere obligatoriamente un bloque `try-catch` para manejar la excepción `IOException`.

### ⚡ Módulo 7: Programación Dirigida por Eventos I (Clases 65 - 70)

- **Modelo de Delegación:** El flujo interactivo requiere tres piezas: Fuente (`JButton`), Evento (`ActionEvent`) y Oyente (`ActionListener`).
- **Interfaces Listener:** Un oyente DEBE implementar el método obligatorio `actionPerformed(ActionEvent e)` marcado con `@Override`.
- **Arquitectura de Oyentes (Best Practice):** Usar **Clases Internas Privadas** para que el oyente pueda manipular la interfaz (ej. `setBackground`) sin romper el encapsulamiento.
- **El Ciclo Gráfico y los Eventos (`repaint()`):** Cuando un evento modifica una variable (estado) que es utilizada para dibujar figuras o textos en el `paintComponent`, se debe invocar explícitamente al método `repaint()`.

### ⌨️ Módulo 8: Eventos de Periféricos II (Clases 71 - 73)

- **Teclado (`KeyListener` y `KeyAdapter`):**
  - Genera un flujo de tres fases: `keyPressed` (tecla baja), `keyReleased` (tecla sube) y `keyTyped` (generación de carácter imprimible).
  - **Primary Key:** Identificamos teclas con `e.getKeyCode()` y constantes (`KeyEvent.VK_A`).
- **Ratón (`MouseListener` y `MouseAdapter`):**
  - Triggers espaciales: `mousePressed`, `mouseReleased`, `mouseClicked`, `mouseEntered` y `mouseExited`.
  - **Extracción de Métricas:** Coordenadas con `e.getX()` / `e.getY()` y agresividad con `e.getClickCount()`.
- **Sincronización Híbrida (Reto Boss):** Coordinación de múltiples periféricos a través de una variable de estado booleana que condiciona el redibujado de la interfaz.

### 🎯 Módulo 9: Foco, Múltiples Fuentes y Seguridad (Clases 74 - 76)

- **Foco de Componente (`FocusListener`):** Gestión de la atención del teclado entre `JTextField`. El método `focusLost` es el lugar crítico para realizar validaciones en tiempo real (ej. comprobar si un campo está vacío o cumple un formato).
- **Identificación de Origen (`getSource()`):** Técnica para centralizar la lógica. Un solo objeto oyente puede vigilar múltiples componentes; usamos `e.getSource() == variable` para determinar qué campo disparó el evento.
- **Foco de Ventana (`WindowFocusListener`):** Supervisión a nivel de aplicación. Detecta cuándo el usuario "entra" o "sale" de la ventana (`windowGainedFocus` / `windowLostFocus`), permitiendo implementar protocolos de seguridad o pausa automática.

### 🛰️ Módulo 10: Arquitectura de Eventos y Patrones de Difusión (Clases 77 - 80)

- **Interfaz `Action` y `AbstractAction`:** Evolución profesional de los oyentes. Permite encapsular la lógica (cambio de color, borrado) junto con sus atributos (nombre, icono, tooltip) en un solo objeto.
- **Múltiples Fuentes (Binding):** Técnica para que un botón y un atajo de teclado (`KeyStroke`) disparen la misma acción sin duplicar código.
- **Estructura de Mapas Swing:**
  - `InputMap`: Relaciona la entrada física (tecla) con un ID simbólico.
  - `ActionMap`: Relaciona ese ID simbólico con el objeto `Action` real.
- **Difusión (Single Source -> Multiple Listeners):** Arquitectura donde un solo componente (ej: Botón "Cerrar Todo" o "Alerta General") notifica a una colección de objetos independientes para que reaccionen simultáneamente.

### 🧩 Módulo 11: Gestores de Diseño y Layouts Avanzados (Clases 81 - 85)

- **Anidamiento Espacial:** Dominio de la arquitectura visual estructurada. Comprendo cómo construir interfaces complejas dividiéndolas en sub-paneles independientes (`BorderLayout` raíz, `FlowLayout` cabecera, `GridLayout` centro).
- **Anti-Patrón Erradicado:** Instanciar ventanas (`JFrame`) dentro de ventanas corrompe la UI. La solución es extraer la lógica a clases que hereden de `JPanel` e inyectarlas.

### 🔒 Módulo 12: Componentes de Texto y Reactividad (Clases 86 - 89)

- **Componentes de Seguridad:** Uso estricto de `JPasswordField` para censurar visualmente las contraseñas.
- **Gestión Segura en RAM:** Para evitar volcados de memoria (Memory Dumps) maliciosos, se extraen contraseñas usando `.getPassword()` que retorna un `char[]` en lugar de un inmutable `String`. Una vez validado, se destruye la copia en memoria aplicando `Arrays.fill(array, '0')`.
- **Validación en Tiempo Real (`DocumentListener`):** Escucha directa sobre el "modelo de datos" (el texto interno) en lugar de la tecla física. Los métodos obligatorios `insertUpdate` y `removeUpdate` permiten alterar dinámicamente la UI sin obligar al usuario a presionar "Aceptar".
- **Refactorización Lógica:** Sustitución de bloques `if(condicion){return true;}else{return false;}` por el estándar senior: `return condicion;`.

### 🖋️ Módulo 13: Áreas de Texto y Selección (Clases 90 - 92)

- **Visualización:** Implementación exitosa de `JTextArea` dentro de `JScrollPane`. Comprendo que el área de texto no gestiona el scroll por sí misma, sino que delega esa responsabilidad al contenedor.
- **Interactividad de Selección:** Dominio de `JCheckBox` para el control de estados.
- **Lógica Atómica:** Uso del operador ternario para la asignación de estilos de fuente, permitiendo que la interfaz reaccione instantáneamente a los cambios del usuario.

### 🏢 Módulo 14: Botones de Selección y Menús Desplegables (Clases 93 - 95)

- **Selección Excluyente (JRadioButton y ButtonGroup):** Los `JRadioButton` se agrupan con un `ButtonGroup` para forzar la exclusión mutua. **Regla de Oro:** `ButtonGroup` es un contenedor lógico de selección, NO un contenedor visual de interfaz. Se deben crear múltiples instancias de `ButtonGroup` si se requieren varias categorías independientes de selección (ej: Jornada y Ubicación).
- **Abstracción del Estado con actionCommand:** En lugar de crear oyentes individuales y complejos por botón, se puede asignar un identificador con `.setActionCommand(texto)` a cada botón de radio y recuperarlo desde el grupo mediante `grupo.getSelection().getActionCommand()`, desacoplando la UI de la lógica del evento.
- **Menús Desplegables Editables (JComboBox):** Al activar `.setEditable(true)`, el usuario puede registrar valores personalizados.
- **Limitación de Genéricos en JComboBox:** Aunque parametricemos un `JComboBox<String>`, el método `getSelectedItem()` continúa retornando un tipo `Object` por motivos de diseño del JDK (soporte para editabilidad y retrocompatibilidad). La manera profesional de procesarlo de forma segura y unificada es mediante `String.valueOf(combo.getSelectedItem())`.

### 🎛️ Módulo 15: Sliders, Spinners y Menús Swing (Clases 96 - 100)

- **`JSlider` - El Deslizador:** Componente de rango numérico continuo. Sus propiedades clave son:
  - `setMinorTickSpacing` / `setMajorTickSpacing`: Gradación visual de la escala.
  - `setPaintTicks(true)` / `setPaintLabels(true)`: Activa la visualización de marcas y etiquetas numéricas.
  - `setSnapToTicks(true)`: **Modo Magnético** — fuerza al selector a encajar en valores enteros al soltarlo, garantizando que nunca se reciba un valor entre marcas (dato sucio).
- **`JSpinner` - El Selector por Pasos:** Componente de entrada numérica restringida. Se controla a través de un modelo: `SpinnerNumberModel(valorInicial, min, max, paso)`. Garantiza que el usuario no pueda ingresar un valor fuera del rango definido.
- **`ChangeListener` y `ChangeEvent`:** El contrato de escucha para ambos componentes. El método `stateChanged(ChangeEvent e)` se dispara en *cada* movimiento del slider o incremento del spinner.
- **Patrón UX Real-Time vs. Heavy Logic:** Decisión arquitectónica crítica:
  - **Actualización visual (JLabel):** Debe ejecutarse *siempre* dentro del `stateChanged` sin ningún guardián, para fluidez visual en tiempo real.
  - **Lógica pesada (I/O a BD o disco):** Debe protegerse con `!slider.getValueIsAdjusting()` para dispararse **solo una vez**, cuando el usuario finaliza el arrastre.
- **`JMenuBar` en Swing - Jerarquía y Posicionamiento:**
  - La jerarquía es estrictamente: `JMenuBar` → `JMenu` → `JMenuItem`.
  - **Regla de Arquitectura:** La barra de menú se asocia al `JFrame` con `setJMenuBar(barra)`, **NO** con `add()` al `JPanel`. Esto garantiza: (1) independencia del `LayoutManager`, (2) comportamiento nativo del teclado (tecla `Alt`), (3) soporte multiplataforma (ej: macOS mueve la barra a la barra global del sistema) y (4) correcta gestión de la capa Z-Order para que los menús desplegables siempre se pinten por encima del contenido.
- **Opacidad de Paneles (`setOpaque`):** Por defecto todos los `JPanel` son opacos (pintan su propio fondo gris). Al anidar paneles con `setOpaque(false)`, estos se vuelven transparentes y dejan ver el fondo del panel padre, evitando tener que propagar cambios de color a todos los hijos de forma explícita.

### 📝 Módulo 16: Eventos Avanzados en Menús y JTextPane (Clases 101 - 106)

- **`JTextPane` vs `JTextArea`:** El `JTextArea` maneja texto plano con un único estilo global. El `JTextPane` maneja **texto enriquecido (Rich Text)** mediante un `StyledDocument`, permitiendo que cada fragmento de caracteres tenga atributos de fuente, tamaño y estilo independientes.
- **`StyledEditorKit`:** Clase que provee acciones de edición predefinidas (`BoldAction`, `ItalicAction`, `FontFamilyAction`, etc.). Su principal ventaja arquitectónica es que manipula únicamente los atributos del **texto seleccionado** internamente, resolviendo estados complejos (como el *toggle* entre negrita y cursiva) sin reconstruir manualmente objetos `Font`.
- **Refactorización de Menús:** En lugar de instanciar y suscribir oyentes independientemente por cada `JMenuItem`, la práctica profesional es abstraer la creación a un método centralizado (ej. `configuraItemMenu()`) que instancie el ítem, lo inyecte al menú padre, y le asigne dinámicamente su acción, reduciendo el código redundante exponencialmente.
- **Acumulación de Estilos (OR Binario):** A nivel subyacente, los estilos (`Font.BOLD`, `Font.ITALIC`) son flags enteros. Para combinarlos sin perder el estado anterior de forma manual, se usa el operador OR a nivel de bits (`|`), ej. `getStyle() | Font.ITALIC`.
- **Z-Order de `JMenuBar`:** Mantener el menú fuertemente acoplado al `JFrame` con `setJMenuBar()` asegura que el submenú flotante (`JPopupMenu`) se renderice siempre en la capa más alta de la UI (LayeredPane), impidiendo ser solapado por paneles del contenido.

### 📋 Módulo 17: Menús Avanzados, Estado y Anidamiento (Clases 107 - 110)

- **Menús con Estado Independiente (`JCheckBoxMenuItem`):** Componente ideal para opciones acumulativas o de alternancia (*toggle*), como efectos de texto (Negrita + Cursiva). Su estado `checked/unchecked` no afecta a otros elementos de su entorno.
- **Menús de Exclusión Mutua (`JRadioButtonMenuItem`):** Se utiliza cuando varias opciones son estrictamente incompatibles entre sí (ej. alinear a la Izquierda vs Derecha). **Regla de Oro:** Deben agruparse lógicamente añadiéndolos a un `ButtonGroup` instanciado; de lo contrario, no sabrán "desmarcar" a sus hermanos al ser seleccionados.
- **Jerarquía y Anidamiento Espacial:** Para crear submenús (menús desplegables en cascada), simplemente se debe instanciar un objeto `JMenu` (la "carpeta") y añadirlo a otro `JMenu` padre utilizando el método `.add()`.
- **Mnemónicos vs Aceleradores:**
  - `setMnemonic(KeyEvent.VK_A)`: Subraya una letra. Requiere presionar `Alt + Letra` y **solo** funciona si la barra de menú tiene el foco del sistema.
  - `setAccelerator(KeyStroke.getKeyStroke(...))`: Define un atajo de teclado global (ej. `Ctrl + G`). Se ejecuta instantáneamente desde cualquier parte de la aplicación, sin importar el estado del menú.
- **Eficiencia en Instanciación (Anti-patrón):** Se debe evitar instanciar componentes con la palabra reservada `new` fuera de bloques de control (`if`/`else`) si estos podrían no ser utilizados. Retrasar la creación del objeto al bloque específico (Lazy instantiation en constructores) previene objetos huérfanos y aligera el *Garbage Collector*.

### 🛠️ Módulo 18: Barras de Herramientas y Patrón Action (Clases 111 - 114)

- **Desacoplamiento Gráfico con Action:** El uso de `AbstractAction` permite desacoplar por completo la lógica de negocio de los componentes gráficos. Un único objeto `Action` actúa como la **Fuente de la Verdad** y puede alimentar simultáneamente a un `JMenuItem` de la barra de menús y a un `JButton` del `JToolBar`.
- **`JToolBar` y BorderLayout:** Para que un `JToolBar` sea móvil o arrastrable, es fundamental que el contenedor principal use `BorderLayout`. Swing utiliza los puntos cardinales (NORTH, SOUTH, EAST, WEST) para re-acoplar la barra dinámicamente cuando el usuario la arrastra.
- **Configuración de Acciones Centralizada:** Propiedades estéticas y de usabilidad como el Tooltip se definen en el constructor de la acción mediante `putValue(Action.SHORT_DESCRIPTION, tooltip)` en lugar de configurarse por separado en cada componente de la interfaz, lo cual evita duplicidad de código.
- **Separadores Lógicos:** El método `.addSeparator()` divide la barra de herramientas en secciones organizadas lógicamente, separando los comandos de naturaleza distinta (ej. seguridad, administración, utilidades).

### 📦 Módulo 19: Box Layout y JOptionPane Avanzado (Clases 115 - 122)

- **`Box` Layout - Maquetación por Cajas:** Sistema de diseño basado en contenedores flexibles. Dos tipos principales:
  - `Box.createVerticalBox()`: Apila componentes de arriba a abajo.
  - `Box.createHorizontalBox()`: Coloca componentes de izquierda a derecha.
- **Espaciado Rígido:** `Box.createVerticalStrut(píxeles)` y `Box.createHorizontalStrut(píxeles)` crean espacio fijo entre componentes. **Regla:** `VerticalStrut` solo tiene efecto visual en cajas verticales; `HorizontalStrut` en cajas horizontales.
- **Muelle Elástico (`Box.createGlue()`):** Componente invisible que ocupa todo el espacio restante, empujando los elementos hacia el lado opuesto. Ideal para anclar botones al fondo de una ventana dinámicamente.
- **`TitledBorder` con CompoundBorder:** Agrupar componentes visualmente usando bordes titulados. Se pueden combinar bordes con `BorderFactory.createCompoundBorder()` para añadir márgenes internos (`EmptyBorder`).
- **`JOptionPane` Dinámico:** Los métodos `showConfirmDialog()` y `showOptionDialog()` aceptan parámetros de tipo (`messageType`) y botones (`optionType`) que se pueden configurar en tiempo de ejecución usando `JRadioButton` y `ButtonGroup`.
- **Interpretación de Respuestas:** `JOptionPane` retorna un `int` que se debe evaluar con las constantes `YES_OPTION`, `NO_OPTION`, `CANCEL_OPTION` y `CLOSED_OPTION` (cuando el usuario cierra la ventana con la X).
- **`DISPOSE_ON_CLOSE` vs `EXIT_ON_CLOSE`:** Las ventanas secundarias deben usar `DISPOSE_ON_CLOSE` para no cerrar la aplicación completa al cerrarse. Solo la ventana principal (`MarcoCentradoComando`) debe usar `EXIT_ON_CLOSE`.
- **Switch Expression (JDK 14+):** Alternativa moderna y legible a las cadenas de `if-else` para evaluar múltiples casos con constantes.

---

## 🛠️ Notas Técnicas Avanzadas (Best Practices)

- **Polimorfismo en Colecciones:** Al recuperar un objeto de un `ArrayList` genérico, el compilador lo trata como tipo `Object`. Es necesario realizar un **Casting** seguro (a menudo usando `instanceof`) para recuperar las capacidades específicas de la subclase.
- **Jerarquía del Lienzo:** La llamada a `super.paintComponent(g)` es innegociable; su función es limpiar el lienzo de "restos" visuales antes de que el nuevo frame se dibuje.
- **Integridad y Excepciones:** Aplicación obligatoria de bloques **try-catch** al usar `ImageIO.read()`. Sin este manejo, una `IOException` (archivo faltante) detendría la ejecución del hilo de renderizado.
- **Metáfora de Optimización (Visión DBA):**
  - **Constructor:** Cargar recursos aquí actúa como una "caché" o `SELECT` único.
  - **PaintComponent:** Cargar recursos aquí es como un `SELECT` dentro de un cursor infinito, lo que satura la CPU innecesariamente.
- **Mosaicos Eficientes:** Uso de `copyArea()` con incrementos de bucle iguales al ancho de la imagen (`i += width`) para evitar redundancia de procesamiento píxel a píxel.
- **Foco del Teclado:** Un componente solo escuchará los eventos de teclado si tiene el "foco" activo del sistema.

---

## Errores Comunes y Soluciones 💡

| Error / Problema | Causa Raíz | Solución Técnica |
| :--- | :--- | :--- |
| El color azul se ve negro. | Valores RGB muy oscuros. | Aumentar el canal azul para mayor visibilidad. |
| Ventana lenta o "congelada". | Bucle de mosaico `i++` o lecturas a disco en el Paint. | Cargar recursos en el constructor y usar incremento `i += width`. |
| El botón no reacciona. | La fuente es "sorda". | Olvido de conectar el botón mediante `addActionListener()`. |
| La variable cambia pero el dibujo no. | El método de dibujo no se volvió a ejecutar automáticamente. | Llamar a `repaint()` justo después de cambiar la variable. |
| Matrioska de Marcos | Instanciar un `JFrame` dentro de otro `JFrame` corrompe la UI. | Extraer la lógica a clases que hereden de `JPanel` e inyectarlas. |
| Componentes Fantasmas | Asignar un Layout al contenedor pero olvidar hacer el `.add(componente)`. | Validar visualmente y mapear cada `.add()` con su contenedor lógico. |
| Incompatibilidad de tipos en `JComboBox<E>` | El método `getSelectedItem()` retorna `Object` por retrocompatibilidad. | Usar `String.valueOf(combo.getSelectedItem())` o un cast explícito `(String)`. |
| Los botones de color dejaron de pintar el fondo. | Al anidar el panel de botones en un sub-panel opaco, este cubre el panel principal. | Aplicar `setOpaque(false)` a todos los sub-paneles intermedios. |
| Ventana secundaria cierra toda la app | Usar `EXIT_ON_CLOSE` en un `JFrame` secundario. | Cambiar a `DISPOSE_ON_CLOSE` para ventanas que no sean la principal. |
| `VerticalStrut` no añade espacio en caja horizontal | `createVerticalStrut()` tiene ancho cero, no funciona en cajas horizontales. | Usar `createHorizontalStrut()` o agregar el strut a la caja vertical correspondiente. |

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
- [x] **Reto Gestores de Diseño (Clases 81-85):** Construcción del Módulo de RRHH (`MarcoPerfilEmpleado`) y Teclado de Seguridad dominando el anidamiento complejo de Layouts (`BorderLayout`, `FlowLayout`, `GridLayout`).
- [x] **Reto Terminal de Credenciales (Clases 86-89):** Módulo reactivo visual con validación de sufijos de email en tiempo real, emparejamiento de contraseñas y blindaje de RAM.
- [x] **Reto Terminal de Biografía (Clases 90-92):** Implementación de un editor profesional con scroll y control de estilos acumulativos (Bold/Italic).
- [x] **Reto Terminal de Gestión de Contratos (Clases 93-95):** Módulo reactivo con JComboBox editable, JRadioButton con ButtonGroups separados y carga de datos dinámica usando enums.
- [x] **Reto Integrador Clases 96-100:** Configurador de Compensación y Antigüedad (`JSlider` magnético + `JSpinner` restringido con reactividad en tiempo real) y refactorización de ventana principal (`MarcoCentradoComando`) migrando botones de navegación a un sistema de `JMenuBar` con `setJMenuBar()`.
- [x] **Reto Editor de Borradores Corporativos (Clases 101-106):** Módulo de procesamiento de texto (Rich Text) basado en `JTextPane`, refactorización dinámica de ítems con `StyledEditorKit` y correcta orquestación arquitectónica en la barra de menú global del `MarcoCentradoComando`.
- [x] **Reto Editor Corporativo Avanzado (Clases 107-110):** Refactorización dinámica de ítems con `JCheckBoxMenuItem` (efectos), exclusión mutua de fuentes mediante `JRadioButtonMenuItem` acoplados a un `ButtonGroup`, separación visual y menús anidados.
- [x] **Reto Barra de Herramientas Dinámica (Clases 111-114):** Refactorización del Centro de Comando (`MarcoCentradoComando.java`) implementando un `JToolBar` no flotante en la región norte, integrando acciones desacopladas a través de `AbstractAction` compartidas con el menú "Gestión".
- [x] **Reto Configurador de Alertas (Clases 115-122):** Módulo de configuración de alertas de red con `Box` layout (verticales/horizontales), `TitledBorder`, `createGlue()` y `JOptionPane` dinámico con `JRadioButton` para seleccionar tipo de mensaje y opciones de confirmación.

---

## Progreso

- [x] **Módulo 1:** Fundamentos, Sintaxis y Memoria (Clases 4-13)
- [x] **Módulo 2:** Control de Flujo e I/O (Clases 14-22)
- [x] **Módulo 3:** Manejo de Estructuras Indexadas (Clases 23-26) - **APROBADO**
- [x] **Módulo 4:** Fundamentos de POO (Clases 27-39) - **CERTIFICADO**
- [ ] **Módulo 5:** POO Avanzada e Interfaces (Clases 40-52) - **PENDIENTE EXAMEN**
- [x] **Módulo 6:** Cimientos Swing, Gráficos y Recursos (Clases 53-64)
- [x] **Módulo 7:** Eventos I - Botones y Ventanas (Clases 65-70)
- [x] **Módulo 8:** Eventos II - Teclado y Ratón (Clases 71-73)
- [x] **Módulo 9:** Eventos III - Foco y Múltiples Fuentes (Clases 74-76) - **APROBADO**
- [x] **Módulo 10:** Arquitectura de Difusión y Acciones (Clases 77-80) - **APROBADO**
- [x] **Módulo 11:** Gestores de Diseño / Layouts (Clases 81-85) - **APROBADO**
- [x] **Módulo 12:** Componentes Interactivos y DocumentListener (Clases 86-89) - **APROBADO**
- [x] **Módulo 13:** Áreas de Texto y Selección (Clases 90-92) - **APROBADO**
- [x] **Módulo 14:** Botones de Selección y Menús Desplegables (Clases 93-95) - **APROBADO**
- [x] **Módulo 15:** JSlider, JSpinner y Menús Swing (Clases 96-100) - **APROBADO**
- [x] **Módulo 16:** Eventos Avanzados en Menús y JTextPane (Clases 101-106) - **APROBADO**
- [x] **Módulo 17:** Menús Avanzados, Estado y Anidamiento (Clases 107-110) - **APROBADO**
- [x] **Módulo 18:** Barras de Herramientas y Patrón Action (Clases 111-114) - **APROBADO**
- [x] **Módulo 19:** Box Layout y JOptionPane Avanzado (Clases 115-122) - **APROBADO**
