package teknologi.azha.portaldebitur.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pooni on 10/1/2017.
 */

public class AngsuranPembiayaanModel {
    /*
    {
            "TGL_TRANS": {
                "date": "2013-10-16 00:00:00.000000",
                "timezone_type": 3,
                "timezone": "America/Los_Angeles"
            },
            "ANGSURAN_KE": "1",
            "POKOK_TRANS": "925100.00",
            "BUNGA_TRANS": "742950.00",
            "TOTAL_ANGSURAN": 1668050
        }
    */
    @SerializedName("TGL_TRANS")
    @Expose
    private TGL_TRANS tgl_trans;
    @SerializedName("ANGSURAN_KE")
    @Expose
    private int ANGSURAN_KE;
    @SerializedName("POKOK_TRANS")
    @Expose
    private Float POKOK_TRANS;
    @SerializedName("BUNGA_TRANS")
    @Expose
    private Float BUNGA_TRANS;
    @SerializedName("TOTAL_ANGSURAN")
    @Expose
    private int TOTAL_ANGSURAN;

    public TGL_TRANS getTglTrans()
    {
        return tgl_trans;
    }

    public void setTglTrans(TGL_TRANS tgl_trans)
    {
        this.tgl_trans=tgl_trans;
    }

    public int getAngsuranKe()
    {
        return ANGSURAN_KE;
    }

    public void setAngsuranKe(int ANGSURAN_KE)
    {
        this.ANGSURAN_KE=ANGSURAN_KE;
    }

    public Float getPokokTrans()
    {
        return POKOK_TRANS;
    }

    public void setPokokTrans(Float POKOK_TRANS)
    {
        this.POKOK_TRANS=POKOK_TRANS;
    }

    public Float getBungaTrans()
    {
        return BUNGA_TRANS;
    }

    public void setBungaTrans(Float BUNGA_TRANS)
    {
        this.BUNGA_TRANS=BUNGA_TRANS;
    }

    public int getTotalAngsuran()
    {
        return TOTAL_ANGSURAN;
    }

    public void setTotalAngsuran(int TOTAL_ANGSURAN)
    {
        this.TOTAL_ANGSURAN=TOTAL_ANGSURAN;
    }

    public class TGL_TRANS
    {
        @SerializedName("date")
        @Expose
        private String dateTransaksi;

        public String getDateTransaksi()
        {
            return dateTransaksi;
        }

        public void setDateTransaksi(String dateTransaksi)
        {
            this.dateTransaksi=dateTransaksi;
        }
    }

    public String getInnterTglTransaksi()
    {
        try {
            return getTglTrans().getDateTransaksi();
        } catch (Exception e) {
            return null;
        }
    }
}
