package teknologi.azha.portaldebitur.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Bus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import teknologi.azha.portaldebitur.MyApplication;

/**
 * Created by pooni on 11/2/2017.
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment {

    private Unbinder unbinder;
    protected final Bus bus = MyApplication.getEventBus();
    protected View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getFragmentView(), container, false);
        unbinder = ButterKnife.bind(this, view);
        bus.register(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        bus.unregister(this);
        super.onDestroyView();
    }

    public abstract int getFragmentView();

}
