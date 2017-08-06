package com.click_labs.click_labsworkflow.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.click_labs.click_labsworkflow.constants.ApiKeyConstant.DATA;
import static com.click_labs.click_labsworkflow.constants.ApiKeyConstant.MESSAGE;
import static com.click_labs.click_labsworkflow.constants.ApiKeyConstant.STATUS_CODE;


/**
 * Developer: Saurabh Verma
 * Dated: 27-09-2016.
 */

public class CommonResponse {
    @SerializedName(STATUS_CODE)
    @Expose
    private String statusCode;
    @SerializedName(MESSAGE)
    @Expose
    private String message;
    @SerializedName(DATA)
    @Expose
    private Object data;

    /**
     * Get message from api response
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get status code of api response
     *
     * @return statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    @Override
    public String toString() {
        return statusCode + " " + message + "\n" + data;
    }
}
