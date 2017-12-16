package teknologi.azha.portaldebitur.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.model.MenuModel;
import teknologi.azha.portaldebitur.ui.adapter.MenuAdapter;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;
import teknologi.azha.portaldebitur.ui.fragment.FormAjukanPinjamanFragment;
import teknologi.azha.portaldebitur.ui.fragment.HistoriAngsuranFragment;
import teknologi.azha.portaldebitur.ui.fragment.JadwalAngsuranFragment;
import teknologi.azha.portaldebitur.ui.fragment.DashboardFragment;
import teknologi.azha.portaldebitur.ui.fragment.ListRekeningFragment;
import teknologi.azha.portaldebitur.ui.fragment.LokasiKantorFragment;
import teknologi.azha.portaldebitur.ui.listerner.OnItemClickListener;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;
import teknologi.azha.portaldebitur.utils.preference.FormatDate;

/**
 * Created by user on 9/23/2017.
 */

public class DashboardActivity extends AppCompatActivity implements OnItemClickListener{
    private AppPreference appPreference = AppPreference.getInstance();
    private long back_pressed;
    private FormatDate fm = new FormatDate();
    private int fragmentType = -1;
    private Fragment currentFragment;
    private List<MenuModel> menuList = new ArrayList<>();;
    private Unbinder unbinder;
    private MenuAdapter mAdapter;
    /*
    */
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.tvLogout)
    TextView tvLogout;
    /*
    */
    @OnClick({
            R.id.tvLogout
    })

    public void setOnClick(View v) {
        switch (v.getId()){
            case R.id.tvLogout:
                doLogout();
                break;
            /*
            case R.id.ivIconOffice_dashboard:
                Intent tn = new Intent(this, LokasiKantorActivity.class);
                startActivity(tn);
                break;
            case R.id.imgAngsuranPembiayaan:
                Intent an = new Intent(this, JadwalAngsuranActivity.class);
                startActivity(an);
                break;
            case R.id.imgRiwayatPembiayaan:
                break;
            case R.id.tvHistoryPembiayaan:
                break;
            case R.id.tvAngsuranPembiayaan:
                Intent nn = new Intent(this, JadwalAngsuranActivity.class);
                startActivity(nn);
                break;*/
        }
        drawer.closeDrawer(GravityCompat.START);
    }

    private void setupNavigationDrawer() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        unbinder = ButterKnife.bind(this);
        //init_data();
        initView();
        loadMenu();
        setupFragment(-1);
        //setup_taptarget();
    }

    private void setup_taptarget()
    {
        final SpannableString sassyDesc = new SpannableString("dapat informasi pembiayaan anda dari menu ini");
        sassyDesc.setSpan(new StyleSpan(Typeface.ITALIC), sassyDesc.length() - "somtimes".length(), sassyDesc.length(), 0);
        // We have a sequence of targets, so lets build it!
        final TapTargetSequence sequence = new TapTargetSequence(this)
                .targets(
                        // You can also target the overflow button in your toolbar
                        TapTarget.forToolbarNavigationIcon(toolbar, "Main Menu", sassyDesc).id(1)
                        )
                .listener(new TapTargetSequence.Listener() {
                    // This listener will tell us when interesting(tm) events happen in regards
                    // to the sequence
                    @Override
                    public void onSequenceFinish() {

                    }

                    @Override
                    public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {
                        Log.d("TapTargetView", "Clicked on " + lastTarget.id());
                    }

                    @Override
                    public void onSequenceCanceled(TapTarget lastTarget) {
                    }
                });
        sequence.start();
    }

    private void initView() {
        setupToolbar();
        setupNavigationDrawer();
        setupMenu();

        //tvProfileName.setText(AppPreference.getInstance().getUserLoggedIn().getNamaNasabah());
        //tvIdDebitur.setText(AppPreference.getInstance().getUserLoggedIn().getNasabahId());
    }

    private void setupMenu() {
        mAdapter = new MenuAdapter(menuList);
        mAdapter.setOnItemClickListener(this);
        Log.v("test",menuList.toString());
        rvMenu.setHasFixedSize(true);
        rvMenu.setItemAnimator(new DefaultItemAnimator());
        rvMenu.setAdapter(mAdapter);
        rvMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    public void init_data()
    {
        /*
        TextView tvJmlAngsan        = (TextView) findViewById(R.id.tvJumlahAngsurann);
        TextView tvKolektibilitas   = (TextView) findViewById(R.id.tvKolektibilitas);

        TextView tvtglRealisasi     = (TextView) findViewById(R.id.tvTglRealisasi);
        TextView tvtglJatuhTempo    = (TextView) findViewById(R.id.tvTglJthTmp);
        TextView tvtglLunas         = (TextView) findViewById(R.id.tvTglLunas);

        //tvNameNasabah.setText(AppPreference.getInstance().getUserLoggedIn().getNamaNasabah());
        //tvIdDebitur.setText(AppPreference.getInstance().getUserLoggedIn().getNasabahId());
        tvJmlAngsan.setText(String.valueOf(AppPreference.getInstance().getUserDetail().getJmlAngsuran()));
        tvKolektibilitas.setText(AppPreference.getInstance().getUserDetail().getKolektibilitas());
        tvtglRealisasi.setText(fm.DateFormat(AppPreference.getInstance().getUserDetail().getInnterTglRealisasi()));
        tvtglJatuhTempo.setText(fm.DateFormat(AppPreference.getInstance().getUserDetail().getInnterTglJatuhTempo()));
        tvtglLunas.setText(fm.DateFormat(AppPreference.getInstance().getUserDetail().getInnterTglLunas()));*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            doLogout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            finish();
        }
        else{
            Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }
    public void doLogout() {
        String confirmMsg = "Anda yakin ingin logout?";
        DialogFactory.showConfirmation(this, getString(R.string.app_name), confirmMsg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearAndLogout();
            }
        }, new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

            }
        });
    }

    private void clearAndLogout() {
        AppPreference.getInstance().clearData();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public void onItemClick(View itemView, View view, int position, long id) {
        setupFragment(position);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void setupFragment(int type) {
        fragmentType = type;
        Fragment fragment = null;
        Class fragmentClass = null;
        switch (type) {
            case 0:
                appPreference.setMenu(0);
                fragmentClass = DashboardFragment.class;

                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.menu_dashboard));
                Log.v("menu","1");
                break;
            case 1:
                appPreference.setMenu(1);
                fragmentClass = ListRekeningFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.jadwal_angsuran));
                    Log.v("menu","2");
                }
                break;
            case 2:
                appPreference.setMenu(2);
                fragmentClass = ListRekeningFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.histori_angsuran));
                    Log.v("menu","3");
                }
                break;
            case 3:
                fragmentClass = LokasiKantorFragment.class;
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(getString(R.string.HubungiKami));
                    Log.v("menu","4");
                }
                break;
            case 4:
                Intent i = new Intent(DashboardActivity.this, FormAjukanPinjamanActivity.class);
                startActivity(i);
                break;
            default:
                fragmentClass = DashboardFragment.class;
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(getString(R.string.title_dashboard));
                break;
        }
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

    private void loadMenu() {
        menuList.add(new MenuModel(0,0, getString(R.string.menu_dashboard), getResources().getDrawable(R.drawable.dashboard)));
        menuList.add(new MenuModel(1,0, getString(R.string.jadwal_angsuran), getResources().getDrawable(R.drawable.angsuran_pembiayaan)));
        menuList.add(new MenuModel(2,0, getString(R.string.histori_angsuran), getResources().getDrawable(R.drawable.ajukan_pinjaman)));
        menuList.add(new MenuModel(3, 0,getString(R.string.HubungiKami), getResources().getDrawable(R.drawable.hubungi_kami)));
        menuList.add(new MenuModel(4, 0,getString(R.string.action_ajukan_pinjaman), getResources().getDrawable(R.drawable.histori_pembiayaan)));
    }

}

