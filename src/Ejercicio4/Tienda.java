package Ejercicio4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Compra> compras = new ArrayList<Compra>();
    private HashMap<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
    private HashMap<Integer, Proveedor> proveedores = new HashMap<Integer, Proveedor>();

    public Tienda(ArrayList<Compra> compras, HashMap<Integer, Cliente> clientes, HashMap<Integer, Proveedor> proveedores) {
        this.compras = compras;
        this.clientes = clientes;
        this.proveedores = proveedores;
    }

    public Tienda() {
    }

    public void mostrarTodasLasCompras(){
        for(Compra compra : compras){
            System.out.println(compra.toString());
        }
    }

    public Juego juegoMasComprado(){
        HashMap<Juego, Integer> juegosComprados = new HashMap<Juego, Integer>();
        Juego juegoMC = new Juego();
        int cantidadMC = 0;
        for (Compra compra : compras){
            if(juegosComprados.containsKey(compra.getJuego())){
                juegosComprados.replace(compra.getJuego(), juegosComprados.get(compra.getJuego()) + 1);
            } else {
                juegosComprados.put(compra.getJuego(), 1);
            }
        }
        for(Map.Entry<Juego, Integer> entry : juegosComprados.entrySet()){
            if(entry.getValue() > cantidadMC){
                juegoMC = entry.getKey();
                cantidadMC = entry.getValue();
            }
        }
        return juegoMC;
    }

    public void addCliente (Cliente cliente) {
        clientes.putIfAbsent(cliente.hashCode(), cliente);
    }

    public void addProveedor (Proveedor proveedor){
        proveedores.putIfAbsent(proveedor.hashCode(), proveedor);
    }

    public void addCompra (Compra compra) {
        compras.add(compra);
    }

    public void buscarCliente () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del cliente: ");
        int clienteHash = sc.nextInt();
        Cliente cliente = clientes.get(clienteHash);
        System.out.println("El cliente es: " + cliente.toString());
    }

    public void buscarProveedor () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del proveedor: ");
        int proveedortHash = sc.nextInt();
        Proveedor proveedor = proveedores.get(proveedortHash);
        System.out.println("El cliente es: " + proveedor.toString());
    }

    public void mostrarMasComprado() {
        System.out.println("El juego mas comprado es: " + juegoMasComprado().toString());
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public HashMap<Integer, Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(HashMap<Integer, Proveedor> proveedores) {
        this.proveedores = proveedores;
    }
}
