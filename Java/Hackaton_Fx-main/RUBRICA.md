# Rúbrica · Hackathon Librería Rincón Lector

> **Aviso importante**
>
> Esta rúbrica es solo referencial. Fue creada por estudiantes con ayuda de inteligencia artificial, y no reemplaza ninguna pauta oficial.
>
> Que te vaya bien aquí no asegura el mismo resultado en la prueba real, ni una mala nota aquí significa un mal resultado allá. Todo esto fue hecho con cariño.

## Cómo se califica

Cada criterio tiene **4 casillas**. Cuenta cuántas cumples y ese es tu logro en el criterio:

| Casillas cumplidas | 4 | 3 | 2 | 1 | 0 |
|---|---|---|---|---|---|
| **% de logro** | 100% | 80% | 60% | 30% | 0% |

Tu puntaje en cada criterio es `ponderación × % de logro`. La suma de los 13 criterios da tu **total ponderado** (máximo 100%).

**Nota:** exigencia de 60%. Con 60% de total obtienes un 4,0 y con 100% un 7,0.

**Reglas generales**

- Si el proyecto **no compila**, todos los criterios quedan en 0%.
- Si compila pero **no inicia**, cada criterio se evalúa por lo que se vea en el código, la vista y la configuración.
- No reescribas ni reemplaces las clases del modelo. Solo puedes hacer ajustes para integrar la interfaz y los archivos.
- La interfaz es **una sola ventana**, declarada en FXML. Una interfaz hecha solo con código no cuenta como vista.
- Una falla solo afecta otro criterio si también impide lo que ese criterio mide.

## Resumen de criterios

| N° | Criterio | Ponderación |
|---|---|---|
| 1 | Configuración del proyecto | 6% |
| 2 | Vista en FXML | 7% |
| 3 | Vista conectada al controlador | 7% |
| 4 | Inicio y eventos del controlador | 8% |
| 5 | Mensajes de resultado | 6% |
| 6 | Paquetes y capas | 8% |
| 7 | Controlador solo coordina | 7% |
| 8 | Tabla y lista observable | 12% |
| 9 | Validación del formulario | 7% |
| 10 | Mensajes de error y formulario | 7% |
| 11 | DAO y Repository | 9% |
| 12 | Carga y guardado | 8% |
| 13 | Flujo completo | 8% |
| | **Total** | **100%** |

## Criterios

### 1. Configuración del proyecto · 6%

- [ ] Gson está en el `pom.xml`, junto a las dependencias de JavaFX, sin alterarlas.
- [ ] La dependencia aparece una sola vez y el proyecto compila.
- [ ] La aplicación inicia desde la clase de arranque entregada, sin pasos extra ni cambios en ella.
- [ ] La vista se carga desde su archivo FXML en la ubicación esperada, sin alterar su carga.

### 2. Vista en FXML · 7%

- [ ] La ventana está declarada en un archivo FXML, no construida por código.
- [ ] Tiene el selector de tipo, los campos comunes (título, páginas, cantidad) y los campos propios de libro y de revista.
- [ ] Tiene la tabla con sus 5 columnas y los botones Registrar y Eliminar.
- [ ] Tiene el área de mensajes, y cada grupo (formulario, tabla, botones, mensajes) se distingue con claridad.

### 3. Vista conectada al controlador · 7%

- [ ] El FXML indica su clase controladora.
- [ ] Cada componente que usa el controlador tiene `fx:id` en la vista.
- [ ] Cada atributo del controlador lleva la anotación `@FXML`.
- [ ] Tipo e identificador coinciden entre vista y controlador, y ningún componente queda sin funcionar.

### 4. Inicio y eventos del controlador · 8%

- [ ] Al iniciar, se cargan los valores de partida (las opciones Libro y Revista del selector).
- [ ] Solo quedan habilitados los datos del tipo elegido, y esto cambia al cambiar el selector.
- [ ] Registrar y Eliminar tienen un manejador de eventos que funciona.
- [ ] Eliminar quita solo la fila seleccionada. Sin selección, avisa y conserva los datos.

### 5. Mensajes de resultado · 6%

- [ ] Se informa el registro exitoso.
- [ ] Se informa la eliminación y también el intento de eliminar sin selección.
- [ ] Se informa el error al leer o guardar los archivos.
- [ ] Cada mensaje indica la publicación o la causa, reemplaza al anterior y aparece en la ventana (no por consola).

### 6. Paquetes y capas · 8%

- [ ] Hay paquetes distintos para controlador, modelo y persistencia, y la vista queda en el lugar que le corresponde.
- [ ] Cada clase está en el paquete de su responsabilidad.
- [ ] El modelo y la persistencia no dependen del controlador ni de clases de JavaFX.
- [ ] Las clases nuevas no están en el paquete raíz ni dentro del paquete del modelo.

### 7. Controlador solo coordina · 7%

- [ ] El controlador revisa las entradas y coordina la interfaz, directamente o usando las reglas del modelo.
- [ ] Los cálculos y reglas (como el precio) los entrega el modelo, y el controlador no los recalcula.
- [ ] Las operaciones con los datos se piden al Repository.
- [ ] El controlador no lee ni escribe archivos directamente ni reemplaza la lógica del modelo.

### 8. Tabla y lista observable · 12%

- [ ] La tabla usa una única lista observable durante toda la ejecución, que se actualiza en lugar de crear una nueva tras cada operación.
- [ ] La lista se sincroniza con el Repository al iniciar y tras cada operación, e incluye libros y revistas sin duplicar.
- [ ] Cada columna (Tipo, Título, Páginas, Cantidad, Precio unitario) muestra el valor correcto, y el precio es el que calcula el modelo.
- [ ] Al registrar, la publicación aparece de inmediato. Al eliminar, desaparece de inmediato, sin reiniciar ni hacer otra acción.

### 9. Validación del formulario · 7%

- [ ] Se exige tipo seleccionado, título sin estar vacío ni solo espacios, y autor (libro) con la misma regla.
- [ ] Se verifica el formato numérico y los rangos: páginas 1 a 1500, cantidad 1 a 300, edición 1 a 999, antigüedad 0 a 120.
- [ ] Solo se validan los campos del tipo seleccionado.
- [ ] Con un dato inválido no se registra nada y la aplicación sigue funcionando, sin errores sin controlar.

### 10. Mensajes de error y formulario · 7%

- [ ] El mensaje de error aparece en el área de mensajes de la ventana.
- [ ] El mensaje indica qué campo es incorrecto.
- [ ] El mensaje indica el motivo del rechazo.
- [ ] Tras un error se conservan los valores ingresados, y tras un registro exitoso el formulario queda vacío y listo.

### 11. DAO y Repository · 9%

- [ ] Existe una interfaz DAO con las operaciones de lectura y escritura.
- [ ] Existe una implementación del DAO que usa Gson y maneja `libros.json` y `revistas.json`.
- [ ] Existe una clase Repository que guarda la colección en memoria, sin depender de JavaFX, y ofrece las operaciones que usa el controlador.
- [ ] El Repository deja la lectura y escritura de archivos al DAO.

### 12. Carga y guardado · 8%

- [ ] Al iniciar, los datos de ambos archivos se cargan por medio del DAO y el Repository, y se muestran en la tabla.
- [ ] Si falta un archivo, la aplicación inicia sin esos datos y sin errores.
- [ ] Cada registro y cada eliminación actualiza los archivos sin acción extra, y al reiniciar aparece todo lo guardado.
- [ ] Ante un error de escritura no se informa éxito y los datos quedan consistentes.

### 13. Flujo completo · 8%

- [ ] La aplicación inicia sin errores y carga los datos guardados.
- [ ] Registra las cuatro publicaciones de prueba, con validación.
- [ ] Los precios coinciden con lo esperado ($15.600, $12.000, $3.500 y $2.100) y la eliminación de la fila seleccionada funciona.
- [ ] Al reiniciar se ve lo guardado: Viajes sigue lista para devolución y Bosque Adentro ya no aparece, si fue eliminado.

## Tu resultado

| Criterio | Ponderación | Casillas (0 a 4) | % de logro | Puntaje |
|---|---|---|---|---|
| 1. Configuración del proyecto | 6% | | | |
| 2. Vista en FXML | 7% | | | |
| 3. Vista conectada al controlador | 7% | | | |
| 4. Inicio y eventos del controlador | 8% | | | |
| 5. Mensajes de resultado | 6% | | | |
| 6. Paquetes y capas | 8% | | | |
| 7. Controlador solo coordina | 7% | | | |
| 8. Tabla y lista observable | 12% | | | |
| 9. Validación del formulario | 7% | | | |
| 10. Mensajes de error y formulario | 7% | | | |
| 11. DAO y Repository | 9% | | | |
| 12. Carga y guardado | 8% | | | |
| 13. Flujo completo | 8% | | | |
| **Total** | **100%** | | | |
