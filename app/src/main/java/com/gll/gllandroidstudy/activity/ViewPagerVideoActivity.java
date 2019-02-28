package com.gll.gllandroidstudy.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.adapter.ViewPagerVideoAdapter;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.callback.OnViewPagerListener;
import com.gll.gllandroidstudy.view.ViewPagerLayoutManager;

public class ViewPagerVideoActivity extends BaseActivity implements OnViewPagerListener {
    private static final String TAG = "gll";
    private RecyclerView VideoRecyclerView;
    private ViewPagerLayoutManager mLayoutManager;
    private ViewPagerVideoAdapter viewPagerVideoAdapter;
    private int selectPosition;//记录下选中的位置

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_view_pager_video);
    }

    @Override
    protected void bindViews() {
        VideoRecyclerView = get(R.id.VideoRecyclerView);
        mLayoutManager = new ViewPagerLayoutManager(this, OrientationHelper.VERTICAL);
        mLayoutManager.setOnViewPagerListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        int[] videoList = {R.raw.video_1, R.raw.video_2, R.raw.video_3, R.raw.video_4,
                R.raw.video_5, R.raw.video_6, R.raw.video_7, R.raw.video_8};

        viewPagerVideoAdapter = new ViewPagerVideoAdapter(mContext, videoList);
        VideoRecyclerView.setLayoutManager(mLayoutManager);
        VideoRecyclerView.setAdapter(viewPagerVideoAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onInitComplete() {
        Log.e(TAG, "onInitComplete");
        playVideo(0);
    }

    @Override
    public void onPageRelease(boolean isNext, int position) {
        Log.e(TAG, "释放位置:" + position + " 下一页:" + isNext);
        int index = 0;
        if (isNext) {
            index = 0;
        } else {
            index = 1;
        }
        releaseVideo(index);
    }

    @Override
    public void onPageSelected(int position, boolean isBottom) {
        Log.e(TAG, "选中位置:" + position + "  是否是滑动到底部:" + isBottom);
        selectPosition = position;
        playVideo(0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("gll", "onResume:");
//        playVideo(selectPosition);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("gll", "onPause:videoIsPlaying=" + videoView.isPlaying());
        videoView.pause();
    }

    private VideoView videoView;
    private ImageView imgPlay;
    private ImageView imgThumb;

    private void playVideo(int position) {
        View itemView = VideoRecyclerView.getChildAt(0);
        videoView = itemView.findViewById(R.id.video_view);
        imgPlay = itemView.findViewById(R.id.img_play);
        imgThumb = itemView.findViewById(R.id.img_thumb);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        videoView.start();
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                mediaPlayer[0] = mp;
                mp.setLooping(true);
                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.setBackgroundColor(0xff000000);
            }
        });

        imgPlay.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = true;

            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    imgPlay.animate().alpha(1f).start();
                    videoView.pause();
                    isPlaying = false;
                } else {
                    imgPlay.animate().alpha(0f).start();
                    videoView.start();
                    isPlaying = true;
                }
            }
        });
    }

    private void releaseVideo(int index) {
        VideoRecyclerView.getChildCount();
        View itemView = VideoRecyclerView.getChildAt(index);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        videoView.stopPlayback();
        imgThumb.animate().alpha(1).start();
        imgPlay.animate().alpha(0f).start();
    }
}
