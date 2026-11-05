package cl.dsy1102.fonda;

public class BebidaSinAlcohol extends Bebida {
    int azucarPorLitro;


    public BebidaSinAlcohol(String nombre, int volumen, int stock, int azucarPorLitro) {
        super(nombre, volumen, stock);
        setAzucarPorLitro(azucarPorLitro);
    }

    public int getAzucarPorLitro() {
        return azucarPorLitro;
    }

    public void setAzucarPorLitro(int azucarPorLitro) {
        if(azucarPorLitro < 0){
            throw new IllegalArgumentException("Error: El valor de azúcar por litro no puede ser negativo.");
        }
        this.azucarPorLitro = azucarPorLitro;
    }


    @Override
    public double calcularPrecio() {
        int precioBase = 2000;
        if(azucarPorLitro > 80){
            return (int)  (precioBase * 1.10);
        }
        return precioBase;
    }

    @Override
    public String obtenerDetalle() {
        return "Tipo: Bebida Sin Alcohol | Nombre: " + getNombre() +
                " | Volumen: " + getVolumenML() + " ml" +
                " | Stock: " + getStock() +
                " | Azucar: " + (int) azucarPorLitro + " g/L" +
                " | Precio: $" + calcularPrecio();
    }


}
