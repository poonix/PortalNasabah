package teknologi.azha.portaldebitur.callback;

import teknologi.azha.portaldebitur.model.UserDebiturModel;

/**
 * Created by user on 9/23/2017.
 */

public interface LoginCallback {

    void onLoginInternalSuccess(UserDebiturModel userModel);

    void onLoginInternalFailed(Throwable t);

    void onLoginProcessCompleted();

    void onLoginProcessNotCompleted(Throwable t);
}

