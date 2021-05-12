package Ignacio;

import Ignacio.guia3.ejercicio1.Cilindro;

public class prueba {
    public static void main(String[] args) {
        Cilindro cilindro = new Cilindro();
        System.out.println(cilindro.toString());
        Cilindro cilindro2 = new Cilindro(2, "azul", 3);
        System.out.println(cilindro2.toString());
        System.out.println();
    }
}
