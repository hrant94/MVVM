package com.armboldmind.mvvmtest.shared.data.remote.api;

import androidx.lifecycle.LiveData;

import com.armboldmind.mvvmtest.model.ListResponseModel;
import com.armboldmind.mvvmtest.model.MainListItemModel;
import com.armboldmind.mvvmtest.model.requestModels.ResponseModel;
import com.armboldmind.mvvmtest.shared.data.remote.networking.ApiResponse;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IMainService {
    @GET("api/Category/GetList/{searchString}")
    Flowable<ResponseModel<List<MainListItemModel>>> getList(@Path("searchString") String searchString);

    @GET("api/Cuisine/GetHomeList")
    LiveData<ApiResponse<ResponseModel<ListResponseModel>>> getList();
}