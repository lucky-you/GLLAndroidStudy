package com.gll.gllandroidstudy.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;

import java.util.TimerTask;

/**
 * author      : Z_B
 * date       : 2018/10/18
 * function  :
 */
public class TimeTaskScroll extends TimerTask {
    private ListView listView;

    public TimeTaskScroll(Context context, ListView listView) {
        this.listView = listView;
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //  控制速度
            listView.smoothScrollBy(5, 0);
            super.handleMessage(msg);
        }
    };

    @Override
    public void run() {
        Message msg = handler.obtainMessage();
        handler.sendMessage(msg);
    }

}
