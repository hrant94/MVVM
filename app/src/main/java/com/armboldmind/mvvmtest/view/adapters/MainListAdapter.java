package com.armboldmind.mvvmtest.view.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.armboldmind.mvvmtest.R;
import com.armboldmind.mvvmtest.databinding.AdapterMainListItemBinding;
import com.armboldmind.mvvmtest.model.MainItemModel;

import java.util.List;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {
    private List<MainItemModel> mList;

    public MainListAdapter(List<MainItemModel> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final AdapterMainListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.adapter_main_list_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.setCategory(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final AdapterMainListItemBinding binding;
        public ViewHolder(@NonNull AdapterMainListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
