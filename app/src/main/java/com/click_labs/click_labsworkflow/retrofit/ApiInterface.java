package com.click_labs.click_labsworkflow.retrofit;


import com.click_labs.click_labsworkflow.model.commonresponse.CommonReponse;
import com.click_labs.click_labsworkflow.model.loginresponse.LoginResponseData;
import com.click_labs.click_labsworkflow.model.projectdetailsdata.ProjectDetailsResponse;
import com.click_labs.click_labsworkflow.model.resetpassworddata.ResetPasswordResponse;
import com.click_labs.click_labsworkflow.model.timesheetresponse.TimesheetResponseData;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Developer: Saurabh Verma
 * Dated: 27-09-2016.
 */
public interface ApiInterface {

    @POST("Common/login")
    @FormUrlEncoded
    Call<LoginResponseData> commonLogin(@Field("email") String email,
                                        @Field("password") String password);

    @GET("Employee/getTimesheet")
    Call<TimesheetResponseData> getTimesheet(@Header("authorization") String accessToken);

    @GET("Employee/getcompactView")
    Call<ProjectDetailsResponse> getProjectDetails(@Header("authorization") String accessToken);

    @POST("Employee/employeeTimesheet")
    @FormUrlEncoded
    Call<CommonReponse> addTimeSheet(@Header("authorization") String accessToken,
                                     @Field("date") String date,
                                     @Field("timesheetInfo") String timesheetInfo);

    @DELETE("Employee/deleteTimeSheet")
    Call<CommonReponse> deleteTimeSheet(@Header("authorization") String accessToken,
                                        @Query("timesheetId") String timesheetId);

    @PUT("Employee/updateEmployeeTimesheet")
    @FormUrlEncoded
    Call<CommonReponse> editTimesheet(@Header("authorization") String accessToken,
                                      @FieldMap Map<String, String> map);


    @PUT("userManagement/changePassword")
    Call<ResetPasswordResponse> changePassword(@Header("authorization") String accessToken,
                                               @Body String body);
}

