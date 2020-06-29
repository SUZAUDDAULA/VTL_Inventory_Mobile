package com.opus_bd.stockmanagement.Utilts;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

public class Utilities {
    private static ProgressDialog progressDialog;

  /*  private Context context;

    public Utilities(Context context) {
        this.context = context;
    }*/

    public static void showLogcatMessage(String message) {
        Log.d("tag", message);
    }

    public static void showProgress(Context context) {
        progressDialog = new ProgressDialog(context);
        // Setting Message
        progressDialog.setMessage("Loading...");
        // Progress Dialog Style Spinner
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    public static void hideProgress(Context context) {
        progressDialog = new ProgressDialog(context);
        // Setting Message
        progressDialog.setMessage("Loading...");
        // Progress Dialog Style Spinner
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.hide();
    }

}
