package com.click_labs.click_labsworkflow.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.database.CommonData;
import com.click_labs.click_labsworkflow.model.resetpassworddata.ResetPasswordResponse;
import com.click_labs.click_labsworkflow.retrofit.APIError;
import com.click_labs.click_labsworkflow.retrofit.ResponseResolver;
import com.click_labs.click_labsworkflow.retrofit.RestClient;
import com.click_labs.click_labsworkflow.util.EditTextUtil;
import com.click_labs.click_labsworkflow.util.Util;
import com.click_labs.click_labsworkflow.util.ValidateEditText;
import com.click_labs.click_labsworkflow.util.dialog.CustomAlertDialog;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;

public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private JSONObject jsonObject;
    private MaterialEditText etOldPassword, etNewPassword, etConfirmPassword;
    private Button btnSave;
    private Call retofitCall;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);


        etOldPassword = (MaterialEditText) findViewById(R.id.et_old_password);
        etNewPassword = (MaterialEditText) findViewById(R.id.et_new_password);
        etConfirmPassword = (MaterialEditText) findViewById(R.id.et_confirm_password);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);

        EditTextUtil.setIgnoreFirstWhiteSpace(etOldPassword);
        EditTextUtil.setIgnoreFirstWhiteSpace(etNewPassword);
        EditTextUtil.setIgnoreFirstWhiteSpace(etConfirmPassword);

    }

    @Override
    public void onClick(View view) {

        if (validateInputData()) {
            jsonObject = new JSONObject();
            try {
                jsonObject.put("oldPassword", etOldPassword.getText().toString().trim());
                jsonObject.put("newPassword", etNewPassword.getText().toString().trim());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (Util.isNetworkAvailable(this)) {
                apiHitForChangePassword();
            } else {
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                mDialog = new CustomAlertDialog.Builder(ChangePasswordActivity.this)
                        .setMessage(R.string.error_internet_not_connected)
                        .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                            @Override
                            public void onClick() {
                                if (Util.isNetworkAvailable(ChangePasswordActivity.this)) {
                                    apiHitForChangePassword();
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

        }

    }

    private void apiHitForChangePassword() {

        retofitCall = RestClient.getApiInterface().changePassword(CommonData.getAccessToken(), jsonObject.toString());
        retofitCall.enqueue(new ResponseResolver<ResetPasswordResponse>(this, true, false) {


            @Override
            public void success(ResetPasswordResponse resetPasswordResponse) {
                Toast.makeText(ChangePasswordActivity.this, R.string.text_password_changed_successfully, Toast.LENGTH_SHORT).show();
                finish();

            }

            @Override
            public void failure(APIError error) {
                etOldPassword.requestFocus();
                etOldPassword.setText("");
                etOldPassword.setError(getString(R.string.text_error_old_password_is_wrong));

            }
        });


    }

    private boolean validateInputData() {

        if (!ValidateEditText.checkPassword(etOldPassword, false)) {
            return false;
        } else if (!ValidateEditText.checkPassword(etNewPassword, false)) {
            return false;
        } else if (!ValidateEditText.checkPassword(etConfirmPassword, true)) {
            return false;
        } else if (!ValidateEditText.comparePassword(etNewPassword, etConfirmPassword)) {
            return false;
        }
        return true;


    }


}
