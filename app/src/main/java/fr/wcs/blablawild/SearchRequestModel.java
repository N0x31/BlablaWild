package fr.wcs.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class SearchRequestModel implements Parcelable {

    //Attributs

    private String villeDepart;
    private String villeDest;
    private Date dateTrajet;

    //Constructeur

    public SearchRequestModel(String villeDepart, String villeDest, Date dateTrajet) {
        this.villeDepart = villeDepart;
        this.villeDest = villeDest;
        this.dateTrajet = dateTrajet;
    }

    //Getter

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleDest() {
        return villeDest;
    }

    public Date getDateTrajet() {
        return dateTrajet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(villeDepart);
        dest.writeString(villeDest);
        dest.writeLong(dateTrajet.getTime());
    }

    public static final Creator<SearchRequestModel> CREATOR = new Creator<SearchRequestModel>() {
        @Override
        public SearchRequestModel createFromParcel(Parcel in) {
            return new SearchRequestModel(in);
        }

        @Override
        public SearchRequestModel[] newArray(int size) {
            return new SearchRequestModel[size];
        }
    };

    public SearchRequestModel (Parcel in) {
        this.villeDepart = in.readString();
        this.villeDest = in.readString();
        this.dateTrajet = new Date(in.readLong());
    }

}
