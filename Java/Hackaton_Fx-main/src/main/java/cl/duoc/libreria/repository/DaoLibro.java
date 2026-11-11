package cl.duoc.libreria.repository;

import cl.duoc.libreria.model.Publicacion;

import java.util.List;

public interface DaoLibro <T extends Publicacion>  {
    List<T> leer() throws PersistenciaException;
    void guardar(List <T> publicacions) throws PersistenciaException;
}
