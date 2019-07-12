package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.gll.gllandroidstudy.Index.CityItemMessage;
import com.gll.gllandroidstudy.Index.IndexBar;
import com.gll.gllandroidstudy.Index.IndexSideBarView;
import com.gll.gllandroidstudy.Index.OnTouchingLetterChangedListener;
import com.gll.gllandroidstudy.Index.SideBarSortMode;
import com.gll.gllandroidstudy.Index.SideBarSortUtils;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.IndexBarListAdapter;
import com.gll.gllandroidstudy.adapter.RightIndexListAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 右侧字母快速索引
 */
public class RightIndexBarActivity extends BaseActivity {
    private RecyclerView cityRecyclerView;
    private TextView txtTip;
    private IndexBar sideBar;
    private SideBarSortMode sideBarSortMode = new SideBarSortMode();
    private RightIndexListAdapter rightIndexListAdapter;
    private IndexBarListAdapter indexBarListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<CityItemMessage> cityItemList = new ArrayList<>();

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_right_index_bar);
    }

    @Override
    protected void bindViews() {
        initTitle("右侧字母快速索引");
        cityRecyclerView = get(R.id.cityRecyclerView);
        txtTip = get(R.id.txtTip);
        sideBar = get(R.id.sideBar);

        sideBar.setSelectedIndexTextView(txtTip);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {


//        rightIndexListAdapter = new RightIndexListAdapter(sideBarSortMode);
//        linearLayoutManager = new LinearLayoutManager(mContext);
//        cityRecyclerView.setLayoutManager(linearLayoutManager);
//        cityRecyclerView.setAdapter(rightIndexListAdapter);


//        sideBarSortMode.setSourceDateList(getCityList());
//        rightIndexListAdapter.setNewData(getCityList());


        SideBarSortUtils sideBarSortUtils = new SideBarSortUtils();
        Map<String, Object> cityList = sideBarSortUtils.setSourceDateList(getCityList());
        Log.e("xy", "cityListSize=" + cityList.size());
        if (cityList != null && !cityList.isEmpty()) {
            cityItemList.clear();
            cityItemList.addAll((List<CityItemMessage>) cityList.get("sortList"));
            Object[] keys = (Object[]) cityList.get("keys");
            String[] letters = new String[keys.length];
            for (int i = 0; i < keys.length; i++) {
                letters[i] = keys[i].toString();
            }
            sideBar.setIndexs(letters);
        }

        Log.e("xy", "cityItemListSize=" + cityItemList.size());
        indexBarListAdapter = new IndexBarListAdapter(mContext, cityItemList);
        linearLayoutManager = new LinearLayoutManager(mContext);
        cityRecyclerView.setLayoutManager(linearLayoutManager);
        cityRecyclerView.setAdapter(indexBarListAdapter);

    }

    @Override
    protected void setListener() {
        sideBar.setOnIndexChangedListener(new IndexBar.OnIndexChangedListener() {
            @Override
            public void onIndexChanged(String index) {
                for (int i = 0; i < cityItemList.size(); i++) {
                    String firstWord = cityItemList.get(i).getFirstWord();
                    if (index.equals(firstWord)) {
                        // 滚动列表到指定的位置
                        linearLayoutManager.scrollToPositionWithOffset(i, 0);
                        return;
                    }
                }
            }
        });
    }

    private List<CityItemMessage> getCityList() {
        List<CityItemMessage> CityListData = new ArrayList<>();
        CityListData.add(new CityItemMessage("0", "北京"));
        CityListData.add(new CityItemMessage("1", "上海"));
        CityListData.add(new CityItemMessage("2", "广州"));
        CityListData.add(new CityItemMessage("3", "深圳"));
        CityListData.add(new CityItemMessage("4", "武汉"));
        CityListData.add(new CityItemMessage("5", "成都"));
        CityListData.add(new CityItemMessage("6", "天津"));
        CityListData.add(new CityItemMessage("7", "沈阳"));
        CityListData.add(new CityItemMessage("8", "兰州"));
        CityListData.add(new CityItemMessage("9", "杭州"));
        CityListData.add(new CityItemMessage("10", "福州"));
        CityListData.add(new CityItemMessage("11", "桂林"));
        CityListData.add(new CityItemMessage("12", "包头"));
        CityListData.add(new CityItemMessage("13", "武穴"));
        CityListData.add(new CityItemMessage("14", "黄石"));
        CityListData.add(new CityItemMessage("15", "阿拉善"));
        CityListData.add(new CityItemMessage("16", "上饶"));
        CityListData.add(new CityItemMessage("17", "长春"));
        CityListData.add(new CityItemMessage("18", "哈尔滨"));
        CityListData.add(new CityItemMessage("19", "佳木斯"));
        CityListData.add(new CityItemMessage("20", "宜昌"));
        CityListData.add(new CityItemMessage("21", "襄阳"));
        CityListData.add(new CityItemMessage("22", "十堰"));
        CityListData.add(new CityItemMessage("23", "鄂尔多斯"));
        CityListData.add(new CityItemMessage("24", "锦州"));
        CityListData.add(new CityItemMessage("25", "亳州"));
        CityListData.add(new CityItemMessage("26", "潜江"));
        CityListData.add(new CityItemMessage("27", "天门"));
        CityListData.add(new CityItemMessage("28", "葫芦岛"));
        CityListData.add(new CityItemMessage("29", "大连"));
        CityListData.add(new CityItemMessage("30", "拉萨"));
        CityListData.add(new CityItemMessage("31", "sasVdSGas"));
        CityListData.add(new CityItemMessage("32", "2154564"));
        CityListData.add(new CityItemMessage("33", "1445455"));
        CityListData.add(new CityItemMessage("34", "DadjkcdjS"));
        CityListData.add(new CityItemMessage("35", "六安"));
        return CityListData;
    }
}
