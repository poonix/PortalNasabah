package teknologi.azha.portaldebitur.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import teknologi.azha.portaldebitur.model.AngsuranPembiayaanModel;

/**
 * Created by pooni on 10/1/2017.
 */

public class AngsuranPembiayaanResponse {


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private List<AngsuranPembiayaanModel> data;

    public List<AngsuranPembiayaanModel> getListData() {
        return data;
    }

    public void setGetListData(List<AngsuranPembiayaanModel> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    class Error {
        @SerializedName("data")
        @Expose
        private String data;
        public String getDataError() {
            return data;
        }
    }

}
