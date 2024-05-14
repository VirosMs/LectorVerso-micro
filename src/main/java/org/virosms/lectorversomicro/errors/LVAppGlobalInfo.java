package org.virosms.lectorversomicro.errors;

import lombok.Data;

@Data
public class LVAppGlobalInfo {
    private static String aplicationName = "lectorversomicro";

    private LVAppGlobalInfo() {
    }

    public static String getAplicationName() {
        return aplicationName;
    }


    // futuramente passar el nombre de la aplicacion por contexto
//    public static void setAplicationName(String aplicationName) {
//        LVAppGlobalInfo.aplicationName = aplicationName;
//    }
}
