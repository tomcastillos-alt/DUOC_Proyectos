# Hackathon · Librería Rincón Lector

Ejercicio de práctica de **Programación Orientada a Objetos (DSY1102)**: construir una aplicación de escritorio con **JavaFX** y archivos **JSON** sobre un modelo de clases ya entregado.

> **Aviso importante**
>
> Este material fue creado por estudiantes, con ayuda de inteligencia artificial. La rúbrica es solo referencial. Que te vaya bien (o mal) aquí no asegura el mismo resultado en la prueba real. Hecho con cariño, para que practiques con un caso real. El aviso completo está en [`ENTREGA.md`](ENTREGA.md).

## Cómo partir

1. En esta página de GitHub, haz clic en **Code → Download ZIP** y descomprime el archivo en una carpeta de trabajo.
2. Abre IntelliJ IDEA y elige **File → Open...**, luego selecciona la carpeta del proyecto.
3. Si IntelliJ lo pregunta, elige **Trust Project** y ábrelo como proyecto Maven.
4. Verifica que el JDK del proyecto sea **21** (**File → Project Structure → Project**).

## Qué documentos leer

| Documento | Para qué sirve |
|---|---|
| [`ENUNCIADO.md`](ENUNCIADO.md) | El caso que debes resolver: qué construir y cómo debe comportarse. |
| [`RUBRICA.md`](RUBRICA.md) | Cómo se evalúa tu trabajo. Úsala como lista de comprobación mientras resuelves. |
| [`COMO_CREAR_REPOSITORIO.md`](COMO_CREAR_REPOSITORIO.md) | Cómo subir tu solución a tu propio repositorio, paso a paso y sin comandos. |
| [`ENTREGA.md`](ENTREGA.md) | Cómo y cuándo entregar: correo, formulario y plazos. |

## Pasos de principio a fin

1. Lee el **enunciado** completo.
2. Mira la **rúbrica**: te dice qué se espera de cada parte.
3. Resuelve el ejercicio. Te recomendamos ponerte un límite de unas **3 horas**.
4. Borra las carpetas `target` y `.idea` de tu proyecto y súbelo a tu repositorio (ver `COMO_CREAR_REPOSITORIO.md`).
5. Envía el **correo** de entrega, con el asunto exacto que indica `ENTREGA.md`.
6. Completa el **formulario**: https://docs.google.com/forms/d/e/1FAIpQLSeWQDIoY3q3X9ABFZY0zKU5t9tuM6wSM12dVdl0p7b1GNCIXg/viewform

## Plazos del 09/11

| Momento | Qué pasa |
|---|---|
| Hasta las **14:00** | Entrega normal. |
| Entre las **14:00 y las 15:00** | Entrega extendida, con **1 punto menos**. Aun así participas. |
| Después de las **15:00** | Ya no participas. La retroalimentación no queda asegurada. |

Quienes entreguen hasta las 15:00 reciben su retroalimentación entre las **15:30 y las 16:30**. Si hay una diferencia, la fuente oficial es [`ENTREGA.md`](ENTREGA.md).

---

## Referencia del proyecto base

### Contenido

```
pom.xml                                     Proyecto Maven para Java 21, con JavaFX incluido.
src/main/java/cl/duoc/libreria/
    Launcher.java                           Punto de entrada: ejecuta esta clase para iniciar la aplicación.
    App.java                                Aplicación JavaFX: carga la vista principal y abre la ventana.
src/main/java/cl/duoc/libreria/model/       Modelo del sistema (ya implementado y probado):
    Devolvible.java
    Publicacion.java
    Libro.java
    Revista.java
src/main/resources/cl/duoc/libreria/view/   Carpeta para las vistas FXML.
```

### Cómo ejecutar la aplicación

- Ejecuta la clase `Launcher` (botón Run junto al método `main`).
- `App` carga la vista principal desde `src/main/resources/cl/duoc/libreria/view/main-view.fxml`. Debes crear ese archivo con Scene Builder. Mientras no exista, la aplicación se detiene con el mensaje "No se encontró la vista principal".

### Lo que debes agregar al `pom.xml`

La dependencia de la librería **Gson**, en el lugar indicado por el comentario. Luego recarga el proyecto Maven (ícono **Load Maven Changes**, o clic derecho en `pom.xml` → **Maven → Reload Project**).

### Importante

- No modifiques la lógica de las clases del modelo.
- Puedes agregar tus propios paquetes, clases y recursos.

### Operaciones disponibles en el modelo

**`Publicacion`** (clase abstracta)

- `getTitulo()` / `setTitulo(String)`
- `getPaginas()` / `setPaginas(int)`
- `getCantidad()` / `setCantidad(int)`
- `calcularPrecio()`: precio unitario según el tipo de publicación.
- `getTipo()`: devuelve `"Libro"` o `"Revista"`.
- `toString()`: tipo, título, páginas, cantidad y precio.

Los métodos `set` rechazan datos inválidos con un mensaje que explica el motivo: el título no puede ser nulo ni vacío, las páginas van entre 1 y 1500 y la cantidad entre 1 y 300 unidades.

**`Libro`** (extiende `Publicacion`)

- `Libro(titulo, paginas, cantidad, autor, tapaDura)`
- `getAutor()` / `setAutor(String)`
- `isTapaDura()` / `setTapaDura(boolean)`

**`Revista`** (extiende `Publicacion`, implementa `Devolvible`)

- `Revista(titulo, paginas, cantidad, numeroEdicion, mesesAntiguedad)`
- `getNumeroEdicion()` / `setNumeroEdicion(int)`
- `getMesesAntiguedad()` / `setMesesAntiguedad(int)`
- `estaListaParaDevolucion()`
- `marcarListaParaDevolucion()`
