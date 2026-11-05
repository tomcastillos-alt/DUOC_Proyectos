package cl.dsy1102.fonda;

public class Main {

    public static void main(String[] args) {

        GestorFonda gestor = new GestorFonda();

        BebidaAlcoholica chichaAlcohol = new BebidaAlcoholica("Chicha", 1000, 40, 12.0, false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 500, 25, 18.0, true);
        BebidaSinAlcohol chichaSana = new BebidaSinAlcohol("Chicha", 1000, 60, 95);
        BebidaSinAlcohol moteHuesillo = new BebidaSinAlcohol("Mote con Huesillo", 400, 50, 70);



        // TODO 1: instanciar las cuatro bebidas con los datos del enunciado.
        // TODO 2: marcar la bebida alcoholica 'Chicha' con la venta restringida.
        // TODO 3: registrarlas todas en el gestor.
        // TODO 4: solicitar las cuatro ventas indicadas en el enunciado.
        // TODO 5: buscar por nombre "Chicha" y listar todas las bebidas.

        chichaAlcohol.restringirVenta();
        gestor.registrar(chichaAlcohol);
        gestor.registrar(piscoSour);
        gestor.registrar(chichaSana);
        gestor.registrar(moteHuesillo);


        gestor.buscarPorNombre("Chicha");

        System.out.println("=== VENTAS ===");
        gestor.venderBebida("Pisco Sour", 2);
        gestor.venderBebida("Pisco Sour", 5);
        gestor.venderBebida("Chicha", 1);
        gestor.venderBebida("Mote con Huesillo", 6);

        gestor.obtenerTodas();

    }
}
