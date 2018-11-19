package com.gll.gllandroidstudy.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.BarUtils;
import com.gll.gllandroidstudy.utils.StringUtils;

/**
 * SpannableString的使用
 */
public class SpannableStringActivity extends BaseActivity {

    private TextView tvTextOne, tvTextTwo, tvTextThree, tvTextFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_spannable_string);
    }

    @Override
    protected void bindViews() {
        initTitle("SpannableString的使用");

        tvTextOne = get(R.id.tv_text_one);
        tvTextTwo = get(R.id.tv_text_Two);
        tvTextThree = get(R.id.tv_text_Three);
        tvTextFour = get(R.id.tv_text_Four);
        LinearLayout llRootLayout = get(R.id.ll_root_layout);
        BarUtils.addMarginTopEqualStatusBarHeight(llRootLayout);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        SpannableString ss1 = new SpannableString("设置背景颜色");
        ss1.setSpan(new BackgroundColorSpan(Color.parseColor("#FFD700")), 0,
                ss1.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        tvTextOne.setText(ss1);

        SpannableString textStringOne = StringUtils.getColorText("改变字体的颜色", mContext.getResources().getColor(R.color.color_a462ff));

        tvTextOne.setText(textStringOne);

        SpannableString ss7 = new SpannableString("下划线");
        ss7.setSpan(new UnderlineSpan(), 0, ss7.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tvTextTwo.setText(ss7);

        SpannableString textStringTwo=   StringUtils.getBigNumber("字体是不是会变大啊");
        tvTextTwo.setText(textStringTwo);



        SpannableString ss3 = new SpannableString("设置文本颜色");
        ss3.setSpan(new ForegroundColorSpan(Color.parseColor("#FF3030")), 3,
                ss3.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tvTextThree.setText(ss3);

        SpannableString textStringThree=    StringUtils.getTheCpecifiedTextColor("开通会员立即享受八折优惠",2,5,mContext.getResources().getColor(R.color.color_a462ff));

        tvTextThree.setText(textStringThree);


        SpannableString ss6 = new SpannableString("删除线");
        ss6.setSpan(new StrikethroughSpan(), 0, ss6.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvTextFour.setText(ss6);

    }

    @Override
    protected void setListener() {

    }
}
