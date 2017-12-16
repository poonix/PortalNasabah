package teknologi.azha.portaldebitur.controller;

import android.util.Log;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.azha.portaldebitur.callback.ListKantorCabangCallback;
import teknologi.azha.portaldebitur.model.LokasiKantorCabangModel;
import teknologi.azha.portaldebitur.rest.ApiClient;
import teknologi.azha.portaldebitur.rest.service.LokasiKantorService;

/**
 * Created by user on 9/25/2017.
 */

public class ListKantorCabangController {
    private final String LOG_TAG = ListKantorCabangController.class.getSimpleName();
    private Call<List<LokasiKantorCabangModel>> call ;
    private ListKantorCabangCallback callback;

    public ListKantorCabangController(ListKantorCabangCallback callback) {
        this.callback = callback;
    }

    public void setCallback(ListKantorCabangCallback callback) {
        this.callback = callback;
    }

    public ListKantorCabangController(){}

    public void connects(final int id) {
        LokasiKantorService apiService = ApiClient.getClient().create(LokasiKantorService.class);
        call = apiService.getKantorCabang(id);
        call.enqueue(new Callback<List<LokasiKantorCabangModel>>() {
            @Override
            public void onResponse(Call<List<LokasiKantorCabangModel>> call, Response<List<LokasiKantorCabangModel>> response) {
                Log.d(LOG_TAG, "getListKantorCabang.onResponse " + (response != null ? response.body().get(2).getMsCabangAlamat():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onGetListKantorCabangSuccess(response.body());
                        Log.d(LOG_TAG, "callback  null ");
                    }
                }
                else {
                    if (response != null && response.code() == HttpURLConnection.HTTP_NOT_FOUND) {
                        callback.onGetListKantorCabangSuccess(null);
                    } else {
                        //kantorCabangCallback.onGetListKantorCabangFailed(new Throwable());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<LokasiKantorCabangModel>>call, Throwable t) {
                // Log error here since request failed
                Log.e(LOG_TAG, t.toString());
            }
        });
    }

    public void cancel() {
        if (call != null)
            call.cancel();
    }
}
