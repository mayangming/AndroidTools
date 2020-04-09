package com.common.weight.recycleview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 基础的RecycleViewAdapter基类
 * 如果想要触发item点击事件需要重写RecycleBaseAdapter中的onBindViewHolder
 * @param <VH>
 */
public abstract class RecycleBaseAdapter<VH extends RecycleBaseViewHolder> extends RecyclerView.Adapter<VH>{

    protected RecycleItemOnClickListener recycleItemOnClickListener;

    /**
     * 该方法可以监听Item的点击事件
     * @param recycleItemOnClickListener
     */
    public void setRecycleItemOnClickListener(RecycleItemOnClickListener recycleItemOnClickListener) {
        this.recycleItemOnClickListener = recycleItemOnClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != recycleItemOnClickListener){
                    recycleItemOnClickListener.onItemClick(holder.itemView,position);
                }
            }
        });
    }
}