package com.gll.gllandroidstudy.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.databinding.ActivityCacheBinding;

/**
 * Created by: Z_B on 2018/8/12.
 * Function:
 */
public class CacheActivity extends BaseActivity {

    ActivityCacheBinding binding;

    @Override
    protected void loadViewLayout() {
//        setContentView(R.layout.activity_cache);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cache);
        binding.cacheRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));



    }

    public class Presenter {
        public void onClickAddItem(View view) {
        }

        public void onClickRemoveItem(View view) {
        }


    }

    @Override
    protected void bindViews() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
