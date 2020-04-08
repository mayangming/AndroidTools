package com.common.weight.recycleview;

import android.view.View;

/**
 * RecycleView的列表的点击事件
 */
public interface RecycleItemOnClickListener {
    void onItemClick(View view, int position);
}