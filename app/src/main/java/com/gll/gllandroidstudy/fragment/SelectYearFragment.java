package com.gll.gllandroidstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.SelectYearDateAdapter;
import com.gll.gllandroidstudy.model.SelectYearDateList;
import com.gll.gllandroidstudy.model.YearAndMouthBean;
import com.gll.gllandroidstudy.utils.ConstantValue;
import com.gll.gllandroidstudy.widget.DivideLineItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectYearFragment extends LibFragment {

    private RecyclerView selectYearRecyclerView;
    private SelectYearDateAdapter selectYearDateAdapter;

    public static SelectYearFragment newInstance(int type) {
        SelectYearFragment selectYearDateFragment = new SelectYearFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ConstantValue.TYPE, type);
        selectYearDateFragment.setArguments(bundle);
        return selectYearDateFragment;
    }

    @Override
    public void initData(@Nullable Bundle bundle) {

    }

    @Override
    public int loadViewLayout() {
        return R.layout.include_select_year_fragment_layout;
    }

    @Override
    public void bindViews(View contentView) {
        selectYearRecyclerView = get(R.id.selectYearRecyclerView);
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {
        List<SelectYearDateList> selectYearDateLists = new ArrayList<>();
        List<YearAndMouthBean> calendarsYearList = new ArrayList<>();
        for (int i = 1919; i < 2000; i++) {
            if (i < 1920) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("10后", calendarsYearList));
            } else if (1920 <= i && i < 1930) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("20后", calendarsYearList));
            } else if (1930 <= i && i < 1940) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("30后", calendarsYearList));
            } else if (1940 <= i && i < 1950) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("40后", calendarsYearList));
            } else if (1950 <= i && i < 1960) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("50后", calendarsYearList));
            } else if (1960 <= i && i < 1970) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("60后", calendarsYearList));
            } else if (1970 <= i && i < 1980) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("70后", calendarsYearList));
            } else if (1980 <= i && i < 1990) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("80后", calendarsYearList));
            } else if (1990 <= i && i < 2000) {
                calendarsYearList.add(new YearAndMouthBean("", "" + i));
                selectYearDateLists.add(new SelectYearDateList("90后", calendarsYearList));
            }
        }
        selectYearDateAdapter = new SelectYearDateAdapter(selectYearDateLists);
        selectYearRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        selectYearRecyclerView.setAdapter(selectYearDateAdapter);
    }

    @Override
    public void setClickListener(View view) {

    }
}
