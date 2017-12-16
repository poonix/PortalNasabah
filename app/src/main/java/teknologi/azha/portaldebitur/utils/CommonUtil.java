package teknologi.azha.portaldebitur.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import teknologi.azha.portaldebitur.ui.factory.DialogFactory;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by pooni on 9/2/2017.
 */

public class CommonUtil {
    public static boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return (netInfo != null && netInfo.isConnected());
    }

    public static void checkInternet(Context context) {
        if (!isConnected(context)) {
            DialogFactory.showAlert(context, "Tidak tersambung internet!\nHarap aktifkan internet anda");
        }
    }
    public static void setMobileDataEnabled(Context context, boolean enabled) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final ConnectivityManager conman = (ConnectivityManager)  context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final Class conmanClass = Class.forName(conman.getClass().getName());
        final Field connectivityManagerField = conmanClass.getDeclaredField("mService");
        connectivityManagerField.setAccessible(true);
        final Object connectivityManager = connectivityManagerField.get(conman);
        final Class connectivityManagerClass =  Class.forName(connectivityManager.getClass().getName());
        final Method setMobileDataEnabledMethod = connectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
        setMobileDataEnabledMethod.setAccessible(true);

        setMobileDataEnabledMethod.invoke(connectivityManager, enabled);
    }

    public static boolean shouldLogin() {
        //long deltaActive = Math.abs(System.currentTimeMillis() - AppPreference.getInstance().getLastActive());
        if (AppPreference.getInstance().getUserLoggedIn() == null ) {
            //|| deltaActive > Constant.SESSION_EXIPRED_TIME) {
            return true;
        }

        return false;
    }

}
