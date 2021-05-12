package Ejercicio4;

import java.util.Objects;

public class Juego {
    private Categoria categoria;
    private String nombre;

    public Juego(Categoria categoria, String nombre) {
        this.categoria = categoria;
        this.nombre = nombre;
    }

    public Juego() {
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "categoria=" + categoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
