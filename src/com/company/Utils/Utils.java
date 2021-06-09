package com.company.Utils;

import java.util.UUID;

public class Utils {
    public static String generateUniqueID () {
        return UUID.randomUUID().toString().toUpperCase().substring(0,7);
    }
    public static void cls() {
        for (int i = 0; i < 60; i++) {
            System.out.println("");
        }
    }
}
