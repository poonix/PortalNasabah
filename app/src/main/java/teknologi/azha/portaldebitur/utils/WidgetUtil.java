package teknologi.azha.portaldebitur.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.ButterKnife;
import teknologi.azha.portaldebitur.R;

/**
 * Created by pooni on 10/1/2017.
 */

public class WidgetUtil {

    public static void showDatePicker(Context context, final TextView textView) {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        final Calendar newCalendar = Calendar.getInstance();
        String currentValue = textView.getText().toString();
        if (!TextUtils.isEmpty(currentValue)) {
            try {
                newCalendar.setTime(dateFormatter.parse(currentValue));
            } catch (Exception e) {
            }
        }
        final DatePickerDialog datePickerDialog = new DatePickerDialog(context, null, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.setCancelable(true);
        datePickerDialog.setCanceledOnTouchOutside(true);
        datePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.btn_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int year = datePickerDialog.getDatePicker().getYear();
                int monthOfYear = datePickerDialog.getDatePicker().getMonth();
                int dayOfMonth = datePickerDialog.getDatePicker().getDayOfMonth();
                newCalendar.set(year, monthOfYear, dayOfMonth);
                if (textView != null) {
                    textView.setText(dateFormatter.format(newCalendar.getTime()));
                }
            }
        });
        datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, context.getString(R.string.btn_cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                datePickerDialog.dismiss();
            }
        });
        datePickerDialog.show();
    }

    /*
    public static void setSpinnerSelectionById(Spinner spinner, Object identifer) {
        for (int i = 0; i < spinner.getCount(); i++) {
            Object obj = spinner.getItemAtPosition(i);
            if (obj != null && obj instanceof BaseMasterModel) {
                //check dropdown item by id
                Object objIdentifier = ((BaseMasterModel) obj).getIdentifier();
                if (objIdentifier != null && identifer != null && objIdentifier.toString().equals(identifer.toString())) {
                    spinner.setSelection(i);
                    break;
                }
            }

            //check dropdoan item by value
            if (obj != null && identifer != null && obj.toString().equalsIgnoreCase(identifer.toString())) {
                spinner.setSelection(i);
                break;
            }
        }
    }*/

    public static int getSpinnerIndexByLabel(Spinner spinner, String myString) {
        int index = 0;
        if (TextUtils.isEmpty(myString)) {
            return 0;
        }

        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static ArrayAdapter createAdapterTahunFromNow(Context context) {
        ArrayList<String> arrTahun = new ArrayList<>();
        arrTahun.add("Pilih");
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i >= 1970; i--) {
            arrTahun.add(Integer.toString(i));
        }
        //ArrayAdapter<String> adapterTahun = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, arrTahun);
        ArrayAdapter<String> adapterTahun = new ArrayAdapter<String>(context, R.layout.item_spinner, arrTahun);
        //adapterTahun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTahun.setDropDownViewResource(R.layout.item_dropdown);

        return adapterTahun;
    }

    public static ArrayAdapter createAdapterTahun(Context context) {
        ArrayList<String> arrTahun = new ArrayList<>();
        arrTahun.add("Pilih");
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i >= 1920; i--) {
            arrTahun.add(Integer.toString(i));
        }
        //ArrayAdapter<String> adapterTahun = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, arrTahun);
        ArrayAdapter<String> adapterTahun = new ArrayAdapter<String>(context, R.layout.item_spinner, arrTahun);
        //adapterTahun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTahun.setDropDownViewResource(R.layout.item_dropdown);

        return adapterTahun;
    }

    public static ArrayAdapter createAdapterBulan(Context context) {
        ArrayList<String> arrBulan = new ArrayList<>();
        arrBulan.add("Pilih");
        for (int i = 1; i <= 12; i++) {
            arrBulan.add(String.format("%02d", i));
        }
        //ArrayAdapter<String> adapterBulan = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, arrBulan);
        ArrayAdapter<String> adapterBulan = new ArrayAdapter<>(context, R.layout.item_spinner, arrBulan);
        //adapterBulan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterBulan.setDropDownViewResource(R.layout.item_dropdown);

        return adapterBulan;
    }

    public static ArrayAdapter createAdapterTanggal(Context context) {
        ArrayList<String> arrTanggal = new ArrayList<>();
        arrTanggal.add("Pilih");
        for (int i = 1; i <= 31; i++) {
            arrTanggal.add(String.format("%02d", i));
        }

        //ArrayAdapter<String> adapterTgl = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, arrTanggal);
        ArrayAdapter<String> adapterTgl = new ArrayAdapter<String>(context, R.layout.item_spinner, arrTanggal);
        //adapterTgl.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterTgl.setDropDownViewResource(R.layout.item_dropdown);

        return adapterTgl;
    }

    public static void setDefaultEmptyAdapter(Spinner spinner) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Pilih");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner.setAdapter(adapter);
    }

    public static void setDataMasterAdapter(Spinner spinner, List arrData) {
        if (arrData != null && arrData.size() > 0) {
            ArrayAdapter adapter = new ArrayAdapter<>(spinner.getContext(), android.R.layout.simple_spinner_item, arrData);
            //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            adapter.setDropDownViewResource(R.layout.item_dropdown);
            spinner.setAdapter(adapter);
        } else {
            setDefaultEmptyAdapter(spinner);
        }
    }

    /*public static void setButtonDrawableTop(Button button, int iconResId) {
        //get drawable from svg resource
        Drawable drawabale = AppCompatResources.getDrawable(button.getContext(), iconResId);
        int h = drawabale.getIntrinsicHeight();
        int w = drawabale.getIntrinsicWidth();
        drawabale.setBounds(0, 0, w, h);
        button.setCompoundDrawables(null, drawabale, null, null);
    }

    public static void setButtonDrawableTopColor(Button button, int iconResId, int color) {
        Drawable originalIcon = AppCompatResources.getDrawable(button.getContext(), iconResId);
        Drawable icon = convertDrawableColor(originalIcon, color);
        button.setCompoundDrawables(null, icon, null, null);
    }*/

    public static Drawable convertDrawableColor(Drawable drawable, int color) {
        if (drawable == null)
            return null;

        Drawable res = drawable.mutate();
        res.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        return res;
    }

    public static boolean validateField(TextView view, String errorMsg) {
        if (!TextUtils.isEmpty(view.getText())) {
            return true;
        } else {
            if (!TextUtils.isEmpty(errorMsg)) {
                showToast(view.getContext(), errorMsg);
            }
            view.requestFocus();
            return false;
        }
    }

    /*public static boolean validateField(EditText view, String errorMsg) {
        if (!TextUtils.isEmpty(view.getText().toString())) {
            return true;
        } else {
            if (!TextUtils.isEmpty(errorMsg)) {
                showToast(view.getContext(), errorMsg);
            }
            view.requestFocus();
            return false;
        }
    }*/

    public static boolean validateField(Spinner spinner, String errorMsg) {
        if (spinner.getSelectedItemPosition() > 0) {
            return true;
        } else {
            if (!TextUtils.isEmpty(errorMsg)) {
                showToast(spinner.getContext(), errorMsg);
            }
            spinner.setFocusable(true);
            spinner.setFocusableInTouchMode(true);
            spinner.requestFocusFromTouch();
            return false;
        }
    }

    public static int getNumberFromField(Spinner spinner) {
        int value = 0;
        try {
            value = Integer.parseInt(spinner.getSelectedItem().toString());
        } catch (Exception e) {
        }

        return value;
    }

    public static double getNumberValueFromField(TextView textView) {
        String value = getNumberFromField(textView);
        double iVal = 0;
        try {
            iVal = Double.parseDouble(value);
        }catch (Exception e) {}

        return iVal;
    }

    public static String getNumberFromField(TextView textView) {
        String value = textView.getText().toString();
        value = value.replaceAll("[^\\d]", "");
        if (TextUtils.isEmpty(value))
            value = "0";
        return value;
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static final ButterKnife.Setter<TextView, Integer> SET_COLOR = new ButterKnife.Setter<TextView, Integer>() {
        @Override
        public void set(TextView view, Integer value, int index) {
            view.setTextColor(value);
        }
    };

    /*public static void setTextWatcherNPWP(final TextView textView) {
        textView.setInputType(EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_VARIATION_NORMAL);
        textView.setKeyListener(DigitsKeyListener.getInstance("0123456789.-"));
        textView.addTextChangedListener(new NumberTextWatcher("##.###.###.#-###.###"));
    }*/

    public static void setTextWatcherCurrency(final TextView textView) {
        setTextWatcherCurrency(textView, Config.MAX_CURRRENCY_VALUE);
    }
    public static void setTextWatcherCurrency(final TextView textView, double maxValue) {
        textView.setInputType(EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_FLAG_DECIMAL);
        textView.setKeyListener(DigitsKeyListener.getInstance("0123456789-,"));
        NumberTextWatcher watcher = new NumberTextWatcher();
        if (maxValue > 0) {
            watcher.setMaxValue(maxValue);
        }
        textView.addTextChangedListener(watcher);
    }

    public static void setMaxChar(TextView textView, int maxChar) {
        textView.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxChar)});
    }

    public static String convertToLocalCurrency(String strValue) {
        int iVal = 0;
        try {
            /*
            DecimalFormat format = new DecimalFormat();
            DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
            decimalFormatSymbols.setDecimalSeparator('.');
            format.setDecimalFormatSymbols(decimalFormatSymbols);
            format.setDecimalSeparatorAlwaysShown(false);
            strValue = format.format(strValue);
            */
            if (strValue.lastIndexOf(".") > 0) {
                strValue = strValue.substring(0, strValue.lastIndexOf("."));
            }
            iVal = Integer.parseInt(strValue);
        } catch (Exception e) {
        }

        return convertToLocalCurrency(iVal);
    }

    public static String convertToLocalCurrency(int value) {
        //return String.format("%,d", value);

        String result = String.valueOf(value);
        DecimalFormat nf = new DecimalFormat("###,###,###,###");
        try {
            String formatted = nf.format(value);
            result = formatted;
        } catch (NumberFormatException nfe) {
        }

        return result;
    }

    public static String convertToLocalCurrency(double value) {
        String result = String.valueOf(value);
        DecimalFormat nf = new DecimalFormat("###,###,###,###");
        try {
            String formatted = nf.format(value);
            result = formatted;
        } catch (NumberFormatException nfe) {
        }

        return result;
    }


}
