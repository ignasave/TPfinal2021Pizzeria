package Ignacio.guia1.Enunciado3;

public class Enunciado3 {
    private int id;
    private String descripcion;
    private int cantidad;
    private float pUnitario;
    private float pTotal;

    public Enunciado3(int id, String descripcion, int cantidad, float pUnitario, float pTotal) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.pUnitario = pUnitario;
        this.pTotal = pTotal;
    }

    public Enunciado3() {}

    public void calculateTotalP () {
        this.pTotal = pUnitario * cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad > 0 ? cantidad : 0;
    }

    public float getpUnitario() {
        return pUnitario;
    }

    public void setpUnitario(float pUnitario) {
        this.pUnitario = pUnitario > 0 ? pUnitario : 0;
    }

    public float getpTotal() {
        return pTotal;
    }

    public void setpTotal(float pTotal) {
        this.pTotal = pTotal;
    }

    @Override
    public String toString() {
        return "ItemVenta[id=" + id + ", descripcion=" + descripcion + ", cantidad=" + cantidad +
                ", pUnitario=" + pUnitario + ", pTotal=" + pTotal;
    }
}
