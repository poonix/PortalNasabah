package teknologi.azha.portaldebitur.callback;

import java.util.List;

import teknologi.azha.portaldebitur.model.RiwayatAngsuranModel;

/**
 * Created by user on 11/8/2017.
 */

public interface GetRiwayatAngsuranCallback {
    void onGetRiwayatAngsuranSuccess(List<RiwayatAngsuranModel> apm);

    void onGetRiwayatAngsuranFailed(Throwable t);
}
