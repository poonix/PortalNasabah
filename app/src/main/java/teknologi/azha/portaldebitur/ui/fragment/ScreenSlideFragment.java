package teknologi.azha.portaldebitur.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import teknologi.azha.portaldebitur.R;

/**
 * Created by pooni on 11/5/2017.
 */

public class ScreenSlideFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.item_dashboard_card, container, false);

        return rootView;
    }
}
