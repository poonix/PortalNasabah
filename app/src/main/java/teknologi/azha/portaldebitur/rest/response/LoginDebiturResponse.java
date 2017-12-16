package teknologi.azha.portaldebitur.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import teknologi.azha.portaldebitur.model.UserDebiturModel;

/**
 * Created by user on 9/23/2017.
 */

public class LoginDebiturResponse {

    public UserDebiturModel getUserLoggedin() {
        try{
            return getListData().get(0);
        }catch (Exception e) {
            return null;
        }
    }

    public boolean isSuccessResponse() {
        try {
            return getStatus().booleanValue() == true;
        } catch (Exception e) {
            return false;
        }
    }

    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private List<UserDebiturModel> TestData;


    public List<UserDebiturModel> getListData() {
        return TestData;
    }

    public void setGetListData(List<UserDebiturModel> TestData) {
        this.TestData = TestData;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginDebiturResponse(){}
}
