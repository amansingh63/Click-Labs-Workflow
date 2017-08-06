package com.click_labs.click_labsworkflow.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.constants.AppConstant;
import com.click_labs.click_labsworkflow.database.CommonData;
import com.click_labs.click_labsworkflow.fragment.AddTimesheetFragment;
import com.click_labs.click_labsworkflow.model.commonresponse.CommonReponse;
import com.click_labs.click_labsworkflow.retrofit.APIError;
import com.click_labs.click_labsworkflow.retrofit.ResponseResolver;
import com.click_labs.click_labsworkflow.retrofit.RestClient;
import com.click_labs.click_labsworkflow.util.Util;
import com.click_labs.click_labsworkflow.util.dialog.CustomAlertDialog;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;

public class AddTimesheetActivity extends AppCompatActivity implements View.OnClickListener, AppConstant {

    private Call retrofitCall;
    private DatePickerDialog datePickerDialog;
    private MaterialEditText etDate;
    private Button btnAdd, btnSave;
    private Calendar myCalendar = Calendar.getInstance();
    private Calendar myCalendar2 = Calendar.getInstance();
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private JSONArray jsonArray = new JSONArray();
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_timesheet);

        init();

    }


    private void init() {
        etDate = (MaterialEditText) findViewById(R.id.et_date);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnSave = (Button) findViewById(R.id.btn_save);
        linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        etDate.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                etDate.setText(simpleDateFormat.format(myCalendar.getTime()));
            }
        };
        myCalendar2.add(Calendar.DATE, -5);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_date:
                if (etDate.isClickable()) {
                    datePickerDialog = new DatePickerDialog(AddTimesheetActivity.this, dateSetListener, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH));
                    datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                    datePickerDialog.getDatePicker().setMinDate(myCalendar2.getTimeInMillis());
                    datePickerDialog.show();
                } else {
                    Toast.makeText(this, R.string.text_toast_with_diffrent_dates, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_add:
                if (!etDate.getText().toString().trim().isEmpty()) {
                    if (Util.isNetworkAvailable(this)) {
                        FragmentManager fm = getSupportFragmentManager();
                        AddTimesheetFragment fragment = new AddTimesheetFragment();
                        fragment.newInstance(this, new AddTimesheetFragment.OnDataSubmitListner() {
                            @Override
                            public void onDataSubmitListner(JSONObject jsonObject, String projectName) {
                                jsonArray.put(jsonObject);
                                Log.v("JSON  ===", jsonArray.toString());
                                Toast.makeText(AddTimesheetActivity.this, R.string.text_timesheet_added_successfully, Toast.LENGTH_SHORT).show();
                                try {
                                    addTimesheetDetailToActivity(jsonObject, projectName);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                etDate.setClickable(false);
                                btnSave.setVisibility(View.VISIBLE);
                                btnAdd.setText(R.string.text_add_more);

                            }
                        });
                        fragment.setCancelable(false);
                        fragment.show(fm, "timesheet_details");
                    } else {
                        new CustomAlertDialog.Builder(this)
                                .setMessage(R.string.error_internet_not_connected)
                                .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick() {
                                        init();
                                    }
                                })
                                .setNegativeButton(getString(R.string.text_exit), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick() {
                                        finish();
                                    }
                                })
                                .show();
                    }
                } else {
                    etDate.setError(getString(R.string.text_error_select_date_first));
                }

                break;
            case R.id.btn_save:
                if (Util.isNetworkAvailable(this)) {
                    apiHitToSaveTimeSheet();
                } else {
                    new CustomAlertDialog.Builder(this)
                            .setMessage(R.string.error_internet_not_connected)
                            .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                @Override
                                public void onClick() {
                                    if (Util.isNetworkAvailable(AddTimesheetActivity.this)) {
                                        apiHitToSaveTimeSheet();
                                    }
                                }
                            })
                            .setNegativeButton(getString(R.string.text_exit), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                @Override
                                public void onClick() {

                                }
                            })
                            .show();
                }
                break;
        }


    }


    private void apiHitToSaveTimeSheet() {
        retrofitCall = RestClient.getApiInterface().addTimeSheet(CommonData.getAccessToken(), etDate.getText().toString().trim(), jsonArray.toString());
        retrofitCall.enqueue(new ResponseResolver<CommonReponse>(this, true, true) {

            @Override
            public void success(CommonReponse commonReponse) {
                Toast.makeText(AddTimesheetActivity.this, R.string.text_timesheet_added_successfully, Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }

            @Override
            public void failure(APIError error) {

            }
        });

    }


    private void addTimesheetDetailToActivity(JSONObject jsonObject, String projectName) throws JSONException {

        View view = getLayoutInflater().inflate(R.layout.layout_item_timesheet, null);
        ((TextView) view.findViewById(R.id.tv_project_name)).setText(projectName);
        ((TextView) view.findViewById(R.id.tv_project_id)).setText(jsonObject.getString("salesOrderTitle"));
        ((TextView) view.findViewById(R.id.tv_date)).setText(etDate.getText().toString());
        ((TextView) view.findViewById(R.id.tv_hours_spent)).setText(jsonObject.getString("noOfHours") + " : " + jsonObject.getString("minutes") + " hrs");
        ((TextView) view.findViewById(R.id.tv_work_description)).setText(jsonObject.getString("comments"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(view, layoutParams);
    }


}
