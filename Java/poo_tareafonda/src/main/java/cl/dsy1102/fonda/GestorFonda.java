package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {

    private List<Bebida> bebidas;

    public GestorFonda() {
        this.bebidas = new ArrayList<>();
    }

    public void registrar(Bebida bebida) {
        bebidas.add(bebida);
        System.out.println(bebida.getNombre() + " (" + bebida.getClass().getSimpleName() + ") registrada correctamente!");
    }

    public void buscarPorNombre(String nombre) {
        System.out.printf("%n=== BUSQUEDA POR NOMBRE: \"%s\" ===%n", nombre);
        for (Bebida i : bebidas) {
            if (i.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(i.obtenerDetalle());
                System.out.println("---");
            }
        }
    }

    public void venderBebida(String nombre, int cantidad) {
        Bebida encontrada = null;
        for (Bebida b : bebidas) {
            if (b.getNombre().equalsIgnoreCase(nombre)) {
                encontrada = b;
                break;
            }
        }

        if (encontrada == null) {
            System.out.println("Venta rechazada: La bebida " + nombre + " no existe.");
            return;
        }

        if (encontrada instanceof ConsumoResponsable) {
            ConsumoResponsable cr = (ConsumoResponsable) encontrada;
            if (cr.tieneVentaRestringida()) {
                System.out.println("Venta rechazada: " + encontrada.getNombre() + " tiene la venta restringida.");
                return;
            }
            if (cr.superaLimite(cantidad)) {
                System.out.println("Venta rechazada: " + cantidad + " unidades de " + encontrada.getNombre() + " superan el limite de 3 por cliente.");
                return;
            }
        }

        int total = (int) (encontrada.calcularPrecio() * cantidad);
        System.out.println("Venta autorizada: " + cantidad + " x " + encontrada.getNombre() + " | Total: $" + total);
    }

    public void obtenerTodas() {
        System.out.println("\n=== LISTADO DE BEBIDAS ===");
        for (Bebida b : bebidas) {
            System.out.println(b.toString());
        }
    }
}