package com.gll.gllandroidstudy.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.NineGridViewImageAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.nineimage.NineHeightWrapGridView;
import com.gll.gllandroidstudy.utils.BarUtils;

import java.util.ArrayList;
import java.util.List;

public class NineImageViewActivity extends BaseActivity {


    private NineHeightWrapGridView nineGridView;
    private NineGridViewImageAdapter nineGridViewImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_nine_image_view);
    }

    @Override
    protected void bindViews() {
        initTitle("九宫格图片显示");
        BarUtils.addMarginTopEqualStatusBarHeight(get(R.id.ll_root_layout));
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
        nineGridView = get(R.id.nineGridView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<String> userImageList = new ArrayList<>();
        userImageList.add("http://pj94obnsr.bkt.clouddn.com//miyue/uploads/1544147531912");
        userImageList.add("http://pj94obnsr.bkt.clouddn.com//miyue/uploads/1544147531868");
        userImageList.add("http://pj94obnsr.bkt.clouddn.com//miyue/uploads/1544147531907");
        userImageList.add("http://pj94obnsr.bkt.clouddn.com//miyue/uploads/1544147531900");
//        nineGridViewImageAdapter = new NineGridViewImageAdapter(userImageList, R.layout.include_nine_image_item_view);
//        nineGridView.setAdapter(nineGridViewImageAdapter);
    }

    @Override
    protected void setListener() {

    }
}
