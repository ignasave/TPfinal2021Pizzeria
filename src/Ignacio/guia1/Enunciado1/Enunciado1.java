package Ignacio.guia1.Enunciado1;

    // MAIN CODE
    /*  Enunciado1 rectangulo = new Enunciado1(4.0F, 6.0F);
        String mostrar = "Width: " + String.valueOf(rectangulo.getWidth()) + ", Height: " + String.valueOf(rectangulo.getHeight());
        System.out.println(mostrar);
        System.out.println("Area: " + String.valueOf(rectangulo.calculateArea()));
        System.out.println("Perimeter: " + String.valueOf(rectangulo.calculatePerimeter()));
        rectangulo.setWidth(2.0F);
        rectangulo.setHeight(2.0F);
        System.out.println("Area: " + String.valueOf(rectangulo.calculateArea()));
        System.out.println("Perimeter: " + String.valueOf(rectangulo.calculatePerimeter()));
    */

public class Enunciado1 {
    private float width = 1.0F;
    private float height = 1.0F;

    public Enunciado1 (float width, float height) {
        this.width = width;
        this.height = height;
    }

    public Enunciado1 (){}

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public float calculateArea() {
        return this.width * this.height;
    }

    public float calculatePerimeter() {
        return 2 * (this.height + this.width);
    }
}
