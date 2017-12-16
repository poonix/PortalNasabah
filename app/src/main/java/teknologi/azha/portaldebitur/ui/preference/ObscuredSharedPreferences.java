package teknologi.azha.portaldebitur.ui.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.Base64;

import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * Created by user on 29/08/2017.
 */

public class ObscuredSharedPreferences implements SharedPreferences {

    private static final String UTF8 = "UTF-8";
    protected SharedPreferences mSharedPreferences;
    protected Context mContext;

    /**
     * INSERT A RANDOM PASSWORD HERE.
     * Don't use anything you wouldn't want to
     * getString out there if someone decompiled
     * your app.
     */
    private char[] mSecretCode;

    public ObscuredSharedPreferences(Context context, SharedPreferences preferences, String secretCode) {
        this.mSharedPreferences = preferences;
        this.mContext = context;
        this.mSecretCode = secretCode.toCharArray();
    }

    @Override
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException(); // left as an exercise to the reader
    }

    @Nullable
    @Override
    public String getString(String key, String defValue) {
        final String v = mSharedPreferences.getString(key, null);
        return v != null ? decrypt(v) : defValue;
    }

    @Nullable
    @Override
    public Set<String> getStringSet(String key, Set<String> defValues) {
        return null;
    }

    @Override
    public int getInt(String key, int defValue) {
        final String v = mSharedPreferences.getString(key, null);
        return v != null ? Integer.parseInt(decrypt(v)) : defValue;
    }

    @Override
    public long getLong(String key, long defValue) {
        final String v = mSharedPreferences.getString(key, null);
        return v != null ? Long.parseLong(decrypt(v)) : defValue;
    }

    @Override
    public float getFloat(String key, float defValue) {
        final String v = mSharedPreferences.getString(key, null);
        return v != null ? Float.parseFloat(decrypt(v)) : defValue;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        final String v = mSharedPreferences.getString(key, null);
        return v != null ? Boolean.parseBoolean(decrypt(v)) : defValue;
    }

    @Override
    public boolean contains(String key) {
        return mSharedPreferences.contains(key);
    }

    @Override
    public Editor edit() {
        return new Editor();
    }

    @Override
    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        mSharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    @Override
    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener listener) {
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }

    protected String encrypt(String value) {
        try {
            final byte[] bytes = value != null ? value.getBytes(UTF8) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(mSecretCode));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.ENCRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(mContext.getContentResolver(), Settings.System.ANDROID_ID).getBytes(UTF8), 20));
            return new String(Base64.encode(pbeCipher.doFinal(bytes), Base64.NO_WRAP), UTF8);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    protected String decrypt(String value) {
        try {
            final byte[] bytes = value != null ? Base64.decode(value, Base64.DEFAULT) : new byte[0];
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyFactory.generateSecret(new PBEKeySpec(mSecretCode));
            Cipher pbeCipher = Cipher.getInstance("PBEWithMD5AndDES");
            pbeCipher.init(Cipher.DECRYPT_MODE, key, new PBEParameterSpec(Settings.Secure.getString(mContext.getContentResolver(), Settings.System.ANDROID_ID).getBytes(UTF8), 20));
            return new String(pbeCipher.doFinal(bytes), UTF8);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public class Editor implements SharedPreferences.Editor {

        protected SharedPreferences.Editor mEditor;

        public Editor(){
            this.mEditor = ObscuredSharedPreferences.this.mSharedPreferences.edit();
        }

        @Override
        public Editor putString(String key, String value) {
            mEditor.putString(key, encrypt(value));
            return this;
        }

        @Override
        public Editor putStringSet(String key, Set<String> values) {
            mEditor.putStringSet(key, values);
            return this;
        }

        @Override
        public Editor putInt(String key, int value) {
            mEditor.putString(key, encrypt(Integer.toString(value)));
            return this;
        }

        @Override
        public Editor putLong(String key, long value) {
            mEditor.putString(key, encrypt(Long.toString(value)));
            return this;
        }

        @Override
        public Editor putFloat(String key, float value) {
            mEditor.putString(key, encrypt(Float.toString(value)));
            return this;
        }

        @Override
        public Editor putBoolean(String key, boolean value) {
            mEditor.putString(key, encrypt(Boolean.toString(value)));
            return this;
        }

        @Override
        public Editor remove(String key) {
            mEditor.remove(key);
            return this;
        }

        @Override
        public Editor clear() {
            mEditor.clear();
            return this;
        }

        @Override
        public boolean commit() {
            return mEditor.commit();
        }

        @Override
        public void apply() {
            mEditor.apply();
        }
    }
}
