
package com.click_labs.click_labsworkflow.model.dashboard;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardResponse implements Parcelable
{

    @SerializedName("statusCode")
    @Expose
    private int statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    public final static Creator<DashboardResponse> CREATOR = new Creator<DashboardResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DashboardResponse createFromParcel(Parcel in) {
            return new DashboardResponse(in);
        }

        public DashboardResponse[] newArray(int size) {
            return (new DashboardResponse[size]);
        }

    }
    ;

    protected DashboardResponse(Parcel in) {
        this.statusCode = ((int) in.readValue((int.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (Datum.class.getClassLoader()));
    }

    public DashboardResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
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
