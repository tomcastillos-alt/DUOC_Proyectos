package org.example.tareaep2.model;


import java.util.ArrayList;
import java.util.List;


///5. Cambiada la forma de iniciar la lista. Ahora debiese funcionar como corresponde
public class GestorCapacitacion {
    private List<Curso> cursos;

    public GestorCapacitacion() {
        this.cursos = new ArrayList<>();
    }


    ///4. Hartos cambios. Arreglado el buscar curso con los argumentos correctos. Agregado tambien la busqueda, ahora no debiese dar error
    public Curso buscarCurso(String codigo) {
        System.out.printf("%n=== BUSQUEDA POR CODIGO CURSO: \"%s\" ===%n", codigo);
        for(Curso c : cursos){
            if(c.getCodigoCurso().equalsIgnoreCase(codigo)){
                return c;
            }
        }
        return null;
    }

    public void agregarCurso(Curso nombre){
        cursos.add(nombre);
        System.out.println("Curso: " + nombre.getCodigoCurso() + " agregado correctamente");
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    /// 3. Colocar calculos de cursos en la clase de c/u. Movi todo este codigo.

}
