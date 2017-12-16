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
import teknologi.azha.portaldebitur.model.RiwayatAngsuranModel;
import teknologi.azha.portaldebitur.ui.activity.DetailHistoriAngsuranActivity;
import teknologi.azha.portaldebitur.ui.fragment.HistoriAngsuranFragment;
import teknologi.azha.portaldebitur.utils.WidgetUtil;
import teknologi.azha.portaldebitur.utils.preference.FormatDate;

/**
 * Created by user on 11/8/2017.
 */

public class DetailRiwayatAngsuranAdapter extends RecyclerView.Adapter<DetailRiwayatAngsuranAdapter.MyViewHolder> {
    private List<RiwayatAngsuranModel> mModel;
    private Context Mcontext;
    private String NoRek;
    private FormatDate fm = new FormatDate();

    public DetailRiwayatAngsuranAdapter(List<RiwayatAngsuranModel> APM,Context context, String Norek)
    {
        mModel = APM;
        Mcontext=context;
        NoRek=Norek;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView TitleAngsuran,TglTransaksi,PokokDibayar,BungaDibayar,TotalDibayar,TotalOs,BungaOs,PokokOs,AngsuranPokok,AngsuranBunga,TotalAngsuran,TvDetail;

        public MyViewHolder(View view) {
            super(view);
            TitleAngsuran   = (TextView) view.findViewById(R.id.title_angsuran);
            TglTransaksi    = (TextView) view.findViewById(R.id.tvTglTransaksi);
            //PokokDibayar      = (TextView) view.findViewById(R.id.tvPokokDibayar);
            //BungaDibayar      = (TextView) view.findViewById(R.id.tvBungaDibayar);
            TotalDibayar   = (TextView) view.findViewById(R.id.tvTotalDibayar);
            TotalOs       = (TextView) view.findViewById(R.id.tvTotalOs);
            //BungaOs       = (TextView) view.findViewById(R.id.tvBungaOs);
            //PokokOs       = (TextView) view.findViewById(R.id.tvPokokOs);
            //AngsuranPokok = (TextView) view.findViewById(R.id.tvAngsuranPokok);
            //AngsuranBunga = (TextView) view.findViewById(R.id.tvAngsuranBunga);
            TotalAngsuran = (TextView) view.findViewById(R.id.tvTotalAngsuran);
            TvDetail = (TextView) view.findViewById(R.id.tv_detail);
        }
    }

    @Override
    public DetailRiwayatAngsuranAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_riwayat_baru, parent, false);
        return new DetailRiwayatAngsuranAdapter.MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(DetailRiwayatAngsuranAdapter.MyViewHolder holder, int position) {
        final RiwayatAngsuranModel mdl = mModel.get(position);
        holder.TitleAngsuran.setText("ANGSURAN "+mdl.getAngsuranKe());
        holder.TglTransaksi.setText(fm.DateFormat(mdl.getInnterTglTransaksi()));
        /*
        if(mdl.getPOKOK_DIBAYAR() == null){
            holder.PokokDibayar.setText("-");
        }else {
            holder.PokokDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getPOKOK_DIBAYAR()));
        }
        if(mdl.getBUNGA_DIBAYAR() == null){
            holder.BungaDibayar.setText("-");
        }else {
            holder.BungaDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getBUNGA_DIBAYAR()));
        }*/
        if(mdl.getTOT_BAYAR() == null){
            holder.TotalDibayar.setText("-");
        }else {
            holder.TotalDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getTOT_BAYAR()));
        }
        /*
        if(mdl.getPOKOK_OS() == null){
            holder.PokokOs.setText("-");
        }else {
            holder.PokokOs.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getPOKOK_OS()));
        }
        if(mdl.getBUNGA_OS() == null){
            holder.BungaOs.setText("-");
        }else {
            holder.BungaOs.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getBUNGA_OS()));
        }*/
        if(mdl.getTOTAL_OS() == null){
            holder.TotalOs.setText("-");
        }else {
            holder.TotalOs.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getTOTAL_OS()));
        }
        /*
        if(mdl.getBUNGA_DIBAYAR() == null){
            holder.BungaDibayar.setText("-");
        }else {
            holder.BungaDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getBUNGA_DIBAYAR()));
        }
        if(mdl.getANGSURAN_POKOK() == null){
            holder.AngsuranPokok.setText("-");
        }else {
            holder.AngsuranPokok.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getANGSURAN_POKOK()));
        }
        if(mdl.getANGSURAN_BUNGA() == null){
            holder.AngsuranBunga.setText("-");
        }else {
            holder.AngsuranBunga.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getANGSURAN_BUNGA()));
        }*/
        if(mdl.getTOT_ANGSURAN() == null){
            holder.TotalAngsuran.setText("-");
        }else {
            holder.TotalAngsuran.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getTOT_ANGSURAN()));
        }
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
