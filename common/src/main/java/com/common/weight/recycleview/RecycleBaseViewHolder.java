package com.common.weight.recycleview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 抽象的RecycleBaseViewHolder类
 */
public abstract class RecycleBaseViewHolder extends RecyclerView.ViewHolder{

    public RecycleBaseViewHolder(@NonNull View itemView) {
        super(itemView);
        initView();
    }

    private void initView(){
    }
}