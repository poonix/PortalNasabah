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
import teknologi.azha.portaldebitur.model.LokasiKantorCabangModel;
import teknologi.azha.portaldebitur.ui.activity.DetailLokasiActivity;
import teknologi.azha.portaldebitur.ui.listerner.OnItemClickListener;
/**
 * Created by user on 9/22/2017.
 */

public class LokasiKantorAdapater extends RecyclerView.Adapter<LokasiKantorAdapater.MyViewHolder> {
    private List<LokasiKantorCabangModel> mKantorCabang;
    private Context Mcontext;
    private OnItemClickListener onItemClickListener;

    public LokasiKantorAdapater(List<LokasiKantorCabangModel> ListKantorCabang)
    {
        mKantorCabang = ListKantorCabang;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Lokasi,Alamat;

        public MyViewHolder(View view) {
            super(view);
            Lokasi = (TextView) view.findViewById(R.id.tvKantorCabang);
            Alamat = (TextView) view.findViewById(R.id.tv_address);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_lokasi_kantor, parent, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final LokasiKantorCabangModel mdl = mKantorCabang.get(position);
        holder.Lokasi.setText(mdl.getMsCabangDeskripsi());
        holder.Alamat.setText(mdl.getMsCabangAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent di = new Intent(view.getContext(), DetailLokasiActivity.class);

                di.putExtra("Nama Cabang", mdl.getMsCabangDeskripsi());
                di.putExtra("Alamat Cabang", mdl.getMsCabangAlamat());
                di.putExtra("NoTelp Cabang", mdl.getMsCabangTelepon());

                view.getContext().startActivity(di);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mKantorCabang.size();
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
