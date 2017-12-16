package teknologi.azha.portaldebitur.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.relex.circleindicator.CircleIndicator;
import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.GetRekeningCallback;
import teknologi.azha.portaldebitur.callback.ListKantorCabangCallback;
import teknologi.azha.portaldebitur.controller.GetRekeningController;
import teknologi.azha.portaldebitur.controller.ListKantorCabangController;
import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;
import teknologi.azha.portaldebitur.model.RekeningDebiturModel;
import teknologi.azha.portaldebitur.ui.adapter.CardDashboardAdapter;
import teknologi.azha.portaldebitur.ui.adapter.LokasiKantorAdapater;
import teknologi.azha.portaldebitur.ui.adapter.RekeningKantorAdapter;
import teknologi.azha.portaldebitur.ui.adapter.ViewPagerAdapter;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by pooni on 11/2/2017.
 */

public class DashboardFragment extends BaseFragment implements GetRekeningCallback{
    private static final String TAG = "Dashboard Fragment";

    private AppPreference appPreference = AppPreference.getInstance();
    private String idDebitur = appPreference.getUserLoggedIn().getNasabahId();
    private TextView tvMessage;
    private ProgressBar progressBar;
    private ViewPagerAdapter mSectionsPagerAdapter;
    private CardDashboardAdapter mAdapter;

    //private static final int NUM_PAGES = 2;
    private List<ListRekeningDebiturModel> rekeningList = new ArrayList<>();
    private List<ListRekeningDebiturModel> rekeningList_tmp = new ArrayList<>();
    private GetRekeningCallback callback;
    private RecyclerView recyclerView;
    GetRekeningController controller;

    @BindView(R.id.tv_profile_name)
    TextView tvProfileName;
    @BindView(R.id.id_debitur)
    TextView tvIdDebitur;
    /*
    @BindView(R.id.tvHistoryPembiayaan)
    TextView tvHistoryPembiayaan;
    @BindView(R.id.tvAngsuranPembiayaan)
    TextView tvAngsuranPembiayaan;
    @BindView(R.id.btn_lokasi_kantor_dashboard)
    Button btn_lokasi_kantor_dashboard;

    @OnClick({
            R.id.tvAngsuranPembiayaan,
            R.id.tvHistoryPembiayaan
    })*/

    public DashboardFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        controller = new GetRekeningController(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        tvMessage = (TextView) view.findViewById(R.id.tvMessage);
        initdata(idDebitur);
    }


    public void initdata(String idDebitur)
    {
        /*
        ViewPager vpPager = (ViewPager) view.findViewById(R.id.viewPager);

        vpPager.setClipToPadding(false);
        vpPager.setPageMargin(12);
        mSectionsPagerAdapter = new ViewPagerAdapter(rekeningList,getContext());
        vpPager.setAdapter(mSectionsPagerAdapter);
        indicator.setViewPager(vpPager);*/

        tvProfileName.setText(AppPreference.getInstance().getUserLoggedIn().getNamaNasabah());
        tvIdDebitur.setText(AppPreference.getInstance().getUserLoggedIn().getNasabahId());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        controller.getListRekening(idDebitur);

        mAdapter = new CardDashboardAdapter(rekeningList);
        recyclerView.setAdapter(mAdapter);



        mAdapter.notifyDataSetChanged();
    }


    public class SectionsPagerAdapter extends FragmentStatePagerAdapter { // FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlideFragment();
        }

        @Override
        public int getCount() {
            int jum = 2;
            return jum;
        }
    }

    @Override
    public int getFragmentView() {
        return R.layout.activity_dashboard;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onGetRekeningSuccess(List<ListRekeningDebiturModel> listRekDebitur) {
        if (listRekDebitur != null && listRekDebitur.size() > 0) {
            rekeningList.addAll(listRekDebitur);
            rekeningList_tmp.addAll(rekeningList);

            progressBar.setVisibility(View.GONE);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetRekeningFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if (!isVisible()) {
            return;
        }
        tvMessage.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        DialogFactory.showAlert(getContext(), t.getMessage());
    }
}
