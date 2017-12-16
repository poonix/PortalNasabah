package teknologi.azha.portaldebitur.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;

/**
 * Created by user on 11/7/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<ListRekeningDebiturModel> listRek = new ArrayList<>();
    private TextView tvRekening;
    private LayoutInflater inflater;

    public ViewPagerAdapter(List<ListRekeningDebiturModel> listRek, Context context)
    {
        this.listRek=listRek;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return listRek.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_dashboard_card, container,
                false);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
