package cl.duoc.libreria.repository;

import java.io.IOException;

public class PersistenciaException extends RuntimeException {
    public PersistenciaException(String message, IOException e) {
        super(message);

    }

    public final static String MSJ_LECTURA = "Error al leer archivo";
    public final static String MSJ_ESCRITURA = "Error al escribir archivo";
}
