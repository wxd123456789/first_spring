package com.first_spring_demo.common.utils;

import java.util.UUID;

public class UUIDHelper {
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
