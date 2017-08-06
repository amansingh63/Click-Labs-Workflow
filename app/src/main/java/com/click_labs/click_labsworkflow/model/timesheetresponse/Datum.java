
package com.click_labs.click_labsworkflow.model.timesheetresponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("salesOrderTitle")
    @Expose
    private String salesOrderTitle;
    @SerializedName("projectId")
    @Expose
    private String projectId;
    @SerializedName("projectName")
    @Expose
    private String projectName;
    @SerializedName("employeeId")
    @Expose
    private String employeeId;
    @SerializedName("employeeName")
    @Expose
    private String employeeName;
    @SerializedName("noOfHours")
    @Expose
    private Integer noOfHours;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("salesOrderId")
    @Expose
    private String salesOrderId;
    @SerializedName("minutes")
    @Expose
    private Integer minutes;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("__v")
    @Expose
    private Integer v;
    public final static Parcelable.Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            Datum instance = new Datum();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.salesOrderTitle = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectId = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectName = ((String) in.readValue((String.class.getClassLoader())));
            instance.employeeId = ((String) in.readValue((String.class.getClassLoader())));
            instance.employeeName = ((String) in.readValue((String.class.getClassLoader())));
            instance.noOfHours = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.date = ((String) in.readValue((String.class.getClassLoader())));
            instance.salesOrderId = ((String) in.readValue((String.class.getClassLoader())));
            instance.minutes = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.isDeleted = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.comments = ((String) in.readValue((String.class.getClassLoader())));
            instance.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Integer noOfHours) {
        this.noOfHours = noOfHours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(String salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(salesOrderTitle);
        dest.writeValue(projectId);
        dest.writeValue(projectName);
        dest.writeValue(employeeId);
        dest.writeValue(employeeName);
        dest.writeValue(noOfHours);
        dest.writeValue(date);
        dest.writeValue(salesOrderId);
        dest.writeValue(minutes);
        dest.writeValue(isDeleted);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(comments);
        dest.writeValue(v);
    }

    public int describeContents() {
        return  0;
    }

}
