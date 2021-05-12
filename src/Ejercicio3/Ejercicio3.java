package Ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio3 {
    public static void ejercicioD() {
        Circulo circulo1 = new Circulo("1", 1);
        Circulo circulo2 = new Circulo("2", 2);
        Rectangulo rectangulo3 = new Rectangulo("3", 3);
        Rectangulo rectangulo4 = new Rectangulo("4", 4);
        Triangulo triangulo5 = new Triangulo("5", 5);
        Triangulo triangulo6 = new Triangulo("6", 6);

        ArrayList<Object> lista = new ArrayList<Object>();

        lista.add(circulo1);
        lista.add(circulo2);
        lista.add(rectangulo3);
        lista.add(rectangulo4);
        lista.add(triangulo5);
        lista.add(triangulo6);

        Iterator<Object> iter = lista.iterator();

        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
}
