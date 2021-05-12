package Ejercicio4;

import java.time.LocalDate;

public class Compra {
    private Cliente cliente;
    private Juego juego;
    private LocalDate fecha;

    public Compra(Cliente cliente, Juego juego, LocalDate fecha) {
        this.cliente = cliente;
        this.juego = juego;
        this.fecha = fecha;
    }

    public Compra() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "cliente=" + cliente.toString() +
                ", juego=" + juego.toString() +
                ", fecha=" + fecha.toString() +
                '}';
    }
}
