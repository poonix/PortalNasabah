package teknologi.azha.portaldebitur.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import teknologi.azha.portaldebitur.model.RiwayatAngsuranModel;

/**
 * Created by user on 11/8/2017.
 */

public class RiwayatAngsuranResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private List<RiwayatAngsuranModel> data;

    public List<RiwayatAngsuranModel> getListData() {
        return data;
    }

    public void setGetListData(List<RiwayatAngsuranModel> data) {
        this.data = data;
    }




    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
