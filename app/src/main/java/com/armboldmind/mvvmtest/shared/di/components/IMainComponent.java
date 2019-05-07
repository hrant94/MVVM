package com.armboldmind.mvvmtest.shared.di.components;

import com.armboldmind.mvvmtest.shared.di.components.root.IAppComponent;
import com.armboldmind.mvvmtest.shared.di.modules.MainModule;
import com.armboldmind.mvvmtest.shared.di.scopes.MainScope;
import com.armboldmind.mvvmtest.viewModel.MainViewModel;

import dagger.Component;

@MainScope
@Component(dependencies = {IAppComponent.class}, modules = {MainModule.class})
public interface IMainComponent {

    void inject(MainViewModel mainViewModel);
}