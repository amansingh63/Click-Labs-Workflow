package com.click_labs.click_labsworkflow.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.activity.SplashActivity;
import com.click_labs.click_labsworkflow.database.CommonData;


/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public final class Util {

    public static final int TEN = 10;

    /**
     * Empty Constructor
     * not called
     */
    private Util() {
    }

    /**
     * Method to check if internet is connected
     *
     * @param context context of calling class
     * @return true if connected to any network else return false
     */
    public static boolean isNetworkAvailable(final Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) (context.getApplicationContext()).getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Method to show toast
     *
     * @param message  that disaply in the Toast
     * @param mContext context of calling activity or fragment
     */
    public static void showToast(final Context mContext, final String message) {
        if (mContext == null
                || message == null
                || message.isEmpty()) {
            return;
        }
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * @param mContext context of calling activity or fragment
     */
    public static void restartAppOnSessionExpired(final Context mContext) {
        Util.showToast(mContext, mContext.getString(R.string.session_expired));
        Intent intent = new Intent(mContext, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        CommonData.clearData();
        mContext.startActivity(intent);
    }
}
