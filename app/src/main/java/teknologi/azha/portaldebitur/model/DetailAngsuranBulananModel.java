package teknologi.azha.portaldebitur.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pooni on 12/4/2017.
 */

public class DetailAngsuranBulananModel {
    @SerializedName("ANGSURAN_KE")
    @Expose
    private Double AngsuranKe;
    @SerializedName("TGL_JATUH_TEMPO_BULANAN")
    @Expose
    private TGL_JATUH_TEMPO_BULANAN TglJatuhTempoBulanan;
    @SerializedName("ANGSURAN_POKOK")
    @Expose
    private Double AngsuranPokok;
    @SerializedName("ANGSURAN_BUNGA")
    @Expose
    private Double AngsuranBunga;
    @SerializedName("ANGSURAN_DENDA")
    @Expose
    private Double AngsuranDenda;
    @SerializedName("ANGSURAN_TOTAL")
    @Expose
    private Double AngsuranTotal;
    @SerializedName("TGL_TRANS")
    @Expose
    private TGL_TRANS TglTrans;
    @SerializedName("POKOK_DIBAYAR")
    @Expose
    private Double PokokDibayar;
    @SerializedName("BUNGA_DIBAYAR")
    @Expose
    private Double BungaDibayar;
    @SerializedName("DENDA_DIBAYAR")
    @Expose
    private Double DendaDibayar;
    @SerializedName("TOTAL_DIBAYAR")
    @Expose
    private Double TotalDibayar;
    @SerializedName("KETERANGAN")
    @Expose
    private String Keterangan;

    public Double getAngsuranKe()
    {
        return AngsuranKe;
    }
    public void setAngsuranKe(Double AngsuranKe)
    {
        this.AngsuranKe=AngsuranKe;
    }

    public Double getAngsuranPokok()
    {
        return AngsuranPokok;
    }
    public void setAngsuranPokok(Double AngsuranPokok)
    {
        this.AngsuranPokok=AngsuranPokok;
    }

    public Double getAngsuranBunga()
    {
        return AngsuranBunga;
    }
    public void setAngsuranBunga(Double AngsuranBunga)
    {
        this.AngsuranBunga=AngsuranBunga;
    }

    public Double getAngsuranDenda()
    {
        return AngsuranDenda;
    }
    public void setAngsuranDenda(Double AngsuranDenda)
    {
        this.AngsuranDenda=AngsuranDenda;
    }

    public Double getPokokDibayar()
    {
        return PokokDibayar;
    }
    public void setPokokDibayar(Double PokokDibayar)
    {
        this.PokokDibayar=PokokDibayar;
    }

    public Double getAngsuranTotal()
    {
        return AngsuranTotal;
    }
    public void setAngsuranTotal(Double AngsuranTotal)
    {
        this.AngsuranTotal=AngsuranTotal;
    }

    public Double getBungaDibayar()
    {
        return BungaDibayar;
    }
    public void setBungaDibayar(Double BungaDibayar)
    {
        this.BungaDibayar=BungaDibayar;
    }

    public Double getDendaDibayar()
    {
        return DendaDibayar;
    }
    public void setDendaDibayar(Double DendaDibayar)
    {
        this.DendaDibayar=DendaDibayar;
    }

    public Double getTotalDibayar()
    {
        return TotalDibayar;
    }
    public void setTotalDibayar(Double TotalDibayar)
    {
        this.TotalDibayar=TotalDibayar;
    }

    public String getKeterangan()
    {
        return Keterangan;
    }
    public void setKeterangan(String Keterangan)
    {
        this.Keterangan=Keterangan;
    }

    public TGL_JATUH_TEMPO_BULANAN getTglJthTempoBulanan()
    {
        return TglJatuhTempoBulanan;
    }
    public void setTglJthTempoBulanan(TGL_JATUH_TEMPO_BULANAN TglJatuhTempoBulanan)
    {
        this.TglJatuhTempoBulanan=TglJatuhTempoBulanan;
    }

    public TGL_TRANS getTglTrans()
    {
        return TglTrans;
    }
    public void setTglTrans(TGL_TRANS TglTrans)
    {
        this.TglTrans=TglTrans;
    }

    public class TGL_JATUH_TEMPO_BULANAN
    {
        @SerializedName("date")
        @Expose
        private String dateJatuhTempoBulanan;

        public String getDateBulanan()
        {
            return dateJatuhTempoBulanan;
        }

        public void setDateBulanan(String dateJatuhTempoBulanan)
        {
            this.dateJatuhTempoBulanan=dateJatuhTempoBulanan;
        }
    }

    public class TGL_TRANS
    {
        @SerializedName("date")
        @Expose
        private String DateTrans;

        public String getDateTrans()
        {
            return DateTrans;
        }

        public void setDateBulanan(String DateTrans)
        {
            this.DateTrans=DateTrans;
        }
    }

    public String getInnterTglTransaksi()
    {
        try {
            return getTglTrans().getDateTrans();
        } catch (Exception e) {
            return null;
        }
    }

    public String getInnterTglJthTempo()
    {
        try {
            return getTglJthTempoBulanan().getDateBulanan();
        } catch (Exception e) {
            return null;
        }
    }
}
