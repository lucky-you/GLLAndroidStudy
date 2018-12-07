package com.gll.gllandroidstudy.adapter;

import com.gll.gllandroidstudy.base.rv.BaseViewHolder;
import com.gll.gllandroidstudy.base.rv.adapter.SimpleAdapter;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/12/7
 * function  :
 */
public class NineGridViewImageAdapter extends SimpleAdapter<String> {
    public NineGridViewImageAdapter(List<String> list, int layoutId) {
        super(list, layoutId);
    }

    @Override
    protected void bind(BaseViewHolder holder, String data) {

    }
//    public NineGridViewImageAdapter(@Nullable List<String> data) {
//        super(R.layout.include_nine_image_item_view,data);
//    }

}
