
package com.click_labs.click_labsworkflow.model.projectdetailsdata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalesOrder implements Parcelable
{

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("saleOrderTitle")
    @Expose
    private String saleOrderTitle;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("supportPeriod")
    @Expose
    private String supportPeriod;
    @SerializedName("discountAmount")
    @Expose
    private Integer discountAmount;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("effectiveAmount")
    @Expose
    private Integer effectiveAmount;
    @SerializedName("kickOffDate")
    @Expose
    private String kickOffDate;
    @SerializedName("MSASignDate")
    @Expose
    private String mSASignDate;
    @SerializedName("salesContactName")
    @Expose
    private String salesContactName;
    @SerializedName("salesContactId")
    @Expose
    private String salesContactId;
    @SerializedName("solutionContactName")
    @Expose
    private String solutionContactName;
    @SerializedName("solutionContactId")
    @Expose
    private String solutionContactId;
    @SerializedName("projectId")
    @Expose
    private String projectId;
    @SerializedName("saleOrderId")
    @Expose
    private String saleOrderId;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("penalityclause")
    @Expose
    private Boolean penalityclause;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("tallyId")
    @Expose
    private String tallyId;
    public final static Parcelable.Creator<SalesOrder> CREATOR = new Creator<SalesOrder>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SalesOrder createFromParcel(Parcel in) {
            SalesOrder instance = new SalesOrder();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.saleOrderTitle = ((String) in.readValue((String.class.getClassLoader())));
            instance.currency = ((String) in.readValue((String.class.getClassLoader())));
            instance.supportPeriod = ((String) in.readValue((String.class.getClassLoader())));
            instance.discountAmount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.amount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.effectiveAmount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.kickOffDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.mSASignDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.salesContactName = ((String) in.readValue((String.class.getClassLoader())));
            instance.salesContactId = ((String) in.readValue((String.class.getClassLoader())));
            instance.solutionContactName = ((String) in.readValue((String.class.getClassLoader())));
            instance.solutionContactId = ((String) in.readValue((String.class.getClassLoader())));
            instance.projectId = ((String) in.readValue((String.class.getClassLoader())));
            instance.saleOrderId = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.penalityclause = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.v = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.tallyId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SalesOrder[] newArray(int size) {
            return (new SalesOrder[size]);
        }

    }
    ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSaleOrderTitle() {
        return saleOrderTitle;
    }

    public void setSaleOrderTitle(String saleOrderTitle) {
        this.saleOrderTitle = saleOrderTitle;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSupportPeriod() {
        return supportPeriod;
    }

    public void setSupportPeriod(String supportPeriod) {
        this.supportPeriod = supportPeriod;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getEffectiveAmount() {
        return effectiveAmount;
    }

    public void setEffectiveAmount(Integer effectiveAmount) {
        this.effectiveAmount = effectiveAmount;
    }

    public String getKickOffDate() {
        return kickOffDate;
    }

    public void setKickOffDate(String kickOffDate) {
        this.kickOffDate = kickOffDate;
    }

    public String getMSASignDate() {
        return mSASignDate;
    }

    public void setMSASignDate(String mSASignDate) {
        this.mSASignDate = mSASignDate;
    }

    public String getSalesContactName() {
        return salesContactName;
    }

    public void setSalesContactName(String salesContactName) {
        this.salesContactName = salesContactName;
    }

    public String getSalesContactId() {
        return salesContactId;
    }

    public void setSalesContactId(String salesContactId) {
        this.salesContactId = salesContactId;
    }

    public String getSolutionContactName() {
        return solutionContactName;
    }

    public void setSolutionContactName(String solutionContactName) {
        this.solutionContactName = solutionContactName;
    }

    public String getSolutionContactId() {
        return solutionContactId;
    }

    public void setSolutionContactId(String solutionContactId) {
        this.solutionContactId = solutionContactId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(String saleOrderId) {
        this.saleOrderId = saleOrderId;
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

    public Boolean getPenalityclause() {
        return penalityclause;
    }

    public void setPenalityclause(Boolean penalityclause) {
        this.penalityclause = penalityclause;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getTallyId() {
        return tallyId;
    }

    public void setTallyId(String tallyId) {
        this.tallyId = tallyId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(saleOrderTitle);
        dest.writeValue(currency);
        dest.writeValue(supportPeriod);
        dest.writeValue(discountAmount);
        dest.writeValue(amount);
        dest.writeValue(effectiveAmount);
        dest.writeValue(kickOffDate);
        dest.writeValue(mSASignDate);
        dest.writeValue(salesContactName);
        dest.writeValue(salesContactId);
        dest.writeValue(solutionContactName);
        dest.writeValue(solutionContactId);
        dest.writeValue(projectId);
        dest.writeValue(saleOrderId);
        dest.writeValue(updatedAt);
        dest.writeValue(createdAt);
        dest.writeValue(penalityclause);
        dest.writeValue(v);
        dest.writeValue(tallyId);
    }

    public int describeContents() {
        return  0;
    }

}
