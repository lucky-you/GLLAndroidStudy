package com.gll.gllandroidstudy.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gll.gllandroidstudy.Index.CityItemMessage;
import com.gll.gllandroidstudy.Index.SideBarSortMode;
import com.gll.gllandroidstudy.R;

/**
 * Created by : Z_B on 2019/7/12.
 * describe：
 */
public class RightIndexListAdapter extends BaseQuickAdapter<CityItemMessage, BaseViewHolder> {

    private SideBarSortMode sideBarSortMode;

    public RightIndexListAdapter(SideBarSortMode sideBarSortMode) {
        super(R.layout.include_city_item_view);
        this.sideBarSortMode = sideBarSortMode;
    }

    @Override
    protected void convert(BaseViewHolder helper, CityItemMessage item) {
        String sortLetterTitle = sideBarSortMode.getSortLetterTitle(helper.getLayoutPosition() - getHeaderLayoutCount());
        helper.setText(R.id.txtCityInitial, sortLetterTitle);
        helper.setText(R.id.txtCityName, item.getName());
        helper.setGone(R.id.txtCityInitial, sortLetterTitle != null);
    }
}
