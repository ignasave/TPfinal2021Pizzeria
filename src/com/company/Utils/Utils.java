package com.company.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Utils {
    public static String generateUniqueID() {
        return UUID.randomUUID().toString().toUpperCase().substring(0, 7);
    }

    public static void cls() {
        for (int i = 0; i < 60; i++) {
            System.out.println("");
        }
    }

    public static void pressToContinue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cualquiera para continuar");
        scanner.nextLine();
    }

    public static int readInt(){
        int value = 0;
        boolean readed = false;
        while(!readed) {
            try {
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();
                readed = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de tipeo, vuelva a intentar");
            }
        }
        return value;
    }

    public static float readFloat(){
        float value = 0;
        boolean readed = false;
        while(!readed) {
            try {
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextFloat();
                readed = true;
            } catch (InputMismatchException e) {
                System.out.println("Error de tipeo, vuelva a intentar");
            }
        }
        return value;
    }


}
