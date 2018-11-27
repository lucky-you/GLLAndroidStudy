package com.gll.gllandroidstudy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.SelectMouthAndDayDateAdapter;
import com.gll.gllandroidstudy.model.YearAndMouthBean;
import com.gll.gllandroidstudy.utils.ConstantValue;
import com.gll.gllandroidstudy.view.LineGridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * author      : Z_B
 * date       : 2018/11/27
 * function  :
 */
public class SelectYearDateFragment extends LibFragment {

    private int classType;
    private LineGridView publicRecyclerView;
    private SelectMouthAndDayDateAdapter selectMouthAndDayDateAdapter;

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
        publicRecyclerView = get(R.id.publicRecyclerView);
        classType = getArguments().getInt(ConstantValue.TYPE, -1);

        Map<String, List<String>> YearDateMap = new HashMap<>();

        List<String> calendarsYearList = new ArrayList<>();
        for (int i = 1919; i < 2000; i++) {
            if (i < 1920) {
                calendarsYearList.add(i + "");
                YearDateMap.put("10后", calendarsYearList);
            } else if (1920 <= i && i < 1930) {
                calendarsYearList.add(i + "");
                YearDateMap.put("20后", calendarsYearList);
            } else if (1930 <= i && i < 1940) {
                calendarsYearList.add(i + "");
                YearDateMap.put("30后", calendarsYearList);
            } else if (1940 <= i && i < 1950) {
                calendarsYearList.add(i + "");
                YearDateMap.put("40后", calendarsYearList);
            } else if (1950 <= i && i < 1960) {
                calendarsYearList.add(i + "");
                YearDateMap.put("50后", calendarsYearList);
            } else if (1960 <= i && i < 1970) {
                calendarsYearList.add(i + "");
                YearDateMap.put("60后", calendarsYearList);
            } else if (1970 <= i && i < 1980) {
                calendarsYearList.add(i + "");
                YearDateMap.put("70后", calendarsYearList);
            } else if (1980 <= i && i < 1990) {
                calendarsYearList.add(i + "");
                YearDateMap.put("80后", calendarsYearList);
            } else if (1990 <= i && i < 2000) {
                calendarsYearList.add(i + "");
                YearDateMap.put("90后", calendarsYearList);
            }
        }
        List<YearAndMouthBean> yearStrList = new ArrayList<>();
        Iterator<Map.Entry<String, List<String>>> iterator = YearDateMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            String keyList = entry.getKey();
            String valueList = entry.getKey();
            yearStrList.add(new YearAndMouthBean(keyList, valueList));
        }
    }

    @Override
    public void processLogic(Bundle savedInstanceState) {
        switch (classType) {
            case 1:
                List<YearAndMouthBean> yearAndMouthBeans = new ArrayList<>();
                for (int i = 1; i < 13; i++) {
                    yearAndMouthBeans.add(new YearAndMouthBean("", i + ""));
                }
                selectMouthAndDayDateAdapter = new SelectMouthAndDayDateAdapter(mContext, yearAndMouthBeans);
                publicRecyclerView.setAdapter(selectMouthAndDayDateAdapter);
                break;
            case 2:
                List<YearAndMouthBean> yearAndMouthBeansList = new ArrayList<>();
                for (int i = 1; i < 32; i++) {
                    yearAndMouthBeansList.add(new YearAndMouthBean("", i + ""));
                }
                selectMouthAndDayDateAdapter = new SelectMouthAndDayDateAdapter(mContext, yearAndMouthBeansList);
                publicRecyclerView.setAdapter(selectMouthAndDayDateAdapter);
                break;

            default:

                break;

        }

    }

    @Override
    public void setClickListener(View view) {

    }
}
