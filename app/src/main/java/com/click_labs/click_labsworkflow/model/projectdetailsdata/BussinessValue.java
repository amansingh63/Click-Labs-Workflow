
package com.click_labs.click_labsworkflow.model.projectdetailsdata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BussinessValue implements Parcelable
{

    @SerializedName("currencyId")
    @Expose
    private String currencyId;
    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("_id")
    @Expose
    private String id;
    public final static Parcelable.Creator<BussinessValue> CREATOR = new Creator<BussinessValue>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BussinessValue createFromParcel(Parcel in) {
            BussinessValue instance = new BussinessValue();
            instance.currencyId = ((String) in.readValue((String.class.getClassLoader())));
            instance.value = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public BussinessValue[] newArray(int size) {
            return (new BussinessValue[size]);
        }

    }
    ;

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(currencyId);
        dest.writeValue(value);
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}
