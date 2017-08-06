package com.click_labs.click_labsworkflow.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.database.CommonData;
import com.click_labs.click_labsworkflow.util.Util;
import com.click_labs.click_labsworkflow.util.dialog.CustomAlertDialog;

import io.paperdb.Paper;


/**
 * Landing Page of the App
 */
public class SplashActivity extends AppCompatActivity {
    private static final String TAG = SplashActivity.class.getName();
    private Dialog mDialog;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        Paper.init(this);
    }


    private synchronized void init() {
        if (!Util.isNetworkAvailable(SplashActivity.this)) {
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }
            mDialog = new CustomAlertDialog.Builder(SplashActivity.this)
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
        } else {
            ((ProgressBar) findViewById(R.id.pb)).setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (CommonData.getAccessToken() == null) {
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    } else {
                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    }
                    finish();
                }
            }, SPLASH_TIME_OUT);
        }
    }


}
