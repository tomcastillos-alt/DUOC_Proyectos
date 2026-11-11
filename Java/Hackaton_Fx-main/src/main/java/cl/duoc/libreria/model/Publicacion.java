package cl.duoc.libreria.model;

/**
 * Publicación a la venta en la librería. Clase abstracta: se registra siempre
 * como Libro o Revista.
 *
 * Reglas comunes: título no vacío, páginas entre 1 y 1500 y cantidad en
 * stock entre 1 y 300 unidades.
 */
public abstract class Publicacion {

    public static final int PAGINAS_MINIMAS = 1;
    public static final int PAGINAS_MAXIMAS = 1500;
    public static final int CANTIDAD_MINIMA = 1;
    public static final int CANTIDAD_MAXIMA = 300;

    private String titulo;
    private int paginas;
    private int cantidad;

    /** Constructor sin parámetros, requerido para reconstruir objetos. */
    protected Publicacion() {
    }

    protected Publicacion(String titulo, int paginas, int cantidad) {
        setTitulo(titulo);
        setPaginas(paginas);
        setCantidad(cantidad);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = validarTitulo(titulo);
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = validarPaginas(paginas);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = validarCantidad(cantidad);
    }

    /** Precio de una unidad, en pesos, según las reglas de cada tipo de publicación. */
    public abstract int calcularPrecio();

    /** "Libro" o "Revista": se muestra en la tabla sin preguntar por la clase concreta. */
    public abstract String getTipo();

    protected static String validarTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }
        return titulo.trim();
    }

    protected static int validarPaginas(int paginas) {
        if (paginas < PAGINAS_MINIMAS || paginas > PAGINAS_MAXIMAS) {
            throw new IllegalArgumentException("Las páginas deben estar entre " + PAGINAS_MINIMAS + " y "
                    + PAGINAS_MAXIMAS + ".");
        }
        return paginas;
    }

    protected static int validarCantidad(int cantidad) {
        if (cantidad < CANTIDAD_MINIMA || cantidad > CANTIDAD_MAXIMA) {
            throw new IllegalArgumentException("La cantidad debe estar entre " + CANTIDAD_MINIMA + " y "
                    + CANTIDAD_MAXIMA + " unidades.");
        }
        return cantidad;
    }

    /** Formato de pesos chilenos: $12.000. */
    public static String pesos(int monto) {
        return String.format("$%,d", monto).replace(',', '.');
    }

    @Override
    public String toString() {
        return getTipo() + " | " + titulo + " | " + paginas + " págs. | " + cantidad + " u. | "
                + pesos(calcularPrecio());
    }
}
