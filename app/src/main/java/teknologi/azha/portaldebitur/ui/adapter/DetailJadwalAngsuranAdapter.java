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
import teknologi.azha.portaldebitur.model.AngsuranPembiayaanModel;
import teknologi.azha.portaldebitur.ui.activity.DetailHistoriAngsuranActivity;
import teknologi.azha.portaldebitur.ui.fragment.HistoriAngsuranFragment;
import teknologi.azha.portaldebitur.utils.WidgetUtil;
import teknologi.azha.portaldebitur.utils.preference.FormatDate;

/**
 * Created by pooni on 10/1/2017.
 */

public class DetailJadwalAngsuranAdapter extends RecyclerView.Adapter<DetailJadwalAngsuranAdapter.MyViewHolder>{
    private List<AngsuranPembiayaanModel> mModel;
    private Context Mcontext = null;
    private String NoRek;
    private FormatDate fm = new FormatDate();

    public DetailJadwalAngsuranAdapter(List<AngsuranPembiayaanModel> APM,String Norek,Context context)
    {
        NoRek=Norek;
        mModel = APM;
        Mcontext=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView TitleAngsuran,TglTransaksi,PokokTrans,BungaTrans,TotalAngsuran,TvDetail;

        public MyViewHolder(View view) {
            super(view);
            TitleAngsuran = (TextView) view.findViewById(R.id.title_angsuran);
            TglTransaksi = (TextView) view.findViewById(R.id.tvTglTransaksi);
            //PokokTrans = (TextView) view.findViewById(R.id.tvPokokTrans);
            //BungaTrans = (TextView) view.findViewById(R.id.tvBungaTrans);
            TotalAngsuran = (TextView) view.findViewById(R.id.tvTotalAngsuran);
            TvDetail = (TextView) view.findViewById(R.id.tv_detail);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_angsuran, parent, false);
        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final AngsuranPembiayaanModel mdl = mModel.get(position);
        holder.TitleAngsuran.setText("ANGSURAN "+WidgetUtil.convertToLocalCurrency(mdl.getAngsuranKe()));
        holder.TglTransaksi.setText(fm.DateFormat(mdl.getInnterTglTransaksi()));
        //holder.PokokTrans.setText("Rp. "+WidgetUtil.convertToLocalCurrency(mdl.getPokokTrans()));
        //holder.BungaTrans.setText("Rp. "+WidgetUtil.convertToLocalCurrency(mdl.getBungaTrans()));
        holder.TotalAngsuran.setText("Rp. "+WidgetUtil.convertToLocalCurrency(mdl.getTotalAngsuran()));
        holder.TvDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ad = new Intent(Mcontext, DetailHistoriAngsuranActivity.class);
                HistoriAngsuranFragment hs = new HistoriAngsuranFragment();
                ad.putExtra("AngsuranKe", String.valueOf(mdl.getAngsuranKe()));
                ad.putExtra("NoRek", NoRek);
                Mcontext.startActivity(ad);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModel.size();
    }
}
