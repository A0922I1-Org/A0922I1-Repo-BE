package com.example.a0922i1projectmobilephone.utils;

public class StringUtils {

    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        return "".equals(str.trim());
    }
}
