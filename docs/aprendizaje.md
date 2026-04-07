# Diario de Aprendizaje: Java

Este archivo centraliza los conceptos clave, apuntes y ejercicios de mi curso de Java, provenientes de las clases de Píldoras Informáticas y el soporte de mi IA colaboradora.

## Notas y Conceptos Clave

### 🛠️ Arquitectura y Lógica (Clases 53 - 59)
- **Clases Internas de Miembro:** Permiten que una clase secundaria acceda a los campos privados de la clase externa sin necesidad de métodos públicos.
- **Clases Internas Locales:** Se declaran dentro de un método. Son ideales para tareas que solo tienen sentido durante la ejecución de ese método (ej. una auditoría rápida).
- **Enums con Tipado Fuerte:** Uso de constructores en Enums para almacenar diferentes tipos de datos (como el título de la app en `String` y si es redimensionable en `boolean`) en un solo lugar centralizado (`EnumVariables.java`).
- **Toolkit:** Clase del sistema que sirve de puente con el SO para obtener dimensiones de pantalla o iconos del sistema.

### 🎨 Gráficos 2D y Estilo (Clases 60 - 61)
- **Casting a Graphics2D:** Para acceder a la API moderna de dibujo, debemos transformar el objeto `Graphics` básico: `Graphics2D g2 = (Graphics2D) g;`.
- **Figuras `geom`:** Uso de `Rectangle2D.Double` y `Ellipse2D.Double` para trabajar con coordenadas decimales (`double`), lo que evita errores de redondeo al escalar.
- **Jerarquía de Pintado:** La importancia de llamar a `super.paintComponent(g)` para limpiar el lienzo antes de dibujar elementos nuevos.

### 🖼️ Recursos Externos y Optimización (Clases 62 - 64)
- **Carga de Imágenes (`ImageIO`):** Uso de la clase `ImageIO` para leer archivos. Requiere obligatoriamente un bloque `try-catch` para manejar la excepción `IOException`.
- **Rendimiento (Constructor vs Paint):** Las imágenes deben cargarse **fuera** del método `paintComponent` (preferiblemente en el constructor). Si se cargan dentro, el programa leerá el disco duro constantemente, ralentizando la interfaz.
- **Mosaicos con `copyArea`:** Técnica para duplicar una sección del dibujo. El incremento del bucle debe ser igual al tamaño de la imagen (`i += width`) para ser eficiente.

### ⚡ Programación Dirigida por Eventos (Clases 65 - 70)
- **Modelo de Delegación:** El flujo interactivo requiere tres piezas: Fuente (ej. `JButton`), Evento (ej. `ActionEvent`) y Oyente (ej. `ActionListener`).
- **Arquitectura de Oyentes:** Se recomienda usar **Clases Internas Privadas** para permitir que el oyente manipule la interfaz gráfica sin romper el encapsulamiento. Se pueden crear constructores paramétricos para hacer oyentes reutilizables.
- **Ciclo Gráfico y Eventos (`repaint()`):** Si un evento altera una variable utilizada para dibujar (`paintComponent`), es obligatorio llamar a `repaint()` para forzar a Java a re-dibujar la pantalla con los nuevos datos.
- **Eventos de Ventana (`WindowListener`):** Detectan acciones a nivel de sistema operativo (abrir, cerrar, minimizar).
- **Clases Adaptadoras (Adaptadores):** Interfaces como `WindowListener` obligan a sobrescribir múltiples métodos. Las clases como `WindowAdapter` solucionan esto: al heredar de ellas (`extends`), solo necesitas sobrescribir el método específico que vas a utilizar (ej. `windowOpened`), dejando el código limpio.
- **Estados de Ventana (`WindowStateListener`):** Sirven para auditar cambios de estado. Se utiliza `e.getNewState()` y se compara con constantes de la clase `Frame` (`Frame.NORMAL`, `Frame.ICONIFIED`, `Frame.MAXIMIZED_BOTH`).

---

## Errores Comunes y Soluciones 💡

| Error / Problema | Causa Raíz | Solución Técnica |
| :--- | :--- | :--- |
| El color azul se ve negro. | Valores RGB muy bajos (ej. `0, 51, 102`). | Aumentar el valor del canal azul (ej. `0, 102, 204`) o usar `.brighter()`. |
| La ventana se "congela" o va lenta. | Carga de imágenes o bucles infinitos en `paintComponent`. | Cargar imágenes en el **constructor** y usar incrementos `i += width` en el mosaico. |
| El texto no se ve sobre el fondo. | El color del pincel no se cambió antes de `drawString`. | Usar `g2.setPaint(Color.WHITE)` antes de escribir el texto sobre fondos oscuros. |
| Figuras con bordes "dentados". | No se ha activado el suavizado (Antialiasing). | Usar `RenderingHints` en `Graphics2D`. |
| El botón no reacciona. | La fuente es "sorda". | Olvido de conectar el botón mediante `addActionListener()`. |
| La variable cambia pero el dibujo no. | El método de dibujo no se volvió a ejecutar. | Llamar a `repaint()` justo después de actualizar las variables de estado. |
| Código saturado con métodos vacíos. | Implementar una Interfaz con muchos métodos (ej. `WindowListener`). | Heredar de una **Clase Adaptadora** (ej. `WindowAdapter`) para sobrescribir solo lo necesario. |

---

## Ejercicios

- [x] **Clase 54-55:** Lógica de Auditoría con clases internas.
- [x] **Clase 58-59:** Marco Centrado dinámico (`Toolkit`).
- [x] **Clase 60-61:** Header Corporativo (`Graphics2D`).
- [x] **Clase 62-64:** Avatar y Textura con rendimiento optimizado.
- [x] **Clase 65-67:** Selector interactivo de Entornos y Título Dinámico (`repaint()`).
- [x] **Clase 68-70:** Auditoría de seguridad con `WindowStateListener` y optimización de código con `WindowAdapter`.

---

## Progreso

- [x] **Módulo 1: Swing Básico y Configuración** (Clases 53-59)
- [x] **Módulo 2: Gráficos y Geometría** (Clases 60-61)
- [x] **Módulo 3: Imágenes e I/O Gráfico** (Clases 62-64)
- [x] **Módulo 4: Eventos I - Botones, Ventanas y Estados** (Clases 65-70 completadas)

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

### 🖼️ Módulo 1-3: Swing, Gráficos y Optimización (Clases 53-64)
* **Encapsulamiento de Lógica:** Implementación de **Clases Internas Locales** dentro de métodos para blindar procesos que no deben ser accesibles desde fuera del alcance del método (ej. Auditoría en `Empleado.java`) [4, 16].
* **Evolución Gráfica (Graphics2D):** Dominio del **Casting de Objetos** de `Graphics` a `Graphics2D` para acceder a la API de geometría avanzada (`java.awt.geom`) y precisión con tipos `double` [17, 18].
* **Integridad y Excepciones:** Aplicación obligatoria de bloques **try-catch** al usar `ImageIO.read()`. Comprendo que sin este manejo, una `IOException` (archivo faltante) detendría la ejecución del hilo de renderizado [19, 20].
* **Metáfora de Optimización (Visión DBA):** * **Constructor:** Cargar recursos aquí actúa como una "caché" o `SELECT` único [19].
    * **PaintComponent:** Cargar recursos aquí es como un `SELECT` dentro de un cursor infinito, lo que satura la CPU innecesariamente [17, 21].
* **Mosaicos Eficientes:** Uso de `copyArea()` con incrementos de bucle iguales al ancho de la imagen (`i += width`) para evitar redundancia de procesamiento píxel a píxel [19, 22].

---

## 🛠️ Notas Técnicas Avanzadas (Best Practices)

* **Polimorfismo en Colecciones:** Al recuperar un objeto de un `ArrayList` genérico, el compilador lo trata como tipo `Object` [23, 24]. Es necesario realizar un **Casting** seguro (a menudo usando `instanceof`) para recuperar las capacidades específicas de la subclase [25, 26].
* **Jerarquía del Lienzo:** La llamada a `super.paintComponent(g)` es innegociable; su función es limpiar el lienzo de "restos" visuales antes de que el nuevo frame se dibuje [18, 27].
* **Configuración Desacoplada:** Uso de **Enums con múltiples constructores** para centralizar valores `String` y `boolean`, eliminando el *hardcoding* en las clases de interfaz [4, 28].