package org.example.tareaep2.model;


public class CursoCertificado extends Curso implements ConDiploma{
    private boolean evaluacionFinalDia;
    private String entidadCertificadora;
    private boolean diplomaEmitido; /// 10. Añadido el boolean diploma emitido para cumplir el enunciado

    public CursoCertificado(String codigoCurso, int duracionHoras, int cupoMaximo, boolean evaluacionFinalDia, String entidadCertificadora) {
        super(codigoCurso, duracionHoras, cupoMaximo);
        setEvaluacionFinalDia(evaluacionFinalDia);
        setEntidadCertificadora(entidadCertificadora);
        setDiplomaEmitido(diplomaEmitido);
    }



    public boolean getEvaluacionFinalDia() {
        return evaluacionFinalDia;
    }


    public String getEntidadCertificadora() {
        return entidadCertificadora;
    }

    public void setEvaluacionFinalDia(boolean evaluacionFinalDia) {
        this.evaluacionFinalDia = evaluacionFinalDia;
    }

    public void setEntidadCertificadora(String entidadCertificadora) {
        this.entidadCertificadora = entidadCertificadora;
    }

    public boolean diplomaEmitido() {
        return diplomaEmitido;
    }

    public void setDiplomaEmitido(boolean diplomaEmitido) {
        this.diplomaEmitido = diplomaEmitido;
    }

    @Override
    public boolean consultarDiploma() {
        return diplomaEmitido;

    }

    @Override
    public void emitirDiploma() {
         this.diplomaEmitido = true;

    }

    @Override
    public String getTipo() {
        return "Curso Certificado";
    }

    /// 3. Colocar calculos de cursos en la clase de c/u
    @Override
    public int calcularPrecio() {
        int costoBaseCT = 85000;
        if(!evaluacionFinalDia){
            return (int) (costoBaseCT * 1.20);
        }
        else
            return costoBaseCT;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Curso Certificado | Código: " + getCodigoCurso() +
                " | Duración: " + getDuracionHoras() + " horas | Cupo: " + getCupoMaximo() +
                " | Entidad certificadora: " + entidadCertificadora +
                " | Evaluación al día: " + (getEvaluacionFinalDia() ? "Sí" : "No") +
                " | Diploma emitido: " + (diplomaEmitido ? "Sí" : "No") +
                " | Costo curso: $" + (long) calcularPrecio();
    }
}
