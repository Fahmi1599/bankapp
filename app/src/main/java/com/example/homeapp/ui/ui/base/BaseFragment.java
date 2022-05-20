package com.example.homeapp.ui.ui.base;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.homeapp.ui.utils.CommonUtils;


public abstract class BaseFragment extends Fragment implements BaseContract.View {

    private BaseActivity mActivity;

    private ProgressDialog mProgressDialog;
    private Dialog dialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showErrorMessage(String error) {
        if (mActivity != null) {
            mActivity.showMessage(error);
        }
    }

    @Override
    public void showErrorDialog() {
        hideLoading();
        dialog = CommonUtils.showErrorDialog(this.getContext());
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this.getContext());
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

    public void showModalBox(String title, String message,String textPositive, String textNegative, DialogInterface.OnClickListener onPositive) {
        AlertDialog.Builder alert = new AlertDialog.Builder(mActivity);
        alert.setTitle(title);
        alert.setMessage(message);

        alert.setPositiveButton(textPositive, onPositive);

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }
}
