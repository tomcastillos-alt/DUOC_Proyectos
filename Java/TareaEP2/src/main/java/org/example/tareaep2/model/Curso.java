package org.example.tareaep2.model;


public abstract class Curso {
    private String codigoCurso;
    private int duracionHoras;
    private int cupoMaximo;

    public Curso(String codigoCurso, int duracionHoras, int cupoMaximo) {
        setCodigoCurso(codigoCurso);
        setDuracionHoras(duracionHoras);
        setCupoMaximo(cupoMaximo);
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso){
        if(codigoCurso.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El código de curso no puede estar vacío.");
        }
        else{
            this.codigoCurso = codigoCurso;
        }
    }

    public abstract String getTipo();

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo)  {
            if(cupoMaximo <= 0){ ///8. Arreglada validacion
                throw new IllegalArgumentException("Error: El cupo debe ser un valor mayor que cero");
            }
            else{
                this.cupoMaximo = cupoMaximo;
            }
        }


        ///Cambio 2. Mover el cálculo de cursos a la clase padre
    public abstract int calcularPrecio();

    public int getDuracionHoras() {
        if(duracionHoras < 4 || duracionHoras > 200){
            throw new IllegalArgumentException("Error: La cantidad de horas debe ser de entre 4 y 200 horas.");
        }
        else{
            return duracionHoras;
        }
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
    public abstract String obtenerDetalle();

    public static String pesos(int monto) {
        return String.format("$%,d", monto).replace(',', '.');
    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigoCurso() + " | Duracion: " + getDuracionHoras() ;
    }
}
