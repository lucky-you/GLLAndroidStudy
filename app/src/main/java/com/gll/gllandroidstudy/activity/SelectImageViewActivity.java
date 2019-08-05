package com.gll.gllandroidstudy.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.PieItemBean;
import com.gll.gllandroidstudy.view.CircleProgressView;
import com.gll.gllandroidstudy.view.LineChartView;
import com.gll.gllandroidstudy.view.PieChartView;

import java.util.ArrayList;
import java.util.List;

/**
 * 选择图片
 */
public class SelectImageViewActivity extends BaseActivity {

    private CircleProgressView circleProgressView;

    private LineChartView mLineChartView;
    private int[] shadeColors;

    private PieChartView pieChartView;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_select_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义图表");

        circleProgressView = get(R.id.circleProgressView);

        mLineChartView = get(R.id.mLineChartView);

        pieChartView = get(R.id.pieChartView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        circleProgressView.setMaxProgress(100);
        circleProgressView.setProgress(62);
        circleProgressView.setTextColor(mContext.getResources().getColor(R.color.red_color_df4c56));
        circleProgressView.setTextSize(15);
        circleProgressView.setText("62%");
        circleProgressView.setShowText(true);

        shadeColors = new int[]{
                Color.argb(100, 255, 86, 86),
                Color.argb(15, 255, 86, 86),
                Color.argb(0, 255, 86, 86)};
        //  设置折线数据
        mLineChartView.setItems(getItemList());
        //  设置渐变颜色
        mLineChartView.setShadeColors(shadeColors);
        //  开启动画
        mLineChartView.startAnim(mLineChartView, 2000);

        pieChartView.setPieData(getInitData());
        pieChartView.startAnim();
        pieChartView.setText("总支出");

    }

    private List<LineChartView.ItemBean> getItemList() {
        List<LineChartView.ItemBean> mItems = new ArrayList<>();
        mItems.add(new LineChartView.ItemBean(1489507200, 23));
        mItems.add(new LineChartView.ItemBean(1489593600, 78));
        mItems.add(new LineChartView.ItemBean(1489680000, 60));
        mItems.add(new LineChartView.ItemBean(1489766400, 52));
        mItems.add(new LineChartView.ItemBean(1489852800, 40));
        mItems.add(new LineChartView.ItemBean(1489939200, 10));
        mItems.add(new LineChartView.ItemBean(1490025600, 33));
        mItems.add(new LineChartView.ItemBean(1490112000, 44));
        mItems.add(new LineChartView.ItemBean(1490198400, 95));
        mItems.add(new LineChartView.ItemBean(1490284800, 17));
        return mItems;
    }

    @Override
    protected void setListener() {

    }

    private List<PieItemBean> getInitData() {
        List<PieItemBean> mList = new ArrayList<>();
        String cArray[] = {"#FF5656", "#FFAE66", "#FF9BA4", "#519FFC", "#E15798", "#25CECB"};
        mList.add(new PieItemBean("股票", Color.parseColor(cArray[0]), 60));
        mList.add(new PieItemBean("债券", Color.parseColor(cArray[1]), 20));
        mList.add(new PieItemBean("活期", Color.parseColor(cArray[2]), 120));
        mList.add(new PieItemBean("定期", Color.parseColor(cArray[3]), 70));
        mList.add(new PieItemBean("商品", Color.parseColor(cArray[4]), 90));
        return mList;
    }

}
