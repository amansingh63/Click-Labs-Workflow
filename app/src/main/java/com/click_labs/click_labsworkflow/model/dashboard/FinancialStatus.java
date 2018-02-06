
package com.click_labs.click_labsworkflow.model.dashboard;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinancialStatus implements Parcelable
{

    @SerializedName("achievable")
    @Expose
    private int achievable;
    @SerializedName("projected")
    @Expose
    private int projected;
    @SerializedName("risk")
    @Expose
    private int risk;
    public final static Creator<FinancialStatus> CREATOR = new Creator<FinancialStatus>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FinancialStatus createFromParcel(Parcel in) {
            return new FinancialStatus(in);
        }

        public FinancialStatus[] newArray(int size) {
            return (new FinancialStatus[size]);
        }

    }
    ;

    protected FinancialStatus(Parcel in) {
        this.achievable = ((int) in.readValue((int.class.getClassLoader())));
        this.projected = ((int) in.readValue((int.class.getClassLoader())));
        this.risk = ((int) in.readValue((int.class.getClassLoader())));
    }

    public FinancialStatus() {
    }

    public int getAchievable() {
        return achievable;
    }

    public void setAchievable(int achievable) {
        this.achievable = achievable;
    }

    public int getProjected() {
        return projected;
    }

    public void setProjected(int projected) {
        this.projected = projected;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(achievable);
        dest.writeValue(projected);
        dest.writeValue(risk);
    }

    public int describeContents() {
        return  0;
    }

}
