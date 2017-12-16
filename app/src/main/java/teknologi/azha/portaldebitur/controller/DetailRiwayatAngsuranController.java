package teknologi.azha.portaldebitur.controller;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.azha.portaldebitur.callback.GetDetailRiwayatAngsuranCallback;
import teknologi.azha.portaldebitur.rest.response.DetailRiwayatAngsuranResponse;
import teknologi.azha.portaldebitur.rest.service.RestHelp;
import teknologi.azha.portaldebitur.rest.service.RiwayatAngsuranService;

/**
 * Created by pooni on 12/4/2017.
 */

public class DetailRiwayatAngsuranController {
    private final String LOG_TAG = DetailRiwayatAngsuranController.class.getSimpleName();
    private GetDetailRiwayatAngsuranCallback callback;
    private RiwayatAngsuranService service = RestHelp.getInstance().getRestService();
    private Call<DetailRiwayatAngsuranResponse> call ;

    public DetailRiwayatAngsuranController(GetDetailRiwayatAngsuranCallback callback) {
        this.callback = callback;
    }

    public void setCallback(GetDetailRiwayatAngsuranCallback callback) {
        this.callback = callback;
    }

    public void CallIt(String NoRek, String AngsuranKe) {
        call= service.getOn("http://182.23.52.249/PNM/api/v1/mms/get_detail_bulanan/",NoRek,AngsuranKe);
        Log.d(LOG_TAG, "test call Detil Riwayat"+NoRek);
        call.enqueue(new Callback<DetailRiwayatAngsuranResponse>() {
            @Override
            public void onResponse(Call<DetailRiwayatAngsuranResponse> call, Response<DetailRiwayatAngsuranResponse> response) {
                Log.d(LOG_TAG, "getDetilRiwayat.onSuccess " + (response != null ? response.body() : ""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        callback.onGetDetailRiwayatAngsuranSuccess(response.body().getListData());
                        Log.d(LOG_TAG, "success ");
                    }
                }
            }
            @Override
            public void onFailure(Call<DetailRiwayatAngsuranResponse> call, Throwable t) {
                Log.d(LOG_TAG, "getDetilRiwayat.onFailure " + (t != null ? t.getMessage() : ""));
                if (callback != null) {
                    callback.onGetDetailRiwayatAngsuranFailed(new Throwable("Failed to get data Debitur\n" + (t != null ? t.getMessage() : "")));
                }
            }
        });
    }
}
