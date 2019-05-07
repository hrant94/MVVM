package com.armboldmind.mvvmtest.view.activities.mainActivity;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.armboldmind.mvvmtest.R;
import com.armboldmind.mvvmtest.databinding.ActivityMainBinding;
import com.armboldmind.mvvmtest.view.activities.BaseActivity;
import com.armboldmind.mvvmtest.view.activities.mainActivity.fragments.MainFragment;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        loadMainFragment();
    }

    private void loadMainFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(mViewBinding.fragmentContainer.getId(), new MainFragment())
                .commit();
    }
}
