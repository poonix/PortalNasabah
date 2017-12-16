package teknologi.azha.portaldebitur.ui.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 29/08/2017.
 */

public class BaseResponse {

    @SerializedName("response")
    @Expose
    private String response;

    @SerializedName("status")
    @Expose
    private String status;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccessResponse() {
        return getResponse()!= null && getResponse().equalsIgnoreCase("true");
    }
}
