package teknologi.azha.portaldebitur.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.ui.fragment.DetailHistoriAngsuranFragment;

/**
 * Created by pooni on 12/4/2017.
 */

public class DetailHistoriAngsuranActivity extends AppCompatActivity{
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_menu);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            getSupportActionBar().setTitle("Detail Histori Angsuran");
        }
        Fragment fragment = null;
        Class fragmentClass = DetailHistoriAngsuranFragment.class;

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
