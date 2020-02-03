package nal.test.planning.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Common of project
 * @author TuanNH
 */
public class Common {

    /**
     * Is valid date
     * @param dateToValidate
     * @param dateFromat
     * @return
     */
    public static boolean isDateValid(String dateToValidate, String dateFromat){

        try {
            // check date null is return false
            if(dateToValidate == null){
                return false;
            }

            SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);

            //if not valid, it will throw ParseException
            sdf.parse(dateToValidate);

        } catch (ParseException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Convert Date
     * @param target
     * @param format
     * @return Date converted
     * @throws ParseException
     */
    public static Date convDate(String target, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(target);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
