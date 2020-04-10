package com.common.weight.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 基础的RecycleViewAdapter基类
 * 如果想要触发item点击事件需要重写RecycleBaseAdapter中的onBindViewHolder
 * @param <VH>
 */
public abstract class RecycleBaseAdapter<VH extends RecycleBaseViewHolder> extends RecyclerView.Adapter<VH>{
    protected Context context;
    protected LayoutInflater layoutInflater;
    protected RecycleItemOnClickListener recycleItemOnClickListener;

    /**
     * 该方法可以监听Item的点击事件
     * @param recycleItemOnClickListener
     */
    public void setRecycleItemOnClickListener(RecycleItemOnClickListener recycleItemOnClickListener) {
        this.recycleItemOnClickListener = recycleItemOnClickListener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (null == context){
            context = parent.getContext();
        }

        if (null == layoutInflater){
            layoutInflater = LayoutInflater.from(context);
        }

        return null;
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