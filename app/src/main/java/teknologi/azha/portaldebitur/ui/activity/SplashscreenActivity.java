package teknologi.azha.portaldebitur.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import teknologi.azha.portaldebitur.R;

/**
 * Created by user on 29/08/2017.
 */

public final class SplashscreenActivity extends AppCompatActivity {

    private Handler handler = new Handler();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,1500);
    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
                openMainActivity();
        }
    };
    private void openMainActivity(){
        Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
