package teknologi.azha.portaldebitur.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.model.ListRekeningDebiturModel;
import teknologi.azha.portaldebitur.ui.activity.HistoriActivity;
import teknologi.azha.portaldebitur.ui.activity.JadwalAngsuranActivity;
import teknologi.azha.portaldebitur.ui.listerner.OnItemClickListener;
import teknologi.azha.portaldebitur.utils.preference.AppPreference;

/**
 * Created by user on 11/7/2017.
 */

public class RekeningKantorAdapter extends RecyclerView.Adapter<RekeningKantorAdapter.MyViewHolder>{
    private AppPreference appPreference = AppPreference.getInstance();
    private int menuType = appPreference.getMenu();
    private List<ListRekeningDebiturModel> listRek;
    private Context mContext;
    private OnItemClickListener onItemClickListener;

    public RekeningKantorAdapter(List<ListRekeningDebiturModel> listRek){
        this.listRek=listRek;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView rekening,status;

        public MyViewHolder(View view) {
            super(view);
            rekening = (TextView) view.findViewById(R.id.tv_rekening_dashboard);
            status = (TextView) view.findViewById(R.id.tvStatusRekening);
        }
    }

    @Override
    public RekeningKantorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_rekening_dashboard, parent, false);
        return new RekeningKantorAdapter.MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(RekeningKantorAdapter.MyViewHolder holder, int position) {
        final ListRekeningDebiturModel mdl = listRek.get(position);
        if(mdl.getStatusAktif() == 1)
        {
            holder.status.setText("baru");
        }
        if(mdl.getStatusAktif() == 2)
        {
            holder.status.setText("aktif");
        }
        if(mdl.getStatusAktif() == 3)
        {
            holder.status.setText("Selesai");
        }
        holder.rekening.setText(mdl.getNoRekening());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (menuType) {
                    case 1:
                        Intent i = new Intent(view.getContext(), JadwalAngsuranActivity.class);
                        i.putExtra("norek", mdl.getNoRekening());
                        view.getContext().startActivity(i);

                        break;
                    case 2:
                        Intent q = new Intent(view.getContext(), HistoriActivity.class);
                        q.putExtra("norek", mdl.getNoRekening());
                        view.getContext().startActivity(q);

                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listRek.size();
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
