package Ignacio.guia3.ejercicio1;

public class Circulo {
    protected float radius = 1.0F;

    private String color = "rojo";

    public float calculateArea(){
        return (float) (Math.pow(this.radius, 2) * Math.PI);
    }

    //region constructor geter y seters
    public Circulo() {
    }

    public Circulo(float radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //endregion


    @Override
    public String toString() {
        return "Circulo{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
