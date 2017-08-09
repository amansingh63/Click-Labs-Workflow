package com.click_labs.click_labsworkflow.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.constants.AppConstant;
import com.click_labs.click_labsworkflow.database.CommonData;
import com.click_labs.click_labsworkflow.model.commonresponse.CommonReponse;
import com.click_labs.click_labsworkflow.model.timesheetresponse.Datum;
import com.click_labs.click_labsworkflow.retrofit.APIError;
import com.click_labs.click_labsworkflow.retrofit.ResponseResolver;
import com.click_labs.click_labsworkflow.retrofit.RestClient;
import com.click_labs.click_labsworkflow.util.Util;
import com.click_labs.click_labsworkflow.util.dialog.CustomAlertDialog;

import retrofit2.Call;


public class TimesheetDetailsFragment extends DialogFragment implements View.OnClickListener, AppConstant {


    private TextView tvProjectName, tvProjectId, tvDate, tvHoursSpent, tvWorkDescription;
    private Button btnEdit, btnDelete;
    private ImageView ivDismiss;
    private Dialog mDialog;
    private Call retrofit;
    private Activity activity;
    private AddTimesheetFragment.OnEditListener onEditListener;
    private OnDeleteListner onDeleteListner;
    private Datum timeSheetDetails;

    // Empty Constructor

    public TimesheetDetailsFragment() {
    }

    public static TimesheetDetailsFragment newInstance(Datum timeSheetDetails) {
        TimesheetDetailsFragment timesheetDetailsFragment = new TimesheetDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_TIMESHEET_DETAILS, timeSheetDetails);
        timesheetDetailsFragment.setArguments(args);
        timesheetDetailsFragment.setCancelable(false);
        return timesheetDetailsFragment;
    }

    public void setOnEditListener(AddTimesheetFragment.OnEditListener onEditListener) {
        this.onEditListener = onEditListener;
    }

    public void setOnDeleteListner(OnDeleteListner onDeleteListner) {
        this.onDeleteListner = onDeleteListner;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.fragment_timesheet_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timeSheetDetails = getArguments().getParcelable(EXTRA_TIMESHEET_DETAILS);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvProjectName = (TextView) view.findViewById(R.id.tv_project_name);
        tvProjectId = (TextView) view.findViewById(R.id.tv_project_id);
        tvDate = (TextView) view.findViewById(R.id.tv_date);
        tvHoursSpent = (TextView) view.findViewById(R.id.tv_hours_spent);
        tvWorkDescription = (TextView) view.findViewById(R.id.tv_work_description);
        btnEdit = (Button) view.findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(this);
        btnDelete = (Button) view.findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(this);
        ivDismiss = (ImageView) view.findViewById(R.id.iv_dismiss);
        ivDismiss.setOnClickListener(this);

        setData();
    }

    private void setData() {
        tvProjectName.setText(timeSheetDetails.getProjectName());
        tvProjectId.setText(timeSheetDetails.getSalesOrderTitle());
        tvDate.setText(timeSheetDetails.getDate());
        tvHoursSpent.setText(timeSheetDetails.getNoOfHours() + " : " +
                timeSheetDetails.getMinutes() + getString(R.string.text_hrs));
        tvWorkDescription.setText(timeSheetDetails.getComments());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit:
                if (Util.isNetworkAvailable(activity)) {
                    openEditTimesheetFragment();
                } else {
                    if (mDialog != null && mDialog.isShowing()) {
                        mDialog.dismiss();
                    }
                    mDialog = new CustomAlertDialog.Builder(activity)
                            .setMessage(R.string.error_internet_not_connected)
                            .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                @Override
                                public void onClick() {
                                    if (Util.isNetworkAvailable(activity)) {
                                        openEditTimesheetFragment();
                                    }
                                }
                            })
                            .setNegativeButton(R.string.text_close, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                @Override
                                public void onClick() {
                                    mDialog.dismiss();
                                }
                            })
                            .show();
                }
                break;

            case R.id.iv_dismiss:
                dismiss();
                break;
            case R.id.btn_delete:
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                mDialog = new CustomAlertDialog.Builder(getContext())
                        .setTitle(R.string.text_delete_timesheet)
                        .setMessage(R.string.text_are_you_sure_to_delete)
                        .setPositiveButton(getString(R.string.text_no), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .setNegativeButton(getString(R.string.text_yes), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                            @Override
                            public void onClick() {

                                if (Util.isNetworkAvailable(activity)) {
                                    apiHitToDeleteTimeSheet();
                                    dismiss();
                                } else {
                                    if (mDialog != null && mDialog.isShowing()) {
                                        mDialog.dismiss();
                                    }
                                    mDialog = new CustomAlertDialog.Builder(activity)
                                            .setMessage(R.string.error_internet_not_connected)
                                            .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick() {
                                                    if (Util.isNetworkAvailable(activity)) {
                                                        apiHitToDeleteTimeSheet();
                                                        dismiss();
                                                    }
                                                }
                                            })
                                            .setNegativeButton(getString(R.string.text_close), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick() {
                                                    mDialog.dismiss();
                                                }
                                            })
                                            .show();
                                }
                            }
                        })
                        .show();
                dismiss();

                break;
        }

    }

    private void apiHitToDeleteTimeSheet() {
        retrofit = RestClient.getApiInterface().deleteTimeSheet(CommonData.getAccessToken(), timeSheetDetails.getId());
        retrofit.enqueue(new ResponseResolver<CommonReponse>(activity, true, true) {

            @Override
            public void success(CommonReponse commonReponse) {
                Toast.makeText(activity, R.string.text_toast_timesheet_deleted_succsfully, Toast.LENGTH_SHORT).show();
                onDeleteListner.onDelete();
            }

            @Override
            public void failure(APIError error) {

            }
        });

    }

    public interface OnDeleteListner {
        public void onDelete();
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


    private void openEditTimesheetFragment() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        AddTimesheetFragment addTimesheetFragment = new AddTimesheetFragment();
        addTimesheetFragment.newInstance(timeSheetDetails, true, activity, onEditListener);
        addTimesheetFragment.setCancelable(false);
        addTimesheetFragment.show(fm, "edit_timesheet");
        dismiss();
    }
}
