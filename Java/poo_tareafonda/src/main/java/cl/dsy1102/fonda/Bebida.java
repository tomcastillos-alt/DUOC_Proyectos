package cl.dsy1102.fonda;

public abstract class Bebida {
    String nombre;
    int volumenML;
    int stock;

    public Bebida(String nombre, int volumenML, int stock) {
        this.nombre = nombre;
        this.volumenML = volumenML;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        if (nombre.trim().isEmpty()){
            throw new IllegalArgumentException("Error: El campo nombre no puede quedar vacío");
        }
        this.nombre = nombre;
    }

    public int getVolumenML() {
        return volumenML;
    }

    public void setVolumenML(int volumenML) {
        if(volumenML < 100){
            throw new IllegalArgumentException("Error: El volumen de la bebida no puede ser inferior a los 100 ML");
        }
        if(volumenML > 3000){
            throw new IllegalArgumentException("Error: El volumen de la bebida no puede ser superior a los 3000 ML");
        }
        this.volumenML = volumenML;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int Stock){
        if(stock >= 0){
            throw new IllegalArgumentException("Error: El stock de la bebida debe ser superior a 0.");
        }
    }

    public abstract double calcularPrecio();
    public abstract String obtenerDetalle();

    @Override
    public String toString(){
        return "Nombre: " + nombre + "| Volumen: " + volumenML + " ml";
    }
}
