package teknologi.azha.portaldebitur.rest.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import teknologi.azha.portaldebitur.model.LokasiKantorCabangModel;

/**
 * Created by user on 9/22/2017.
 */

public interface LokasiKantorService {
        @GET("master/lov_cabang/{id}")
        Call<List<LokasiKantorCabangModel>> getKantorCabang(@Path("id") int id);
}
