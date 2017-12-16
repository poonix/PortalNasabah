package teknologi.azha.portaldebitur.utils.preference;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pooni on 10/1/2017.
 */

public class FormatDate {
    public FormatDate(){}

    public String DateFormat(String TglDate)
    {
        String [] dateParts = TglDate.split(" ");
        String date = dateParts[0];
        String time = dateParts[1];

        String[] dateFormat = date.split("-");
        String year = dateFormat[0];
        String month = dateFormat[1];
        String dated = dateFormat[2];

        return dated+"-"+month+"-"+year;
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
}
