package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.MarqueeAdapter;
import com.gll.gllandroidstudy.adapter.MembershipListAdapter;
import com.gll.gllandroidstudy.adapter.NoticeRecyclerViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.NoticeMessage;
import com.gll.gllandroidstudy.view.AutoScrollLayoutManager;
import com.gll.gllandroidstudy.view.MarqueeView;
import com.gll.gllandroidstudy.view.MemberTitleView;
import com.gll.gllandroidstudy.view.UPMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class ViewFlipperActivity extends BaseActivity {


    private MarqueeView marqueeView;
    private UPMarqueeView upMarqueeView;

    private MembershipListAdapter membershipListAdapter;
    private RecyclerView noticeRecyclerView;
    private NoticeRecyclerViewAdapter noticeRecyclerViewAdapter;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_tab_layout);
    }

    @Override
    protected void bindViews() {
        initTitle("ViewFlipper");
        marqueeView = get(R.id.marqueeView);
        upMarqueeView = get(R.id.uPMarqueeView);
        noticeRecyclerView = get(R.id.noticeRecyclerView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<NoticeMessage> noticeMessageList = new ArrayList<>();
        noticeMessageList.add(new NoticeMessage("会员0", "编号:48770"));
        noticeMessageList.add(new NoticeMessage("会员1", "编号:48771"));
        noticeMessageList.add(new NoticeMessage("会员2", "编号:48772"));
        noticeMessageList.add(new NoticeMessage("会员3", "编号:48773"));
        noticeMessageList.add(new NoticeMessage("会员4", "编号:48774"));
        noticeMessageList.add(new NoticeMessage("会员5", "编号:48775"));
        noticeMessageList.add(new NoticeMessage("会员6", "编号:48776"));
        noticeMessageList.add(new NoticeMessage("会员7", "编号:48777"));
        noticeMessageList.add(new NoticeMessage("会员8", "编号:48778"));
        noticeMessageList.add(new NoticeMessage("会员9", "编号:48779"));

        MarqueeAdapter marqueeAdapter = new MarqueeAdapter();
        marqueeAdapter.setData(noticeMessageList, 5);
        marqueeView.setAdapter(marqueeAdapter);
        membershipListAdapter = new MembershipListAdapter(noticeMessageList, R.layout.include_view_flipper_view);

        List<MemberTitleView> viewList = new ArrayList<>();
        for (int i = 0; i < noticeMessageList.size(); i++) {
            MemberTitleView memberTitleView = new MemberTitleView(mContext);
            memberTitleView.setMemberDate(noticeMessageList.get(i));
            viewList.add(memberTitleView);
        }
        upMarqueeView.setViews(viewList);


        noticeRecyclerViewAdapter = new NoticeRecyclerViewAdapter(mContext, noticeMessageList);
        AutoScrollLayoutManager autoScrollLayoutManager = new AutoScrollLayoutManager(mContext);
        noticeRecyclerView.setLayoutManager(autoScrollLayoutManager);
        noticeRecyclerView.setAdapter(noticeRecyclerViewAdapter);

    }



    @Override
    protected void setListener() {
        noticeRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    // 如果自动滑动到最后一个位置，则此处状态为SCROLL_STATE_IDLE
                    AutoScrollLayoutManager lm = (AutoScrollLayoutManager) recyclerView
                            .getLayoutManager();
                    int position = lm.findLastCompletelyVisibleItemPosition();
                    int count = lm.getItemCount();
                    if(position == count-1){
                        lm.scrollToPosition(0);
                        recyclerView.smoothScrollToPosition(noticeRecyclerViewAdapter.getItemCount());
                    }
                }

            }
        });
    }
}
