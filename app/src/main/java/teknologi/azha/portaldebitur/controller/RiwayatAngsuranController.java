package teknologi.azha.portaldebitur.controller;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.azha.portaldebitur.callback.GetRiwayatAngsuranCallback;
import teknologi.azha.portaldebitur.callback.ListKantorCabangCallback;
import teknologi.azha.portaldebitur.rest.ApiClient;
import teknologi.azha.portaldebitur.rest.response.AngsuranPembiayaanResponse;
import teknologi.azha.portaldebitur.rest.response.GetRekeningResponse;
import teknologi.azha.portaldebitur.rest.response.RiwayatAngsuranResponse;
import teknologi.azha.portaldebitur.rest.service.AngsuranPembiayaanService;
import teknologi.azha.portaldebitur.rest.service.LoginService;
import teknologi.azha.portaldebitur.rest.service.RiwayatAngsuranService;

/**
 * Created by user on 11/8/2017.
 */

public class RiwayatAngsuranController {
    private final String LOG_TAG = RiwayatAngsuranController.class.getSimpleName();
    private GetRiwayatAngsuranCallback callback;
    private Call<RiwayatAngsuranResponse> call ;

    public RiwayatAngsuranController(GetRiwayatAngsuranCallback callback) {
        this.callback = callback;
    }

    public void setCallback(GetRiwayatAngsuranCallback callback) {
        this.callback = callback;
    }

    public void doit(String IdDebitur) {
        RiwayatAngsuranService as = ApiClient.getClient().create(RiwayatAngsuranService.class);
        call = as.serve(IdDebitur);
        Log.d(LOG_TAG, "test call "+as);
        call.enqueue(new Callback<RiwayatAngsuranResponse>() {
            @Override
            public void onResponse(Call<RiwayatAngsuranResponse> call, Response<RiwayatAngsuranResponse> response) {
                Log.d(LOG_TAG, "getRiwayat.onSuccess " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onGetRiwayatAngsuranSuccess(response.body().getListData());
                        Log.d(LOG_TAG, "success ");
                    }
                }
            }
            @Override
            public void onFailure(Call<RiwayatAngsuranResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getRiwayat.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetRiwayatAngsuranFailed(new Throwable("Failed to get data Debitur\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }
}
