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
//        List<SelectYearDateList> selectYearDateLists = new ArrayList<>();
//        List<YearAndMouthBean> calendarsYearList = new ArrayList<>();
//        selectYearDateAdapter = new SelectYearDateAdapter(selectYearDateLists);
//        selectYearRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        selectYearRecyclerView.setAdapter(selectYearDateAdapter);
    }

    @Override
    public void setClickListener(View view) {

    }
}
