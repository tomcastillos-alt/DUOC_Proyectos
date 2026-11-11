package org.example.tareaep2.repository;

import org.example.tareaep2.model.Curso;
import org.example.tareaep2.model.CursoCertificado;
import org.example.tareaep2.model.CursoLibre;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    public final static String archivoCertificado = "certificado.json";
    public final static String archivoLibre = "libre.json";

    private final CursoDAO<CursoCertificado> cursoCertificadoDao;
    private final CursoDAO<CursoLibre> cursoLibreDao;
    private final List<CursoCertificado> certificado = new ArrayList<>();
    private final List<CursoLibre> libre = new ArrayList<>();

    public CursoRepository(CursoDAO<CursoCertificado> cursoCertificadoDao, CursoDAO<CursoLibre> cursoLibreDao) {
        this.cursoCertificadoDao = cursoCertificadoDao;
        this.cursoLibreDao = cursoLibreDao;
    }

    public CursoRepository(){
        this(new GsonCursoDAO<>(archivoCertificado, CursoCertificado.class), new GsonCursoDAO<>(archivoLibre, CursoLibre.class));
    }
    public void cargar(){
        List<CursoCertificado> leidoCertificado = this.cursoCertificadoDao.leer();
        List<CursoLibre> leidoLibre = this.cursoLibreDao.leer();
        this.certificado.clear();
        this.certificado.addAll(leidoCertificado);
        this.libre.clear();
        this.libre.addAll(leidoLibre);

    }

    public List<Curso> listar(){
        List<Curso> todos = new ArrayList<>(this.certificado);
        todos.addAll(this.libre);
        return todos;
    }

    public void registrar(Curso curso){
        if(curso instanceof  CursoCertificado certifica) {
            this.certificado.add(certifica);
            try {
                cursoCertificadoDao.guardar(this.certificado);
            } catch (PersistenciaException e) {
                this.certificado.remove(certificado.size() - 1);
            }

        }
        else if (curso instanceof CursoLibre libreC){
            this.libre.add(libreC);
            try{
                cursoLibreDao.guardar(this.libre);
            } catch (PersistenciaException e) {

                this.libre.remove(libre.size()-1);
                throw e;
            }
        } else {
            throw new IllegalArgumentException("Curso invalido, intente nuevamente");
        }
    }

    public boolean eliminar(Curso curso){
        if(curso instanceof  CursoCertificado){
            return this.eliminarDe(certificado, cursoCertificadoDao, curso);
        }else if(curso instanceof CursoLibre){
            return this.eliminarDe(libre, cursoLibreDao, curso);
        }
        return false;
    }

    private<T extends Curso> boolean eliminarDe(List<T> lista, CursoDAO<T> dao, Curso curso){
        int posicion = indiceDe(lista, curso);
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


    private static int indiceDe(List<? extends Curso> lista, Curso curso){
        for(int i = 0; i < lista.size(); i++){
        if(lista.get(i) == curso){
            return i;
        }
    }
        return -1;
    }




}
