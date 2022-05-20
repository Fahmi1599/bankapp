package com.example.homeapp.ui.ui.base;

/**
 * List Function for Base Activity
 * Created by ShareHub
 * October 17th 2019
 *
 * Other related UI Class
 *
 *
 */

public interface BaseContract {
    interface View {
        void showMessage(String message);

        void showErrorMessage(String error);

        void showErrorDialog();

        void showLoading();

        void hideLoading();

        void hideKeyboard();

    }

    interface Presenter {
        void datePicker(int id);
    }
}
