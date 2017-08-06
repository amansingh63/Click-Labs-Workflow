
package com.click_labs.click_labsworkflow.model.projectdetailsdata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Datum implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("projectName")
    @Expose
    private String projectName;
    @SerializedName("briefSummary")
    @Expose
    private String briefSummary;
    @SerializedName("projectClassification")
    @Expose
    private String projectClassification;
    @SerializedName("pmName")
    @Expose
    private String pmName;
    @SerializedName("pmId")
    @Expose
    private String pmId;
    @SerializedName("projectAssignedId")
    @Expose
    private String projectAssignedId;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("clientId")
    @Expose
    private String clientId;
    @SerializedName("vertical")
    @Expose
    private String vertical;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("bussinessValue")
    @Expose
    private List<BussinessValue> bussinessValue = null;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("currentStage")
    @Expose
    private String currentStage;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("projectType")
    @Expose
    private String projectType;
    @SerializedName("salesOrder")
    @Expose
    private List<SalesOrder> salesOrder = null;
    public final static Parcelable.Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            Datum instance = new Datum();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectName = ((String) in.readValue((String.class.getClassLoader())));
            instance.briefSummary = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectClassification = ((String) in.readValue((String.class.getClassLoader())));
            instance.pmName = ((String) in.readValue((String.class.getClassLoader())));
            instance.pmId = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectAssignedId = ((String) in.readValue((String.class.getClassLoader())));
            instance.clientName = ((String) in.readValue((String.class.getClassLoader())));
            instance.clientId = ((String) in.readValue((String.class.getClassLoader())));
            instance.vertical = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdBy = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.bussinessValue, (com.click_labs.click_labsworkflow.model.projectdetailsdata.BussinessValue.class.getClassLoader()));
            instance.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.currentStage = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectType = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.salesOrder, (com.click_labs.click_labsworkflow.model.projectdetailsdata.SalesOrder.class.getClassLoader()));
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBriefSummary() {
        return briefSummary;
    }

    public void setBriefSummary(String briefSummary) {
        this.briefSummary = briefSummary;
    }

    public String getProjectClassification() {
        return projectClassification;
    }

    public void setProjectClassification(String projectClassification) {
        this.projectClassification = projectClassification;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public String getProjectAssignedId() {
        return projectAssignedId;
    }

    public void setProjectAssignedId(String projectAssignedId) {
        this.projectAssignedId = projectAssignedId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public List<BussinessValue> getBussinessValue() {
        return bussinessValue;
    }

    public void setBussinessValue(List<BussinessValue> bussinessValue) {
        this.bussinessValue = bussinessValue;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getCurrentStage() {
        return currentStage;
    }

    public void setCurrentStage(String currentStage) {
        this.currentStage = currentStage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public List<SalesOrder> getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(List<SalesOrder> salesOrder) {
        this.salesOrder = salesOrder;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(projectName);
        dest.writeValue(briefSummary);
        dest.writeValue(projectClassification);
        dest.writeValue(pmName);
        dest.writeValue(pmId);
        dest.writeValue(projectAssignedId);
        dest.writeValue(clientName);
        dest.writeValue(clientId);
        dest.writeValue(vertical);
        dest.writeValue(createdBy);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeList(bussinessValue);
        dest.writeValue(v);
        dest.writeValue(currentStage);
        dest.writeValue(status);
        dest.writeValue(projectType);
        dest.writeList(salesOrder);
    }

    public int describeContents() {
        return  0;
    }

}
