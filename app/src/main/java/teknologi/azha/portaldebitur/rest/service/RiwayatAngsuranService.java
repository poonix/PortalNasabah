package teknologi.azha.portaldebitur.rest.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import teknologi.azha.portaldebitur.rest.response.DetailRiwayatAngsuranResponse;
import teknologi.azha.portaldebitur.rest.response.RiwayatAngsuranResponse;

/**
 * Created by user on 11/8/2017.
 */

public interface RiwayatAngsuranService {
    @GET("mms/get_riwayat_angsuran/{id}")
    Call<RiwayatAngsuranResponse> serve (@Path("id") String id);

    //@GET("mms/get_detail_bulanan/")
    @GET
    Call<DetailRiwayatAngsuranResponse> getOn (
            @Url String url,
            @Query("NO_REKENING") String NoRek,
            @Query("ANGSURAN_KE") String AngsuranKe);
}
