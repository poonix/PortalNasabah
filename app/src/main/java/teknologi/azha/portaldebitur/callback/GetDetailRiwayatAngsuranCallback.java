package teknologi.azha.portaldebitur.callback;

import java.util.List;

import teknologi.azha.portaldebitur.model.DetailAngsuranBulananModel;

/**
 * Created by pooni on 12/4/2017.
 */

public interface GetDetailRiwayatAngsuranCallback {
    void onGetDetailRiwayatAngsuranSuccess(List<DetailAngsuranBulananModel> apm);

    void onGetDetailRiwayatAngsuranFailed(Throwable t);
}
