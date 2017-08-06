
package com.click_labs.click_labsworkflow.model.timesheetresponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimesheetResponseData implements Parcelable
{

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    public final static Parcelable.Creator<TimesheetResponseData> CREATOR = new Creator<TimesheetResponseData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TimesheetResponseData createFromParcel(Parcel in) {
            TimesheetResponseData instance = new TimesheetResponseData();
            instance.statusCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.data, (com.click_labs.click_labsworkflow.model.timesheetresponse.Datum.class.getClassLoader()));
            return instance;
        }

        public TimesheetResponseData[] newArray(int size) {
            return (new TimesheetResponseData[size]);
        }

    }
    ;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(statusCode);
        dest.writeValue(message);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}
