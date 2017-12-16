package teknologi.azha.portaldebitur.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.utils.CommonUtil;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by user on 29/08/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private IntroActivity ia = new IntroActivity();
    private Unbinder unbinder;
    private long back_pressed;
    String url = "http://pnm.co.id/";
    public boolean isFirstStart;
    Context mcontext;

    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.btn_hubungi_kami)
    Button btn_hubungi_kami;
    @BindView(R.id.btn_ajukan_pinjaman)
    Button btn_ajukan_pinjaman;

    @OnClick({
            R.id.btn_login,
            R.id.btn_hubungi_kami,
            R.id.btn_ajukan_pinjaman
    })
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.btn_hubungi_kami:
                Intent s = new Intent(MainActivity.this, LokasiKantorActivity.class);
                startActivity(s);
                break;
            case R.id.btn_ajukan_pinjaman:
                Intent as = new Intent(MainActivity.this, FormAjukanPinjamanActivity.class);
                startActivity(as);
                break;
        }

    }

    private void goToMainPage() {
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        ButterKnife.bind(this);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //  Intro App Initialize SharedPreferences
                SharedPreferences getSharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());

                //  Create a new boolean and preference and set it to true
                isFirstStart = getSharedPreferences.getBoolean("firstStart", true);

                //  Check either activity or app is open very first time or not and do action
                if (isFirstStart) {
                    //  Launch application introduction screen
                    Intent i = new Intent(MainActivity.this, IntroActivity.class);
                    startActivity(i);
                    finish();
                    SharedPreferences.Editor e = getSharedPreferences.edit();
                    e.putBoolean("firstStart", false);
                    e.apply();
                }
            }
        });
        t.start();



    }

    @Override
    protected void onStart() {
        super.onStart();

        if (AppPreference.getInstance().getUserLoggedIn() == null && AppPreference.getInstance().getUserDetail() == null) {
            return;
        }else {
            goToMainPage();
        }

    }

    /*
    public void init_slider()
    {
        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String, String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://azha.ddns.net:8080/cms-hr/assets/content/banner1.png");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }



    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.logged_in_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_custom_indicator:
                mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
                break;
            case R.id.action_custom_child_animation:
                mDemoSlider.setCustomAnimation(new ChildAnimationExample());
                break;
            case R.id.action_restore_default:
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {}
    */

    @Override
    protected void onResume() {
        super.onResume();
        CommonUtil.checkInternet(this);
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
        }
        else{
            Toast.makeText(getBaseContext(), "Press once again to exit", Toast.LENGTH_SHORT).show();
            back_pressed = System.currentTimeMillis();
        }
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

    private ButterKnife.Setter<ToggleButton, Integer> setToggleOff = new ButterKnife.Setter<ToggleButton, Integer>() {
        @Override
        public void set(ToggleButton view, Integer value, int index) {
            if (view.getId() != value) {
                view.setChecked(false);
            }
        }
    };
}
