package teknologi.azha.portaldebitur.rest.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import teknologi.azha.portaldebitur.rest.response.PostAjukanPinjamanResponse;
import teknologi.azha.portaldebitur.rest.response.PostResponse;

/**
 * Created by user on 10/12/2017.
 */

public interface SaveAjukanPinjamanService {
    @POST("submission/postSubmission")
    Call<PostResponse> saveAjukanPinjaman(
            @Body PostAjukanPinjamanResponse body
    );
}
