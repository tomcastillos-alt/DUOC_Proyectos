package org.example.tareaep2.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import org.example.tareaep2.model.Curso;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GsonCursoDAO <T extends Curso> implements CursoDAO<T> {
    private final Path archivo;
    private final Type tipoLista;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GsonCursoDAO(String archivo, Class<T> publi) {
        this.archivo = Path.of(archivo);
        this.tipoLista = TypeToken.getParameterized(List.class, publi).getType();
    }


    @Override
    public List<T> leer() {
        if(Files.notExists(this.archivo)){
            return new ArrayList<>();
        }
        try(Reader lector = Files.newBufferedReader(this.archivo, StandardCharsets.UTF_8)){
            List<T> cursos = this.gson.fromJson(lector, this.tipoLista);
            if(cursos == null){
                return new ArrayList<>();
            }
            List<T> validos = new ArrayList<>();
            for(T curso : cursos){
                if(curso != null && curso.getCodigoCurso()!=null){
                    validos.add(curso);
                }
            }
            return validos;
        }catch (IOException e){
            throw new PersistenciaException(PersistenciaException.MSJ_LECTURA, e);
        }
    }

    @Override
    public void guardar(List<T> cursos) {
        try(Writer escritor = Files.newBufferedWriter(this.archivo, StandardCharsets.UTF_8)){
            this.gson.toJson(cursos, this.tipoLista, escritor);
        }catch (IOException| JsonParseException e){
            throw new PersistenciaException(PersistenciaException.MSJ_ESCRITURA, e);

        }

    }
}
