package com.wxd.my_mall.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {
    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        return sdf.format(date);
    }
}
