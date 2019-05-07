package com.armboldmind.mvvmtest.shared.di.modules;


import com.armboldmind.mvvmtest.shared.data.remote.api.IMainService;
import com.armboldmind.mvvmtest.shared.di.scopes.MainScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    @Provides
    @MainScope
    IMainService providesIMainService(Retrofit retrofit) {
        return retrofit.create(IMainService.class);
    }
}