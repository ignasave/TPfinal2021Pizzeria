package Ejercicio2;

import java.time.LocalDate;

public class Persona {
    private static int count = 0;
    private int id;
    private int dni;
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    //region Constructores
    public Persona() {
        this.id = incrementCount();
    }

    public Persona(int dni, String nombre, String apellido, LocalDate nacimiento) {
        this.id = incrementCount();
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
    }
    //endregion
    public int incrementCount () {
        this.count = count + 1;
        return count;
    }
    //region Geters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }
    //endregion
    @Override
    public String toString() {
        return "Persona{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nacimiento=" + nacimiento +
                '}';
    }

}
