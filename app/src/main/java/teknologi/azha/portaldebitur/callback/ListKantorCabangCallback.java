package teknologi.azha.portaldebitur.callback;

import java.util.List;

import teknologi.azha.portaldebitur.model.LokasiKantorCabangModel;
import teknologi.azha.portaldebitur.model.UserDebiturModel;

/**
 * Created by user on 9/22/2017.
 */

public interface ListKantorCabangCallback {
    void onGetListKantorCabangSuccess(List<LokasiKantorCabangModel> lst);

    void onGetListKantorCabangFailed(Throwable t);
}
