package teknologi.azha.portaldebitur.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.ui.fragment.HistoriAngsuranFragment;
import teknologi.azha.portaldebitur.ui.fragment.JadwalAngsuranFragment;

/**
 * Created by user on 11/9/2017.
 */

public class HistoriActivity extends AppCompatActivity {

    private Fragment currentFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_menu);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Histori Angsuran");
        }
        Fragment fragment = null;
        Class fragmentClass = HistoriAngsuranFragment.class;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            currentFragment = fragment;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
