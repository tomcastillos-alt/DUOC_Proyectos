package org.example.tareaep2.repository;

public class PersistenciaException extends RuntimeException {
    public PersistenciaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
    public final static String MSJ_LECTURA = "Error al leer archivo";
    public final static String MSJ_ESCRITURA = "Error al escribir archivo";
}
