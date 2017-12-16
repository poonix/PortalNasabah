package teknologi.azha.portaldebitur.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pooni on 9/21/2017.
 */

public class BaseModel {
    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status=status;
    }
}
