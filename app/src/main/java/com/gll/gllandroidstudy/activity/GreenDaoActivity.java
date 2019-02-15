package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.gll.gllandroidstudy.GoodMessageDao;
import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.db.DBManager;
import com.gll.gllandroidstudy.db.GoodMessage;

import java.util.List;

public class GreenDaoActivity extends BaseActivity {

    private ListView goodList;
    private TextView tvCurrentNumber;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_green_dao);
    }

    @Override
    protected void bindViews() {
        initTitle("GreenDao的使用");
        get(R.id.tvAddNumber).setOnClickListener(this);
        get(R.id.tvReduceNumber).setOnClickListener(this);
        get(R.id.tvEditNumber).setOnClickListener(this);
        get(R.id.tvQueriesNumber).setOnClickListener(this);
        tvCurrentNumber = get(R.id.tvCurrentNumber);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        queryGoodNumber();

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvAddNumber:
                //增加
                GoodMessage goodMessage = new GoodMessage();
                goodMessage.setGoodName("农夫山泉");
                goodMessage.setGoodNumber(String.valueOf(1));
                DBManager.getInstance().getGoodMessageDao().insert(goodMessage);
                queryGoodNumber();
                break;

            case R.id.tvReduceNumber:
                //减少
                GoodMessage goodBean = DBManager.getInstance().getGoodMessageDao().queryBuilder().where(GoodMessageDao.Properties.Id.eq(9)).build().unique();
                if (goodBean != null) {
                    DBManager.getInstance().getGoodMessageDao().deleteByKey(goodBean.getId());
                }
//                DBManager.getInstance().getGoodMessageDao().deleteAll();
                queryGoodNumber();
                break;

            case R.id.tvEditNumber:
                //修改
                GoodMessage message = DBManager.getInstance().getGoodMessageDao().queryBuilder().where(GoodMessageDao.Properties.Id.eq(9)).build().unique();
                if (message != null) {
                    message.setGoodNumber(String.valueOf(2));
                    DBManager.getInstance().getGoodMessageDao().update(message);
                }
                queryGoodNumber();
                break;

            case R.id.tvQueriesNumber:
                //查询
                queryGoodNumber();
                break;

        }
    }

    /**
     * 查询数量
     */
    private void queryGoodNumber() {
        List<GoodMessage> goodMessageList = DBManager.getInstance().getGoodMessageDao().queryBuilder().build().list();
        tvCurrentNumber.setText("当前数量：" + goodMessageList.size());
        Log.d("gll", "goodMessageList=" + goodMessageList.size() + "\n" + goodMessageList.toString());
    }


}
