package Ejercicio4;

import java.time.LocalDate;

public class Cliente extends Persona{
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, LocalDate fechaRegistro) {
        super(nombre, apellido);
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente() {
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += fechaRegistro.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "fechaRegistro=" + fechaRegistro + super.toString() +
                '}';
    }
}
