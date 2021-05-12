package Ignacio.guia0;

import java.util.Scanner;

public class Guia0 {


    public static void ejercicio1() {
        int N = 10;
        double A = 1.001;
        char C = 'c';
        double suma = N + A;
        double resta = A - N;
        System.out.println("N: " + N);
        System.out.println("A: " + A);
        System.out.println("C: " + C);
        System.out.println("N + A: " + suma);
        System.out.println("A - N: " + resta);
        System.out.println(String.format("C: %s", Integer.valueOf(C)));
    }

    public static void ejercicio2() {
        int X = 5;
        int Y = 7;
        double N = 1004;
        double M = 812;

        System.out.println("Suma de todo:" + String.valueOf(X + Y + N + M));
        System.out.println("Resta de todo:" + String.valueOf(X - Y - N - M));

    }

    public static void ejercicio3(){
        int N = 10;
        N = N + 77;
        N = N - 3;
        N = N * 2;
    }

    public static void ejercicio4(){
        int A = 5;
        int B = 7;
        int C = 9;
        int D = 10;
        B = C;
        C = A;
        A = D;
        D = B;
    }

    public static void ejercicio5(){
        int A = 10;
        if (A % 2 == 0){
            System.out.println("A es par");
        } else {
            System.out.println("A es impar");
        }
    }

    public static void ejercicio6(){
        int B = 10;
        if(B >= 0){
            System.out.println("Positivo");
        } else {
            System.out.println("Negativo");
        }
    }

    public static void ejercicio7(){
        int C = 10;
        System.out.print("El numero " + C + " es: ");
        if(C >= 0){
            System.out.print("positivo, ");
        } else {
            System.out.print("negativo, ");
        }
        if (C % 2 == 0){
            System.out.print("par, ");
        } else {
            System.out.print("impar, ");
        }
        if (C % 5 == 0){
            System.out.print("multiplo de 5, ");
        } else {
            System.out.print("no es multimplo de 5, ");
        }
        if (C % 10 == 0){
            System.out.print("multiplo de 10, ");
        } else {
            System.out.print("no es multimplo de 10, ");
        }
        if (C >= 100){
            System.out.print("mayor o igual a 100.");
        } else {
            System.out.print("menor que 100.");
        }
    }

    public static void ejercicio8(){
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Buenos dias, " + nombre);
    }

    public static void ejercicio9(){
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        int doble = numero * 2;
        int triple = numero * 3;
        System.out.println("Numero: " + numero + " ,doble: " + doble + " ,triple:" + triple);
    }

    public static void ejercicio10(){
        Scanner sc = new Scanner(System.in);
        float gradosF = sc.nextFloat();
        float gradosC = (gradosF - 32) * 5/9;
        System.out.println("Grados en Centigrados: " + gradosC);
    }

    public static void ejercicio11(){
        Scanner sc = new Scanner(System.in);
        float radio = sc.nextFloat();
        float area = (float) (Math.pow(radio, 2) * Math.PI);
        float longitud = (float) (2 * Math.PI * radio);
        System.out.println("Longitud: " + longitud + " ,Area: " + area);
    }

    public static void ejercicio12(){
        Scanner sc = new Scanner(System.in);
        float velocidadMS = sc.nextFloat();
        float velocidadKMH = (float) (velocidadMS * 3.6);
        System.out.println(velocidadKMH);
    }

    public static void ejercio13(){
        Scanner sc = new Scanner(System.in);
        float cateto1 = sc.nextFloat();
        float cateto2 = sc.nextFloat();
        float hipotenusa = (float) (Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2)));
        System.out.println(hipotenusa);
    }

    public static void ejercicio14(){
        Scanner sc = new Scanner(System.in);
        float radio = sc.nextFloat();
        float volumen = (float) (4/3 * Math.PI * Math.pow(radio, 3));
        System.out.println(volumen);
    }

    public static float ejercicio15(){
        Scanner sc = new Scanner(System.in);
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        float c = sc.nextFloat();

        float s = (a + b + c) / 2;

        return (float) Math.sqrt(s * (s - a ) * (s - b) * (s - c));

    }

    public static void ejercicio16(){
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (number < 100 || number > 1000) {
            number = sc.nextInt();
        }
        String string = String.valueOf(number);
        String[] ciphers =  string.split("|");
        System.out.println(ciphers[0] + '.' + ciphers[1] + '.' +  ciphers[2]);
    }
    //este depende de lo que llames "posiciones impares" si contas que empieza en 0 o 1
    public static void ejercicio17(){
        Scanner sc = new Scanner(System.in);
        int number = 0;
        while (number < 10000 || number > 100000) {
            number = sc.nextInt();
        }
        String string = String.valueOf(number);
        String[] ciphers =  string.split("|");
        System.out.println(ciphers[0] + '.' + ciphers[2] + '.' +  ciphers[4]);
    }

    public static void ejercicio18(){
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int S = sc.nextInt();
        boolean valid = false;

        if(H < 24 || H > 0){
            if(M < 60 || M > 0){
                if(S < 60 || S > 0){
                    valid = true;
                }
            }
        }

        if(valid){
            System.out.println("Valido");
        } else {
            System.out.println("Invalido");
        }

    }
}
