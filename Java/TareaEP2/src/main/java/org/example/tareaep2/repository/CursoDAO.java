package org.example.tareaep2.repository;

import org.example.tareaep2.model.Curso;

import java.util.List;

public interface CursoDAO <T extends Curso>  {
    List<T> leer() throws PersistenciaException;
    void guardar(List <T> cursos) throws PersistenciaException;
}
