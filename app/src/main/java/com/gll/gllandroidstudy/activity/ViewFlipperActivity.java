package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

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
        noticeRecyclerView = get(R.id.noticeRecyclerView);

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<NoticeMessage> noticeMessageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            noticeMessageList.add(new NoticeMessage("会员120" + i, "编号:4877" + i));
        }

        noticeRecyclerViewAdapter = new NoticeRecyclerViewAdapter(noticeMessageList);
        AutoScrollLayoutManager autoScrollLayoutManager = new AutoScrollLayoutManager(mContext);
        noticeRecyclerView.setLayoutManager(autoScrollLayoutManager);
        noticeRecyclerView.setAdapter(noticeRecyclerViewAdapter);

        AutoStart();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopAuto();
    }

    private void AutoStart() {
        if (mAutoTask != null && (!mAutoTask.isDisposed())) {
            mAutoTask.dispose();
        }
        mAutoTask = Observable.interval(1, 2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        noticeRecyclerView.smoothScrollToPosition( (5 + aLong.intValue()));
                    }
                });
    }

    private void stopAuto() {
        if (mAutoTask != null && (!mAutoTask.isDisposed())) {
            mAutoTask.dispose();
            mAutoTask = null;
        }
        noticeRecyclerView.stop();

    }


    @Override
    protected void setListener() {
    }
}
