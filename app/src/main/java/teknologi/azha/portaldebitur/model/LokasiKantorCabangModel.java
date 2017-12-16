package teknologi.azha.portaldebitur.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pooni on 9/21/2017.
 */

public class LokasiKantorCabangModel implements Parcelable{
    /*
        "MS_CABANG_ID": 1,
        "MS_WILAYAH_ID": 1,
        "MS_CABANG_KODE": "BGR",
        "MS_CABANG_DESKRIPSI": "BOGOR",
        "MS_CABANG_KODE_GP": "00164",
        "MS_CABANG_ALAMAT": "Jl. Dadali No. 35 Rt. 05 Rw. 05 Kel. Tanah Sareal - Kota Bogor 16161",
        "MS_CABANG_TELEPON": "0251-8384663",
        "ACTIVE": 1,
        "LOGID": "",
        "CREATED_DATE": "2017-07-14 14:54:26.237",
        "CREATED_BY_ID": "HSJ",
        "CREATED_BY_NAME": "HASAN JUHRI",
        "MODIFIED_DATE": null,
        "MODIFIED_BY_ID": null,
        "MODIFIED_BY_NAME": null
    */

    @SerializedName("MS_CABANG_ID")
    @Expose
    private int MS_CABANG_ID;
    @SerializedName("MS_WILAYAH_ID")
    @Expose
    private int MS_WILAYAH_ID;
    @SerializedName("MS_CABANG_KODE")
    @Expose
    private String MS_CABANG_KODE;
    @SerializedName("MS_CABANG_DESKRIPSI")
    @Expose
    private String MS_CABANG_DESKRIPSI;
    @SerializedName("MS_CABANG_KODE_GP")
    @Expose
    private int MS_CABANG_KODE_GP;
    @SerializedName("MS_CABANG_ALAMAT")
    @Expose
    private String MS_CABANG_ALAMAT;
    @SerializedName("MS_CABANG_TELEPON")
    @Expose
    private String MS_CABANG_TELEPON;
    @SerializedName("ACTIVE")
    @Expose
    private int ACTIVE;
    @SerializedName("LOGID")
    @Expose
    private String LOGID;
    @SerializedName("CREATED_DATE")
    @Expose
    private String CREATED_DATE;
    @SerializedName("CREATED_BY_ID")
    @Expose
    private String CREATED_BY_ID;
    @SerializedName("CREATED_BY_NAME")
    @Expose
    private String CREATED_BY_NAME;
    @SerializedName("MODIFIED_DATE")
    @Expose
    private String MODIFIED_DATE;
    @SerializedName("MODIFIED_BY_ID")
    @Expose
    private String MODIFIED_BY_ID;
    @SerializedName("MODIFIED_BY_NAME")
    @Expose
    private String MODIFIED_BY_NAME;

    @Override
    public int describeContents() {
        return 0;
    }

    public LokasiKantorCabangModel() {

    }

    protected LokasiKantorCabangModel(Parcel in) {
        MS_CABANG_ID = in.readInt();
        MS_WILAYAH_ID= in.readInt();
        MS_CABANG_KODE= in.readString();
        MS_CABANG_DESKRIPSI= in.readString();
        MS_CABANG_KODE_GP= in.readInt();
        MS_CABANG_ALAMAT= in.readString();
        MS_CABANG_TELEPON= in.readString();
        ACTIVE=in.readInt();
        LOGID=in.readString();
        CREATED_DATE=in.readString();
        CREATED_BY_ID=in.readString();
        CREATED_BY_NAME=in.readString();
        MODIFIED_DATE=in.readString();
        MODIFIED_BY_ID=in.readString();
        MODIFIED_BY_NAME=in.readString();
    }

    public static final Creator<LokasiKantorCabangModel> CREATOR = new Creator<LokasiKantorCabangModel>() {
        @Override
        public LokasiKantorCabangModel createFromParcel(Parcel in) {
            return new LokasiKantorCabangModel(in);
        }

        @Override
        public LokasiKantorCabangModel[] newArray(int size) {
            return new LokasiKantorCabangModel[size];
        }
    };

    public int getMsCabangId()
    {
        return MS_CABANG_ID;
    }

    public void setNasabahId(int MS_CABANG_ID)
    {
        this.MS_CABANG_ID=MS_CABANG_ID;
    }

    public int getMsWilayahId()
    {
        return MS_WILAYAH_ID;
    }

    public void setMsWilayahId(int MS_WILAYAH_ID)
    {
        this.MS_WILAYAH_ID=MS_WILAYAH_ID;
    }

    public String getMsCabangKode()
    {
        return MS_CABANG_KODE;
    }

    public void setMsCabangKode(String MS_CABANG_KODE)
    {
        this.MS_CABANG_KODE=MS_CABANG_KODE;
    }

    public String getMsCabangDeskripsi()
    {
        return MS_CABANG_DESKRIPSI;
    }

    public void setMsCabangDeskripsi(String MS_CABANG_DESKRIPSI)
    {
        this.MS_CABANG_DESKRIPSI=MS_CABANG_DESKRIPSI;
    }

    public int getMsCabangKodeGp()
    {
        return MS_CABANG_KODE_GP;
    }

    public void setMsCabangKodeGp(int MS_CABANG_KODE_GP)
    {
        this.MS_CABANG_KODE_GP=MS_CABANG_KODE_GP;
    }

    public String getMsCabangAlamat()
    {
        return MS_CABANG_ALAMAT;
    }

    public void setMsCabangAlamat(String MS_CABANG_ALAMAT)
    {
        this.MS_CABANG_ALAMAT=MS_CABANG_ALAMAT;
    }

    public String getMsCabangTelepon()
    {
        return MS_CABANG_TELEPON;
    }

    public void setMsCabangTelepon(String MS_CABANG_TELEPON)
    {
        this.MS_CABANG_TELEPON=MS_CABANG_TELEPON;
    }

    public int getActive()
    {
        return ACTIVE;
    }

    public void setActive(int ACTIVE)
    {
        this.ACTIVE=ACTIVE;
    }

    public String getLogId()
    {
        return LOGID;
    }

    public void setLogId(String LOGID)
    {
        this.LOGID=LOGID;
    }

    public String getCreatedDate()
    {
        return CREATED_DATE;
    }

    public void setCreatedDate(String CREATED_DATE)
    {
        this.CREATED_DATE=CREATED_DATE;
    }

    public String getCreatedById()
    {
        return CREATED_BY_ID;
    }

    public void setCreatedById(String CREATED_BY_ID)
    {
        this.CREATED_BY_ID=CREATED_BY_ID;
    }

    public String getCreatedByName()
    {
        return CREATED_BY_NAME;
    }

    public void setCreatedByName(String CREATED_BY_NAME)
    {
        this.CREATED_BY_NAME=CREATED_BY_NAME;
    }

    public String getModifiedDate()
    {
        return MODIFIED_DATE;
    }

    public void setModifiedDate(String MODIFIED_DATE)
    {
        this.MODIFIED_DATE=MODIFIED_DATE;
    }

    public String getModifiedById()
    {
        return MODIFIED_BY_ID;
    }

    public void setModifiedById(String MODIFIED_BY_ID)
    {
        this.MODIFIED_BY_ID=MODIFIED_BY_ID;
    }

    public String getModifiedByName()
    {
        return MODIFIED_BY_NAME;
    }

    public void setModifiedByName(String MODIFIED_BY_NAME)
    {
        this.MODIFIED_BY_NAME=MODIFIED_BY_NAME;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(MS_CABANG_ID);
        dest.writeInt(MS_WILAYAH_ID);
        dest.writeString(MS_CABANG_KODE);
        dest.writeString(MS_CABANG_DESKRIPSI);
        dest.writeInt(MS_CABANG_KODE_GP);
        dest.writeString(MS_CABANG_ALAMAT);
        dest.writeString(MS_CABANG_TELEPON);
        dest.writeInt(ACTIVE);
        dest.writeString(LOGID);
        dest.writeString(CREATED_DATE);
        dest.writeString(CREATED_BY_ID);
        dest.writeString(CREATED_DATE);
        dest.writeString(CREATED_BY_NAME);
        dest.writeString(MODIFIED_DATE);
        dest.writeString(MODIFIED_BY_ID);
        dest.writeString(MODIFIED_BY_NAME);
    }


}
