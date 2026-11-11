package org.example.tareaep2.model;

public class CursoLibre extends Curso {
    private int cantidadInscritos;

    public CursoLibre(String codigoCurso, int duracionHoras, int cupoMaximo, int cantidadInscritos) {
        super(codigoCurso, duracionHoras, cupoMaximo);
        setCantidadInscritos(cantidadInscritos);
    }


    public int getCantidadInscritos() {
        return cantidadInscritos;
    }

    public void setCantidadInscritos(int cantidadInscritos) {
        this.cantidadInscritos = cantidadInscritos;
    }


    @Override
    public String getTipo() {
        return "Curso Libre";
    }

    @Override
    public int calcularPrecio() {
        int costoBaseCT = 45000;
        if(cantidadInscritos > 20){
            return (int) (costoBaseCT * 1.10);
        }
        else
            return costoBaseCT;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Curso Certificado | Código: " + getCodigoCurso() +
                " | Duración: " + getDuracionHoras() + " horas | Cupo: " + getCupoMaximo() +
                " | Cantidad Inscritos: " + getCantidadInscritos() +
                " | Costo curso: $" + (long) calcularPrecio();
    }
}

