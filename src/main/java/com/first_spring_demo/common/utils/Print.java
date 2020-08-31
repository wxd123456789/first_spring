package com.first_spring_demo.common.utils;

public class Print {
    public static void print(String msg, String... args) {
        if (args.length == 0) {
            System.out.println(msg);
            return;
        }
        String message = String.format(msg, args);
        System.out.println(message);
    }
}
