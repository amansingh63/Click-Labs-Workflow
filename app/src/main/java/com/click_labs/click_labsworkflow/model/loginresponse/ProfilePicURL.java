
package com.click_labs.click_labsworkflow.model.loginresponse;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfilePicURL implements Parcelable
{

    @SerializedName("original")
    @Expose
    private Object original;
    @SerializedName("thumbnail")
    @Expose
    private Object thumbnail;
    public final static Creator<ProfilePicURL> CREATOR = new Creator<ProfilePicURL>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProfilePicURL createFromParcel(Parcel in) {
            ProfilePicURL instance = new ProfilePicURL();
            instance.original = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.thumbnail = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public ProfilePicURL[] newArray(int size) {
            return (new ProfilePicURL[size]);
        }

    }
    ;

    public Object getOriginal() {
        return original;
    }

    public void setOriginal(Object original) {
        this.original = original;
    }

    public Object getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Object thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(original);
        dest.writeValue(thumbnail);
    }

    public int describeContents() {
        return  0;
    }

}
