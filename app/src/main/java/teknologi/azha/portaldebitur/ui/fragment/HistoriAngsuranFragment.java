package teknologi.azha.portaldebitur.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.GetRiwayatAngsuranCallback;
import teknologi.azha.portaldebitur.controller.RiwayatAngsuranController;
import teknologi.azha.portaldebitur.model.RiwayatAngsuranModel;
import teknologi.azha.portaldebitur.ui.adapter.DetailRiwayatAngsuranAdapter;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;

/**
 * Created by user on 11/8/2017.
 */

public class HistoriAngsuranFragment extends android.support.v4.app.Fragment implements GetRiwayatAngsuranCallback {

    private static final String TAG = "Riwayat Angsuran";
    private List<RiwayatAngsuranModel> riwayatModel = new ArrayList<>();
    private List<RiwayatAngsuranModel> riwayatModel_tmp = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
     String Norek;
    private RiwayatAngsuranController controller;
    private DetailRiwayatAngsuranAdapter mAdapter;
    private TextView tvMessage;
    //private Unbinder unbinder;

    //@BindView(R.id.tv_detail)
    //TextView tvDetail;

    public HistoriAngsuranFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new RiwayatAngsuranController(this);
    }

    public void initdata()
    {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        controller.doit(Norek);
        mAdapter = new DetailRiwayatAngsuranAdapter(riwayatModel,getActivity(),Norek);
        recyclerView.setAdapter(mAdapter);
        /*
        tvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"rest riwayat angsuran klik");
            }
        });*/

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item_riwayat, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        tvMessage = (TextView) rootView.findViewById(R.id.tvMessage);

        //unbinder = ButterKnife.bind(this,rootView);
        Intent intent = getActivity().getIntent();
        Norek  = intent.getStringExtra("norek");
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initdata();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetRiwayatAngsuranSuccess(List<RiwayatAngsuranModel> apm) {
        if (apm != null && apm.size() > 0) {
            progressBar.setVisibility(View.GONE);
            tvMessage.setVisibility(View.GONE);
            riwayatModel.addAll(apm);
            riwayatModel_tmp.addAll(riwayatModel);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetRiwayatAngsuranFailed(Throwable t) {
        DialogFactory.dismissProgress();
        if (!isVisible()) {
            return;
        }
        tvMessage.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        DialogFactory.showAlert(getContext(), t.getMessage());
    }
}
