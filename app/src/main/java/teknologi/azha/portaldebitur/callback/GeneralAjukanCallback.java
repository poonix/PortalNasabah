package teknologi.azha.portaldebitur.callback;

import java.util.List;

/**
 * Created by user on 10/12/2017.
 */

public interface GeneralAjukanCallback {
    void onSaveProspekSuccess(String message);

    void onSaveProspekFailed(Throwable t);

}
