package Ejercicio2;

import java.time.LocalDate;

public class Empleado extends Persona{
    private int salario;
    private int numeroDeDepartamento;

    //region Constructores
    public Empleado() {
    }

    public Empleado(int salario, int numeroDeDepartamento) {
        this.salario = salario;
        this.numeroDeDepartamento = numeroDeDepartamento;
    }

    public Empleado(int dni, String nombre, String apellido, LocalDate nacimiento, int salario, int numeroDeDepartamento) {
        super(dni, nombre, apellido, nacimiento);
        this.salario = salario;
        this.numeroDeDepartamento = numeroDeDepartamento;
    }
    //endregion
    //region Geters y Setters
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getNumeroDeDepartamento() {
        return numeroDeDepartamento;
    }

    public void setNumeroDeDepartamento(int numeroDeDepartamento) {
        this.numeroDeDepartamento = numeroDeDepartamento;
    }
    //endregion
    @Override
    public String toString() {
        return "Empleado{" +
                "salario=" + salario +
                ", numeroDeDepartamento=" + numeroDeDepartamento +
                '}' + super.toString();
    }
}
