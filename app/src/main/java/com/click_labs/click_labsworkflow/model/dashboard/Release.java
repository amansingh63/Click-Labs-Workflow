
package com.click_labs.click_labsworkflow.model.dashboard;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Release implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("milestoneTitle")
    @Expose
    private String milestoneTitle;
    @SerializedName("milestoneDate")
    @Expose
    private String milestoneDate;
    @SerializedName("milestoneStatus")
    @Expose
    private String milestoneStatus;
    @SerializedName("releaseTitle")
    @Expose
    private String releaseTitle;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("releaseStatus")
    @Expose
    private String releaseStatus;
    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("salesId")
    @Expose
    private String salesId;
    @SerializedName("isDeleted")
    @Expose
    private boolean isDeleted;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("raised")
    @Expose
    private int raised;
    @SerializedName("financialStatus")
    @Expose
    private FinancialStatus financialStatus;
    @SerializedName("__v")
    @Expose
    private int v;
    @SerializedName("received")
    @Expose
    private int received;
    @SerializedName("notes")
    @Expose
    private String notes;
    public final static Creator<Release> CREATOR = new Creator<Release>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Release createFromParcel(Parcel in) {
            return new Release(in);
        }

        public Release[] newArray(int size) {
            return (new Release[size]);
        }

    }
    ;

    protected Release(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.milestoneTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.milestoneDate = ((String) in.readValue((String.class.getClassLoader())));
        this.milestoneStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((int) in.readValue((int.class.getClassLoader())));
        this.salesId = ((String) in.readValue((String.class.getClassLoader())));
        this.isDeleted = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
        this.createdAt = ((String) in.readValue((String.class.getClassLoader())));
        this.raised = ((int) in.readValue((int.class.getClassLoader())));
        this.financialStatus = ((FinancialStatus) in.readValue((FinancialStatus.class.getClassLoader())));
        this.v = ((int) in.readValue((int.class.getClassLoader())));
        this.received = ((int) in.readValue((int.class.getClassLoader())));
        this.notes = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Release() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMilestoneTitle() {
        return milestoneTitle;
    }

    public void setMilestoneTitle(String milestoneTitle) {
        this.milestoneTitle = milestoneTitle;
    }

    public String getMilestoneDate() {
        return milestoneDate;
    }

    public void setMilestoneDate(String milestoneDate) {
        this.milestoneDate = milestoneDate;
    }

    public String getMilestoneStatus() {
        return milestoneStatus;
    }

    public void setMilestoneStatus(String milestoneStatus) {
        this.milestoneStatus = milestoneStatus;
    }

    public String getReleaseTitle() {
        return releaseTitle;
    }

    public void setReleaseTitle(String releaseTitle) {
        this.releaseTitle = releaseTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSalesId() {
        return salesId;
    }

    public void setSalesId(String salesId) {
        this.salesId = salesId;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
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

    public int getRaised() {
        return raised;
    }

    public void setRaised(int raised) {
        this.raised = raised;
    }

    public FinancialStatus getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(FinancialStatus financialStatus) {
        this.financialStatus = financialStatus;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(milestoneTitle);
        dest.writeValue(milestoneDate);
        dest.writeValue(milestoneStatus);
        dest.writeValue(releaseTitle);
        dest.writeValue(releaseDate);
        dest.writeValue(releaseStatus);
        dest.writeValue(amount);
        dest.writeValue(salesId);
        dest.writeValue(isDeleted);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(raised);
        dest.writeValue(financialStatus);
        dest.writeValue(v);
        dest.writeValue(received);
        dest.writeValue(notes);
    }

    public int describeContents() {
        return  0;
    }

}
