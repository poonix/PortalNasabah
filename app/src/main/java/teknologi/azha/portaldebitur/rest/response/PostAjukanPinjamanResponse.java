package teknologi.azha.portaldebitur.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import teknologi.azha.portaldebitur.model.AjukanPinjamanModel;

/**
 * Created by user on 10/12/2017.
 */

public class PostAjukanPinjamanResponse extends PostResponse{
    @SerializedName("submission")
    @Expose
    private List<AjukanPinjamanModel> submission = null;

    public  List<AjukanPinjamanModel> getSubmission() {
        return submission;
    }

    public void setSubmission( List<AjukanPinjamanModel> submission) {
        this.submission = submission;
    }
}
