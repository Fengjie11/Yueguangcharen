package com.yueguang.main_interface.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by FengJIe on 2017/2/15.
 */

public class DiscountRecycleView extends RecyclerView.Adapter<DiscountRecycleView.MyViewHolder> {

    @Override
    public DiscountRecycleView.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;

    }

    @Override
    public void onBindViewHolder(DiscountRecycleView.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
