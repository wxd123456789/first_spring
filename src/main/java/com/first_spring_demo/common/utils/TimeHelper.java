package com.first_spring_demo.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {
    public static String getCurrentTime(){
        Date date = new Date();
        var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        return sdf.format(date);
    }
}
