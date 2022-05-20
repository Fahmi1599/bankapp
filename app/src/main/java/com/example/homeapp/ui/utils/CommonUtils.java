package com.example.homeapp.ui.utils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;

import com.example.homeapp.R;

public class CommonUtils {

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.show();

        if (progressDialog.getWindow() != null) {
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        progressDialog.setContentView(R.layout.dialog_loading);
        progressDialog.setIndeterminate(true);
//        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }

    public static Dialog showErrorDialog(Context context) {
        Dialog dialog = new Dialog(context, R.style.AppTheme);
        dialog.show();

        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }

        dialog.setContentView(R.layout.error_dialog);
//        progressDialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);


        TextView tvError = dialog.findViewById(R.id.error_tv);

        return dialog;
    }
}
