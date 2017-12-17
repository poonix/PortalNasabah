package teknologi.azha.portaldebitur.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import teknologi.azha.portaldebitur.callback.GetRekeningCallback;
import teknologi.azha.portaldebitur.controller.GetRekeningController;
import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;
import teknologi.azha.portaldebitur.ui.adapter.RekeningKantorAdapter;
import teknologi.azha.portaldebitur.ui.factory.DialogFactory;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by user on 11/9/2017.
 */

public class ListRekeningFragment extends Fragment implements GetRekeningCallback{
    private AppPreference appPreference = AppPreference.getInstance();
    private static final String TAG = "List Rekening";
    private int menuType = appPreference.getMenu();
    private List<ListRekeningDebiturModel> rekeningList = new ArrayList<>();
    private List<ListRekeningDebiturModel> rekeningList_tmp = new ArrayList<>();
    private GetRekeningCallback callback;
    private RecyclerView recyclerView;
    private GetRekeningController controller;
    private String idDebitur = appPreference.getUserLoggedIn().getNasabahId();
    private TextView tvMessage;
    private ProgressBar progressBar;
    private RekeningKantorAdapter mAdapter;

    public ListRekeningFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        controller = new GetRekeningController(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item_rekening, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        tvMessage = (TextView) rootView.findViewById(R.id.tvMessage);

        return rootView;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initdata(idDebitur);
    }

    @Override
    public void onGetRekeningSuccess(List<ListRekeningDebiturModel> listRekDebitur) {
        if (listRekDebitur != null && listRekDebitur.size() > 0) {
            rekeningList.addAll(listRekDebitur);
            rekeningList_tmp.addAll(rekeningList);

            progressBar.setVisibility(View.GONE);
        }
        else
        {
            progressBar.setVisibility(View.GONE);
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setText("Tidak ada data");
        }
        mAdapter.notifyDataSetChanged();
    }

    public void initdata(String IdDebitur)
    {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        switch (menuType) {
            case 1:
                controller.getListRekeningJadwal(IdDebitur);
                Log.v("test",""+menuType);
                break;
            case 2:
                controller.getListRekeningRiwayat(IdDebitur);
                Log.v("test 2",""+menuType);
                break;
        }

        mAdapter = new RekeningKantorAdapter(rekeningList);
        recyclerView.setAdapter(mAdapter);
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
