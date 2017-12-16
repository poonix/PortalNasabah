package teknologi.azha.portaldebitur.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 11/8/2017.
 */

public class RiwayatAngsuranModel {
    @SerializedName("ANGSURAN_KE")
    @Expose
    private int ANGSURAN_KE;
    @SerializedName("TGL_TRANS")
    @Expose
    private TGL_TRANS tgl_trans;
    @SerializedName("POKOK_DIBAYAR")
    @Expose
    private Double POKOK_DIBAYAR;
    @SerializedName("BUNGA_DIBAYAR")
    @Expose
    private Double BUNGA_DIBAYAR;
    @SerializedName("TOT_BAYAR")
    @Expose
    private Double TOT_BAYAR;
    @SerializedName("ANGSURAN_POKOK")
    @Expose
    private Double ANGSURAN_POKOK;
    @SerializedName("ANGSURAN_BUNGA")
    @Expose
    private Double ANGSURAN_BUNGA;
    @SerializedName("TOT_ANGSURAN")
    @Expose
    private Double TOT_ANGSURAN;
    @SerializedName("TOTAL_OS")
    @Expose
    private Double TOTAL_OS;
    @SerializedName("POKOK_OS")
    @Expose
    private Double POKOK_OS;
    @SerializedName("BUNGA_OS")
    @Expose
    private Double BUNGA_OS;
    @SerializedName("KETERANGAN")
    @Expose
    private String KETERANGAN;

    public int getAngsuranKe(){
        return ANGSURAN_KE;
    }

    public void setANGSURAN_KE(int ANGSURAN_KE){
        this.ANGSURAN_KE=ANGSURAN_KE;
    }

    public Double getPOKOK_DIBAYAR(){
        return POKOK_DIBAYAR;
    }

    public void setPOKOK_DIBAYAR(Double POKOK_DIBAYAR)
    {
        this.POKOK_DIBAYAR=POKOK_DIBAYAR;
    }

    public Double getBUNGA_DIBAYAR(){
        return BUNGA_DIBAYAR;
    }

    public void setBUNGA_DIBAYAR(Double BUNGA_DIBAYAR){
        this.BUNGA_DIBAYAR=BUNGA_DIBAYAR;
    }

    public Double getTOT_BAYAR()
    {
        return TOT_BAYAR;
    }

    public void setTOT_BAYAR(Double TOT_BAYAR){
        this.TOT_BAYAR=TOT_BAYAR;
    }

    public Double getANGSURAN_POKOK(){
        return ANGSURAN_POKOK;
    }

    public void setANGSURAN_POKOK(Double ANGSURAN_POKOK){
        this.ANGSURAN_POKOK=ANGSURAN_POKOK;
    }

    public Double getANGSURAN_BUNGA()
    {
        return ANGSURAN_BUNGA;
    }

    public void setANGSURAN_BUNGA(Double ANGSURAN_BUNGA){
        this.ANGSURAN_BUNGA=ANGSURAN_BUNGA;
    }

    public Double getTOT_ANGSURAN()
    {
        return TOT_ANGSURAN;
    }

    public void setTOT_ANGSURAN(Double TOT_ANGSURAN){
        this.TOT_ANGSURAN=TOT_ANGSURAN;
    }

    public Double getTOTAL_OS()
    {
        return TOTAL_OS;
    }

    public void setTOTAL_OS(Double TOTAL_OS){
        this.TOTAL_OS=TOTAL_OS;
    }

    public Double getPOKOK_OS()
    {
        return POKOK_OS;
    }

    public void setPOKOK_OS(Double POKOK_OS){
        this.POKOK_OS=POKOK_OS;
    }

    public Double getBUNGA_OS(){
        return BUNGA_OS;
    }

    public void setBUNGA_OS(Double BUNGA_OS){
        this.BUNGA_OS=BUNGA_OS;
    }

    public String getKETERANGAN(){
        return KETERANGAN;
    }

    public void setKETERANGAN(String KETERANGAN){
        this.KETERANGAN=KETERANGAN;
    }

    public TGL_TRANS getTglTrans()
    {
        return tgl_trans;
    }

    public void setTglTrans(TGL_TRANS tgl_trans)
    {
        this.tgl_trans=tgl_trans;
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
