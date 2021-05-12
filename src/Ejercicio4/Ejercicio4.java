package Ejercicio4;

import java.time.LocalDate;

public class Ejercicio4 {
    public static void muestraSistema() {
        Tienda tienda = new Tienda();
        Cliente cliente1 = new Cliente("Ignacio", "Vazquez", LocalDate.of(2021, 03,03));
        Cliente cliente2 = new Cliente("Martin", "Gonzales", LocalDate.of(2021, 03,03));
        Proveedor provedor1 = new Proveedor("Oscar", "Ricardo", Categoria.ACCION);
        Proveedor provedor2 = new Proveedor("Natasha", "Sussi", Categoria.AVENTURA);
        Juego juego1 = new Juego(Categoria.ESTRATEGIA,"Age of Empires");
        Juego juego2 = new Juego(Categoria.AVENTURA, "Skyrim");
        Compra compra1 = new Compra(cliente1, juego1, LocalDate.of(2021, 04, 04));
        Compra compra2 = new Compra(cliente2, juego2, LocalDate.of(2021, 04, 04));
        Compra compra3 = new Compra(cliente1, juego1, LocalDate.of(2021, 04, 04));
        tienda.addCliente(cliente1);
        tienda.addCliente(cliente2);
        tienda.addProveedor(provedor1);
        tienda.addProveedor(provedor2);
        tienda.addCompra(compra1);
        tienda.addCompra(compra2);
        tienda.addCompra(compra3);
        tienda.mostrarTodasLasCompras();
        tienda.mostrarMasComprado();
    }
}
