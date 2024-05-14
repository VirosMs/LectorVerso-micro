package org.virosms.lectorversomicro.utils;

public class Utils {

    public static boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        return username.length() <= 20;
    }
}
