package cl.duoc.libreria.model;

/**
 * Libro. Precio unitario base de $12.000; si es de tapa dura, el precio sube un 30 %.
 */
public class Libro extends Publicacion {

    public static final int PRECIO_BASE = 12_000;
    public static final int RECARGO_TAPA_DURA = 30;

    private String autor;
    private boolean tapaDura;

    /** Constructor sin parámetros, requerido para reconstruir objetos. */
    public Libro() {
    }

    public Libro(String titulo, int paginas, int cantidad, String autor, boolean tapaDura) {
        super(titulo, paginas, cantidad);
        setAutor(autor);
        setTapaDura(tapaDura);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isTapaDura() {
        return tapaDura;
    }

    public void setTapaDura(boolean tapaDura) {
        this.tapaDura = tapaDura;
    }

    @Override
    public int calcularPrecio() {
        if (tapaDura) {
            return PRECIO_BASE + PRECIO_BASE * RECARGO_TAPA_DURA / 100;
        }
        return PRECIO_BASE;
    }

    @Override
    public String getTipo() {
        return "Libro";
    }
}
