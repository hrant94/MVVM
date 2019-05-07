package com.armboldmind.mvvmtest.view.activities.mainActivity.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.armboldmind.mvvmtest.R;
import com.armboldmind.mvvmtest.databinding.FragmentMainBinding;
import com.armboldmind.mvvmtest.model.MainItemModel;
import com.armboldmind.mvvmtest.model.MainListItemModel;
import com.armboldmind.mvvmtest.view.activities.BaseFragment;
import com.armboldmind.mvvmtest.view.adapters.MainListAdapter;
import com.armboldmind.mvvmtest.viewModel.MainViewModel;

import java.util.List;

public class MainFragment extends BaseFragment {
    private FragmentMainBinding mBinding;
    private MainViewModel mViewModel;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        initViews();
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel.getLiveData().observe(this, mainListItemModels -> {
            mBinding.mainRecyclerView.setAdapter(new MainListAdapter(mainListItemModels));
            mBinding.mainLoading.setVisibility(View.GONE);
        });

        mViewModel.searchInList();
    }

    private void initViews() {
        mBinding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }

}
