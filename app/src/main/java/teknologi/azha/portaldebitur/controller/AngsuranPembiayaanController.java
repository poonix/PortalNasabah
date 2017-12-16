package teknologi.azha.portaldebitur.controller;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.azha.portaldebitur.callback.GetAngsuranPembiayaanCallback;
import teknologi.azha.portaldebitur.rest.service.AngsuranPembiayaanService;
import teknologi.azha.portaldebitur.rest.ApiClient;
import teknologi.azha.portaldebitur.rest.response.AngsuranPembiayaanResponse;

/**
 * Created by pooni on 10/1/2017.
 */

public class AngsuranPembiayaanController {
    private final String LOG_TAG = AngsuranPembiayaanController.class.getSimpleName();
    private GetAngsuranPembiayaanCallback getAngsuranCallback;
    private Call<AngsuranPembiayaanResponse> call ;

    public AngsuranPembiayaanController(GetAngsuranPembiayaanCallback callback) {
        this.getAngsuranCallback = callback;
    }

    public void doGetAngsuranPembiayaan(String IdDebitur) {
        AngsuranPembiayaanService as = ApiClient.getClient().create(AngsuranPembiayaanService.class);
        call = as.getAngsuranService(IdDebitur);
        call.enqueue(new Callback<AngsuranPembiayaanResponse>() {
            @Override
            public void onResponse(Call<AngsuranPembiayaanResponse> call, Response<AngsuranPembiayaanResponse> response) {
                Log.d(LOG_TAG, "AngusranPembiayaan.onResponse " + (response != null ? response.body() : ""));
                if (getAngsuranCallback != null) {
                    if (response != null && response.body() != null) {
                        String errMsg = response.body().getStatus();
                        if ( response.body() != null) {
                            getAngsuranCallback.onGetAngsuranDataSuccess(response.body().getListData());
                        } else {
                            getAngsuranCallback.onGetAngsuranDataFailed(new Throwable(errMsg));
                        }
                    } else {
                        getAngsuranCallback.onGetAngsuranDataFailed(new Throwable("Data not found"));
                    }
                }
            }

            @Override
            public void onFailure(Call<AngsuranPembiayaanResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getErrorAngsuran.onFailure " + (t != null ? t.getMessage() : ""));
                if (getAngsuranCallback != null) {
                    getAngsuranCallback.onGetAngsuranDataFailed(new Throwable("Failed Get Data\n" + (t != null ? t.getMessage() : "")));
                }
            }

        });
    }
}
