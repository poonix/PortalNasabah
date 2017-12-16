package teknologi.azha.portaldebitur.controller;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.azha.portaldebitur.callback.GetRekeningCallback;
import teknologi.azha.portaldebitur.rest.ApiClient;
import teknologi.azha.portaldebitur.rest.response.GetRekeningResponse;
import teknologi.azha.portaldebitur.rest.service.LoginService;

/**
 * Created by user on 11/7/2017.
 */

public class GetRekeningController {

    private final String LOG_TAG = GetRekeningController.class.getSimpleName();
    private GetRekeningCallback callback;
    private Call<GetRekeningResponse> callDebitur ;

    public GetRekeningController(GetRekeningCallback callback)
    {
        this.callback = callback;
    }

    public void setCallback(GetRekeningCallback callback)
    {
        this.callback = callback;
    }

    public void getListRekeningJadwal(String IdDebitur) {
        LoginService as = ApiClient.getClient().create(LoginService.class);
        callDebitur = as.getListRekening(IdDebitur,2);
        callDebitur.enqueue(new Callback<GetRekeningResponse>() {
            @Override
            public void onResponse(Call<GetRekeningResponse> call, Response<GetRekeningResponse> response) {
                Log.d(LOG_TAG, "getRekening.getRekening " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onGetRekeningSuccess(response.body().getListRekeningDebitur());
                        Log.d(LOG_TAG, "success ");
                    }
                }
            }
            @Override
            public void onFailure(Call<GetRekeningResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getRekening.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetRekeningFailed(new Throwable("Failed to get data Debitur\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void getListRekeningRiwayat(String IdDebitur) {
        LoginService as = ApiClient.getClient().create(LoginService.class);
        callDebitur = as.getListRekening(IdDebitur,3);
        callDebitur.enqueue(new Callback<GetRekeningResponse>() {
            @Override
            public void onResponse(Call<GetRekeningResponse> call, Response<GetRekeningResponse> response) {
                Log.d(LOG_TAG, "getRekening.getRekening " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onGetRekeningSuccess(response.body().getListRekeningDebitur());
                        Log.d(LOG_TAG, "success ");
                    }
                }
            }
            @Override
            public void onFailure(Call<GetRekeningResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getRekening.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetRekeningFailed(new Throwable("Failed to get data Debitur\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }

    public void getListRekening(String IdDebitur) {
        LoginService as = ApiClient.getClient().create(LoginService.class);
        callDebitur = as.getListRekeningDashboard(IdDebitur);
        callDebitur.enqueue(new Callback<GetRekeningResponse>() {
            @Override
            public void onResponse(Call<GetRekeningResponse> call, Response<GetRekeningResponse> response) {
                Log.d(LOG_TAG, "getRekening.getRekening " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onGetRekeningSuccess(response.body().getListRekeningDebitur());
                        Log.d(LOG_TAG, "success ");
                    }
                }
            }
            @Override
            public void onFailure(Call<GetRekeningResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getRekening.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetRekeningFailed(new Throwable("Failed to get data Debitur\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }
}
