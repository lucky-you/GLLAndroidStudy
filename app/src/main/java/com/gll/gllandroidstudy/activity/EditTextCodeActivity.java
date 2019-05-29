package com.gll.gllandroidstudy.activity;

import android.os.Bundle;

import com.gll.gllandroidstudy.R;
import com.gll.gllandroidstudy.base.BaseActivity;
import com.gll.gllandroidstudy.utils.CommonUtil;
import com.gll.gllandroidstudy.view.VerificationCodeView;

public class EditTextCodeActivity extends BaseActivity {

    private VerificationCodeView verCodeVIew;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_edit_text_code);
    }

    @Override
    protected void bindViews() {
        initTitle("自定义验证码输入框");
        verCodeVIew = get(R.id.verCodeView);
        verCodeVIew.setmEtWidth(CommonUtil.dip2px(mContext, 34));
        verCodeVIew.setOnCodeFinishListener(content -> showToast(content));
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    protected void setListener() {

    }
}
