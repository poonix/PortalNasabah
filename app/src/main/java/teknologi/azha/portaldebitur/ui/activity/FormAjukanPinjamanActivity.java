package teknologi.azha.portaldebitur.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.GeneralAjukanCallback;
import teknologi.azha.portaldebitur.controller.AjukanPinjamanController;
import teknologi.azha.portaldebitur.model.AjukanPinjamanModel;
import teknologi.azha.portaldebitur.rest.response.PostAjukanPinjamanResponse;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;
import teknologi.azha.portaldebitur.utils.Config;
import teknologi.azha.portaldebitur.utils.WidgetUtil;

/**
 * Created by user on 04/09/2017.
 */

public class FormAjukanPinjamanActivity extends AppCompatActivity implements GeneralAjukanCallback{

    private Unbinder unbinder;
    private AjukanPinjamanModel mAjukanPinjamanModel;
    private AjukanPinjamanController controller;
    @BindView(R.id.tv_hint_tahun)
    TextView tvHintTahun;
    @BindView(R.id.tv_nickname)
    EditText tvNickname;
    @BindView(R.id.tv_fullname)
    EditText tvFullname;
    @BindView(R.id.tv_address)
    EditText tvAddress;
    @BindView(R.id.spinner_gender)
    Spinner SpinnerGender;
    @BindView(R.id.tv_phone)
    EditText tvPhone;
    @BindView(R.id.spinner_id)
    Spinner spinnerID;
    @BindView(R.id.tv_identity_number)
    EditText tvIdendityNumber;
    @BindView(R.id.picker_date)
    View vPickerDate;
    @BindView(R.id.tv_masa_berlaku)
    TextView tvMasaBerlaku;
    @BindView(R.id.cb_seumur_hidup)
    CheckBox cbSeumurHidup;
    @BindView(R.id.tv_tempat_lahir)
    EditText tvTempatLahir;
    @BindView(R.id.spinner_tgl)
    Spinner spinnerTgl;
    @BindView(R.id.spinner_bulan)
    Spinner spinnerBulan;
    @BindView(R.id.spinner_tahun)
    Spinner spinnerTahun;
    @BindView(R.id.tv_mother_name)
    EditText tvMotherName;
    @BindView(R.id.tv_rencana_plafond)
    EditText tvRencanaPlafond;
    @BindView(R.id.tv_rencana_angsuran)
    EditText tvRencanaAngsuran;
    @BindView(R.id.tv_rencana_tenor)
    EditText tvRencanaTenor;
    @BindView(R.id.dd_tujuan_pembiayaan)
    Spinner ddTujuanPembiayaan;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajukan_pinjaman);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getString(R.string.action_ajukan_pinjaman));

        controller = new AjukanPinjamanController(this);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }

    private void initView() {
        spinnerTahun.setAdapter(WidgetUtil.createAdapterTahun(getApplicationContext()));
        spinnerBulan.setAdapter(WidgetUtil.createAdapterBulan(getApplicationContext()));
        spinnerTgl.setAdapter(WidgetUtil.createAdapterTanggal(getApplicationContext()));

        cbSeumurHidup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if( isChecked) {
                    vPickerDate.setEnabled(false);
                    vPickerDate.setClickable(false);
                    tvMasaBerlaku.setText("");
                } else {
                    vPickerDate.setEnabled(true);
                    vPickerDate.setClickable(true);
                }
            }
        });
        vPickerDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WidgetUtil.showDatePicker(FormAjukanPinjamanActivity.this, tvMasaBerlaku);
            }
        });

        WidgetUtil.setTextWatcherCurrency(tvRencanaPlafond, Config.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvRencanaAngsuran, Config.MAX_PLAFOND_VALUE);
        WidgetUtil.setTextWatcherCurrency(tvRencanaTenor, 60);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onSaveProspekFailed(Throwable t) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, t.getMessage());
    }

    @Override
    public void onSaveProspekSuccess(String message) {
        DialogFactory.dismissProgress();
        DialogFactory.showAlert(this, message);
    }

    public void saveData() {
        if (!WidgetUtil.validateField(tvNickname, getString(R.string.field_err_msg, "Nama panggilan"))) {
            //return null;
        }

        if (!WidgetUtil.validateField(tvAddress, getString(R.string.field_err_msg, "Alamat"))) {
            //return null;
        }

        if (!WidgetUtil.validateField(tvPhone, getString(R.string.field_err_msg, "Nomor telepon"))) {
            //return null;
        }

        if (!WidgetUtil.validateField(tvMotherName, getString(R.string.field_err_msg, "Nama ibu kandung"))) {
            //return null;
        }
        else {
            if (mAjukanPinjamanModel == null) {
                mAjukanPinjamanModel = new AjukanPinjamanModel();
            }
            mAjukanPinjamanModel.setNamaLengkap(tvNickname.getText().toString());
            mAjukanPinjamanModel.setNamaPanggilan(tvFullname.getText().toString());
            mAjukanPinjamanModel.setAlamat(tvAddress.getText().toString());
            mAjukanPinjamanModel.setJenisKelamin(SpinnerGender.getSelectedItem().toString());
            mAjukanPinjamanModel.setNoHp(tvPhone.getText().toString());
            mAjukanPinjamanModel.setJenisIdentitas(spinnerID.getSelectedItem().toString());
            mAjukanPinjamanModel.setNoIdentitas(tvIdendityNumber.getText().toString());
            mAjukanPinjamanModel.setMasaBerlaku("1900-01-01");
            //mAjukanPinjamanModel.setIsSeumurHidup(cbSeumurHidup.isChecked()?1:0);
            mAjukanPinjamanModel.setTempatLahir(tvTempatLahir.getText().toString());
        /*
        if(spinnerTgl.getSelectedItemPosition() > 0 && spinnerBulan.getSelectedItemPosition() > 0 && spinnerTahun.getSelectedItemPosition() > 0) {
            String tgl = spinnerTgl.getSelectedItem() != null ? spinnerTgl.getSelectedItem().toString() : "";
            String bln = spinnerBulan.getSelectedItem() != null ? spinnerBulan.getSelectedItem().toString() : "";
            String thn = spinnerTahun.getSelectedItem() != null ? spinnerTahun.getSelectedItem().toString() : "";
            mAjukanPinjamanModel.setTanggalLahir(thn + "-" + bln + "-" + tgl);
        } else {
            mAjukanPinjamanModel.setTanggalLahir("1900-01-01");
        }*/
            mAjukanPinjamanModel.setTanggalLahir("1900-01-01");
            mAjukanPinjamanModel.setNamaIbuKandung(tvMotherName.getText().toString());
            mAjukanPinjamanModel.setPlafon(tvRencanaPlafond.getText().toString());
            mAjukanPinjamanModel.setAngsuran(tvRencanaAngsuran.getText().toString());
            mAjukanPinjamanModel.setTenor(tvRencanaTenor.getText().toString());
            mAjukanPinjamanModel.setTujuan(ddTujuanPembiayaan.getSelectedItem().toString());
            PostAjukanPinjamanResponse ps = new PostAjukanPinjamanResponse();
            List<AjukanPinjamanModel> biodataModelList = new ArrayList<>();
            biodataModelList.add(mAjukanPinjamanModel);
            ps.setSubmission(biodataModelList);
            DialogFactory.showProgress(this);
            controller.saveProspek(ps);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            saveData();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
