package com.click_labs.click_labsworkflow.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.database.CommonData;
import com.click_labs.click_labsworkflow.model.loginresponse.LoginResponseData;
import com.click_labs.click_labsworkflow.retrofit.APIError;
import com.click_labs.click_labsworkflow.retrofit.ResponseResolver;
import com.click_labs.click_labsworkflow.retrofit.RestClient;
import com.click_labs.click_labsworkflow.util.EditTextUtil;
import com.click_labs.click_labsworkflow.util.Util;
import com.click_labs.click_labsworkflow.util.ValidateEditText;
import com.click_labs.click_labsworkflow.util.dialog.CustomAlertDialog;
import com.rengwuxian.materialedittext.MaterialEditText;

import io.paperdb.Paper;
import retrofit2.Call;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private MaterialEditText etEmail, etPassword;
    private Button btnLogin;
    private Call callLogin;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Paper.init(this);

        etEmail = (MaterialEditText) findViewById(R.id.et_email);
        etPassword = (MaterialEditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        EditTextUtil.setIgnoreAllWhiteSpaces(etEmail);
        EditTextUtil.setIgnoreFirstWhiteSpace(etPassword);


    }

    @Override
    public void onClick(View view) {
        if (ValidateEditText.checkEmail(etEmail) && ValidateEditText.checkPassword(etPassword, false)) {
            if (Util.isNetworkAvailable(this)) {
                apiHitForLogin();
            } else {
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
                mDialog = new CustomAlertDialog.Builder(this)
                        .setMessage(R.string.error_internet_not_connected)
                        .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                            @Override
                            public void onClick() {
                                apiHitForLogin();
                            }
                        })
                        .setNegativeButton(getString(R.string.text_exit), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .show();
            }
        }
    }

    private void apiHitForLogin() {

        callLogin = RestClient.getApiInterface().commonLogin(etEmail.getText().toString().trim().toLowerCase()
                , etPassword.getText().toString().trim());

        callLogin.enqueue(new ResponseResolver<LoginResponseData>(this, true, true) {

            @Override
            public void success(LoginResponseData loginResponseData) {
                Toast.makeText(LoginActivity.this, R.string.text_toast_logged_in_succsefull, Toast.LENGTH_SHORT).show();
                CommonData.saveAccessToken(loginResponseData.getData().getToken());
                Intent homeActivityIntent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(homeActivityIntent);
                finish();

            }

            @Override
            public void failure(APIError error) {

            }
        });
    }
}
