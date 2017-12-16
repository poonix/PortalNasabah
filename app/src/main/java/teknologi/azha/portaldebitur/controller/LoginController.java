package teknologi.azha.portaldebitur.controller;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.azha.portaldebitur.callback.GetRekeningCallback;
import teknologi.azha.portaldebitur.callback.LoginCallback;
import teknologi.azha.portaldebitur.rest.ApiClient;
import teknologi.azha.portaldebitur.rest.service.LoginService;
import teknologi.azha.portaldebitur.rest.response.LoginDebiturResponse;
import teknologi.azha.portaldebitur.rest.response.RekeningDebiturResponse;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by user on 9/23/2017.
 */

public class LoginController {
    private final String LOG_TAG = LoginController.class.getSimpleName();
    private AppPreference appPreference = AppPreference.getInstance();
    private LoginCallback loginCallback;
    private GetRekeningCallback getRekeningCallback;
    private Call<LoginDebiturResponse> call ;
    private Call<RekeningDebiturResponse> callDebitur ;

    public LoginController(LoginCallback callback) {
        this.loginCallback = callback;
    }

    public void doLogin(String NoHp) {
        LoginService lg = ApiClient.getClient().create(LoginService.class);
        call = lg.loginDebiturService(NoHp);
        call.enqueue(new Callback<LoginDebiturResponse>() {
            @Override
            public void onResponse(Call<LoginDebiturResponse> call, Response<LoginDebiturResponse> response) {
                Log.d(LOG_TAG, "doLogin.onResponse " + (response != null ? response.body() : ""));
                if (loginCallback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getMessage();
                        if (response.body().isSuccessResponse() && response.body().getUserLoggedin() != null) {
                            appPreference.setUserLoggedIn(response.body().getUserLoggedin());
                            loginCallback.onLoginInternalSuccess(response.body().getUserLoggedin());
                        } else {
                            loginCallback.onLoginInternalFailed(new Throwable(errMsg));
                        }
                    } else {
                        loginCallback.onLoginInternalFailed(new Throwable("Login Failed"));
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginDebiturResponse> call, Throwable t) {
                Log.d(LOG_TAG, "doLoginSSO.onFailure " + (t != null ? t.getMessage() : ""));
                if (loginCallback != null) {
                    loginCallback.onLoginInternalFailed(new Throwable("Login Failed\n" + (t != null ? t.getMessage() : "")));
                }
            }

        });
    }


    public void doGetRekening(String IdDebitur) {
        LoginService as = ApiClient.getClient().create(LoginService.class);
        callDebitur = as.getRekeningService(IdDebitur);
        callDebitur.enqueue(new Callback<RekeningDebiturResponse>() {
            @Override
            public void onResponse(Call<RekeningDebiturResponse> call, Response<RekeningDebiturResponse> response) {
                Log.d(LOG_TAG, "doLogin.getRekening " + (response != null ? response.body() : ""));
                if (loginCallback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if ( response.body() != null) {
                            appPreference.setUserDetail(response.body().getRekeningData());
                            loginCallback.onLoginProcessCompleted();
                        } else {
                            loginCallback.onLoginProcessNotCompleted(new Throwable(errMsg));
                        }
                    } else {
                        loginCallback.onLoginProcessNotCompleted(new Throwable("Failed to get data Debitur"));
                    }
                }
            }
            @Override
            public void onFailure(Call<RekeningDebiturResponse> call, Throwable t) {
                Log.d(LOG_TAG, "doLoginSSO.onFailure " + (t != null ? t.getMessage() : ""));
                if (getRekeningCallback != null) {
                    getRekeningCallback.onGetRekeningFailed(new Throwable("Failed to get data Debitur\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }



    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
