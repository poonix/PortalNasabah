package teknologi.azha.portaldebitur.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.GetDetailRiwayatAngsuranCallback;
import teknologi.azha.portaldebitur.controller.DetailRiwayatAngsuranController;
import teknologi.azha.portaldebitur.model.DetailAngsuranBulananModel;
import teknologi.azha.portaldebitur.ui.adapter.DetailRiwayatDetilAngsuranAdapter;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;

/**
 * Created by pooni on 12/4/2017.
 */

public class DetailHistoriAngsuranFragment extends android.support.v4.app.Fragment implements GetDetailRiwayatAngsuranCallback{
    private static final String TAG = "Detail Riwayat Angsuran";
    private List<DetailAngsuranBulananModel> riwayatModel = new ArrayList<>();
    private List<DetailAngsuranBulananModel> riwayatModel_tmp = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private String AngsuranKe,Noreks;
    private TextView tvMessage;
    private DetailRiwayatAngsuranController controller;
    private DetailRiwayatDetilAngsuranAdapter mAdapter;

    public DetailHistoriAngsuranFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new DetailRiwayatAngsuranController(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.list_item_detail_riwayat, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        tvMessage = (TextView) rootView.findViewById(R.id.tvMessage);

        //unbinder = ButterKnife.bind(this,rootView);
        Intent intent = getActivity().getIntent();
        AngsuranKe  = intent.getStringExtra("AngsuranKe");
        Noreks = intent.getStringExtra("NoRek");


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initdata();

        mAdapter.notifyDataSetChanged();
    }

    public void initdata()
    {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Log.v(TAG,"NoRek :"+Noreks+"| Angsuran Ke"+ AngsuranKe);
        controller.CallIt(Noreks,AngsuranKe);
        mAdapter = new DetailRiwayatDetilAngsuranAdapter(riwayatModel,getActivity());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onGetDetailRiwayatAngsuranFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if (!isVisible()) {
            return;
        }
        tvMessage.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        DialogFactory.showAlert(getContext(), t.getMessage());
    }

    @Override
    public void onGetDetailRiwayatAngsuranSuccess(List<DetailAngsuranBulananModel> apm) {
        if (apm != null && apm.size() > 0) {
            progressBar.setVisibility(View.GONE);
            tvMessage.setVisibility(View.GONE);
            riwayatModel.addAll(apm);
            riwayatModel_tmp.addAll(riwayatModel);
        }else
        {
            progressBar.setVisibility(View.GONE);
            tvMessage.setText("Tidak Ada Data");
        }
        mAdapter.notifyDataSetChanged();
    }
}
