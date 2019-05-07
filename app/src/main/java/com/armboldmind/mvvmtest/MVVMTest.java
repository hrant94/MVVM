package com.armboldmind.mvvmtest;

import androidx.multidex.MultiDexApplication;

import com.armboldmind.mvvmtest.shared.di.components.DaggerIMainComponent;
import com.armboldmind.mvvmtest.shared.di.components.IMainComponent;
import com.armboldmind.mvvmtest.shared.di.components.root.DaggerIAppComponent;
import com.armboldmind.mvvmtest.shared.di.components.root.IAppComponent;
import com.armboldmind.mvvmtest.shared.di.modules.MainModule;
import com.armboldmind.mvvmtest.shared.di.modules.root.AppModule;
import com.armboldmind.mvvmtest.shared.di.modules.root.NetModule;

public class MVVMTest extends MultiDexApplication {
    private IAppComponent mAppComponent;
    private IMainComponent mMainComponent;
    private static MVVMTest mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule())
                .build();
        mInstance = this;
    }

    public static synchronized MVVMTest getInstance() {
        return mInstance;
    }

    public IMainComponent getMainComponent() {
        mMainComponent = DaggerIMainComponent.builder()
                .iAppComponent(mAppComponent)
                .mainModule(new MainModule())
                .build();
        return mMainComponent;
    }

    public void releaseMainComponent() {
        mMainComponent = null;
    }

}
