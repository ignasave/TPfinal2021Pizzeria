package Ignacio.guia1.Enunciado2;

        //MAIN CODE
/*      Enunciado2 carlos = new Enunciado2(23456345, "Carlos", "Gutierrez", 25000);
        Enunciado2 ana = new Enunciado2(34234123, "Ana", "Sanchez", 27500);
        carlos.printEmpleado();
        ana.printEmpleado();
        carlos.raiseRevenueWithPercentaje(15);
        System.out.println("Salario de carlos aumentado 15%: " + String.valueOf(carlos.getAnualRevenue()));
        */

public class Enunciado2 {

    private int dni;
    private String name;
    private String lastname;
    private float revenue;

    public Enunciado2 (int dni, String name, String lastname, float revenue){
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.revenue = revenue;
    }

    public Enunciado2 () {}

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public int getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public float getRevenue() {
        return revenue;
    }

    public float getAnualRevenue() {
        return this.revenue * 12;
    }

    public void raiseRevenueWithPercentaje(float percentaje) {
        this.revenue = this.revenue + (this.revenue * (percentaje / 100) );
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", NOMBRE Y APELLIDO: " + name + ' ' + lastname + ", SALARIO: " + revenue;
    }
}
