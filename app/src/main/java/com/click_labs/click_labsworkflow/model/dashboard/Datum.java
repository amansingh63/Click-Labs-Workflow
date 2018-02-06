
package com.click_labs.click_labsworkflow.model.dashboard;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Datum implements Parcelable {

    @SerializedName("salesKey")
    @Expose
    private String salesKey;
    @SerializedName("salesOrderID")
    @Expose
    private String salesOrderID;
    @SerializedName("projectName")
    @Expose
    private String projectName;
    @SerializedName("briefSummary")
    @Expose
    private String briefSummary;
    @SerializedName("projectClassification")
    @Expose
    private String projectClassification;
    @SerializedName("pmId")
    @Expose
    private String pmId;
    @SerializedName("pmName")
    @Expose
    private String pmName;
    @SerializedName("clientId")
    @Expose
    private String clientId;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("vertical")
    @Expose
    private String vertical;
    @SerializedName("currentStage")
    @Expose
    private String currentStage;
    @SerializedName("status")
    @Expose
    private String status;
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
    private int discountAmount;
    @SerializedName("projectAssignedId")
    @Expose
    private String projectAssignedId;
    @SerializedName("kickOffDate")
    @Expose
    private String kickOffDate;
    @SerializedName("solutionContactName")
    @Expose
    private String solutionContactName;
    @SerializedName("salesContactName")
    @Expose
    private String salesContactName;
    @SerializedName("MSASignDate")
    @Expose
    private String mSASignDate;
    @SerializedName("penalityclause")
    @Expose
    private boolean penalityclause;
    @SerializedName("milestoneDate")
    @Expose
    private String milestoneDate;
    @SerializedName("releaseDate")
    @Expose
    private String releaseDate;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("amount")
    @Expose
    private int amount;
    @SerializedName("plannedDate")
    @Expose
    private String plannedDate;
    @SerializedName("expectedDate")
    @Expose
    private String expectedDate;
    @SerializedName("productionRedy")
    @Expose
    private String productionRedy;
    @SerializedName("teamName")
    @Expose
    private String teamName;
    @SerializedName("month")
    @Expose
    private int month;
    @SerializedName("plannedAmount")
    @Expose
    private int plannedAmount;
    @SerializedName("enteryDate")
    @Expose
    private String enteryDate;
    @SerializedName("releases")
    @Expose
    private ArrayList<Release> releases = new ArrayList<Release>();
    @SerializedName("totalCount")
    @Expose
    private int totalCount;
    @SerializedName("actualCost")
    @Expose
    private int actualCost;
    @SerializedName("tallyId")
    @Expose
    private String tallyId;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    };

    protected Datum(Parcel in) {
        this.salesKey = ((String) in.readValue((String.class.getClassLoader())));
        this.salesOrderID = ((String) in.readValue((String.class.getClassLoader())));
        this.projectName = ((String) in.readValue((String.class.getClassLoader())));
        this.briefSummary = ((String) in.readValue((String.class.getClassLoader())));
        this.projectClassification = ((String) in.readValue((String.class.getClassLoader())));
        this.pmId = ((String) in.readValue((String.class.getClassLoader())));
        this.pmName = ((String) in.readValue((String.class.getClassLoader())));
        this.clientId = ((String) in.readValue((String.class.getClassLoader())));
        this.clientName = ((String) in.readValue((String.class.getClassLoader())));
        this.vertical = ((String) in.readValue((String.class.getClassLoader())));
        this.currentStage = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.saleOrderTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        this.supportPeriod = ((String) in.readValue((String.class.getClassLoader())));
        this.discountAmount = ((int) in.readValue((int.class.getClassLoader())));
        this.projectAssignedId = ((String) in.readValue((String.class.getClassLoader())));
        this.kickOffDate = ((String) in.readValue((String.class.getClassLoader())));
        this.solutionContactName = ((String) in.readValue((String.class.getClassLoader())));
        this.salesContactName = ((String) in.readValue((String.class.getClassLoader())));
        this.mSASignDate = ((String) in.readValue((String.class.getClassLoader())));
        this.penalityclause = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.milestoneDate = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
        this.year = ((int) in.readValue((int.class.getClassLoader())));
        this.amount = ((int) in.readValue((int.class.getClassLoader())));
        this.plannedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.expectedDate = ((String) in.readValue((String.class.getClassLoader())));
        this.productionRedy = ((String) in.readValue((String.class.getClassLoader())));
        this.teamName = ((String) in.readValue((String.class.getClassLoader())));
        this.month = ((int) in.readValue((int.class.getClassLoader())));
        this.plannedAmount = ((int) in.readValue((int.class.getClassLoader())));
        this.enteryDate = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.releases, (Release.class.getClassLoader()));
        this.totalCount = ((int) in.readValue((int.class.getClassLoader())));
        this.actualCost = ((int) in.readValue((int.class.getClassLoader())));
        this.tallyId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public String getSalesKey() {
        return salesKey;
    }

    public void setSalesKey(String salesKey) {
        this.salesKey = salesKey;
    }

    public String getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        this.salesOrderID = salesOrderID;
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

    public String getPmId() {
        return pmId;
    }

    public void setPmId(String pmId) {
        this.pmId = pmId;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
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

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getProjectAssignedId() {
        return projectAssignedId;
    }

    public void setProjectAssignedId(String projectAssignedId) {
        this.projectAssignedId = projectAssignedId;
    }

    public String getKickOffDate() {
        return kickOffDate;
    }

    public void setKickOffDate(String kickOffDate) {
        this.kickOffDate = kickOffDate;
    }

    public String getSolutionContactName() {
        return solutionContactName;
    }

    public void setSolutionContactName(String solutionContactName) {
        this.solutionContactName = solutionContactName;
    }

    public String getSalesContactName() {
        return salesContactName;
    }

    public void setSalesContactName(String salesContactName) {
        this.salesContactName = salesContactName;
    }

    public String getMSASignDate() {
        return mSASignDate;
    }

    public void setMSASignDate(String mSASignDate) {
        this.mSASignDate = mSASignDate;
    }

    public boolean isPenalityclause() {
        return penalityclause;
    }

    public void setPenalityclause(boolean penalityclause) {
        this.penalityclause = penalityclause;
    }

    public String getMilestoneDate() {
        return milestoneDate;
    }

    public void setMilestoneDate(String milestoneDate) {
        this.milestoneDate = milestoneDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(String plannedDate) {
        this.plannedDate = plannedDate;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getProductionRedy() {
        return productionRedy;
    }

    public void setProductionRedy(String productionRedy) {
        this.productionRedy = productionRedy;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getPlannedAmount() {
        return plannedAmount;
    }

    public void setPlannedAmount(int plannedAmount) {
        this.plannedAmount = plannedAmount;
    }

    public String getEnteryDate() {
        return enteryDate;
    }

    public void setEnteryDate(String enteryDate) {
        this.enteryDate = enteryDate;
    }

    public ArrayList<Release> getReleases() {
        return releases;
    }

    public void setReleases(ArrayList<Release> releases) {
        this.releases = releases;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getActualCost() {
        return actualCost;
    }

    public void setActualCost(int actualCost) {
        this.actualCost = actualCost;
    }

    public String getTallyId() {
        return tallyId;
    }

    public void setTallyId(String tallyId) {
        this.tallyId = tallyId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(salesKey);
        dest.writeValue(salesOrderID);
        dest.writeValue(projectName);
        dest.writeValue(briefSummary);
        dest.writeValue(projectClassification);
        dest.writeValue(pmId);
        dest.writeValue(pmName);
        dest.writeValue(clientId);
        dest.writeValue(clientName);
        dest.writeValue(vertical);
        dest.writeValue(currentStage);
        dest.writeValue(status);
        dest.writeValue(saleOrderTitle);
        dest.writeValue(currency);
        dest.writeValue(supportPeriod);
        dest.writeValue(discountAmount);
        dest.writeValue(projectAssignedId);
        dest.writeValue(kickOffDate);
        dest.writeValue(solutionContactName);
        dest.writeValue(salesContactName);
        dest.writeValue(mSASignDate);
        dest.writeValue(penalityclause);
        dest.writeValue(milestoneDate);
        dest.writeValue(releaseDate);
        dest.writeValue(year);
        dest.writeValue(amount);
        dest.writeValue(plannedDate);
        dest.writeValue(expectedDate);
        dest.writeValue(productionRedy);
        dest.writeValue(teamName);
        dest.writeValue(month);
        dest.writeValue(plannedAmount);
        dest.writeValue(enteryDate);
        dest.writeList(releases);
        dest.writeValue(totalCount);
        dest.writeValue(actualCost);
        dest.writeValue(tallyId);
    }

    public int describeContents() {
        return 0;
    }

}
