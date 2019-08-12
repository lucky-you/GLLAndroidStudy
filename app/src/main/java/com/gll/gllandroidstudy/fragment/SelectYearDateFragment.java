package com.gll.gllandroidstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.utils.ConstantValue;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectYearDateFragment extends LibFragment {


    public static SelectYearDateFragment newInstance(int type) {
        SelectYearDateFragment selectYearDateFragment = new SelectYearDateFragment();
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
        return R.layout.include_select_fragment_layout;
    }

    @Override
    public void bindViews(View contentView) {

    }

    @Override
    public void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void setClickListener(View view) {

    }
}
