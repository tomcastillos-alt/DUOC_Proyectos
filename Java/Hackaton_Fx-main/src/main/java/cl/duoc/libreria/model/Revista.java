package cl.duoc.libreria.model;

/**
 * Revista. Participa en la devolución al proveedor.
 * Precio unitario base de $3.500; si la edición tiene más de 6 meses de
 * antigüedad, el precio baja un 40 %.
 */
public class Revista extends Publicacion implements Devolvible {

    public static final int PRECIO_BASE = 3_500;
    public static final int DESCUENTO_EDICION_ANTIGUA = 40;
    public static final int MESES_EDICION_ANTIGUA = 6;

    private int numeroEdicion;
    private int mesesAntiguedad;
    private boolean listaParaDevolucion;

    /** Constructor sin parámetros, requerido para reconstruir objetos. */
    public Revista() {
    }

    public Revista(String titulo, int paginas, int cantidad, int numeroEdicion, int mesesAntiguedad) {
        super(titulo, paginas, cantidad);
        setNumeroEdicion(numeroEdicion);
        setMesesAntiguedad(mesesAntiguedad);
        this.listaParaDevolucion = false;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public int getMesesAntiguedad() {
        return mesesAntiguedad;
    }

    public void setMesesAntiguedad(int mesesAntiguedad) {
        this.mesesAntiguedad = mesesAntiguedad;
    }

    @Override
    public boolean estaListaParaDevolucion() {
        return listaParaDevolucion;
    }

    @Override
    public void marcarListaParaDevolucion() {
        this.listaParaDevolucion = true;
    }

    @Override
    public int calcularPrecio() {
        if (mesesAntiguedad > MESES_EDICION_ANTIGUA) {
            return PRECIO_BASE - PRECIO_BASE * DESCUENTO_EDICION_ANTIGUA / 100;
        }
        return PRECIO_BASE;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }
}
