package teknologi.azha.portaldebitur.utils.preference;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import teknologi.azha.portaldebitur.model.RekeningDebiturModel;
import teknologi.azha.portaldebitur.model.UserDebiturModel;

/**
 * Created by user on 9/23/2017.
 */

public class AppPreference extends BasePreference {

    private final String LOG_TAG = AppPreference.class.getSimpleName();

    public static final String API_HOST_SSO = "api_host_sso";
    public static final String API_HOST_INTERNAL = "api_host_internal";


    public static final String USER_DEBITUR_DETAIL = "user_debitur_detail";
    public static final String USER_DEBITUR = "user_debitur";
    public static final String MENU_TYPE = "menu";
    public static final String USER_TYPE = "user_type";
    public static final String FCM_ID = "user_fcm_id";
    public static final String FCM_NEED_RESEND = "fcm_id_need_resend";
    public static final String LAST_ACTIVE = "last_active_time";


    private static final Object LOCK = new Object();
    private static AppPreference sInstance;

    public static AppPreference getInstance() {
        synchronized (LOCK) {
            if (sInstance == null) {
                sInstance = new AppPreference();
            }
        }
        return sInstance;
    }

    private AppPreference() {

    }

    public void setMenu(int menus) {
        set(MENU_TYPE, menus);
    }

    public int getMenu() {
        int menus = getInt(MENU_TYPE);
        return menus;
    }

    public RekeningDebiturModel getUserDetail() {
        RekeningDebiturModel detailDebiturModel = null;
        try {
            detailDebiturModel = new Gson().fromJson(getString(USER_DEBITUR_DETAIL), RekeningDebiturModel.class);
        }catch (Exception e) {
            Log.e(LOG_TAG, "test getuserloggedin : " + e.getMessage());
        }
        return detailDebiturModel;

    }

    public void setUserDetail(RekeningDebiturModel detailDebiturModel) {
        //userModel.setIdUserGroup(com.example.saifullah_albasrie.pnm.model.annotation.UserType.MANAGER_UNIT); //TEST MU
        set(USER_DEBITUR_DETAIL, new Gson().toJson(detailDebiturModel));
    }

    public UserDebiturModel getUserLoggedIn() {
        UserDebiturModel userModel = null;
        try {
            userModel = new Gson().fromJson(getString(USER_DEBITUR), UserDebiturModel.class);
        }catch (Exception e) {
            Log.e(LOG_TAG, "test getuserloggedin : " + e.getMessage());
        }
        return userModel;

    }

    public void setUserLoggedIn(UserDebiturModel userModel) {
        set(USER_DEBITUR, new Gson().toJson(userModel));
    }


    public void clearData() {
        set(USER_DEBITUR, null);
        set(USER_DEBITUR_DETAIL, null);
        set(LAST_ACTIVE, 0);
        set(API_HOST_SSO, null);
        set(API_HOST_INTERNAL, null);

        removeAll();

    }
}
