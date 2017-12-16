package teknologi.azha.portaldebitur.controller;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import teknologi.azha.portaldebitur.MyApplication;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.GeneralAjukanCallback;
import teknologi.azha.portaldebitur.rest.response.PostAjukanPinjamanResponse;
import teknologi.azha.portaldebitur.rest.response.PostResponse;
import teknologi.azha.portaldebitur.rest.service.RestHelper;
import teknologi.azha.portaldebitur.rest.service.SaveAjukanPinjamanService;

/**
 * Created by user on 10/12/2017.
 */

public class AjukanPinjamanController {
    private final String LOG_TAG = AjukanPinjamanController.class.getSimpleName();
    private SaveAjukanPinjamanService service = RestHelper.getInstance().getRestService();
    private GeneralAjukanCallback callback;

    private Call<PostResponse> callSaveData;

    public AjukanPinjamanController(GeneralAjukanCallback callback) {
        this.callback = callback;
    }

    public void saveProspek(PostAjukanPinjamanResponse model) {
        if(model != null && model.getSubmission() != null ) {
        }

        callSaveData = service.saveAjukanPinjaman(model);
        callSaveData.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                Log.d(LOG_TAG, "saveAjukanPinjaman.onResponse " + (response != null ? response.body():""));
                if (callback != null) {
                    if (response != null && response.body() != null) {
                        String statusMsg = response.body().getStatus();
                        if (response.body().isSuccessResponse()) {
                            callback.onSaveProspekSuccess(statusMsg);
                        } else {
                            callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed) +"\n" + statusMsg));
                        }
                    } else {
                        callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed)));
                    }
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Log.d(LOG_TAG, "saveAjukanPinjaman.onFailure " + (t != null ? t.getMessage():""));
                if (callback != null) {
                    callback.onSaveProspekFailed(new Throwable(MyApplication.getContext().getString(R.string.save_data_failed_on_server)));
                }
            }
        });
    }
}
