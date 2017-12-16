package teknologi.azha.portaldebitur.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import teknologi.azha.portaldebitur.model.DetailAngsuranBulananModel;

/**
 * Created by pooni on 12/4/2017.
 */

public class DetailRiwayatAngsuranResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private List<DetailAngsuranBulananModel> data;

    public List<DetailAngsuranBulananModel> getListData() {
        return data;
    }

    public void setGetListData(List<DetailAngsuranBulananModel> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
