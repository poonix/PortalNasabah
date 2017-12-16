package teknologi.azha.portaldebitur.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import teknologi.azha.portaldebitur.R;

/**
 * Created by user on 9/22/2017.
 */

public class LokasiKantorActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_lokasi_kantor);
         if (getSupportActionBar() != null) {
             getSupportActionBar().setDisplayHomeAsUpEnabled(true);
             getSupportActionBar().setTitle("Lokasi Kantor Cabang");
         }
     }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sort_lokasi, menu);
        return true;
    }*/

}
