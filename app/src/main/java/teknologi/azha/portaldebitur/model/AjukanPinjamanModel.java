package teknologi.azha.portaldebitur.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 10/3/2017.
 */

public class AjukanPinjamanModel implements Parcelable{
    /*
            "nama_panggilan": "Test Nama Panggilan 1",
            "nama_lenglap": "Nama Lengkap",
            "jenis_identitas": "KTP",
            "nomor_identitas": "01234567890",
            "masa_berlaku": "2018-08-01",
            "tempat_lahir": "Jakarta",
    		"is_seumur_hidup": 1,
            "tanggal_lahir": "1990-01-01",
            "jenis_kelamin": "P",
            "alamat": "Test Alamat 1",
            "nomor_hp": "081280000088",
            "nama_ibu": "Test Nama Ibu Kandung 1",
            "plafon": "200000000",
            "tenor": "12",
            "angsuran": "1500000",
            "tujuan": "Test Tujuan Pembiayaan 1"
     */

            @SerializedName("nama_panggilan")
            @Expose
            private String namaPanggilan;
            @SerializedName("nama_lengkap")
            @Expose
            private String namaLengkap;
            @SerializedName("jenis_identitas")
            @Expose
            private String jenisIdentitas;
            @SerializedName("tempat_lahir")
            @Expose
            private String tempatLahir;
            @SerializedName("tanggal_lahir")
            @Expose
            private String tanggalLahir;
            @SerializedName("jenis_kelamin")
            @Expose
            private String jenisKelamin;
            @SerializedName("nomor_identitas")
            @Expose
            private String noIdentitas;
            @SerializedName("masa_berlaku")
            @Expose
            private String masaBerlaku;
            @SerializedName("is_seumur_hidup")
            @Expose
            private int isSeumurHidup;
            @SerializedName("nama_ibu")
            @Expose
            private String namaIbuKandung;
            @SerializedName("alamat")
            @Expose
            private String alamat;
            @SerializedName("nomor_hp")
            @Expose
            private String noHp;
            @SerializedName("plafon")
            @Expose
            private String plafon;
            @SerializedName("tenor")
            @Expose
            private String tenor;
            @SerializedName("angsuran")
            @Expose
            private String angsuran;
            @SerializedName("tujuan")
            @Expose
            private String tujuan;

            public String getNamaPanggilan() {
                return namaPanggilan;
            }

            public void setNamaPanggilan(String namaPanggilan) {
                this.namaPanggilan = namaPanggilan;
            }

            public String getNamaLengkap() {
                return namaLengkap;
            }

            public void setNamaLengkap(String namaLengkap) {
                this.namaLengkap = namaLengkap;
            }

            public String getTempatLahir() {
                return tempatLahir;
            }

            public void setTempatLahir(String tempatLahir) {
                this.tempatLahir = tempatLahir;
            }

            public String getTanggalLahir() {
                return tanggalLahir;
            }

            public void setTanggalLahir(String tanggalLahir) {
                this.tanggalLahir = tanggalLahir;
            }

            public String getJenisKelamin() {
                return jenisKelamin;
            }

            public void setJenisKelamin(String jenisKelamin) {
                this.jenisKelamin = jenisKelamin;
            }

            public String getJenisIdentitas() {
                return jenisIdentitas;
            }

            public void setJenisIdentitas(String jenisIdentitas) {
                this.jenisIdentitas = jenisIdentitas;
            }

            public String getNoIdentitas() {
                return noIdentitas;
            }

            public void setNoIdentitas(String noIdentitas) {
                this.noIdentitas = noIdentitas;
            }

            public String getMasaBerlaku() {
                return masaBerlaku;
            }

            public void setMasaBerlaku(String masaBerlaku) {
                this.masaBerlaku = masaBerlaku;
            }

            public int getIsSeumurHidup() {
                return isSeumurHidup;
            }

            public void setIsSeumurHidup(int isSeumurHidup) {
                this.isSeumurHidup = isSeumurHidup;
            }

            public String getNamaIbuKandung() {
                return namaIbuKandung;
            }

            public void setNamaIbuKandung(String namaIbuKandung) {
                this.namaIbuKandung = namaIbuKandung;
            }

            public String getAlamat() {
                return alamat;
            }

            public void setAlamat(String alamat) {
                this.alamat = alamat;
            }

            public String getNoHp() {
                return noHp;
            }

            public void setNoHp(String noHp) {
                this.noHp = noHp;
            }

            public String getPlafon() {
                return plafon;
            }

            public void setPlafon(String plafon) {
                this.plafon = plafon;
            }

            public String getTenor() {
                return tenor;
            }

            public void setTenor(String tenor) {
                this.tenor = tenor;
            }

            public String getAngsuran() {
                return angsuran;
            }

            public void setAngsuran(String angsuran) {
                this.angsuran = angsuran;
            }

            public String getTujuan() {
                return tujuan;
            }

            public void setTujuan(String tujuan) {
                this.tujuan = tujuan;
            }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaPanggilan);
        dest.writeString(namaLengkap);
        dest.writeString(tempatLahir);
        dest.writeString(tanggalLahir);
        dest.writeString(jenisKelamin);
        dest.writeString(jenisIdentitas);
        dest.writeString(noIdentitas);
        dest.writeString(masaBerlaku);
        dest.writeInt(isSeumurHidup);
        dest.writeString(namaIbuKandung);
        dest.writeString(alamat);
        dest.writeString(noHp);
        dest.writeString(plafon);
        dest.writeString(tenor);
        dest.writeString(angsuran);
        dest.writeString(tujuan);

    }

    public static final Creator<AjukanPinjamanModel> CREATOR = new Creator<AjukanPinjamanModel>() {
        @Override
        public AjukanPinjamanModel createFromParcel(Parcel in) {
            return new AjukanPinjamanModel(in);
        }

        @Override
        public AjukanPinjamanModel[] newArray(int size) {
            return new AjukanPinjamanModel[size];
        }
    };

    public AjukanPinjamanModel() {}

    protected AjukanPinjamanModel(Parcel in) {
        namaPanggilan = in.readString();
        namaLengkap = in.readString();
        tempatLahir = in.readString();
        tanggalLahir = in.readString();
        jenisKelamin = in.readString();
        jenisIdentitas = in.readString();
        noIdentitas = in.readString();
        masaBerlaku = in.readString();
        isSeumurHidup = in.readInt();
        namaIbuKandung = in.readString();
        alamat = in.readString();
        noHp = in.readString();
        plafon = in.readString();
        tenor = in.readString();
        angsuran = in.readString();
        tujuan = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
