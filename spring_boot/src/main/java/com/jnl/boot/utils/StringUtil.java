package com.jnl.boot.utils;

public class StringUtil {

    public static String captureName(String name) {

        return name.substring(0, 1).toUpperCase() + name.substring(1);

    }
}
