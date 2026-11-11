package cl.duoc.libreria.model;

/**
 * Contrato que cumplen las publicaciones que pueden devolverse al proveedor.
 * El estado no tiene setter: se cambia con marcarListaParaDevolucion().
 */
public interface Devolvible {

    /**
     * Indica si la publicación está lista para ser devuelta al proveedor.
     *
     * @return true si está lista para devolución
     */
    boolean estaListaParaDevolucion();

    /**
     * Registra que la publicación está lista para devolución.
     */
    void marcarListaParaDevolucion();
}
