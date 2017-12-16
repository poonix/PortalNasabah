package teknologi.azha.portaldebitur.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 9/23/2017.
 */

public class UserDebiturModel implements Parcelable{
    /*
        "NASABAH_ID": "LB.000348",
        "NAMA_NASABAH": "UNDANG MOCH YUSUF",
        "ALAMAT": "KP. SALAMANJAH RT.004/RW. 004",
        "no_hp": "082116346657",
        "KODE_UNIT": "LB",
        "NAMA_UNIT": "Unit Ciwidey",
        "KODE_CABANG": "CMH",
        "NAMA_CABANG": "CIMAHI"
     */
    @SerializedName("NASABAH_ID")
    @Expose
    private String NasabahID;
    @SerializedName("NAMA_NASABAH")
    @Expose
    private String NamaNasabah;
    @SerializedName("ALAMAT")
    @Expose
    private String AlamatNasabah;
    @SerializedName("no_hp")
    @Expose
    private String NoHpNasabah;
    @SerializedName("KODE_UNIT")
    @Expose
    private String KodeUnitNasabah;
    @SerializedName("NAMA_UNIT")
    @Expose
    private String NamaUnitNasabah;
    @SerializedName("KODE_CABANG")
    @Expose
    private String KodeCabangNasabah;
    @SerializedName("NAMA_CABANG")
    @Expose
    private String NamaCabangNasabah;


    protected UserDebiturModel(Parcel in) {
        NasabahID = in.readString();
        NamaNasabah = in.readString();
        AlamatNasabah = in.readString();
        NoHpNasabah = in.readString();
        KodeUnitNasabah = in.readString();
        NamaUnitNasabah = in.readString();
        KodeCabangNasabah = in.readString();
        NamaCabangNasabah = in.readString();
    }

    public static final Creator<UserDebiturModel> CREATOR = new Creator<UserDebiturModel>() {
        @Override
        public UserDebiturModel createFromParcel(Parcel in) {
            return new UserDebiturModel(in);
        }

        @Override
        public UserDebiturModel[] newArray(int size) {
            return new UserDebiturModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public String toString() {
        return "UserDebiturModel{" +
                "NasabahID='" + NasabahID + '\'' +
                ", NamaNasabah='" + NamaNasabah + '\'' +
                ", AlamatNasabah='" + AlamatNasabah + '\'' +
                ", NoHpNasabah='" + NoHpNasabah + '\'' +
                ", KodeUnitNasabah='" + KodeUnitNasabah + '\'' +
                ", NamaUnitNasabah='" + NamaUnitNasabah + '\'' +
                ", KodeCabangNasabah='" + KodeCabangNasabah + '\'' +
                ", NamaCabangNasabah='" + NamaCabangNasabah + '\'' +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(NasabahID);
        dest.writeString(NamaNasabah);
        dest.writeString(AlamatNasabah);
        dest.writeString(NoHpNasabah);
        dest.writeString(KodeUnitNasabah);
        dest.writeString(NamaUnitNasabah);
        dest.writeString(KodeCabangNasabah);
        dest.writeString(NamaCabangNasabah);
    }

    public String getNasabahId() {
        return NasabahID;
    }

    public void setNasabahId(String NasabahID) {
        this.NasabahID = NasabahID;
    }

    public String getNamaNasabah() {
        return NamaNasabah;
    }

    public void setNamaNasabah(String NamaNasabah) {
        this.NamaNasabah = NamaNasabah;
    }

    public String getAlamatNasabah() {
        return AlamatNasabah;
    }

    public void setAlamatNasabah(String AlamatNasabah) {
        this.AlamatNasabah = AlamatNasabah;
    }

    public String getNoHpNasabah() {
        return NoHpNasabah;
    }

    public void setNoHpNasabah(String NoHpNasabah) {
        this.NoHpNasabah = NoHpNasabah;
    }

    public String getKodeUnitNasabah() {
        return KodeUnitNasabah;
    }

    public void setKodeUnitNasabah(String KodeUnitNasabah) {
        this.KodeUnitNasabah = KodeUnitNasabah;
    }

    public String getNamaUnitNasabah() {
        return NamaUnitNasabah;
    }

    public void setNamaUnitNasabah(String NamaUnitNasabah) {
        this.NamaUnitNasabah = NamaUnitNasabah;
    }

    public String getKodeCabangNasabah() {
        return KodeCabangNasabah;
    }

    public void setKodeCabangNasabah(String KodeCabangNasabah) {
        this.KodeCabangNasabah = KodeCabangNasabah;
    }

    public String getNamaCabangNasabah() {
        return NamaCabangNasabah;
    }

    public void setNamaCabangNasabah(String NamaCabangNasabah) {
        this.NamaCabangNasabah = NamaCabangNasabah;
    }


}
