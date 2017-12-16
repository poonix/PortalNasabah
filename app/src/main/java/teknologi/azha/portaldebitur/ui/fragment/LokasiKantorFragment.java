package teknologi.azha.portaldebitur.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.callback.ListKantorCabangCallback;
import teknologi.azha.portaldebitur.controller.ListKantorCabangController;
import teknologi.azha.portaldebitur.model.LokasiKantorCabangModel;
import teknologi.azha.portaldebitur.ui.adapter.LokasiKantorAdapater;
import teknologi.azha.portaldebitur.ui.factory.SearchViewFactory;

/**
 * Created by user on 9/22/2017.
 */

public class LokasiKantorFragment extends android.support.v4.app.Fragment implements ListKantorCabangCallback{

    private static final String TAG = "ListKantor";
    private List<LokasiKantorCabangModel> kantorCabangModelList = new ArrayList<>();
    private List<LokasiKantorCabangModel> kantorCabangModelList_tmp = new ArrayList<>();
    private ListKantorCabangCallback callback;
    private LokasiKantorAdapater mAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView tvMessage;
    private ListKantorCabangController controller;
    private boolean isLoading = false;
    private int ids=0;
    private SearchViewFactory mSearchViewFactory;

    public  LokasiKantorFragment(){}

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        Log.v(TAG,"masuk oncreate"+kantorCabangModelList);

        mSearchViewFactory = new SearchViewFactory();
        mSearchViewFactory.setOnSearchListener(mSearchViewListener);
        controller = new ListKantorCabangController(this);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initdata(ids);

        mAdapter.notifyDataSetChanged();
    }

    public void initdata(int ids)
    {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Log.v(TAG,"masuk viewcreated"+ids);
        controller.connects(ids);

        mAdapter = new LokasiKantorAdapater(kantorCabangModelList);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lokasi_kantor, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progress_bar);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        tvMessage = (TextView) rootView.findViewById(R.id.tv_message);


        return rootView;
    }

    @Override
    public void onGetListKantorCabangSuccess (List<LokasiKantorCabangModel> lst) {
        if (lst != null && lst.size() > 0) {
            progressBar.setVisibility(View.GONE);
            kantorCabangModelList.addAll(lst);
            kantorCabangModelList_tmp.addAll(kantorCabangModelList);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onGetListKantorCabangFailed(Throwable t) {

    }

    private SearchViewFactory.OnSearchListener mSearchViewListener = new SearchViewFactory.OnSearchListener() {
        @Override
        public void onSearchStarted(String query) {
            doSearch(query);
        }

        @Override
        public void onSearchStopped() {
            //tvMessage.setVisibility(View.GONE);
        }
    };

    public void doSearch(String query) {
        kantorCabangModelList.clear();
        if (TextUtils.isEmpty(query)) {
            kantorCabangModelList.addAll(kantorCabangModelList_tmp);
            //tvMessage.setVisibility(View.GONE);
        } else {
            query = query.toLowerCase();
            boolean found = false;
            for (LokasiKantorCabangModel item : kantorCabangModelList_tmp) {
                if (!TextUtils.isEmpty(item.getMsCabangDeskripsi()) && item.getMsCabangDeskripsi().toLowerCase().contains(query)) {
                    kantorCabangModelList.add(item);
                    found = true;
                }

                if (!found) {
                    tvMessage.setText("Not Found");
                    tvMessage.setVisibility(View.VISIBLE);
                } else {
                    tvMessage.setVisibility(View.GONE);
                }
            }
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_list_lokasi, menu);
        inflater.inflate(R.menu.menu_sort_lokasi, menu);
        mSearchViewFactory.setupSearchMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_all) {
            kantorCabangModelList.clear();
            kantorCabangModelList_tmp.clear();
            initdata(0);
            return true;
        }

        if (id == R.id.action_barat) {
            kantorCabangModelList.clear();
            kantorCabangModelList_tmp.clear();
            initdata(1);
            return true;
        }

        if (id == R.id.action_timur) {
            kantorCabangModelList.clear();
            kantorCabangModelList_tmp.clear();
            initdata(2);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        if (controller != null) {
            controller.cancel();
        }
        super.onDestroy();
    }
}
