package org.virosms.lectorversomicro.errors;

import lombok.Data;
import lombok.Getter;

@Data
public class LVAppGlobalInfo {
    @Getter
    private static String aplicationName = "lectorversomicro";

    private LVAppGlobalInfo() {
    }


    // futuramente passar el nombre de la aplicacion por contexto
//    public static void setAplicationName(String aplicationName) {
//        LVAppGlobalInfo.aplicationName = aplicationName;
//    }
}
