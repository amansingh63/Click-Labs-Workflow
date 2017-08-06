
package com.click_labs.click_labsworkflow.model.addtimesheet;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddTimeSheetDatum implements Parcelable
{

    @SerializedName("salesOrderTitle")
    @Expose
    private String salesOrderTitle;
    @SerializedName("projectId")
    @Expose
    private String projectId;
    @SerializedName("noOfHours")
    @Expose
    private Integer noOfHours;
    @SerializedName("minutes")
    @Expose
    private Integer minutes;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("salesOrderId")
    @Expose
    private String salesOrderId;
    public final static Parcelable.Creator<AddTimeSheetDatum> CREATOR = new Creator<AddTimeSheetDatum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AddTimeSheetDatum createFromParcel(Parcel in) {
            AddTimeSheetDatum instance = new AddTimeSheetDatum();
            instance.salesOrderTitle = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectId = ((String) in.readValue((String.class.getClassLoader())));
            instance.noOfHours = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.minutes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.comments = ((String) in.readValue((String.class.getClassLoader())));
            instance.salesOrderId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public AddTimeSheetDatum[] newArray(int size) {
            return (new AddTimeSheetDatum[size]);
        }

    }
    ;

    public String getSalesOrderTitle() {
        return salesOrderTitle;
    }

    public void setSalesOrderTitle(String salesOrderTitle) {
        this.salesOrderTitle = salesOrderTitle;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Integer noOfHours) {
        this.noOfHours = noOfHours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(salesOrderTitle);
        dest.writeValue(projectId);
        dest.writeValue(noOfHours);
        dest.writeValue(minutes);
        dest.writeValue(comments);
        dest.writeValue(salesOrderId);
    }

    public int describeContents() {
        return  0;
    }

}
