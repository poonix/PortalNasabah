package teknologi.azha.portaldebitur.ui.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Bus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import teknologi.azha.portaldebitur.MyApplication;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.LoginCallback;
import teknologi.azha.portaldebitur.controller.LoginController;
import teknologi.azha.portaldebitur.model.UserDebiturModel;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;
import teknologi.azha.portaldebitur.utils.CommonUtil;

/**
 * Created by user on 30/08/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginCallback{

    private EditText mNoHpView;
    private TextView mErrorView;
    private LoginController loginController;
    protected final Bus bus = MyApplication.getEventBus();
    private Unbinder unbinder;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Session Manager
        //session = new SessionManagement(getApplicationContext());


        Button mEmailSignInButton = (Button) findViewById(R.id.sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
        unbinder = ButterKnife.bind(this);
        loginController = new LoginController(this);
        CommonUtil.checkInternet(this);
    }

    private void attemptLogin() {
        if (loginController != null) {
            loginController.cancel();
        }
        mNoHpView = (EditText) findViewById(R.id.noHpLogin);
        mErrorView = (TextView) findViewById(R.id.tv_error);
        // Reset errors.
        mNoHpView.setError(null);
        mErrorView.setVisibility(View.INVISIBLE);

        // Store values at the time of the login attempt.
        String noHp = mNoHpView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (cancel) {
            focusView.requestFocus();
        } else {
            processLogin(noHp);
        }
    }

    private void processLogin(String NoHp) {
        /*
        if(email.equals("admin") && password.equals("admin")) {
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
            return;
        }
        */
        showProgress(true);
        loginController.doLogin(NoHp);
    }

    @Override
    public void onLoginInternalSuccess(UserDebiturModel userModel) {
        //session.createLoginSession(userModel.getNamaNasabah(), userModel.getNasabahId());
        loginController.doGetRekening(userModel.getNasabahId());

    }
    @Override
    public void onLoginInternalFailed(Throwable t) {
        showProgress(false);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.setText(t.getMessage());
    }

    @Override
    public void onLoginProcessNotCompleted(Throwable t) {
        showProgress(false);
        mErrorView.setVisibility(View.VISIBLE);
        mErrorView.setText(t.getMessage());
    }

    @Override
    public void onLoginProcessCompleted() {
        showProgress(false);
        goToMainPage();
        //session.createGetUserDetailSession(rn.getNoRekening(), rn.getInnterTglRealisasi(),rn.getInnterTglJatuhTempo(),rn.getInnterTglLunas(),rn.getKolektibilitas(),rn.getFlagToleransi());

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        if ( show) {
            DialogFactory.showProgress(this);
        } else {
            DialogFactory.dismissProgress();
        }

        /*
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            //mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
        */
    }

    private void goToMainPage() {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        bus.unregister(this);
        unbinder.unbind();
        super.onDestroy();
    }

}
