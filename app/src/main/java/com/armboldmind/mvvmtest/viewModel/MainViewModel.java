package com.armboldmind.mvvmtest.viewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.armboldmind.mvvmtest.MVVMTest;
import com.armboldmind.mvvmtest.model.ListResponseModel;
import com.armboldmind.mvvmtest.model.MainItemModel;
import com.armboldmind.mvvmtest.model.requestModels.ResponseModel;
import com.armboldmind.mvvmtest.shared.data.remote.api.IMainService;
import com.armboldmind.mvvmtest.shared.data.remote.networking.ApiResponse;
import com.armboldmind.mvvmtest.shared.di.scopes.MainScope;

import java.util.List;

import javax.inject.Inject;

@MainScope
public class MainViewModel extends AndroidViewModel {

    @Inject
    IMainService mMainService;

    public MainViewModel(@NonNull Application application) {
        super(application);
        ((MVVMTest) application).getMainComponent().inject(this);
    }

    private final MediatorLiveData<List<MainItemModel>> liveData = new MediatorLiveData<>();

    public LiveData<List<MainItemModel>> getLiveData() {
        return liveData;
    }

    public void searchInList() {
        LiveData<ApiResponse<ResponseModel<ListResponseModel>>> sourceLiveData = mMainService.getList();
        liveData.addSource(sourceLiveData, listResponseModelResponseModel -> {
            if (listResponseModelResponseModel.isSuccessful() && listResponseModelResponseModel.body != null) {
                liveData.setValue(listResponseModelResponseModel.body.getData().getCuisines());
                liveData.removeSource(sourceLiveData);
            } else
                Toast.makeText(MVVMTest.getInstance().getBaseContext(), "", Toast.LENGTH_SHORT).show();
        });

    }

}
