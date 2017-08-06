
package com.click_labs.click_labsworkflow.model.projectdetailsdata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectDetailsResponse implements Parcelable
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
    public final static Parcelable.Creator<ProjectDetailsResponse> CREATOR = new Creator<ProjectDetailsResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProjectDetailsResponse createFromParcel(Parcel in) {
            ProjectDetailsResponse instance = new ProjectDetailsResponse();
            instance.statusCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.data, (com.click_labs.click_labsworkflow.model.projectdetailsdata.Datum.class.getClassLoader()));
            return instance;
        }

        public ProjectDetailsResponse[] newArray(int size) {
            return (new ProjectDetailsResponse[size]);
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
