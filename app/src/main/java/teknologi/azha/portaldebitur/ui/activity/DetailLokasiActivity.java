package teknologi.azha.portaldebitur.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.ui.fragment.DetailLokasiKantorFragment;

/**
 * Created by user on 9/22/2017.
 */

public class DetailLokasiActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lokasi_cabang);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            Intent intent = DetailLokasiActivity.this.getIntent();

            String getIntentTitle = intent.getStringExtra("Nama Cabang");
            getSupportActionBar().setTitle("CABANG "+getIntentTitle);
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container,new DetailLokasiKantorFragment())
                    .commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
