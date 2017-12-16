package teknologi.azha.portaldebitur.callback;

import java.util.List;

import teknologi.azha.portaldebitur.model.AngsuranPembiayaanModel;

/**
 * Created by pooni on 10/1/2017.
 */

public interface GetAngsuranPembiayaanCallback {

    void onGetAngsuranDataSuccess(List<AngsuranPembiayaanModel> apm);

    void onGetAngsuranDataFailed(Throwable t);
}
