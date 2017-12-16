package teknologi.azha.portaldebitur.rest.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import teknologi.azha.portaldebitur.rest.response.AngsuranPembiayaanResponse;

/**
 * Created by pooni on 10/1/2017.
 */

public interface AngsuranPembiayaanService {
    @GET("mms/get_jadwal_angsuran/{id}")
    Call<AngsuranPembiayaanResponse> getAngsuranService(@Path("id") String id);
}
