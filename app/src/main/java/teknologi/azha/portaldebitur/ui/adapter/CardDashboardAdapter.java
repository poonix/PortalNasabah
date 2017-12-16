package teknologi.azha.portaldebitur.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;
import teknologi.azha.portaldebitur.ui.listerner.OnItemClickListener;
import teknologi.azha.portaldebitur.utils.WidgetUtil;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by pooni on 11/5/2017.
 */

public class CardDashboardAdapter extends RecyclerView.Adapter<CardDashboardAdapter.MyViewHolder>{

    private AppPreference appPreference = AppPreference.getInstance();
    private int menuType = appPreference.getMenu();
    private List<ListRekeningDebiturModel> listRek;
    private Context mContext;
    private OnItemClickListener onItemClickListener;

    public CardDashboardAdapter(List<ListRekeningDebiturModel> listRek){
        this.listRek=listRek;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView rekening,angsuran,jumlahPinjaman;

        public MyViewHolder(View view) {
            super(view);
            rekening = (TextView) view.findViewById(R.id.id_rekening);
            angsuran = (TextView) view.findViewById(R.id.tv_angsuran);
            jumlahPinjaman = (TextView) view.findViewById(R.id.jumlah_pinjaman);
        }
    }

    @Override
    public CardDashboardAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard_card, parent, false);
        return new CardDashboardAdapter.MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(CardDashboardAdapter.MyViewHolder holder, int position) {
        final ListRekeningDebiturModel mdl = listRek.get(position);
        holder.rekening.setText(mdl.getNoRekening());
        holder.angsuran.setText("Jumlah Angsuran "+String.valueOf(mdl.getJmlAngsuran()));
        holder.jumlahPinjaman.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getJmlPinjaman()));
    }

    @Override
    public int getItemCount() {
        return listRek.size();
    }

}
