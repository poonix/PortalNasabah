package teknologi.azha.portaldebitur.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;

/**
 * Created by user on 11/7/2017.
 */

public class GetRekeningResponse {
    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("data")
    @Expose
    private List<ListRekeningDebiturModel> listRekening;

    public List<ListRekeningDebiturModel> getListRekeningDebitur() {
        return listRekening;
    }

    public void setListRekeningDebitur(List<ListRekeningDebiturModel> listRekening) {
        this.listRekening = listRekening;
    }
}
