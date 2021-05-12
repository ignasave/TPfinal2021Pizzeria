package Ignacio.guia3.ejercicio1;

public class Cilindro extends Circulo{
    private float height = 1.0F;

    public float calculateVolume () {
        return height * this.calculateArea();
    }
    @Override
    public float calculateArea(){
        return (float) (2 * Math.PI * this.radius * this.height + 2 * super.calculateArea() * super.color);
    }

    //region Constructor geters y seters
    public Cilindro(float radius, String color, float height) {
        super(radius, color);
        this.height = height;
    }

    public Cilindro() {
        super();
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
    //endregion

    @Override
    public String toString() {
        return "Cilindro{" +
                "height=" + height +
                '}' + super.toString();
    }
}
