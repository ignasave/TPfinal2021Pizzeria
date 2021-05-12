package Ignacio.guia2.ejercicio1;
/*  antes del punto h
     Autor author = new Autor("Joshua", "Bloch", "joshua@email.com", 'M');
        System.out.println(author.toString());
        Libro libro = new Libro("Effective Java", 450, 150, );
        System.out.println(libro.toString());
        libro.setPrice(500);
        libro.setStock(libro.getStock() + 50);
        System.out.println(libro.getAuthor().toString());
        libro.printMessage();*/
public class Libro {
    private String title;
    private float price;
    private int stock;
    private Autor[] author;

    public Libro() {
    }

    public Libro(String title, float price, int stock, Autor[] author) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Autor[] getAuthor() {
        return author;
    }

    public void setAuthor(Autor[] author) {
        this.author = author;
    }

    public void printMessage() {
        String output;
        output = "El libro, " + this.title + " de ";
        for (Autor autorActual: author) {
            output = output + autorActual.getName() + " y ";
        }
        output = output.substring(0, output.length() - 2);
        output = output + ".Se vende a " + this.price + " pesos";
        System.out.println(output);
    }

    @Override
    public String toString() {
        return "Titulo: " + title + "  Precio: " + price + "  Stock: " + stock + "\nAutor: " + author.toString();
    }
}


