package teknologi.azha.portaldebitur.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import teknologi.azha.portaldebitur.R;

/**
 * Created by user on 9/22/2017.
 */

public class DetailLokasiKantorFragment extends Fragment {
    private static final String LOG_TAG = DetailLokasiKantorFragment.class.getSimpleName();
    private static final String MOVIES_LEARNING_AZHA = " #AzhaLearning";
    private static String getIntentTitle;
    private static String getIntentAlamat;
    private static String getIntentNotelp;


    public DetailLokasiKantorFragment() {setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_lokasi_kantor, container, false);
        Intent intent = getActivity().getIntent();

        getIntentTitle = intent.getStringExtra("Nama Cabang");
        ((TextView) rootView.findViewById(R.id.tvTitleCabang)).setText(getIntentTitle);

        getIntentAlamat = intent.getStringExtra("Alamat Cabang");
        ((TextView) rootView.findViewById(R.id.tvAlamatDetail)).setText(getIntentAlamat);

        getIntentNotelp = intent.getStringExtra("NoTelp Cabang");
        ((TextView) rootView.findViewById(R.id.tvPhoneDetail)).setText(getIntentNotelp);

        return rootView;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //inflater.inflate(R.menu.detail_menu, menu);

        // Retrieve the share menu item
        //MenuItem menuItem = menu.findItem(R.id.action_share);

        // Get the provider and hold onto it to set/change the share intent.
        //ShareActionProvider mShareActionProvider =
        //        (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        // Attach an intent to this ShareActionProvider.  You can update this at any time,
        // like when the user selects a new piece of data they might like to share.
        //if (mShareActionProvider != null ) {
        //    mShareActionProvider.setShareIntent(createShareMovieIntent());
        //} else {
            Log.d(LOG_TAG, "Share Action Provider is null?");
        //}
    }

}
