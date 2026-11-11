package cl.duoc.libreria.repository;

import cl.duoc.libreria.model.Libro;
import cl.duoc.libreria.model.Publicacion;
import cl.duoc.libreria.model.Revista;

import java.util.ArrayList;
import java.util.List;

public class RepositoryLibro {
    public final static String archivoLibro = "libro.json";
    public final static String archivoRevista = "revista.json";

    private final DaoLibro<Revista> revistaDao;
    private final DaoLibro<Libro> libroDao;
    private final List<Libro> libro = new ArrayList<>();
    private final List<Revista> revista = new ArrayList<>();

    public RepositoryLibro(DaoLibro<Revista> revistaDao, DaoLibro<Libro> libroDao) {
        this.libroDao = libroDao;
        this.revistaDao = revistaDao;
    }

    public RepositoryLibro(){
        this(new GsonLibroDao<>(archivoRevista, Revista.class),
                new GsonLibroDao<>(archivoLibro, Libro.class));
    }

    public void cargar(){
        List<Libro> leidoLibro = this.libroDao.leer();
        List<Revista> leidoRevista = this.revistaDao.leer();
        this.libro.clear();
        this.libro.addAll(leidoLibro);
        this.revista.clear();
        this.revista.addAll(leidoRevista);

    }

    public List<Publicacion> listar(){
        List<Publicacion> todos = new ArrayList<>(this.libro);
        todos.addAll(this.revista);
        return todos;
    }

    public void registrar(Publicacion publicacion){
        if(publicacion instanceof  Libro librito) {
            this.libro.add(librito);
            try {
                libroDao.guardar(this.libro);
            } catch (PersistenciaException e) {
                this.libro.remove(libro.size() - 1);
            }

        }
        else if (publicacion instanceof Revista revista1){
            this.revista.add(revista1);
            try{
                revistaDao.guardar(this.revista);
            } catch (PersistenciaException e) {

                this.revista.remove(revista.size()-1);
                throw e;
            }
        } else {
            throw new IllegalArgumentException("Curso invalido, intente nuevamente");
        }
    }

    public boolean eliminar(Publicacion publicacion){
        if(publicacion instanceof  Libro){
            return this.eliminarDe(libro, libroDao, publicacion);
        }else if(publicacion instanceof Revista){
            return this.eliminarDe(revista, revistaDao, publicacion);
        }
        return false;
    }

    private<T extends Publicacion> boolean eliminarDe(List<T> lista, DaoLibro<T> dao, Publicacion p){
        int posicion = indiceDe(lista, p);
        if(posicion < 0){
            return false;
        }
        T eliminada = lista.remove(posicion);
        try{
            dao.guardar(lista);
        } catch (PersistenciaException e) {
            lista.add(posicion, eliminada);
            throw e;
        }
        return true;
    }


    private static int indiceDe(List<? extends Publicacion> lista, Publicacion p){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i) == p){
                return i;
            }
        }
        return -1;
    }


}
