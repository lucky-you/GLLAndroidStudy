package com.gll.gllandroidstudy.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.model.SelectYearDateList;
import com.gll.gllandroidstudy.view.LineGridView;

import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectYearDateAdapter extends BaseQuickAdapter<SelectYearDateList, BaseViewHolder> {
    public SelectYearDateAdapter(@Nullable List<SelectYearDateList> data) {
        super(R.layout.include_select_year_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectYearDateList item) {
        helper.setText(R.id.tvYearLeft, item.getYearList());
        LineGridView lineGridView = helper.getView(R.id.yearRightGridView);
        SelectMouthAndDayDateAdapter selectMouthAndDayDateAdapter = new SelectMouthAndDayDateAdapter(mContext, item.getYearAndMouthBeans());
        lineGridView.setAdapter(selectMouthAndDayDateAdapter);

    }
}
