package Ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    public static void ejercicioA () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese un numero: ");
        int numero = sc.nextInt();
        if(numero > 0) {
            System.out.println("El numero es positivo");
        } else if (numero < 0){
            System.out.println("El numero es negativo");
        } else {
            System.out.println("El numero es 0");
        }
    }
    public static void ejercicioB () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Hola, " + nombre + " espero que tengas buen dia!");
    }
    public static void ejercicioC () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese un numero: ");
        int numero1 = sc.nextInt();
        System.out.println("Ingrese otro : ");
        int numero2 = sc.nextInt();
        String resultado;
        if(numero1 > numero2){
            resultado = "primero";
        } else {
            resultado = "segundo";
        }
        System.out.println("El " + resultado + " es mas grande");
    }
}
