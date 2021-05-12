package Ejercicio4;

public class Proveedor extends Persona{
    private Categoria categoriaIngresada;

    public Proveedor(String nombre, String apellido, Categoria categoriaIngresada) {
        super(nombre, apellido);
        this.categoriaIngresada = categoriaIngresada;
    }

    public Proveedor(Categoria categoriaIngresada) {
        this.categoriaIngresada = categoriaIngresada;
    }

    public Proveedor() {
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result += 31 * categoriaIngresada.hashCode();
        return result;
    }

}
