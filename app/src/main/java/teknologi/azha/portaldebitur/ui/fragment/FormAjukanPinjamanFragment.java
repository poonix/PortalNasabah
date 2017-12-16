package teknologi.azha.portaldebitur.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.model.AjukanPinjamanModel;
import teknologi.azha.portaldebitur.utils.WidgetUtil;
import teknologi.azha.portaldebitur.utils.preference.FormatDate;

/**
 * Created by user on 10/4/2017.
 */

public class FormAjukanPinjamanFragment extends Fragment {

    private AjukanPinjamanModel mAjukanPinjamanModel;
    private FormatDate fm = new FormatDate();

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
    @BindView(R.id.tv_masa_berlaku)
    EditText tvMasaBerlaku;
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


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ajukan_pinjaman_fragment, container, false);
        return rootView;
    }

    private void initView() {
        spinnerTahun.setAdapter(WidgetUtil.createAdapterTahun(getContext()));
        spinnerBulan.setAdapter(WidgetUtil.createAdapterBulan(getContext()));
        spinnerTgl.setAdapter(WidgetUtil.createAdapterTanggal(getContext()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
    }



    private void setupView() {
        if (mAjukanPinjamanModel != null) {
            tvNickname.setText(mAjukanPinjamanModel.getNamaPanggilan());
            tvFullname.setText(mAjukanPinjamanModel.getNamaLengkap());
            tvAddress.setText(mAjukanPinjamanModel.getAlamat());
            int posGender = WidgetUtil.getSpinnerIndexByLabel(SpinnerGender, mAjukanPinjamanModel.getJenisKelamin());
            SpinnerGender.setSelection(posGender);
            tvPhone.setText(mAjukanPinjamanModel.getNoHp());
            int posJenisId = WidgetUtil.getSpinnerIndexByLabel(spinnerID, mAjukanPinjamanModel.getJenisIdentitas());
            SpinnerGender.setSelection(posJenisId);
            tvIdendityNumber.setText(mAjukanPinjamanModel.getNoIdentitas());
            if (!TextUtils.isEmpty(mAjukanPinjamanModel.getMasaBerlaku()) && !mAjukanPinjamanModel.getMasaBerlaku().equals("1900-01-01")) {
                tvMasaBerlaku.setText(fm.DateFormat(mAjukanPinjamanModel.getMasaBerlaku()));
            }
            if (mAjukanPinjamanModel.getIsSeumurHidup() == 1) {
                cbSeumurHidup.setChecked(true);
            } else {
                cbSeumurHidup.setChecked(false);
            }
            tvTempatLahir.setText(mAjukanPinjamanModel.getTempatLahir());
            if (!TextUtils.isEmpty(mAjukanPinjamanModel.getTanggalLahir()) && !mAjukanPinjamanModel.getTanggalLahir().equals("1900-01-01")) {
                String tgl = fm.convertDateString(mAjukanPinjamanModel.getTanggalLahir(), "yyyy-MM-dd", "dd");
                String bln = fm.convertDateString(mAjukanPinjamanModel.getTanggalLahir(), "yyyy-MM-dd", "MM");
                String tahun = fm.convertDateString(mAjukanPinjamanModel.getTanggalLahir(), "yyyy-MM-dd", "yyyy");
                int posTgl = WidgetUtil.getSpinnerIndexByLabel(spinnerTgl, tgl);
                spinnerTgl.setSelection(posTgl);
                int posBulan = WidgetUtil.getSpinnerIndexByLabel(spinnerBulan, bln);
                spinnerBulan.setSelection(posBulan);
                int posTahun = WidgetUtil.getSpinnerIndexByLabel(spinnerTahun, tahun);
                spinnerTahun.setSelection(posTahun);
            }
            tvMotherName.setText(mAjukanPinjamanModel.getNamaIbuKandung());
            tvRencanaPlafond.setText(mAjukanPinjamanModel.getPlafon());
            tvRencanaTenor.setText(mAjukanPinjamanModel.getTenor());
        }

    }


}
