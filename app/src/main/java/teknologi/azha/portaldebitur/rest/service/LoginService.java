package teknologi.azha.portaldebitur.rest.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;
import teknologi.azha.portaldebitur.model.RekeningDebiturModel;
import teknologi.azha.portaldebitur.rest.response.GetRekeningResponse;
import teknologi.azha.portaldebitur.rest.response.LoginDebiturResponse;
import teknologi.azha.portaldebitur.rest.response.RekeningDebiturResponse;

/**
 * Created by user on 9/23/2017.
 */

public interface LoginService {
    @FormUrlEncoded
    @POST("mms/login_debitur")
    Call<LoginDebiturResponse> loginDebiturService(
            @Field("no_hp") String noHp
    );

    @GET("mms/get_rekening_debitur/{id}")
    Call<RekeningDebiturResponse> getRekeningService(@Path("id") String id);

    @GET("mms/get_rekening_debitur/{id}")
    Call <GetRekeningResponse> getListRekening(
            @Path("id") String id,
            @Query("STATUS_AKTIF") int statusAktif);

    @GET("mms/get_rekening_debitur/{id}")
    Call <GetRekeningResponse> getListRekeningDashboard(@Path("id") String id);
}
