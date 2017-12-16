package teknologi.azha.portaldebitur.callback;

import java.util.List;

import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;

/**
 * Created by user on 9/29/2017.
 */

public interface GetRekeningCallback {
        void onGetRekeningSuccess(List<ListRekeningDebiturModel> listRekDebitur);

        void onGetRekeningFailed(Throwable t);

}
