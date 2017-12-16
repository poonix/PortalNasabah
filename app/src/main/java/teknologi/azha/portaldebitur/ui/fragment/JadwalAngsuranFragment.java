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

import java.util.ArrayList;
import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.GetAngsuranPembiayaanCallback;
import teknologi.azha.portaldebitur.controller.AngsuranPembiayaanController;
import teknologi.azha.portaldebitur.model.AngsuranPembiayaanModel;
import teknologi.azha.portaldebitur.ui.adapter.DetailJadwalAngsuranAdapter;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;

/**
 * Created by pooni on 10/1/2017.
 */

public class JadwalAngsuranFragment extends android.support.v4.app.Fragment implements GetAngsuranPembiayaanCallback{

    private static final String TAG = "Angsuran Pembiayaan";
    private List<AngsuranPembiayaanModel> angsuranPembiayaanModel = new ArrayList<>();
    private List<AngsuranPembiayaanModel> angsuranPembiayaanModel_tmp = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AngsuranPembiayaanController controller;
    private String Norek;
    private DetailJadwalAngsuranAdapter mAdapter;

    private boolean isLoading = false;

    public JadwalAngsuranFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new AngsuranPembiayaanController(this);
    }

    public void initdata()
    {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        controller.doGetAngsuranPembiayaan(Norek);
        mAdapter = new DetailJadwalAngsuranAdapter(angsuranPembiayaanModel,Norek,getActivity());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item_angsuran, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
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
    public void onGetAngsuranDataSuccess(List<AngsuranPembiayaanModel> apm) {
        if (apm != null && apm.size() > 0) {
            progressBar.setVisibility(View.GONE);
            angsuranPembiayaanModel.addAll(apm);
            angsuranPembiayaanModel_tmp.addAll(angsuranPembiayaanModel);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetAngsuranDataFailed(Throwable t) {
        DialogFactory.showAlert(getContext(), t.getMessage());
    }
}
