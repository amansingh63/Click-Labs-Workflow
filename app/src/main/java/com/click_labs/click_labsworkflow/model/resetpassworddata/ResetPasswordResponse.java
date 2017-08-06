package com.click_labs.click_labsworkflow.model.resetpassworddata;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResetPasswordResponse implements Parcelable {

    public final static Creator<ResetPasswordResponse> CREATOR = new Creator<ResetPasswordResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResetPasswordResponse createFromParcel(Parcel in) {
            ResetPasswordResponse instance = new ResetPasswordResponse();
            instance.statusCode = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.message = ((String) in.readValue((String.class.getClassLoader())));
            instance.data = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public ResetPasswordResponse[] newArray(int size) {
            return (new ResetPasswordResponse[size]);
        }

    };
    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(statusCode);
        dest.writeValue(message);
        dest.writeValue(data);
    }

    public int describeContents() {
        return 0;
    }

}
