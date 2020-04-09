package com.common.weight.recycleview;

import android.view.View;

/**
 * RecycleView的列表的点击事件
 * 如果想要触发item点击事件需要重写RecycleBaseAdapter中的onBindViewHolder
 */
public interface RecycleItemOnClickListener {
    void onItemClick(View view, int position);
}