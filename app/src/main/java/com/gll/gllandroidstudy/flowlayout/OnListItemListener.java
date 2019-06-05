package com.gll.gllandroidstudy.flowlayout;

/**
 * author      : Z_B
 * date       : 2019/6/5
 * function  :
 */
public interface OnListItemListener<T> {


    /**
     * 点击
     * @param position
     * @param model
     * @param tag
     */
    void onItemClick(int position, T model, int tag);

    /**
     * 长按
     * @param position
     * @param model
     * @param tag
     */
    void onItemLongClick(int position, T model, int tag);
}
