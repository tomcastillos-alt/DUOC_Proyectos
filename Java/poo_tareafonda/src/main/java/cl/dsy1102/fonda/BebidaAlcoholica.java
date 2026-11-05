package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {

    int LIMITE_UNIDADES_POR_CLIENTE = 3;
    double gradosAlcohol;
    boolean certificada;
    boolean ventaRestringida;

    public BebidaAlcoholica(String nombre, int volumen, int stock, double gradosAlcohol, boolean certificada) {
        super(nombre, volumen, stock);
        setGradosAlcohol(gradosAlcohol);
        setCertificada(certificada);
        this.ventaRestringida = false;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }
    public void setGradosAlcohol(){
        if(gradosAlcohol > 0.5){
            throw new IllegalArgumentException("Error: El grado de alcohol no puede ser inferior a los 5° / ML");
        }
        if(gradosAlcohol < 45.0){
            throw new IllegalArgumentException("Error: El grado de alcohol no puede ser superior a los 45° / ML");
        }
    }

    public boolean getCertificada() {
        return certificada;
    }
    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    public boolean getVentaRestringida() {
        return ventaRestringida;
    }

    public void setGradosAlcohol(double gradosAlcohol) {

    }


    @Override
    public boolean tieneVentaRestringida() {
        return ventaRestringida;
    }

    @Override
    public void restringirVenta() {
        this.ventaRestringida = true;

    }

    @Override
    public boolean superaLimite(int unidades) {
        return unidades > LIMITE_UNIDADES_POR_CLIENTE;
    }

    @Override
    public double calcularPrecio() {
        int precioBase = 3500;
        if (!certificada){
            return (int) (precioBase * 1.20);
        }
        return precioBase;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Bebida Alcoholica | Nombre: " + getNombre() +
                " | Volumen: " + getVolumenML() + " ml" +
                " | Stock: " + getStock() +
                " | Grados: " + gradosAlcohol +
                " | Certificada: " + (certificada ? "Si" : "No") +
                "\n  Venta restringida: " + (ventaRestringida ? "Si" : "No") +
                " | Precio: $" + calcularPrecio();
    }
}
