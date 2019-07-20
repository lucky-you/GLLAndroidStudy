package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.find.SectionBanner;
import com.gll.gllandroidstudy.find.SectionColumnList;
import com.gll.gllandroidstudy.find.SectionMessageList;
import com.gll.gllandroidstudy.model.ColumnList;
import com.gll.gllandroidstudy.model.RecyclerViewList;
import com.gll.gllandroidstudy.section.SectionedRVAdapter;
import com.gll.gllandroidstudy.utils.DateImageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * SectionedRV的使用
 */
public class BottomTabActivity extends BaseActivity {

    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    private SectionedRVAdapter sectionedRVAdapter;
    private List<String> bannerUrlList = new ArrayList<>();

    private List<RecyclerViewList> recyclerViewLists = new ArrayList<>();

    private List<ColumnList> columnLists = new ArrayList<>();

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_bottom_tab);
    }

    @Override
    protected void bindViews() {
        initTitle("SectionedRV的使用");
        refreshLayout = get(R.id.refreshLayout);
        recyclerView = get(R.id.recyclerView);
        getData();
        sectionedRVAdapter = new SectionedRVAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(sectionedRVAdapter);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {


        initDataToView();
    }

    private void initDataToView() {
        sectionedRVAdapter.addSection(new SectionBanner(R.layout.include_recyclerview_header_layout, R.layout.layout_empty, bannerUrlList));

        sectionedRVAdapter.addSection(new SectionColumnList(R.layout.layout_item_section_head, R.layout.layout_item_special_body, columnLists));

        sectionedRVAdapter.addSection(new SectionMessageList(R.layout.layout_item_section_head, R.layout.layout_item_section_footer, R.layout.include_simple_item_view_layout, recyclerViewLists));

        sectionedRVAdapter.notifyDataSetChanged();
    }

    private void getData() {
        if (bannerUrlList.size() > 0) bannerUrlList.clear();
        if (columnLists.size() > 0) columnLists.clear();
        if (recyclerViewLists.size() > 0) recyclerViewLists.clear();

        bannerUrlList = DateImageUtils.imageData(5);


        columnLists.add(new ColumnList("重难点全面剖析", "李俊成", "化学大咖", "十年生死两茫茫，不思量，自难忘，千里孤坟，无处话凄凉", DateImageUtils.getImageUrl()));
        columnLists.add(new ColumnList("精英百题训练", "周小川", "圈粉人气王", "怀旧，不是因为那个时代多么好，而是那个时候，你年轻", DateImageUtils.getImageUrl()));
        columnLists.add(new ColumnList("中考前必看致胜锦囊", "黄家豪", "中考数学名师", "一举一动，都是承诺，会被另一个人看在眼里，记在心上的", DateImageUtils.getImageUrl()));

        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "一举一动，都是承诺，会被另一个人看在眼里，记在心上的", "2019-05-14"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "当时年少春衫薄,骑马倚斜桥,满楼红袖招", "2018-12-16"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "愿漂泊的人都有酒喝，愿孤独的人都能放歌", "2019-03-24"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "怀旧，不是因为那个时代多么好，而是那个时候，你年轻。", "2018-11-16"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "最好的人：像孩子一样，真诚。像夕阳一样，温暖。像天空一样，宁静。", "2019-01-12"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "我在半山腰等你，我在河中央爱你，你却在尘埃里", "2019-04-17"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "成长是一种蜕变，失去了旧的，必然因为又来了新的，这就是公平。", "2019-03-16"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "从来没有人读书，只有人在书中读自己，发现自己或检查自己。", "2019-03-23"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "你脚踩的地狱只是天堂的倒影,我唇角的故事也是时间的灰烬", "2019-02-27"));
        recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "十年生死两茫茫，不思量，自难忘，千里孤坟，无处话凄凉", "2019-05-07"));

    }


    @Override
    protected void setListener() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "成长是一种蜕变，失去了旧的，必然因为又来了新的，这就是公平。", "2019-03-16"));
                recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "从来没有人读书，只有人在书中读自己，发现自己或检查自己。", "2019-03-23"));
                recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "你脚踩的地狱只是天堂的倒影,我唇角的故事也是时间的灰烬", "2019-02-27"));
                recyclerViewLists.add(new RecyclerViewList(DateImageUtils.getImageUrl(), "十年生死两茫茫，不思量，自难忘，千里孤坟，无处话凄凉", "2019-05-07"));
                sectionedRVAdapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });


    }
}
