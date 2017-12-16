package teknologi.azha.portaldebitur.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import teknologi.azha.portaldebitur.model.RekeningDebiturModel;

/**
 * Created by user on 9/29/2017.
 */

public class RekeningDebiturResponse {


    public RekeningDebiturModel getRekeningData() {
        try{
            return getListData().get(0);
        }catch (Exception e) {
            return null;
        }
    }

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private List<RekeningDebiturModel> TestData;


    public List<RekeningDebiturModel> getListData() {
        return TestData;
    }

    public void setGetListData(List<RekeningDebiturModel> TestData) {
        this.TestData = TestData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RekeningDebiturResponse(){}
}
