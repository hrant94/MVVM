package com.armboldmind.mvvmtest.view.activities;

import androidx.annotation.StringRes;

public interface IBaseView {
    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    void setLightStatusBar();

    /*void showLoadingDialog();

    void hideLoadingDialog();*/

}
