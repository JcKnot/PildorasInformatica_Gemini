# Estado: PENDIENTE DE IMPLEMENTACIÓN Y EVALUACIÓN

### 🛡️ Reto Integrador: Terminal de Credenciales Reactivo

**Contexto del Negocio:**
El departamento de TI necesita un módulo para asignar correos electrónicos y contraseñas a los nuevos empleados. Para evitar errores tipográficos y filtraciones, el formulario debe reaccionar en tiempo real e implementar limpieza automática de RAM.

**Tu Misión:**
Debes crear un nuevo módulo (ventana) que se lance desde el Mando de Control Central y que valide los datos a medida que el usuario los teclea.

### 📋 Checklist de Criterios de Aceptación

- [x] **Arquitectura Base:** Crea dos clases nuevas (`MarcoCredenciales` y `LaminaCredenciales`). Mantén el estándar: el marco solo envuelve a la lámina, y la lámina (JPanel) contiene toda la lógica.
- [] **Integración:** Añade un nuevo botón en el `MarcoCentradoComando` que instancie y muestre el `MarcoCredenciales`. (Usa `DISPOSE_ON_CLOSE` para no matar la app principal).
- [x] **Diseño Visual:** La `LaminaCredenciales` debe contener:
  - Un `JLabel` y un `JTextField` para el "Email Corporativo".
  - Dos `JLabel` y dos `JPasswordField` (uno para "Clave Segura" y otro para "Confirmar Clave").
  - Anida Layouts (ej. un GridLayout para los campos, envuelto en un BorderLayout) para que se vea ordenado.
- [ ] **Reactividad Nivel 1 (Email):** Conecta un `DocumentListener` al campo de Email. En tiempo real, si el texto contiene el sufijo **`@corporativo.com`**, el fondo del campo debe ponerse Verde. Si no, debe ser Rojo o Blanco.
- [ ] **Reactividad Nivel 2 (Match de Contraseñas):** Conecta un `DocumentListener` a los campos de contraseña. En tiempo real, si **ambas contraseñas coinciden exactamente** y tienen al menos 8 caracteres, un `JLabel` inferior debe mostrar el mensaje "Credenciales Válidas" en verde. De lo contrario, debe decir "Error de seguridad" en rojo.
- [ ] **Requisito Senior (Blindaje de RAM):** En la lógica de tus `insertUpdate` y `removeUpdate` de las contraseñas, extrae los `char[]`, compáralos, y justo antes de que termine el método, **obliga a vaciarlos** (ej. usando `Arrays.fill(array, '0')`) para no dejar basura en la memoria.
