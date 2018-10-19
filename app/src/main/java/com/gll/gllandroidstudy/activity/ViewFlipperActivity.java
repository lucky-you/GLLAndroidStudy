package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.MarqueeAdapter;
import com.gll.gllandroidstudy.adapter.MembershipListAdapter;
import com.gll.gllandroidstudy.adapter.NoticeRecyclerViewAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.model.NoticeMessage;
import com.gll.gllandroidstudy.view.AutoScrollLayoutManager;
import com.gll.gllandroidstudy.view.AutoScrollRecyclerView;
import com.gll.gllandroidstudy.view.MarqueeView;
import com.gll.gllandroidstudy.view.MemberTitleView;
import com.gll.gllandroidstudy.view.UPMarqueeView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ViewFlipperActivity extends BaseActivity {


    private MarqueeView marqueeView;
    private UPMarqueeView upMarqueeView;

    private MembershipListAdapter membershipListAdapter;

    private AutoScrollRecyclerView noticeRecyclerView;
    private NoticeRecyclerViewAdapter noticeRecyclerViewAdapter;
    private Disposable mAutoTask;

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


        noticeRecyclerViewAdapter = new NoticeRecyclerViewAdapter(noticeMessageList);
        AutoScrollLayoutManager autoScrollLayoutManager = new AutoScrollLayoutManager(mContext);
        noticeRecyclerView.setLayoutManager(autoScrollLayoutManager);
        noticeRecyclerView.setAdapter(noticeRecyclerViewAdapter);
//        noticeRecyclerView.start();

        AutoStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAuto();
    }

    private void AutoStart() {
        if (mAutoTask != null && (mAutoTask.isDisposed() == true)) {
            mAutoTask.dispose();
        }
        mAutoTask = Observable.interval(1, 2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        noticeRecyclerView.smoothScrollToPosition((int) (4 + aLong));
                    }
                });
//        noticeRecyclerView.start();
    }

    private void stopAuto() {
        if (mAutoTask != null && (mAutoTask.isDisposed() == true)) {
            mAutoTask.dispose();
            mAutoTask = null;
        }
        noticeRecyclerView.stop();

    }


    @Override
    protected void setListener() {
    }
}
