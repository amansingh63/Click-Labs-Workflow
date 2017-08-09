package com.click_labs.click_labsworkflow.fragment;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.database.CommonData;
import com.click_labs.click_labsworkflow.model.commonresponse.CommonReponse;
import com.click_labs.click_labsworkflow.model.projectdetailsdata.ProjectDetailsResponse;
import com.click_labs.click_labsworkflow.model.timesheetresponse.Datum;
import com.click_labs.click_labsworkflow.retrofit.APIError;
import com.click_labs.click_labsworkflow.retrofit.CommonParams;
import com.click_labs.click_labsworkflow.retrofit.ResponseResolver;
import com.click_labs.click_labsworkflow.retrofit.RestClient;
import com.click_labs.click_labsworkflow.util.Util;
import com.click_labs.click_labsworkflow.util.dialog.CustomAlertDialog;
import com.click_labs.click_labsworkflow.util.dialog.CustomListAdapter;
import com.click_labs.click_labsworkflow.util.dialog.CustomListSelector;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;

public class AddTimesheetFragment extends DialogFragment implements View.OnClickListener {

    private OnEditListener onEditListener;
    private OnDataSubmitListener onDataSubmitListener;
    private MaterialEditText etProjectName, etSalesTitle, etHours, etMinutes, etTask;
    private Button btnSave, btnCancel;
    private Datum timeSheetDetails;
    private Boolean isEdit = false;
    private Call retrofitCall;
    private Activity activity;
    private ArrayList<String> projectNameList, projectNameIdList, projectSalesTitleList, projectSalesIdList, hoursList, minutesList;
    private List<com.click_labs.click_labsworkflow.model.projectdetailsdata.Datum> projectDetails;

    public AddTimesheetFragment() {
        // Required empty public constructor
    }


    public AddTimesheetFragment newInstance(Activity activity, OnDataSubmitListener onDataSubmitListener) {
        this.activity = activity;
        this.onDataSubmitListener = onDataSubmitListener;
        return this;
    }

    public AddTimesheetFragment newInstance(Datum timeSheetDetails, Boolean isEdit, Activity activity, OnEditListener onEditListener) {
        this.activity = activity;
        this.isEdit = isEdit;
        this.onEditListener = onEditListener;
        this.timeSheetDetails = timeSheetDetails;
        return this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_add_timesheet, container, false);
        return view;

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etProjectName = (MaterialEditText) view.findViewById(R.id.et_project);
        etSalesTitle = (MaterialEditText) view.findViewById(R.id.et_sales_title);
        etHours = (MaterialEditText) view.findViewById(R.id.et_hours);
        etMinutes = (MaterialEditText) view.findViewById(R.id.et_minutes);
        etTask = (MaterialEditText) view.findViewById(R.id.et_task);
        btnSave = (Button) view.findViewById(R.id.btn_save);
        btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        etProjectName.setOnClickListener(this);
        etSalesTitle.setOnClickListener(this);
        etHours.setOnClickListener(this);
        etMinutes.setOnClickListener(this);

        projectNameList = new ArrayList<>();
        projectNameIdList = new ArrayList<>();
        projectSalesTitleList = new ArrayList<>();
        projectSalesIdList = new ArrayList<>();
        hoursList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"));
        minutesList = new ArrayList<>(Arrays.asList("0", "15", "30", "45"));


        apiHitToGetProjectNameList();

        if (isEdit) {
            setDataonView();
        }


    }

    private void setDataonView() {
        etProjectName.setText(timeSheetDetails.getProjectName());
        etSalesTitle.setText(timeSheetDetails.getSalesOrderTitle());
        etHours.setText(timeSheetDetails.getNoOfHours().toString());
        etMinutes.setText(timeSheetDetails.getMinutes().toString());
        etTask.setText(timeSheetDetails.getComments());
    }

    private boolean isValidInputData() {

        if (etProjectName.getText().toString().trim().isEmpty()) {
            etProjectName.setError("Please Select Project");
            return false;
        } else if (etSalesTitle.getText().toString().trim().isEmpty()) {
            etSalesTitle.setError("Please Select Sales Title");
            return false;
        } else if (etHours.getText().toString().trim().isEmpty()) {
            etHours.setError("Please Select Hours");
            return false;
        } else if (etMinutes.getText().toString().trim().isEmpty()) {
            etMinutes.setError("Please Select Minutes");
            return false;
        } else if (etTask.getText().toString().trim().isEmpty()) {
            etTask.setError("Please Enter Task Accomplished");
            return false;
        }
        return true;

    }

    private void apiHitToEditTimeSheet() {

        CommonParams.Builder builder = new CommonParams.Builder()
                .add("timesheetId", timeSheetDetails.getId())
                .add("salesOrderTitle", etSalesTitle.getText().toString())
                .add("projectId", projectNameIdList.get(projectNameList.indexOf(etProjectName.getText().toString())))
                .add("noOfHours", Integer.valueOf(etHours.getText().toString()))
                .add("projectName", etProjectName.getText())
                .add("minutes", Integer.valueOf(etMinutes.getText().toString()))
                .add("comments", etTask.getText().toString().trim())
                .add("salesOrderId", projectSalesIdList.get(projectSalesTitleList.indexOf(etSalesTitle.getText().toString())));

        CommonParams commonParams = builder.build();


        retrofitCall = RestClient.getApiInterface().editTimesheet(CommonData.getAccessToken(), commonParams.getMap());
        retrofitCall.enqueue(new ResponseResolver<CommonReponse>(activity, true, true) {

            @Override
            public void success(CommonReponse commonReponse) {
                Toast.makeText(activity, R.string.text_toast_timesheet_edited, Toast.LENGTH_SHORT).show();
                onEditListener.onEdit();
            }

            @Override
            public void failure(APIError error) {

            }
        });


    }

    private void apiHitToGetProjectNameList() {
        retrofitCall = RestClient.getApiInterface().getProjectDetails(CommonData.getAccessToken());
        retrofitCall.enqueue(new ResponseResolver<ProjectDetailsResponse>(activity, true, true) {

            @Override
            public void success(ProjectDetailsResponse projectDetailsResponse) {
                projectDetails = projectDetailsResponse.getData();
                if (projectNameList.size() == 0 && projectNameIdList.size() == 0) {
                    for (int i = 0; i < projectDetailsResponse.getData().size(); i++) {
                        projectNameList.add(i, projectDetailsResponse.getData().get(i).getProjectName());
                        projectNameIdList.add(i, projectDetailsResponse.getData().get(i).getId());
                    }
                    if (isEdit) {
                        getSalesTitleList(etProjectName.getText().toString().trim());
                    }
                }

            }

            @Override
            public void failure(APIError error) {

            }
        });


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.et_project:
                if (projectNameList.size() == 0) {
                    apiHitToGetProjectNameList();
                } else {
                    CustomListSelector.showCustomListSelector(activity, projectNameList)
                            .setListTitle(getString(R.string.text_select_project))
                            // .sortList()
                            .addSearch()
                            .show(new CustomListAdapter.OnListItemSelectedListener() {
                                @Override
                                public void onListItemSelected(int position, String listItem) {
                                    etProjectName.setText(listItem);
                                    etSalesTitle.setText("");
                                }
                            });
                }
                break;
            case R.id.et_sales_title:
                if (etProjectName.getText().toString().trim().isEmpty()) {
                    etSalesTitle.setError(getString(R.string.text_error_select_project_first));
                } else {
                    getSalesTitleList(etProjectName.getText().toString().trim());
                    CustomListSelector.showCustomListSelector(activity, projectSalesTitleList)
                            .setListTitle(getString(R.string.text_select_sales_title))
                            .show(new CustomListAdapter.OnListItemSelectedListener() {
                                @Override
                                public void onListItemSelected(int position, String listItem) {
                                    etSalesTitle.setText(listItem);
                                }
                            });
                }
                break;
            case R.id.et_hours:
                CustomListSelector.showCustomListSelector(activity, hoursList)
                        .setListTitle(getString(R.string.text_select_hours_spent))
                        .show(new CustomListAdapter.OnListItemSelectedListener() {
                            @Override
                            public void onListItemSelected(int position, String listItem) {
                                etHours.setText(listItem);
                            }
                        });

                break;
            case R.id.et_minutes:
                CustomListSelector.showCustomListSelector(activity, minutesList)
                        .setListTitle(getString(R.string.text_select_minutes_spent))
                        .show(new CustomListAdapter.OnListItemSelectedListener() {
                            @Override
                            public void onListItemSelected(int position, String listItem) {
                                etMinutes.setText(listItem);
                            }
                        });
                break;

            case R.id.btn_save:


                if (isValidInputData()) {
                    if (Util.isNetworkAvailable(activity)) {
                        if (!isEdit) {
                            try {
                                JSONObject jsonObject = addToJsonObject();
                                onDataSubmitListener.onDataSubmitListener(jsonObject, etProjectName.getText().toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            dismiss();
                        } else {
                            apiHitToEditTimeSheet();
                            dismiss();
                        }
                    } else {
                        new CustomAlertDialog.Builder(activity)
                                .setMessage(R.string.error_internet_not_connected)
                                .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick() {

                                    }
                                })
                                .setNegativeButton(getString(R.string.text_exit), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick() {
                                        dismiss();
                                    }
                                })
                                .show();
                    }

                }
                break;
            case R.id.btn_cancel:
                dismiss();
                break;


        }


    }


    private JSONObject addToJsonObject() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("salesOrderTitle", etSalesTitle.getText());
        jsonObject.put("projectId", projectNameIdList.get(projectNameList.indexOf(etProjectName.getText().toString())));
        jsonObject.put("noOfHours", Integer.valueOf(etHours.getText().toString()));
        jsonObject.put("minutes", Integer.valueOf(etMinutes.getText().toString()));
        jsonObject.put("comments", etTask.getText().toString().trim());
        jsonObject.put("salesOrderId", projectSalesIdList.get(projectSalesTitleList.indexOf(etSalesTitle.getText().toString())));

        return jsonObject;
    }


    private void getSalesTitleList(String itemList) {
        projectSalesTitleList.clear();
        for (int i = 0; i < projectDetails.get(projectNameList.indexOf(itemList)).getSalesOrder().size(); i++) {
            projectSalesTitleList.add(i, projectDetails.get(projectNameList.indexOf(itemList)).getSalesOrder().get(i).getSaleOrderTitle());
            projectSalesIdList.add(i, projectDetails.get(projectNameList.indexOf(itemList)).getSalesOrder().get(i).getId());
        }
    }


    public interface OnDataSubmitListener {

        public void onDataSubmitListener(JSONObject jsonObject, String projectName);
    }

    public interface OnEditListener {
        public void onEdit();
    }

    @Override
    public void onResume() {
        // Store access variables for window and blank point
        Window window = getDialog().getWindow();
        Point size = new Point();
        // Store dimensions of the screen in `size`
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(size);
        // Set the width of the dialog proportional to 75% of the screen width
        window.setLayout((int) (size.x), WindowManager.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        // Call super onResume after sizing
        super.onResume();
    }
}
