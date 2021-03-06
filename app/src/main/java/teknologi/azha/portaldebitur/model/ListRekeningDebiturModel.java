package teknologi.azha.portaldebitur.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 11/7/2017.
 */

public class ListRekeningDebiturModel implements Parcelable{
    @SerializedName("NASABAH_ID")
    @Expose
    private String NASABAH_ID;
    @SerializedName("NO_REKENING")
    @Expose
    private String NO_REKENING;
    @SerializedName("NO_ALTERNATIF")
    @Expose
    private String NO_ALTERNATIF;
    @SerializedName("JML_PINJAMAN")
    @Expose
    private String JML_PINJAMAN;
    @SerializedName("JML_ANGSURAN")
    @Expose
    private int JML_ANGSURAN;
    @SerializedName("OUTSTANDING")
    @Expose
    private String OUTSTANDING;
    @SerializedName("POSISI_CICILAN_KE")
    @Expose
    private String POSISI_CICILAN_KE;
    @SerializedName("angsuran_total")
    @Expose
    private Double angsuran_total;
    @SerializedName("TGL_REALISASI")
    @Expose
    private TGL_REALISASI tgl_realisasi;
    @SerializedName("TGL_JATUH_TEMPO")
    @Expose
    private TGL_JATUH_TEMPO tgl_jatuh_tempo;
    @SerializedName("TGL_LUNAS")
    @Expose
    private TGL_LUNAS tgl_lunas;
    @SerializedName("KOLEKTIBILITAS")
    @Expose
    private String KOLEKTIBILITAS;
    @SerializedName("FLAG_TOLERANSI")
    @Expose
    private String FLAG_TOLERANSI;
    @SerializedName("TIPE_KREDIT")
    @Expose
    private int TIPE_KREDIT;
    @SerializedName("STATUS_AKTIF")
    @Expose
    private int STATUS_AKTIF;
    public String getNasabahId()
    {
        return NASABAH_ID;
    }
    public void setNasabahId(String NASABAH_ID)
    {
        this.NASABAH_ID=NASABAH_ID;
    }

    public String getNoRekening()
    {
        return NO_REKENING;
    }
    public void setNoRekening(String NO_REKENING)
    {
        this.NO_REKENING=NO_REKENING;
    }

    public String getNoAlternatif()
    {
        return NO_ALTERNATIF;
    }
    public void setNoAlternatif(String NO_ALTERNATIF)
    {
        this.NO_ALTERNATIF=NO_ALTERNATIF;
    }

    public int getJmlAngsuran()
    {
        return JML_ANGSURAN;
    }
    public void setJmlAngsuran(int JML_ANGSURAN)
    {
        this.JML_ANGSURAN=JML_ANGSURAN;
    }

    public String getPosisiCicilan()
    {
        return POSISI_CICILAN_KE;
    }
    public void setPosisiCicilan(String posisicicilan)
    {
        this.POSISI_CICILAN_KE=posisicicilan;
    }

    public String getJmlPinjaman()
    {
        return JML_PINJAMAN;
    }
    public void setJmlPinjaman(String JML_PINJAMAN)
    {
        this.JML_PINJAMAN=JML_PINJAMAN;
    }

    public Double getAngsuranTotal()
    {
        return angsuran_total;
    }
    public void setAngsuranTotal(Double angsuran_total)
    {
        this.angsuran_total=angsuran_total;
    }

    public String getOutstanding()
    {
        return OUTSTANDING;
    }
    public void setOutstanding(String outstanding)
    {
        this.OUTSTANDING=outstanding;
    }

    private TGL_REALISASI getTglRealisasi()
    {
        return tgl_realisasi;
    }
    public void setTglRealisasi(TGL_REALISASI tgl_realisasi)
    {
        this.tgl_realisasi=tgl_realisasi;
    }

    private TGL_JATUH_TEMPO getTglJthTempo()
    {
        return tgl_jatuh_tempo;
    }
    private void setTglJthTempo(TGL_JATUH_TEMPO tgl_jatuh_tempo)
    {
        this.tgl_jatuh_tempo=tgl_jatuh_tempo;
    }

    private TGL_LUNAS getTglLunas()
    {
        return tgl_lunas;
    }
    public void setTglLunas(TGL_LUNAS tgl_lunas)
    {
        this.tgl_lunas=tgl_lunas;
    }

    public String getKolektibilitas()
    {
        return KOLEKTIBILITAS;
    }
    public void setKolektibilitas(String KOLEKTIBILITAS)
    {
        this.KOLEKTIBILITAS=KOLEKTIBILITAS;
    }

    public String getFlagToleransi()
    {
        return FLAG_TOLERANSI;
    }
    public void setFlagToleransi(String FLAG_TOLERANSI)
    {
        this.FLAG_TOLERANSI=FLAG_TOLERANSI;
    }

    public int getTipeKredit()
    {
        return TIPE_KREDIT;
    }
    public void setTipeKredit(int TIPE_KREDIT)
    {
        this.TIPE_KREDIT=TIPE_KREDIT;
    }

    public int getStatusAktif()
    {
        return STATUS_AKTIF;
    }
    public void setStatusAktif(int STATUS_AKTIF)
    {
        this.STATUS_AKTIF=STATUS_AKTIF;
    }

    public class TGL_REALISASI
    {
        @SerializedName("date")
        @Expose
        private String dateRealisasi;

        private String getDateRealisasi()
        {
            return dateRealisasi;
        }

        public void setDateRealisasi(String dateRealisasi)
        {
            this.dateRealisasi=dateRealisasi;
        }
    }

    public class TGL_LUNAS
    {
        @SerializedName("date")
        @Expose
        private String dateLunas;

        private String getLunas()
        {
            return dateLunas;
        }

        public void setLunas(String dateLunas)
        {
            this.dateLunas=dateLunas;
        }
    }

    public class TGL_JATUH_TEMPO
    {
        @SerializedName("date")
        @Expose
        private String dateJatuhTempo;

        private String getJatuhTempo()
        {
            return dateJatuhTempo;
        }

        public void setJatuhTempo(String dateJatuhTempo)
        {
            this.dateJatuhTempo=dateJatuhTempo;
        }
    }

    public String getInnterTglLunas()
    {
        try {
            return getTglLunas().getLunas();
        } catch (Exception e) {
            return null;
        }
    }

    public String getInnterTglRealisasi()
    {
        try {
            return getTglRealisasi().getDateRealisasi();
        } catch (Exception e) {
            return null;
        }
    }

    public String getInnterTglJatuhTempo()
    {
        try {
            return getTglJthTempo().getJatuhTempo();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public ListRekeningDebiturModel() {

    }

    protected ListRekeningDebiturModel(Parcel in) {
        NASABAH_ID = in.readString();
        NO_REKENING= in.readString();
        NO_ALTERNATIF= in.readString();
        JML_PINJAMAN= in.readString();
        OUTSTANDING= in.readString();
        POSISI_CICILAN_KE= in.readString();
        JML_ANGSURAN= in.readInt();
        angsuran_total= in.readDouble();
        KOLEKTIBILITAS= in.readString();
    }

    public static final Parcelable.Creator<ListRekeningDebiturModel> CREATOR = new Parcelable.Creator<ListRekeningDebiturModel>() {
        @Override
        public ListRekeningDebiturModel createFromParcel(Parcel in) {
            return new ListRekeningDebiturModel(in);
        }

        @Override
        public ListRekeningDebiturModel[] newArray(int size) {
            return new ListRekeningDebiturModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(NASABAH_ID);
        dest.writeString(NO_REKENING);
        dest.writeString(NO_ALTERNATIF);
        dest.writeString(JML_PINJAMAN);
        dest.writeString(OUTSTANDING);
        dest.writeString(POSISI_CICILAN_KE);
        dest.writeInt(JML_ANGSURAN);
        dest.writeDouble(angsuran_total);
        dest.writeString(KOLEKTIBILITAS);
    }
}
