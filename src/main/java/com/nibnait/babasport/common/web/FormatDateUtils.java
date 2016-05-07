package com.nibnait.babasport.common.web;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nibnait on 2016/5/4.
 */
public class FormatDateUtils {

    /**将日期类型转换成String类型，yyMMdd格式*/
    public static String dateToString1(Date date) {
        String sDate = new SimpleDateFormat("yyMMdd").format(date);
        return sDate;
    }

    /**将日期类型转换成String类型，yyyy-MM-dd HH:mm:ss格式*/
    public static String dateToString2(Date date) {
        String sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        return sDate;
    }

    /**将日期类型转换成String类型，yyyyMMddHHmmssSSS格式*/
    public static String dateToString3(Date date){
        String sDate = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
        return sDate;
    }
}
