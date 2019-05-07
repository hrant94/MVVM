package com.armboldmind.mvvmtest.view.activities;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment implements IBaseView {

    private BaseActivity baseActivity;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.baseActivity = (BaseActivity) context;
            //context.onFragmentAttached()
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, Integer requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                || baseActivity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (baseActivity != null) {
            baseActivity.openActivityOnTokenExpire();
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (baseActivity != null) {
            baseActivity.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (baseActivity != null) {
            baseActivity.onError(message);
        }
    }

    @Override
    public void showMessage(String message) {
        if (baseActivity != null) {
            baseActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (baseActivity != null) {
            baseActivity.showMessage(resId);
        }
    }

    @Override
    public void setLightStatusBar() {
        if (baseActivity != null) {
            baseActivity.setLightStatusBar();
        }
    }

    /*@Override
    public void showLoadingDialog() {
        baseActivity.showLoadingDialog();
    }

    @Override
    public void hideLoadingDialog() {
        baseActivity.hideLoadingDialog();
    }*/
}
