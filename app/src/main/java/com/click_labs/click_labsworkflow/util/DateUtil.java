package com.click_labs.click_labsworkflow.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by cl-mac-mini-3 on 1/20/17.
 */

public class DateUtil {

    public static String displayDateTimeFromHit(String utcDateAndTime, String outputFormat) {
//        java.text.DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        java.text.DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;
        try {
            date = utcFormat.parse(utcDateAndTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return "Invalid Date";
        }

//        java.text.DateFormat pstFormat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm a");
        java.text.DateFormat pstFormat = new SimpleDateFormat(outputFormat);
        pstFormat.setTimeZone(TimeZone.getDefault());
        return pstFormat.format(date);

    }
}
