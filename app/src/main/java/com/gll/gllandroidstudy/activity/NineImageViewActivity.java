package com.gll.gllandroidstudy.activity;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.NineGridViewImageAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.model.NineImageList;
import com.gll.gllandroidstudy.utils.BarUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NineImageViewActivity extends BaseActivity {


    private RecyclerView recyclerView;
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
        recyclerView = get(R.id.recyclerView);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        List<NineImageList> nineImageLists = new ArrayList<>();

        nineImageLists.add(new NineImageList("开水白菜", Arrays.asList(
                "https://pic3.zhimg.com/d1750bd47b514ad62af9497bbe5bb17e_xll.jpg"
        )));
        nineImageLists.add(new NineImageList("百岁山", Arrays.asList(
                "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
                "https://pic1.zhimg.com/76903410e4831571e19a10f39717988c_xll.png",
                "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg"
        )));
        nineImageLists.add(new NineImageList("百岁山", Arrays.asList(
                "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
                "https://pic1.zhimg.com/76903410e4831571e19a10f39717988c_xll.png",
                "https://pic1.zhimg.com/76903410e4831571e19a10f39717988c_xll.png",
                "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg"
        )));
        nineImageLists.add(new NineImageList("农夫山泉", Arrays.asList(
                "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg",
                "https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png",
                "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
                "https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg",
                "https://pic3.zhimg.com/f6dc1c1cecd7ba8f4c61c7c31847773e_xll.jpg"
        )));
        nineImageLists.add(new NineImageList("农夫山泉", Arrays.asList(
                "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg",
                "https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png",
                "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
                "https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg",
                "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
                "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg",
                "https://pic3.zhimg.com/f6dc1c1cecd7ba8f4c61c7c31847773e_xll.jpg"
        )));
        nineImageLists.add(new NineImageList("娃哈哈", Arrays.asList(
                "https://pic3.zhimg.com/33c6cf59163b3f17ca0c091a5c0d9272_xll.jpg",
                "https://pic4.zhimg.com/52e093cbf96fd0d027136baf9b5cdcb3_xll.png",
                "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
                "https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg",
                "https://pic3.zhimg.com/f6dc1c1cecd7ba8f4c61c7c31847773e_xll.jpg",
                "https://pic4.zhimg.com/fc04224598878080115ba387846eabc3_xll.jpg",
                "https://pic3.zhimg.com/d1750bd47b514ad62af9497bbe5bb17e_xll.jpg",
                "https://pic4.zhimg.com/da52c865cb6a472c3624a78490d9a3b7_xll.jpg",
                "https://pic3.zhimg.com/0c149770fc2e16f4a89e6fc479272946_xll.jpg"
        )));

        nineGridViewImageAdapter = new NineGridViewImageAdapter(nineImageLists, mContext);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(nineGridViewImageAdapter);
    }

    @Override
    protected void setListener() {

    }
}
