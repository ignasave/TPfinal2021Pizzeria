package Ejercicio3;

public abstract class Figura {
    public String color;
    public int size;

    public Figura(String color, int size) {
        this.color = color;
        this.size = size;
    }

    public Figura() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
