package teknologi.azha.portaldebitur.ui.preference;

import android.content.Context;

/**
 * Created by user on 29/08/2017.
 */

public class BasePreference {
    public static final String PREF_NAME = "pref_pnm_app";

    private Context mContext;
    private ObscuredSharedPreferences mObscuredSharedPreferences;

    private static final Object LOCK = new Object();
    private static BasePreference sInstance;

    public static BasePreference getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new BasePreference();
            }
        }
        return sInstance;
    }



    public void set(String key, String value) {
        mObscuredSharedPreferences.edit().putString(key, value).apply();
    }

    public void set(String key, int value) {
        mObscuredSharedPreferences.edit().putInt(key, value).apply();
    }

    public void set(String key, boolean value) {
        mObscuredSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public void set(String key, float value) {
        mObscuredSharedPreferences.edit().putFloat(key, value).apply();
    }

    public void set(String key, long value) {
        mObscuredSharedPreferences.edit().putLong(key, value).apply();
    }

    public String getString(String key) {
        return mObscuredSharedPreferences.getString(key, "");
    }

    public boolean getBoolean(String key) {
        return mObscuredSharedPreferences.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mObscuredSharedPreferences.getBoolean(key, defValue);
    }

    public int getInt(String key) {
        return mObscuredSharedPreferences.getInt(key, 0);
    }

    public long getLong(String key) {
        return mObscuredSharedPreferences.getLong(key, 0);
    }

    public void removeAll() {
        mObscuredSharedPreferences.edit().clear().commit();
    }
}
