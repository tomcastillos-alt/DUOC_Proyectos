package cl.duoc.libreria.repository;

import cl.duoc.libreria.model.Publicacion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GsonLibroDao <T extends Publicacion > implements DaoLibro <T> {
    private final Path archivo;
    private final Type tipoLista;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GsonLibroDao(String archivo, Class<T> publi) {
        this.archivo = Path.of(archivo);
        this.tipoLista = TypeToken.getParameterized(List.class, publi).getType();
    }


    @Override
    public List<T> leer() {
        if (Files.notExists(this.archivo)) {
            return new ArrayList<>();
        }
        try (Reader lector = Files.newBufferedReader(this.archivo, StandardCharsets.UTF_8)) {
            List<T> publi = this.gson.fromJson(lector, this.tipoLista);
            if (publi == null) {
                return new ArrayList<>();
            }
            List<T> validos = new ArrayList<>();
            for (T p : publi) {
                if (p != null && p.getTitulo() != null) {
                    validos.add(p);
                }
            }
            return validos;
        } catch (IOException e) {
            throw new PersistenciaException(PersistenciaException.MSJ_LECTURA, e);
        }
    }

    @Override
    public void guardar(List<T> publi) {
        try (Writer escritor = Files.newBufferedWriter(this.archivo, StandardCharsets.UTF_8)) {
            this.gson.toJson(publi, this.tipoLista, escritor);
        } catch (IOException | JsonParseException e) {
            throw new PersistenciaException(PersistenciaException.MSJ_ESCRITURA, (IOException) e);

        }

    }
}

