package teknologi.azha.portaldebitur.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.model.DetailAngsuranBulananModel;
import teknologi.azha.portaldebitur.utils.WidgetUtil;
import teknologi.azha.portaldebitur.utils.preference.FormatDate;

/**
 * Created by pooni on 12/4/2017.
 */

public class DetailRiwayatDetilAngsuranAdapter extends RecyclerView.Adapter<DetailRiwayatDetilAngsuranAdapter.MyViewHolder>{
    private List<DetailAngsuranBulananModel> mModel;
    private Context Mcontext;
    private FormatDate fm = new FormatDate();

    public DetailRiwayatDetilAngsuranAdapter(List<DetailAngsuranBulananModel> APM, Context context)
    {
        mModel = APM;
        Mcontext=context;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView TglTransaksi,PokokDibayar,BungaDibayar,TotalDibayar,DendaAngsuran,DendaDibayar,TglJatuhTempo,AngsuranPokok,AngsuranBunga,TotalAngsuran,Keterangan;

        public MyViewHolder(View view) {
            super(view);
            //TitleAngsuran       = (TextView) view.findViewById(R.id.title_angsuran);
            TglTransaksi        = (TextView) view.findViewById(R.id.tvTglTransaksi);
            TglJatuhTempo       = (TextView) view.findViewById(R.id.tvTglJatuhTempoBlnan);
            PokokDibayar        = (TextView) view.findViewById(R.id.tvPokokDibayar);
            BungaDibayar        = (TextView) view.findViewById(R.id.tvBungaDibayar);
            DendaDibayar        = (TextView) view.findViewById(R.id.tvDendaDibayar);
            TotalDibayar        = (TextView) view.findViewById(R.id.tvTotalDibayar);
            DendaAngsuran       = (TextView) view.findViewById(R.id.tvDendaAngsuran);
            AngsuranPokok       = (TextView) view.findViewById(R.id.tvAngsuranPokok);
            AngsuranBunga       = (TextView) view.findViewById(R.id.tvAngsuranBunga);
            TotalAngsuran       = (TextView) view.findViewById(R.id.tvTotalAngsuran);
            Keterangan          = (TextView) view.findViewById(R.id.tvKeteranganDetail);
        }

    }


    @Override
    public DetailRiwayatDetilAngsuranAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_detail_riwayat, parent, false);
        return new DetailRiwayatDetilAngsuranAdapter.MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(DetailRiwayatDetilAngsuranAdapter.MyViewHolder holder, int position) {
        final DetailAngsuranBulananModel mdl = mModel.get(position);
        //holder.TitleAngsuran.setText("ANGSURAN "+mdl.getAngsuranKe());
        holder.TglTransaksi.setText(fm.DateFormat(mdl.getInnterTglTransaksi()));
        holder.TglJatuhTempo.setText(fm.DateFormat(mdl.getInnterTglJthTempo()));
        holder.Keterangan.setText(mdl.getKeterangan());

        if(mdl.getPokokDibayar() == null){
            holder.PokokDibayar.setText("-");
        }else {
            holder.PokokDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getPokokDibayar()));
        }
        if(mdl.getBungaDibayar() == null){
            holder.BungaDibayar.setText("-");
        }else {
            holder.BungaDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getBungaDibayar()));
        }
        if(mdl.getDendaDibayar() == null){
            holder.DendaDibayar.setText("-");
        }else {
            holder.DendaDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getDendaDibayar()));
        }
        if(mdl.getTotalDibayar() == null){
            holder.TotalDibayar.setText("-");
        }else {
            holder.TotalDibayar.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getTotalDibayar()));
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
        }
        if(mdl.getTOTAL_OS() == null){
            holder.TotalOs.setText("-");
        }else {
            holder.TotalOs.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getTOTAL_OS()));
        }*/

        if(mdl.getAngsuranPokok() == null){
            holder.AngsuranPokok.setText("-");
        }else {
            holder.AngsuranPokok.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getAngsuranPokok()));
        }
        if(mdl.getAngsuranBunga() == null){
            holder.AngsuranBunga.setText("-");
        }else {
            holder.AngsuranBunga.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getAngsuranBunga()));
        }
        if(mdl.getAngsuranDenda() == null){
            holder.DendaAngsuran.setText("-");
        }else {
            holder.DendaAngsuran.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getAngsuranDenda()));
        }
        if(mdl.getAngsuranTotal() == null){
            holder.TotalAngsuran.setText("-");
        }else {
            holder.TotalAngsuran.setText("Rp. " + WidgetUtil.convertToLocalCurrency(mdl.getAngsuranTotal()));
        }
    }

    @Override
    public int getItemCount() {
        return mModel.size();
    }
}
