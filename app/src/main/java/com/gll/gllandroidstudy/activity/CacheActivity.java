package com.gll.gllandroidstudy.activity;

import android.os.Bundle;
import android.widget.Button;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.guidview.GuideCaseQueue;
import com.gll.gllandroidstudy.guidview.GuideCaseView;
import com.gll.gllandroidstudy.guidview.OnCompleteListener;

/**
 * Created by: Z_B on 2018/8/12.
 * Function: 引导页面的使用
 */
public class CacheActivity extends BaseActivity {

    Button step1, step2, step3, step4, changePicture;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_cache);
    }

    @Override
    protected void bindViews() {
        initTitle("GuideCaseView的使用");
        step1 = get(R.id.step1);
        step2 = get(R.id.step2);
        step3 = get(R.id.step3);
        step4 = get(R.id.step4);
        changePicture = get(R.id.changePicture);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        showTextGuideView();
    }

    private void showTextGuideView() {
        final GuideCaseView guideStep1 = new GuideCaseView.Builder(this)
                .title("请注意，这是第一步")
                .focusOn(step1)
                .fitWindowsAuto()
                .build();

        final GuideCaseView guideStep2 = new GuideCaseView.Builder(this)
                .title("请注意，这是第二步")
                .focusOn(step2)
                .fitWindowsAuto()
                .build();

        final GuideCaseView guideStep3 = new GuideCaseView.Builder(this)
                .title("请注意，这是第三步")
                .focusOn(step3)
                .fitWindowsAuto()
                .build();

        final GuideCaseView guideStep4 = new GuideCaseView.Builder(this)
                .title("请注意，这是第四步")
                .focusOn(step4)
                .fitWindowsAuto()
                .build();

        new GuideCaseQueue()
                .add(guideStep1)
                .add(guideStep2)
                .add(guideStep3)
                .add(guideStep4)
                .show();
    }

    private void showPictureGuideView() {
        final GuideCaseView guideStep1 = new GuideCaseView.Builder(this)
                .picture(R.drawable.img_guidecaseview_1)
                .focusOn(step1)
                .fitWindowsAuto()
                .build();

        final GuideCaseView guideStep2 = new GuideCaseView.Builder(this)
                .picture(R.drawable.img_guidecaseview_2)
                .focusOn(step2)
                .fitWindowsAuto()
                .build();

        final GuideCaseView guideStep3 = new GuideCaseView.Builder(this)
                .picture(R.drawable.img_guidecaseview_3)
                .focusOn(step3)
                .fitWindowsAuto()
                .build();

        final GuideCaseView guideStep4 = new GuideCaseView.Builder(this)
                .picture(R.drawable.img_guidecaseview_4)
                .focusOn(step4)
                .fitWindowsAuto()
                .build();

        new GuideCaseQueue()
                .add(guideStep1)
                .add(guideStep2)
                .add(guideStep3)
                .add(guideStep4)
                .show();
    }

    @Override
    protected void setListener() {
        changePicture.setOnClickListener(v -> showPictureGuideView());
    }

}
