package teknologi.azha.portaldebitur.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 11/2/2017.
 */

public class MenuModel implements Parcelable {

    private int id;
    private int type;
    private String label;
    private Drawable icon;
    private int status;
    private Drawable background;
    private int paddingTop;
    private int paddingBottom;


    public MenuModel(int id, int type, String label) {
        this.id = id;
        this.type = type;
        this.label = label;
    }

    public MenuModel(int id, int type, String label, Drawable icon) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.icon = icon;
    }

    protected MenuModel(Parcel in) {
        id = in.readInt();
        type = in.readInt();
        label = in.readString();
        status = in.readInt();
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public Drawable getBackground() {
        return background;
    }

    public void setBackground(Drawable background) {
        this.background = background;
    }

    public static final Creator<MenuModel> CREATOR = new Creator<MenuModel>() {
        @Override
        public MenuModel createFromParcel(Parcel in) {
            return new MenuModel(in);
        }

        @Override
        public MenuModel[] newArray(int size) {
            return new MenuModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(type);
        dest.writeString(label);
        dest.writeInt(status);
    }
}
