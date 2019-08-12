package com.gll.gllandroidstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.utils.ConstantValue;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectYearFragment extends LibFragment {

    private RecyclerView selectYearRecyclerView;

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
    }

    @Override
    public void setClickListener(View view) {

    }
}
