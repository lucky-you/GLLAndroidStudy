package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.BaseRecyclerViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.base.BaseApplication;
import com.gll.gllandroidstudy.base.rv.listener.OnItemClickListener;
import com.gll.gllandroidstudy.model.RecyclerViewList;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.widget.DivideLineItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends BaseActivity {

    private RecyclerView publicRecyclerView;
    private BaseRecyclerViewAdapter baseRecyclerViewAdapter;
    private List<RecyclerViewList> RecyclerViewList = new ArrayList<>();

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_base_recycler_view_adapter);
    }

    @Override
    protected void bindViews() {
        initTitle("RecyclerViewAdapter");
        publicRecyclerView = get(R.id.publicRecyclerView);
        LinearLayout llRootLayout = get(R.id.ll_root_layout);
        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);
        BarUtils.setStatusBarColor(this, ContextCompat.getColor(BaseApplication.getInstance(), R.color.colorPrimary), 0);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        baseRecyclerViewAdapter = new BaseRecyclerViewAdapter(getViewListDate(), R.layout.include_simple_item_view_layout);
        publicRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        publicRecyclerView.addItemDecoration(new DivideLineItemDecoration(mContext, mContext.getResources().getColor(R.color.color_f3f3f3), 1));
        publicRecyclerView.setAdapter(baseRecyclerViewAdapter);

        View headerView = View.inflate(mContext, R.layout.include_recyclerview_header_layout, null);
        View footView = View.inflate(mContext, R.layout.include_recyclerview_footer_layout, null);

        baseRecyclerViewAdapter.setHeaderView(headerView);
        baseRecyclerViewAdapter.setFooterView(footView);

        baseRecyclerViewAdapter.setOnItemClickListener((view, position) -> showToast("点击了=" + position));


    }


    private List<RecyclerViewList> getViewListDate() {
        List<RecyclerViewList> RecyclerViewList = new ArrayList<>();
        RecyclerViewList.add(new RecyclerViewList("一举一动，都是承诺，会被另一个人看在眼里，记在心上的", "2019-05-14"));
        RecyclerViewList.add(new RecyclerViewList("当时年少春衫薄,骑马倚斜桥,满楼红袖招", "2018-12-16"));
        RecyclerViewList.add(new RecyclerViewList("愿漂泊的人都有酒喝，愿孤独的人都能放歌", "2019-03-24"));
        RecyclerViewList.add(new RecyclerViewList("怀旧，不是因为那个时代多么好，而是那个时候，你年轻。", "2018-11-16"));
        RecyclerViewList.add(new RecyclerViewList("最好的人：像孩子一样，真诚。像夕阳一样，温暖。像天空一样，宁静。", "2019-01-12"));
        RecyclerViewList.add(new RecyclerViewList("我在半山腰等你，我在河中央爱你，你却在尘埃里", "2019-04-17"));
        RecyclerViewList.add(new RecyclerViewList("成长是一种蜕变，失去了旧的，必然因为又来了新的，这就是公平。", "2019-03-16"));
        RecyclerViewList.add(new RecyclerViewList("从来没有人读书，只有人在书中读自己，发现自己或检查自己。", "2019-03-23"));
        RecyclerViewList.add(new RecyclerViewList("你脚踩的地狱只是天堂的倒影,我唇角的故事也是时间的灰烬", "2019-02-27"));
        RecyclerViewList.add(new RecyclerViewList("十年生死两茫茫，不思量，自难忘，千里孤坟，无处话凄凉", "2019-05-07"));
        return RecyclerViewList;
    }

    @Override
    protected void setListener() {

    }
}
