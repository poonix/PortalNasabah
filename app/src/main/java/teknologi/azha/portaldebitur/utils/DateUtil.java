package teknologi.azha.portaldebitur.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by pooni on 11/17/2017.
 */

public class DateUtil {

    public static String convertDateToNormal(String dateSting) {
        String s = convertDateString(dateSting, "yyyy-MM-dd", "dd-MM-yyyy");
        if (s != null && s.equals("01-01-1900")) {
            s = "";
        }
        return s;
    }

    public static String convertDateToDB(String dateSting) {
        return convertDateString(dateSting, "dd-MM-yyyy", "yyyy-MM-dd");
    }

    public static String convertDateString(String dateString, String formatFrom, String formatTo) {
        String result = "";
        Date convertedDate;
        try {
            convertedDate = new SimpleDateFormat(formatFrom).parse(dateString);
            result = new SimpleDateFormat(formatTo).format(convertedDate);
        } catch (Exception e) {
            //Log.d("TAG", e.getMessage());
        }

        /*if (TextUtils.isEmpty(result)) {
            result = "1900-01-01";
        }*/

        return result;
    }

    public static int getAge(String dateOfBirth) {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        int age = 0;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        birthDate.setTime(convertedDate);
        if (birthDate.after(today)) {
            //throw new IllegalArgumentException("Can't be born in the future");
            return -1;
        }

        age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        // If birth date is greater than todays date (after 2 days adjustment of
        // leap year) then decrement age one year
        if ((birthDate.get(Calendar.DAY_OF_YEAR)
                - today.get(Calendar.DAY_OF_YEAR) > 3)
                || (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
            age--;

            // If birth date and todays date are of same month and birth day of
            // month is greater than todays day of month then decrement age
        } else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
                && (birthDate.get(Calendar.DAY_OF_MONTH) > today
                .get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }

    public static String getCurrentDateTimeAsString(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }

    public static int getDayDiff(String dateString) {
        return getDayDiff(dateString, "yyyy-MM-dd");
    }

    public static int getDayDiff(String dateString, String dateFormat) {
        Date comparedDate = new Date();
        try {
            comparedDate = new SimpleDateFormat(dateFormat).parse(dateString);
        } catch (Exception e) {
            //Log.d("TAG", e.getMessage());
        }

        int diff = 0;
        Calendar today = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.setTime(comparedDate);

        if (today.get(Calendar.YEAR) > cal.get(Calendar.YEAR)) {
            int yearDiff = (today.get(Calendar.YEAR) - cal.get(Calendar.YEAR) - 1) * 365;
            diff = today.get(Calendar.DAY_OF_YEAR) + (cal.getActualMaximum(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR)) + yearDiff;
        } if (today.get(Calendar.YEAR) < cal.get(Calendar.YEAR)) {
            int yearDiff = (cal.get(Calendar.YEAR) - today.get(Calendar.YEAR) - 1) * 365;
            diff = today.get(Calendar.DAY_OF_YEAR) - today.getActualMaximum(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR) - yearDiff;
        } else {
            diff = today.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
        }

        //long diffInMillis = Math.abs(today.getTimeInMillis() - cal.getTimeInMillis());
        //int actualDiffValue = (int)(diffInMillis / (24 * 60 * 60 * 1000));

        return diff;
    }


    public static long getDateDiff(long time, int field) {
        return getDateDiff(Calendar.getInstance().getTimeInMillis(), time, field);
    }

    public static long getDateDiff(long curTime, long time, int field) {
        long diffInMillis = Math.abs(curTime - time);

        switch (field) {
            case Calendar.SECOND:
                return TimeUnit.MILLISECONDS.toSeconds(diffInMillis);
            case Calendar.MINUTE:
                return TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
            case Calendar.HOUR:
                return TimeUnit.MILLISECONDS.toHours(diffInMillis);
            default:
                return TimeUnit.MILLISECONDS.toDays(diffInMillis);
        }

    }

    public static long getTimemillis(String strTanggal, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date convertedDate;
        try {
            convertedDate = dateFormat.parse(strTanggal);
            return convertedDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}