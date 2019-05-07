package com.armboldmind.mvvmtest.shared.di.components.root;

import android.content.Context;


import com.armboldmind.mvvmtest.shared.di.modules.root.AppModule;
import com.armboldmind.mvvmtest.shared.di.modules.root.NetModule;
import com.armboldmind.mvvmtest.shared.helpers.SharedPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface IAppComponent {

    Retrofit retrofit();

    OkHttpClient okHttpClient();

    Context context();

    SharedPreferencesHelper sharedPreferences();
}