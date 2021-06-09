package com.company.Utils;

import java.util.UUID;

public class Utils {
    public static String generateUniqueID () {
        return UUID.randomUUID().toString().toUpperCase().substring(0,7);
    }
}
