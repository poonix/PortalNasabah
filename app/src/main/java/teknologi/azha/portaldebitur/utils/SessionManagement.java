package teknologi.azha.portaldebitur.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

import teknologi.azha.portaldebitur.rest.ApiConstant;
import teknologi.azha.portaldebitur.ui.activity.LoginActivity;
import teknologi.azha.portaldebitur.ui.activity.MainActivity;

/**
 * Created by user on 9/28/2017.
 */

public class SessionManagement {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_DEBITUR = "idDebitur";
    public static final String KEY_REKENING= "rekening";
    public static final String KEY_JUMLAHPINJAMAN = "jml_pinjaman";
    public static final String KEY_JUMLAHANGSURAN = "jml_angsuran";
    public static final String KEY_TANGGALREALISASI = "tgl_realisasi";
    public static final String KEY_TANGGALJATUHTEMPO = "tgl_jatuhtempo";
    public static final String KEY_TANGGALLUNAS = "tgl_lunas";
    public static final String KEY_KOLEKTIBILITAS = "kl";
    public static final String KEY_TOLERANSI = "tl";

    // Constructor
    public SessionManagement(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(ApiConstant.PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String name, String iddebitur){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing email in pref
        editor.putString(KEY_DEBITUR, iddebitur);

        // commit changes
        editor.commit();
    }

    public void createGetUserDetailSession(String rekening, String tglrealisasi,
                                           String tgljatuhtempo,String tgllunas,String kl,String tl) {
        // Storing name in pref
        editor.putString(KEY_REKENING, rekening);

        // Storing email in pref
        //editor.putFloat(KEY_JUMLAHPINJAMAN, jmlpinjaman);

        // Storing name in pref
        //editor.putString(KEY_JUMLAHANGSURAN, jmlangsuran);

        // Storing email in pref
        editor.putString(KEY_TANGGALREALISASI, tglrealisasi);

        // Storing name in pref
        editor.putString(KEY_TANGGALJATUHTEMPO, tgljatuhtempo);

        // Storing email in pref
        editor.putString(KEY_TANGGALLUNAS, tgllunas);

        // Storing email in pref
        editor.putString(KEY_KOLEKTIBILITAS, kl);

        // Storing email in pref
        editor.putString(KEY_TOLERANSI, tl);

        // commit changes
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        if(!this.isLoggedIn()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_DEBITUR, pref.getString(KEY_DEBITUR, null));

        // user email id
        user.put(KEY_REKENING, pref.getString(KEY_REKENING, null));

        // user email id
        //user.put(KEY_JUMLAHPINJAMAN, pref.getFloat(KEY_JUMLAHPINJAMAN, user));

        // user email id
        //user.put(KEY_JUMLAHANGSURAN, pref.getString(KEY_JUMLAHANGSURAN, null));

        // user email id
        user.put(KEY_TANGGALREALISASI, pref.getString(KEY_TANGGALREALISASI, null));

        // user email id
        user.put(KEY_TANGGALJATUHTEMPO, pref.getString(KEY_TANGGALJATUHTEMPO, null));

        // user email id
        user.put(KEY_TANGGALLUNAS, pref.getString(KEY_TANGGALLUNAS, null));

        // user email id
        user.put(KEY_KOLEKTIBILITAS, pref.getString(KEY_KOLEKTIBILITAS, null));

        // user email id
        user.put(KEY_TOLERANSI, pref.getString(KEY_TOLERANSI, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, MainActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
