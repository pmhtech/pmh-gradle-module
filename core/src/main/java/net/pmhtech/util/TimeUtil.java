package net.pmhtech.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeUtil {

    public static Long getTime(){

        Long time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            time = sdf.parse(sdf.format(new Date())).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static Boolean isMatchWeekDay(String gmtOffset, Integer repeatOptions){

        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone(gmtOffset));
        Integer weekday = cal.get(Calendar.DAY_OF_WEEK)-1;

        if((repeatOptions & 1<<weekday) ==0){
            return false;
        }
        return true;
    }

    public static Long getMidnight(String gmtOffset){

        SimpleDateFormat sdfLocal = new SimpleDateFormat("yyyy-MM-dd");
        sdfLocal.setTimeZone(TimeZone.getTimeZone(gmtOffset));
        Long time = null;
        try {
            time = sdfLocal.parse( sdfLocal.format(new Date()) ).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String getLocaleDay(String gmtOffset){
        String localeDay = null;
        SimpleDateFormat sdfLocal = new SimpleDateFormat("yyyyMMdd");
        sdfLocal.setTimeZone(TimeZone.getTimeZone(gmtOffset));
        localeDay= sdfLocal.format(new Date());

        return localeDay;

    }

}
